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
public class SavingsAccount extends Account {
    
    public SavingsAccount(String acc,double balance,double interestRate) {
        this.accountNumber = acc;
        this.interestRate = interestRate;
        this.balance = balance;
    }
    
    public SavingsAccount(double bal, String acc, int cId){
        this.accountNumber = acc;
        this.customerId = cId;
        if(bal >= 100){
            balance = bal;
        }
        else{
            JOptionPane.showMessageDialog(null,"Insufficient amount", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
      
    @Override
    public String toString() {
        return "SavingsAccount{" + accountNumber + ',' + balance + '}';
    }    
}
