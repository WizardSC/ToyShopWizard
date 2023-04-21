/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.CTHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.SanPhamBUS;
import BUS.XuatHoaDonBUS;
import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author wizardsc
 */
public class HoaDonGUI extends javax.swing.JPanel {

    CTHoaDonBUS cthdBUS = new CTHoaDonBUS();
    HoaDonBUS hdBUS = new HoaDonBUS();
    SanPhamBUS spBUS = new SanPhamBUS();
    DefaultTableModel dtmSanPham;
    DefaultTableModel dtmGioHang;
    DefaultTableModel dtmThongTinHD;
    int SoLuongSPTrongCuaHang; //khai báo SL sản phẩm hiện có trong cửa hàng
    String imgName = "null";
    private BufferedImage i = null;

    private ArrayList<CTHoaDonDTO> dscthd = new ArrayList<>();

    public HoaDonGUI() {
        initComponents();
        dtmSanPham = (DefaultTableModel) tblDSSP.getModel();
        dtmGioHang = (DefaultTableModel) tblGioHang.getModel();
        dtmThongTinHD = (DefaultTableModel) tblTTHD.getModel();
        init();
        loadDataDSSP();
        loadDataMaHD(); //load mã HD lên form

    }

    public void init() {
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

        //GioHang
        tblGioHang.setFocusable(false);
        tblGioHang.setIntercellSpacing(new Dimension(0, 0));
        tblGioHang.setRowHeight(25);
        tblGioHang.setFillsViewportHeight(true);
        tblGioHang.getTableHeader().setOpaque(false);
        tblGioHang.getTableHeader().setBackground(new Color(152, 168, 248));
        tblGioHang.getTableHeader().setForeground(Color.WHITE);
        tblGioHang.setSelectionBackground(new Color(188, 206, 248));
        tblGioHang.setSelectionForeground(Color.BLACK);
        tblGioHang.setFont(new Font("Arial", Font.PLAIN, 13));
        tblGioHang.getTableHeader().setReorderingAllowed(false);
        tblGioHang.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));

        //ThongTinHD
        //GioHang
        tblTTHD.setFocusable(false);
        tblTTHD.setIntercellSpacing(new Dimension(0, 0));
        tblTTHD.setRowHeight(25);
        tblTTHD.setFillsViewportHeight(true);
        tblTTHD.getTableHeader().setOpaque(false);
        tblTTHD.getTableHeader().setBackground(new Color(152, 168, 248));
        tblTTHD.getTableHeader().setForeground(Color.WHITE);
        tblTTHD.setSelectionBackground(new Color(188, 206, 248));
        tblTTHD.setSelectionForeground(Color.BLACK);
        tblTTHD.setFont(new Font("Arial", Font.PLAIN, 13));
        tblTTHD.getTableHeader().setReorderingAllowed(false);
        tblTTHD.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));

        //set SoLuong Spinner
        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, 0, 100, 1);
        txtSoLuong.setModel(modeSpinner);
        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) txtSoLuong.getEditor()).getTextField();
        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        txtSpinner.setEditable(true);
        txtSpinner.setHorizontalAlignment(JTextField.LEFT);
        txtSpinner.setBackground(Color.white);
        txtSpinner.setEditable(false);

        //set Enabled(false)
        txtMaSP.setEnabled(false);
        txtTenSP.setEnabled(false);
        txtDonGia.setEnabled(false);
//        txtSoLuong.setEnabled(false);
        txtMaSP.setEnabled(false);
        txtMaHD.setEnabled(false);
        txtMaKH.setEnabled(false);
        txtMaNV.setEnabled(false);
        txtTongTien.setEnabled(false);
        txtMaKM.setEnabled(false);
        txtThanhToan.setEnabled(false);
    }

    public void showAllDSSP(ArrayList<SanPhamDTO> dssp) {
        dtmSanPham.setRowCount(0);
        for (int i = 0; i < dssp.size(); i++) {
            dtmSanPham.addRow(new String[]{
                dssp.get(i).getMaSP(),
                dssp.get(i).getTenSP(),
                String.valueOf(dssp.get(i).getSoLuong()),
                String.valueOf(dssp.get(i).getDonGia()),
                dssp.get(i).getIMG()
            });
        }
    }
