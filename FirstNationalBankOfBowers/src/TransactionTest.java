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
        t1.disconnect();
        System.out.println(keith.toString());
    }
}
