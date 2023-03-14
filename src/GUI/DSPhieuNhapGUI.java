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
import java.util.ArrayList;
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
        lblMaSP1 = new javax.swing.JLabel();
        txtMaCTPN = new javax.swing.JTextField();
        lblMaSP5 = new javax.swing.JLabel();
        lblMaSP6 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        lblMaSP7 = new javax.swing.JLabel();
        txtThanhToan = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

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
            tblDSCTPN.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblDSCTPN.getColumnModel().getColumn(1).setResizable(false);
            tblDSCTPN.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblDSCTPN.getColumnModel().getColumn(2).setResizable(false);
            tblDSCTPN.getColumnModel().getColumn(2).setPreferredWidth(230);
            tblDSCTPN.getColumnModel().getColumn(3).setResizable(false);
            tblDSCTPN.getColumnModel().getColumn(3).setPreferredWidth(25);
            tblDSCTPN.getColumnModel().getColumn(4).setResizable(false);
            tblDSCTPN.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblDSCTPN.getColumnModel().getColumn(5).setResizable(false);
            tblDSCTPN.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        lblMaSP1.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP1.setText("Mã HD");

        lblMaSP5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP5.setText("Tổng tiền");

        lblMaSP6.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP6.setText("Khuyến mãi");

        lblMaSP7.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP7.setText("Thanh toán");

        jButton3.setText("...");

        javax.swing.GroupLayout pnGioHangLayout = new javax.swing.GroupLayout(pnGioHang);
        pnGioHang.setLayout(pnGioHangLayout);
        pnGioHangLayout.setHorizontalGroup(
            pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaSP1)
                .addGap(32, 32, 32)
                .addComponent(txtMaCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaSP5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMaSP6, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblMaSP7, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGioHangLayout.createSequentialGroup()
                        .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(pnGioHangLayout.createSequentialGroup()
                        .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(4, 4, 4))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGioHangLayout.createSequentialGroup()
                .addComponent(lblGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnGioHangLayout.setVerticalGroup(
            pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGioHangLayout.createSequentialGroup()
                        .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaSP1))
                        .addGap(18, 18, 18)
                        .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaSP6)
                            .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaSP7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblMaSP5))
                .addContainerGap(123, Short.MAX_VALUE))
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
            .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
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
        String MaPN = txtMaPN.getText();
        loadDataDSCTPNtheoMaPN(MaPN);
    }//GEN-LAST:event_tblDSPNMouseClicked

    private void txtMaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPNActionPerformed

    }//GEN-LAST:event_txtMaPNActionPerformed

    private void tblDSCTPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSCTPNMouseClicked

    }//GEN-LAST:event_tblDSCTPNMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblDSSP;
    private javax.swing.JLabel lblGioHang;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMaPN;
    private javax.swing.JLabel lblMaSP1;
    private javax.swing.JLabel lblMaSP5;
    private javax.swing.JLabel lblMaSP6;
    private javax.swing.JLabel lblMaSP7;
    private javax.swing.JPanel pnDSSP;
    private javax.swing.JPanel pnGioHang;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JTable tblDSCTPN;
    private javax.swing.JTable tblDSPN;
    private javax.swing.JTextField txtMaCTPN;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPN;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private javax.swing.JTextField txtThanhToan;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
