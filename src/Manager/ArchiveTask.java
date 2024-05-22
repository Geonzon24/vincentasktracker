
package Manager;


import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
import task.tracker.LoginPage;


public class ArchiveTask extends javax.swing.JFrame {

    
    public ArchiveTask() {
        initComponents();
        displayData();
    }
    
    
    
    //table format
    public void tableFormat(){
        // Disable cell editing by default
        jUserTaskTable.setDefaultEditor(Object.class, null);

        TableColumnModel columnModel = jUserTaskTable.getColumnModel();
        columnModel.getColumn(0).setHeaderValue("Task ID");
        columnModel.getColumn(1).setHeaderValue("Description");
        columnModel.getColumn(2).setHeaderValue("AssignTo");
        columnModel.getColumn(3).setHeaderValue("Deadline");
        columnModel.getColumn(4).setHeaderValue("Status");

        jUserTaskTable.getTableHeader().setBackground(Color.decode("#00AEEF"));

        //size of the row height
        jUserTaskTable.setRowHeight(20);

        //size of column by percent
        int totalWidth = jUserTaskTable.getWidth();
        double[] columnWidthPercentages = {15, 35, 20, 15, 15};
        int[] columnWidths = new int[columnWidthPercentages.length];

        for (int i = 0; i < columnWidthPercentages.length; i++) {
            columnWidths[i] = (int) (totalWidth * (columnWidthPercentages[i] / 100.0));
        }
        columnModel.getColumn(0).setPreferredWidth(columnWidths[0]);
        columnModel.getColumn(1).setPreferredWidth(columnWidths[1]);
        columnModel.getColumn(2).setPreferredWidth(columnWidths[2]);
        columnModel.getColumn(3).setPreferredWidth(columnWidths[3]);
        columnModel.getColumn(4).setPreferredWidth(columnWidths[4]);

        TableCellRenderer rendererFromHeader = jUserTaskTable.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        //Set cell renderer to center-align data in all columns 
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jUserTaskTable.setDefaultRenderer(Object.class, centerRenderer);
    }
    
    //display table data
    public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT task.t_id,task.t_name,employee.e_fullname,task.t_deadline,task.t_status "
                    + "FROM employee "
                    + "INNER JOIN task ON employee.e_id = task.e_id "
                    + "WHERE task.t_archive = 'YES'");
            jUserTaskTable.setModel(DbUtils.resultSetToTableModel(rs));
            tableFormat();

            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jUserTaskTable = new javax.swing.JTable();
        jHomeButton1 = new javax.swing.JButton();
        jHomeButton = new javax.swing.JButton();
        jLogoutButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jHomeButton4 = new javax.swing.JButton();
        jLogoutButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLogoutButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jUserName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ARCHIVE TASK");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("LIST OF ALL ARCHIVE TASK");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(500, 80, 280, 22);

        jUserTaskTable.setBackground(new java.awt.Color(240, 240, 240));
        jUserTaskTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUserTaskTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jUserTaskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Task ID", "Name", "Deadline", "AssignTo", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jUserTaskTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jUserTaskTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jUserTaskTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(170, 180, 920, 280);

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

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton1.setText("REFRESH");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(280, 140, 100, 24);

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

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton5.setText("RESTORE");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(170, 140, 100, 24);

        jLogoutButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLogoutButton2.setText("ARCHIVE TASK");
        jLogoutButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jLogoutButton2);
        jLogoutButton2.setBounds(17, 219, 130, 25);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account (2).png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 10, 100, 90);

        jUserName.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jUserName.setText("ADMIN");
        jPanel1.add(jUserName);
        jUserName.setBounds(56, 100, 50, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/task table.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        displayData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int selectedRow = jUserTaskTable.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to restore this record?", "", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                int taskID = (int)jUserTaskTable.getValueAt(selectedRow, 0);
                String query = "UPDATE task SET t_archive = 'NO' WHERE t_id = '" + taskID + "'";
                dbConnector dbc = new dbConnector();
                if(dbc.insertData(query)){
                    JOptionPane.showMessageDialog(null,"Task ID " + taskID + " Record restored successfully.");
                    
                    displayData();
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to restore record.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to restore.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLogoutButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutButton2ActionPerformed
        ArchiveTask AT = new ArchiveTask();
        AT.setVisible(true);
        AT.pack();
        AT.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLogoutButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
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
            java.util.logging.Logger.getLogger(ArchiveTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArchiveTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArchiveTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArchiveTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArchiveTask().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jHomeButton;
    private javax.swing.JButton jHomeButton1;
    private javax.swing.JButton jHomeButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jLogoutButton;
    private javax.swing.JButton jLogoutButton1;
    private javax.swing.JButton jLogoutButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jUserName;
    private javax.swing.JTable jUserTaskTable;
    // End of variables declaration//GEN-END:variables
}
