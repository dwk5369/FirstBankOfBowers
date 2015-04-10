
import java.awt.Font;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwk5369
 */

//TODO: Set Withdraw, Deposit, Transfer and other buttons as disabled if the current account is null

public class MainScreen extends javax.swing.JFrame {

    Transaction bankTrans;
    Account acctCurrent;
    Customer custCurrent;
    Teller currentUser;
    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
    }

    public MainScreen(Teller tell, Transaction trans)
    {
        currentUser = tell;
        bankTrans = trans;
        initComponents();
        jlLoggedInAs.setText("Logged in as: " + currentUser.getClass().toString().substring(6) + " " + currentUser.toString());
        if(currentUser.getClass().toString().substring(6).equals("Teller"))
            jbManagerTools.setVisible(false);
    }

    public MainScreen(Teller tell, Transaction trans, Customer cust, Account acct)
    {
        currentUser = tell;
        bankTrans = trans;
        custCurrent = cust;
        acctCurrent = acct;
        initComponents();
        jlLoggedInAs.setText("Logged in as: " + currentUser.getClass().toString().substring(6) + " " + currentUser.toString());
        if(currentUser.getClass().toString().substring(6).equals("Teller"))
            jbManagerTools.setVisible(false);
        if(custCurrent != null)
            jlCustomer.setText("Current Customer: " + custCurrent.toString());
        if(acctCurrent != null)
        {
            jlAccount.setText("Current Account: " + acctCurrent.getAccountNumber());
            jlBalance.setText("Account Balance: $" + new BigDecimal(acctCurrent.getBalance()).setScale(2, RoundingMode.UP));
        }
            
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jpMain = new javax.swing.JPanel();
        jbLogout = new javax.swing.JButton();
        jbManagerTools = new javax.swing.JButton();
        jpButtons = new javax.swing.JPanel();
        jlLoggedInAs = new javax.swing.JLabel();
        jbSearchCustomer = new javax.swing.JButton();
        jbSelectAccount = new javax.swing.JButton();
        jbWithdrawl = new javax.swing.JButton();
        jbDeposit = new javax.swing.JButton();
        jbTransferFunds = new javax.swing.JButton();
        jbAccountInfo = new javax.swing.JButton();
        jlAccount = new javax.swing.JLabel();
        jlBalance = new javax.swing.JLabel();
        jlCustomer = new javax.swing.JLabel();
        jbEndTransaction = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("First Bank Of Bowers Account Management System");

        jbLogout.setText("Logout");
        jbLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLogoutActionPerformed(evt);
            }
        });

        jbManagerTools.setText("Manager Tools");
        jbManagerTools.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbManagerToolsActionPerformed(evt);
            }
        });

        jpButtons.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlLoggedInAs.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N

        jbSearchCustomer.setText("Search Customer");
        jbSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchCustomerActionPerformed(evt);
            }
        });

        jbSelectAccount.setText("Select Account");
        jbSelectAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSelectAccountActionPerformed(evt);
            }
        });

        jbWithdrawl.setText("Withdraw");
        jbWithdrawl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbWithdrawlActionPerformed(evt);
            }
        });

        jbDeposit.setText("Deposit");
        jbDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDepositActionPerformed(evt);
            }
        });

        jbTransferFunds.setText("Transfer Funds");
        jbTransferFunds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTransferFundsActionPerformed(evt);
            }
        });

        jbAccountInfo.setText("Account Info");

        jlAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlAccount.setText("Current Account:");

        jlBalance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlBalance.setText("Account Balance: ");

        jlCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlCustomer.setText("Current Customer:");

        jbEndTransaction.setText("End Transaction");
        jbEndTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEndTransactionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpButtonsLayout = new javax.swing.GroupLayout(jpButtons);
        jpButtons.setLayout(jpButtonsLayout);
        jpButtonsLayout.setHorizontalGroup(
            jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpButtonsLayout.createSequentialGroup()
                        .addComponent(jbTransferFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpButtonsLayout.createSequentialGroup()
                        .addGroup(jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpButtonsLayout.createSequentialGroup()
                                .addComponent(jbSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpButtonsLayout.createSequentialGroup()
                                .addComponent(jbSelectAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpButtonsLayout.createSequentialGroup()
                                .addComponent(jbWithdrawl, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpButtonsLayout.createSequentialGroup()
                                .addComponent(jbDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpButtonsLayout.createSequentialGroup()
                                .addComponent(jbAccountInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                .addComponent(jbEndTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLoggedInAs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpButtonsLayout.setVerticalGroup(
            jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLoggedInAs, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSearchCustomer)
                    .addComponent(jlCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSelectAccount)
                    .addComponent(jlAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbWithdrawl)
                    .addComponent(jlBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jbDeposit)
                .addGap(18, 18, 18)
                .addComponent(jbTransferFunds)
                .addGap(18, 18, 18)
                .addGroup(jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAccountInfo)
                    .addComponent(jbEndTransaction))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpMainLayout = new javax.swing.GroupLayout(jpMain);
        jpMain.setLayout(jpMainLayout);
        jpMainLayout.setHorizontalGroup(
            jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpMainLayout.createSequentialGroup()
                        .addComponent(jbManagerTools, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMainLayout.setVerticalGroup(
            jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jpButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbManagerTools)
                    .addComponent(jbLogout))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLogoutActionPerformed
        int intLogout = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout?", JOptionPane.YES_NO_OPTION);
        if(intLogout == 0)
        {
            new TellerInterface().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jbLogoutActionPerformed

    private void jbManagerToolsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbManagerToolsActionPerformed
        new ManagerScreen((Manager)currentUser,bankTrans,custCurrent,acctCurrent).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbManagerToolsActionPerformed

    private void jbSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchCustomerActionPerformed
        new SearchCustomer(bankTrans,acctCurrent,custCurrent,currentUser).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbSearchCustomerActionPerformed

    private void jbEndTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEndTransactionActionPerformed
        int intEnd = JOptionPane.showConfirmDialog(this, "Are you sure you want to end the current transaction?", "End Transaction", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(intEnd == 0)
        {
            jlCustomer.setText("Current Customer:");
            jlAccount.setText("Current Account:");
            jlBalance.setText("Account Balance:");
            custCurrent = new Customer();
            acctCurrent = new Account();
        }
    }//GEN-LAST:event_jbEndTransactionActionPerformed

    private void jbSelectAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelectAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSelectAccountActionPerformed

    private void jbWithdrawlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbWithdrawlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbWithdrawlActionPerformed

    private void jbDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDepositActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbDepositActionPerformed

    private void jbTransferFundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTransferFundsActionPerformed
        // TODO add your handling code here:
        new selectAccount(bankTrans,acctCurrent,custCurrent,currentUser).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbTransferFundsActionPerformed
                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jbAccountInfo;
    private javax.swing.JButton jbDeposit;
    private javax.swing.JButton jbEndTransaction;
    private javax.swing.JButton jbLogout;
    private javax.swing.JButton jbManagerTools;
    private javax.swing.JButton jbSearchCustomer;
    private javax.swing.JButton jbSelectAccount;
    private javax.swing.JButton jbTransferFunds;
    private javax.swing.JButton jbWithdrawl;
    private javax.swing.JLabel jlAccount;
    private javax.swing.JLabel jlBalance;
    private javax.swing.JLabel jlCustomer;
    private javax.swing.JLabel jlLoggedInAs;
    private javax.swing.JPanel jpButtons;
    private javax.swing.JPanel jpMain;
    // End of variables declaration//GEN-END:variables
}
