/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
/**
 *
 * @author krm5188
 */
public class Account {
    
    public double balance = 0;
    public static int MINBALANCE = 100;
    public double interestRate = 0;
    public String accountNumber;
    
    public void deposit(double depositAmount){
        balance += depositAmount;
    }
    
    public void withdraw(double withdrawAmount){
        balance -= withdrawAmount;
    }
    
    public double getBalance(){
        return balance;
    }
    
}
