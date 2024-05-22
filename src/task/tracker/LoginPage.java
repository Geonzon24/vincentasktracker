
package task.tracker;


import Employee.EmployeeDashboard;
import Manager.ManagerDashboard;
import config.Session;
import config.dbConnector;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class LoginPage extends javax.swing.JFrame {

    
    public LoginPage() {
        initComponents();
    }

    //function to get user position
    private static String loginAccount(String username, String password){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM employee  WHERE e_username = '" + username + "' AND e_password = '" + password + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()){
                //get user data and set data to session
                Session session = Session.getInstance();
                session.setId(resultSet.getInt("e_id"));
                session.setFullname("" + resultSet.getString("e_fullname"));
                session.setContactNumber("" + resultSet.getString("e_contactnumber"));
                session.setBirthdate(resultSet.getDate("e_birthday"));
                session.setGender("" + resultSet.getString("e_gender"));
                session.setAddress("" + resultSet.getString("e_address"));
                session.setPosition("" + resultSet.getString("e_position"));
                session.setUsername("" + resultSet.getString("e_username"));
                session.setPassword("" + resultSet.getString("e_password"));
                session.setStatus("" + resultSet.getString("e_status"));
                
                return resultSet.getString("e_position");
            }else{
                return null;
            }
        }catch (SQLException ex) {
            System.out.println("Invalid loginAccount Connection" + ex.getMessage());
            return null;
        }
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
    
    //function to get user status
    private static String loginStatus(String username, String password){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT e_status FROM employee  WHERE e_username = '" + username + "' AND e_password = '" + password + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()){
                return resultSet.getString("e_status");
            }else{
                return null;
            }
        }catch (SQLException ex) {
            System.out.println("Invalid loginStatus Connection" + ex.getMessage());
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jUsername = new javax.swing.JTextField();
        jShowPassword = new javax.swing.JCheckBox();
        jPassword = new javax.swing.JPasswordField();
        jLoginButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jRegisterButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 230, 70, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Username");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 170, 70, 20);

        jUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel1.add(jUsername);
        jUsername.setBounds(50, 190, 250, 30);

        jShowPassword.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jShowPassword.setText("Show Password");
        jShowPassword.setContentAreaFilled(false);
        jShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jShowPassword);
        jShowPassword.setBounds(190, 280, 110, 23);

        jPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel1.add(jPassword);
        jPassword.setBounds(50, 250, 250, 30);

        jLoginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLoginButton.setText("Login");
        jLoginButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jLoginButton.setFocusPainted(false);
        jLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jLoginButton);
        jLoginButton.setBounds(50, 310, 250, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("I don't have an account");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 410, 140, 18);

        jRegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRegisterButton.setForeground(new java.awt.Color(255, 0, 0));
        jRegisterButton.setText("Register");
        jRegisterButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jRegisterButton.setFocusPainted(false);
        jRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jRegisterButton);
        jRegisterButton.setBounds(190, 400, 110, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 350, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterButtonActionPerformed
        SignupPage SignupPageFrame = new SignupPage();
        SignupPageFrame.setVisible(true);
        SignupPageFrame.pack();
        SignupPageFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jRegisterButtonActionPerformed

    private void jLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginButtonActionPerformed
        String username = jUsername.getText();
        String password = passwordHash(jPassword.getText());
        
        String position = loginAccount(username,password);
        String status = loginStatus(username,password);
        
        if(position != null){
            if(status.equalsIgnoreCase("active")){
                if(position.equalsIgnoreCase("Manager")){
                    //if user is a team leader
                    JOptionPane.showMessageDialog(null, "Login Success");
                    ManagerDashboard MD = new ManagerDashboard();
                    MD.setVisible(true);
                    MD.pack();
                    MD.setLocationRelativeTo(null);
                    this.dispose();
                }else{
                    //if user is team member
                    JOptionPane.showMessageDialog(null, "Login Success");
                    EmployeeDashboard ED = new EmployeeDashboard();
                    ED.setVisible(true);
                    ED.pack();
                    ED.setLocationRelativeTo(null);
                    this.dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Account is InActive");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Wrong username and password");
        }
    }//GEN-LAST:event_jLoginButtonActionPerformed

    private void jShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowPasswordActionPerformed
        if(jShowPassword.isSelected()) {
            jPassword.setEchoChar((char)0);
        }else {
            jPassword.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_jShowPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JButton jRegisterButton;
    private javax.swing.JCheckBox jShowPassword;
    private javax.swing.JTextField jUsername;
    // End of variables declaration//GEN-END:variables
}
