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
public class CheckingAccount extends Account {
    
    public CheckingAccount(String acc) {
        accountNumber = acc;
    }
    
    public CheckingAccount(double bal, String acc){
        accountNumber = acc;
        if (bal >= 100){
            balance = bal;
        }
        else{
            JOptionPane.showMessageDialog(null,"Insufficient amount", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
