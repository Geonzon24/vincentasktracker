
package Manager;


import config.dbConnector;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class AddEmployee extends javax.swing.JFrame {

    
    public AddEmployee() {
        initComponents();
    }

    //check if username exist
    public static boolean checkUserName(String username){
        dbConnector dbc = new dbConnector();
        try{
            String query = "SELECT * FROM employee WHERE e_username = '"+username+"'";
            ResultSet rst = dbc.getData(query);
            return rst.next();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jUsername = new javax.swing.JTextField();
        jLoginButton = new javax.swing.JButton();
        jConfirmPasswordField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPassword = new javax.swing.JLabel();
        jConfirmPassword = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jRegisterButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jFullName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jContactNumber = new javax.swing.JTextField();
        jContactNumberLabel = new javax.swing.JLabel();
        jPosition = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jBirthdate = new com.toedter.calendar.JDateChooser();
        jBirthday = new javax.swing.JLabel();
        jAddress = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jGender = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADD EMPLOYEE");

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel2.setLayout(null);

        jUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jUsername);
        jUsername.setBounds(60, 290, 200, 30);

        jLoginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLoginButton.setForeground(new java.awt.Color(255, 0, 0));
        jLoginButton.setText("CANCEL");
        jLoginButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jLoginButton.setFocusPainted(false);
        jLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginButtonActionPerformed(evt);
            }
        });
        jPanel2.add(jLoginButton);
        jLoginButton.setBounds(400, 390, 220, 30);

        jConfirmPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jConfirmPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jConfirmPasswordField);
        jConfirmPasswordField.setBounds(520, 290, 220, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Username");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(60, 320, 70, 20);

        jPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPassword.setText("Password");
        jPanel2.add(jPassword);
        jPassword.setBounds(280, 320, 70, 20);

        jConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jConfirmPassword.setText("Confirm Password");
        jPanel2.add(jConfirmPassword);
        jConfirmPassword.setBounds(520, 320, 120, 20);

        jPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jPasswordField);
        jPasswordField.setBounds(280, 290, 220, 30);

        jRegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRegisterButton.setText("ADD EMPLOYEE");
        jRegisterButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jRegisterButton.setFocusPainted(false);
        jRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterButtonActionPerformed(evt);
            }
        });
        jPanel2.add(jRegisterButton);
        jRegisterButton.setBounds(160, 390, 220, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("ADD NEW EMPLOYEE");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(300, 80, 200, 25);

        jFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jFullName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jFullName);
        jFullName.setBounds(60, 150, 200, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Full Name");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(60, 180, 70, 20);

        jContactNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jContactNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jContactNumber);
        jContactNumber.setBounds(280, 150, 160, 30);

        jContactNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jContactNumberLabel.setText("Contact Number");
        jPanel2.add(jContactNumberLabel);
        jContactNumberLabel.setBounds(280, 180, 110, 20);

        jPosition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee", "Manager" }));
        jPosition.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 174, 239), 1, true));
        jPanel2.add(jPosition);
        jPosition.setBounds(520, 220, 220, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Gender");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(620, 180, 90, 20);

        jBirthdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jBirthdate.setDateFormatString("MM-dd- yyyy");
        jBirthdate.setPreferredSize(new java.awt.Dimension(71, 26));
        jPanel2.add(jBirthdate);
        jBirthdate.setBounds(460, 150, 140, 30);

        jBirthday.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBirthday.setText("Birthday");
        jPanel2.add(jBirthday);
        jBirthday.setBounds(460, 180, 90, 20);

        jAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jAddress);
        jAddress.setBounds(60, 220, 440, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Position");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(520, 250, 90, 20);

        jGender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jGender);
        jGender.setBounds(620, 150, 120, 30);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Address");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(60, 250, 90, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/signup background.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        ListOfEmployee LE = new ListOfEmployee();
        LE.setVisible(true);
        LE.pack();
        LE.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLoginButtonActionPerformed

    private void jRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterButtonActionPerformed
        String fullname = jFullName.getText();
        String contactnumber = jContactNumber.getText();
        String birthday = null;
        String gender = (String)jGender.getSelectedItem();
        String address = jAddress.getText();
        String position = (String)jPosition.getSelectedItem();
        String username = jUsername.getText();
        String password = jPasswordField.getText();
        String repassword = jConfirmPasswordField.getText();
        String hashPassword = passwordHash(password); //hashpassword
        //check if all textfields is empty
        if(fullname.isEmpty() || contactnumber.isEmpty() || address.isEmpty() || username.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return;
        }
        //check if date is empty or valid
        if(jBirthdate.getDate() == null){
            JOptionPane.showMessageDialog(null,"Invalid date");
            return;
        }
        
        //check if contact number contain number
        if(!contactnumber.matches("\\d+")){
            JOptionPane.showMessageDialog(null,"Contact number should only contain digits.");
            return;
        }
        //Check if contact number length is not 11 digits
        if(contactnumber.length() != 11) {
            JOptionPane.showMessageDialog(null,"Contact number must be 11 digits.");
            return;
        }
        //check if password length is less than 8 characters
        if(password.length() < 8 || repassword.length() < 8){
            JOptionPane.showMessageDialog(null, "Password must at least 8 characters");
            return;
        }
        //check if password and confirm password does not match
        if(!password.equals(repassword)){
            JOptionPane.showMessageDialog(null, "Password does not match");
            return;
        }
        //check if username exist
        if(checkUserName(username)){
            JOptionPane.showMessageDialog(null, "Username already exist");
            return;
        }else{
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            birthday = dateformat.format(jBirthdate.getDate());
        }
        

        //insert data to database
        dbConnector dbc = new dbConnector();
        String query = "INSERT INTO employee ( e_fullname, e_contactnumber, e_birthday, e_gender, e_address, e_position, e_username, e_password, e_status) VALUES ("
                + "'" + fullname + "',"
                + "'"+ contactnumber +"',"
                + "'"+ birthday +"',"
                + "'"+ gender +"',"
                + "'"+ address +"',"
                + "'"+ position +"',"
                + "'"+ username +"',"
                + "'"+ hashPassword +"',"
                + "'inactive')";
        if(dbc.insertData(query)){
            JOptionPane.showMessageDialog(null, "Register Successfully");
            ListOfEmployee LE = new ListOfEmployee();
            LE.setVisible(true);
            LE.pack();
            LE.setLocationRelativeTo(null);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }//GEN-LAST:event_jRegisterButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAddress;
    private com.toedter.calendar.JDateChooser jBirthdate;
    private javax.swing.JLabel jBirthday;
    private javax.swing.JLabel jConfirmPassword;
    private javax.swing.JPasswordField jConfirmPasswordField;
    private javax.swing.JTextField jContactNumber;
    private javax.swing.JLabel jContactNumberLabel;
    private javax.swing.JTextField jFullName;
    private javax.swing.JComboBox<String> jGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jPassword;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JComboBox<String> jPosition;
    private javax.swing.JButton jRegisterButton;
    private javax.swing.JTextField jUsername;
    // End of variables declaration//GEN-END:variables
}
