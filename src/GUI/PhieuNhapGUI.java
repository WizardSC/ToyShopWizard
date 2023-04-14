/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.CTPhieuNhapBUS;
import BUS.KhoBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamBUS;
import BUS.XuatPhieuNhapBUS;
import DTO.CTPhieuNhapDTO;
import DTO.HoaDonDTO;
import DTO.KhoDTO;
import DTO.PhieuNhapDTO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author wizardsc
 */
public class PhieuNhapGUI extends javax.swing.JPanel {

    DefaultTableModel dtmSanPham;
    DefaultTableModel dtmHangChoNhap;
    DefaultTableModel dtmThongTinPN;
    SanPhamBUS spBUS = new SanPhamBUS();
    PhieuNhapBUS pnBUS = new PhieuNhapBUS();
    CTPhieuNhapBUS ctpnBUS = new CTPhieuNhapBUS();
    KhoBUS khoBUS = new KhoBUS();
    ArrayList<PhieuNhapDTO> dspn = new ArrayList<>();
    static boolean chooseNCC = false;

    private ArrayList<CTPhieuNhapDTO> dsctpn = new ArrayList<>();
    String imgName = "null";
    private BufferedImage i = null;
    int SoLuongTrongKho;
    int selectedRow = -1;

    public PhieuNhapGUI() {
        initComponents();

        dtmSanPham = (DefaultTableModel) tblDSSP.getModel();
        dtmHangChoNhap = (DefaultTableModel) tblHangChoNhap.getModel();
        dtmThongTinPN = (DefaultTableModel) tblTTPN.getModel();
        init();
        loadDataDSSP();
        loadDataMaPN();

        txtMaNCC.setEnabled(false);
        txtMaNV.setEnabled(false);
        txtMaPN.setEnabled(false);
        txtTongTien.setEnabled(false);

        JTextFieldDateEditor editor = (JTextFieldDateEditor) this.txtNgayLap.getDateEditor();
        editor.setEnabled(false);

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
        //HangChoNhap
        tblHangChoNhap.setFocusable(false);
        tblHangChoNhap.setIntercellSpacing(new Dimension(0, 0));
        tblHangChoNhap.setRowHeight(25);
        tblHangChoNhap.setFillsViewportHeight(true);
        tblHangChoNhap.getTableHeader().setOpaque(false);
        tblHangChoNhap.getTableHeader().setBackground(new Color(152, 168, 248));
        tblHangChoNhap.getTableHeader().setForeground(Color.WHITE);
        tblHangChoNhap.setSelectionBackground(new Color(188, 206, 248));
        tblHangChoNhap.setSelectionForeground(Color.BLACK);
        tblHangChoNhap.setFont(new Font("Arial", Font.PLAIN, 13));
        tblHangChoNhap.getTableHeader().setReorderingAllowed(false);
        tblHangChoNhap.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));

        //ThongTinPN
        tblTTPN.setFocusable(false);
        tblTTPN.setIntercellSpacing(new Dimension(0, 0));
        tblTTPN.setRowHeight(25);
        tblTTPN.setFillsViewportHeight(true);
        tblTTPN.getTableHeader().setOpaque(false);
        tblTTPN.getTableHeader().setBackground(new Color(152, 168, 248));
        tblTTPN.getTableHeader().setForeground(Color.WHITE);
        tblTTPN.setSelectionBackground(new Color(188, 206, 248));
        tblTTPN.setSelectionForeground(Color.BLACK);
        tblTTPN.setFont(new Font("Arial", Font.PLAIN, 13));
        tblTTPN.getTableHeader().setReorderingAllowed(false);
        tblTTPN.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));

        //set SoLuong Spinner
        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, 0, 100, 1);
        txtSoLuong.setModel(modeSpinner);
        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) txtSoLuong.getEditor()).getTextField();
        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        txtSpinner.setEditable(true);
        txtSpinner.setHorizontalAlignment(JTextField.LEFT);
        txtSpinner.setBackground(Color.white);

        //Set hover cho tblDSSP
        tblDSSP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                int row = tblDSSP.rowAtPoint(evt.getPoint());
                int col = tblDSSP.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {

                    tblDSSP.setRowSelectionInterval(row, row);
                    tblDSSP.setColumnSelectionInterval(0, tblDSSP.getColumnCount() - 1);
                    tblDSSP.setSelectionBackground(new Color(152, 168, 248)); // đổi màu nền của ô khi hover
                }
            }
        });

