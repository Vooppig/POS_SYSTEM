package admin;

import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
import services.clientHandler;

public class UsersPanel extends javax.swing.JPanel {

  int currentRowIndex;
  int currentUserId;
  javax.swing.table.DefaultTableModel tbmUsers;

  /**
   * Creates new form UsersPanel
   *
   * @throws java.lang.ClassNotFoundException
   */
  public UsersPanel() throws ClassNotFoundException {
    /**
     * Initialize
     */
    tbmUsers = new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Full Name", "Username"}
    ) {
      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
      }
    };

    initComponents();

    /**
     * Populate on load
     */
    getAllUsers();
  }

  private void addRow(User user) {
    tbmUsers.addRow(new Object[]{
      user.getId(), user.getFullName(), user.getUsername()
    });
  }

  private void addRows(java.util.ArrayList<User> users) {
    tbmUsers.setRowCount(0);
    users.forEach(user -> addRow(user));
    resizeColumns();
  }

  private void updateRow(User users) {
    javax.swing.table.TableModel model = (javax.swing.table.TableModel) tblUsers.getModel();
    model.setValueAt(users.getId(), currentRowIndex, 0);
    model.setValueAt(users.getFullName(), currentRowIndex, 1);
    model.setValueAt(users.getUsername(), currentRowIndex, 2);
  }

  private void removeRow() {
    tbmUsers.removeRow(currentRowIndex);
  }

  private void onRowClicked(java.awt.event.MouseEvent evt) throws ClassNotFoundException {
    javax.swing.table.TableModel model = (javax.swing.table.TableModel) tblUsers.getModel();
    int rowIndex = tblUsers.getSelectedRow();
    int userId = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());

    currentRowIndex = rowIndex;
    currentUserId = userId;

    getOneUser(userId);
  }

  private void resizeColumns() {
    javax.swing.table.TableColumnModel model = (javax.swing.table.TableColumnModel) tblUsers.getColumnModel();
    model.getColumn(0).setPreferredWidth(50);
    model.getColumn(0).setMaxWidth(50);
  }

  private void handleRefresh() throws ClassNotFoundException {
    getAllUsers();
  }

  private void handleSave() throws ClassNotFoundException {
    String fullName = txtUserName.getText();
    String username = txtUserUsername.getText();
    String password = txtUserPassword.getText();

    if (fullName.isEmpty()) {
      javax.swing.JOptionPane.showMessageDialog(null, "Full name is required", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
    } else if (username.isEmpty()) {
      javax.swing.JOptionPane.showMessageDialog(null, "Username is required", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
    } else if (password.isEmpty()) {
      javax.swing.JOptionPane.showMessageDialog(null, "Password is required", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
    } else {
      User user = new User();
      user.setId(currentUserId);
      user.setFullName(fullName);
      user.setUsername(username);
      user.setPassword(password);

      if (currentRowIndex >= 0) {
        updateOneItem(user);
      } else {
        createOneUser(user);
        clearFields();
      }
    }
  }

  private void handleNew() {
    clearFields();
  }

  private void handleDelete() throws ClassNotFoundException {
    if (currentRowIndex >= 0) {
      deleteOneItem(currentUserId);
      clearFields();
    } else {
      javax.swing.JOptionPane.showMessageDialog(null, "No user selected to delete", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
    }
  }

  private void populateFields(User users) {
    txtUserName.setText(users.getFullName());
    txtUserUsername.setText(users.getUsername());
    txtUserPassword.setText(users.getPassword());
  }

  private void clearFields() {
    currentRowIndex = -1;
    currentUserId = -1;

    tblUsers.clearSelection();

    txtUserName.setText("");
    txtUserUsername.setText("");
    txtUserPassword.setText("");
  }

  private void getAllUsers() throws ClassNotFoundException {
    java.util.ArrayList<User> users = clientHandler.userGetAll();
    if (!users.isEmpty()) {
      addRows(users);
    }
  }

  private void getOneUser(int id) throws ClassNotFoundException {
    User user = clientHandler.userGetOne(id);
    if (user != null) {
      populateFields(user);
    }
  }

  private void createOneUser(User user) throws ClassNotFoundException {
    int rowCount = clientHandler.userCreateOne(user);
    if (rowCount > 0) {
      getAllUsers();
    } else {
      javax.swing.JOptionPane.showMessageDialog(null, "Failed to create a new user", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
  }

  private void updateOneItem(User user) throws ClassNotFoundException {
    int rowCount = clientHandler.userUpdateOne(user);
    if (rowCount > 0) {
      updateRow(user);
    } else {
      javax.swing.JOptionPane.showMessageDialog(null, "Failed to update a user", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
  }

  private void deleteOneItem(int id) throws ClassNotFoundException {
    int rowCount = clientHandler.userDeleteOne(id);
    if (rowCount > 0) {
      removeRow();
    } else {
      javax.swing.JOptionPane.showMessageDialog(null, "Failed to delete a user", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    scpUsers = new javax.swing.JScrollPane();
    tblUsers = new javax.swing.JTable();
    pnlUserFields = new javax.swing.JPanel();
    lblUserName = new javax.swing.JLabel();
    lblUserUsername = new javax.swing.JLabel();
    lblUserPassword = new javax.swing.JLabel();
    txtUserName = new javax.swing.JTextField();
    txtUserUsername = new javax.swing.JTextField();
    txtUserPassword = new javax.swing.JTextField();
    pnlUserActions = new javax.swing.JPanel();
    btnUserRefresh = new javax.swing.JButton();
    btnUserSave = new javax.swing.JButton();
    btnUserNew = new javax.swing.JButton();
    btnUserDelete = new javax.swing.JButton();

    setPreferredSize(new java.awt.Dimension(720, 600));
    setLayout(new java.awt.GridBagLayout());

    tblUsers.setModel(tbmUsers);
    tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tblUsersMouseClicked(evt);
      }
    });
    scpUsers.setViewportView(tblUsers);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    add(scpUsers, gridBagConstraints);

    java.awt.GridBagLayout pnlUserFieldsLayout = new java.awt.GridBagLayout();
    pnlUserFieldsLayout.columnWidths = new int[] {100, 300};
    pnlUserFieldsLayout.rowHeights = new int[] {60, 0, 60};
    pnlUserFields.setLayout(pnlUserFieldsLayout);

    lblUserName.setLabelFor(txtUserName);
    lblUserName.setText("Name");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    pnlUserFields.add(lblUserName, gridBagConstraints);

    lblUserUsername.setLabelFor(txtUserUsername);
    lblUserUsername.setText("Username");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    pnlUserFields.add(lblUserUsername, gridBagConstraints);

    lblUserPassword.setLabelFor(txtUserPassword);
    lblUserPassword.setText("Password");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    pnlUserFields.add(lblUserPassword, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    pnlUserFields.add(txtUserName, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    pnlUserFields.add(txtUserUsername, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    pnlUserFields.add(txtUserPassword, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    add(pnlUserFields, gridBagConstraints);

    pnlUserActions.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 20));

    btnUserRefresh.setText("Refresh");
    btnUserRefresh.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUserRefreshActionPerformed(evt);
      }
    });
    pnlUserActions.add(btnUserRefresh);

    btnUserSave.setText("Save");
    btnUserSave.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUserSaveActionPerformed(evt);
      }
    });
    pnlUserActions.add(btnUserSave);

    btnUserNew.setText("New");
    btnUserNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUserNewActionPerformed(evt);
      }
    });
    pnlUserActions.add(btnUserNew);

    btnUserDelete.setText("Delete");
    btnUserDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUserDeleteActionPerformed(evt);
      }
    });
    pnlUserActions.add(btnUserDelete);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
    add(pnlUserActions, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  private void btnUserRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserRefreshActionPerformed
    try {
      handleRefresh();
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UsersPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_btnUserRefreshActionPerformed

  private void btnUserSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserSaveActionPerformed
    try {
      handleSave();
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UsersPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_btnUserSaveActionPerformed

  private void btnUserNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserNewActionPerformed
    handleNew();
  }//GEN-LAST:event_btnUserNewActionPerformed

  private void btnUserDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDeleteActionPerformed
    try {
      handleDelete();
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UsersPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_btnUserDeleteActionPerformed

  private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
    try {
      onRowClicked(evt);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UsersPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_tblUsersMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnUserDelete;
  private javax.swing.JButton btnUserNew;
  private javax.swing.JButton btnUserRefresh;
  private javax.swing.JButton btnUserSave;
  private javax.swing.JLabel lblUserName;
  private javax.swing.JLabel lblUserPassword;
  private javax.swing.JLabel lblUserUsername;
  private javax.swing.JPanel pnlUserActions;
  private javax.swing.JPanel pnlUserFields;
  private javax.swing.JScrollPane scpUsers;
  private javax.swing.JTable tblUsers;
  private javax.swing.JTextField txtUserName;
  private javax.swing.JTextField txtUserPassword;
  private javax.swing.JTextField txtUserUsername;
  // End of variables declaration//GEN-END:variables
}
