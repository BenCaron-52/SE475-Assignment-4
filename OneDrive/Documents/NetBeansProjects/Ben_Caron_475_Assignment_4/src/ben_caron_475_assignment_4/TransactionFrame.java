
package ben_caron_475_assignment_4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionFrame extends JFrame implements ActionListener {
    
    //components
    private Container c;
    private JLabel title;
    private JLabel balance;
    private JLabel transactionId;
    private JLabel select;
    private JRadioButton deposit;
    private JRadioButton withdraw;
    private ButtonGroup transactionOptions;
    private JLabel amount;
    private JTextField tAmount;
    private JButton submit;
    
    //constructor
    public TransactionFrame(Transaction transaction, Customer customer, Account account) {
        setTitle("Transaction");
        setBounds(300, 90, 900, 600);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Transaction");
        title.setSize(100, 20);
        title.setLocation(400, 20);
        c.add(title);
        
        balance = new JLabel("Account Balance: $" + account.getBalance());
        balance.setSize(200, 20);
        balance.setLocation(300, 60);
        c.add(balance);
        
        transactionId = new JLabel("Transaction ID: " + transaction.getTransactionId());
        transactionId.setSize(400, 20);
        transactionId.setLocation(300, 90);
        c.add(transactionId);
        
        select = new JLabel("Select Operation: ");
        select.setSize(100, 20);
        select.setLocation(300, 120);
        c.add(select);
        
        deposit = new JRadioButton("Deposit");
        deposit.setSize(150, 20);
        deposit.setLocation(450, 120);
        c.add(deposit);
        
        withdraw = new JRadioButton("Withdraw");
        withdraw.setSize(150, 20);
        withdraw.setLocation(450, 150);
        c.add(withdraw);
        
        transactionOptions = new ButtonGroup();
        transactionOptions.add(deposit);
        transactionOptions.add(withdraw);
        
        amount = new JLabel("Enter Amount: $");
        amount.setSize(150, 20);
        amount.setLocation(300, 180);
        c.add(amount);
        
        tAmount = new JTextField();
        tAmount.setSize(100, 20);
        tAmount.setLocation(450, 180);
        c.add(tAmount);
        
        submit = new JButton("Submit");
        submit.setSize(100, 30);
        submit.setLocation(450, 210);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == submit){
                    if(deposit.isSelected() == true) {
                        transaction.deposit(Float.parseFloat(tAmount.getText()));
                    }
                    else if (withdraw.isSelected() == true) {
                        transaction.withdraw(Float.parseFloat(tAmount.getText()));
                    }
                    
                    AccountInfoFrame infoFrame = new AccountInfoFrame(customer, account);
                    
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
