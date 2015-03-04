
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
    protected PreparedStatement psGetCust;
    protected ResultSet rsResult;
    protected ResultSetMetaData rsmdData;
    
    //get customer info when given a customer's name
    protected String strSearchCust = "select accountNumber,fname,lname,address,city,state,zipcode,email from CUSTOMER_ACCOUNT where fName = ? OR lName = ?;";

    //get customer info when given a customer's account number
    protected String strGetCust = "select accountNumber,fname,lname,address,city,state,zipcode,email from CUSTOMER_ACCOUNT where accountNumber = ?;";
    
    //get customer info when given a customer's account number
    protected String strGetCust2 = "select accountNumber,fname,lname,address,city,state,zipcode,email from CUSTOMER_ACCOUNT where fName = ? AND lName = ?;";
    
    //get account info when given a customer's account number
    protected String strGetAcct = "select balance from CUSTOMER_ACCOUNT where accountNumber = ?";
        
    //get account info when given a customer's account number
    protected String strGetAcct2 = "select balance from account where accountNumber = ?";
    
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
                Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } 

    }// connect
    
    /**
     * 
     * @param accountNum 
     * @return  
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
            cGet.setAccountNumber(rsResult.getInt(1));
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
    
    public Customer getCustomerInfo(String fname, String lname)
    {
        Customer cGet = new Customer();
        try 
        {
            psGet = connDB.prepareStatement(strGetCust2);
            psGet.setString(1, fname);
            psGet.setString(2, lname);
            rsResult = psGet.executeQuery();
            rsResult.first();            
            cGet.setAccountNumber(rsResult.getInt(1));
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
     *
     * @param fname
     * @param lname
     * @return
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
                cGet.setAccountNumber(rsResult.getInt(1));
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
    }//getAccount
    
    public Account getAccount(String fname, String lname)
    {
        return null;
    }//getAccount
    
    public void withdraw(int intAccountNum, int pinNum, int intAmount)
    {
        
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
