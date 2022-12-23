/*
 * Copyright (c) 2020 Self-Order Kiosk
 */
package pos;

import java.util.logging.Level;
import java.util.logging.Logger;
import services.clientHandler;

public class OrderSummaryFrame extends javax.swing.JFrame implements StateObserver {
  
  OrderTable tbmOrder;
  models.Order order;

  /**
   * Creates new form OrderSummaryFrame
   */
  public OrderSummaryFrame() {
    app.Global.setAppIcon(this);

    /**
     * Initialize
     */
    initModels();
    initComponents();
    initState();
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

    btgEatingLocation = new javax.swing.ButtonGroup();
    btgPayment = new javax.swing.ButtonGroup();
    label1 = new java.awt.Label();
    pnlHeader = new javax.swing.JPanel();
    lblHeaderTitle = new javax.swing.JLabel();
    pnlContent = new javax.swing.JPanel();
    scpOrder = new javax.swing.JScrollPane();
    tblOrder = new javax.swing.JTable();
    pnlTotal = new javax.swing.JPanel();
    lblTotal = new javax.swing.JLabel();
    lblTotalValue = new javax.swing.JLabel();
    pnlFooter = new javax.swing.JPanel();
    btnBack = new javax.swing.JButton();
    sepActions = new javax.swing.JSeparator();
    btnCheckOut = new javax.swing.JButton();

    label1.setText("label1");

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Order Summary");
    setMinimumSize(new java.awt.Dimension(720, 860));
    setName(""); // NOI18N

    pnlHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
    pnlHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

    lblHeaderTitle.setFont(lblHeaderTitle.getFont().deriveFont(lblHeaderTitle.getFont().getSize()+10f));
    lblHeaderTitle.setText("Order Summary");
    lblHeaderTitle.setToolTipText("");
    pnlHeader.add(lblHeaderTitle);

    getContentPane().add(pnlHeader, java.awt.BorderLayout.NORTH);

    pnlContent.setLayout(new javax.swing.BoxLayout(pnlContent, javax.swing.BoxLayout.Y_AXIS));

    scpOrder.setPreferredSize(new java.awt.Dimension(452, 200));

    tblOrder.setModel(tbmOrder);
    tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tblOrderMouseClicked(evt);
      }
    });
    scpOrder.setViewportView(tblOrder);

    pnlContent.add(scpOrder);

    pnlTotal.setPreferredSize(new java.awt.Dimension(165, 10));
    pnlTotal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING, 20, 20));

    lblTotal.setFont(lblTotal.getFont().deriveFont(lblTotal.getFont().getStyle() | java.awt.Font.BOLD));
    lblTotal.setText("Total:");
    pnlTotal.add(lblTotal);

    lblTotalValue.setFont(lblTotalValue.getFont().deriveFont(lblTotalValue.getFont().getStyle() | java.awt.Font.BOLD));
    lblTotalValue.setText("$ 0.00");
    pnlTotal.add(lblTotalValue);

    pnlContent.add(pnlTotal);

    getContentPane().add(pnlContent, java.awt.BorderLayout.CENTER);

    pnlFooter.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
    pnlFooter.setLayout(new java.awt.GridBagLayout());

    btnBack.setText("Back");
    btnBack.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBackActionPerformed(evt);
      }
    });
    pnlFooter.add(btnBack, new java.awt.GridBagConstraints());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.weightx = 1.0;
    pnlFooter.add(sepActions, gridBagConstraints);

    btnCheckOut.setText("Check out");
    btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCheckOutActionPerformed(evt);
      }
    });
    pnlFooter.add(btnCheckOut, new java.awt.GridBagConstraints());

    getContentPane().add(pnlFooter, java.awt.BorderLayout.SOUTH);

    getAccessibleContext().setAccessibleName("");

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void initModels() {
    tbmOrder = new OrderTable();
  }
  
  private void initState() {
    getAllOrderedItems();
  }
  private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    try {
      new MenuFrame().setVisible(true);
      this.dispose();
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(OrderSummaryFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_btnBackActionPerformed

  private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
    
    try {
      java.util.ArrayList<models.OrderDetail> orderedItems = StateManager.getOrderedItems();
      
      models.Order ord = new models.Order();
      ord.setStatus(0);
      Integer orderId = clientHandler.createOne(ord);
      Integer rowCount = clientHandler.createOneDetails(orderId, orderedItems);
      
      if (rowCount > 0) {
        new EndFrame().setVisible(true);
        dispose();
      } else {
        javax.swing.JOptionPane.showMessageDialog(null, "Oops, we couldn't get your order.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(OrderSummaryFrame.class.getName()).log(Level.SEVERE, null, ex);
    }

  }//GEN-LAST:event_btnCheckOutActionPerformed

  private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
    int rowIndex = tblOrder.getSelectedRow();
    CustomizeDialog customizeDialog = new CustomizeDialog(StateManager.getOrderedItem(rowIndex), rowIndex);
    customizeDialog.addObserver(this);
    customizeDialog.setVisible(true);
  }//GEN-LAST:event_tblOrderMouseClicked

  private void tgbDisposeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgbDisposeItemStateChanged
    
    try {
      java.util.ArrayList<models.OrderDetail> orderedItems = StateManager.getOrderedItems();
      
      models.Order items = new models.Order();
      
      int orderId = clientHandler.createOne(items);
      int rowCount = clientHandler.createOneDetails(orderId, orderedItems);
      
      if (rowCount > 0) {
        new EndFrame().setVisible(true);
        dispose();
      } else {
        javax.swing.JOptionPane.showMessageDialog(null, "Oops, we couldn't get your order.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        
      }
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(OrderSummaryFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_tgbDisposeItemStateChanged

  private void tgbDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbDisposeActionPerformed
    try {
      // TODO add your handling code here:
      StateManager.reset();
      new MenuFrame().setVisible(true);
      javax.swing.JOptionPane.showMessageDialog(null, "Order cleared");
      this.dispose();
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(OrderSummaryFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_tgbDisposeActionPerformed
  
  private void getAllOrderedItems() {
    java.util.ArrayList<models.OrderDetail> orderedItems = StateManager.getOrderedItems();
    if (orderedItems != null) {
      tbmOrder.addRows(orderedItems);
      tbmOrder.resizeColumns(tblOrder.getColumnModel());
      app.Global.setTotalPrice(orderedItems, lblTotalValue);
    }
  }
  
  @Override
  public void onStateChange() {
    getAllOrderedItems();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set default theme */
    app.Global.setDefaultTheme();

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
      new OrderSummaryFrame().setVisible(true);
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.ButtonGroup btgEatingLocation;
  private javax.swing.ButtonGroup btgPayment;
  private javax.swing.JButton btnBack;
  private javax.swing.JButton btnCheckOut;
  private java.awt.Label label1;
  private javax.swing.JLabel lblHeaderTitle;
  private javax.swing.JLabel lblTotal;
  private javax.swing.JLabel lblTotalValue;
  private javax.swing.JPanel pnlContent;
  private javax.swing.JPanel pnlFooter;
  private javax.swing.JPanel pnlHeader;
  private javax.swing.JPanel pnlTotal;
  private javax.swing.JScrollPane scpOrder;
  private javax.swing.JSeparator sepActions;
  private javax.swing.JTable tblOrder;
  // End of variables declaration//GEN-END:variables
}
