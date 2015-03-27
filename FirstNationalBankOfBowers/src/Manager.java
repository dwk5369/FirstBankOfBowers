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
    

    
    public void createCustAccount(int custID, int accountNumber)
    {
        
        transaction.createCustAccount(custID, accountNumber);
                
    }
    
     public void createAccount(int accountNumber, String fname, String lname, String address, String city, String state, int zipcode, String email, int ssn)
    {
        
        transaction.create_Account(accountNumber, fname, lname, address, city, state, zipcode, email, ssn);
                
    }
    
    public void closeAccount(int accountNumber)
    {
        transaction.closeAccount(accountNumber);
    }
    
    public void createChecking(int accountNumber)
    {
            try
        {
            
            Statement CloseState = transaction.connect().createStatement();
            String closeAccount = "INSERT INTO CUSTOMER_ACCOUNT VALUES ()";
            ResultSet rs = CloseState.executeQuery(closeAccount);

        }
        catch (Exception SQLException)
        {
            System.out.println("test");
        }       
    }  
    public void createSaving()
    {
                
    }

}


