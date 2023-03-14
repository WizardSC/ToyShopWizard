/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.CTPhieuXuatBUS;
import BUS.PhieuXuatBUS;
import DTO.CTPhieuXuatDTO;
import DTO.PhieuXuatDTO;
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
public class DSPhieuXuatGUI extends javax.swing.JPanel {

    DefaultTableModel dtmPhieuXuat;
    DefaultTableModel dtmCTPhieuXuat;
    private PhieuXuatBUS pxBUS = new PhieuXuatBUS();
    private CTPhieuXuatBUS ctpxBUS = new CTPhieuXuatBUS();
    public DSPhieuXuatGUI() {
        initComponents();
        
        dtmPhieuXuat = (DefaultTableModel) tblDSPX.getModel();
        dtmCTPhieuXuat = (DefaultTableModel) tblDSCTPX.getModel();
        init();
        loadDataDSPX();
    }
    public void init(){
        //set giao diện cho Table
        //DSPX
        tblDSPX.setFocusable(false);
        tblDSPX.setIntercellSpacing(new Dimension(0, 0));
        tblDSPX.setRowHeight(25);
        tblDSPX.setFillsViewportHeight(true);
        tblDSPX.getTableHeader().setOpaque(false);
        tblDSPX.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSPX.getTableHeader().setForeground(Color.WHITE);
        tblDSPX.setSelectionBackground(new Color(188, 206, 248));
        tblDSPX.setSelectionForeground(Color.BLACK);
        tblDSPX.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSPX.getTableHeader().setReorderingAllowed(false);
        tblDSPX.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
        //DSCTPX
        tblDSCTPX.setFocusable(false);
        tblDSCTPX.setIntercellSpacing(new Dimension(0, 0));
        tblDSCTPX.setRowHeight(25);
        tblDSCTPX.setFillsViewportHeight(true);
        tblDSCTPX.getTableHeader().setOpaque(false);
        tblDSCTPX.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSCTPX.getTableHeader().setForeground(Color.WHITE);
        tblDSCTPX.setSelectionBackground(new Color(188, 206, 248));
        tblDSCTPX.setSelectionForeground(Color.BLACK);
        tblDSCTPX.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSCTPX.getTableHeader().setReorderingAllowed(false);
        tblDSCTPX.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
    }

    public void showAllDSPX(ArrayList<PhieuXuatDTO> dspx){
        dtmPhieuXuat.setRowCount(0);
        for(int i=0;i<dspx.size();i++){
            dtmPhieuXuat.addRow(new String[]{
                dspx.get(i).getMaPX(),
                dspx.get(i).getMaNV(),
                dspx.get(i).getNgayLap(),
                String.valueOf(dspx.get(i).getTongTien())
            });
        }
    }
    
    public void showAllDSCTPX(ArrayList<CTPhieuXuatDTO> dsctpx){
        dtmCTPhieuXuat.setRowCount(0);
        for(int i=0;i<dsctpx.size();i++){
            dtmCTPhieuXuat.addRow(new String[]{
                dsctpx.get(i).getMaPX(),
                dsctpx.get(i).getMaSP(),
                dsctpx.get(i).getTenSP(),
                String.valueOf(dsctpx.get(i).getDonGia()),
                String.valueOf(dsctpx.get(i).getSoLuong()),
                String.valueOf(dsctpx.get(i).getThanhTien()),
            });
        }
    }
    public void loadDataDSPX(){
        pxBUS.docDanhSach();
        ArrayList<PhieuXuatDTO> dspx = pxBUS.getListPhieuXuat();
        showAllDSPX(dspx);
    }
    
