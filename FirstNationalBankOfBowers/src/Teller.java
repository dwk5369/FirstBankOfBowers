/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trm5313
 */
public class Teller extends Person {
    
    public class Overdrawn extends Exception
    {

    }
    
    public double checkBalance(Account currentAccount)
    {
        return 0;//currentAccount.getBalance();
    }//checkBalance
    
    public void makeWithdraw(Account currentAccount, int intAmount) throws Overdrawn
    {
        try
        {
            if (intAmount > checkBalance(currentAccount)) 
            {
                throw new Overdrawn();
            }
            else
            {
                //currentAccount.Withdraw(currentAccount, intAmount);
            }
        } // try
        
        catch (Overdrawn Over)
        {
             System.out.println("Cannot withdraw " + intAmount + ". Insufficient funds.");
        } //catch
    }//makeWithdrawal
    
    public void makeDeposit(Account currentAccount, int Amount)
    {
        //currentAccount.Deposit(currentAccount, Amount);
    } // makeDeposit
    
    public void makeTransfer(Account startingAccount, Account endingAccount, int Amount)
    {
        //currentAccount.wireTransfer(startingAccount, endingAccount, Amount);
    } //makeTransfer
    
}
