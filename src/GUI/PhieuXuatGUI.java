/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.CTPhieuXuatBUS;
import BUS.KhoBUS;
import BUS.PhieuXuatBUS;
import BUS.SanPhamBUS;
import BUS.XuatPhieuXuatBUS;
import DTO.CTPhieuXuatDTO;
import DTO.KhoDTO;
import DTO.PhieuXuatDTO;
import DTO.SanPhamDTO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
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
public class PhieuXuatGUI extends javax.swing.JPanel {

    private PhieuXuatBUS pxBUS = new PhieuXuatBUS();
    private KhoBUS khoBUS = new KhoBUS();
    private SanPhamBUS spBUS = new SanPhamBUS();
    private CTPhieuXuatBUS ctpxBUS = new CTPhieuXuatBUS();
    DefaultTableModel dtmSanPham;
    DefaultTableModel dtmHangChoXuat;
    DefaultTableModel dtmInPhieuXuat;
    ArrayList<CTPhieuXuatDTO> dsctpx = new ArrayList<>();
    String imgName = "null";
    private BufferedImage i = null;
    int SoLuongTrongKho;
    int SoLuongTrongCH;
    public PhieuXuatGUI() {
        initComponents();
        init();
        dtmSanPham = (DefaultTableModel) tblDSSP.getModel();
        dtmHangChoXuat = (DefaultTableModel) tblHangChoXuat.getModel();
        dtmInPhieuXuat = (DefaultTableModel) tblTTPX.getModel();
        loadDataDSSP();
        loadDataMaPX();
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

        //set giao diện cho Table
        //HangChoXuat
        tblHangChoXuat.setFocusable(false);
        tblHangChoXuat.setIntercellSpacing(new Dimension(0, 0));
        tblHangChoXuat.setRowHeight(25);
        tblHangChoXuat.setFillsViewportHeight(true);
        tblHangChoXuat.getTableHeader().setOpaque(false);
        tblHangChoXuat.getTableHeader().setBackground(new Color(152, 168, 248));
        tblHangChoXuat.getTableHeader().setForeground(Color.WHITE);
        tblHangChoXuat.setSelectionBackground(new Color(188, 206, 248));
        tblHangChoXuat.setSelectionForeground(Color.BLACK);
        tblHangChoXuat.setFont(new Font("Arial", Font.PLAIN, 13));
        tblHangChoXuat.getTableHeader().setReorderingAllowed(false);
        tblHangChoXuat.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
        //set giao diện cho Table
        //ThongTinhPhieuXuat
        tblTTPX.setFocusable(false);
        tblTTPX.setIntercellSpacing(new Dimension(0, 0));
        tblTTPX.setRowHeight(25);
        tblTTPX.setFillsViewportHeight(true);
        tblTTPX.getTableHeader().setOpaque(false);
        tblTTPX.getTableHeader().setBackground(new Color(152, 168, 248));
        tblTTPX.getTableHeader().setForeground(Color.WHITE);
        tblTTPX.setSelectionBackground(new Color(188, 206, 248));
        tblTTPX.setSelectionForeground(Color.BLACK);
        tblTTPX.setFont(new Font("Arial", Font.PLAIN, 13));
        tblTTPX.getTableHeader().setReorderingAllowed(false);
        tblTTPX.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
        //set SoLuong Spinner
        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, 0, 100, 1);
        txtSoLuong.setModel(modeSpinner);
        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) txtSoLuong.getEditor()).getTextField();
        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        txtSpinner.setEditable(true);
        txtSpinner.setHorizontalAlignment(JTextField.LEFT);
        txtSpinner.setBackground(Color.white);

        //setEnabled
        txtMaNV.setEnabled(false);
        txtMaPX.setEnabled(false);
        txtTongTien.setEnabled(false);
        JDateChooser chooser = new JDateChooser();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) this.txtNgayLap.getDateEditor();
        editor.setEnabled(false);

    }

    public void showAllDSSP(ArrayList<KhoDTO> dskho) {
        dtmSanPham.setRowCount(0);
        for (int i = 0; i < dskho.size(); i++) {
            dtmSanPham.addRow(new String[]{
                dskho.get(i).getMaSP(),
                dskho.get(i).getTenSP(),
                String.valueOf(dskho.get(i).getSoLuong()),
                dskho.get(i).getIMG()
            });
        }

    }

    public void loadDataDSSP() {
        khoBUS.docDanhSach();
        ArrayList<KhoDTO> dskho = khoBUS.getListKho();
        showAllDSSP(dskho);
    }
