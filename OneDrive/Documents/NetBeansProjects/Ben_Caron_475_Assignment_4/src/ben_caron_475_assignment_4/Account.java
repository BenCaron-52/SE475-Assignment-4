
package ben_caron_475_assignment_4;

public class Account {
    //attributes
    private int accountNumber;
    private float balance;
    private final Customer c;
    
    //constructor
    public Account(float initialBalance, Customer customer) {
        this.c = customer;
        setAccountNumber((int)(Math.random() * 1000 + 1));
        setBalance(initialBalance);
    }
    
    //getters
    public int getAccountNumber() {
        return accountNumber;
    }
    public float getBalance() {
        return balance;
    }
    
    //setters
    public void setAccountNumber(int accountNum) {
        accountNumber = accountNum;
    }
    public void setBalance(float b) {
        balance = b;
    }
}
