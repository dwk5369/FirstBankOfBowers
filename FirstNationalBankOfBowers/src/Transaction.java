
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    
    public static Connection connect()
    { 
            try 
            { 
                Class.forName("com.mysql.jdbc.Driver");
                connDB = DriverManager.getConnection("jdbc:mysql://istdata.bk.psu.edu:3306/dwk5369?" + "user=dwk5369&password=berks6125");
                return connDB;
            } 
            catch (ClassNotFoundException|SQLException ex) 
            { 
                return null;
            } 

    }// connect
    
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
            
        }
    }// disconnect
}
