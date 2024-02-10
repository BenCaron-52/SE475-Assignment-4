package ben_caron_assignment_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

interface account {
    void deposit(float dollars);
}

abstract class BankAccount implements account{
    private String owner = new String();
    private float balance;

    public float getBalance() {
        return balance;
    }
    public void setBalance(float dollars) {
        this.balance = dollars;
    }
    public String getOwner(){
        return owner;
    }
    public void deposit(float dollars){
        setBalance(this.balance + dollars);
    }
    void withdrawal(float dollars){}
    
    public BankAccount(String name){
        this.owner = name;
    }
}

class CheckingAccount extends BankAccount{
    private float insufficientFundsFee;
    
    public float getFee(){
        return insufficientFundsFee;
    }
    public void setFee(float fee){
        this.insufficientFundsFee = fee;
    }
    public void processCheck(/*checkToProcess check*/){
        System.out.println("Check successfully processed");
    }
    public void withdrawal(float dollars){
        deposit(-dollars);
    }
    
    public CheckingAccount(String name, float fee){
        super(name);
        this.insufficientFundsFee = fee;
    }
    
    @Override
    public String toString() {
        return "Account Owner: " + this.getOwner() + "\n" + "Account Balance: " + this.getBalance() + "\n" + "Insufficient Funds Fee: " + this.getFee();
    }
}

class SavingsAccount extends BankAccount{
    private float annualInterestRate; //represented as a percentage, not a deciaml
    
    public float getAIR(){
        return annualInterestRate;
    }
    public void setAIR(float rate){
        this.annualInterestRate = rate;
    }
    public void depositMonthlyInterest(){
        deposit(annualInterestRate / 12);
    }
    public void withdrawal(float dollars){
        deposit(-dollars);
    }
    
    public SavingsAccount(String name, float rate){
        super(name);
        this.annualInterestRate = rate;
    }
}

// ---------- Frame Classes ---------- //
class CreateAccountFrame extends JFrame implements ActionListener{
    // Components
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tName;
    private JLabel accountType;
    private JRadioButton savings;
    private JRadioButton checking;
    private ButtonGroup accountTypeGroup;
    private JLabel iFF;
    private JTextField tIFF;
    private JLabel aIR;
    private JTextField tAIR;
    private JButton submit;
    
    public CreateAccountFrame(){
        setTitle("Create Account");
        setBounds(300, 90, 900, 600);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Create Account");
        title.setSize(100, 20);
        title.setLocation(400, 20);
        c.add(title);
        
        name = new JLabel("Name");
        name.setSize(100, 20);
        name.setLocation(350, 60);
        c.add(name);
        
        tName = new JTextField();
        tName.setSize(200, 20);
        tName.setLocation(400, 60);
        c.add(tName);
        
        accountType = new JLabel("Account Type");
        accountType.setSize(100, 20);
        accountType.setLocation(300, 90);
        c.add(accountType);
        
        savings = new JRadioButton("Savings");
        savings.setSize(100, 20);
        savings.setLocation(400, 90);
        c.add(savings);
        
        checking = new JRadioButton("Checking");
        checking.setSize(100, 20);
        checking.setLocation(500, 90);
        c.add(checking);
        
        accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savings);
        accountTypeGroup.add(checking);
        
        iFF = new JLabel("Insufficient Funds Fee (if checking account)");
        iFF.setSize(250, 20);
        iFF.setLocation(200, 120);
        c.add(iFF);
        
        tIFF = new JTextField();
        tIFF.setSize(200, 20);
        tIFF.setLocation(475, 120);
        c.add(tIFF);
        
        aIR = new JLabel("Annual Interest Rate Percentage (if savings account)");
        aIR.setSize(300, 20);
        aIR.setLocation(150, 150);
        c.add(aIR);
        
        tAIR = new JTextField();
        tAIR.setSize(200, 20);
        tAIR.setLocation(475, 150);
        c.add(tAIR);
        
