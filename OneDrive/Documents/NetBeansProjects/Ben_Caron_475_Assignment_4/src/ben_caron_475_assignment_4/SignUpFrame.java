
package ben_caron_475_assignment_4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpFrame extends JFrame implements ActionListener {
    
    //components
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tName;
    private JLabel address;
    private JTextField tAddress;
    private JLabel phoneNumber;
    private JTextField tPhoneNumber;
    private JButton submit;
    
    //constructor
    public SignUpFrame() {
        setTitle("Sign Up");
        setBounds(300, 90, 900, 600);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Sign Up");
        title.setSize(100, 20);
        title.setLocation(400, 20);
        c.add(title);
        
        name = new JLabel("Name");
        name.setSize(100, 20);
        name.setLocation(350, 60);
        c.add(name);
        
        tName = new JTextField();
        tName.setSize(300, 20);
        tName.setLocation(450, 60);
        c.add(tName);
        
        address = new JLabel("Address");
        address.setSize(100, 20);
        address.setLocation(350, 90);
        c.add(address);
        
        tAddress = new JTextField();
        tAddress.setSize(300, 20);
        tAddress.setLocation(450, 90);
        c.add(tAddress);
        
        phoneNumber = new JLabel("Phone Number");
        phoneNumber.setSize(100, 20);
        phoneNumber.setLocation(350, 120);
        c.add(phoneNumber);
        
        tPhoneNumber = new JTextField();
        tPhoneNumber.setSize(300, 20);
        tPhoneNumber.setLocation(450, 120);
        c.add(tPhoneNumber);
        
        submit = new JButton("Submit");
        submit.setSize(100, 30);
        submit.setLocation(400, 160);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (e.getSource() == submit){
                    //create Customer object and go to AccountInfoFrame
                    Customer bankCustomer = new Customer(tName.getText(), tAddress.getText(), tPhoneNumber.getText());
                    Account customerAccount = new Account(0, bankCustomer);
                    AccountInfoFrame createAccount = new AccountInfoFrame(bankCustomer, customerAccount);
                    
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
