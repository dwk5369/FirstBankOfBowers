
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
    

    
    public void createAccount()
    {
        /*  
        try
        {
            Transaction.connect();
            Statement state = Transaction.connect().createStatement();
            
            String sql = "SELECT* FROM Manager";
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next())
            {
                int id = rs.getInt("id");
                String userName = rs.getString("username");
            }
        }
        catch (Exception SQLException)
        {
            System.out.println("test");
        }  
                */
    }
    
    public void closeAccount()
    {
                
    }
    
    public void createChecking()
    {
                
    }
    
    public void createSaving()
    {
                
    }

}


