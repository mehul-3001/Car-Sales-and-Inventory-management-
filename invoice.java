/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsales;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class invoice extends javax.swing.JFrame {

    /**
     * Creates new form invoice
     */
    Connection con=null;
    PreparedStatement pst=null;
    DefaultTableModel model;
    private String id;
    private int gqty;
    public invoice() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
    }
 public void bill()
    {
        String total1 = total.getText();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel)jTable1.getModel(); 
        txtbill.setText(txtbill.getText() + "*******************************************************\n");
        txtbill.setText(txtbill.getText() + "                            BILL                          \n");
        txtbill.setFont(txtbill.getFont().deriveFont(Font.BOLD, 13f));
 
        txtbill.setText(txtbill.getText() + "*******************************************************\n");   
         //Heading
          txtbill.setText(txtbill.getText() + "Product" + "\t" + "Price" + "\t" + "Amount" + "\n"  ); 
        
          for(int i = 0; i < model.getRowCount(); i++)
          {              
              String pname = (String)model.getValueAt(i, 0);
              int price = (Integer)model.getValueAt(i, 1);
              int amount = (Integer)model.getValueAt(i, 3);        
              txtbill.setText(txtbill.getText() + pname  + "\t" + price + "\t" + amount  + "\n"  );
          }   
          txtbill.setText(txtbill.getText() + "\n");       
          txtbill.setText(txtbill.getText() + "\t" +  "Subtotal : " + total1 + "\n");
          txtbill.setText(txtbill.getText() + "\n");
          txtbill.setText(txtbill.getText() + "*******************************************************\n");
          txtbill.setText(txtbill.getText() + "           THANK YOU COME AGAIN             \n");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        productID = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        productID1 = new javax.swing.JLabel();
        txtpname = new javax.swing.JTextField();
        productID2 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        productID4 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        productID5 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        print = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        manage = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 204), 10, true));
        jPanel1.setForeground(new java.awt.Color(0, 51, 204));

        productID.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        productID.setForeground(new java.awt.Color(0, 0, 153));
        productID.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        productID.setText("Product ID :");

        txtid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtidFocusLost(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidKeyReleased(evt);
            }
        });

        productID1.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        productID1.setForeground(new java.awt.Color(0, 0, 153));
        productID1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        productID1.setText("Name :");

        txtpname.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        productID2.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        productID2.setForeground(new java.awt.Color(0, 0, 153));
        productID2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        productID2.setText("Price :");

        txtprice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        productID4.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        productID4.setForeground(new java.awt.Color(0, 0, 153));
        productID4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        productID4.setText("Quantity :");

        qty.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });

        productID5.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        productID5.setForeground(new java.awt.Color(0, 0, 153));
        productID5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        productID5.setText("Total :");

        total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        Add.setBackground(new java.awt.Color(204, 204, 204));
        Add.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Add.setForeground(new java.awt.Color(0, 51, 204));
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        print.setBackground(new java.awt.Color(204, 204, 204));
        print.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        print.setForeground(new java.awt.Color(0, 51, 204));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(204, 204, 204));
        reset.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        reset.setForeground(new java.awt.Color(0, 51, 204));
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Price", "Quantity", "Tax(%)", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txtbill.setColumns(20);
        txtbill.setRows(5);
        jScrollPane2.setViewportView(txtbill);

        jLabel5.setBackground(new java.awt.Color(153, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CAR SALES AND INVENTORY MANAGEMENT");

        manage.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        manage.setForeground(new java.awt.Color(0, 51, 204));
        manage.setText("Manage->");
        manage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageActionPerformed(evt);
            }
        });

        Back.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Back.setForeground(new java.awt.Color(0, 51, 204));
        Back.setText("<-Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jToggleButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(0, 51, 204));
        jToggleButton1.setText("Display Inventory");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(productID5)
                        .addGap(32, 32, 32)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(productID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(productID4)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(productID1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(productID2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(qty, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtprice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(166, 166, 166))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addGap(247, 247, 247)
                .addComponent(manage)
                .addGap(171, 171, 171))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manage)
                    .addComponent(Back)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productID5))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productID1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productID2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productID4)
                            .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
         
    }//GEN-LAST:event_txtidKeyReleased
    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        String panme = (txtpname.getText());
            int price = Integer.parseInt(txtprice.getText());
            price=(int) (price+(price*0.10));
            int qty1 = Integer.parseInt(qty.getText());
            int tax=28;
            if(qty1<gqty&&qty1!=0)
            {
            int tot = (int) (qty1 * (price + (price*0.28)));
 
            model = (DefaultTableModel)jTable1.getModel();
            
            model.addRow(new Object[]
                    {
    
                        panme ,
                        price,
                        qty1,
                        tax,
                        tot, 
                    });
            
            int sum = 0;
            
             for(int i = 0; i<jTable1.getRowCount(); i++)
        {
            sum = sum + Integer.parseInt(jTable1.getValueAt(i, 3).toString());
        }
        
        total.setText(Integer.toString(sum));
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
            int q=gqty-qty1;
            System.out.print(q);
            String sql="UPDATE `inventory` SET qty =' "+q+" ' WHERE barcode = '"+id+"'";
            pst = con.prepareStatement(sql);
            pst.execute();
        }
        catch(Exception e)
        {
                JOptionPane.showMessageDialog(null, "Database Not Responding");
        }
        txtid.setText("");
        txtpname.setText("");
        txtprice.setText("");
        qty.setText("");
        txtid.requestFocus();
        
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Quantity Not Available or Invalid..Avail Qty="+gqty);
            }
    }//GEN-LAST:event_AddActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
            bill();
            
    }//GEN-LAST:event_printActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new invoice().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_resetActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homescreen().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void manageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageActionPerformed
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventory().setVisible(true);
            }
        });
         this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_manageActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inveentory_update().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void txtidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidFocusLost
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
            id = txtid.getText();
            pst = con.prepareStatement("select id,barcode,product,price,qty from inventory where barcode = ?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()==true)
            {
                String prodname = rs.getString(3);
                String price = rs.getString(4);
                 gqty=Integer.parseInt(rs.getString(5));
                txtpname.setText(prodname);
                txtprice.setText(price);
            }   
            else
            {
                 txtpname.setText("");
                 txtprice.setText("");
            }
 
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Database Not Responding");
        }
    }//GEN-LAST:event_txtidFocusLost

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Back;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton manage;
    private javax.swing.JButton print;
    private javax.swing.JLabel productID;
    private javax.swing.JLabel productID1;
    private javax.swing.JLabel productID2;
    private javax.swing.JLabel productID4;
    private javax.swing.JLabel productID5;
    private javax.swing.JTextField qty;
    private javax.swing.JButton reset;
    private javax.swing.JTextField total;
    private javax.swing.JTextArea txtbill;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtprice;
    // End of variables declaration//GEN-END:variables
}