//
//    
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

    public void loadDataGiaNhap() {

    }
//--    Hiển thị mã PN tiếp theo
//--    Lấy mã PN mới nhất + 1 để ra mã PN cần được tạo

    public void showMaPN(ArrayList<PhieuNhapDTO> dspn) {
        if (dspn.isEmpty()) {
            txtMaPN.setText(String.valueOf("PN01"));
        }
        for (int i = 0; i < dspn.size(); i++) {

            int sum = Integer.parseInt(dspn.get(i).getMaPN().substring(2)) + 1;
            if (sum < 10) {
                txtMaPN.setText(String.valueOf("PN0" + sum));
            } else {
                txtMaPN.setText(String.valueOf("PN" + sum));
            }
            sum = 0;

        }
    }

    private void loadDataMaPN() {
        pnBUS.docDanhSach();
        ArrayList<PhieuNhapDTO> dspn = pnBUS.getListPhieuNhap();
        showMaPN(dspn);
    }
//-- Xuất sản phẩm vừa thêm vào giỏ hàng ra table

    public void outModelHangChoNhap(DefaultTableModel dtmHangChoNhap, ArrayList<CTPhieuNhapDTO> dsctpn) {
        Vector data;
        dtmHangChoNhap.setRowCount(0);
        for (int i = 0; i < dsctpn.size(); i++) {
            dtmHangChoNhap.addRow(new String[]{
                dsctpn.get(i).getMaSP(),
                dsctpn.get(i).getTenSP(),
                String.valueOf(dsctpn.get(i).getSoLuong()),
                String.valueOf(dsctpn.get(i).getDonGia()),
                String.valueOf(dsctpn.get(i).getThanhTien())
            });
        }
    }
//--

//-- Tính tổng tiền hóa đơn
    public int sumPN() {
        int sum = 0;
        for (CTPhieuNhapDTO ctpn : dsctpn) {
            int SoLuong = ctpn.getSoLuong();
            int DonGia = ctpn.getDonGia();
            sum += SoLuong * DonGia;
        }
        return sum;
    }
//--
//    Thêm hàng vào table Thông tin hóa đơn
//--    Chỉ thêm vào table dòng cuối cùng của hóa đơn

    public void showAllTTPN(ArrayList<PhieuNhapDTO> dspn) {
        dtmThongTinPN.setRowCount(0);
        int i = dspn.size() - 1;
        dtmThongTinPN.addRow(new String[]{
            dspn.get(i).getMaPN(),
            dspn.get(i).getMaNCC(),
            dspn.get(i).getMaNV(),
            dspn.get(i).getNgayLap(),
            String.valueOf(dspn.get(i).getTongTien())
        });

    }
//--
//--    Load dữ liệu

    public void loadDataTTPN() {
        pnBUS.docDanhSach();
        ArrayList<PhieuNhapDTO> dspn = pnBUS.getListPhieuNhap();
        showAllTTPN(dspn);
    }
