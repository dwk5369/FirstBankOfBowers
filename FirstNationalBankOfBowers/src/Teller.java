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
    
    public double checkBalance()
    {
        return Transaction.getBalance();
    }//checkBalance
    
    public void makeWithdraw(int intaccountNum, int pinNum, int intAmount) throws Overdrawn
    {
        try
        {
            if (intAmount > checkBalance()) 
            {
                throw new Overdrawn();
            }
            else
            {
                Transaction.Withdraw(intaccountNum, pinNum, intAmount);
            }
        } // try
        
        catch (Overdrawn Over)
        {
             System.out.println("Cannot withdrawl " + intAmount + ". Insufficient funds.");
        } //catch
    }//makeWithdrawal
    
    public void makeDeposit(int accountNum, int pinNum, int Amount)
    {
        Transaction.Deposit(accountNum, pinNum, Amount);
    } // makeDeposit
    
    public void makeTransfer(int startingAccountNumber, int endingAccountNumber, int Amount)
    {
        Transaction.wireTransfer(startingAccountNumber, endingAccountNumber, Amount);
    } //makeTransfer
    
}