//-- Xuất sản phẩm vừa thêm vào giỏ hàng ra table

    public void outModelHangChoXuat(DefaultTableModel dtmHangChoXuat, ArrayList<CTPhieuXuatDTO> dsctpx) {
        Vector data;
        dtmHangChoXuat.setRowCount(0);
        for (int i = 0; i < dsctpx.size(); i++) {
            dtmHangChoXuat.addRow(new String[]{
                dsctpx.get(i).getMaSP(),
                dsctpx.get(i).getTenSP(),
                String.valueOf(dsctpx.get(i).getSoLuong()),
                String.valueOf(dsctpx.get(i).getDonGia()),
                String.valueOf(dsctpx.get(i).getThanhTien())
            });
        }
    }
//--

//-- Tính tổng tiền hóa đơn
    public int sumPX() {
        int sum = 0;
        for (CTPhieuXuatDTO ctpx : dsctpx) {
            int SoLuong = ctpx.getSoLuong();
            int DonGia = ctpx.getDonGia();
            sum += SoLuong * DonGia;
        }
        return sum;
    }
//--
//--    Hiển thị mã PX tiếp theo
//--    Lấy mã PX mới nhất + 1 để ra mã PX cần được tạo

    public void showMaHD(ArrayList<PhieuXuatDTO> dspx) {
        if (dspx.isEmpty()) {
            txtMaPX.setText(String.valueOf("PX01"));
        }
        for (int i = 0; i < dspx.size(); i++) {

            int sum = Integer.parseInt(dspx.get(i).getMaPX().substring(2)) + 1;
            if (sum < 10) {
                txtMaPX.setText(String.valueOf("PX0" + sum));
            } else {
                txtMaPX.setText(String.valueOf("PX" + sum));
            }
            sum = 0;

        }
    }
//--    
//--    Load mã hóa đơn mới nhất lên form

    private void loadDataMaPX() {
        pxBUS.docDanhSach();
        ArrayList<PhieuXuatDTO> dspx = pxBUS.getListPhieuXuat();
        showMaHD(dspx);
    }
//--
//--    Load thông tin phiếu nhập lên XuatHoaDonGUI

    public void showAllDSPX(ArrayList<PhieuXuatDTO> dspx) {
        dtmInPhieuXuat.setRowCount(0);
        int i = dspx.size() - 1;
        dtmInPhieuXuat.addRow(new String[]{
            dspx.get(i).getMaPX(),
            dspx.get(i).getMaNV(),
            dspx.get(i).getNgayLap(),
            String.valueOf(dspx.get(i).getTongTien())
        });
    }

    public void loadDataDSPX() {
        pxBUS.docDanhSach();
        ArrayList<PhieuXuatDTO> dspx = pxBUS.getListPhieuXuat();
        showAllDSPX(dspx);
    }