//--

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InPhieuNhapGUI = new javax.swing.JDialog();
        pnRootInPhieuNhapGUI = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTTPN = new javax.swing.JTable();
        pnHeader1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtMaPNinTTPN = new javax.swing.JTextField();
        lblMaSP8 = new javax.swing.JLabel();
        lblMaSP9 = new javax.swing.JLabel();
        txtMaNCCinTTPN = new javax.swing.JTextField();
        lblMaSP10 = new javax.swing.JLabel();
        txtMaNVinTTPN = new javax.swing.JTextField();
        lblMaSP11 = new javax.swing.JLabel();
        lblMaSP12 = new javax.swing.JLabel();
        txtTongTieninTTPN = new javax.swing.JTextField();
        txtNgayLapinTTPN = new com.toedter.calendar.JDateChooser();
        btnInPhieuNhapinTTPN = new javax.swing.JLabel();
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
        pnHangChoNhap = new javax.swing.JPanel();
        lblGioHang = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblHangChoNhap = new javax.swing.JTable();
        btnTaoPhieuNhap = new javax.swing.JLabel();
        btnInHoaDon = new javax.swing.JLabel();
        lblMaSP1 = new javax.swing.JLabel();
        txtMaPN = new javax.swing.JTextField();
        lblMaSP2 = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        lblMaSP3 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtNgayLap = new com.toedter.calendar.JDateChooser();
        lblMaSP4 = new javax.swing.JLabel();
        lblMaSP5 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        chooseMaNCC = new javax.swing.JButton();
        chooseMaNV = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JLabel();

        pnRootInPhieuNhapGUI.setBackground(new java.awt.Color(250, 247, 240));
        pnRootInPhieuNhapGUI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        tblTTPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", null, null, null, null}
            },
            new String [] {
                "Mã PN", "Mã NCC", "Mã NV", "Ngày lập", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTTPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTPNMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTTPN);
        if (tblTTPN.getColumnModel().getColumnCount() > 0) {
            tblTTPN.getColumnModel().getColumn(0).setResizable(false);
            tblTTPN.getColumnModel().getColumn(1).setResizable(false);
            tblTTPN.getColumnModel().getColumn(2).setResizable(false);
            tblTTPN.getColumnModel().getColumn(3).setResizable(false);
            tblTTPN.getColumnModel().getColumn(4).setResizable(false);
        }

        pnHeader1.setBackground(new java.awt.Color(152, 168, 248));
        pnHeader1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 0, 0)));
        pnHeader1.setPreferredSize(new java.awt.Dimension(102, 40));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblLoai.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        jLabel9.setText("THÔNG TIN PHIẾU NHẬP CHỜ IN");

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
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jPanel6.add(txtMaPNinTTPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 143, 24));

        lblMaSP8.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP8.setText("Mã PN");
        jPanel6.add(lblMaSP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        lblMaSP9.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP9.setText("Mã NCC");
        jPanel6.add(lblMaSP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));
        jPanel6.add(txtMaNCCinTTPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 143, 24));

        lblMaSP10.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP10.setText("Mã NV");
        jPanel6.add(lblMaSP10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));
        jPanel6.add(txtMaNVinTTPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 143, 24));

        lblMaSP11.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP11.setText("Ngày lập");
        jPanel6.add(lblMaSP11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        lblMaSP12.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP12.setText("Tổng tiền");
        jPanel6.add(lblMaSP12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));
        jPanel6.add(txtTongTieninTTPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 140, 24));

        txtNgayLapinTTPN.setDateFormatString("dd/MM/yyyy");
        jPanel6.add(txtNgayLapinTTPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 143, 24));

        btnInPhieuNhapinTTPN.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnInPhieuNhapinTTPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblInHoaDon.png"))); // NOI18N
        btnInPhieuNhapinTTPN.setText("In phiếu nhập");
        btnInPhieuNhapinTTPN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInPhieuNhapinTTPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInPhieuNhapinTTPNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnRootInPhieuNhapGUILayout = new javax.swing.GroupLayout(pnRootInPhieuNhapGUI);
        pnRootInPhieuNhapGUI.setLayout(pnRootInPhieuNhapGUILayout);
        pnRootInPhieuNhapGUILayout.setHorizontalGroup(
            pnRootInPhieuNhapGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
            .addGroup(pnRootInPhieuNhapGUILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRootInPhieuNhapGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRootInPhieuNhapGUILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInPhieuNhapinTTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );
        pnRootInPhieuNhapGUILayout.setVerticalGroup(
            pnRootInPhieuNhapGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRootInPhieuNhapGUILayout.createSequentialGroup()
                .addComponent(pnHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnInPhieuNhapinTTPN)
                .addContainerGap())
        );

        javax.swing.GroupLayout InPhieuNhapGUILayout = new javax.swing.GroupLayout(InPhieuNhapGUI.getContentPane());
        InPhieuNhapGUI.getContentPane().setLayout(InPhieuNhapGUILayout);
        InPhieuNhapGUILayout.setHorizontalGroup(
            InPhieuNhapGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRootInPhieuNhapGUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        InPhieuNhapGUILayout.setVerticalGroup(
            InPhieuNhapGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRootInPhieuNhapGUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnRoot.setBackground(new java.awt.Color(250, 247, 240));

        pnDSSP.setBackground(new java.awt.Color(250, 247, 240));
        pnDSSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 4, new java.awt.Color(0, 0, 0)));
        pnDSSP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDSSP.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblDSSP.setForeground(new java.awt.Color(255, 51, 51));
        lblDSSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDSSP.setText("Sản phẩm cần nhập");
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
            tblDSSP.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblDSSP.getColumnModel().getColumn(1).setResizable(false);
            tblDSSP.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblDSSP.getColumnModel().getColumn(2).setResizable(false);
            tblDSSP.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblDSSP.getColumnModel().getColumn(3).setResizable(false);
            tblDSSP.getColumnModel().getColumn(3).setPreferredWidth(1);
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
        btnThemSP.setText("Thêm sản phẩm");
        btnThemSP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemSPMouseClicked(evt);
            }
        });
        pnDSSP.add(btnThemSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 640, 190, -1));
        pnDSSP.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 230, 24));

        jLabel1.setFont(new java.awt.Font("Baloo 2 SemiBold", 2, 13)); // NOI18N
        jLabel1.setText("Đơn giá đề xuất :");
        pnDSSP.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, -1, 30));

        lblGiaNhap.setText(" ");
        pnDSSP.add(lblGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 600, 100, -1));

        pnHangChoNhap.setBackground(new java.awt.Color(250, 247, 240));

        lblGioHang.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblGioHang.setForeground(new java.awt.Color(255, 51, 51));
        lblGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioHang.setText("Hàng chờ nhập");

        tblHangChoNhap.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHangChoNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangChoNhapMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblHangChoNhap);
        if (tblHangChoNhap.getColumnModel().getColumnCount() > 0) {
            tblHangChoNhap.getColumnModel().getColumn(0).setResizable(false);
            tblHangChoNhap.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblHangChoNhap.getColumnModel().getColumn(1).setResizable(false);
            tblHangChoNhap.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblHangChoNhap.getColumnModel().getColumn(2).setResizable(false);
            tblHangChoNhap.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblHangChoNhap.getColumnModel().getColumn(3).setResizable(false);
            tblHangChoNhap.getColumnModel().getColumn(4).setResizable(false);
            tblHangChoNhap.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        btnTaoPhieuNhap.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnTaoPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnAdd.png"))); // NOI18N
        btnTaoPhieuNhap.setText("Tạo phiếu nhập");
        btnTaoPhieuNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoPhieuNhapMouseClicked(evt);
            }
        });

        btnInHoaDon.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblInHoaDon.png"))); // NOI18N
        btnInHoaDon.setText("In phiếu nhập");
        btnInHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInHoaDonMouseClicked(evt);
            }
        });

        lblMaSP1.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP1.setText("Mã HD");

        lblMaSP2.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP2.setText("Mã NCC");

        lblMaSP3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP3.setText("Mã NV");

        txtNgayLap.setDateFormatString("dd/MM/yyyy");

        lblMaSP4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP4.setText("Ngày tạo");

        lblMaSP5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP5.setText("Tổng tiền");

        chooseMaNCC.setText("...");
        chooseMaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseMaNCCActionPerformed(evt);
            }
        });

        chooseMaNV.setText("...");
        chooseMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseMaNVActionPerformed(evt);
            }
        });

        btnXoaSanPham.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnXoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnDelete.png"))); // NOI18N
        btnXoaSanPham.setText("Xóa sản phẩm");
        btnXoaSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaSanPhamMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnHangChoNhapLayout = new javax.swing.GroupLayout(pnHangChoNhap);
        pnHangChoNhap.setLayout(pnHangChoNhapLayout);
        pnHangChoNhapLayout.setHorizontalGroup(
            pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHangChoNhapLayout.createSequentialGroup()
                .addGroup(pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnHangChoNhapLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnHangChoNhapLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMaSP3)
                        .addGap(30, 30, 30)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chooseMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnHangChoNhapLayout.createSequentialGroup()
                            .addGap(113, 113, 113)
                            .addComponent(btnTaoPhieuNhap)
                            .addGap(79, 79, 79)
                            .addComponent(btnInHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnHangChoNhapLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMaSP1)
                                .addComponent(lblMaSP2))
                            .addGap(22, 22, 22)
                            .addGroup(pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnHangChoNhapLayout.createSequentialGroup()
                                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(chooseMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(lblMaSP5)
                                    .addGap(11, 11, 11)
                                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnHangChoNhapLayout.createSequentialGroup()
                                    .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(71, 71, 71)
                                    .addComponent(lblMaSP4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnHangChoNhapLayout.setVerticalGroup(
            pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHangChoNhapLayout.createSequentialGroup()
                .addComponent(lblGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnXoaSanPham)
                .addGap(10, 10, 10)
                .addGroup(pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaSP4)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnHangChoNhapLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaSP1)
                            .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaSP5)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnHangChoNhapLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaSP2)
                            .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooseMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaSP3))
                .addGap(43, 43, 43)
                .addGroup(pnHangChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTaoPhieuNhap)
                    .addComponent(btnInHoaDon))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnHangChoNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHangChoNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        txtMaSP.setText(tblDSSP.getModel().getValueAt(k, 0).toString());
        txtTenSP.setText(tblDSSP.getModel().getValueAt(k, 1).toString());
        imgName = tblDSSP.getModel().getValueAt(k, 3).toString();
        //--Lấy giá nhập đề xuất
        khoBUS.docDanhSach();
        ArrayList<KhoDTO> dskho = khoBUS.getListKho();
        for (KhoDTO kho : dskho) {
            if (txtMaSP.getText().equals(kho.getMaSP())) {
                lblGiaNhap.setText(String.valueOf(kho.getGiaNhap()));
                txtDonGia.setText(String.valueOf(kho.getGiaNhap()));
            }
        }
        //--

        Image newImage;
        newImage = new ImageIcon("./src/image/SanPham/" + imgName).getImage().getScaledInstance(155, 185, Image.SCALE_DEFAULT);
        txtIMG.setIcon(new ImageIcon(newImage));

        txtMaSP.setEnabled(false);
        txtTenSP.setEnabled(false);
    }//GEN-LAST:event_tblDSSPMouseClicked

    private void btnThemSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemSPMouseClicked

        String MaPN = txtMaPN.getText();
        String MaSP = txtMaSP.getText();
        String TenSP = txtTenSP.getText();
        int SoLuong = Integer.parseInt(txtSoLuong.getValue().toString());
        if (SoLuong >= 1) {
            if (isNumeric(txtDonGia.getText())) {
                int DonGia = Integer.parseInt(txtDonGia.getText());
                int ThanhTien = SoLuong * DonGia;

                int k = tblDSSP.getSelectedRow();
                int SoLuongConLai = Integer.parseInt(tblDSSP.getModel().getValueAt(k, 2).toString());

                khoBUS.capNhatSoLuongSP(MaSP, SoLuong, SoLuongConLai);
                khoBUS.docDanhSach();
                boolean flag = true;
                for (CTPhieuNhapDTO ctpn : dsctpn) {
                    if (ctpn.getMaSP().equals(MaSP)) {
                        int old = ctpn.getSoLuong();
                        ctpn.setSoLuong(old + SoLuong);
                        int new1 = ctpn.getSoLuong();
                        ctpn.setThanhTien(new1 * DonGia);
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    dsctpn.add(new CTPhieuNhapDTO(MaPN, MaSP, TenSP, SoLuong, DonGia, ThanhTien));

                }

                outModelHangChoNhap(dtmHangChoNhap, dsctpn);

                txtTongTien.setText(String.valueOf(sumPN()));

                txtMaSP.setText("");
                txtTenSP.setText("");
                txtSoLuong.setValue(0);
                txtDonGia.setText("");
                txtIMG.setIcon(null);
                txtIMG.setText("IMAGE");
                imgName = null;
            } else {
                JOptionPane.showMessageDialog(null, "Đơn giá không hợp lệ");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Số lượng nhập phải lớn hơn 0");
        }

    }//GEN-LAST:event_btnThemSPMouseClicked

    private void tblHangChoNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangChoNhapMouseClicked

    }//GEN-LAST:event_tblHangChoNhapMouseClicked

    private void btnTaoPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoPhieuNhapMouseClicked
        String MaPN = txtMaPN.getText();
        String MaNCC = txtMaNCC.getText();
        String MaNV = txtMaNV.getText();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String NgayLap = dateFormat.format(txtNgayLap.getDate());
        int TongTien = Integer.parseInt(txtTongTien.getText());

        PhieuNhapDTO pn = new PhieuNhapDTO(MaPN, MaNCC, MaNV, NgayLap, TongTien);
        pnBUS.add(pn);
