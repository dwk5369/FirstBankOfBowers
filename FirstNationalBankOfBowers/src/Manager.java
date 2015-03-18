
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
    

    
    public void createAccount(int accountNumber, String fname, String lname, String address, String city, String state, int zipcode, String email)
    {
        
        try
        {
            
            Statement CreateState = transaction.connect().createStatement();
            
            String createAccount = "INSERT INTO CUSTOMER_ACCOUNT VALUES (accountNumber,fname,lname,address,city,state,zipcode,email)";
            ResultSet rs = CreateState.executeQuery(createAccount);
            System.out.println(rs);

        }
        catch (Exception SQLException)
        {
            System.out.println("test");
        }  
                
    }
    
    public void closeAccount(int accountNum)
    {
           try
        {
            
            Statement CloseState = transaction.connect().createStatement();
            //test
            /*String getAccount = "SELECT* FROM CUSTOMER_ACCOUNT WHERE accountNumber =  " + accountNum;
            ResultSet rs = CloseState.executeQuery(getAccount);
            System.out.println(rs);
            */
            String closeAccount = "DELETE FROM CUSTOMER_ACCOUNT WHERE accountNumber = " + accountNum;
            ResultSet rs = CloseState.executeQuery(closeAccount);

        }
        catch (Exception SQLException)
        {
            System.out.println("test");
        }       
    }
    
    public void createChecking()
    {
                
    }
    
    public void createSaving()
    {
                
    }

}


