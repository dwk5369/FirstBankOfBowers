/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krm5188
 */
public class CheckingAccount {
    
    private double balance = 0;
    private static int MINBALANCE = 100;
    private double interestRate = 0;
    private String accountNumber;
    
    public CheckingAccount(String acc) {
        accountNumber = acc;
    }
    
    public CheckingAccount(double bal, String acc){
        accountNumber = acc;
        if (bal >= 100){
            balance = bal;
        }
        else{
            
        }
    }
    
    public void deposit(double depositAmount){
        
    }
    
    public void withdraw(double withdrawAmount){
        
    }
    
    public double getBalance(){
        return balance;
    }
    
}
