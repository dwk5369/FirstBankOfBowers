
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
        Customer keith = t1.getCustomerInfo(acctNum);
        
        System.out.println(keith.toString());
        
        Customer someone = t1.getCustomerInfo("444444444");
        System.out.println(someone.toString());
        
        String fname = "Keith";
        String lname = "McMullan";
        
        ArrayList maybeKeith = t1.searchCustomerInfo(fname, lname);
        System.out.println(maybeKeith.toString());
        
        Account acct = t1.getAccount(keith);
        System.out.println(acct.toString());
        t1.disconnect();
    }
}