//        loadDataTTHD(); //load thông tin hóa đơn

        txtMaPN.setText("");
        txtMaNCC.setText("");
        txtMaNV.setText("");
        txtTongTien.setText("");

        txtNgayLap.setCalendar(null);
        dtmHangChoNhap.setRowCount(0);
        int result = JOptionPane.showConfirmDialog(pnRoot, "Tạo phiếu nhập thành công. Nhấn OK để In phiếu nhập");
        if (result == JOptionPane.YES_OPTION) {
            InPhieuNhapGUI.setUndecorated(true);
            InPhieuNhapGUI.pack();
            InPhieuNhapGUI.setVisible(true);
            InPhieuNhapGUI.setLocationRelativeTo(null);
            loadDataTTPN(); //load thông tin hóa đơn
            ctpnBUS.docDanhSach();
            ArrayList<PhieuNhapDTO> dsctpn = pnBUS.getListPhieuNhap();
        } else {
            JOptionPane.showMessageDialog(pnRoot, "Nếu có nhu cầu, bạn hãy nhấn vào In phiếu nhập");
        }

    }//GEN-LAST:event_btnTaoPhieuNhapMouseClicked

    private void btnInHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHoaDonMouseClicked
        InPhieuNhapGUI.setUndecorated(true);
        InPhieuNhapGUI.pack();
        InPhieuNhapGUI.setVisible(true);
        InPhieuNhapGUI.setLocationRelativeTo(null);
        loadDataTTPN(); //load thông tin hóa đơn
        ctpnBUS.docDanhSach();
        ArrayList<PhieuNhapDTO> dsctpn = pnBUS.getListPhieuNhap();
    }//GEN-LAST:event_btnInHoaDonMouseClicked

    private void chooseMaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseMaNCCActionPerformed
        RCNhaCungCapGUI rcncc = new RCNhaCungCapGUI();
        rcncc.setVisible(true);
        String MaNCC = rcncc.getMaNCC();
        txtMaNCC.setText(MaNCC);
    }//GEN-LAST:event_chooseMaNCCActionPerformed

    private void chooseMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseMaNVActionPerformed
        RCNhanVienGUI rcnv = new RCNhanVienGUI();
        rcnv.setVisible(true);

        String MaNV = rcnv.getMaNV();
        txtMaNV.setText(MaNV);
    }//GEN-LAST:event_chooseMaNVActionPerformed

    private void btnXoaSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaSanPhamMouseClicked
        int k = tblHangChoNhap.getSelectedRow();
        String MaSP = tblHangChoNhap.getModel().getValueAt(k, 0).toString();
        int SoLuong = Integer.parseInt(tblHangChoNhap.getModel().getValueAt(k, 2).toString());

        //lấy số lượng sản phẩm hiện có trong kho
        khoBUS.docDanhSach();
        ArrayList<KhoDTO> dskho = khoBUS.getListKho();
        for (KhoDTO kho : dskho) {
            if (MaSP.equals(kho.getMaSP())) {
                SoLuongTrongKho = kho.getSoLuong();
            }
        }
        //--
        khoBUS.capNhatSoLuongSP(MaSP, -SoLuong, SoLuongTrongKho);
        khoBUS.docDanhSach();
        dsctpn.remove(k);
        dtmHangChoNhap.removeRow(k);
        txtTongTien.setText(String.valueOf(sumPN()));
        loadDataDSSP();

    }//GEN-LAST:event_btnXoaSanPhamMouseClicked

    private void tblTTPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTTPNMouseClicked
        int k = tblTTPN.getSelectedRow();
        txtMaPNinTTPN.setText(tblTTPN.getValueAt(k, 0).toString());
        txtMaNCCinTTPN.setText(tblTTPN.getValueAt(k, 1).toString());
        txtMaNVinTTPN.setText(tblTTPN.getValueAt(k, 2).toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date NgayLap = new Date();
        try {
            NgayLap = sdf.parse(tblTTPN.getModel().getValueAt(k, 3).toString());
        } catch (ParseException ex) {
            Logger.getLogger(PhieuNhapGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNgayLapinTTPN.setDate(NgayLap);
        txtTongTieninTTPN.setText(tblTTPN.getValueAt(k, 4).toString());

        txtMaPNinTTPN.setEnabled(false);
        txtMaNCCinTTPN.setEnabled(false);
        txtMaNVinTTPN.setEnabled(false);
        txtNgayLapinTTPN.setEnabled(false);
        txtTongTieninTTPN.setEnabled(false);
    }//GEN-LAST:event_tblTTPNMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        InPhieuNhapGUI.dispose();
        txtMaPNinTTPN.setText("");
        txtMaNCCinTTPN.setText("");
        txtMaNVinTTPN.setText("");
        txtNgayLapinTTPN.setCalendar(null);
        txtTongTieninTTPN.setText("");
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnInPhieuNhapinTTPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInPhieuNhapinTTPNMouseClicked

        for (CTPhieuNhapDTO ctpn : dsctpn) {
            ctpnBUS.add(ctpn);
        }
        //Xuất pdf
        String MaPN = txtMaPNinTTPN.getText();
        String MaNCC = txtMaNCCinTTPN.getText();
        String MaNV = txtMaNVinTTPN.getText();

       
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // định dạng ngày
        String NgayLap = sdf.format(txtNgayLapinTTPN.getDate());
        System.out.println(NgayLap);
        int TongTien = Integer.parseInt(txtTongTieninTTPN.getText());

        PhieuNhapDTO pn = new PhieuNhapDTO(MaPN, MaNCC, MaNV, NgayLap, TongTien);
        XuatPhieuNhapBUS xuatpn = new XuatPhieuNhapBUS(pn, dsctpn);
        xuatpn.print();
        txtMaPNinTTPN.setText("");
        txtMaNCCinTTPN.setText("");
        txtMaNVinTTPN.setText("");
        txtNgayLapinTTPN.setCalendar(null);
        txtTongTieninTTPN.setText("");

//        JOptionPane.showMessageDialog(pnRootInPhieuNhapGUI, "In phiếu nhập thành công");
        loadDataDSSP();
    }//GEN-LAST:event_btnInPhieuNhapinTTPNMouseClicked
    public static void setMaNCC(String ma) {
        txtMaNCC.setText(ma);
        chooseNCC = false;
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog InPhieuNhapGUI;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnInHoaDon;
    private javax.swing.JLabel btnInPhieuNhapinTTPN;
    private javax.swing.JLabel btnTaoPhieuNhap;
    private javax.swing.JLabel btnThemSP;
    private javax.swing.JLabel btnXoaSanPham;
    private javax.swing.JButton chooseMaNCC;
    private javax.swing.JButton chooseMaNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JLabel lblMaSP10;
    private javax.swing.JLabel lblMaSP11;
    private javax.swing.JLabel lblMaSP12;
    private javax.swing.JLabel lblMaSP2;
    private javax.swing.JLabel lblMaSP3;
    private javax.swing.JLabel lblMaSP4;
    private javax.swing.JLabel lblMaSP5;
    private javax.swing.JLabel lblMaSP8;
    private javax.swing.JLabel lblMaSP9;
    private javax.swing.JPanel pnDSSP;
    private javax.swing.JPanel pnHangChoNhap;
    private javax.swing.JPanel pnHeader1;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JPanel pnRootInPhieuNhapGUI;
    private javax.swing.JTable tblDSSP;
    private javax.swing.JTable tblHangChoNhap;
    private javax.swing.JTable tblTTPN;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JLabel txtIMG;
    private static javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNCCinTTPN;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaNVinTTPN;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtMaPNinTTPN;
    private javax.swing.JTextField txtMaSP;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private com.toedter.calendar.JDateChooser txtNgayLapinTTPN;
    private javax.swing.JSpinner txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTongTieninTTPN;
    // End of variables declaration//GEN-END:variables
}
