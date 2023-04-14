/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.KhoBUS;
import DTO.KhoDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wizardsc
 */
public class KhoGUI extends javax.swing.JPanel {
    KhoBUS khoBUS = new KhoBUS();
    DefaultTableModel dtmKho;
    DefaultComboBoxModel dcbmDuLieu;
    private BufferedImage i = null;
    String imgName = "null";
    String tuKhoaTimKiem;
    boolean clickedOnce = false;
    public KhoGUI() {
        initComponents();
        dtmKho = (DefaultTableModel) tblDSSP.getModel();
        dcbmDuLieu = (DefaultComboBoxModel) cbxDuLieu.getModel();
        
        init();
        loadDataKho();
        loaddataCBX();
        
    }
    
    public void init(){
        //set giao diện cho Table
        //DSSP
        tblDSSP.setFocusable(false);
        tblDSSP.setIntercellSpacing(new Dimension(0, 0));
        tblDSSP.setRowHeight(25);
        tblDSSP.setFillsViewportHeight(true);
        tblDSSP.getTableHeader().setOpaque(false);
        tblDSSP.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSSP.getTableHeader().setForeground(Color.WHITE);
        tblDSSP.setSelectionBackground(new Color(188, 206, 248));
        tblDSSP.setSelectionForeground(Color.BLACK);
        tblDSSP.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSSP.getTableHeader().setReorderingAllowed(false);
        tblDSSP.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
        
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(tuKhoaTimKiem);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(tuKhoaTimKiem);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               search(tuKhoaTimKiem);
            }
        });
    }
    public void search(String tk){
        if (tk.equals("Mã SP")){
            khoBUS.docDanhSach();
            ArrayList<KhoDTO> dskho = khoBUS.searchMaSP(txtTimKiem.getText());
            showAllDSKho(dskho);
        }
        if (tk.equals("Tên SP")){
            khoBUS.docDanhSach();
            ArrayList<KhoDTO> dskho = khoBUS.searchTenSP(txtTimKiem.getText());
            showAllDSKho(dskho);
        }
        if (tk.equals("Đơn vị tính")){
            khoBUS.docDanhSach();
            ArrayList<KhoDTO> dskho = khoBUS.searchDonViTinh(txtTimKiem.getText());
            showAllDSKho(dskho);
        }
       
    }
    public void showAllDSKho(ArrayList<KhoDTO> dskho){
        dtmKho.setRowCount(0);
        for(int i=0;i<dskho.size();i++){
            dtmKho.addRow(new String[]{
                dskho.get(i).getMaSP(),
                dskho.get(i).getTenSP(),
                String.valueOf(dskho.get(i).getSoLuong()),
                String.valueOf(dskho.get(i).getGiaNhap()),
                dskho.get(i).getDonViTinh(),
                dskho.get(i).getMaLoai(),
                dskho.get(i).getIMG(),
            });
            
            
        }
    }
    
