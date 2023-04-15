/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
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
public class RCNhanVienGUI extends javax.swing.JDialog {

    DefaultTableModel dtmNhanVien;
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
    String MaCV;
    public RCNhanVienGUI(String MaCV) {
        setUndecorated(true);
        initComponents();
        this.setModal(true);
        this.setResizable(false);
        setLocationRelativeTo(null);
        dtmNhanVien = (DefaultTableModel) tblDSNV.getModel();
        init();
        
        
        this.MaCV = MaCV;
        loadDataDSNVTheoMaCV();

    }
    
    public void init() {
        //set giao diện cho Table
        //DSNV
        tblDSNV.setFocusable(false);
        tblDSNV.setIntercellSpacing(new Dimension(0, 0));
        tblDSNV.setRowHeight(25);
        tblDSNV.setFillsViewportHeight(true);
        tblDSNV.getTableHeader().setOpaque(false);
        tblDSNV.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSNV.getTableHeader().setForeground(Color.WHITE);
        tblDSNV.setSelectionBackground(new Color(188, 206, 248));
        tblDSNV.setSelectionForeground(Color.BLACK);
        tblDSNV.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSNV.getTableHeader().setReorderingAllowed(false);
        tblDSNV.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
    }

    public void showAllDSNV(ArrayList<NhanVienDTO> dsnv) {

        dtmNhanVien.setRowCount(0);
        for (int i = 0; i < dsnv.size(); i++) {
            
                dtmNhanVien.addRow(new String[]{
                    dsnv.get(i).getMaNV(),
                    dsnv.get(i).getHo(),
                    dsnv.get(i).getTen(),
                    dsnv.get(i).getNgaySinh(),
                    dsnv.get(i).getGioiTinh()
                });
            

        }
    }

    public void loadDataDSNV() {
        System.out.println("MaCV o GUI" + MaCV);
        nvBUS.docDanhSachTheoMaCV(MaCV);
        ArrayList<NhanVienDTO> dsnv = nvBUS.getListNhanVien();
        showAllDSNV(dsnv);
    }
    public void loadDataDSNVTheoMaCV() {
        nvBUS.docDanhSachTheoMaCV(MaCV);
        ArrayList<NhanVienDTO> dsnv = nvBUS.getListNhanVienTheoMaCV(MaCV);
        showAllDSNV(dsnv);
    }
    //Hàm lấy Mã NV
    public String getMaNV() {
        return txtMaNV.getText();
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
        txtMaNV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSNV = new javax.swing.JTable();

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
        jLabel10.setText("QUẢN LÝ NHÂN VIÊN");
        pnHeader2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 0, -1, 40));

        jPanel7.setBackground(new java.awt.Color(250, 247, 240));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỌN NHÂN VIÊN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChonLoai.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonLoai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChonLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/check-mark.png"))); // NOI18N
        btnChonLoai.setText("Chọn NV");
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
        jPanel7.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 148, 27));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Mã NV");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 60, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Họ");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 60, -1));
        jPanel7.add(txtHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 148, 27));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Ngày sinh");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Tên");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 60, -1));
        jPanel7.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 148, 27));
        jPanel7.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 148, 27));
        jPanel7.add(txtGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 148, 27));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Giới tính");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 62, -1));

        tblDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ", "Tên", "Ngày sinh", "Giới tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNVMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSNV);

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
        txtMaNV.setText("");
        txtHo.setText("");
        txtTen.setText("");
        txtNgaySinh.setText("");
        txtGioiTinh.setText("");
    }//GEN-LAST:event_btnBoChonMouseClicked

    private void tblDSNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNVMouseClicked
        int k = tblDSNV.getSelectedRow();
        txtMaNV.setText(tblDSNV.getValueAt(k, 0).toString());
        txtHo.setText(tblDSNV.getValueAt(k, 1).toString());
        txtTen.setText(tblDSNV.getValueAt(k, 2).toString());
        txtNgaySinh.setText(tblDSNV.getValueAt(k, 3).toString());
        txtGioiTinh.setText(tblDSNV.getValueAt(k, 4).toString());

        txtMaNV.setEnabled(false);
        txtHo.setEnabled(false);
        txtTen.setEnabled(false);
        txtNgaySinh.setEnabled(false);
        txtGioiTinh.setEnabled(false);
    }//GEN-LAST:event_tblDSNVMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBoChon;
    private javax.swing.JLabel btnChonLoai;
    private javax.swing.JLabel btnClose1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnHeader2;
    private javax.swing.JTable tblDSNV;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
