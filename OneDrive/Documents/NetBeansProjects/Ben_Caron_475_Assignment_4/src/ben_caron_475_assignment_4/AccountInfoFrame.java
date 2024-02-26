
package ben_caron_475_assignment_4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountInfoFrame extends JFrame implements ActionListener {
    
    //components
    private Container c;
    private JLabel title;
    private JLabel name;
    private JLabel customerId;
    private JLabel address;
    private JLabel phoneNumber;
    private JLabel accountNumber;
    private JLabel balance;
    private JButton transact;
    
    //constructor
    public AccountInfoFrame(Customer customer, Account account) {
        setTitle("Account Info");
        setBounds(300, 90, 900, 600);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Account Info");
        title.setSize(100, 20);
        title.setLocation(400, 20);
        c.add(title);
        
        name = new JLabel("Name: " + customer.getCustomerName());
        name.setSize(400, 20);
        name.setLocation(350, 60);
        c.add(name);
        
        customerId = new JLabel("Customer ID: " + customer.getCustomerId());
        customerId.setSize(400, 20);
        customerId.setLocation(350, 90);
        c.add(customerId);
        
        address = new JLabel("Customer Address: " + customer.getAddress());
        address.setSize(400, 20);
        address.setLocation(350, 120);
        c.add(address);
        
        phoneNumber = new JLabel("Phone Number: " + customer.getPhoneNumber());
        phoneNumber.setSize(400, 20);
        phoneNumber.setLocation(350, 150);
        c.add(phoneNumber);
        
        accountNumber = new JLabel("Account Number: " + account.getAccountNumber());
        accountNumber.setSize(400, 20);
        accountNumber.setLocation(350, 180);
        c.add(accountNumber);
        
        balance = new JLabel("Account Balance: $" + account.getBalance());
        balance.setSize(400, 20);
        balance.setLocation(350, 210);
        c.add(balance);
        
        transact = new JButton("Begin Transaction");
        transact.setSize(200, 30);
        transact.setLocation(350, 240);
        transact.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == transact){
                    //create Transaction object and go to TransactionFrame
                    Transaction accountTransaction = new Transaction(account);
                    TransactionFrame newTransaction = new TransactionFrame(accountTransaction, customer, account);
                    
                    //close frame
                    setVisible(false);
                    dispose();
                }
            }
        });
        c.add(transact);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