//--

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        XuatHoaDonGUI = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTTPX = new javax.swing.JTable();
        pnHeader1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtMaPXinTTPX = new javax.swing.JTextField();
        lblMaSP8 = new javax.swing.JLabel();
        lblMaSP9 = new javax.swing.JLabel();
        txtMaNVinTTPX = new javax.swing.JTextField();
        lblMaSP11 = new javax.swing.JLabel();
        lblMaSP12 = new javax.swing.JLabel();
        txtTongTieninTTPX = new javax.swing.JTextField();
        txtNgayLapinTTPX = new com.toedter.calendar.JDateChooser();
        btnInHoaDoninTTHD = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
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
        jLabel1 = new javax.swing.JLabel();
        lblGiaNhap = new javax.swing.JLabel();
        pnHangChoXuat = new javax.swing.JPanel();
        lblGioHang = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblHangChoXuat = new javax.swing.JTable();
        btnTaoPhieuXuat = new javax.swing.JLabel();
        btnInHoaDon = new javax.swing.JLabel();
        lblMaSP1 = new javax.swing.JLabel();
        txtMaPX = new javax.swing.JTextField();
        lblMaSP3 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtNgayLap = new com.toedter.calendar.JDateChooser();
        lblMaSP4 = new javax.swing.JLabel();
        lblMaSP5 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        chooseMaNV = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(250, 247, 240));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        tblTTPX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", null, null, null}
            },
            new String [] {
                "Mã PX", "Mã NV", "Ngày lập", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTTPX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTPXMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTTPX);

        pnHeader1.setBackground(new java.awt.Color(152, 168, 248));
        pnHeader1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 0, 0)));
        pnHeader1.setPreferredSize(new java.awt.Dimension(102, 40));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblLoai.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        jLabel9.setText("THÔNG TIN PHIẾU XUẤT CHỜ IN");

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
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jPanel6.add(txtMaPXinTTPX, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 143, 24));

        lblMaSP8.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP8.setText("Mã PX");
        jPanel6.add(lblMaSP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        lblMaSP9.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP9.setText("Mã NV");
        jPanel6.add(lblMaSP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));
        jPanel6.add(txtMaNVinTTPX, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 143, 24));

        lblMaSP11.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP11.setText("Ngày lập");
        jPanel6.add(lblMaSP11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        lblMaSP12.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP12.setText("Tổng tiền");
        jPanel6.add(lblMaSP12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));
        jPanel6.add(txtTongTieninTTPX, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 143, 24));

        txtNgayLapinTTPX.setDateFormatString("dd/MM/yyyy");
        jPanel6.add(txtNgayLapinTTPX, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 143, 24));

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
            .addComponent(pnHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(btnInHoaDoninTTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout XuatHoaDonGUILayout = new javax.swing.GroupLayout(XuatHoaDonGUI.getContentPane());
        XuatHoaDonGUI.getContentPane().setLayout(XuatHoaDonGUILayout);
        XuatHoaDonGUILayout.setHorizontalGroup(
            XuatHoaDonGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        XuatHoaDonGUILayout.setVerticalGroup(
            XuatHoaDonGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnRoot.setBackground(new java.awt.Color(250, 247, 240));

        pnDSSP.setBackground(new java.awt.Color(250, 247, 240));
        pnDSSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 4, new java.awt.Color(0, 0, 0)));
        pnDSSP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDSSP.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblDSSP.setForeground(new java.awt.Color(255, 51, 51));
        lblDSSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDSSP.setText("Sản phẩm muốn xuất kho");
        pnDSSP.add(lblDSSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Trong kho", "IMG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            tblDSSP.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblDSSP.getColumnModel().getColumn(1).setResizable(false);
            tblDSSP.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblDSSP.getColumnModel().getColumn(2).setResizable(false);
            tblDSSP.getColumnModel().getColumn(2).setPreferredWidth(25);
            tblDSSP.getColumnModel().getColumn(3).setResizable(false);
            tblDSSP.getColumnModel().getColumn(3).setPreferredWidth(2);
        }

        pnDSSP.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 490, 380));

        txtIMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIMG.setText("IMAGE");
        txtIMG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnDSSP.add(txtIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 160, 190));

        lblMaSP.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP.setText("Mã SP");
        pnDSSP.add(lblMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, -1, -1));
        pnDSSP.add(txtMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 230, 24));
        pnDSSP.add(txtTenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 230, 24));

        lblHo.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblHo.setText("Tên SP");
        pnDSSP.add(lblHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, -1));

        jLabel3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel3.setText("Số Lượng");
        pnDSSP.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, -1, -1));

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Đơn giá");
        pnDSSP.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, -1, -1));
        pnDSSP.add(txtDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 230, 24));

        btnThemSP.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnThemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnAdd.png"))); // NOI18N
        btnThemSP.setText("Xuất sản phẩm");
        btnThemSP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemSPMouseClicked(evt);
            }
        });
        pnDSSP.add(btnThemSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 640, 170, -1));
        pnDSSP.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 230, 24));

        jLabel1.setFont(new java.awt.Font("Baloo 2 SemiBold", 2, 13)); // NOI18N
        jLabel1.setText("Giá bán đề xuất");
        pnDSSP.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, -1, 20));

        lblGiaNhap.setText(" ");
        pnDSSP.add(lblGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 600, 100, 20));

        pnHangChoXuat.setBackground(new java.awt.Color(250, 247, 240));

        lblGioHang.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblGioHang.setForeground(new java.awt.Color(255, 51, 51));
        lblGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioHang.setText("Hàng chờ xuất");

        tblHangChoXuat.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHangChoXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangChoXuatMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblHangChoXuat);
        if (tblHangChoXuat.getColumnModel().getColumnCount() > 0) {
            tblHangChoXuat.getColumnModel().getColumn(0).setResizable(false);
            tblHangChoXuat.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblHangChoXuat.getColumnModel().getColumn(1).setResizable(false);
            tblHangChoXuat.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblHangChoXuat.getColumnModel().getColumn(2).setResizable(false);
            tblHangChoXuat.getColumnModel().getColumn(2).setPreferredWidth(25);
            tblHangChoXuat.getColumnModel().getColumn(3).setResizable(false);
            tblHangChoXuat.getColumnModel().getColumn(3).setPreferredWidth(25);
            tblHangChoXuat.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        btnTaoPhieuXuat.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnTaoPhieuXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnAdd.png"))); // NOI18N
        btnTaoPhieuXuat.setText("Tạo phiếu xuất");
        btnTaoPhieuXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoPhieuXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoPhieuXuatMouseClicked(evt);
            }
        });

        btnInHoaDon.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblInHoaDon.png"))); // NOI18N
        btnInHoaDon.setText("In phiếu xuất");
        btnInHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInHoaDonMouseClicked(evt);
            }
        });

        lblMaSP1.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP1.setText("Mã PX");

        lblMaSP3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP3.setText("Mã NV");

        txtNgayLap.setDateFormatString("dd/MM/yyyy");

        lblMaSP4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP4.setText("Ngày tạo");

        lblMaSP5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP5.setText("Tổng tiền");

        chooseMaNV.setText("...");
        chooseMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseMaNVActionPerformed(evt);
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

        javax.swing.GroupLayout pnHangChoXuatLayout = new javax.swing.GroupLayout(pnHangChoXuat);
        pnHangChoXuat.setLayout(pnHangChoXuatLayout);
        pnHangChoXuatLayout.setHorizontalGroup(
            pnHangChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHangChoXuatLayout.createSequentialGroup()
                .addGroup(pnHangChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(pnHangChoXuatLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnTaoPhieuXuat)
                        .addGap(79, 79, 79)
                        .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(pnHangChoXuatLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnHangChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnHangChoXuatLayout.createSequentialGroup()
                        .addComponent(lblMaSP3)
                        .addGap(29, 29, 29)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnHangChoXuatLayout.createSequentialGroup()
                        .addComponent(lblMaSP1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaPX, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(chooseMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(pnHangChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaSP4)
                    .addComponent(lblMaSP5))
                .addGap(18, 18, 18)
                .addGroup(pnHangChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHangChoXuatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
            .addGroup(pnHangChoXuatLayout.createSequentialGroup()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        pnHangChoXuatLayout.setVerticalGroup(
            pnHangChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHangChoXuatLayout.createSequentialGroup()
                .addComponent(lblGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaSP)
                .addGap(27, 27, 27)
                .addGroup(pnHangChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnHangChoXuatLayout.createSequentialGroup()
                        .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addGroup(pnHangChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaoPhieuXuat)
                            .addComponent(btnInHoaDon)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnHangChoXuatLayout.createSequentialGroup()
                        .addGroup(pnHangChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnHangChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMaSP1)
                                .addComponent(txtMaPX, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblMaSP4))
                        .addGap(30, 30, 30)
                        .addGroup(pnHangChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaSP3)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooseMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaSP5)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnHangChoXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRootLayout.createSequentialGroup()
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnHangChoXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1096, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 4, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 5, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 5, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSPMouseClicked
        int k = tblDSSP.getSelectedRow();
        //đầu tiên set rỗng cho các textfield
        txtMaSP.setText("");
        txtTenSP.setText("");

        //set hết hàng cho SP có số lượng < 1
        int SoLuongConLai = Integer.parseInt(tblDSSP.getModel().getValueAt(k, 2).toString());
        if (SoLuongConLai < 1) {
            JOptionPane.showMessageDialog(pnRoot, "Sản phẩm đã hết hàng", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            txtIMG.setIcon(null);
            return;
        }
        //--
        txtMaSP.setText(tblDSSP.getModel().getValueAt(k, 0).toString());
        txtTenSP.setText(tblDSSP.getModel().getValueAt(k, 1).toString());
        imgName = tblDSSP.getModel().getValueAt(k, 3).toString();
        //--Lấy giá bán đề xuất
        spBUS.docDanhSach();
        ArrayList<SanPhamDTO> dssp = spBUS.getListSanPham();
        for (SanPhamDTO sp : dssp) {
            if (txtMaSP.getText().equals(sp.getMaSP())) {
                lblGiaNhap.setText(String.valueOf(sp.getDonGia()));
                txtDonGia.setText(String.valueOf(sp.getDonGia()));
            }
        }
        //set txtSoLuong sao cho chỉ có thể chọn tối đa số lượng sản phẩm hiện có trong table
        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, 0, SoLuongConLai, 1);
        txtSoLuong.setModel(modeSpinner);
        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) txtSoLuong.getEditor()).getTextField();
        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        txtSpinner.setEditable(false);
        txtSpinner.setHorizontalAlignment(JTextField.LEFT);
        //--
        Image newImage;
        newImage = new ImageIcon("./src/image/SanPham/" + imgName).getImage().getScaledInstance(155, 185, Image.SCALE_DEFAULT);
        txtIMG.setIcon(new ImageIcon(newImage));

        txtMaSP.setEnabled(false);
        txtTenSP.setEnabled(false);
    }//GEN-LAST:event_tblDSSPMouseClicked

    private void btnThemSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemSPMouseClicked
        String MaPX = txtMaPX.getText();
        String MaSP = txtMaSP.getText();
        String TenSP = txtTenSP.getText();
        int SoLuong = Integer.parseInt(txtSoLuong.getValue().toString()); //số lượng muốn xuất kho
        int DonGia = Integer.parseInt(txtDonGia.getText());
        int ThanhTien = SoLuong * DonGia;

        int k = tblDSSP.getSelectedRow();
        spBUS.docDanhSach1(MaSP);
        ArrayList<SanPhamDTO> dssp = spBUS.getSLSanPhamCH();
        for (SanPhamDTO sp : dssp) {
            SoLuongTrongCH = sp.getSoLuong(); //số lượng hiện tại trong cửa hàng
        }
        
        int SoLuongConLai = Integer.parseInt(tblDSSP.getModel().getValueAt(k, 2).toString()); //số lượng trong kho
        System.out.println(SoLuongConLai);
        System.out.println(SoLuong);
        khoBUS.capNhatSoLuongSP(MaSP, -SoLuong, SoLuongConLai);
        khoBUS.docDanhSach();
        spBUS.capNhatSoLuongHD(MaSP, SoLuong, SoLuongTrongCH);
        spBUS.docDanhSach();
        boolean flag = true;
        for (CTPhieuXuatDTO ctpx : dsctpx) {
            if (ctpx.getMaSP().equals(MaSP)) {
                int old = ctpx.getSoLuong();
                ctpx.setSoLuong(old + SoLuong);
                int new1 = ctpx.getSoLuong();
                ctpx.setThanhTien(new1 * DonGia);
                flag = false;
                break;
            }
        }
        if (flag) {
            dsctpx.add(new CTPhieuXuatDTO(MaPX, MaSP, TenSP, SoLuong, DonGia, ThanhTien));

        }

        outModelHangChoXuat(dtmHangChoXuat, dsctpx);
        loadDataDSSP();
        txtTongTien.setText(String.valueOf(sumPX()));

        txtMaSP.setText("");
        txtTenSP.setText("");
        txtSoLuong.setValue(0);
        txtDonGia.setText("");
        txtIMG.setIcon(null);
        txtIMG.setText("IMAGE");
        imgName = null;
    }//GEN-LAST:event_btnThemSPMouseClicked

    private void tblHangChoXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangChoXuatMouseClicked

    }//GEN-LAST:event_tblHangChoXuatMouseClicked

    private void btnTaoPhieuXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoPhieuXuatMouseClicked
        String MaPX = txtMaPX.getText();
        String MaNV = txtMaNV.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String NgayLap = dateFormat.format(txtNgayLap.getDate());

        int TongTien = Integer.parseInt(txtTongTien.getText());
        if (MaPX.trim().equals("") || MaNV.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin phiếu xuất");
            return;
        } else {
            PhieuXuatDTO px = new PhieuXuatDTO(MaPX, MaNV, NgayLap, TongTien);
            pxBUS.add(px);
        }

        txtMaPX.setText("");
        txtMaNV.setText("");
        txtNgayLap.setCalendar(null);
        txtTongTien.setText("");
        dtmHangChoXuat.setRowCount(0);
        int result = JOptionPane.showConfirmDialog(pnRoot, "Tạo phiếu xuất thành công. Nhấn OK để In phiếu xuất");
        if (result == JOptionPane.YES_OPTION) {
            XuatHoaDonGUI.setUndecorated(true);
            XuatHoaDonGUI.pack();
            XuatHoaDonGUI.setVisible(true);
            XuatHoaDonGUI.setLocationRelativeTo(null);
            loadDataDSPX();
            ctpxBUS.docDanhSach();
            ArrayList<PhieuXuatDTO> dsctpx = pxBUS.getListPhieuXuat();
        } else {
            JOptionPane.showMessageDialog(pnRoot, "Nếu có nhu cầu, bạn hãy nhấn vào In phiếu xuất");

        }

    }//GEN-LAST:event_btnTaoPhieuXuatMouseClicked

    private void btnInHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHoaDonMouseClicked
        XuatHoaDonGUI.setUndecorated(true);
        XuatHoaDonGUI.pack();
        XuatHoaDonGUI.setVisible(true);
        XuatHoaDonGUI.setLocationRelativeTo(null);
        loadDataDSPX();
        ctpxBUS.docDanhSach();
        ArrayList<PhieuXuatDTO> dsctpx = pxBUS.getListPhieuXuat();
    }//GEN-LAST:event_btnInHoaDonMouseClicked

    private void chooseMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseMaNVActionPerformed
        RCNhanVienGUI rcnv = new RCNhanVienGUI("CV03");
        rcnv.setVisible(true);
        String MaNV = rcnv.getMaNV();
        txtMaNV.setText(MaNV);
    }//GEN-LAST:event_chooseMaNVActionPerformed

    private void btnXoaSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaSPMouseClicked
        int k = tblHangChoXuat.getSelectedRow();
        String MaSP = tblHangChoXuat.getModel().getValueAt(k, 0).toString();
        int SoLuong = Integer.parseInt(tblHangChoXuat.getModel().getValueAt(k, 2).toString());

        //lấy số lượng sản phẩm hiện có trong kho
        khoBUS.docDanhSach();
        ArrayList<KhoDTO> dskho = khoBUS.getListKho();
        for (KhoDTO kho : dskho) {
            if (MaSP.equals(kho.getMaSP())) {
                SoLuongTrongKho = kho.getSoLuong();
            }
        }
        //--
        khoBUS.capNhatSoLuongSP(MaSP, SoLuong, SoLuongTrongKho);
        khoBUS.docDanhSach();
        dsctpx.remove(k);
        dtmHangChoXuat.removeRow(k);
        txtTongTien.setText(String.valueOf(sumPX()));
        loadDataDSSP();
    }//GEN-LAST:event_btnXoaSPMouseClicked

    private void tblTTPXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTTPXMouseClicked
        int k = tblTTPX.getSelectedRow();
        txtMaPXinTTPX.setText(tblTTPX.getValueAt(k, 0).toString());
        txtMaNVinTTPX.setText(tblTTPX.getValueAt(k, 1).toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date NgayLap = new Date();
        try {
            NgayLap = sdf.parse(tblTTPX.getModel().getValueAt(k, 2).toString());
        } catch (ParseException ex) {
            Logger.getLogger(HoaDonGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNgayLapinTTPX.setDate(NgayLap);
        txtTongTieninTTPX.setText(tblTTPX.getValueAt(k, 3).toString());

        txtMaPXinTTPX.setEnabled(false);
        txtMaNVinTTPX.setEnabled(false);
        txtMaNVinTTPX.setEnabled(false);
        txtNgayLapinTTPX.setEnabled(false);
        txtTongTieninTTPX.setEnabled(false);
    }//GEN-LAST:event_tblTTPXMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        XuatHoaDonGUI.dispose();

    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnInHoaDoninTTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHoaDoninTTHDMouseClicked
        
        for (CTPhieuXuatDTO ctpx : dsctpx) {
            ctpxBUS.add(ctpx);
            System.out.println(ctpx.getSoLuong());
        }
        
        String MaPX = txtMaPXinTTPX.getText();

        String MaNV = txtMaNVinTTPX.getText();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // định dạng ngày
        String NgayLap = sdf.format(txtNgayLapinTTPX.getDate());
        System.out.println(NgayLap);
        int TongTien = Integer.parseInt(txtTongTieninTTPX.getText());
        PhieuXuatDTO px = new PhieuXuatDTO(MaPX, MaNV, NgayLap, TongTien);

        XuatPhieuXuatBUS xuatpx = new XuatPhieuXuatBUS(px, dsctpx);
        xuatpx.print();
        txtMaPXinTTPX.setText("");
        txtMaNVinTTPX.setText("");
        txtMaNVinTTPX.setText("");
        txtNgayLapinTTPX.setCalendar(null);
        txtTongTieninTTPX.setText("");
        dsctpx.clear();
        loadDataDSSP();
        loadDataMaPX();
        JOptionPane.showMessageDialog(jPanel5, "In phiếu xuất thành công");
    }//GEN-LAST:event_btnInHoaDoninTTHDMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog XuatHoaDonGUI;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnInHoaDon;
    private javax.swing.JLabel btnInHoaDoninTTHD;
    private javax.swing.JLabel btnTaoPhieuXuat;
    private javax.swing.JLabel btnThemSP;
    private javax.swing.JLabel btnXoaSP;
    private javax.swing.JButton chooseMaNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblDSSP;
    private javax.swing.JLabel lblGiaNhap;
    private javax.swing.JLabel lblGioHang;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblMaSP1;
    private javax.swing.JLabel lblMaSP11;
    private javax.swing.JLabel lblMaSP12;
    private javax.swing.JLabel lblMaSP3;
    private javax.swing.JLabel lblMaSP4;
    private javax.swing.JLabel lblMaSP5;
    private javax.swing.JLabel lblMaSP8;
    private javax.swing.JLabel lblMaSP9;
    private javax.swing.JPanel pnDSSP;
    private javax.swing.JPanel pnHangChoXuat;
    private javax.swing.JPanel pnHeader1;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JTable tblDSSP;
    private javax.swing.JTable tblHangChoXuat;
    private javax.swing.JTable tblTTPX;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JLabel txtIMG;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaNVinTTPX;
    private javax.swing.JTextField txtMaPX;
    private javax.swing.JTextField txtMaPXinTTPX;
    private javax.swing.JTextField txtMaSP;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private com.toedter.calendar.JDateChooser txtNgayLapinTTPX;
    private javax.swing.JSpinner txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTongTieninTTPX;
    // End of variables declaration//GEN-END:variables
}
