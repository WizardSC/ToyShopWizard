/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.CTPhieuNhapBUS;
import BUS.PhieuNhapBUS;
import DTO.CTPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wizardsc
 */
public class DSPhieuNhapGUI extends javax.swing.JPanel {

    DefaultTableModel dtmPhieuNhap;
    DefaultTableModel dtmCTPhieuNhap;
    PhieuNhapBUS pnBUS = new PhieuNhapBUS();
    CTPhieuNhapBUS ctpnBUS = new CTPhieuNhapBUS();
    public DSPhieuNhapGUI() {
        initComponents();
        init();
        
        dtmPhieuNhap = (DefaultTableModel) tblDSPN.getModel();
        dtmCTPhieuNhap = (DefaultTableModel) tblDSCTPN.getModel();
        loadDataDSPN();
    }

    public void init(){
        //set giao diện cho Table
        //DSHD
        tblDSPN.setFocusable(false);
        tblDSPN.setIntercellSpacing(new Dimension(0, 0));
        tblDSPN.setRowHeight(25);
        tblDSPN.setFillsViewportHeight(true);
        tblDSPN.getTableHeader().setOpaque(false);
        tblDSPN.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSPN.getTableHeader().setForeground(Color.WHITE);
        tblDSPN.setSelectionBackground(new Color(188, 206, 248));
        tblDSPN.setSelectionForeground(Color.BLACK);
        tblDSPN.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSPN.getTableHeader().setReorderingAllowed(false);
        tblDSPN.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
        //DSCTHD
        tblDSCTPN.setFocusable(false);
        tblDSCTPN.setIntercellSpacing(new Dimension(0, 0));
        tblDSCTPN.setRowHeight(25);
        tblDSCTPN.setFillsViewportHeight(true);
        tblDSCTPN.getTableHeader().setOpaque(false);
        tblDSCTPN.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSCTPN.getTableHeader().setForeground(Color.WHITE);
        tblDSCTPN.setSelectionBackground(new Color(188, 206, 248));
        tblDSCTPN.setSelectionForeground(Color.BLACK);
        tblDSCTPN.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSCTPN.getTableHeader().setReorderingAllowed(false);
        tblDSCTPN.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
        
//        

        tblDSPN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                int row = tblDSPN.rowAtPoint(evt.getPoint());
                int col = tblDSPN.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    
                    tblDSPN.setRowSelectionInterval(row, row);
                    tblDSPN.setColumnSelectionInterval(0, tblDSPN.getColumnCount() - 1);
                    tblDSPN.setSelectionBackground(new Color(188, 206, 248)); // đổi màu nền của ô khi hover
                }
            }
        });
    }
    
    public void showAllDSPN(ArrayList<PhieuNhapDTO> dspn){
        dtmPhieuNhap.setRowCount(0);
        for(int i=0;i<dspn.size();i++){
            dtmPhieuNhap.addRow(new String[]{
                dspn.get(i).getMaPN(),
                dspn.get(i).getMaNCC(),
                dspn.get(i).getMaNV(),
                dspn.get(i).getNgayLap(),
                String.valueOf(dspn.get(i).getTongTien())
            });
        }
    }
    
    public void showAllDSCTPN(ArrayList<CTPhieuNhapDTO> dsctpn){
        dtmCTPhieuNhap.setRowCount(0);
        for(int i=0;i<dsctpn.size();i++){
            dtmCTPhieuNhap.addRow(new String[]{
                dsctpn.get(i).getMaPN(),
                dsctpn.get(i).getMaSP(),
                dsctpn.get(i).getTenSP(),
                String.valueOf(dsctpn.get(i).getDonGia()),
                String.valueOf(dsctpn.get(i).getSoLuong()),
                String.valueOf(dsctpn.get(i).getThanhTien()),
            });
        }
    }
    
    public void loadDataDSPN(){
        pnBUS.docDanhSach();
        ArrayList<PhieuNhapDTO> dspn = pnBUS.getListPhieuNhap();
        showAllDSPN(dspn);
    }
    
    public void loadDataDSCTPNtheoMaPN(String MaPN){
        if (ctpnBUS.getListCTPN() == null){
            ctpnBUS.listCTPN();
        }
        ArrayList<CTPhieuNhapDTO> dsctpn = ctpnBUS.getListCTPNtheoMaPN(MaPN);
        dtmCTPhieuNhap.setRowCount(0);
        showAllDSCTPN(dsctpn);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pnRoot = new javax.swing.JPanel();
        pnDSSP = new javax.swing.JPanel();
        lblDSSP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSPN = new javax.swing.JTable();
        lblMaPN = new javax.swing.JLabel();
        txtMaPN = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        lblHo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgayLap = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btnTimKiemNC = new javax.swing.JLabel();
        cbxTimKiemNC = new javax.swing.JComboBox<>();
        cbxTimKiem = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        lblMaPN2 = new javax.swing.JLabel();
        txtFrom = new javax.swing.JTextField();
        lblMaPN1 = new javax.swing.JLabel();
        txtTo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        pnGioHang = new javax.swing.JPanel();
        lblGioHang = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDSCTPN = new javax.swing.JTable();
        lblMaPNinDSPN = new javax.swing.JLabel();
        txtMaPNinDSPN = new javax.swing.JTextField();
        lblSanPhaminDSPN = new javax.swing.JLabel();
        txtTenSPinDSPN = new javax.swing.JTextField();
        lblTenSPinDSPN = new javax.swing.JLabel();
        lblSoLuonginDSPN = new javax.swing.JLabel();
        lblDonGiainDSPN = new javax.swing.JLabel();
        lblThanhTieninDSPN = new javax.swing.JLabel();
        txtSoLuonginDSPN = new javax.swing.JTextField();
        txtThanhTieninDSPN = new javax.swing.JTextField();
        txtMaSPinDSPN = new javax.swing.JTextField();
        txtDonGiainDSPN = new javax.swing.JTextField();

        pnRoot.setBackground(new java.awt.Color(250, 247, 240));

        pnDSSP.setBackground(new java.awt.Color(250, 247, 240));
        pnDSSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 4, new java.awt.Color(0, 0, 0)));

        lblDSSP.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblDSSP.setForeground(new java.awt.Color(255, 51, 51));
        lblDSSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDSSP.setText("Danh sách phiếu nhập");

        tblDSPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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
        tblDSPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSPNMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSPN);
        if (tblDSPN.getColumnModel().getColumnCount() > 0) {
            tblDSPN.getColumnModel().getColumn(0).setResizable(false);
            tblDSPN.getColumnModel().getColumn(1).setResizable(false);
            tblDSPN.getColumnModel().getColumn(2).setResizable(false);
            tblDSPN.getColumnModel().getColumn(3).setResizable(false);
            tblDSPN.getColumnModel().getColumn(4).setResizable(false);
        }

        lblMaPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPN.setText("Mã PN");

        txtMaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPNActionPerformed(evt);
            }
        });

        lblHo.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblHo.setText("Mã NV");

        jLabel3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel3.setText("Mã NCC");

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Ngày lập");

        jLabel5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel5.setText("Tổng tiền");

        txtNgayLap.setDateFormatString("dd/MM/yyyy");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N

        btnTimKiemNC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTimKiemNC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemNCMouseClicked(evt);
            }
        });

        cbxTimKiemNC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tổng tiền" }));
        cbxTimKiemNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemNCActionPerformed(evt);
            }
        });

        cbxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã PN", "<Mã NCC", "Mã NV" }));
        cbxTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemActionPerformed(evt);
            }
        });

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        lblMaPN2.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPN2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaPN2.setText("Từ");

        lblMaPN1.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaPN1.setText("Đến");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N

        jTextField1.setText("Tháng");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));

        javax.swing.GroupLayout pnDSSPLayout = new javax.swing.GroupLayout(pnDSSP);
        pnDSSP.setLayout(pnDSSPLayout);
        pnDSSPLayout.setHorizontalGroup(
            pnDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDSSP, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnDSSPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnDSSPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblMaPN)
                .addGap(26, 26, 26)
                .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(21, 21, 21)
                .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnDSSPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblHo)
                .addGap(26, 26, 26)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(14, 14, 14)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnDSSPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnDSSPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnDSSPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnDSSPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnTimKiemNC)
                .addGap(28, 28, 28)
                .addComponent(cbxTimKiemNC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblMaPN2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblMaPN1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnDSSPLayout.setVerticalGroup(
            pnDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDSSPLayout.createSequentialGroup()
                .addComponent(lblDSSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaPN)
                    .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(pnDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHo)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(pnDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(pnDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiemNC)
                    .addComponent(cbxTimKiemNC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaPN2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaPN1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnGioHang.setBackground(new java.awt.Color(250, 247, 240));
        pnGioHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGioHang.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblGioHang.setForeground(new java.awt.Color(255, 51, 51));
        lblGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioHang.setText("Chi tiết phiếu nhập");
        pnGioHang.add(lblGioHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 563, 21));

        tblDSCTPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PN", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSCTPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSCTPNMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDSCTPN);
        if (tblDSCTPN.getColumnModel().getColumnCount() > 0) {
            tblDSCTPN.getColumnModel().getColumn(0).setResizable(false);
            tblDSCTPN.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblDSCTPN.getColumnModel().getColumn(1).setResizable(false);
            tblDSCTPN.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblDSCTPN.getColumnModel().getColumn(2).setResizable(false);
            tblDSCTPN.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblDSCTPN.getColumnModel().getColumn(3).setResizable(false);
            tblDSCTPN.getColumnModel().getColumn(3).setPreferredWidth(25);
            tblDSCTPN.getColumnModel().getColumn(4).setResizable(false);
            tblDSCTPN.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblDSCTPN.getColumnModel().getColumn(5).setResizable(false);
            tblDSCTPN.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        pnGioHang.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 33, 563, 411));

        lblMaPNinDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPNinDSPN.setText("Mã PN");
        pnGioHang.add(lblMaPNinDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 464, -1, -1));
        pnGioHang.add(txtMaPNinDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 462, 158, 24));

        lblSanPhaminDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblSanPhaminDSPN.setText("Mã SP");
        pnGioHang.add(lblSanPhaminDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 464, -1, -1));
        pnGioHang.add(txtTenSPinDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 504, 449, 24));

        lblTenSPinDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblTenSPinDSPN.setText("Tên SP");
        pnGioHang.add(lblTenSPinDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 506, -1, -1));

        lblSoLuonginDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblSoLuonginDSPN.setText("Số lượng");
        pnGioHang.add(lblSoLuonginDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 547, -1, -1));

        lblDonGiainDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblDonGiainDSPN.setText("Đơn giá");
        pnGioHang.add(lblDonGiainDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 547, -1, -1));

        lblThanhTieninDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblThanhTieninDSPN.setText("Thành tiền");
        pnGioHang.add(lblThanhTieninDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 589, -1, -1));
        pnGioHang.add(txtSoLuonginDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 545, 159, 24));
        pnGioHang.add(txtThanhTieninDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 587, 447, 24));
        pnGioHang.add(txtMaSPinDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 462, 171, 24));
        pnGioHang.add(txtDonGiainDSPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 545, 173, 24));

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addComponent(pnDSSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1084, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSPNMouseClicked
        int k = tblDSPN.getSelectedRow();
        txtMaPN.setText(tblDSPN.getModel().getValueAt(k,0).toString());
        txtMaNCC.setText(tblDSPN.getModel().getValueAt(k,1).toString());
        txtMaNV.setText(tblDSPN.getModel().getValueAt(k,2).toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date NgayLap = new Date();
        try {
            NgayLap = sdf.parse(tblDSPN.getModel().getValueAt(k, 3).toString());
        } catch (ParseException ex) {
            System.out.println("Sai thgian");
            Logger.getLogger(DSPhieuNhapGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNgayLap.setDate(NgayLap);
        txtTongTien.setText(tblDSPN.getModel().getValueAt(k,4).toString());
        txtMaPN.setEnabled(false);
        txtMaNV.setEnabled(false);
        txtMaNCC.setEnabled(false);
        txtNgayLap.setEnabled(false);
        txtTongTien.setEnabled(false);
        String MaPN = txtMaPN.getText();
        loadDataDSCTPNtheoMaPN(MaPN);
    }//GEN-LAST:event_tblDSPNMouseClicked

    private void txtMaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPNActionPerformed

    }//GEN-LAST:event_txtMaPNActionPerformed

    private void tblDSCTPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSCTPNMouseClicked
        int k = tblDSCTPN.getSelectedRow();
        txtMaPNinDSPN.setText(tblDSCTPN.getModel().getValueAt(k,0).toString());
        txtMaSPinDSPN.setText(tblDSCTPN.getModel().getValueAt(k,1).toString());
        txtTenSPinDSPN.setText(tblDSCTPN.getModel().getValueAt(k,2).toString());
        txtSoLuonginDSPN.setText(tblDSCTPN.getModel().getValueAt(k,3).toString());
        txtDonGiainDSPN.setText(tblDSCTPN.getModel().getValueAt(k,4).toString());
        txtThanhTieninDSPN.setText(tblDSCTPN.getModel().getValueAt(k,5).toString());
        
        txtMaPNinDSPN.setEnabled(false);
        txtMaSPinDSPN.setEnabled(false);
        txtTenSPinDSPN.setEnabled(false);
        txtSoLuonginDSPN.setEnabled(false);
        txtDonGiainDSPN.setEnabled(false);
        txtThanhTieninDSPN.setEnabled(false);    
    }//GEN-LAST:event_tblDSCTPNMouseClicked

    private void btnTimKiemNCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemNCMouseClicked
//        if(!clickedOnce){
//            ArrayList<PhieuXuatDTO> dspx = pxBUS.searchTongTien(Integer.parseInt(txtFrom.getText()), Integer.parseInt(txtTo.getText()));
//            showAllDSPX(dspx);
//            clickedOnce = true;
//        } else {
//            txtFrom.setText("");
//            txtTo.setText("");
//            loadDataDSPX();
//            clickedOnce = false;
//        }

    }//GEN-LAST:event_btnTimKiemNCMouseClicked

    private void cbxTimKiemNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemNCActionPerformed
//        tuKhoaTimKiem = cbxTimKiemNC.getSelectedItem().toString();
//        System.out.println(tuKhoaTimKiem);
    }//GEN-LAST:event_cbxTimKiemNCActionPerformed

    private void cbxTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemActionPerformed
//        tuKhoaTimKiem = cbxTimKiem.getSelectedItem().toString();
//        txtTimKiem.setText("");
    }//GEN-LAST:event_cbxTimKiemActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed

    }//GEN-LAST:event_txtTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnTimKiemNC;
    private javax.swing.JComboBox<String> cbxTimKiem;
    private javax.swing.JComboBox<String> cbxTimKiemNC;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDSSP;
    private javax.swing.JLabel lblDonGiainDSPN;
    private javax.swing.JLabel lblGioHang;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMaPN;
    private javax.swing.JLabel lblMaPN1;
    private javax.swing.JLabel lblMaPN2;
    private javax.swing.JLabel lblMaPNinDSPN;
    private javax.swing.JLabel lblSanPhaminDSPN;
    private javax.swing.JLabel lblSoLuonginDSPN;
    private javax.swing.JLabel lblTenSPinDSPN;
    private javax.swing.JLabel lblThanhTieninDSPN;
    private javax.swing.JPanel pnDSSP;
    private javax.swing.JPanel pnGioHang;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JTable tblDSCTPN;
    private javax.swing.JTable tblDSPN;
    private javax.swing.JTextField txtDonGiainDSPN;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtMaPNinDSPN;
    private javax.swing.JTextField txtMaSPinDSPN;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private javax.swing.JTextField txtSoLuonginDSPN;
    private javax.swing.JTextField txtTenSPinDSPN;
    private javax.swing.JTextField txtThanhTieninDSPN;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTo;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
