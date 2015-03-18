
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwk5369
 */
public class Transaction 
{
    protected Connection connDB;
    protected PreparedStatement psGet;
    protected ResultSet rsResult;
    protected ResultSetMetaData rsmdData;
    
    //get customer info when given a customer's name
    protected String strSearchCust = "select accountNumber,fname,lname,address,city,state,zipcode,email from CUSTOMER_ACCOUNT where fName = ? OR lName = ?;";

    //get customer info when given a customer's account number
    protected String strGetCust = "select accountNumber,fname,lname,address,city,state,zipcode,email from CUSTOMER_ACCOUNT where accountNumber = ?;";
    
    //get customer info when given a customer's account number
    protected String strGetCust2 = "select accountNumber,fname,lname,address,city,state,zipcode,email from CUSTOMER_ACCOUNT where ssn = ?;";
    
    //get account info when given a customer's account number
    protected String strGetAcct = "select balance, interestRate, COS from CUSTOMER_ACCOUNT where accountNumber = ?";
    
    //confirm that a user's login credentials match in the database
    protected String strLogin = "select balance from account where accountNumber = ?";
    
    //perform a withdrawal
    protected String strWithdraw = "update account set balance = balance - ? where accountNumber = ?";
   
    //perform a deposit
    protected String strDeposit = "update account set balance = balance + ? where accountNumber = ?";
    
    /*
    For login view:
    select * from person
    inner join teller on person.ssn = teller.ssn
    left outer join manager on teller.tellerID = manager.tellerID
    */
    
    public Connection connect()
    { 
            try 
            { 
                Class.forName("com.mysql.jdbc.Driver");
                connDB = DriverManager.getConnection("jdbc:mysql://istdata.bk.psu.edu:3306/dwk5369?" + "user=dwk5369&password=berks6125");
                return connDB;
            } 
            catch (ClassNotFoundException|SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE);
                return null;
            } 

    }// connect
    
    /**
     * Searches the database for a customer with the given first name and last name and returns
     * an object containing that customer's information.
     * 
     * @param accountNum the customer's account number
     * @return an object of type Customer containing that customer's information
     */
    public Customer getCustomerInfo(int accountNum)
    {
        Customer cGet = new Customer();
        try 
        {
            psGet = connDB.prepareStatement(strGetCust);
            psGet.setInt(1, accountNum);
            rsResult = psGet.executeQuery();
            rsResult.first();            
            cGet.setCustomerIDnumber(rsResult.getInt(1));
            cGet.setFname(rsResult.getString(2));
            cGet.setLname(rsResult.getString(3));
            cGet.setAddress(rsResult.getString(4));
            cGet.setCity(rsResult.getString(5));
            cGet.setState(rsResult.getString(6));
            cGet.setZipcode(rsResult.getString(7));
            cGet.setEmail(rsResult.getString(8));
            psGet.close();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return cGet;

    }//getCustomerInfo
    
    /**
     * Searches the database for a customer with the given first name and last name and returns
     * an object containing that customer's information.
     * 
     * @param ssn the customer's social security number, in a string
     * @return an object of type Customer containing that customer's information
     */
    public Customer getCustomerInfo(String ssn)
    {
        Customer cGet = new Customer();
        try 
        {
            psGet = connDB.prepareStatement(strGetCust2);
            psGet.setString(1, ssn);
            rsResult = psGet.executeQuery();
            rsResult.first();            
            cGet.setCustomerIDnumber(rsResult.getInt(1));
            cGet.setFname(rsResult.getString(2));
            cGet.setLname(rsResult.getString(3));
            cGet.setAddress(rsResult.getString(4));
            cGet.setCity(rsResult.getString(5));
            cGet.setState(rsResult.getString(6));
            cGet.setZipcode(rsResult.getString(7));
            cGet.setEmail(rsResult.getString(8));
            psGet.close();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return cGet;

    }//getCustomerInfo
    
    /**
     * Searches the database for customers with the given first name or last name
     * 
     * @param fname first name to search for. Pass in an empty string to only search for last names
     * @param lname last name to search for. Pass in an empty string to only search for first names
     * @return an ArrayList object containing each Customer that is a potential match
     */
    public ArrayList searchCustomerInfo(String fname, String lname)
    {
        Customer cGet;
        ArrayList cResult;
        try 
        {
            psGet = connDB.prepareStatement(strSearchCust);
            psGet.setString(1,fname);
            psGet.setString(2,lname);
            rsResult = psGet.executeQuery();
            cResult = new ArrayList();
            while(rsResult.next())
            {
                cGet = new Customer();
                cGet.setCustomerIDnumber(rsResult.getInt(1));
                cGet.setFname(rsResult.getString(2));
                cGet.setLname(rsResult.getString(3));
                cGet.setAddress(rsResult.getString(4));
                cGet.setCity(rsResult.getString(5));
                cGet.setState(rsResult.getString(6));
                cGet.setZipcode(rsResult.getString(7));
                cGet.setEmail(rsResult.getString(8));
                cResult.add(cGet);
            }
            psGet.close();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return cResult;
    }//searchCustomerInfo
    
    /**
     * 
     * @param strUserName
     * @param strPass
     * @return 
     */
    public Teller login(String strUserName, String strPass)
    {
        
        return new Teller();
    }//
    
    /**
     * 
     * @param cust
     * @return 
     */
    public Account getAccount(Customer cust)
    {
        try 
        {
            int acctNum = cust.getCustomerIDnumber();
            
            psGet = connDB.prepareStatement(strGetAcct);
            psGet.setInt(1, acctNum);
            rsResult = psGet.executeQuery();
            rsResult.first();            
            
            double balance = rsResult.getDouble(1);
            double intRate = rsResult.getDouble(2);
            String cOrS = rsResult.getString(3);
            psGet.close();
            if(cOrS.equals("c"))
                return new CheckingAccount(acctNum+"", balance, intRate);
            else
                return new SavingsAccount(acctNum+"", balance, intRate);
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }//getAccount
    
    public void withdraw(String strAcctNum, double dblAmount)
    {
        try
        {
            psGet = connDB.prepareStatement(strWithdraw);
            psGet.setDouble(1, dblAmount);
            psGet.setInt(2, Integer.parseInt(strAcctNum));
            psGet.executeUpdate();
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE);      
        }
    }//withdraw
    
    public void deposit(String strAcctNum, double dblAmount)
    {
        try
        {
            psGet = connDB.prepareStatement(strDeposit);
            psGet.setDouble(1, dblAmount);
            psGet.setInt(2, Integer.parseInt(strAcctNum));
            psGet.executeUpdate();
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE);      
        }        
    }//withdraw
    
    public double getBalance(Account acct)
    {
        return 0;
    }//withdraw
    
    
    public void disconnect()
    {
        try 
        {
            connDB.close();
        } 
        catch (SQLException ex) 
        {
            //handle
        }
    }// disconnect
}
