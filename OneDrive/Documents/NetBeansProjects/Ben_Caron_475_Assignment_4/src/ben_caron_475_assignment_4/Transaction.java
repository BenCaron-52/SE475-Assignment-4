
package ben_caron_475_assignment_4;
import java.util.*;

public class Transaction {
    //attributes
    private int transactionId;
    private String transactionType;
    private final Account account;
    
    //constructor
    public Transaction(Account account) {
        this.account = account;
        setTransactionId(account);
    }
    //destructor <-----------------------------------------------------------------------------
        //called upon confirming transaction?
    
    //getters
    public int getTransactionId() {
        return transactionId;
    }
    public String getTransactionType() {
        return transactionType;
    }
    
    //setters
    public void setTransactionId(Account account) {
        Calendar c = Calendar.getInstance();
        transactionId = Integer.parseInt("" + account.getAccountNumber() 
                + c.get(Calendar.HOUR) 
                + c.get(Calendar.MINUTE) 
                + c.get(Calendar.SECOND)
                + c.get(Calendar.AM_PM));
    }
    public void setTransactionType(String type) {
        transactionType = type;
    }
    
    //methods
    public void deposit(float amount) {
        account.setBalance(account.getBalance() + amount);
    }
    public void withdraw(float amount) {
        account.setBalance(account.getBalance() - amount);
    }
    public float checkBalance() {
        return account.getBalance();
    }
}
