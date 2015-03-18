
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwk5369
 */
public class TransactionTest {
    public static void main(String[] args)
    {
        Transaction t1 = new Transaction();
        int acctNum = 11111111;
        t1.connect();
        ArrayList test = t1.getAccountOwners(acctNum);
        
        System.out.println(test.toString());
        
        Customer someone = t1.getCustomerInfo("333333333");
        System.out.println(someone.toString());
        
        String fname = "Keith";
        String lname = "McMullan";
        
        ArrayList maybeKeith = t1.searchCustomerInfo(fname, lname);
        System.out.println(maybeKeith.toString());
        
       /* Account acct = t1.getAccount(keith);
        System.out.println(acct.toString());
        t1.withdraw(acct.getAccountNumber(),100);
        System.out.println(t1.getAccount(keith).getBalance());
        t1.deposit(acct.getAccountNumber(),1000);
        System.out.println(t1.getAccount(keith).getBalance());        
        t1.disconnect();*/
    }
}
