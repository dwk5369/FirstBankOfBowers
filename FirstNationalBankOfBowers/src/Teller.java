import java.util.ArrayList;

/**
 *
 * @author trm5313
 */
public class Teller extends Person {
    
    public class Overdrawn extends Exception
    {

    }    
    Transaction tellerTransaction = new Transaction();  //new Transaction Object
    
    private Customer currentCustomer = new Customer();  //Class level variable for the current customer object
    private Account currentAccount = new Account();     //Class level variable for the current account object

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }//getCurrentCustomer

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }//setCurrentCustomer

    public Account getCurrentAccount() {
        return currentAccount;
    }//getCurrentAccount

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }//setCurrentAccount
        
    public Teller tellerLogin(String username, String password)//Login method for Teller
    {
        return tellerTransaction.login(username, password);
    }
    
    /**
     * References transaction class for searching customer info
     * NOTE: Overloaded method
     * 
     * @param fname
     * @param lname
     * @return 
     */
    public ArrayList tellerCustomerSearch(String fname, String lname)
    {
        return tellerTransaction.searchCustomerInfo(fname, lname);
    }
    
    /**
     * References transaction class for searching customer info
     * NOTE: Overloaded method
     * 
     * @param ssn
     * @return 
     */
    public Customer tellerCustomerSearch(String ssn)
    {
        return tellerTransaction.getCustomerInfo(ssn);
    }
    
    /**
     * checkBalance imports the currentAccount
     * 
     * @return 
     */
    public double checkBalance()
    {
        return 0;//currentAccount.getBalance();
    }//checkBalance
    
    /**
     * References currentAccount methods to check if there is enough money to withdraw and uses withdraw method of the account class
     * Throws exception: Overdrawn
     * 
     * @param intAmount
     * @throws Teller.Overdrawn 
     */
    public void makeWithdraw(int intAmount) throws Overdrawn
    {
        try
        {
            if (intAmount > checkBalance()) 
            {
                throw new Overdrawn();
            }
            else
            {
                //currentAccount.Withdraw(intAmount);
            }
        } // try
        
        catch (Overdrawn Over)
        {
             System.out.println("Cannot withdraw " + intAmount + ". Insufficient funds.");
        } //catch
    }//makeWithdrawal
    
    /**
     * References currentAccount's deposit method
     * 
     * @param Amount 
     */
    public void makeDeposit(int Amount)
    {
        //currentAccount.Deposit(currentAccount, Amount);
    } // makeDeposit
    
    /**
     * References currentAccount's wiretransfer method to transfer money to another account
     * 
     * @param endingAccount
     * @param Amount 
     */
    public void makeTransfer(Account endingAccount, int Amount)
    {
        //currentAccount.wireTransfer(endingAccount, Amount);
    } //makeTransfer
    
}
