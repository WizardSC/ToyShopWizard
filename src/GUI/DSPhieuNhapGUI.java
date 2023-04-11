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
        pnDSSP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDSSP.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblDSSP.setForeground(new java.awt.Color(255, 51, 51));
        lblDSSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDSSP.setText("Danh sách phiếu nhập");
        pnDSSP.add(lblDSSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 30));

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

        pnDSSP.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 480, 430));

        lblMaPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPN.setText("Mã PN");
        pnDSSP.add(lblMaPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        txtMaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPNActionPerformed(evt);
            }
        });
        pnDSSP.add(txtMaPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 160, 24));
        pnDSSP.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 160, 24));

        lblHo.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblHo.setText("Mã NV");
        pnDSSP.add(lblHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        jLabel3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel3.setText("Mã NCC");
        pnDSSP.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Ngày lập");
        pnDSSP.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, -1, -1));
        pnDSSP.add(txtMaNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 160, 24));
        pnDSSP.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 520, 160, 24));

        jLabel5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel5.setText("Tổng tiền");
        pnDSSP.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, -1, -1));

        txtNgayLap.setDateFormatString("dd/MM/yyyy");
        pnDSSP.add(txtNgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 160, 24));

        pnGioHang.setBackground(new java.awt.Color(250, 247, 240));

        lblGioHang.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblGioHang.setForeground(new java.awt.Color(255, 51, 51));
        lblGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioHang.setText("Chi tiết phiếu nhập");

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

        lblMaPNinDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPNinDSPN.setText("Mã PN");

        lblSanPhaminDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblSanPhaminDSPN.setText("Mã SP");

        lblTenSPinDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblTenSPinDSPN.setText("Tên SP");

        lblSoLuonginDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblSoLuonginDSPN.setText("Số lượng");

        lblDonGiainDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblDonGiainDSPN.setText("Đơn giá");

        lblThanhTieninDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblThanhTieninDSPN.setText("Thành tiền");

        javax.swing.GroupLayout pnGioHangLayout = new javax.swing.GroupLayout(pnGioHang);
        pnGioHang.setLayout(pnGioHangLayout);
        pnGioHangLayout.setHorizontalGroup(
            pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(lblGioHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnGioHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenSPinDSPN)
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addComponent(lblMaPNinDSPN)
                                .addGap(257, 257, 257)
                                .addComponent(lblSanPhaminDSPN)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaSPinDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGioHangLayout.createSequentialGroup()
                        .addComponent(lblThanhTieninDSPN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtThanhTieninDSPN))
                    .addGroup(pnGioHangLayout.createSequentialGroup()
                        .addComponent(lblSoLuonginDSPN)
                        .addGap(18, 19, Short.MAX_VALUE)
                        .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addComponent(txtSoLuonginDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(lblDonGiainDSPN)
                                .addGap(18, 18, 18)
                                .addComponent(txtDonGiainDSPN, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenSPinDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaPNinDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 1, Short.MAX_VALUE)))))
                .addGap(30, 30, 30))
        );
        pnGioHangLayout.setVerticalGroup(
            pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPNinDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaPNinDSPN)
                    .addComponent(lblSanPhaminDSPN)
                    .addComponent(txtMaSPinDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenSPinDSPN)
                    .addComponent(txtTenSPinDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSoLuonginDSPN)
                        .addComponent(txtSoLuonginDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDonGiainDSPN)
                        .addComponent(txtDonGiainDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThanhTieninDSPN)
                    .addComponent(txtThanhTieninDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblDSSP;
    private javax.swing.JLabel lblDonGiainDSPN;
    private javax.swing.JLabel lblGioHang;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMaPN;
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
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtMaPNinDSPN;
    private javax.swing.JTextField txtMaSPinDSPN;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private javax.swing.JTextField txtSoLuonginDSPN;
    private javax.swing.JTextField txtTenSPinDSPN;
    private javax.swing.JTextField txtThanhTieninDSPN;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
