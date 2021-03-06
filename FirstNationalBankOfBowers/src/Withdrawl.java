
import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mjb6002
 */
public class Withdrawl extends javax.swing.JFrame {
 
    Transaction bankTrans;
    Account acctCurrent;
    Customer custCurrent;
    Teller currentUser;
    
    /**
     * Creates new form Withdraw
     * @param tell
     * @param trans
     * @param cust
     * @param acct
     */
    private Withdrawl() {
        initComponents();
        
    }
    
    public Withdrawl(Teller tell, Transaction trans, Customer cust, Account acct) {
        currentUser = tell;
        custCurrent = cust;
        acctCurrent = acct;
        bankTrans = trans;
           
        initComponents();
        
        jlCurrentAccount.setText("Current Account: " + acctCurrent.getAccountNumber());       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbExit = new javax.swing.JButton();
        jbWithdraw = new javax.swing.JButton();
        jtWithdraw = new javax.swing.JTextField();
        jlCurrentAccount = new javax.swing.JLabel();
        jlNotify = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbExit.setText("Exit");
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        jbWithdraw.setText("Withdraw");
        jbWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbWithdrawActionPerformed(evt);
            }
        });

        jtWithdraw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtWithdrawActionPerformed(evt);
            }
        });

        jlCurrentAccount.setText("Current Account:");

        jlNotify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbExit)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlCurrentAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbWithdraw)
                        .addGap(18, 18, 18)
                        .addComponent(jtWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlNotify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlCurrentAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbWithdraw)
                    .addComponent(jtWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlNotify, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        new MainScreen(currentUser,bankTrans,custCurrent,acctCurrent).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbExitActionPerformed

    private void jtWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtWithdrawActionPerformed
       
    }//GEN-LAST:event_jtWithdrawActionPerformed

    private void jbWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbWithdrawActionPerformed
       double amountWithdraw = Double.parseDouble(jtWithdraw.getText());
       bankTrans.connect();
       bankTrans.withdraw(acctCurrent.getAccountNumber(), amountWithdraw);
       bankTrans.disconnect();
       jlNotify.setText("$" + new BigDecimal(amountWithdraw).setScale(2, RoundingMode.UP) + " Withdrawn");
       acctCurrent.balance = acctCurrent.getBalance() - amountWithdraw;
       
    }//GEN-LAST:event_jbWithdrawActionPerformed

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
            java.util.logging.Logger.getLogger(Withdrawl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Withdrawl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Withdrawl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Withdrawl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Withdrawl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbWithdraw;
    private javax.swing.JLabel jlCurrentAccount;
    private javax.swing.JLabel jlNotify;
    private javax.swing.JTextField jtWithdraw;
    // End of variables declaration//GEN-END:variables
}