//--    Thêm hàng vào table Thông tin hóa đơn
//--    Chỉ thêm vào table dòng cuối cùng của hóa đơn

    public void showAllTTHD(ArrayList<HoaDonDTO> dshd) {
        dtmThongTinHD.setRowCount(0);
        int i = dshd.size() - 1;
        dtmThongTinHD.addRow(new String[]{
            dshd.get(i).getMaHD(),
            dshd.get(i).getMaKH(),
            dshd.get(i).getMaNV(),
            dshd.get(i).getNgayLap(),
            String.valueOf(dshd.get(i).getTongTien())
        });

    }
//--
//--    Load dữ liệu

    public void loadDataTTHD() {
        hdBUS.docDanhSach();
        ArrayList<HoaDonDTO> dshd = hdBUS.getListHoaDon();
        showAllTTHD(dshd);
    }
//--
//--    Load dữ liệu

    public void loadDataDSSP() {
        spBUS.docDanhSach();
        ArrayList<SanPhamDTO> dssp = spBUS.getListSanPham();
        showAllDSSP(dssp);
    }
//--

    private void loadDataCTHD() {

    }
//--    Hiển thị mã HD tiếp theo
//--    Lấy mã HD mới nhất + 1 để ra mã HD cần được tạo

    public void showMaHD(ArrayList<HoaDonDTO> dshd) {
        if (dshd.isEmpty()) {
            txtMaHD.setText(String.valueOf("HD01"));
        }
        for (int i = 0; i < dshd.size(); i++) {

            int sum = Integer.parseInt(dshd.get(i).getMaHD().substring(2)) + 1;
            if (sum < 10) {
                txtMaHD.setText(String.valueOf("HD0" + sum));
            } else {
                txtMaHD.setText(String.valueOf("HD" + sum));
            }
            sum = 0;

        }
    }
//--    
//--    Load mã hóa đơn mới nhất lên form

    private void loadDataMaHD() {
        hdBUS.docDanhSach();
        ArrayList<HoaDonDTO> dshd = hdBUS.getListHoaDon();
        showMaHD(dshd);
    }
//-- 

    private void loadDataGioHang() {
        dtmGioHang.setRowCount(0);
        ArrayList<SanPhamDTO> dssp = null;

    }
//-- Xuất sản phẩm vừa thêm vào giỏ hàng ra table

    public void outModelGioHang(DefaultTableModel dtmGioHang, ArrayList<CTHoaDonDTO> dscthd) {
        Vector data;
        dtmGioHang.setRowCount(0);
        for (int i = 0; i < dscthd.size(); i++) {
            dtmGioHang.addRow(new String[]{
                dscthd.get(i).getMaSP(),
                dscthd.get(i).getTenSP(),
                String.valueOf(dscthd.get(i).getSoLuong()),
                String.valueOf(dscthd.get(i).getDonGia()),
                String.valueOf(dscthd.get(i).getThanhTien())
            });
        }
    }
//--

//-- Tính tổng tiền hóa đơn
    public int sumHD() {
        int sum = 0;
        for (CTHoaDonDTO cthd : dscthd) {
            int SoLuong = cthd.getSoLuong();
            int DonGia = cthd.getDonGia();
            sum += SoLuong * DonGia;
        }
        return sum;
    }
