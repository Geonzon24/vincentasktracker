
package Manager;


import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import task.tracker.LoginPage;


public class CreateTask extends javax.swing.JFrame {

    
    public CreateTask() {
        initComponents();
        populateComboBox();
    }
    
    private void clearFields() {
        jTaskName.setText(null);
        jTaskDeadline.setDate(null);
    }

    public void populateComboBox() {
        try {
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT e_fullname FROM employee");

            // Clear existing items in the JComboBox
            jAssignTo.removeAllItems();

            // Populate JComboBox with fetched employee names
            while (rs.next()) {
                String fullName = rs.getString("e_fullname");
                jAssignTo.addItem(fullName);
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }
    
    public int getEmployeeID(String name){
        dbConnector dbc = new dbConnector();
        try{
            String query = "SELECT e_id FROM employee WHERE e_fullname = '"+name+"'";
            ResultSet rs = dbc.getData(query);
            if(rs.next()){
                return rs.getInt("e_id");
            }else{
                return 0;
            }
        }catch(SQLException ex){
            System.out.println("" + ex.getMessage());
            return 0;
        }  
    }
    
    public void createTask(){
        String deadline = null;
        if(jTaskName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please fill in all fields");
            return;
        }
        if(jTaskDeadline.getDate() == null){
            JOptionPane.showMessageDialog(null,"Invalid date");
            return;
        }
        int employeeID = getEmployeeID((String)jAssignTo.getSelectedItem());
        //inserting data to database
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        deadline = dateformat.format(jTaskDeadline.getDate());
        dbConnector dbc = new dbConnector();
        String query = "INSERT INTO task (t_name, t_deadline, e_id, t_status, t_archive) VALUES ("
                + "'" + jTaskName.getText() + "',"
                + "'"+ deadline +"',"
                + "'"+ employeeID +"',"
                + "'PENDING',"
                + "'NO')";
        if(dbc.insertData(query)){
            JOptionPane.showMessageDialog(null, "Task created Successfully");
            ViewAllTaskPage VT = new ViewAllTaskPage();
            VT.setVisible(true);
            VT.pack();
            VT.setLocationRelativeTo(null);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTaskName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTaskDeadline = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jAssignTo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jHomeButton1 = new javax.swing.JButton();
        jHomeButton = new javax.swing.JButton();
        jLogoutButton = new javax.swing.JButton();
        jHomeButton4 = new javax.swing.JButton();
        jLogoutButton1 = new javax.swing.JButton();
        jLogoutButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jUserName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CREATE TASK PAGE");

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jTaskName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTaskName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jPanel1.add(jTaskName);
        jTaskName.setBounds(200, 190, 550, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Task Description");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(200, 220, 130, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("CREATE NEW TASK");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(200, 140, 170, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Assign To");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(420, 290, 90, 20);

        jTaskDeadline.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jTaskDeadline.setDateFormatString("yyyy-MM-dd");
        jTaskDeadline.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTaskDeadline.setPreferredSize(new java.awt.Dimension(71, 26));
        jPanel1.add(jTaskDeadline);
        jTaskDeadline.setBounds(200, 260, 190, 30);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 0));
        jButton1.setText("CANCEL");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jButton1.setPreferredSize(new java.awt.Dimension(73, 26));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(490, 370, 150, 26);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("ADD TASK");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jButton2.setPreferredSize(new java.awt.Dimension(73, 26));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(280, 370, 150, 26);

        jAssignTo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jAssignTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UserName" }));
        jAssignTo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        jPanel1.add(jAssignTo);
        jAssignTo.setBounds(420, 260, 330, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Task Deadline");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(200, 290, 90, 20);

        jHomeButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jHomeButton1.setText("PROFILE");
        jHomeButton1.setFocusPainted(false);
        jHomeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHomeButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jHomeButton1);
        jHomeButton1.setBounds(17, 173, 130, 25);

        jHomeButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jHomeButton.setText("HOME");
        jHomeButton.setFocusPainted(false);
        jHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHomeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jHomeButton);
        jHomeButton.setBounds(17, 150, 130, 25);

        jLogoutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLogoutButton.setForeground(new java.awt.Color(255, 0, 0));
        jLogoutButton.setText("LOGOUT");
        jLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jLogoutButton);
        jLogoutButton.setBounds(17, 267, 130, 25);

        jHomeButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jHomeButton4.setText("TASK");
        jHomeButton4.setFocusPainted(false);
        jHomeButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHomeButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jHomeButton4);
        jHomeButton4.setBounds(17, 196, 130, 25);

        jLogoutButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLogoutButton1.setText("EMPLOYEE");
        jLogoutButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jLogoutButton1);
        jLogoutButton1.setBounds(17, 243, 130, 25);

        jLogoutButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLogoutButton2.setText("ARCHIVE TASK");
        jLogoutButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jLogoutButton2);
        jLogoutButton2.setBounds(17, 219, 130, 25);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account (2).png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 10, 100, 90);

        jUserName.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jUserName.setText("ADMIN");
        jPanel1.add(jUserName);
        jUserName.setBounds(56, 100, 50, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/signup background.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViewAllTaskPage VT = new ViewAllTaskPage();
        VT.setVisible(true);
        VT.pack();
        VT.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        createTask();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jHomeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeButton1ActionPerformed
        ManagerAccountProfile MP = new ManagerAccountProfile();
        MP.setVisible(true);
        MP.pack();
        MP.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jHomeButton1ActionPerformed

    private void jHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeButtonActionPerformed
        ManagerDashboard DashboardPageFrame = new ManagerDashboard();
        DashboardPageFrame.setVisible(true);
        DashboardPageFrame.pack();
        DashboardPageFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jHomeButtonActionPerformed

    private void jLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutButtonActionPerformed
        LoginPage LoginFrame = new LoginPage();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLogoutButtonActionPerformed

    private void jHomeButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeButton4ActionPerformed
        ViewAllTaskPage UT = new ViewAllTaskPage();
        UT.setVisible(true);
        UT.pack();
        UT.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jHomeButton4ActionPerformed

    private void jLogoutButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutButton1ActionPerformed
        ListOfEmployee LE = new ListOfEmployee();
        LE.setVisible(true);
        LE.pack();
        LE.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLogoutButton1ActionPerformed

    private void jLogoutButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutButton2ActionPerformed
        ArchiveTask AT = new ArchiveTask();
        AT.setVisible(true);
        AT.pack();
        AT.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLogoutButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CreateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jAssignTo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jHomeButton;
    private javax.swing.JButton jHomeButton1;
    private javax.swing.JButton jHomeButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jLogoutButton;
    private javax.swing.JButton jLogoutButton1;
    private javax.swing.JButton jLogoutButton2;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jTaskDeadline;
    private javax.swing.JTextField jTaskName;
    private javax.swing.JLabel jUserName;
    // End of variables declaration//GEN-END:variables
}
