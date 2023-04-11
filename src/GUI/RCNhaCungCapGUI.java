/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import DTO.NhaCungCapDTO;
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
public class RCNhaCungCapGUI extends javax.swing.JDialog {

    DefaultTableModel dtmNhaCungCap;
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    public RCNhaCungCapGUI(){
        setUndecorated(true);
        initComponents();
        this.setModal(true);
        this.setResizable(false);
        setLocationRelativeTo(null);     
        dtmNhaCungCap = (DefaultTableModel) tblDSNCC.getModel();
        init();
        loadData();
    }
    
    public void showAllDSNCC(ArrayList<NhaCungCapDTO> dsncc){
        dtmNhaCungCap.setRowCount(0);
        for(int i=0;i<dsncc.size();i++){
            dtmNhaCungCap.addRow(new String[]{
                dsncc.get(i).getMaNCC(),
                dsncc.get(i).getTenNCC(),
                dsncc.get(i).getDiaChi(),
                dsncc.get(i).getSoDT()
            });
        }
    }
    
    public void loadData(){
        nccBUS.docDanhSach();
        ArrayList<NhaCungCapDTO> dsncc = nccBUS.getListNhaCungCap();
        showAllDSNCC(dsncc);
    }
    public void init() {
        //set giao diện cho Table
        //DSNV
        tblDSNCC.setFocusable(false);
        tblDSNCC.setIntercellSpacing(new Dimension(0, 0));
        tblDSNCC.setRowHeight(25);
        tblDSNCC.setFillsViewportHeight(true);
        tblDSNCC.getTableHeader().setOpaque(false);
        tblDSNCC.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSNCC.getTableHeader().setForeground(Color.WHITE);
        tblDSNCC.setSelectionBackground(new Color(188, 206, 248));
        tblDSNCC.setSelectionForeground(Color.BLACK);
        tblDSNCC.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSNCC.getTableHeader().setReorderingAllowed(false);
        tblDSNCC.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
    }
    
    public String getMaNCC(){
        return txtMaNCC.getText();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnHeader2 = new javax.swing.JPanel();
        btnClose1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnChonLoai = new javax.swing.JLabel();
        btnBoChon = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenNCC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSNCC = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 247, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        pnHeader2.setBackground(new java.awt.Color(152, 168, 248));
        pnHeader2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 0, 0)));
        pnHeader2.setPreferredSize(new java.awt.Dimension(102, 40));
        pnHeader2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClose1MouseClicked(evt);
            }
        });
        pnHeader2.add(btnClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 0, 49, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblKhachHang.png"))); // NOI18N
        pnHeader2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 52, -1));

        jLabel10.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        jLabel10.setText("QUẢN LÝ NHÀ CUNG CẤP");
        pnHeader2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 0, -1, 40));

        jPanel7.setBackground(new java.awt.Color(250, 247, 240));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỌN NHÀ CUNG CẤP", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChonLoai.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonLoai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChonLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/check-mark.png"))); // NOI18N
        btnChonLoai.setText("Chọn NCC");
        btnChonLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonLoaiMouseClicked(evt);
            }
        });
        jPanel7.add(btnChonLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 130, -1));

        btnBoChon.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnBoChon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBoChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel.png"))); // NOI18N
        btnBoChon.setText("Bỏ chọn");
        btnBoChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBoChonMouseClicked(evt);
            }
        });
        jPanel7.add(btnBoChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 122, -1));
        jPanel7.add(txtMaNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 148, 27));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Mã NCC");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 60, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Tên NCC");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 60, -1));
        jPanel7.add(txtTenNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 148, 27));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Địa chỉ");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));
        jPanel7.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 148, 27));
        jPanel7.add(txtSoDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 148, 27));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Số ĐT");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 62, -1));

        tblDSNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", null, null, null}
            },
            new String [] {
                "Mã NCC", "Tên NCC", "Địa chỉ", "Số ĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNCCMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSNCC);

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, 630, 280));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pnHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClose1MouseClicked
        dispose();
    }//GEN-LAST:event_btnClose1MouseClicked

    private void btnChonLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonLoaiMouseClicked
        dispose();

    }//GEN-LAST:event_btnChonLoaiMouseClicked

    private void btnBoChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoChonMouseClicked
        dispose();
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        txtSoDT.setText("");
        
    }//GEN-LAST:event_btnBoChonMouseClicked

    private void tblDSNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNCCMouseClicked
        int k = tblDSNCC.getSelectedRow();
        txtMaNCC.setText(tblDSNCC.getValueAt(k,0).toString());
        txtTenNCC.setText(tblDSNCC.getValueAt(k,1).toString());
        txtDiaChi.setText(tblDSNCC.getValueAt(k,2).toString());
        txtSoDT.setText(tblDSNCC.getValueAt(k,3).toString());
       
        txtMaNCC.setEnabled(false);
        txtTenNCC.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtSoDT.setEnabled(false);
    }//GEN-LAST:event_tblDSNCCMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBoChon;
    private javax.swing.JLabel btnChonLoai;
    private javax.swing.JLabel btnClose1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnHeader2;
    private javax.swing.JTable tblDSNCC;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTenNCC;
    // End of variables declaration//GEN-END:variables
}
