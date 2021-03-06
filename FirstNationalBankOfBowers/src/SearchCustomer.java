
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwk5369
 */
public class SearchCustomer extends javax.swing.JFrame {

    Transaction bankTrans;
    Account acctCurrent;
    Customer custCurrent;
    Teller currentUser;    
    DefaultListModel dlmCustomer;
    ListSelectionListener lslFun;
    
    /**
     * Creates new form SearchCustomer
     */
    public SearchCustomer() {
        initComponents();
    }

    public SearchCustomer(Transaction bankTrans, Account acctCurrent, Customer custCurrent, Teller currentUser) throws HeadlessException {
        this.bankTrans = bankTrans;
        this.acctCurrent = acctCurrent;
        this.custCurrent = custCurrent;
        this.currentUser = currentUser;
        dlmCustomer = new DefaultListModel();

        initComponents();
        
        lslFun = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) 
            {
                Customer cust = (Customer)jlMatchingCust.getSelectedValue();
                jlCustFname.setText(cust.getFname());
                jlCustLname.setText(cust.getLname());
                jlCustAddress.setText(cust.getAddress());
                jlCustCity.setText(cust.getCity());
                jlCustState.setText(cust.getState());
                jlCustZIP.setText(cust.getZipcode());
                jlCustEmail.setText(cust.getEmail());
            }
        };
        jlMatchingCust.addListSelectionListener(lslFun);        
        
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSearch = new javax.swing.ButtonGroup();
        jpCustomerInfo = new javax.swing.JPanel();
        jbContinue = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlMatchingCust = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jbClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlCustFname = new javax.swing.JLabel();
        jlCustAddress = new javax.swing.JLabel();
        jlCustLname = new javax.swing.JLabel();
        jlCustCity = new javax.swing.JLabel();
        jlCustState = new javax.swing.JLabel();
        jlCustZIP = new javax.swing.JLabel();
        jlCustEmail = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlFirstName = new javax.swing.JLabel();
        jtfSSN = new javax.swing.JTextField();
        jtfLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jlSSN = new javax.swing.JLabel();
        jrbName = new javax.swing.JRadioButton();
        jlLastName = new javax.swing.JLabel();
        jbSearch = new javax.swing.JButton();
        jrbSSN = new javax.swing.JRadioButton();
        jtfFirstName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search For Customer");

        jpCustomerInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbContinue.setText("Continue");
        jbContinue.setEnabled(false);
        jbContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbContinueActionPerformed(evt);
            }
        });

        jlMatchingCust.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jlMatchingCust);

        jLabel4.setText("Matching Customers");

        jbClear.setText("Clear List");
        jbClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClearActionPerformed(evt);
            }
        });

        jLabel1.setText("Customer Info:");

        jlCustState.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jlCustZIP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jlCustEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jpCustomerInfoLayout = new javax.swing.GroupLayout(jpCustomerInfo);
        jpCustomerInfo.setLayout(jpCustomerInfoLayout);
        jpCustomerInfoLayout.setHorizontalGroup(
            jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCustomerInfoLayout.createSequentialGroup()
                .addGroup(jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpCustomerInfoLayout.createSequentialGroup()
                        .addGroup(jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCustomerInfoLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel4))
                            .addGroup(jpCustomerInfoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCustomerInfoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlCustAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jpCustomerInfoLayout.createSequentialGroup()
                                        .addComponent(jlCustFname, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlCustLname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCustomerInfoLayout.createSequentialGroup()
                                        .addComponent(jlCustCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jpCustomerInfoLayout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jlCustEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jpCustomerInfoLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jlCustState, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jlCustZIP, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jpCustomerInfoLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(jLabel1)
                                .addGap(0, 208, Short.MAX_VALUE))))
                    .addGroup(jpCustomerInfoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jbClear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jpCustomerInfoLayout.setVerticalGroup(
            jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCustomerInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCustomerInfoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbContinue)
                            .addComponent(jbClear))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCustomerInfoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCustFname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCustLname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlCustAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCustomerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCustCity, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCustState, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCustZIP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlCustEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );

        jlFirstName.setText("First Name:");

        jtfSSN.setEnabled(false);

        jLabel5.setText("Search By:");

        jlSSN.setText("Social Security:");

        bgSearch.add(jrbName);
        jrbName.setSelected(true);
        jrbName.setText("Name");
        jrbName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNameActionPerformed(evt);
            }
        });

        jlLastName.setText("Last Name:");

        jbSearch.setText("Search");
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        bgSearch.add(jrbSSN);
        jrbSSN.setText("SSN");
        jrbSSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSSNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlSSN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfSSN, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jrbName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbSSN))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlFirstName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlLastName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jrbName)
                    .addComponent(jrbSSN))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFirstName)
                    .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlLastName)
                    .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSSN)
                    .addComponent(jtfSSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbSearch)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCustomerInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpCustomerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbSSNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSSNActionPerformed
        jtfSSN.setEnabled(true);
        jtfFirstName.setEnabled(false);
        jtfLastName.setEnabled(false);
    }//GEN-LAST:event_jrbSSNActionPerformed

    private void jrbNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNameActionPerformed
        jtfSSN.setEnabled(false);
        jtfFirstName.setEnabled(true);
        jtfLastName.setEnabled(true);
    }//GEN-LAST:event_jrbNameActionPerformed

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        String strSSN;
        String strFname;
        String strLname;
        bankTrans.connect();
        dlmCustomer.removeAllElements();
        if(jrbSSN.isSelected())
        {
            strSSN = jtfSSN.getText();
            Customer cust = bankTrans.getCustomerInfo(strSSN);
            dlmCustomer.addElement(cust);
        }
        else
        {
            strFname = jtfFirstName.getText();
            strLname = jtfLastName.getText();
            ArrayList<Customer> custs = bankTrans.searchCustomerInfo(strLname, strLname);
            for(Customer c : custs)
                dlmCustomer.addElement(c);
        }
        jlMatchingCust.setModel(dlmCustomer);
        jbContinue.setEnabled(true);
        bankTrans.disconnect();
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jbClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearActionPerformed
        jlMatchingCust.removeListSelectionListener(lslFun);
        dlmCustomer.removeAllElements();
        jbContinue.setEnabled(false);
        jlMatchingCust.addListSelectionListener(lslFun);
        jlCustFname.setText("");
        jlCustLname.setText("");
        jlCustAddress.setText("");
        jlCustCity.setText("");
        jlCustState.setText("");
        jlCustZIP.setText("");
        jlCustEmail.setText("");
    }//GEN-LAST:event_jbClearActionPerformed

    private void jbContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbContinueActionPerformed
        custCurrent = (Customer) jlMatchingCust.getSelectedValue();
        new MainScreen(currentUser,bankTrans,custCurrent,acctCurrent).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbContinueActionPerformed

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
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbClear;
    private javax.swing.JButton jbContinue;
    private javax.swing.JButton jbSearch;
    private javax.swing.JLabel jlCustAddress;
    private javax.swing.JLabel jlCustCity;
    private javax.swing.JLabel jlCustEmail;
    private javax.swing.JLabel jlCustFname;
    private javax.swing.JLabel jlCustLname;
    private javax.swing.JLabel jlCustState;
    private javax.swing.JLabel jlCustZIP;
    private javax.swing.JLabel jlFirstName;
    private javax.swing.JLabel jlLastName;
    private javax.swing.JList jlMatchingCust;
    private javax.swing.JLabel jlSSN;
    private javax.swing.JPanel jpCustomerInfo;
    private javax.swing.JRadioButton jrbName;
    private javax.swing.JRadioButton jrbSSN;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfSSN;
    // End of variables declaration//GEN-END:variables
}
