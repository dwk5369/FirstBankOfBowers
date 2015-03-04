
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
    private static Connection connDB;
    private static PreparedStatement psGet;
    private static ResultSet rsResult;
    private static ResultSetMetaData rsmdData;
    private static String strGetAcct = "select accountNumber from dwk5369.account;";
    private static String strGetCust = "select * from CUSTOMER_ACCOUNT where fName = ? OR lName = ?;";
    private static String strGetCust2 = "select * from CUSTOMER_ACCOUNT where accountNum = ?;";
    
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
        Customer cGet = new Customer();
        try 
        {
            psGet = connDB.prepareStatement(strGetCust);
            psGet.setInt(1, Integer.parseInt(accountNum));
            rsResult = psGet.executeQuery();
            cGet.setAccountNumber(rsResult.getInt(1));
            cGet.setFname(rsResult.getString(2));
            cGet.setLname(rsResult.getString(3));
            cGet.setAddress(rsResult.getString(4));
            cGet.setCity(rsResult.getString(5));
            cGet.setState(rsResult.getString(6));
            cGet.setZipcode(rsResult.getString(7));
            cGet.setEmail(rsResult.getString(8));

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT.", "Error", JOptionPane.ERROR);
            return null;
        }
        disconnect();
        return cGet;

    }//getAccount
    
    /**
     *
     * @param fname
     * @param lname
     * @return
     */
    public static ArrayList getCustomerInfo(String fname, String lname)
    {
        connect();
        Customer cGet = new Customer();
        ArrayList cResult;
        try 
        {
            psGet = connDB.prepareStatement(strGetCust2);
            psGet.setString(1, fname);
            psGet.setString(2,lname);
            rsResult = psGet.executeQuery();
            cResult = new ArrayList();
            while(rsResult.next())
            {
                cGet.setAccountNumber(rsResult.getInt(1));
                cGet.setFname(rsResult.getString(2));
                cGet.setLname(rsResult.getString(3));
                cGet.setAddress(rsResult.getString(4));
                cGet.setCity(rsResult.getString(5));
                cGet.setState(rsResult.getString(6));
                cGet.setZipcode(rsResult.getString(7));
                cGet.setEmail(rsResult.getString(8));
                cResult.add(cGet);
                rsResult.next();
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT.", "Error", JOptionPane.ERROR);
            return null;
        }
        disconnect();
        return cResult;
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
