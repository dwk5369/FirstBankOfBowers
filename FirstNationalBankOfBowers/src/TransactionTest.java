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
        String acctNum = "11111111";
        Customer keith = Transaction.getCustomerInfo(acctNum);
        System.out.println(keith.toString());
    }
}
