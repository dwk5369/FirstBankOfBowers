import java.sql.*;

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
        transaction.closeAccount(accountNumber);
    }


}


