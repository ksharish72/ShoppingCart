/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VendorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.Organization.VendorOrganization;
import Business.Product.Item;
import Business.Product.Product;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AddProductWorkRequest;
import Business.WorkQueue.CheckStockWorkRequest;

import Business.WorkQueue.OrderProcessWorkRequest;
import Business.WorkQueue.VendorProcessWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.InventoryRole.ManageProductRequestJPanel;
import static userinterface.PaymentProcessRole.PaymentProcessWorkAreaJPanel.paymentProcessTable;

/**
 *
 * @author raunak
 */
public class VendorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private VendorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private JPanel backGroundJPanel;
    private EcoSystem business;

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public VendorWorkAreaJPanel(JPanel backGroundJPanel, JPanel userProcessContainer, UserAccount account, VendorOrganization organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.backGroundJPanel = backGroundJPanel;
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business=business;
        valueLabel.setText(enterprise.getName());
        populateRequestTable();
        populateCustomerOrderRequestTable();
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[6];
            row[0] = request.getRequestID();
            row[1] = request.getRequestType();
            row[2] = request.getReceiver();
            row[3] = request.getSender();
            row[4] = request.getRequestDate();
            row[5] = request.getStatus();
            model.addRow(row);
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

        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        manageProductsJButton = new javax.swing.JButton();
        addProductManually = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        vendorWorkTable = new javax.swing.JTable();
        processCustOrder = new javax.swing.JButton();
        totalProfitTextjLabel = new javax.swing.JLabel();
        profitValuejLabel = new javax.swing.JLabel();
        analysisBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(250, 250, 250));
        setMinimumSize(new java.awt.Dimension(1680, 980));
        setPreferredSize(new java.awt.Dimension(1680, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(38, 114, 0));
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 127, 30));

        valueLabel.setForeground(new java.awt.Color(0, 153, 0));
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 158, 26));

        manageProductsJButton.setBackground(new java.awt.Color(0, 153, 0));
        manageProductsJButton.setForeground(new java.awt.Color(255, 255, 255));
        manageProductsJButton.setText("Manage Products");
        manageProductsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProductsJButtonActionPerformed(evt);
            }
        });
        add(manageProductsJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        addProductManually.setBackground(new java.awt.Color(0, 153, 0));
        addProductManually.setForeground(new java.awt.Color(255, 255, 255));
        addProductManually.setText("Add Product");
        addProductManually.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductManuallyActionPerformed(evt);
            }
        });
        add(addProductManually, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 131, -1));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Request Type", "Receiver", "Sender", "Request Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 82, 1290, 210));

        vendorWorkTable.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        vendorWorkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Order total price", "Product count", "Sender", "Status"
            }
        ));
        vendorWorkTable.setEnabled(true);
        vendorWorkTable.setGridColor(new java.awt.Color(255, 255, 255));
        vendorWorkTable.setSelectionBackground(new java.awt.Color(0, 153, 0));
        jScrollPane8.setViewportView(vendorWorkTable);

        add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 1300, 240));

        processCustOrder.setBackground(new java.awt.Color(0, 153, 0));
        processCustOrder.setForeground(new java.awt.Color(255, 255, 255));
        processCustOrder.setText("Process Customer Order");
        processCustOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processCustOrderActionPerformed(evt);
            }
        });
        add(processCustOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 430, 170, 30));

        totalProfitTextjLabel.setForeground(new java.awt.Color(0, 153, 0));
        totalProfitTextjLabel.setText("Total Profit:");
        add(totalProfitTextjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, -1, 20));

        profitValuejLabel.setForeground(new java.awt.Color(0, 153, 0));
        add(profitValuejLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 320, 70, 22));

        analysisBtn.setBackground(new java.awt.Color(0, 153, 0));
        analysisBtn.setForeground(new java.awt.Color(255, 255, 255));
        analysisBtn.setText("Analysis");
        analysisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analysisBtnActionPerformed(evt);
            }
        });
        add(analysisBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 490, 170, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void manageProductsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProductsJButtonActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ManageProduct", new ManageProducts(backGroundJPanel, userProcessContainer, userAccount, organization, enterprise,business));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageProductsJButtonActionPerformed

    private void addProductManuallyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductManuallyActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("AddProduct", new AddProduct(backGroundJPanel, userProcessContainer, userAccount, organization, enterprise,business));
        layout.next(userProcessContainer);

    }//GEN-LAST:event_addProductManuallyActionPerformed

    private void processCustOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processCustOrderActionPerformed
        int selectedRow = vendorWorkTable.getSelectedRow();

        if (selectedRow < 0) {
            return;
        }
        int ID = (int) vendorWorkTable.getValueAt(selectedRow, 0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            VendorProcessWorkRequest vendorProcessworkRequest = (VendorProcessWorkRequest) request;
            if (request.getRequestID() == ID) {

                if (userAccount.getEmployee().getVendorProcessWorkRequestMap().get(vendorProcessworkRequest).equals("Out for delivery")) {
                    JOptionPane.showMessageDialog(null, "This request is already completed");
                    break;
                } else {
                    if (userAccount.getEmployee().getVendorProcessWorkRequestMap().get(vendorProcessworkRequest).equals("Stock check")) {
                        JOptionPane.showMessageDialog(null, "Please wait for the Inventory personnel to respond with stock check result...");
                    } else {
                        if (userAccount.getEmployee().getVendorProcessWorkRequestMap().get(vendorProcessworkRequest).equals("Stock check completed")) {

                            JOptionPane.showMessageDialog(null, "Your Items availability has been updated in the order! Waiting for other vendors to respond");
                        } else {
                            int reply = JOptionPane.showConfirmDialog(null,
                                    "This request requires an inventory check!\n\t Do you want to forward this to Inventory?", "Forward to inventory", JOptionPane.YES_NO_OPTION);

                            if (reply == JOptionPane.YES_OPTION) {

                                CheckStockWorkRequest checkStockWorkRequest = new CheckStockWorkRequest();
                                checkStockWorkRequest.setVendorProcessWorkRequest(vendorProcessworkRequest);
                                // vendorProcessworkRequest.setCheckStockWorkRequest(checkStockWorkRequest);
                                checkStockWorkRequest.setSender(userAccount);
                                List<Item> vendorArrayListItems = vendorProcessworkRequest.getOrder().getItemlist().stream().filter(item -> item.getProduct().getVendorName().equals(userAccount.getEmployee().getName())).collect(Collectors.toList());
                                checkStockWorkRequest.setItemList((ArrayList< Item>) vendorArrayListItems);
                                checkStockWorkRequest.setAvailability(false);
                                checkStockWorkRequest.setStatus("Initiated");
                                checkStockWorkRequest.setRequestType("Stock Check");
                                Organization org = null;
                                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                    if (organization instanceof InventoryOrganization) {
                                        org = organization;
                                        break;
                                    }
                                }
                                if (org != null) {
                                    org.getWorkQueue().getWorkRequestList().add(checkStockWorkRequest);
                                    userAccount.getWorkQueue().getWorkRequestList().add(checkStockWorkRequest);
                                }
//enterprise.getWorkQueue().getWorkRequestList().add(request);
                                JOptionPane.showMessageDialog(null, "Stock check sent to inventory");
                                populateRequestTable();
                                userAccount.getEmployee().getVendorProcessWorkRequestMap().put(vendorProcessworkRequest, "Stock check");
                                // vendorProcessworkRequest.setStatus("Stock check");
                                //   vendorProcessworkRequest.getPaymentProcessWorkRequest().setStatus("Stock check");
                                populateCustomerOrderRequestTable();
                            }
                        }
                    }
                }
            }
        }

