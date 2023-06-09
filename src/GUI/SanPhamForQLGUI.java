/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.SanPhamBUS;
import DTO.SanPhamDTO;
import DTO.SanPhamDTO;
import DTO.SanPham_ViTriDTO;
import MyCustom.XuLyException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
public class SanPhamForQLGUI extends javax.swing.JPanel {

    SanPhamBUS spBUS = new SanPhamBUS();
    DefaultTableModel dtmSanPham = new DefaultTableModel();
    String imgName = "null";
    private BufferedImage i = null;
    String tuKhoaTimKiem;
    boolean clickedOnce = false;

    public SanPhamForQLGUI() {
        initComponents();
        init();
        dtmSanPham = (DefaultTableModel) tblDSSP.getModel();
        loadData();
    }

    public void init() {

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

//        txtDonGia.setEnabled(false);
        txtSoLuong.setEnabled(false);
        txtMaSP.setEnabled(false);
//        txtDonGia.setEnabled(false)
        tuKhoaTimKiem = cbxTimKiem.getSelectedItem().toString();
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
        });;
        loaddataCBX();
    }

    public void loaddataCBX() {

        spBUS.docDanhSach();
        ArrayList<SanPhamDTO> dssp = spBUS.getListSanPham();
        HashSet<String> unique = new HashSet<>();
        for (SanPhamDTO sp : dssp) {
            unique.add(sp.getMaLoai());
        }
        for (String MaLoai : unique) {
            cbxDuLieu.addItem(MaLoai);
        }
    }

    public void search(String tk) {
        if (tk.equals("Mã SP")) {
            ArrayList<SanPhamDTO> dssp = spBUS.searchMaSP(txtTimKiem.getText().toString());
            showAll(dssp);
        }
        if (tk.equals("Tên SP")) {
            ArrayList<SanPhamDTO> dssp = spBUS.searchTenSP(txtTimKiem.getText().toString());
            showAll(dssp);
        }
    }
    //    public void showAll(ArrayList<SanPham_ViTriDTO> dssp) {
    //        dtmSanPham.setRowCount(0);
    //        for (int i = 0; i < dssp.size(); i++) {
    //            dtmSanPham.addRow(new String[]{
    //                dssp.get(i).getMaSP(),
    //                dssp.get(i).getTenSP(),
    //                String.valueOf(dssp.get(i).getSoLuong()),
    //                String.valueOf(dssp.get(i).getDonGia()),
    //                dssp.get(i).getDonViTinh(),
    //                dssp.get(i).getMaLoai(),
    //                dssp.get(i).getIMG()
    //            });
    //        }
    //    }

    public void showAll(ArrayList<SanPhamDTO> dssp) {
        dtmSanPham.setRowCount(0);
        for (int i = 0; i < dssp.size(); i++) {
            dtmSanPham.addRow(new String[]{
                dssp.get(i).getMaSP(),
                dssp.get(i).getTenSP(),
                String.valueOf(dssp.get(i).getSoLuong()),
                String.valueOf(dssp.get(i).getDonGia()),
                dssp.get(i).getDonViTinh(),
                dssp.get(i).getMaLoai(),
                dssp.get(i).getIMG()
            });
        }
    }
