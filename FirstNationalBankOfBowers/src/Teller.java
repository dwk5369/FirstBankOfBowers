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
    
    public class Overdrawn extends Throwable
    {
        
    }
    
    public double checkBalance()
    {
        return Transaction.getBalance();
    }
    
    public String makeWithdrawal(int accountNum, int pinNum, int Amount) throws Overdrawn
    {
        try
        {
            if (Amount > checkBalance()) throw new Overdrawn
            else Transaction.Withdrawl(accountNum, pinNum, Amount);
        }
        
        catch (Overdrawn Over)
        {
             return("Cannot withdrawl " + Amount + ". Insufficient funds.");
        }
    }
}
