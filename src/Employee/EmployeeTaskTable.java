
package Employee;


import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import task.tracker.LoginPage;


public class EmployeeTaskTable extends javax.swing.JFrame {

    
    public EmployeeTaskTable() {
        initComponents();
        displayData();
        
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedStatus = (String) jComboBox1.getSelectedItem();
                if (selectedStatus.equals("ON-GOING")) {
                    updateTableData("ON-GOING");
                } else if (selectedStatus.equals("PENDING")) {
                    updateTableData("PENDING");
                } else if (selectedStatus.equals("FINISHED")){
                    updateTableData("FINISHED");
                } else {
                    updateTableData("ALL TASK");
                }
            }
        });
    }

    private void updateTableData(String status) {
        if(status.equals("ON-GOING")){
            displayOnGoingData();
        }else if(status.equals("PENDING")){
            displayPendingData();
        }else if(status.equals("FINISHED")){
            displayFinishedData();
        }else{
            displayData();
        }
    }
    //TABLE FORMAT
    public void tableFormat(){
        // Disable cell editing by default
        jUserTaskTable.setDefaultEditor(Object.class, null);

        TableColumnModel columnModel = jUserTaskTable.getColumnModel();
        columnModel.getColumn(0).setHeaderValue("Task ID");
        columnModel.getColumn(1).setHeaderValue("Description");
        columnModel.getColumn(2).setHeaderValue("Deadline");
        columnModel.getColumn(3).setHeaderValue("Status");

        jUserTaskTable.getTableHeader().setBackground(Color.decode("#00AEEF"));

        //size of the row height
        jUserTaskTable.setRowHeight(20);

        //size of column by percent
        int totalWidth = jUserTaskTable.getWidth();
        double[] columnWidthPercentages = {15, 55, 15, 15};
        int[] columnWidths = new int[columnWidthPercentages.length];

        for (int i = 0; i < columnWidthPercentages.length; i++) {
            columnWidths[i] = (int) (totalWidth * (columnWidthPercentages[i] / 100.0));
        }
        columnModel.getColumn(0).setPreferredWidth(columnWidths[0]);
        columnModel.getColumn(1).setPreferredWidth(columnWidths[1]);
        columnModel.getColumn(2).setPreferredWidth(columnWidths[2]);
        columnModel.getColumn(3).setPreferredWidth(columnWidths[3]);

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
        Session session = Session.getInstance();
        int employeeID = session.getId();
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT t_id,t_name,t_deadline,t_status FROM task WHERE e_id = '"+employeeID+"' AND t_archive = 'NO'");
            jUserTaskTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            tableFormat();
            
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    //display on-going table data
    public void displayOnGoingData(){
        Session session = Session.getInstance();
        int employeeID = session.getId();
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT t_id,t_name,t_deadline,t_status FROM task WHERE t_status = 'ON-GOING' AND e_id = '"+employeeID+"' AND t_archive = 'NO'");
            jUserTaskTable.setModel(DbUtils.resultSetToTableModel(rs));
            tableFormat();
            
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    //display pending table data
    public void displayPendingData(){
        Session session = Session.getInstance();
        int employeeID = session.getId();
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT t_id,t_name,t_deadline,t_status FROM task WHERE t_status = 'PENDING' AND e_id = '"+employeeID+"' AND t_archive = 'NO'");
            jUserTaskTable.setModel(DbUtils.resultSetToTableModel(rs));
            tableFormat();
            
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    //display finished table data
    public void displayFinishedData(){
        Session session = Session.getInstance();
        int employeeID = session.getId();
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT t_id,t_name,t_deadline,t_status FROM task WHERE t_status = 'FINISHED' AND e_id = '"+employeeID+"' AND t_archive = 'NO'");
            jUserTaskTable.setModel(DbUtils.resultSetToTableModel(rs));
            tableFormat();
            
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    //show data to selected row
    public void updateData(){
        int rowindex = jUserTaskTable.getSelectedRow();
        if(rowindex < 0){
            JOptionPane.showMessageDialog(null,"Please select a task");
            return;
        } else {
            TableModel model = jUserTaskTable.getModel();
            // Check if the status of the selected row is "FINISHED"
            String status = model.getValueAt(rowindex, 3).toString();
            if ("FINISHED".equalsIgnoreCase(status)) {
                JOptionPane.showMessageDialog(null, "Task already finished");
                return;
            }
            
            UpdateEmployeeTask updateFrame = new UpdateEmployeeTask();
            updateFrame.jID.setText("" + model.getValueAt(rowindex, 0));
            updateFrame.jID.setEditable(false);
            updateFrame.jDescription.setText("" + model.getValueAt(rowindex, 1));
            updateFrame.jDescription.setEditable(false);
            updateFrame.jStatus.setSelectedItem("" + model.getValueAt(rowindex, 3));
            
            updateFrame.setVisible(true);
            updateFrame.pack();
            updateFrame.setLocationRelativeTo(null);
            this.dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jHomeButton1 = new javax.swing.JButton();
        jHomeButton = new javax.swing.JButton();
        jLogoutButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jUserTaskTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jHomeButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jUserName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EMPLOYEE TASK TABLE");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 500));
        jPanel1.setLayout(null);

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
        jLogoutButton.setBounds(17, 219, 130, 25);

        jUserTaskTable.setBackground(new java.awt.Color(240, 240, 240));
        jUserTaskTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUserTaskTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jUserTaskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Task ID", "Description", "Deadline", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane1.setBounds(170, 150, 920, 310);

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton4.setText("UPDATE");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(170, 110, 100, 24);

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
        jButton1.setBounds(290, 110, 100, 24);

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL TASK", "PENDING", "ON-GOING", "FINISHED" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(410, 110, 150, 24);

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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account (2).png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 10, 100, 90);

        jUserName.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jUserName.setText("USER");
        jPanel1.add(jUserName);
        jUserName.setBounds(62, 100, 60, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/task table.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jHomeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeButton1ActionPerformed
        EmployeeAccountProfile up = new EmployeeAccountProfile();
        up.setVisible(true);
        up.pack();
        up.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jHomeButton1ActionPerformed

    private void jHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeButtonActionPerformed
        EmployeeDashboard ED = new EmployeeDashboard();
        ED.setVisible(true);
        ED.pack();
        ED.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jHomeButtonActionPerformed

    private void jLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutButtonActionPerformed
        LoginPage LoginFrame = new LoginPage();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLogoutButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        displayData();
    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        displayData();
        jComboBox1.setSelectedItem("ALL TASK");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jHomeButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeButton4ActionPerformed
        EmployeeTaskTable UT = new EmployeeTaskTable();
        UT.setVisible(true);
        UT.pack();
        UT.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jHomeButton4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        updateData();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeTaskTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeTaskTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeTaskTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeTaskTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeTaskTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JButton jHomeButton;
    private javax.swing.JButton jHomeButton1;
    private javax.swing.JButton jHomeButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jLogoutButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jUserName;
    private javax.swing.JTable jUserTaskTable;
    // End of variables declaration//GEN-END:variables
}
