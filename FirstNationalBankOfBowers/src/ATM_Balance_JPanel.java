
import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexander
 */
public class ATM_Balance_JPanel extends javax.swing.JPanel {

    /**
     * Creates new form ATM_Balance_JPanel
     */
    ATMInterface ATMI;
    
    
    public ATM_Balance_JPanel(ATMInterface ATMIget) {
        
        initComponents();
        ATMI = ATMIget;
       
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlAccBal = new javax.swing.JLabel();
        bBackBal = new javax.swing.JButton();
        bBalance = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome");

        jLabel2.setText("Account Balance is:");

        jlAccBal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlAccBal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAccBal.setText("Press Get Balance!");

        bBackBal.setBackground(new java.awt.Color(255, 0, 0));
        bBackBal.setText("Back");
        bBackBal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackBalActionPerformed(evt);
            }
        });

        bBalance.setText("Get Balance!");
        bBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBalanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bBackBal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(bBalance)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(212, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(243, 243, 243))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlAccBal)
                        .addGap(219, 219, 219))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(jlAccBal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(bBalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(bBackBal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bBackBalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackBalActionPerformed
        // TODO add your handling code here:
        ATMI.setContentPane(ATMI.jWelc);
        ATMI.repaint(); 
        ATMI.pack();
    }//GEN-LAST:event_bBackBalActionPerformed

    private void bBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBalanceActionPerformed
        // TODO add your handling code here:
        ATMI.trans.connect();
        ATMI.AtmM.setAccountBalance(ATMI.trans.getAccBal(ATMI.acctNum));
        System.out.println(ATMI.AtmM.getAccountBalance());
        ATMI.trans.disconnect();
        jlAccBal.setText("$" + new BigDecimal(ATMI.AtmM.getAccountBalance()).setScale(2, RoundingMode.UP));
        jlAccBal.repaint();   
    }//GEN-LAST:event_bBalanceActionPerformed
    
    public void setLabelName(String name)
    {
        jLabel1.setText(name);
    }

    public void setLabelBalance(String balance)
    {
        jlAccBal.setText(balance);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBackBal;
    private javax.swing.JButton bBalance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlAccBal;
    // End of variables declaration//GEN-END:variables
}
