/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexander
 */
public class ATM_Methods {
    
    String UserInfoFname;
    String UserAccountBal;
    //Void to get user information and to String for output (Welcome User!)
    public void setUserInfoFname(String setUserFname)
    {
        UserInfoFname = ("Welcome Back " + setUserFname + "!!");
    }
    //return variable for call
    public String getUserInfoFname()
    {
        return UserInfoFname;
    }
    //set Account Balance
    public void setAccountBalance(String setBalance)
    {
       UserAccountBal =  setBalance;
               
    }
    //return variable
    public String getAccountBalance()
    {
        return UserAccountBal;
    }
 
    
}