    public void loadDataDSCTPXtheoMaPX(String MaPX){
        if (ctpxBUS.getListCTPX() == null){
            ctpxBUS.listCTPX();
        }
        ArrayList<CTPhieuXuatDTO> dsctpx = ctpxBUS.getListCTPXtheoMaPX(MaPX);
        dtmCTPhieuXuat.setRowCount(0);
        showAllDSCTPX(dsctpx);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pnRoot = new javax.swing.JPanel();
        pnDSSP = new javax.swing.JPanel();
        lblDSSP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSPX = new javax.swing.JTable();
        lblMaPN = new javax.swing.JLabel();
        txtMaPX = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        lblHo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgayLap = new com.toedter.calendar.JDateChooser();
        pnGioHang = new javax.swing.JPanel();
        lblGioHang = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDSCTPX = new javax.swing.JTable();
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
        lblDSSP.setText("Danh sách phiếu xuất");
        pnDSSP.add(lblDSSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 30));

        tblDSPX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        tblDSPX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSPXMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSPX);
        if (tblDSPX.getColumnModel().getColumnCount() > 0) {
            tblDSPX.getColumnModel().getColumn(0).setResizable(false);
            tblDSPX.getColumnModel().getColumn(1).setResizable(false);
            tblDSPX.getColumnModel().getColumn(2).setResizable(false);
            tblDSPX.getColumnModel().getColumn(3).setResizable(false);
        }

        pnDSSP.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 480, 530));

        lblMaPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPN.setText("Mã PN");
        pnDSSP.add(lblMaPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

        txtMaPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPXActionPerformed(evt);
            }
        });
        pnDSSP.add(txtMaPX, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, 160, 24));
        pnDSSP.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 620, 160, 24));

        lblHo.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblHo.setText("Mã NV");
        pnDSSP.add(lblHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, -1, -1));

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Ngày lập");
        pnDSSP.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, -1, -1));
        pnDSSP.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 620, 160, 24));

        jLabel5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel5.setText("Tổng tiền");
        pnDSSP.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 620, -1, -1));

        txtNgayLap.setDateFormatString("dd/MM/yyyy");
        pnDSSP.add(txtNgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 580, 160, 24));

        pnGioHang.setBackground(new java.awt.Color(250, 247, 240));

        lblGioHang.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblGioHang.setForeground(new java.awt.Color(255, 51, 51));
        lblGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioHang.setText("Chi tiết phiếu xuất");

        tblDSCTPX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PX", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSCTPX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSCTPXMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDSCTPX);
        if (tblDSCTPX.getColumnModel().getColumnCount() > 0) {
            tblDSCTPX.getColumnModel().getColumn(0).setResizable(false);
            tblDSCTPX.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblDSCTPX.getColumnModel().getColumn(1).setResizable(false);
            tblDSCTPX.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblDSCTPX.getColumnModel().getColumn(2).setResizable(false);
            tblDSCTPX.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblDSCTPX.getColumnModel().getColumn(3).setResizable(false);
            tblDSCTPX.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblDSCTPX.getColumnModel().getColumn(4).setResizable(false);
            tblDSCTPX.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblDSCTPX.getColumnModel().getColumn(5).setResizable(false);
            tblDSCTPX.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        lblMaSP1.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP1.setText("Mã PX");

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
                .addContainerGap()
                .addComponent(lblMaSP1)
                .addGap(32, 32, 32)
                .addComponent(txtMaCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaSP5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMaSP6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMaSP7, javax.swing.GroupLayout.Alignment.TRAILING))
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
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(lblGioHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tblDSPXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSPXMouseClicked
        int k = tblDSPX.getSelectedRow();
        txtMaPX.setText(tblDSPX.getModel().getValueAt(k,0).toString());
        String MaPX = txtMaPX.getText();
        loadDataDSCTPXtheoMaPX(MaPX);
    }//GEN-LAST:event_tblDSPXMouseClicked

    private void txtMaPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPXActionPerformed

    }//GEN-LAST:event_txtMaPXActionPerformed

    private void tblDSCTPXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSCTPXMouseClicked

    }//GEN-LAST:event_tblDSCTPXMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
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
    private javax.swing.JTable tblDSCTPX;
    private javax.swing.JTable tblDSPX;
    private javax.swing.JTextField txtMaCTPN;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPX;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private javax.swing.JTextField txtThanhToan;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