//--Lấy tổng tiền ban đầu của hóa đơn

    public String getTongTien() {
        return txtTongTien.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InHoaDonGUI = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTTHD = new javax.swing.JTable();
        pnHeader1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtMaHDinTTHD = new javax.swing.JTextField();
        lblMaSP8 = new javax.swing.JLabel();
        lblMaSP9 = new javax.swing.JLabel();
        txtMaKHinTTHD = new javax.swing.JTextField();
        lblMaSP10 = new javax.swing.JLabel();
        txtMaNVinTTHD = new javax.swing.JTextField();
        lblMaSP11 = new javax.swing.JLabel();
        lblMaSP12 = new javax.swing.JLabel();
        txtTongTieninTTHD = new javax.swing.JTextField();
        txtNgayLapinTTHD = new com.toedter.calendar.JDateChooser();
        btnInHoaDoninTTHD = new javax.swing.JLabel();
        pnRoot = new javax.swing.JPanel();
        pnDSSP = new javax.swing.JPanel();
        lblDSSP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSSP = new javax.swing.JTable();
        txtIMG = new javax.swing.JLabel();
        lblMaSP = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        lblHo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        btnThemSP = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JSpinner();
        pnGioHang = new javax.swing.JPanel();
        lblGioHang = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JLabel();
        btnInHoaDon = new javax.swing.JLabel();
        lblMaSP1 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        lblMaSP2 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        lblMaSP3 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtNgayLap = new com.toedter.calendar.JDateChooser();
        lblMaSP4 = new javax.swing.JLabel();
        lblMaSP5 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        lblMaSP6 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        lblMaSP7 = new javax.swing.JLabel();
        txtThanhToan = new javax.swing.JTextField();
        chooseMaKH = new javax.swing.JButton();
        chooseMaNV = new javax.swing.JButton();
        chooseMaKM = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(250, 247, 240));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        tblTTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã KH", "Mã NV", "Ngày lập", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTTHD);

        pnHeader1.setBackground(new java.awt.Color(152, 168, 248));
        pnHeader1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 0, 0)));
        pnHeader1.setPreferredSize(new java.awt.Dimension(102, 40));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblLoai.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        jLabel9.setText("THÔNG TIN HÓA ĐƠN CHỜ IN");

        btnClose.setBackground(new java.awt.Color(152, 168, 248));
        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnHeader1Layout = new javax.swing.GroupLayout(pnHeader1);
        pnHeader1.setLayout(pnHeader1Layout);
        pnHeader1Layout.setHorizontalGroup(
            pnHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeader1Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnHeader1Layout.setVerticalGroup(
            pnHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeader1Layout.createSequentialGroup()
                .addGroup(pnHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(250, 247, 240));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KIỂM TRA THÔNG TIN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(txtMaHDinTTHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 143, 24));

        lblMaSP8.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP8.setText("Mã HD");
        jPanel6.add(lblMaSP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        lblMaSP9.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP9.setText("Mã KH");
        jPanel6.add(lblMaSP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));
        jPanel6.add(txtMaKHinTTHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 143, 24));

        lblMaSP10.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP10.setText("Mã NV");
        jPanel6.add(lblMaSP10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));
        jPanel6.add(txtMaNVinTTHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 143, 24));

        lblMaSP11.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP11.setText("Ngày lập");
        jPanel6.add(lblMaSP11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        lblMaSP12.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP12.setText("Tổng tiền");
        jPanel6.add(lblMaSP12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));
        jPanel6.add(txtTongTieninTTHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 143, 24));

        txtNgayLapinTTHD.setDateFormatString("dd/MM/yyyy");
        jPanel6.add(txtNgayLapinTTHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 143, 24));

        btnInHoaDoninTTHD.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnInHoaDoninTTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblInHoaDon.png"))); // NOI18N
        btnInHoaDoninTTHD.setText("In hóa đơn");
        btnInHoaDoninTTHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInHoaDoninTTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInHoaDoninTTHDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(btnInHoaDoninTTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(pnHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInHoaDoninTTHD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout InHoaDonGUILayout = new javax.swing.GroupLayout(InHoaDonGUI.getContentPane());
        InHoaDonGUI.getContentPane().setLayout(InHoaDonGUILayout);
        InHoaDonGUILayout.setHorizontalGroup(
            InHoaDonGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        InHoaDonGUILayout.setVerticalGroup(
            InHoaDonGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnRoot.setBackground(new java.awt.Color(250, 247, 240));

        pnDSSP.setBackground(new java.awt.Color(250, 247, 240));
        pnDSSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 4, new java.awt.Color(0, 0, 0)));
        pnDSSP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDSSP.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblDSSP.setForeground(new java.awt.Color(255, 51, 51));
        lblDSSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDSSP.setText("Danh sách sản phẩm");
        pnDSSP.add(lblDSSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, -1));

        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Còn lại", "Đơn Giá", "IMG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            tblDSSP.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblDSSP.getColumnModel().getColumn(1).setResizable(false);
            tblDSSP.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblDSSP.getColumnModel().getColumn(2).setResizable(false);
            tblDSSP.getColumnModel().getColumn(2).setPreferredWidth(25);
            tblDSSP.getColumnModel().getColumn(3).setResizable(false);
            tblDSSP.getColumnModel().getColumn(3).setPreferredWidth(25);
            tblDSSP.getColumnModel().getColumn(4).setResizable(false);
            tblDSSP.getColumnModel().getColumn(4).setPreferredWidth(7);
        }

        pnDSSP.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 490, 430));

        txtIMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIMG.setText("IMAGE");
        txtIMG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnDSSP.add(txtIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 160, 190));

        lblMaSP.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP.setText("Mã SP");
        pnDSSP.add(lblMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, -1));
        pnDSSP.add(txtMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 230, 24));
        pnDSSP.add(txtTenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 230, 24));

        lblHo.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblHo.setText("Tên SP");
        pnDSSP.add(lblHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, -1, -1));

        jLabel3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel3.setText("Số Lượng");
        pnDSSP.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, -1, -1));

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Đơn giá");
        pnDSSP.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, -1, -1));
        pnDSSP.add(txtDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 600, 230, 24));

        btnThemSP.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnThemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnAdd.png"))); // NOI18N
        btnThemSP.setText("Thêm sản phẩm");
        btnThemSP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemSPMouseClicked(evt);
            }
        });
        pnDSSP.add(btnThemSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 640, 190, -1));
        pnDSSP.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 230, 24));

        pnGioHang.setBackground(new java.awt.Color(250, 247, 240));

        lblGioHang.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblGioHang.setForeground(new java.awt.Color(255, 51, 51));
        lblGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioHang.setText("Giỏ hàng");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(0).setResizable(false);
            tblGioHang.getColumnModel().getColumn(0).setPreferredWidth(45);
            tblGioHang.getColumnModel().getColumn(1).setResizable(false);
            tblGioHang.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblGioHang.getColumnModel().getColumn(2).setResizable(false);
            tblGioHang.getColumnModel().getColumn(2).setPreferredWidth(45);
            tblGioHang.getColumnModel().getColumn(3).setResizable(false);
            tblGioHang.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblGioHang.getColumnModel().getColumn(4).setResizable(false);
            tblGioHang.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        btnTaoHoaDon.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnAdd.png"))); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHoaDonMouseClicked(evt);
            }
        });

        btnInHoaDon.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblInHoaDon.png"))); // NOI18N
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInHoaDonMouseClicked(evt);
            }
        });

        lblMaSP1.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP1.setText("Mã HD");

        lblMaSP2.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP2.setText("Mã KH");

        lblMaSP3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP3.setText("Mã NV");

        txtNgayLap.setDateFormatString("dd/MM/yyyy");

        lblMaSP4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP4.setText("Ngày tạo");

        lblMaSP5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP5.setText("Tổng tiền");

        lblMaSP6.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP6.setText("Khuyến mãi");

        lblMaSP7.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP7.setText("Thanh toán");

        chooseMaKH.setText("...");
        chooseMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseMaKHActionPerformed(evt);
            }
        });

        chooseMaNV.setText("...");
        chooseMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseMaNVActionPerformed(evt);
            }
        });

        chooseMaKM.setText("...");
        chooseMaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseMaKMActionPerformed(evt);
            }
        });

        btnXoaSP.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnXoaSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnDelete.png"))); // NOI18N
        btnXoaSP.setText("Xóa sản phẩm");
        btnXoaSP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaSPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnGioHangLayout = new javax.swing.GroupLayout(pnGioHang);
        pnGioHang.setLayout(pnGioHangLayout);
        pnGioHangLayout.setHorizontalGroup(
            pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGioHangLayout.createSequentialGroup()
                        .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaSP3)
                                    .addComponent(lblMaSP4))
                                .addGap(14, 14, 14)
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(txtNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaSP1)
                                    .addComponent(lblMaSP2))
                                .addGap(32, 32, 32)
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(13, 13, 13)
                        .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaSP5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGioHangLayout.createSequentialGroup()
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(chooseMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(chooseMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaSP6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMaSP7, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44))
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooseMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(4, 4, 4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGioHangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGioHangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        pnGioHangLayout.setVerticalGroup(
            pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addComponent(lblGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGioHangLayout.createSequentialGroup()
                        .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaSP1))
                        .addGap(18, 18, 18)
                        .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaSP2)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaSP3)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaSP4)
                                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaSP6)
                                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chooseMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chooseMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaSP7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chooseMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaSP5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInHoaDon)
                    .addComponent(btnTaoHoaDon))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSPMouseClicked
        int k = tblDSSP.getSelectedRow();
        //đầu tiên set rỗng cho các textfield
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtDonGia.setText("");
        txtSoLuong.setEnabled(true);
        //set hết hàng cho SP có số lượng < 1
        int SoLuongConLai = Integer.parseInt(tblDSSP.getModel().getValueAt(k, 2).toString());
        if (SoLuongConLai < 1) {
            JOptionPane.showMessageDialog(pnRoot, "Sản phẩm đã hết hàng", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //--
        txtMaSP.setText(tblDSSP.getModel().getValueAt(k, 0).toString());
        txtTenSP.setText(tblDSSP.getModel().getValueAt(k, 1).toString());
        txtDonGia.setText(tblDSSP.getModel().getValueAt(k, 3).toString());

        //set txtSoLuong sao cho chỉ có thể chọn tối đa số lượng sản phẩm hiện có trong table
        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, 0, SoLuongConLai, 1);
        txtSoLuong.setModel(modeSpinner);
        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) txtSoLuong.getEditor()).getTextField();
        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        txtSpinner.setEditable(false);
        txtSpinner.setHorizontalAlignment(JTextField.LEFT);
        //--

        imgName = tblDSSP.getModel().getValueAt(k, 4).toString();
        Image newImage;
        newImage = new ImageIcon("./src/image/SanPham/" + imgName).getImage().getScaledInstance(155, 185, Image.SCALE_DEFAULT);
        txtIMG.setIcon(new ImageIcon(newImage));

        txtMaSP.setEnabled(false);
        txtTenSP.setEnabled(false);
        txtDonGia.setEnabled(false);
    }//GEN-LAST:event_tblDSSPMouseClicked

    private void btnThemSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemSPMouseClicked

        if (txtMaSP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng lựa chọn sản phầm", "LỖI", JOptionPane.ERROR_MESSAGE);

        } else {
            String MaHD = txtMaHD.getText();
            String MaSP = txtMaSP.getText();
            String TenSP = txtTenSP.getText();
            int SoLuong = Integer.parseInt(txtSoLuong.getValue().toString());
            int DonGia = Integer.parseInt(txtDonGia.getText());
            int ThanhTien = SoLuong * DonGia;

            int k = tblDSSP.getSelectedRow();
            int SoLuongConLai = Integer.parseInt(tblDSSP.getModel().getValueAt(k, 2).toString());

            spBUS.capNhatSoLuongHD(MaSP, -SoLuong, SoLuongConLai);
            spBUS.docDanhSach();
            boolean flag = true;
            for (CTHoaDonDTO cthd : dscthd) {
                if (cthd.getMaSP().equals(MaSP)) {
                    int old = cthd.getSoLuong();
                    cthd.setSoLuong(old + SoLuong);
                    int new1 = cthd.getSoLuong();
                    cthd.setThanhTien(new1 * DonGia);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                dscthd.add(new CTHoaDonDTO(MaHD, MaSP, TenSP, SoLuong, DonGia, ThanhTien));

            }

            outModelGioHang(dtmGioHang, dscthd);
            txtTongTien.setText(String.valueOf(sumHD()));
            loadDataDSSP();
            txtMaSP.setText("");
            txtTenSP.setText("");
            txtSoLuong.setValue(0);
            txtDonGia.setText("");
            txtIMG.setIcon(null);
            txtIMG.setText("IMAGE");
            imgName = null;
        }
//
//        dtmGioHang.addRow(new String[]{
//            MaSP,
//            TenSP,
//            String.valueOf(SoLuong),
//            String.valueOf(DonGia),
//            String.valueOf(ThanhTien)
//        });
    }//GEN-LAST:event_btnThemSPMouseClicked

    private void btnInHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHoaDonMouseClicked
        System.out.println(dscthd.size());

        InHoaDonGUI.setUndecorated(true);
        InHoaDonGUI.pack();
        InHoaDonGUI.setVisible(true);
        InHoaDonGUI.setLocationRelativeTo(null);
        loadDataTTHD(); //load thông tin hóa đơn
        cthdBUS.docListCTHoaDon();
        ArrayList<HoaDonDTO> dscthd = hdBUS.getListHoaDon();
    }//GEN-LAST:event_btnInHoaDonMouseClicked

    private void btnTaoHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHoaDonMouseClicked
        System.out.println(dscthd.size());
        String MaHD = txtMaHD.getText();
        String MaKH = txtMaKH.getText();
        String MaNV = txtMaNV.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String NgayLap = dateFormat.format(txtNgayLap.getDate());
        String ThanhToan = txtThanhToan.getText();
        if (MaKH.trim().equals("") || MaNV.trim().equals("")) {
            JOptionPane.showConfirmDialog(this, "Vui lòng nhập đầy đủ thông tin hóa đơn");
            return;
        } else {
            HoaDonDTO hd = new HoaDonDTO(MaHD, MaKH, MaNV, NgayLap, ThanhToan);
            hdBUS.add(hd);
            loadDataTTHD();
        }
        //load thông tin hóa đơn

        txtMaHD.setText("");
        txtMaKH.setText("");
        txtMaNV.setText("");
        txtTongTien.setText("");
        txtMaKM.setText("");
        txtThanhToan.setText("");
        txtNgayLap.setCalendar(null);
        dtmGioHang.setRowCount(0);
