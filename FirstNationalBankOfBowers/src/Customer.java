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