//    Đổ dữ liệu vào combobox
    public void loaddataCBX(){
        
        khoBUS.docDanhSach();
        ArrayList<KhoDTO> dskho = khoBUS.getListKho();
        HashSet<String> unique = new HashSet<>();
        for (KhoDTO kho : dskho) {
            unique.add(kho.getMaLoai());
        }
        for(String MaLoai : unique ){
            cbxDuLieu.addItem(MaLoai);        
        }
    }
    public void loadDataKho(){
        khoBUS.docDanhSach();
        ArrayList<KhoDTO> dskho = khoBUS.getListKho();
        showAllDSKho(dskho);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRoot = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSSP = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblMaSP = new javax.swing.JLabel();
        lblHo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        txtMaLoai = new javax.swing.JTextField();
        txtIMG = new javax.swing.JLabel();
        cbxDonViTinh = new javax.swing.JComboBox<>();
        btnLoai = new javax.swing.JButton();
        btnChonAnh = new javax.swing.JLabel();
        btnChinhSua = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxTimKiem = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiemNC = new javax.swing.JLabel();
        cbxTimKiemNC = new javax.swing.JComboBox<>();
        lblMaPN2 = new javax.swing.JLabel();
        txtFrom = new javax.swing.JTextField();
        lblMaPN1 = new javax.swing.JLabel();
        txtTo = new javax.swing.JTextField();
        cbxDuLieu = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnImportExcel = new javax.swing.JLabel();
        btnExportExcel = new javax.swing.JLabel();

        pnRoot.setBackground(new java.awt.Color(250, 247, 240));
        pnRoot.setPreferredSize(new java.awt.Dimension(1089, 750));

        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Đơn giá ", "Đơn vị tính", "Mã loại", "IMG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSSP);

        jPanel1.setBackground(new java.awt.Color(250, 247, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QUẢN LÝ SẢN PHẨM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Baloo 2 ExtraBold", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaSP.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP.setText("Mã SP");
        jPanel1.add(lblMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 41, -1, -1));

        lblHo.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblHo.setText("Tên SP");
        jPanel1.add(lblHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 83, -1, -1));

        jLabel3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel3.setText("Số Lượng");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Đơn giá");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 262, -1, -1));
        jPanel1.add(txtMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 39, 180, 24));
        jPanel1.add(txtTenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 81, 353, 24));
        jPanel1.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 218, 181, 24));
        jPanel1.add(txtDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 260, 180, 24));

        jLabel5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel5.setText("Đơn vị tính");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 125, -1, -1));

        lblDiaChi.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblDiaChi.setText("Mã loại");
        jPanel1.add(lblDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 167, -1, -1));
        jPanel1.add(txtMaLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 165, 181, 24));

        txtIMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIMG.setText("IMAGE");
        txtIMG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(txtIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 190, 237));

        cbxDonViTinh.setEditable(true);
        cbxDonViTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cái", "Tấm" }));
        jPanel1.add(cbxDonViTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 123, 178, 24));

        btnLoai.setText("...");
        btnLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 165, 42, -1));

        btnChonAnh.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/upload.png"))); // NOI18N
        btnChonAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChonAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonAnhMouseClicked(evt);
            }
        });
        jPanel1.add(btnChonAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, -1, -1));

        btnChinhSua.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnUpdate.png"))); // NOI18N
        btnChinhSua.setText("Sửa");
        btnChinhSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChinhSuaMouseClicked(evt);
            }
        });
        jPanel1.add(btnChinhSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        jPanel2.setBackground(new java.awt.Color(250, 247, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        cbxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã SP", "Tên SP", "Đơn vị tính" }));
        cbxTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemActionPerformed(evt);
            }
        });
        jPanel2.add(cbxTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 100, 30));

        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        jPanel2.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 190, 30));

        btnTimKiemNC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTimKiemNC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemNCMouseClicked(evt);
            }
        });
        jPanel2.add(btnTimKiemNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        cbxTimKiemNC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đơn giá" }));
        cbxTimKiemNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemNCActionPerformed(evt);
            }
        });
        jPanel2.add(cbxTimKiemNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 100, 30));

        lblMaPN2.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPN2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaPN2.setText("Từ");
        jPanel2.add(lblMaPN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 30, 30));
        jPanel2.add(txtFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 140, 30));

        lblMaPN1.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaPN1.setText("Đến");
        jPanel2.add(lblMaPN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 40, 30));
        jPanel2.add(txtTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 140, 30));

        cbxDuLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn mã loại" }));
        cbxDuLieu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDuLieuItemStateChanged(evt);
            }
        });
        jPanel2.add(cbxDuLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 300, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        btnImportExcel.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnImportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import.png"))); // NOI18N
        btnImportExcel.setText("Nhập Excel");
        btnImportExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImportExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportExcelMouseClicked(evt);
            }
        });

        btnExportExcel.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnExportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xls.png"))); // NOI18N
        btnExportExcel.setText("Xuất Excel");
        btnExportExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExportExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportExcelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRootLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnRootLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnRootLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnRootLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btnImportExcel)
                                .addGap(38, 38, 38)
                                .addComponent(btnExportExcel)))
                        .addGap(5, 5, 5)))
                .addGap(18, 18, 18))
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRootLayout.createSequentialGroup()
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnRootLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExportExcel)
                            .addComponent(btnImportExcel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 1087, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 678, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSPMouseClicked
        int k = tblDSSP.getSelectedRow();
        txtMaSP.setText(tblDSSP.getModel().getValueAt(k, 0).toString());
        txtTenSP.setText(tblDSSP.getModel().getValueAt(k, 1).toString());
        txtSoLuong.setText(tblDSSP.getModel().getValueAt(k, 2).toString());
        txtDonGia.setText(tblDSSP.getModel().getValueAt(k, 3).toString());
        cbxDonViTinh.setSelectedItem(tblDSSP.getModel().getValueAt(k, 4).toString());
        txtMaLoai.setText(tblDSSP.getModel().getValueAt(k, 5).toString());
        imgName = tblDSSP.getModel().getValueAt(k, 6).toString();
        Image newImage;
        newImage = new ImageIcon("./src/image/SanPham/" + imgName).getImage().getScaledInstance(200,250, Image.SCALE_DEFAULT);
        txtIMG.setIcon(new ImageIcon(newImage));

        txtMaSP.setEnabled(false);
    }//GEN-LAST:event_tblDSSPMouseClicked

    private void btnLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiActionPerformed
//        LoaiGUI.setUndecorated(true);
//        LoaiGUI.pack();
//        LoaiGUI.setLocationRelativeTo(null);
//        LoaiGUI.setVisible(true);
    }//GEN-LAST:event_btnLoaiActionPerformed

    private void btnChonAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonAnhMouseClicked
