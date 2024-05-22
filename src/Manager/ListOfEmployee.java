
package Manager;



import config.dbConnector;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import task.tracker.LoginPage;


public class ListOfEmployee extends javax.swing.JFrame {

    
    public ListOfEmployee() {
        initComponents();
        displayData();
    }

    static String name,gender,contactnumber,username,position,address,status;
    static Date birthdate;
    static int id;
    
    
    //display table data
    public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT e_id,e_fullname,e_position,e_contactnumber,e_status FROM employee");
            jEmployeeTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            //clear the searchfield if click to table
            jEmployeeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) { // Ensure that the event is not fired multiple times
                        int selectedRow = jEmployeeTable.getSelectedRow();
                        if (selectedRow != -1) { // If a row is selected
                            Object employeeID = jEmployeeTable.getValueAt(selectedRow, 0); // Assuming student ID is in the first column
                            jSearch.setText("search employee ID");
                        }
                    }
                }
            });
           
            // Disable cell editing by default
            jEmployeeTable.setDefaultEditor(Object.class, null);
            
            TableColumnModel columnModel = jEmployeeTable.getColumnModel();
            columnModel.getColumn(0).setHeaderValue("Employee ID");
            columnModel.getColumn(1).setHeaderValue("Full Name");
            columnModel.getColumn(2).setHeaderValue("Position");
            columnModel.getColumn(3).setHeaderValue("Contact Number");
            columnModel.getColumn(4).setHeaderValue("Status");
            
            jEmployeeTable.getTableHeader().setBackground(Color.decode("#00AEEF"));
            
            //size of the row height
            jEmployeeTable.setRowHeight(20);

            //size of column by percent
            int totalWidth = jEmployeeTable.getWidth();
            double[] columnWidthPercentages = {15, 25, 25, 20, 15};
            int[] columnWidths = new int[columnWidthPercentages.length];

            for (int i = 0; i < columnWidthPercentages.length; i++) {
                columnWidths[i] = (int) (totalWidth * (columnWidthPercentages[i] / 100.0));
            }
            columnModel.getColumn(0).setPreferredWidth(columnWidths[0]);
            columnModel.getColumn(1).setPreferredWidth(columnWidths[1]);
            columnModel.getColumn(2).setPreferredWidth(columnWidths[2]);
            columnModel.getColumn(3).setPreferredWidth(columnWidths[3]);
            columnModel.getColumn(4).setPreferredWidth(columnWidths[4]);
        
            TableCellRenderer rendererFromHeader = jEmployeeTable.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) rendererFromHeader;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            
            //Set cell renderer to center-align data in all columns 
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            jEmployeeTable.setDefaultRenderer(Object.class, centerRenderer);
            
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    //get employee data from database and set data to session
    public boolean getEmployeeDetails(int ID){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM employee WHERE e_id = '" + ID + "'";
            ResultSet resultset = connector.getData(query);
            if(resultset.next()){
                id = resultset.getInt("e_id");
                name = resultset.getString("e_fullname");
                birthdate = resultset.getDate("e_birthday");
                gender = resultset.getString("e_gender");
                contactnumber = resultset.getString("e_contactnumber");
                username = resultset.getString("e_username");
                position = resultset.getString("e_position");
                address = resultset.getString("e_address");
                status = resultset.getString("e_status");
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
  
    //show data to selected row and set data to UpdateEmployee
    public void updateData(){
        int rowindex = jEmployeeTable.getSelectedRow();
        if(rowindex < 0){
            JOptionPane.showMessageDialog(null,"Please select an employee");
            return;
        } else {
            TableModel model = jEmployeeTable.getModel();
            UpdateEmployee UE = new UpdateEmployee();
            int employeeID = (int) model.getValueAt(rowindex, 0);
            if(getEmployeeDetails(employeeID)){
                UE.jID.setText("" + id);
                UE.jID.setEditable(false);
                UE.jFullName.setText("" + name);
                UE.jPosition.setSelectedItem(position);
                UE.jContactNumber.setText("" + contactnumber);
                UE.jGender.setSelectedItem(gender);
                UE.jUsername.setText("" + username);
                UE.jAddress.setText("" + address);
                UE.jBirthdate.setDate(birthdate);
                UE.jStatus.setSelectedItem(status);
                UE.setVisible(true);
                UE.pack();
                UE.setLocationRelativeTo(null);
                this.dispose();
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEmployeeTable = new javax.swing.JTable();
        jButtonUpdate = new javax.swing.JButton();
        jButtonUpdate1 = new javax.swing.JButton();
        jHomeButton1 = new javax.swing.JButton();
        jHomeButton = new javax.swing.JButton();
        jLogoutButton = new javax.swing.JButton();
        jButtonDELETE = new javax.swing.JButton();
        jSearch = new javax.swing.JTextField();
        jHomeButton4 = new javax.swing.JButton();
        jLogoutButton1 = new javax.swing.JButton();
        jButtonRefresh1 = new javax.swing.JButton();
        jLogoutButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jUserName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VIEW EMPLOYEE PAGE");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("LIST OF EMPLOYEE DETAILS");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(340, 130, 250, 25);

        jEmployeeTable.setBackground(new java.awt.Color(240, 240, 240));
        jEmployeeTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jEmployeeTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jEmployeeTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jEmployeeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jEmployeeTable);
        if (jEmployeeTable.getColumnModel().getColumnCount() > 0) {
            jEmployeeTable.getColumnModel().getColumn(0).setHeaderValue("Employee ID");
            jEmployeeTable.getColumnModel().getColumn(1).setHeaderValue("Name");
            jEmployeeTable.getColumnModel().getColumn(2).setHeaderValue("Position");
            jEmployeeTable.getColumnModel().getColumn(3).setHeaderValue("Contact Number");
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(160, 230, 630, 220);

        jButtonUpdate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonUpdate.setText("UPDATE");
        jButtonUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jButtonUpdate.setFocusPainted(false);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUpdate);
        jButtonUpdate.setBounds(260, 190, 90, 24);

        jButtonUpdate1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonUpdate1.setText("ADD");
        jButtonUpdate1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jButtonUpdate1.setFocusPainted(false);
        jButtonUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdate1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUpdate1);
        jButtonUpdate1.setBounds(160, 190, 90, 24);

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

        jButtonDELETE.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonDELETE.setText("DELETE");
        jButtonDELETE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jButtonDELETE.setFocusPainted(false);
        jButtonDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDELETEActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDELETE);
        jButtonDELETE.setBounds(360, 190, 90, 24);

        jSearch.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jSearch.setText("search employee ID");
        jSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSearchMouseClicked(evt);
            }
        });
        jSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSearchKeyReleased(evt);
            }
        });
        jPanel1.add(jSearch);
        jSearch.setBounds(660, 190, 130, 24);

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

        jButtonRefresh1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRefresh1.setText("REFRESH");
        jButtonRefresh1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jButtonRefresh1.setFocusPainted(false);
        jButtonRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefresh1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRefresh1);
        jButtonRefresh1.setBounds(460, 190, 90, 24);

        jLogoutButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLogoutButton2.setText("ARCHIVE TASK");
        jLogoutButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jLogoutButton2);
        jLogoutButton2.setBounds(17, 219, 130, 25);

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 102, 255));
        jButton6.setText("EXPORT CSV");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 174, 239)));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(640, 460, 150, 24);

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

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        updateData();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdate1ActionPerformed
        AddEmployee AE = new AddEmployee();
        AE.setVisible(true);
        AE.pack();
        AE.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonUpdate1ActionPerformed

    private void jHomeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeButton1ActionPerformed
        ManagerAccountProfile ap = new ManagerAccountProfile();
        ap.setVisible(true);
        ap.pack();
        ap.setLocationRelativeTo(null);
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

    private void jButtonDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDELETEActionPerformed
        //delete data in table
        int selectedRow = jEmployeeTable.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String IDText = jEmployeeTable.getValueAt(selectedRow, 0).toString();
                int ID = Integer.valueOf(IDText);
                String query = "DELETE FROM employee WHERE e_id = '" + ID + "'";
                dbConnector dbc = new dbConnector();
                if (dbc.insertData(query)) {
                    ((DefaultTableModel)jEmployeeTable.getModel()).removeRow(selectedRow);
                    JOptionPane.showMessageDialog(null, "Employee ID " + ID + " Record deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete record.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDELETEActionPerformed

    private void jSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMouseClicked
        //clear search data
        jSearch.setText("");
    }//GEN-LAST:event_jSearchMouseClicked

    private void jSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchKeyReleased
        //search data in table using id number
        String searchText = jSearch.getText();
        if (!searchText.isEmpty()) {
            try {
                dbConnector dbc = new dbConnector();
                // Assuming student_id is numeric, so we parse searchText as an integer
                int ID = Integer.parseInt(searchText);
                String query = "SELECT e_id, e_fullname, e_position, e_contactnumber, e_status FROM employee WHERE e_id = " + ID;
                ResultSet rs = dbc.getData(query);
                jEmployeeTable.setModel(DbUtils.resultSetToTableModel(rs));
                TableColumnModel columnModel = jEmployeeTable.getColumnModel();
                columnModel.getColumn(0).setHeaderValue("Employee ID");
                columnModel.getColumn(1).setHeaderValue("Full Name");
                columnModel.getColumn(2).setHeaderValue("Position");
                columnModel.getColumn(3).setHeaderValue("Contact Number");
                columnModel.getColumn(4).setHeaderValue("Status");
                
                jEmployeeTable.getTableHeader().setBackground(Color.decode("#00AEEF"));
            
                //size of the row height
                jEmployeeTable.setRowHeight(20);

                //size of column by percent
                int totalWidth = jEmployeeTable.getWidth();
                double[] columnWidthPercentages = {15, 25, 25, 20, 15};
                int[] columnWidths = new int[columnWidthPercentages.length];

                for (int i = 0; i < columnWidthPercentages.length; i++) {
                    columnWidths[i] = (int) (totalWidth * (columnWidthPercentages[i] / 100.0));
                }
                columnModel.getColumn(0).setPreferredWidth(columnWidths[0]);
                columnModel.getColumn(1).setPreferredWidth(columnWidths[1]);
                columnModel.getColumn(2).setPreferredWidth(columnWidths[2]);
                columnModel.getColumn(3).setPreferredWidth(columnWidths[3]);
                columnModel.getColumn(4).setPreferredWidth(columnWidths[4]);

                TableCellRenderer rendererFromHeader = jEmployeeTable.getTableHeader().getDefaultRenderer();
                JLabel headerLabel = (JLabel) rendererFromHeader;
                headerLabel.setHorizontalAlignment(JLabel.CENTER);

                //Set cell renderer to center-align data in all columns 
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                jEmployeeTable.setDefaultRenderer(Object.class, centerRenderer);
            
                rs.close();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid employee ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            } catch (SQLException ex) {
                System.out.println("Errors: " + ex.getMessage());
            }
        } else {
            // If search field is empty, display all data
            displayData();
        }
    }//GEN-LAST:event_jSearchKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

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

    private void jButtonRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefresh1ActionPerformed
        displayData();
        jSearch.setText("search employee ID");
    }//GEN-LAST:event_jButtonRefresh1ActionPerformed

    private void jLogoutButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutButton2ActionPerformed
        ArchiveTask AT = new ArchiveTask();
        AT.setVisible(true);
        AT.pack();
        AT.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLogoutButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Table Data as CSV");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".csv")) {
                filePath += ".csv";
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                TableModel model = jEmployeeTable.getModel();
                for (int col = 0; col < model.getColumnCount(); col++) {
                    writer.write(model.getColumnName(col));
                    if (col < model.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();

                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Object cellData = model.getValueAt(row, col);
                        if (cellData != null) {
                            writer.write(cellData.toString());
                        }
                        if (col < model.getColumnCount() - 1) {
                            writer.write(",");
                        }
                    }
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(this, "Table data exported successfully to " + filePath, "Export Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error exporting data: " + e.getMessage(), "Export Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(ListOfEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOfEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOfEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOfEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOfEmployee().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonDELETE;
    private javax.swing.JButton jButtonRefresh1;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonUpdate1;
    private javax.swing.JTable jEmployeeTable;
    private javax.swing.JButton jHomeButton;
    private javax.swing.JButton jHomeButton1;
    private javax.swing.JButton jHomeButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jLogoutButton;
    private javax.swing.JButton jLogoutButton1;
    private javax.swing.JButton jLogoutButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSearch;
    private javax.swing.JLabel jUserName;
    // End of variables declaration//GEN-END:variables
}
