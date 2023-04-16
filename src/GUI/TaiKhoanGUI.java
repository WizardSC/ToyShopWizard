/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.TaiKhoanBUS;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class TaiKhoanGUI extends javax.swing.JPanel {

    private ArrayList<TaiKhoanDTO> dstk = new ArrayList<>();
    private TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    private TaiKhoanDAO tkDAO = new TaiKhoanDAO();

    DefaultTableModel model;
    DefaultComboBoxModel dcbmNhanVien;

    public TaiKhoanGUI() {
        initComponents();
        init();

        model = (DefaultTableModel) tblDSTK.getModel();
        dcbmNhanVien = (DefaultComboBoxModel) cbxNhanVien.getModel();
//        dcbmNhanVien = cbx

        loadlenCBX();
        loadData();
    }

    public void init() {

        tblDSTK.setFocusable(false);
        tblDSTK.setIntercellSpacing(new Dimension(0, 0));

        tblDSTK.setRowHeight(30);
        tblDSTK.setFillsViewportHeight(true);

        tblDSTK.getTableHeader().setOpaque(false);
        tblDSTK.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSTK.getTableHeader().setForeground(Color.WHITE);
        tblDSTK.setSelectionBackground(new Color(188, 206, 248));
        tblDSTK.setFont(new Font("Arial", Font.PLAIN, 13));

        tblDSTK.getTableHeader().setReorderingAllowed(false);
        tblDSTK.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));

    }

    public void showAll(ArrayList<TaiKhoanDTO> dstk) {
        model.setRowCount(0);
        for (int i = 0; i < dstk.size(); i++) {
            model.addRow(new String[]{
                dstk.get(i).getMaNV(),
                dstk.get(i).getTenDangNhap(),
                dstk.get(i).getMatKhau(),
                String.valueOf(dstk.get(i).isTinhTrang())
            });
        }
    }

    public void loadData() {
        tkBUS.docDanhSach();
        ArrayList<TaiKhoanDTO> dstk = tkBUS.getListTaiKhoan();
        showAll(dstk);

    }

    public void loadlenCBX() {
        tkBUS.docDanhSach1();
        ArrayList<TaiKhoanDTO> dstk = tkBUS.getListMaNVChuaCoTK();
        dcbmNhanVien.removeAllElements();
        for (int i = 0; i < dstk.size(); i++) {
            cbxNhanVien.addItem(dstk.get(i).getMaNV());

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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTenDangNhap1 = new javax.swing.JTextField();
        lblMaCV = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMatKhau1 = new javax.swing.JTextField();
        lblMaCV1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JLabel();
        cbxTinhTrang = new javax.swing.JComboBox<>();
        cbxNhanVien = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnXoa = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenDangNhap3 = new javax.swing.JTextField();
        txtTinhTrang2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSTK = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMatKhau2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTenDangNhap2 = new javax.swing.JTextField();
        btnDatMatKhau = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMatKhauMoi = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1089, 700));

        jPanel2.setBackground(new java.awt.Color(250, 247, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(1089, 700));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(250, 247, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TẠO TÀI KHOẢN MỚI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Baloo 2 ExtraBold", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel3.setText("Tên đăng nhập");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));
        jPanel1.add(txtTenDangNhap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 168, 26));

        lblMaCV.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaCV.setText("Mã NV");
        jPanel1.add(lblMaCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel5.setText("Mật khẩu");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));
        jPanel1.add(txtMatKhau1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 169, 26));

        lblMaCV1.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaCV1.setText("Tình trạng");
        jPanel1.add(lblMaCV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        btnThem.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnAdd.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        cbxTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "true" }));
        jPanel1.add(cbxTinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 170, 30));

        cbxNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 170, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 377, 270));

        jPanel3.setBackground(new java.awt.Color(250, 247, 240));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KHÓA TÀI KHOẢN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnXoa.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/padlock.png"))); // NOI18N
        btnXoa.setText("Khóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        jPanel3.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel7.setText("Tên đăng nhập");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));
        jPanel3.add(txtTenDangNhap3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 150, 26));
        jPanel3.add(txtTinhTrang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 150, 26));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 3, 310, 170));

        tblDSTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên Đăng Nhập", "Mật Khẩu", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSTKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSTK);
        if (tblDSTK.getColumnModel().getColumnCount() > 0) {
            tblDSTK.getColumnModel().getColumn(0).setResizable(false);
            tblDSTK.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblDSTK.getColumnModel().getColumn(1).setResizable(false);
            tblDSTK.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblDSTK.getColumnModel().getColumn(2).setResizable(false);
            tblDSTK.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblDSTK.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 286, 1067, 390));

        jPanel4.setBackground(new java.awt.Color(250, 247, 240));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Baloo 2 ExtraBold", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NV" }));
        jComboBox1.setFocusable(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 180, 310, -1));

        jPanel5.setBackground(new java.awt.Color(250, 247, 240));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ĐẶT LẠI MẬT KHẨU", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Baloo 2 ExtraBold", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Tên đăng nhập");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        jPanel5.add(txtMatKhau2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 168, 26));

        jLabel6.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel6.setText("Mật khẩu cũ");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));
        jPanel5.add(txtTenDangNhap2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 168, 26));

        btnDatMatKhau.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnDatMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnReset.png"))); // NOI18N
        btnDatMatKhau.setText("Đặt lại mật khẩu");
        btnDatMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDatMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDatMatKhauMouseClicked(evt);
            }
        });
        jPanel5.add(btnDatMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel8.setText("Mật khẩu mới");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        jPanel5.add(txtMatKhauMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 168, 26));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 350, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        String TenDangNhap = txtTenDangNhap1.getText();
        String MatKhau = txtMatKhau1.getText();
        String MaNV = cbxNhanVien.getSelectedItem().toString();
        boolean TinhTrang = Boolean.parseBoolean(cbxTinhTrang.getSelectedItem().toString());
        TaiKhoanDTO tk = new TaiKhoanDTO(MaNV, TenDangNhap, MatKhau, TinhTrang);
        tkBUS.add(tk);
        loadData();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnDatMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatMatKhauMouseClicked
        String TenDangNhap = txtTenDangNhap2.getText();

        String MatKhau = txtMatKhau2.getText();
        String MatKhauMoi = txtMatKhauMoi.getText();
        tkBUS.update(MatKhau,MatKhauMoi, TenDangNhap);
        loadData();
    }//GEN-LAST:event_btnDatMatKhauMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        String TenDangNhap = txtTenDangNhap2.getText();
        String TinhTrang = txtTinhTrang2.getText();
        tkBUS.lock(Boolean.parseBoolean(TinhTrang), TenDangNhap);
        
        loadData();
    }//GEN-LAST:event_btnXoaMouseClicked

    private void tblDSTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSTKMouseClicked
        int k = tblDSTK.getSelectedRow();
        
        txtTenDangNhap2.setText(tblDSTK.getModel().getValueAt(k, 1).toString());
        txtTenDangNhap2.setEnabled(false);
        txtMatKhau2.setText(tblDSTK.getModel().getValueAt(k, 2).toString());
        String MatKhau = tblDSTK.getModel().getValueAt(k, 2).toString();
        txtMatKhau2.setEnabled(false);
        txtTenDangNhap3.setText(tblDSTK.getModel().getValueAt(k, 1).toString());
        txtTinhTrang2.setText(tblDSTK.getModel().getValueAt(k, 3).toString());
        String TT = tblDSTK.getModel().getValueAt(k, 3).toString();
        boolean TinhTrang = Boolean.parseBoolean(TT);
        System.out.println(TinhTrang);
        System.out.println(TT);
        
        if (MatKhau.equals("111111")){
            btnDatMatKhau.setText("Đặt mật khẩu mới");
            btnDatMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/password.png")));
        } else {
            btnDatMatKhau.setText("Reset mật khẩu");
            btnDatMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnReset.png")));
        }
        if (TinhTrang == false) {
            btnXoa.setText("Mở khóa");
            btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/unlock.png")));
        } else {
            btnXoa.setText("Khóa");
            btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/padlock.png")));
        }
    }//GEN-LAST:event_tblDSTKMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDatMatKhau;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JComboBox<String> cbxNhanVien;
    private javax.swing.JComboBox<String> cbxTinhTrang;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblMaCV;
    private javax.swing.JLabel lblMaCV1;
    private javax.swing.JTable tblDSTK;
    private javax.swing.JTextField txtMatKhau1;
    private javax.swing.JTextField txtMatKhau2;
    private javax.swing.JTextField txtMatKhauMoi;
    private javax.swing.JTextField txtTenDangNhap1;
    private javax.swing.JTextField txtTenDangNhap2;
    private javax.swing.JTextField txtTenDangNhap3;
    private javax.swing.JTextField txtTinhTrang2;
    // End of variables declaration//GEN-END:variables
}
