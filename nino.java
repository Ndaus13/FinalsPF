import java.sql.*;
import java.util.Vector;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class nino extends javax.swing.JFrame {

    /**
     * Creates new form nino
     */
    public nino() {
        initComponents();
        Connect();
        LoadProductNo();
        Fetch();
    }

  Connection con;
  PreparedStatement pst;
  ResultSet rs;
  
  
  public void Connect(){
      try{
          Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost/ninodb","root","");
      }catch(ClassNotFoundException ex){
            Logger.getLogger(nino.class.getName()).log(Level.SEVERE,null,ex);
      } catch (SQLException ex) {
            Logger.getLogger(nino.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
  public void LoadProductNo(){
      
        try {
            pst= con.prepareStatement("SELECT Id FROM noni_tbl");
            rs= pst.executeQuery();
            txtpid.removeAllItems();
            while(rs.next()){
                txtpid.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(nino.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
  public void Fetch(){
        try {
            int q;
            pst=con.prepareStatement("SELECT * FROM noni_tbl");
            rs=pst.executeQuery();
            ResultSetMetaData rss=rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2= new Vector();
                for(int a=1; a<=q;a++){
                    v2.add(rs.getString("Id"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Brand"));
                    v2.add(rs.getString("Unit"));
                    v2.add(rs.getString("Quantity"));
                    v2.add(rs.getString("Payment"));
                }
                df.addRow(v2);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(nino.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        brand = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        Unit = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtquantity = new javax.swing.JTextField();
        txtpayment = new javax.swing.JTextField();
        txtpid = new javax.swing.JComboBox<>();
        searching = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setText("Sold Motor Inventory System");

        id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        id.setText("ID:");

        name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name.setText("Name:");

        brand.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        brand.setText("Brand:");

        Unit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Unit.setText("Unit Model ");

        txtUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitActionPerformed(evt);
            }
        });

        btnAdd.setBackground(java.awt.Color.green);
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearch.setBackground(java.awt.Color.green);
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(java.awt.Color.green);
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(java.awt.Color.green);
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Brand", "Unit Model", "Quantity", "Payment"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Quantity");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Payment");

        txtpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpaymentActionPerformed(evt);
            }
        });

        txtpid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        txtpid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpidActionPerformed(evt);
            }
        });

        searching.setText("Searching:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(302, 302, 302)
                                .addComponent(title))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(searching)
                                .addGap(34, 34, 34)
                                .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(brand)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUnit))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Unit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtquantity))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpayment)))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searching))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(brand)
                            .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Unit)
                            .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            // TODO add your handling code here:
            String Id=txtId.getText();
            String Name=txtName.getText();
            String Brand =txtBrand.getText();
            String Unit=txtUnit.getText();
            String Quantity=txtquantity.getText();
            String Payment=txtpayment.getText();
            
            
            pst= con.prepareStatement("INSERT INTO noni_tbl(Id,Name,Brand,Unit,Quantity,Payment)VALUES(?,?,?,?,?,?)");
            pst.setString(1, Id);
            pst.setString(2, Name);
            pst.setString(3, Brand);
            pst.setString(4, Unit);
            pst.setString(5, Quantity);
            pst.setString(6, Payment);
            
            int k=pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "Record Added Successfully");
                txtId.setText("");
                txtName.setText("");
                txtBrand.setText("");
                txtUnit.setText("");
                txtquantity.setText("");
                txtpayment.setText("");
                Fetch();
                LoadProductNo();
            }else{
                 JOptionPane.showMessageDialog(this, "Record faied to add");
                
            }
            
                
        } catch (SQLException ex) {
            Logger.getLogger(nino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            // TODO add your handling code here:
            
            String pid= txtpid.getSelectedItem().toString();
            
            pst =con.prepareStatement("SELECT * FROM noni_tbl WHERE Id =?");
            pst.setString(1,pid);
            rs= pst.executeQuery();
            
            if(rs.next()==true){
                txtName.setText(rs.getString (2));
                txtBrand.setText(rs.getString (3));
                txtUnit.setText(rs.getString (4));
                txtquantity.setText(rs.getString (5));
                txtpayment.setText(rs.getString (6));
                
            }else{
                 JOptionPane.showMessageDialog(this, "No Record Found Parang di nag Grade 2 !!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(nino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            // TODO add your handling code here:
            String Name=txtName.getText();
            String Brand=txtBrand.getText();
            String Unit=txtUnit.getText();
            String Quantity=txtquantity.getText();
            String Payment=txtpayment.getText();
            
            String pid=txtpid.getSelectedItem().toString()  ;
            
            pst=con.prepareStatement("UPDATE noni_tbl SET Name=?,Brand=?,Unit=?,Quantity=?,Payment=? WHERE Id=?" );
           
           
             pst.setString(1,Name);
             pst.setString(2,Brand);
             pst.setString(3,Unit);
             pst.setString(4,Quantity);
             pst.setString(5,Payment);
             pst.setString(6,pid);    
                 int k=pst.executeUpdate();
                 if(k==1){
                     JOptionPane.showMessageDialog(this, "Record has been Updated Succesfully!");
                     txtName.setText("");
                     txtBrand.setText("");
                     txtUnit.setText("");
                     txtquantity.setText("");
                     txtpayment.setText("");
                     txtName.requestFocus();
                     Fetch();
                LoadProductNo();
                
                 }
            
        } catch (SQLException ex) {
            Logger.getLogger(nino.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // TODO add your handling code here:
            String pid=txtpid.getSelectedItem().toString();
            
            pst=con.prepareStatement("DELETE FROM noni_tbl WHERE Id=?");
            
            pst.setString(1,pid);
             int k=pst.executeUpdate();
             if(k==1){
                JOptionPane.showMessageDialog(this, "Record has been Deleted Succesfully!");
                
                 txtName.setText("");
                     txtBrand.setText("");
                     txtUnit.setText("");
                     txtquantity.setText("");
                     txtpayment.setText("");
                     txtName.requestFocus();
                     Fetch();
                LoadProductNo();
                
             }else{
                 JOptionPane.showMessageDialog(this, "Record Failed  Deleted ");
             }
        } catch (SQLException ex) {
            Logger.getLogger(nino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaymentActionPerformed

    private void txtpidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpidActionPerformed

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
            java.util.logging.Logger.getLogger(nino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logInForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Unit;
    private javax.swing.JLabel brand;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel searching;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtUnit;
    private javax.swing.JTextField txtpayment;
    private javax.swing.JComboBox<String> txtpid;
    private javax.swing.JTextField txtquantity;
    // End of variables declaration//GEN-END:variables
}
