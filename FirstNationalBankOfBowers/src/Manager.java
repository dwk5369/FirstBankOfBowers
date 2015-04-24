import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mjb6002
 */
public class Manager extends Teller
{
    Transaction transaction = new Transaction();

    Manager(String strFName, String strLName) 
    {
        super.setFname(strFName); 
        super.setLname(strLName);
    }
    

    
    public void createCustAccount(int custID, int accountNumber)
    {
        
        transaction.createCustAccount(custID, accountNumber);
                
    }
    
     public void createAccount(Customer cust, String strAcctType, double dblBalance, double dblInterest)
    {
        
        transaction.createAccount(cust, strAcctType, dblBalance, dblInterest);
                
    }
    
    public void closeAccount(int accountNumber)
    {
        if (JOptionPane.showConfirmDialog(null,"Are you sure you want to close this account?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            transaction.closeAccount(accountNumber);
        }
        
    }


}