//        JFileChooser fc = new JFileChooser("./src/image/SanPham");
//        FileNameExtensionFilter filter = new FileNameExtensionFilter(
//            "JPG, PNG & JPEG images", "jpg", "png", "jpeg");
//        fc.setFileFilter(filter);
//        int result = fc.showOpenDialog(null);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            try {
//                File file = fc.getSelectedFile(); //Lấy URL hình
//                i = ImageIO.read(file); // Lấy hình
//                imgName = txtMaSP.getText().concat(".jpg"); //Tên hình
//                // Thay đổi hình hiển thị
//                txtIMG.setText("");
//                txtIMG.setIcon(new ImageIcon(i.getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
//
//                revalidate();
//                repaint();
//            } catch (IOException ex) {
//                Logger.getLogger(SanPhamForQLGUI.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_btnChonAnhMouseClicked

    private void btnChinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChinhSuaMouseClicked
//        String MaSP = txtMaSP.getText();
//        String TenSP = txtTenSP.getText();
//        String SoLuong = txtSoLuong.getText();
//        String DonGia = txtDonGia.getText();
//        String DonViTinh = cbxDonViTinh.getSelectedItem().toString();
//        String MaLoai = txtMaLoai.getText();
//        String IMG = imgName;
//        SanPhamDTO sp = new SanPhamDTO(MaSP, TenSP, Integer.parseInt(SoLuong), Integer.parseInt(DonGia), DonViTinh, MaLoai, IMG);
//        spBUS.update(sp);
//        saveIMG();
//        loadData();
    }//GEN-LAST:event_btnChinhSuaMouseClicked

    private void cbxTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemActionPerformed
        tuKhoaTimKiem = cbxTimKiem.getSelectedItem().toString();
        
        System.out.println(tuKhoaTimKiem);
    }//GEN-LAST:event_cbxTimKiemActionPerformed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
//        txtMaNCC.setText("");
//        txtMaNV.setText("");
//        txtMaPN.setText("");
//        txtNgayLap.setDate(null);
//        txtTongTien.setText("");
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void btnTimKiemNCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemNCMouseClicked
        if(!clickedOnce){
            ArrayList<KhoDTO> dskho = khoBUS.searchDonGia(Integer.parseInt(txtFrom.getText()), Integer.parseInt(txtTo.getText()));
            showAllDSKho(dskho);
            clickedOnce = true;
        } else {
            txtFrom.setText("");
            txtTo.setText("");
            loadDataKho();
            clickedOnce = false;
        }
    }//GEN-LAST:event_btnTimKiemNCMouseClicked

    private void cbxTimKiemNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemNCActionPerformed
        //        tuKhoaTimKiem = cbxTimKiemNC.getSelectedItem().toString();
        //        System.out.println(tuKhoaTimKiem);
    }//GEN-LAST:event_cbxTimKiemNCActionPerformed

    private void cbxDuLieuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDuLieuItemStateChanged
        tuKhoaTimKiem = cbxDuLieu.getSelectedItem().toString();
        if(tuKhoaTimKiem.equals("Danh sach")){
            khoBUS.docDanhSach();
            ArrayList<KhoDTO> dskho = khoBUS.getListKho();
            showAllDSKho(dskho);
            loadDataKho();
        } else {
             khoBUS.docDanhSach();
        ArrayList<KhoDTO> dskho = khoBUS.searchMaLoai(tuKhoaTimKiem);
        showAllDSKho(dskho);
        }
       
    }//GEN-LAST:event_cbxDuLieuItemStateChanged

    private void btnImportExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportExcelMouseClicked
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/checkOption.png"));
        JFileChooser fc = new JFileChooser("./reports");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Excel", "xlsx");
        fc.setFileFilter(filter);
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile(); //Lấy URL
            khoBUS.importExcel(file);
            khoBUS.listKho();
            JOptionPane.showMessageDialog(null, "Đã nhập file excel thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE, icon);

        }

        loadDataKho();
    }//GEN-LAST:event_btnImportExcelMouseClicked

    private void btnExportExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportExcelMouseClicked
        khoBUS.ExportExcel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/checkOption.png"));
        JOptionPane.showMessageDialog(null, "Đã xuất file excel thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_btnExportExcelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChinhSua;
    private javax.swing.JLabel btnChonAnh;
    private javax.swing.JLabel btnExportExcel;
    private javax.swing.JLabel btnImportExcel;
    private javax.swing.JButton btnLoai;
    private javax.swing.JLabel btnTimKiemNC;
    private javax.swing.JComboBox<String> cbxDonViTinh;
    private javax.swing.JComboBox<String> cbxDuLieu;
    private javax.swing.JComboBox<String> cbxTimKiem;
    private javax.swing.JComboBox<String> cbxTimKiemNC;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMaPN1;
    private javax.swing.JLabel lblMaPN2;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JTable tblDSSP;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JLabel txtIMG;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}
