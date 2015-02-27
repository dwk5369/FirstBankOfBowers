/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krm5188
 */
public class SavingsAccount {
    
    private double balance = 0;
    private static int MINBALANCE = 100;
    private double interestRate = 0;
    private String accountNumber;
    
    public SavingsAccount(String acc){
        accountNumber = acc;
    }
    
    public SavingsAccount(double bal, String acc){
        accountNumber = acc;
        if(bal >= 100){
            balance = bal;
        }
        else{
            
        }
    }
    
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
