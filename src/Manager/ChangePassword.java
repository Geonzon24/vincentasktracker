
package Manager;


import config.Session;
import config.dbConnector;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ChangePassword extends javax.swing.JFrame {

    
    public ChangePassword() {
        initComponents();
    }

    
    
    
    //function to hash password
    public String passwordHash(String password){
        try{
            MessageDigest messagedigest = MessageDigest.getInstance("SHA");
            byte[] hashbyte = messagedigest.digest(password.getBytes());
            StringBuilder stringbuilder = new StringBuilder();
            
            for(byte bytes : hashbyte){
                stringbuilder.append(String.format("%02x",bytes));
            }
            
            return stringbuilder.toString();
        }catch(Exception ex){
            System.out.println("Password Hash Error: " + ex.getMessage() );
            return null;
        }
    }
    //get data from database and set data to session
    public void getDetails(int id){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM employee  WHERE e_id = '" + id + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()) {
                Session session = Session.getInstance();
                session.setPassword("" + resultSet.getString("e_password"));
            }
        }catch (SQLException ex) {
            System.out.println("Invalid Connection" + ex.getMessage());            
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jUsername = new javax.swing.JTextField();
        jLoginButton = new javax.swing.JButton();
        jNewPasswordField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPassword = new javax.swing.JLabel();
        jConfirmPassword = new javax.swing.JLabel();
        jOldPassword = new javax.swing.JPasswordField();
        jRegisterButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jConfirmNewPassword = new javax.swing.JPasswordField();
        jConfirmPassword1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHANGE PASSWORD");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel2.setLayout(null);

        jUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jPanel2.add(jUsername);
        jUsername.setBounds(60, 180, 220, 30);

        jLoginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLoginButton.setForeground(new java.awt.Color(255, 0, 0));
        jLoginButton.setText("CANCEL");
        jLoginButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jLoginButton.setFocusPainted(false);
        jLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginButtonActionPerformed(evt);
            }
        });
        jPanel2.add(jLoginButton);
        jLoginButton.setBounds(300, 350, 220, 30);

        jNewPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jNewPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jPanel2.add(jNewPasswordField);
        jNewPasswordField.setBounds(60, 260, 220, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Username");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(60, 210, 70, 20);

        jPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPassword.setText("Old Password");
        jPanel2.add(jPassword);
        jPassword.setBounds(300, 210, 100, 20);

        jConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jConfirmPassword.setText("New Password");
        jPanel2.add(jConfirmPassword);
        jConfirmPassword.setBounds(60, 290, 120, 20);

        jOldPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jOldPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jPanel2.add(jOldPassword);
        jOldPassword.setBounds(300, 180, 220, 30);

        jRegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRegisterButton.setText("SAVE CHANGES");
        jRegisterButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jRegisterButton.setFocusPainted(false);
        jRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterButtonActionPerformed(evt);
            }
        });
        jPanel2.add(jRegisterButton);
        jRegisterButton.setBounds(60, 350, 220, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("UPDATE PASSWORD");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(210, 110, 190, 25);

        jConfirmNewPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jConfirmNewPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jPanel2.add(jConfirmNewPassword);
        jConfirmNewPassword.setBounds(300, 260, 220, 30);

        jConfirmPassword1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jConfirmPassword1.setText("Confirm New Password");
        jPanel2.add(jConfirmPassword1);
        jConfirmPassword1.setBounds(300, 290, 160, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pass background.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 580, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginButtonActionPerformed
        ManagerAccountProfile MP = new ManagerAccountProfile();
        MP.setVisible(true);
        MP.pack();
        MP.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLoginButtonActionPerformed

    private void jRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterButtonActionPerformed
        Session session = Session.getInstance();
        String password = session.getPassword();//password in database  
        String hashPassword = passwordHash(jOldPassword.getText()); //hashpassword from old password textfield
        String newPassword = jNewPasswordField.getText();
        String confirmNewPassword = jConfirmNewPassword.getText();
        String newPasswordHash = passwordHash(newPassword); //new hashpassword
        int ID = session.getId();
        
        //check if all fields is empty
        if(newPassword.isEmpty() || confirmNewPassword.isEmpty() || jOldPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return;
        }
        //check if password length is less than 8 characters
        if((newPassword.length() < 8) || (confirmNewPassword.length() < 8)){
            JOptionPane.showMessageDialog(null, "Password must at least 8 characters");
            return;
        }
        //check if old password is correct
        if(!password.equals(hashPassword)){
            JOptionPane.showMessageDialog(null, "Incorrect Old Password");
            return;
        }
        //check if new password and new confirm password does not match
        if(!newPassword.equals(confirmNewPassword)){
            JOptionPane.showMessageDialog(null, "New Password and Confirm Password does not match");
            return;
        }
        
        //update password data to database
        dbConnector dbc = new dbConnector();
        String query = "UPDATE employee SET "
                + "e_password = '"+ newPasswordHash +"' "
                + "WHERE e_id = '"+ ID +"'";
        if(dbc.insertData(query)){
            JOptionPane.showMessageDialog(null, "Update Successfully");
            getDetails(ID);
            ManagerAccountProfile ap = new ManagerAccountProfile();
            ap.setVisible(true);
            ap.pack();
            ap.setLocationRelativeTo(null);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }//GEN-LAST:event_jRegisterButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session session = Session.getInstance();
        jUsername.setText(session.getUsername());
        jUsername.setEditable(false);
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField jConfirmNewPassword;
    private javax.swing.JLabel jConfirmPassword;
    private javax.swing.JLabel jConfirmPassword1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPasswordField jNewPasswordField;
    private javax.swing.JPasswordField jOldPassword;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jPassword;
    private javax.swing.JButton jRegisterButton;
    private javax.swing.JTextField jUsername;
    // End of variables declaration//GEN-END:variables
}