//    public void loadData() {
//        spBUS.docDanhSach1();
//        ArrayList<SanPham_ViTriDTO> dssp = spBUS.getListSPCuahang();
//        showAll(dssp);
//    }

    public void loadData() {
        spBUS.docDanhSach();
        ArrayList<SanPhamDTO> dssp = spBUS.getListSanPham();
        showAll(dssp);
        showMaSP(dssp);
    }

    public void saveIMG() {
        try {
            if (i != null) {
                File save = new File("src/image/SanPham/" + imgName);//Tạo file
                ImageIO.write(i, "jpg", save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex) {
            Logger.getLogger(SanPhamForQLGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //--    Hiển thị mã NV tiếp theo
    //--    Lấy mã NV mới nhất + 1 để ra mã NV cần được tạo
    public void showMaSP(ArrayList<SanPhamDTO> dssp) {
        if (dssp.isEmpty()) {
            txtMaSP.setText(String.valueOf("SP01"));
        }
        for (int i = 0; i < dssp.size(); i++) {
            int sum = Integer.parseInt(dssp.get(i).getMaSP().substring(2)) + 1;
            if (sum < 10) {
                txtMaSP.setText(String.valueOf("SP0") + sum);
            } else {
                txtMaSP.setText(String.valueOf("SP") + sum);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
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
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        btnChinhSua = new javax.swing.JLabel();
        btnImportExcel = new javax.swing.JLabel();
        btnExportExcel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
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

        setPreferredSize(new java.awt.Dimension(1089, 750));

        jPanel2.setBackground(new java.awt.Color(250, 247, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(1089, 750));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        if (tblDSSP.getColumnModel().getColumnCount() > 0) {
            tblDSSP.getColumnModel().getColumn(0).setResizable(false);
            tblDSSP.getColumnModel().getColumn(1).setResizable(false);
            tblDSSP.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblDSSP.getColumnModel().getColumn(2).setResizable(false);
            tblDSSP.getColumnModel().getColumn(3).setResizable(false);
            tblDSSP.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblDSSP.getColumnModel().getColumn(4).setResizable(false);
            tblDSSP.getColumnModel().getColumn(5).setResizable(false);
            tblDSSP.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 1065, 370));

        jPanel1.setBackground(new java.awt.Color(250, 247, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QUẢN LÝ SẢN PHẨM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Baloo 2 ExtraBold", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N

        lblMaSP.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP.setText("Mã SP");

        lblHo.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblHo.setText("Tên SP");

        jLabel3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel3.setText("Số Lượng");

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Đơn giá");

        jLabel5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel5.setText("Đơn vị tính");

        lblDiaChi.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblDiaChi.setText("Mã loại");

        txtIMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIMG.setText("IMAGE");
        txtIMG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        cbxDonViTinh.setEditable(true);
        cbxDonViTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cái", "Hộp", "Bộ", "" }));

        btnLoai.setText("...");
        btnLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiActionPerformed(evt);
            }
        });

        btnChonAnh.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/upload.png"))); // NOI18N
        btnChonAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChonAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaSP)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lblHo)
                    .addComponent(jLabel5)
                    .addComponent(lblDiaChi))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
                                .addGap(12, 12, 12)))
                        .addComponent(txtIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChonAnh)
                        .addGap(71, 71, 71))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaSP))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHo)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiaChi)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLoai))
                    .addComponent(btnChonAnh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 290));

        jPanel4.setBackground(new java.awt.Color(250, 247, 240));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỨC NĂNG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N

        btnThem.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnAdd.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnDelete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        btnChinhSua.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnUpdate.png"))); // NOI18N
        btnChinhSua.setText("Sửa");
        btnChinhSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChinhSuaMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(53, 53, 53)
                        .addComponent(btnChinhSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(btnImportExcel)
                        .addGap(42, 42, 42)
                        .addComponent(btnExportExcel)))
                .addGap(56, 56, 56))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnChinhSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExportExcel)
                    .addComponent(btnImportExcel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 0, 440, 140));

        jPanel3.setBackground(new java.awt.Color(250, 247, 240));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        cbxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã SP", "Tên SP" }));
        cbxTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemActionPerformed(evt);
            }
        });
        jPanel3.add(cbxTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 120, 30));

        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        jPanel3.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 240, 30));

        btnTimKiemNC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTimKiemNC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemNCMouseClicked(evt);
            }
        });
        jPanel3.add(btnTimKiemNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        cbxTimKiemNC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đơn giá" }));
        cbxTimKiemNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemNCActionPerformed(evt);
            }
        });
        jPanel3.add(cbxTimKiemNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 100, 30));

        lblMaPN2.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPN2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaPN2.setText("Từ");
        jPanel3.add(lblMaPN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 30, 30));
        jPanel3.add(txtFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 100, 30));

        lblMaPN1.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaPN1.setText("Đến");
        jPanel3.add(lblMaPN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 40, 30));
        jPanel3.add(txtTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 100, 30));

        cbxDuLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn mã loại" }));
        cbxDuLieu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDuLieuItemStateChanged(evt);
            }
        });
        jPanel3.add(cbxDuLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 370, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 440, 150));

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

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        String MaSP = txtMaSP.getText().toUpperCase();
        String TenSP = txtTenSP.getText();
        int SoLuong = 0;

        String DonViTinh = cbxDonViTinh.getSelectedItem().toString();
        String MaLoai = txtMaLoai.getText();
        String IMG = imgName;
        if (MaSP.trim().equals("") || TenSP.trim().equals("") || DonViTinh.trim().equals("") || MaLoai.trim().equals("") || txtDonGia.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin sản phẩm");
        } else {
            int DonGia = Integer.parseInt(txtDonGia.getText());
            SanPhamDTO sp = new SanPhamDTO(MaSP, TenSP, SoLuong, DonGia, DonViTinh, MaLoai, IMG);
            spBUS.add(sp);
            loadData();
        }

        //        NhanVienDTO nv = new NhanVienDTO(MaNV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SoDT, Integer.parseInt(Luong), IMG);
        //        nvBUS.add(nv);
        //        saveIMG();
        //        loadData();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        //JOptionPane.showConfirmDialog(this,"Bạn muốn xóa sản phẩm này?");
