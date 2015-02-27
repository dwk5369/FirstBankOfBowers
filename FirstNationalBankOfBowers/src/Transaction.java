
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static Connection connDB;
    private static PreparedStatement psGet;
    private static ResultSet rsResult;
    private static ResultSetMetaData rsmdData;
    private static String strGetAcct = "select accountNumber from dwk5369.account;";
    private static String strGetCust = "select * from CUSTOMER_ACCOUNT;";
    
    public static void connect()
    { 
            try 
            { 
                Class.forName("com.mysql.jdbc.Driver");
                connDB = DriverManager.getConnection("jdbc:mysql://istdata.bk.psu.edu:3306/dwk5369?" + "user=dwk5369&password=berks6125");
            } 
            catch (ClassNotFoundException|SQLException ex) 
            { 
                //handle
            } 

    }// connect
    
    /**
     * 
     * @param accountNum 
     * @return  
     */
    public static Customer getCustomerInfo(String accountNum)
    {
        connect();
        try 
        {
            psGet = connDB.prepareStatement(strGetCust);
            rsResult = psGet.executeQuery();
            rsmdData = rsResult.getMetaData();
            Customer cGet = new Customer();
            cGet.setAccountNumber(rsResult.getInt(1));
            cGet.setFname(rsResult.getString(2));
            cGet.setLname(rsResult.getString(3));
            cGet.setAddress(rsResult.getString(4));
            cGet.setEmail(rsResult.getString(8));
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return null;
    }//getAccount
    
    /**
     *
     * @param fname
     * @param lname
     * @return
     */
    public static Customer getCustomerInfo(String fname, String lname)
    {
        return null;
    }//getAccount
    
    public static Account getAccount(String fname, String lname)
    {
        return null;
    }//getAccount
    
    public static void withdraw(int intAccountNum, int pinNum, int intAmount)
    {
        
    }//withdraw
    
    public static double getBalance()
    {
        return 0;
    }//withdraw
    
    
    public static void disconnect()
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
