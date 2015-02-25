
import java.sql.SQLException;
import java.sql.Statement;

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
    Transaction test = new Transaction();

    
    public void createAccount()
    {
        try
        {
            Statement st = test.connDB.createStatement();
        }
        catch (Exception SQLException)
        {
            
        }
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
