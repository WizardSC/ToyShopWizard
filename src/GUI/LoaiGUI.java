/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.LoaiBUS;
import DTO.LoaiDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wizardsc
 */
public class LoaiGUI extends javax.swing.JDialog {

    private LoaiBUS loaiBUS = new LoaiBUS();
     
    DefaultTableModel dtmLoai;
    public LoaiGUI() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setResizable(true);
        
        dtmLoai = (DefaultTableModel) tblDSLOAI.getModel();
        init();
        loadData();
    }
    public void init(){
        tblDSLOAI.setFocusable(false);
        tblDSLOAI.setIntercellSpacing(new Dimension(0, 0));

        tblDSLOAI.setRowHeight(25);
        tblDSLOAI.setFillsViewportHeight(true);

        tblDSLOAI.getTableHeader().setOpaque(false);
        tblDSLOAI.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSLOAI.getTableHeader().setForeground(Color.WHITE);
        tblDSLOAI.setSelectionBackground(new Color(188, 206, 248));
        tblDSLOAI.setSelectionForeground(Color.BLACK);
        tblDSLOAI.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSLOAI.getTableHeader().setReorderingAllowed(false);
        tblDSLOAI.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
        
    }
    
    public void showAllDSLoai(ArrayList<LoaiDTO> dsloai){
        dtmLoai.setRowCount(0);
        for(int i=0;i<dsloai.size();i++){
            dtmLoai.addRow(new String[]{
                dsloai.get(i).getMaLoai(),
                dsloai.get(i).getTenLoai()
            });
        }
    }
    
    public void loadData(){
        loaiBUS.docDanhSach();
        ArrayList<LoaiDTO> dsloai = loaiBUS.getListLoai();
        showAllDSLoai(dsloai);
    }
    public String getMaLoai() {
        String MaLoai = txtMaLoai.getText();
        return MaLoai;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSLOAI = new javax.swing.JTable();
        pnHeader1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnChonLoai = new javax.swing.JLabel();
        btnBoChon = new javax.swing.JLabel();
        txtMaLoai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenLoai = new javax.swing.JTextField();
        txtTimKiem1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(250, 247, 240));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        tblDSLOAI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", null}
            },
            new String [] {
                "Mã loại", "Tên loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSLOAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSLOAIMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSLOAI);
        if (tblDSLOAI.getColumnModel().getColumnCount() > 0) {
            tblDSLOAI.getColumnModel().getColumn(0).setResizable(false);
            tblDSLOAI.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblDSLOAI.getColumnModel().getColumn(1).setResizable(false);
            tblDSLOAI.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        pnHeader1.setBackground(new java.awt.Color(152, 168, 248));
        pnHeader1.setPreferredSize(new java.awt.Dimension(102, 40));

        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblLoai.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        jLabel9.setText("QUẢN LÝ LOẠI");

        javax.swing.GroupLayout pnHeader1Layout = new javax.swing.GroupLayout(pnHeader1);
        pnHeader1.setLayout(pnHeader1Layout);
        pnHeader1Layout.setHorizontalGroup(
            pnHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHeader1Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnHeader1Layout.setVerticalGroup(
            pnHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnHeader1Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(250, 247, 240));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỌN LOẠI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("KIẾM TRA THÔNG TIN");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 26, 593, -1));

        btnChonLoai.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonLoai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChonLoai.setText("Chọn");
        btnChonLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonLoaiMouseClicked(evt);
            }
        });
        jPanel6.add(btnChonLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 130, -1));

        btnBoChon.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnBoChon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBoChon.setText("Bỏ chọn");
        btnBoChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBoChonMouseClicked(evt);
            }
        });
        jPanel6.add(btnBoChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 122, -1));
        jPanel6.add(txtMaLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 148, 27));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Mã loại");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 60, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tên loại");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 60, 30));
        jPanel6.add(txtTenLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 148, 27));
        jPanel6.add(txtTimKiem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 200, 27));

        jComboBox2.setEditable(true);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã KH" }));
        jComboBox2.setFocusable(false);
        jPanel6.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 68, 27));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(pnHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSLOAIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSLOAIMouseClicked
        int k = tblDSLOAI.getSelectedRow();
        txtMaLoai.setText(tblDSLOAI.getModel().getValueAt(k, 0).toString());
        txtTenLoai.setText(tblDSLOAI.getModel().getValueAt(k,1).toString());
    }//GEN-LAST:event_tblDSLOAIMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnChonLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonLoaiMouseClicked
        dispose();
    }//GEN-LAST:event_btnChonLoaiMouseClicked

    private void btnBoChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoChonMouseClicked
        dispose();
    }//GEN-LAST:event_btnBoChonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBoChon;
    private javax.swing.JLabel btnChonLoai;
    private javax.swing.JLabel btnClose;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnHeader1;
    private javax.swing.JTable tblDSLOAI;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtTenLoai;
    private javax.swing.JTextField txtTimKiem1;
    // End of variables declaration//GEN-END:variables
}