//request.setModel();
//request.setStatus("Initiated");
//request.setRequestType("Add Product");
//  Organization org = null;
//        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
//            if (organization instanceof InventoryOrganization){
//                org = organization;
//                break;
//            }
//        }
//        if (org!=null){
//            org.getWorkQueue().getWorkRequestList().add(request);
//            account.getWorkQueue().getWorkRequestList().add(request);
        //}

    }//GEN-LAST:event_processCustOrderActionPerformed

    private void analysisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analysisBtnActionPerformed
        // TODO add your handling code here:
        HashMap<String, Integer> produdctWiseSoldData = new HashMap<String, Integer>();
        DefaultTableModel model = (DefaultTableModel) vendorWorkTable.getModel();
        ArrayList<WorkRequest> workRequests = organization.getWorkQueue().getWorkRequestList();
        model.setRowCount(0);
        for (int i = 0; i < workRequests.size(); i++) {
            Object[] row = new Object[9];
            WorkRequest workRequest = workRequests.get(i);
            VendorProcessWorkRequest vendorProcessworkRequest = (VendorProcessWorkRequest) workRequest;
            List<Item> vendorArrayListItems = vendorProcessworkRequest.getOrder().getItemlist().stream().filter(item -> item.getProduct().getVendorName().equals(userAccount.getEmployee().getName())).collect(Collectors.toList());
            if (vendorArrayListItems.size() > 0) {
                for (Item item : vendorArrayListItems) {
                    String brandName = item.getProduct().getBrand_name();
                    int quantityBought = item.getQuantity();
                    if (produdctWiseSoldData.containsKey(brandName)) {
                        produdctWiseSoldData.put(brandName, produdctWiseSoldData.get(brandName) + quantityBought);
                    } else {
                        produdctWiseSoldData.put(brandName, quantityBought);
                    }
                }
            }
        }
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ProductAnalyis", new ProductAnalysisJPanel(backGroundJPanel, userProcessContainer, produdctWiseSoldData, userAccount, organization, enterprise));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_analysisBtnActionPerformed

    private HashMap<String, ArrayList<Product>> ReadFromProductsExcel(String pathToCsv) throws FileNotFoundException, IOException {
        String[] categoryArray = {"Newly Added", "Electronics", "Mobiles", "Kids Corner"};
        String[] collections = {"products", "productCategory"};
        HashMap<String, ArrayList<Product>> productsListMap = new HashMap<String, ArrayList<Product>>();
        String row = "";
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        int rowCount = 0;
        Product lastAddedProduct = null;
        while ((row = csvReader.readLine()) != null) {
            if (rowCount == 0) {
                rowCount++;
                continue;
            }
            String[] data = row.split(",");
            if (data.length == 1) {
                lastAddedProduct.getDescription().add(data[0]);
                continue;
            }
            if (data.length == 2) {
                lastAddedProduct.getDescription().add(data[0] + " " + data[1]);
                continue;
            }
            String category = data[6];
            // DBObject dbObject = getDocumentByProperty(categoryCol, "name", category);
            // String id = dbObject.get("_id").toString();
            Product product = new Product();
            product.setBrand_name(data[1]);
            //  product.setCategoryId(id);
            product.getDescription().add(data[7]);
            product.setImageFileName(data[5]);
            product.setModel(data[2]);
            product.setPrice(Integer.parseInt(data[3]));
            product.setStock(Integer.parseInt(data[4]));
            if (productsListMap.containsKey(category)) {
                ArrayList<Product> arrayList = productsListMap.get(category);
                arrayList.add(product);
                lastAddedProduct = product;
            } else {
                ArrayList<Product> arrayList = new ArrayList<Product>();
                arrayList.add(product);
                lastAddedProduct = product;
                productsListMap.put(category, arrayList);
            }
            rowCount++;
            // do something with the data
        }
        csvReader.close();
        return productsListMap;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductManually;
    private javax.swing.JButton analysisBtn;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JButton manageProductsJButton;
    private javax.swing.JButton processCustOrder;
    private javax.swing.JLabel profitValuejLabel;
    private javax.swing.JLabel totalProfitTextjLabel;
    private javax.swing.JLabel valueLabel;
    public static javax.swing.JTable vendorWorkTable;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables

    public void populateCustomerOrderRequestTable() {
        int profit = 0;
        vendorWorkTable.setRowHeight(150);
        DefaultTableModel model = (DefaultTableModel) vendorWorkTable.getModel();
        ArrayList<WorkRequest> workRequests = organization.getWorkQueue().getWorkRequestList();
        model.setRowCount(0);
        for (int i = 0; i < workRequests.size(); i++) {
            Object[] row = new Object[9];
            WorkRequest workRequest = workRequests.get(i);
            VendorProcessWorkRequest vendorProcessworkRequest = (VendorProcessWorkRequest) workRequest;
            List<Item> vendorArrayListItems = vendorProcessworkRequest.getOrder().getItemlist().stream().filter(item -> item.getProduct().getVendorName().equals(userAccount.getEmployee().getName())).collect(Collectors.toList());
            if (vendorArrayListItems.size() > 0) {
                //   userAccount.getEmployee().getVendorProcessWorkRequestMap().put(vendorProcessworkRequest, "Payment Processing");
                int vendorOrderPrice = vendorArrayListItems.stream().mapToInt(item -> item.getTotalItemCost()).sum();
                row[0] = vendorProcessworkRequest.getRequestID();
                row[1] = vendorOrderPrice;
                row[2] = vendorArrayListItems.size();
                row[3] = vendorProcessworkRequest.getSender().getEmployee().getName();
                //  row[4] = vendorProcessworkRequest.getReceiver() == null ? null : vendorProcessworkRequest.getReceiver().getEmployee().getName();
                row[4] = vendorProcessworkRequest.getPaymentProcessWorkRequest().getStatus();
                model.addRow(row);
                profit = profit + vendorOrderPrice;
            }
        }
        profitValuejLabel.setText(profit + " dollars");
    }
}
