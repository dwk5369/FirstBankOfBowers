/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexander
 */
public class ATM_Welcome_JPanel extends javax.swing.JPanel{

    /**
     * Creates new form ATM_Welcome_JPanel
     */
    ATM_Methods AtmM = new ATM_Methods();
    ATMInterface ATMI;
    public ATM_Welcome_JPanel(ATMInterface ATMIget) {
        ATMI = ATMIget;
        initComponents();
        //try catch on startup to get user info, if incorrect default
        try{
            Jlabel_Welcome.setText(AtmM.getUserInfoFname());
           
        } catch (Exception e){Jlabel_Welcome.setText("Welcome Back!!");}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jlabel_Welcome = new javax.swing.JLabel();
        bDeposit = new javax.swing.JButton();
        bWithdrawal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bBalance = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        Jlabel_Welcome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Jlabel_Welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Jlabel_Welcome.setText("Welcome Back!!!");

        bDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDepositActionPerformed(evt);
            }
        });

        bWithdrawal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bWithdrawalActionPerformed(evt);
            }
        });

        jLabel1.setText("Withdrawal");

        jLabel2.setText("Deposit");

        bBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBalanceActionPerformed(evt);
            }
        });

        jLabel3.setText("Account Balance");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jlabel_Welcome, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bWithdrawal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(Jlabel_Welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bWithdrawal, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(bBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bDeposit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(128, 128, 128))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bWithdrawalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bWithdrawalActionPerformed
        // TODO add your handling code here:
        ATMI.setContentPane(ATMI.jWith);
       
        
    }//GEN-LAST:event_bWithdrawalActionPerformed

    private void bBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBalanceActionPerformed
        // TODO add your handling code here:
        ATMI.setContentPane(ATMI.jBala);
    }//GEN-LAST:event_bBalanceActionPerformed

    private void bDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDepositActionPerformed
        // TODO add your handling code here:
        ATMI.setContentPane(ATMI.jDepo);
    }//GEN-LAST:event_bDepositActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel_Welcome;
    private javax.swing.JButton bBalance;
    private javax.swing.JButton bDeposit;
    private javax.swing.JButton bWithdrawal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