//                spBUS.delete(txtMaSP.getText());
//                saveIMG();
//                loadData();

        String MaSP = txtMaSP.getText();
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sản phẩm không?");
        if (result == JOptionPane.YES_OPTION) {
            try {
                spBUS.delete(MaSP);
                loadData();
            } catch (XuLyException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa sản phẩm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnChinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChinhSuaMouseClicked
        String MaSP = txtMaSP.getText();
        String TenSP = txtTenSP.getText();
        String SoLuong = txtSoLuong.getText();
        String DonGia = txtDonGia.getText();
        String DonViTinh = cbxDonViTinh.getSelectedItem().toString();
        String MaLoai = txtMaLoai.getText();
        String IMG = imgName;
        SanPhamDTO sp = new SanPhamDTO(MaSP, TenSP, Integer.parseInt(SoLuong), Integer.parseInt(DonGia), DonViTinh, MaLoai, IMG);
        spBUS.update(sp);
        saveIMG();
        loadData();
    }//GEN-LAST:event_btnChinhSuaMouseClicked

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
        newImage = new ImageIcon("./src/image/SanPham/" + imgName).getImage().getScaledInstance(170, 203, Image.SCALE_DEFAULT);
        txtIMG.setIcon(new ImageIcon(newImage));

        txtMaSP.setEnabled(false);
    }//GEN-LAST:event_tblDSSPMouseClicked

    private void btnLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiActionPerformed
        LoaiGUI loai = new LoaiGUI();
        loai.setVisible(true);
        String MaLoai = loai.getMaLoai();
        txtMaLoai.setText(MaLoai);
    }//GEN-LAST:event_btnLoaiActionPerformed

    private void btnChonAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonAnhMouseClicked
        JFileChooser fc = new JFileChooser("./src/image/SanPham");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, PNG & JPEG images", "jpg", "png", "jpeg");
        fc.setFileFilter(filter);
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile(); //Lấy URL hình
                i = ImageIO.read(file); // Lấy hình
                imgName = txtMaSP.getText().concat(".jpg"); //Tên hình
                // Thay đổi hình hiển thị
                txtIMG.setText("");
                txtIMG.setIcon(new ImageIcon(i.getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

                revalidate();
                repaint();
            } catch (IOException ex) {
                Logger.getLogger(SanPhamForQLGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnChonAnhMouseClicked

    private void btnImportExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportExcelMouseClicked
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/checkOption.png"));
        JFileChooser fc = new JFileChooser("./reports");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Excel", "xlsx");
        fc.setFileFilter(filter);
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile(); //Lấy URL
            spBUS.importExcel(file);
            spBUS.listSP();
            JOptionPane.showMessageDialog(null, "Đã nhập file excel thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE, icon);

        }

        loadData();
    }//GEN-LAST:event_btnImportExcelMouseClicked

    private void btnExportExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportExcelMouseClicked
        spBUS.ExportExcel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/checkOption.png"));
        JOptionPane.showMessageDialog(null, "Đã xuất file excel thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_btnExportExcelMouseClicked

    private void cbxTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemActionPerformed
        tuKhoaTimKiem = cbxTimKiem.getSelectedItem().toString();
        System.out.println(tuKhoaTimKiem);
        txtTimKiem.setText("");
    }//GEN-LAST:event_cbxTimKiemActionPerformed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        //        txtMaNCC.setText("");
        //        txtMaNV.setText("");
        //        txtMaPN.setText("");
        //        txtNgayLap.setDate(null);
        //        txtTongTien.setText("");
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void btnTimKiemNCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemNCMouseClicked
        if (!clickedOnce) {
            ArrayList<SanPhamDTO> dssp = spBUS.searchDonGia(Integer.parseInt(txtFrom.getText()), Integer.parseInt(txtTo.getText()));
            showAll(dssp);
            clickedOnce = true;
        } else {
            txtFrom.setText("");
            txtTo.setText("");
            loadData();
            clickedOnce = false;
        }
    }//GEN-LAST:event_btnTimKiemNCMouseClicked

    private void cbxTimKiemNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemNCActionPerformed
        tuKhoaTimKiem = cbxTimKiemNC.getSelectedItem().toString();
        System.out.println(tuKhoaTimKiem);
    }//GEN-LAST:event_cbxTimKiemNCActionPerformed

    private void cbxDuLieuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDuLieuItemStateChanged
        tuKhoaTimKiem = cbxDuLieu.getSelectedItem().toString();
        if(tuKhoaTimKiem.equals("Danh sach")){
            spBUS.docDanhSach();
            ArrayList<SanPhamDTO> dssp = spBUS.getListSanPham();
            showAll(dssp);
            loadData();
        } else {
            spBUS.docDanhSach();
            ArrayList<SanPhamDTO> dssp = spBUS.searchMaLoai(tuKhoaTimKiem);
            showAll(dssp);
        }

    }//GEN-LAST:event_cbxDuLieuItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChinhSua;
    private javax.swing.JLabel btnChonAnh;
    private javax.swing.JLabel btnExportExcel;
    private javax.swing.JLabel btnImportExcel;
    private javax.swing.JButton btnLoai;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnTimKiemNC;
    private javax.swing.JLabel btnXoa;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMaPN1;
    private javax.swing.JLabel lblMaPN2;
    private javax.swing.JLabel lblMaSP;
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
