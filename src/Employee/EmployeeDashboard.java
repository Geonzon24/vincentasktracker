

package Employee;

import config.Session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import task.tracker.LoginPage;


public class EmployeeDashboard extends javax.swing.JFrame {

    /** Creates new form UserDashboard */
    public EmployeeDashboard() {
        initComponents();
    }

    
    //get number of finished task
    public int numberOfFinishedTask() {
        Session session = Session.getInstance();
        int id = session.getId();
        int studentCount = 0;
        dbConnector dbc = new dbConnector();
        try {
            String query = "SELECT COUNT(*) AS t_count FROM task WHERE t_archive = 'NO' AND t_status = 'FINISHED' AND e_id = '"+id+"'";
            ResultSet resultset = dbc.getData(query);
            if (resultset.next()) {
                studentCount = resultset.getInt("t_count");
                resultset.close();
            }
        } catch (SQLException ex) {
            System.err.println("Error fetching task count: " + ex.getMessage());
        }
        return studentCount;
    }
    
    //get number of pending task
    public int numberOfPendingTask() {
        Session session = Session.getInstance();
        int id = session.getId();
        int studentCount = 0;
        dbConnector dbc = new dbConnector();
        try {
            String query = "SELECT COUNT(*) AS t_count FROM task WHERE t_archive = 'NO' AND t_status = 'PENDING' AND e_id = '"+id+"'";
            ResultSet resultset = dbc.getData(query);
            if (resultset.next()) {
                studentCount = resultset.getInt("t_count");
                resultset.close();
            }
        } catch (SQLException ex) {
            System.err.println("Error fetching task count: " + ex.getMessage());
        }
        return studentCount;
    }
    //get number of on-going task
    public int numberOfOnGoingTask() {
        Session session = Session.getInstance();
        int id = session.getId();
        int studentCount = 0;
        dbConnector dbc = new dbConnector();
        try {
            String query = "SELECT COUNT(*) AS t_count FROM task WHERE t_archive = 'NO' AND t_status = 'ON-GOING' AND e_id = '"+id+"'";
            ResultSet resultset = dbc.getData(query);
            if (resultset.next()) {
                studentCount = resultset.getInt("t_count");
                resultset.close();
            }
        } catch (SQLException ex) {
            System.err.println("Error fetching task count: " + ex.getMessage());
        }
        return studentCount;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jHomeButton2 = new javax.swing.JButton();
        jHomeButton = new javax.swing.JButton();
        jHomeButton4 = new javax.swing.JButton();
        jLogoutButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jFinished = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jOngoing = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPending = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jUserName1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EMPLOYEE DASHBOARD");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jHomeButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jHomeButton2.setText("PROFILE");
        jHomeButton2.setFocusPainted(false);
        jHomeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHomeButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jHomeButton2);
        jHomeButton2.setBounds(17, 173, 130, 25);

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

        jLogoutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLogoutButton.setForeground(new java.awt.Color(255, 0, 0));
        jLogoutButton.setText("LOGOUT");
        jLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jLogoutButton);
        jLogoutButton.setBounds(17, 219, 130, 25);

        jPanel2.setBackground(new java.awt.Color(0, 174, 239));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("FINISHED TASK");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 50, 110, 20);

        jFinished.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel2.add(jFinished);
        jFinished.setBounds(0, 0, 160, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(390, 320, 160, 80);

        jPanel3.setBackground(new java.awt.Color(0, 174, 239));
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ON-GOING TASK");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(25, 50, 120, 20);

        jOngoing.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel3.add(jOngoing);
        jOngoing.setBounds(0, 0, 160, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(500, 190, 160, 80);

        jPanel4.setBackground(new java.awt.Color(0, 174, 239));
        jPanel4.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("PENDING TASK");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(30, 50, 110, 20);

        jPending.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel4.add(jPending);
        jPending.setBounds(0, 0, 160, 40);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(280, 190, 160, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account (2).png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 10, 100, 90);

        jUserName1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jUserName1.setText("USER");
        jPanel1.add(jUserName1);
        jUserName1.setBounds(62, 100, 60, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/signup background.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jHomeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeButton2ActionPerformed
        EmployeeAccountProfile ep = new EmployeeAccountProfile();
        ep.setVisible(true);
        ep.pack();
        ep.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jHomeButton2ActionPerformed

    private void jHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeButtonActionPerformed
        EmployeeDashboard UB = new EmployeeDashboard();
        UB.setVisible(true);
        UB.pack();
        UB.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jHomeButtonActionPerformed

    private void jHomeButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeButton4ActionPerformed
        EmployeeTaskTable ET = new EmployeeTaskTable();
        ET.setVisible(true);
        ET.pack();
        ET.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jHomeButton4ActionPerformed

    private void jLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutButtonActionPerformed
        LoginPage LoginFrame = new LoginPage();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLogoutButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        jPending.setHorizontalAlignment(SwingConstants.CENTER);
        jPending.setText("" + numberOfPendingTask());
        jOngoing.setHorizontalAlignment(SwingConstants.CENTER);
        jOngoing.setText("" + numberOfOnGoingTask());
        jFinished.setHorizontalAlignment(SwingConstants.CENTER);
        jFinished.setText("" + numberOfFinishedTask());
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
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jFinished;
    private javax.swing.JButton jHomeButton;
    private javax.swing.JButton jHomeButton2;
    private javax.swing.JButton jHomeButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jLogoutButton;
    private javax.swing.JLabel jOngoing;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jPending;
    private javax.swing.JLabel jUserName1;
    // End of variables declaration//GEN-END:variables

}