//        dscthd.clear();

        int result = JOptionPane.showConfirmDialog(pnRoot, "Tạo hóa đơn thành công. Nhấn OK để In hóa đơn");
        if (result == JOptionPane.YES_OPTION) {
            InHoaDonGUI.setUndecorated(true);
            InHoaDonGUI.pack();
            InHoaDonGUI.setVisible(true);
            InHoaDonGUI.setLocationRelativeTo(null);
            loadDataTTHD(); //load thông tin hóa đơn
            cthdBUS.docListCTHoaDon();
            ArrayList<HoaDonDTO> dscthd = hdBUS.getListHoaDon();
        } else {
            JOptionPane.showMessageDialog(pnRoot, "Nếu có nhu cầu, bạn hãy nhấn vào In hóa đơn");
        }

    }//GEN-LAST:event_btnTaoHoaDonMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int k = tblGioHang.getSelectedRow();
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnXoaSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaSPMouseClicked
        int k = tblGioHang.getSelectedRow();
        String MaSP = tblGioHang.getModel().getValueAt(k, 0).toString();
        int SoLuong = Integer.parseInt(tblGioHang.getModel().getValueAt(k, 2).toString());

        //lấy số lượng sản phẩm hiện có trong cửa hàng
        spBUS.docDanhSach();
        ArrayList<SanPhamDTO> dssp = spBUS.getListSanPham();
        for (SanPhamDTO sp : dssp) {
            if (MaSP.equals(sp.getMaSP())) {
                SoLuongSPTrongCuaHang = sp.getSoLuong();
            }
        }
        //--
        spBUS.capNhatSoLuongHD(MaSP, SoLuong, SoLuongSPTrongCuaHang);
        spBUS.docDanhSach();
        dscthd.remove(k);
        dtmGioHang.removeRow(k);
        txtTongTien.setText(String.valueOf(sumHD()));
        loadDataDSSP();
    }//GEN-LAST:event_btnXoaSPMouseClicked

    private void tblTTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTTHDMouseClicked
        int k = tblTTHD.getSelectedRow();
        txtMaHDinTTHD.setText(tblTTHD.getValueAt(k, 0).toString());
        txtMaKHinTTHD.setText(tblTTHD.getValueAt(k, 1).toString());
        txtMaNVinTTHD.setText(tblTTHD.getValueAt(k, 2).toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date NgayLap = new Date();
        try {
            NgayLap = sdf.parse(tblTTHD.getModel().getValueAt(k, 3).toString());
        } catch (ParseException ex) {
            Logger.getLogger(HoaDonGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNgayLapinTTHD.setDate(NgayLap);
        txtTongTieninTTHD.setText(tblTTHD.getValueAt(k, 4).toString());

        txtMaHDinTTHD.setEnabled(false);
        txtMaKHinTTHD.setEnabled(false);
        txtMaNVinTTHD.setEnabled(false);
        txtNgayLapinTTHD.setEnabled(false);
        txtTongTieninTTHD.setEnabled(false);
    }//GEN-LAST:event_tblTTHDMouseClicked

    private void btnInHoaDoninTTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHoaDoninTTHDMouseClicked
        String MaHD = txtMaHDinTTHD.getText();
        String MaKH = txtMaKHinTTHD.getText();
        String MaNV = txtMaNVinTTHD.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // định dạng ngày
        String NgayLap = sdf.format(txtNgayLapinTTHD.getDate());
        System.out.println(NgayLap);
        int TongTien = Integer.parseInt(txtTongTieninTTHD.getText());
        HoaDonDTO hd = new HoaDonDTO(MaHD, MaKH, MaNV, NgayLap, String.valueOf(TongTien));
        XuatHoaDonBUS xuathd = new XuatHoaDonBUS(hd, dscthd);
        xuathd.print();
        for (CTHoaDonDTO cthd : dscthd) {
            cthdBUS.add(cthd);
        }
        txtMaHDinTTHD.setText("");
        txtMaKHinTTHD.setText("");
        txtMaNVinTTHD.setText("");
        txtNgayLapinTTHD.setCalendar(null);
        txtTongTieninTTHD.setText("");
        dscthd.clear();
        loadDataMaHD();
        JOptionPane.showMessageDialog(pnRoot, "In hóa đơn thành công");
    }//GEN-LAST:event_btnInHoaDoninTTHDMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        InHoaDonGUI.dispose();

    }//GEN-LAST:event_btnCloseMouseClicked

    private void chooseMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseMaKHActionPerformed
        RCKhachHangGUI rkh = new RCKhachHangGUI();
        rkh.setVisible(true);
        String MaKH = rkh.getMaKH();
        txtMaKH.setText(MaKH);
    }//GEN-LAST:event_chooseMaKHActionPerformed

    private void chooseMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseMaNVActionPerformed
        RCNhanVienGUI rnv = new RCNhanVienGUI("CV02");
        rnv.setVisible(true);
        String MaNV = rnv.getMaNV();
        txtMaNV.setText(MaNV);
    }//GEN-LAST:event_chooseMaNVActionPerformed

    private void chooseMaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseMaKMActionPerformed
        double TongTien = Double.parseDouble(txtTongTien.getText());

        RCKhuyenMaiGUI rkm = new RCKhuyenMaiGUI(TongTien); //hàm tạo truyền vào tham số TongTien
        rkm.setVisible(true);
        String MaKM = rkm.getMaKM();
        txtMaKM.setText(MaKM);
        if (txtMaKM.getText().equals("")) {
            double TongTienSauKM = TongTien;
            txtThanhToan.setText(String.valueOf(TongTienSauKM));
        } else {
            double KM = Double.parseDouble(rkm.getPhanTramKM());
            double TongTienSauKM = TongTien - TongTien * (KM / 100);
            txtThanhToan.setText(String.valueOf(TongTienSauKM));
        }

    }//GEN-LAST:event_chooseMaKMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog InHoaDonGUI;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnInHoaDon;
    private javax.swing.JLabel btnInHoaDoninTTHD;
    private javax.swing.JLabel btnTaoHoaDon;
    private javax.swing.JLabel btnThemSP;
    private javax.swing.JLabel btnXoaSP;
    private javax.swing.JButton chooseMaKH;
    private javax.swing.JButton chooseMaKM;
    private javax.swing.JButton chooseMaNV;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblDSSP;
    private javax.swing.JLabel lblGioHang;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblMaSP1;
    private javax.swing.JLabel lblMaSP10;
    private javax.swing.JLabel lblMaSP11;
    private javax.swing.JLabel lblMaSP12;
    private javax.swing.JLabel lblMaSP2;
    private javax.swing.JLabel lblMaSP3;
    private javax.swing.JLabel lblMaSP4;
    private javax.swing.JLabel lblMaSP5;
    private javax.swing.JLabel lblMaSP6;
    private javax.swing.JLabel lblMaSP7;
    private javax.swing.JLabel lblMaSP8;
    private javax.swing.JLabel lblMaSP9;
    private javax.swing.JPanel pnDSSP;
    private javax.swing.JPanel pnGioHang;
    private javax.swing.JPanel pnHeader1;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JTable tblDSSP;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblTTHD;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JLabel txtIMG;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHDinTTHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaKHinTTHD;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaNVinTTHD;
    private javax.swing.JTextField txtMaSP;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private com.toedter.calendar.JDateChooser txtNgayLapinTTHD;
    private javax.swing.JSpinner txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtThanhToan;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTongTieninTTHD;
    // End of variables declaration//GEN-END:variables
}
