
package Employee;


import config.Session;
import config.dbConnector;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class EmployeeUpdateProfile extends javax.swing.JFrame {

    
    public EmployeeUpdateProfile() {
        initComponents();
    }

    
    //check if username exist
    public static boolean checkUserName(String username, int ID){
        dbConnector dbc = new dbConnector();
        try{
            String query = "SELECT * FROM employee WHERE e_username = '"+username+"' AND e_id != '" + ID + "'";
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
    //get data from database and set to session
    public void getDetails(int id){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM employee  WHERE e_id = '" + id + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()) {
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
            }
        }catch (SQLException ex) {
            System.out.println("Invalid Connection" + ex.getMessage());            
        }
    }
    //set userdata to UserUpdateProfile
    public void setDetails(){
        Session session = Session.getInstance();
        jFullName.setText("" + session.getFullname());
        jContactNumber.setText("" + session.getContactNumber());
        jBirthdate.setDate(session.getBirthdate());
        jGender.setSelectedItem(session.getGender());
        jAddress.setText("" + session.getAddress());
        jPosition.setSelectedItem(session.getPosition());
        jUsername.setText("" + session.getUsername());
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLoginButton = new javax.swing.JButton();
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
        jUsername = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EMPLOYEE UPDATE PROFILE");

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel2.setLayout(null);

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
        jLoginButton.setBounds(410, 380, 220, 30);

        jRegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRegisterButton.setText("SAVE CHANGES");
        jRegisterButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jRegisterButton.setFocusPainted(false);
        jRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterButtonActionPerformed(evt);
            }
        });
        jPanel2.add(jRegisterButton);
        jRegisterButton.setBounds(160, 380, 220, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("UPDATE PROFILE INFORMATION");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(260, 100, 290, 25);

        jFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jFullName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jFullName);
        jFullName.setBounds(60, 160, 240, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Full Name");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(60, 190, 70, 20);

        jContactNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jContactNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jContactNumber);
        jContactNumber.setBounds(60, 230, 240, 30);

        jContactNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jContactNumberLabel.setText("Contact Number");
        jPanel2.add(jContactNumberLabel);
        jContactNumberLabel.setBounds(60, 260, 110, 20);

        jPosition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee" }));
        jPosition.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jPosition);
        jPosition.setBounds(560, 230, 180, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Gender");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(560, 190, 90, 20);

        jBirthdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jBirthdate.setDateFormatString("MM-dd- yyyy");
        jBirthdate.setPreferredSize(new java.awt.Dimension(71, 26));
        jPanel2.add(jBirthdate);
        jBirthdate.setBounds(320, 160, 220, 30);

        jBirthday.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBirthday.setText("Birthday");
        jPanel2.add(jBirthday);
        jBirthday.setBounds(340, 190, 90, 20);

        jAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jAddress);
        jAddress.setBounds(60, 300, 680, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Position");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(560, 260, 90, 20);

        jGender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jGender);
        jGender.setBounds(560, 160, 180, 30);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Username");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(320, 260, 90, 20);

        jUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel2.add(jUsername);
        jUsername.setBounds(320, 230, 220, 30);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Address");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(60, 330, 90, 20);

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
        EmployeeAccountProfile EP = new EmployeeAccountProfile();
        EP.setVisible(true);
        EP.pack();
        EP.setLocationRelativeTo(null);
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
        Session session = Session.getInstance();
        int id = session.getId();
        
        //check if all textfields is empty
        if(fullname.isEmpty() || contactnumber.isEmpty() || address.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all fields");
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
        //check if username exist
        if(checkUserName(username,id)){
            JOptionPane.showMessageDialog(null, "Username already exist");
            return;
        }
        //check if birthdate is valid or empty
        if(jBirthdate.getDate() == null){
            JOptionPane.showMessageDialog(null,"Invalid date");
            return;
        }else{
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            birthday = dateformat.format(jBirthdate.getDate());
        }
        
        
        //update data to database
        dbConnector dbc = new dbConnector();
        String query = "UPDATE employee SET "
                + "e_fullname = '" + fullname + "', "
                + "e_contactnumber = '"+ contactnumber +"', "
                + "e_birthday = '"+ birthday +"', "
                + "e_gender = '"+ gender +"', "
                + "e_address = '"+ address +"', "
                + "e_username = '"+ username +"', "
                + "e_position = '"+ position +"' "
                + "WHERE e_id = '"+ id +"'";
        if(dbc.insertData(query)){
            JOptionPane.showMessageDialog(null, "Register Successfully");
            getDetails(id);//update data to session
            EmployeeAccountProfile ap = new EmployeeAccountProfile();
            ap.setVisible(true);
            ap.pack();
            ap.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(EmployeeUpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

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
    private javax.swing.JTextField jContactNumber;
    private javax.swing.JLabel jContactNumberLabel;
    private javax.swing.JTextField jFullName;
    private javax.swing.JComboBox<String> jGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jPosition;
    private javax.swing.JButton jRegisterButton;
    private javax.swing.JTextField jUsername;
    // End of variables declaration//GEN-END:variables
}
