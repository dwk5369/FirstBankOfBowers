/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JOptionPane;
/**
 *
 * @author krm5188
 */
public class Account {
    
    public double balance = 0;
    public static int MINBALANCE = 100;
    public double interestRate = 0;
    public String accountNumber;
    public int customerId = 0;
    
    Transaction t = new Transaction();
    
    public void deposit(double depositAmount){
        balance += depositAmount;
        t.deposit(accountNumber,balance);
    }
    
    public void withdraw(double withdrawAmount){
        balance -= withdrawAmount;
        if (balance < 0){
            JOptionPane.showMessageDialog(null, "Cannot withdraw ammount: Account will become over-drawn", "Error", JOptionPane.ERROR_MESSAGE);
            balance += withdrawAmount;
        }
        else {
            t.withdraw(accountNumber, balance);
        }
    }
    
    public double getBalance(){
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
}
