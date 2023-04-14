/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.KhuyenMaiBUS;
import DTO.KhuyenMaiDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wizardsc
 */
public class RCKhuyenMaiGUI extends javax.swing.JDialog {
    DefaultTableModel dtmKhuyenMai;
    private KhuyenMaiBUS kmBUS = new KhuyenMaiBUS();
    private double TongTien; //tham số TongTien ở hàm tạo
    public RCKhuyenMaiGUI(){
        this.setUndecorated(true);
        initComponents();
        this.setModal(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        init();
        
        
        dtmKhuyenMai = (DefaultTableModel) tblDSKM.getModel();
        loadDataDSSP();
    }
    //Hàm tạo có sẵn tham số TongTien
    public RCKhuyenMaiGUI(double TongTien){
        this();
        this.TongTien= TongTien;
    }
    public void init() {
        //set giao diện cho Table
        //DSKM
        tblDSKM.setFocusable(false);
        tblDSKM.setIntercellSpacing(new Dimension(0, 0));
        tblDSKM.setRowHeight(25);
        tblDSKM.setFillsViewportHeight(true);
        tblDSKM.getTableHeader().setOpaque(false);
        tblDSKM.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSKM.getTableHeader().setForeground(Color.WHITE);
        tblDSKM.setSelectionBackground(new Color(188, 206, 248));
        tblDSKM.setSelectionForeground(Color.BLACK);
        tblDSKM.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSKM.getTableHeader().setReorderingAllowed(false);
        tblDSKM.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
    }
    
    public void showAllDSKM(ArrayList<KhuyenMaiDTO> dskm){
        dtmKhuyenMai.setRowCount(0);
        DecimalFormat dcf = new DecimalFormat(">#######");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
       
        for(int i=0;i<dskm.size();i++){
            if(dskm.get(i).getNgayBatDau().before(now) && dskm.get(i).getNgayKetThuc().after(now)){
                dtmKhuyenMai.addRow(new String[]{
                    dskm.get(i).getMaKM(),
                    dskm.get(i).getTenKM(),
                    String.valueOf(dskm.get(i).getPhanTramKM()),
                    String.valueOf(dcf.format(dskm.get(i).getDieuKien())),
                    sdf.format(dskm.get(i).getNgayBatDau()),
                    sdf.format(dskm.get(i).getNgayKetThuc()),
                    "Có hiệu lực"
                });
            } else {
                dtmKhuyenMai.addRow(new String[]{
                    dskm.get(i).getMaKM(),
                    dskm.get(i).getTenKM(),
                    String.valueOf(dskm.get(i).getPhanTramKM()),
                    String.valueOf(dcf.format(dskm.get(i).getDieuKien())),
                    sdf.format(dskm.get(i).getNgayBatDau()),
                    sdf.format(dskm.get(i).getNgayKetThuc()),
                    "Không hiệu lực"
                });
            }
        }
    }
    
    public void loadDataDSSP() {
        kmBUS.docDanhSach();
        ArrayList<KhuyenMaiDTO> dskm = kmBUS.getListKhuyenMai();
        showAllDSKM(dskm);
    }
    
    public String getMaKM(){
        return txtMaKM.getText();
    }
    
    public String getPhanTramKM(){
        return txtPhanTramKM.getText();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnHeader2 = new javax.swing.JPanel();
        btnClose1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnChonLoai = new javax.swing.JLabel();
        btnBoChon = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPhanTramKM = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSKM = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtDieuKien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 247, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        pnHeader2.setBackground(new java.awt.Color(152, 168, 248));
        pnHeader2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 0, 0)));
        pnHeader2.setPreferredSize(new java.awt.Dimension(102, 40));
        pnHeader2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClose1MouseClicked(evt);
            }
        });
        pnHeader2.add(btnClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 49, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblKhachHang.png"))); // NOI18N
        pnHeader2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 52, -1));

        jLabel10.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        jLabel10.setText("QUẢN LÝ KHUYẾN MÃI");
        pnHeader2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 0, -1, 40));

        jPanel7.setBackground(new java.awt.Color(250, 247, 240));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỌN KHUYẾN MÃI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChonLoai.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonLoai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChonLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/check-mark.png"))); // NOI18N
        btnChonLoai.setText("Chọn KM");
        btnChonLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonLoaiMouseClicked(evt);
            }
        });
        jPanel7.add(btnChonLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 130, -1));

        btnBoChon.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnBoChon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBoChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel.png"))); // NOI18N
        btnBoChon.setText("Bỏ chọn");
        btnBoChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBoChonMouseClicked(evt);
            }
        });
        jPanel7.add(btnBoChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 122, -1));
        jPanel7.add(txtMaKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 148, 27));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Mã KM");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 60, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Phần trăm KM");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 100, 20));
        jPanel7.add(txtPhanTramKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 148, 27));

        tblDSKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", null, null, null, null, null, null}
            },
            new String [] {
                "Mã KM", "Tên KM", "Phần trăm KM", "Điều Kiện", "Ngày BD", "Ngày KT", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSKMMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSKM);
        if (tblDSKM.getColumnModel().getColumnCount() > 0) {
            tblDSKM.getColumnModel().getColumn(0).setResizable(false);
            tblDSKM.getColumnModel().getColumn(1).setResizable(false);
            tblDSKM.getColumnModel().getColumn(2).setResizable(false);
            tblDSKM.getColumnModel().getColumn(3).setResizable(false);
            tblDSKM.getColumnModel().getColumn(4).setResizable(false);
            tblDSKM.getColumnModel().getColumn(5).setResizable(false);
            tblDSKM.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, 710, 280));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Điều kiện");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 100, 20));
        jPanel7.add(txtDieuKien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 148, 27));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pnHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClose1MouseClicked
        dispose();
    }//GEN-LAST:event_btnClose1MouseClicked

    private void tblDSKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSKMMouseClicked
        int k = tblDSKM.getSelectedRow();
        txtMaKM.setText(tblDSKM.getValueAt(k,0).toString());
        txtPhanTramKM.setText(tblDSKM.getValueAt(k,2).toString());
        String dk = tblDSKM.getModel().getValueAt(k, 3).toString();
        dk = dk.replace(">", "");
        txtDieuKien.setText(dk);
        
        
        txtMaKM.setEnabled(false);
        txtPhanTramKM.setEnabled(false);
        txtDieuKien.setEnabled(false);
    }//GEN-LAST:event_tblDSKMMouseClicked

    private void btnBoChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoChonMouseClicked
        txtMaKM.setText("");
        dispose();
    }//GEN-LAST:event_btnBoChonMouseClicked

    private void btnChonLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonLoaiMouseClicked
        //Kiểm tra điều kiện tham gia khuyến mãi
        //Nếu tổng tiền của hóa đơn nhỏ hơn điều kiện khuyến mãi --> không xài được
        //Nếu trạng thái "không hiệu lực" --> không xài được
        int k = tblDSKM.getSelectedRow();
        double DieuKien = Double.parseDouble(txtDieuKien.getText());

            if (tblDSKM.getModel().getValueAt(k, 6).equals("Không hiệu lực")) {
                JOptionPane.showMessageDialog(null, "Khuyến mãi không có hiệu lực!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
                txtMaKM.setText("");
                return;
            }
            else if (TongTien < DieuKien) {
                JOptionPane.showMessageDialog(null, "Không đủ điều kiện tham gia khuyến mãi này!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
                txtMaKM.setText("");
                return;
            } else {
                dispose();
            }
    }//GEN-LAST:event_btnChonLoaiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBoChon;
    private javax.swing.JLabel btnChonLoai;
    private javax.swing.JLabel btnClose1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnHeader2;
    private javax.swing.JTable tblDSKM;
    private javax.swing.JTextField txtDieuKien;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtPhanTramKM;
    // End of variables declaration//GEN-END:variables
}
