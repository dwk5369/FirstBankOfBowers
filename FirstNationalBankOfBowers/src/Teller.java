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
    
    public void makeWithdraw(int accountNum, int pinNum, int Amount) throws Overdrawn
    {
        try
        {
            if (Amount > checkBalance()) 
            {
                throw new Overdrawn();
            }
            else
            {
                Transaction.Withdraw(accountNum, pinNum, Amount);
            }
        } // try
        
        catch (Overdrawn Over)
        {
             System.out.println("Cannot withdrawl " + Amount + ". Insufficient funds.");
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
