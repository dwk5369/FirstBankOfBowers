
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
 * @author Alexander
 */
public class ATM_Main_JPanel extends javax.swing.JPanel {

    /**
     * Creates new form ATM_Main_Jpanel
     */
    ATMInterface ATMI;
    
    public ATM_Main_JPanel(ATMInterface ATMIget) {
        ATMI = ATMIget;
        initComponents();
        try{
            Jlabel_Welcome.setText(ATMI.AtmM.getUserInfoFname());
           
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

        Jlabel_Insert = new javax.swing.JLabel();
        Jlabel_Welcome = new javax.swing.JLabel();
        jtfAccount = new javax.swing.JTextField();
        bInitialize = new javax.swing.JButton();

        Jlabel_Insert.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Jlabel_Insert.setText("Insert Card To Begin!");

        Jlabel_Welcome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Jlabel_Welcome.setText("Welcome To The First Bank of Bowers!");

        bInitialize.setText("GO!");
        bInitialize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInitializeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addComponent(Jlabel_Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(Jlabel_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jtfAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(bInitialize)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(Jlabel_Welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(Jlabel_Insert)
                .addGap(18, 18, 18)
                .addComponent(jtfAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bInitialize)
                .addGap(111, 111, 111))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bInitializeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInitializeActionPerformed
        ATMI.acctNum = (jtfAccount.getText().trim());
        ATMI.trans.connect();
        int intacctNum = Integer.parseInt(ATMI.acctNum);
        Account userAcct = ATMI.trans.getAccount(intacctNum);
        ATMI.cPin = ATMI.trans.getCustPin(jtfAccount.getText().trim());
        JOptionPane.showInputDialog(ATMI, "Please Enter Your Pin", "1234");
        ATMI.AtmM.setAccountBalance(ATMI.trans.getAccBal(ATMI.acctNum));
        
        ATMI.trans.disconnect();
        if(userAcct != null && ATMI.cPin != null)
        {   
            ATMI.trans.connect();            
            ATMI.AtmM.setUserInfoFname(ATMI.trans.getCustFName(ATMI.acctNum,ATMI.cPin));
            ATMI.jBala.setLabelName(ATMI.AtmM.getUserInfoFname());
            ATMI.jBala.setLabelBalance("$" + new BigDecimal(ATMI.AtmM.getAccountBalance()).setScale(2, RoundingMode.UP));
            System.out.println("username: " + ATMI.acctNum + " pin: " + ATMI.cPin + " account: " + userAcct + " Name: " + ATMI.AtmM.getUserInfoFname());
            ATMI.setContentPane(ATMI.jWelc);
            ATMI.repaint(); 
            ATMI.pack();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Your card was not recognized", "ATM Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bInitializeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel_Insert;
    private javax.swing.JLabel Jlabel_Welcome;
    private javax.swing.JButton bInitialize;
    private javax.swing.JTextField jtfAccount;
    // End of variables declaration//GEN-END:variables
}
