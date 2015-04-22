/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trm5313
 */
public class Customer extends Person {
    private int customerIDnumber;
    private int pinNum;

    public Customer(String SocialSecurity, String Fname, String Lname, String Address, String City, String State, String Zipcode, int Phone, String Email) {
        super(SocialSecurity, Fname, Lname, Address, City, State, Zipcode, Phone, Email);
    }

    public Customer(String SocialSecurity, String Fname, String Lname, String Address, String City, String State, String Zipcode, String Email) {
        super(SocialSecurity, Fname, Lname, Address, City, State, Zipcode, Email);
    }

    public Customer() {
        
    }

    
    
    public int getCustomerIDnumber() {
        return customerIDnumber;
    }

    public void setCustomerIDnumber(int customerIDnumber) {
        this.customerIDnumber = customerIDnumber;
    }

    public int getPinNum() {
        return pinNum;
    }

    public void setPinNum(int pinNum) {
        this.pinNum = pinNum;
    }
    
}
