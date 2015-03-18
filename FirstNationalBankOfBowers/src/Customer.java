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
    private int customerIDNumber;
    private int pinNum;

    public int getCustomerIDNumber() {
        return customerIDNumber;
    }

    public void setCustomerIDNumber(int customerIDNumber) {
        this.customerIDNumber = customerIDNumber;
    }

    public int getPinNum() {
        return pinNum;
    }

    public void setPinNum(int pinNum) {
        this.pinNum = pinNum;
    }
    
}
