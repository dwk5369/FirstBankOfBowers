
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


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
    //protected String strSearchCust = "select accountNumber,fname,lname,address,city,state,zipcode,email from CUSTOMER_ACCOUNT where fName = ? OR lName = ?;";
    protected String strSearchCust = "select distinct fname,lname,address,city,state,zipcode,email,ssn from CUSTOMER_ACCOUNT where fName = ? OR lName = ?;";

    //get customer info when given a customer's account number
    protected String strGetCust = "select fname,lname,address,city,state,zipcode,email,ssn from CUSTOMER_ACCOUNT where accountNumber = ?;";
    
    //get customer info when given a customer's ssn
    //protected String strGetCust2 = "select accountNumber,fname,lname,address,city,state,zipcode,email from CUSTOMER_ACCOUNT where ssn = ?;";
    protected String strGetCust2 = "select distinct fname,lname,address,city,state,zipcode,email from CUSTOMER_ACCOUNT where ssn = ?;";
    
    //get account info when given a customer's account number
    protected String strGetAcct = "select accountNumber, balance, interestRate, COS from CUSTOMER_ACCOUNT where ssn = ?";
    
    //get account info for a specific account type
    protected String strGetAcct2 = "select accountNumber, balance, interestRate from CUSTOMER_ACCOUNT where ssn = ? and COS = ?";
    
    //confirm that a user's login credentials match in the database
    //protected String strLogin = "select fname, lname, managerID from person inner join teller on person.id = teller.id left outer join manager on teller.tellerID = manager.tellerID where userName = ? and password = ?";
    protected String strLogin = "select fname, lname, managerID from logininfo where userName = ? and password = ?";
    
    //perform a withdrawal
    protected String strWithdraw = "update account set balance = balance - ? where accountNumber = ?";
   
    //perform a deposit
    protected String strDeposit = "update account set balance = balance + ? where accountNumber = ?";
    
    
    protected String strCreateCustAccount = "INSERT INTO CUSTOMERACCOUNTS VALUES (?, ?)";
    
    protected String strCreateAccount = "INSERT INTO ACCOUNT (balance, interestRate, checkingOrSavings) VALUES (?,?,?)";
    
    protected String strCloseAccount = "DELETE FROM ACCOUNT WHERE accountNumber = ?";
    
    protected String strGetCustID = "select customerID from customer inner join person on customer.id = person.id where ssn=?";
    
    protected String strCreateCustomer = "insert into person (ssn, fname, lname, address, city, state, zipcode, email) values (?,?,?,?,?,?,?,?);";
    
    protected String strCreateCustomer2 = "insert into customer (id,pinnumber) values (7,'9999');";
    
    protected String strTransferFrom = "update account set balance = balance - ? where accountNumber = ?";
    
    protected String strTransferTo = "update account set balance = balance + ? where accountNumber = ?";
    
    /*
    For login view:
    select * from person
    inner join teller on person.id = teller.id
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
    public ArrayList<Customer> getAccountOwners(int accountNum)
    {
        Customer cGet;
        ArrayList<Customer> cResult;
        try 
        {
            psGet = connDB.prepareStatement(strGetCust);
            psGet.setInt(1, accountNum);
            rsResult = psGet.executeQuery();
            rsResult.beforeFirst();
            cResult = new ArrayList();
            while(rsResult.next())
            {
                cGet = new Customer();
                //cGet.setAccountNumber(rsResult.getInt(1));
                cGet.setFname(rsResult.getString(1));
                cGet.setLname(rsResult.getString(2));
                cGet.setAddress(rsResult.getString(3));
                cGet.setCity(rsResult.getString(4));
                cGet.setState(rsResult.getString(5));
                cGet.setZipcode(rsResult.getString(6));
                cGet.setEmail(rsResult.getString(7));
                cGet.setSocialSecurity(rsResult.getString(8));
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
            //cGet.setAccountNumber(rsResult.getInt(1));
            cGet.setFname(rsResult.getString(1));
            cGet.setLname(rsResult.getString(2));
            cGet.setAddress(rsResult.getString(3));
            cGet.setCity(rsResult.getString(4));
            cGet.setState(rsResult.getString(5));
            cGet.setZipcode(rsResult.getString(6));
            cGet.setEmail(rsResult.getString(7));
            cGet.setSocialSecurity(ssn);
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
    public ArrayList<Customer> searchCustomerInfo(String fname, String lname)
    {
        Customer cGet;
        ArrayList<Customer> cResult;
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
                //cGet.setAccountNumber(rsResult.getInt(1));
                cGet.setFname(rsResult.getString(1));
                cGet.setLname(rsResult.getString(2));
                cGet.setAddress(rsResult.getString(3));
                cGet.setCity(rsResult.getString(4));
                cGet.setState(rsResult.getString(5));
                cGet.setZipcode(rsResult.getString(6));
                cGet.setEmail(rsResult.getString(7));
                cGet.setSocialSecurity(rsResult.getString(8));
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
     * Log a user into the system, allowing them to perform tasks.
     * 
     * @param strUserName the username entered in the login screen
     * @param strPass the password entered in the login screen
     * @return A Teller object if the user is a teller, a Manager object if the user is a manager, or nothing if the username and password are not found
     */
    public Teller login(String strUserName, String strPass)
    {
        try 
        {
            psGet = connDB.prepareStatement(strLogin);
            psGet.setString(1,strUserName);
            psGet.setString(2,strPass);
            rsResult = psGet.executeQuery();
            rsResult.first();
            String strFName = rsResult.getString(1);
            String strLName = rsResult.getString(2);
            int managerID = rsResult.getInt(3);
            psGet.close();
            if(managerID == 0)
                return new Teller(strFName,strLName);
            else
                return new Manager(strFName,strLName);            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }//
    
    /**
     * 
     * @param cust
     * @return 
     */
    public ArrayList<Account> getAccount(Customer cust)
    {
        try 
        {
            String strSSN = cust.getSocialSecurity();
            
            ArrayList<Account> acct = new ArrayList();
            
            psGet = connDB.prepareStatement(strGetAcct);
            psGet.setString(1, strSSN);
            rsResult = psGet.executeQuery();
            rsResult.beforeFirst();
            while(rsResult.next())
            {
                String acctNum = rsResult.getString(1);
                double balance = rsResult.getDouble(2);
                double intRate = rsResult.getDouble(3);
                String cOrS = rsResult.getString(4);
                if(cOrS.equals("c"))
                    acct.add(new CheckingAccount(acctNum, balance, intRate));
                else
                    acct.add(new SavingsAccount(acctNum, balance, intRate));                
            }
            psGet.close();
            return acct;
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }//getAccount

    public Account getAccount(Customer cust, String strCOS)
    {
        try 
        {
            String strSSN = cust.getSocialSecurity();
            Account acct;
            
            psGet = connDB.prepareStatement(strGetAcct2);
            psGet.setString(1, strSSN);
            psGet.setString(2, strCOS);
            rsResult = psGet.executeQuery();
            rsResult.first();            
            String acctNum = rsResult.getString(1);
            double balance = rsResult.getDouble(2);
            double intRate = rsResult.getDouble(3);
            if(strCOS.equals("c"))
                acct = new CheckingAccount(acctNum, balance, intRate);
            else
                acct = new SavingsAccount(acctNum, balance, intRate);                
            psGet.close();
            return acct;
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }//getAccount    
    
    /**
     * Withdraw funds from the specified account
     * 
     * @param strAcctNum account number to withdraw from
     * @param dblAmount amount to be withdrawn
     */
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
    
    /**
     * Deposit funds into an account
     * 
     * @param strAcctNum account number to deposit into
     * @param dblAmount amount to be deposited
     */
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
    
    /**
     * 
     * 
     * @param cust
     * @param strAcctType
     * @param dblBalance
     * @param dblInterest
     */
    public void createAccount(Customer cust, String strAcctType, double dblBalance, double dblInterest)
    {
        
        try
        {
            
            psGet = connDB.prepareStatement(strCreateAccount);
            psGet.setDouble(1, dblBalance);
            psGet.setDouble(2, dblInterest);
            psGet.setString(3, strAcctType);
            psGet.executeUpdate();
            int custID = getCustomerID(cust.getSocialSecurity());
            int acctNum = Integer.parseInt(getAccount(cust, strAcctType).getAccountNumber());
            createCustAccount(custID,acctNum);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE); 
        }
    
    }//create_Account
     
    /**
     * 
     * @param custID
     * @param accountNumber 
     */
    public void createCustAccount(int custID, int accountNumber)
    {
        
        try
        {
            
            psGet = connDB.prepareStatement(strCreateCustAccount);
            psGet.setInt(1, custID);
            psGet.setInt(2, accountNumber);
            psGet.executeUpdate();

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE); 
        }  
                
    }//createCustAccount
    
    private int getCustomerID(String strSSN) 
    {
        try
        {
            psGet = connDB.prepareStatement(strGetCustID);
            psGet.setString(1,strSSN);
            rsResult = psGet.executeQuery();
            int intCustID = rsResult.getInt(1);
            return intCustID;
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE); 
            return 0;
        }   
    } 
     
    public void closeAccount(int accountNumber)
    {
        try
        {
            psGet = connDB.prepareStatement(strCloseAccount);
            psGet.setInt(1,accountNumber);
            psGet.executeUpdate();
            

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE); 
        }    
    } //closeAccount
    
    
    public Customer createCustomer(String strSSN, String strFName, String strLName, String strAddress, String strCity, String strState, String strZipcode, String strEmail)
    {
        try
        {
            psGet = connDB.prepareStatement(strCloseAccount);
            psGet.setString(1, strSSN);
            psGet.setString(2, strFName);
            psGet.setString(3, strLName);
            psGet.setString(4, strAddress);
            psGet.setString(5, strCity);
            psGet.setString(6, strState);
            psGet.setString(7, strZipcode);
            psGet.setString(8, strEmail);
            psGet.executeUpdate();
            //insert into customer (id,pinnumber) values (7,'9999');

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE); 
        }            
        return new Customer();
    }//createAccount

    public void transferFunds(Account acctFrom, Account acctTo, double dblTransfer) 
    {
        try
        {
            psGet = connDB.prepareStatement(strTransferFrom);
            psGet.setDouble(1, dblTransfer);
            psGet.setString(2, acctFrom.getAccountNumber());
            psGet.executeUpdate();
            psGet = connDB.prepareStatement(strTransferTo);
            psGet.setDouble(1, dblTransfer);
            psGet.setString(2, acctTo.getAccountNumber());
            psGet.executeUpdate();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error reading database. Please contact IT. " + ex.getMessage(), ex.getClass().toString(), JOptionPane.ERROR_MESSAGE); 
        }            
    }    
    
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
