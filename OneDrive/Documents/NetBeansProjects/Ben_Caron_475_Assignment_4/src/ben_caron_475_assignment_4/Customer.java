
package ben_caron_475_assignment_4;

public class Customer {
    //attributes
    private int customerId;
    private String customerName;
    private String address;
    private String phoneNumber;
    
    //constructor
    public Customer(String cName, String a, String pNum) {
        setCustomerId((int)(Math.random() * 1000 + 1));
        setCustomerName(cName);
        setAddress(a);
        setPhoneNumber(pNum);
    }
    
    //getters
    public int getCustomerId() {
        return customerId;
    } 
    public String getCustomerName() {
        return customerName;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    //setters
    public void setCustomerId(int id) {
        customerId = id;
    }
    public void setCustomerName(String name) {
        customerName = name;
    }
    public void setAddress(String a) {
        address = a;
    }
    public void setPhoneNumber(String number) {
        phoneNumber = number;
    }
}