        submit = new JButton("Submit");
        submit.setSize(100, 30);
        submit.setLocation(400, 200);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == submit){
                    //create account object, store the user's data in it, and go to account info frame
                    if (savings.isSelected()){
                        SavingsAccount account = new SavingsAccount(tName.getText(), Float.parseFloat(tAIR.getText()));
                        AccountInfoFrame infoFrame = new AccountInfoFrame(account);
                    } 
                    else if (checking.isSelected()){
                        CheckingAccount account = new CheckingAccount(tName.getText(), Float.parseFloat(tIFF.getText()));
                        AccountInfoFrame infoFrame = new AccountInfoFrame(account);
                    }
                    
                    //close frame
                    setVisible(false);
                    dispose();
                }
            }
        });
        c.add(submit);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class AccountInfoFrame extends JFrame implements ActionListener{
    //Components
    private Container c;
    private JLabel title;
    private JLabel name;
    private JLabel balance;
    private JLabel accountType;
    private JLabel iFF;
    private JLabel aIR;
    private JButton manageAccount;
    
    public AccountInfoFrame(SavingsAccount account){
        setTitle("Account Info");
        setBounds(300, 90, 900, 600);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Account Info");
        title.setSize(100, 20);
        title.setLocation(400, 20);
        c.add(title);
        
        name = new JLabel("Name: " + account.getOwner());
        name.setSize(200, 20);
        name.setLocation(400, 60);
        c.add(name);
        
        balance = new JLabel("Balance: $" + account.getBalance());
        balance.setSize(200, 20);
        balance.setLocation(400, 90);
        c.add(balance);
        
        accountType = new JLabel("Account Type: Savings");
        accountType.setSize(200, 20);
        accountType.setLocation(400, 120);
        c.add(accountType);
        
        aIR = new JLabel("Annual Interest Rate: " + account.getAIR() + "%");
        aIR.setSize(200, 20);
        aIR.setLocation(400, 150);
        c.add(aIR);
        
        manageAccount = new JButton("Manage Account");
        manageAccount.setSize(200, 30);
        manageAccount.setLocation(400, 200);
        manageAccount.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == manageAccount){
                    ManageAccountFrame manageFrame = new ManageAccountFrame(account);
                    setVisible(false);
                    dispose();
                }
            }
        });
        c.add(manageAccount);
        
        setVisible(true);
    }
    
    public AccountInfoFrame(CheckingAccount account){
        setTitle("Account Info");
        setBounds(300, 90, 900, 600);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Account Info");
        title.setSize(100, 20);
        title.setLocation(400, 20);
        c.add(title);
        
        name = new JLabel("Name: " + account.getOwner());
        name.setSize(200, 20);
        name.setLocation(400, 60);
        c.add(name);
        
        balance = new JLabel("Balance: $" + account.getBalance());
        balance.setSize(200, 20);
        balance.setLocation(400, 90);
        c.add(balance);
        
        accountType = new JLabel("Account Type: Checking");
        accountType.setSize(200, 20);
        accountType.setLocation(400, 120);
        c.add(accountType);
        
        iFF = new JLabel("Insufficient Funds Fee: $" + account.getFee());
        iFF.setSize(200, 20);
        iFF.setLocation(400, 150);
        c.add(iFF);
        
        manageAccount = new JButton("Manage Account");
        manageAccount.setSize(200, 30);
        manageAccount.setLocation(400, 200);
        manageAccount.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == manageAccount){
                    ManageAccountFrame manageFrame = new ManageAccountFrame(account);
                    setVisible(false);
                    dispose();
                }
            }
        });
        c.add(manageAccount);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class ManageAccountFrame extends JFrame implements ActionListener{
    //Components
    private Container c;
    private JLabel title;
    private JLabel select;
    private JRadioButton deposit;
    private JRadioButton processCheck;
    private JRadioButton withdraw;
    private JRadioButton depositMonthlyInterest;
    private ButtonGroup checkingOptions;
    private ButtonGroup savingsOptions;
    private JLabel amount;
    private TextField tAmount;
    private JButton submit;
    
    public ManageAccountFrame(SavingsAccount account){
        setTitle("Manage Savings Account");
        setBounds(300, 90, 900, 600);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Manage Savings Account");
        title.setSize(100, 20);
        title.setLocation(400, 20);
        c.add(title);
        
        select = new JLabel("Select Operation: ");
        select.setSize(200, 20);
        select.setLocation(300, 60);
        c.add(select);
        
        deposit = new JRadioButton("Deposit");
        deposit.setSize(150, 20);
        deposit.setLocation(500, 60);
        c.add(deposit);
        
        depositMonthlyInterest = new JRadioButton("Deposit Monthly Interest");
        depositMonthlyInterest.setSize(150, 20);
        depositMonthlyInterest.setLocation(500, 90);
        c.add(depositMonthlyInterest);
        
        withdraw = new JRadioButton("Withdraw");
        withdraw.setSize(150, 20);
        withdraw.setLocation(500, 120);
        c.add(withdraw);
        
        savingsOptions = new ButtonGroup();
        savingsOptions.add(deposit);
        savingsOptions.add(depositMonthlyInterest);
        savingsOptions.add(withdraw);
        
        amount = new JLabel("Enter Amount: $");
        amount.setSize(150, 20);
        amount.setLocation(300, 150);
        c.add(amount);
        
        tAmount = new TextField();
        tAmount.setSize(200, 20);
        tAmount.setLocation(500, 150);
        c.add(tAmount);
        
        submit = new JButton();
        submit.setSize(200, 30);
        submit.setLocation(400, 190);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == submit){
                    if(deposit.isSelected() == true) {
                        account.deposit(Float.parseFloat(tAmount.getText()));
                    }
                    else if (depositMonthlyInterest.isSelected() == true) {
                        account.depositMonthlyInterest();
                    }
                    else if (withdraw.isSelected() == true) {
                        account.withdrawal(Float.parseFloat(tAmount.getText()));
                    }
                    
                    AccountInfoFrame infoFrame = new AccountInfoFrame(account);
                    
                    setVisible(false);
                    dispose();
                }
            }
        });
        c.add(submit);
        
        c.setVisible(true);
    }
    
    public ManageAccountFrame(CheckingAccount account){
        setTitle("Manage Savings Account");
        setBounds(300, 90, 900, 600);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Manage Checking Account");
        title.setSize(100, 20);
        title.setLocation(400, 20);
        c.add(title);
        
        select = new JLabel("Select Operation: ");
        select.setSize(200, 20);
        select.setLocation(300, 60);
        c.add(select);
        
        deposit = new JRadioButton("Deposit");
        deposit.setSize(150, 20);
        deposit.setLocation(500, 60);
        c.add(deposit);
        
        processCheck = new JRadioButton("Process Check");
        processCheck.setSize(150, 20);
        processCheck.setLocation(500, 90);
        c.add(processCheck);
        
        withdraw = new JRadioButton("Withdraw");
        withdraw.setSize(150, 20);
        withdraw.setLocation(500, 120);
        c.add(withdraw);
        
        savingsOptions = new ButtonGroup();
        savingsOptions.add(deposit);
        savingsOptions.add(processCheck);
        savingsOptions.add(withdraw);
        
        amount = new JLabel("Enter Amount: $");
        amount.setSize(150, 20);
        amount.setLocation(300, 150);
        c.add(amount);
        
        tAmount = new TextField();
        tAmount.setSize(200, 20);
        tAmount.setLocation(500, 150);
        c.add(tAmount);
        
        submit = new JButton();
        submit.setSize(200, 30);
        submit.setLocation(400, 190);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == submit){
                    if(deposit.isSelected() == true) {
                        account.deposit(Float.parseFloat(tAmount.getText()));
                    }
                    else if (processCheck.isSelected() == true) {
                        account.processCheck();
                    }
                    else if (withdraw.isSelected() == true) {
                        account.withdrawal(Float.parseFloat(tAmount.getText()));
                    }
                    
                    AccountInfoFrame infoFrame = new AccountInfoFrame(account);
                    
                    setVisible(false);
                    dispose();
                }
            }
        });
        c.add(submit);
        
        c.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

public class Ben_Caron_Assignment_2 {

    public static void main(String[] args) {
        CreateAccountFrame frame = new CreateAccountFrame();
    }
    
}
