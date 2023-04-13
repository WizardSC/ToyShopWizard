/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wizardsc
 */
public class RCKhachHangGUI extends javax.swing.JDialog {

    DefaultTableModel dtmKhachHang;
    private KhachHangBUS khBUS = new KhachHangBUS();
    private ArrayList<KhachHangDTO> dskh = new ArrayList<>();

    public RCKhachHangGUI() {
        setUndecorated(true);
        initComponents();
        this.setModal(true);
        this.setResizable(false);
        setLocationRelativeTo(null);
        dtmKhachHang = (DefaultTableModel) tblDSKH.getModel();
        
        init();
        loadData();
        
        
    }

    public void init() {
        tblDSKH.setFocusable(false);
        tblDSKH.setIntercellSpacing(new Dimension(0, 0));
        tblDSKH.setRowHeight(25);
        tblDSKH.setFillsViewportHeight(true);
        tblDSKH.getTableHeader().setOpaque(false);
        tblDSKH.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSKH.getTableHeader().setForeground(Color.WHITE);
        tblDSKH.setSelectionBackground(new Color(188, 206, 248));
        tblDSKH.setSelectionForeground(Color.BLACK);
        tblDSKH.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSKH.getTableHeader().setReorderingAllowed(false);
        tblDSKH.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));

        tblDSKH.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                int row = tblDSKH.rowAtPoint(evt.getPoint());
                int col = tblDSKH.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {

                    tblDSKH.setRowSelectionInterval(row, row);
                    tblDSKH.setColumnSelectionInterval(0, tblDSKH.getColumnCount() - 1);
                    tblDSKH.setSelectionBackground(new Color(188, 206, 248)); // đổi màu nền của ô khi hover
                }
            }
        });
    }
    
    public void showAllDSKH(ArrayList<KhachHangDTO> dskh){
        dtmKhachHang.setRowCount(0);
        for(int i=0;i<dskh.size();i++){
            dtmKhachHang.addRow(new Object[]{
                dskh.get(i).getMaKH(),
                dskh.get(i).getHo(),
                dskh.get(i).getTen(),
                dskh.get(i).getNgaySinh(),
                dskh.get(i).getGioiTinh(),
            });
        }
    }
    
    public void loadData(){
        khBUS.docDanhSach();
        ArrayList<KhachHangDTO> dskh = khBUS.getListKhachHang();
        showAllDSKH(dskh);
    }
    
    //Hàm lấy mã KH để dùng cho việc khác
    public String getMaKH(){
        return txtMaKH.getText();
    }

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
        txtMaKH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSKH = new javax.swing.JTable();

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
        pnHeader2.add(btnClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 0, 49, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblKhachHang.png"))); // NOI18N
        pnHeader2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 52, -1));

        jLabel10.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        jLabel10.setText("QUẢN LÝ KHÁCH HÀNG");
        pnHeader2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 0, -1, 40));

        jPanel7.setBackground(new java.awt.Color(250, 247, 240));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỌN KHÁCH HÀNG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChonLoai.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonLoai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChonLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/check-mark.png"))); // NOI18N
        btnChonLoai.setText("Chọn");
        btnChonLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonLoaiMouseClicked(evt);
            }
        });
        jPanel7.add(btnChonLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 130, -1));

        btnBoChon.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnBoChon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBoChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel.png"))); // NOI18N
        btnBoChon.setText("Bỏ chọn");
        btnBoChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBoChonMouseClicked(evt);
            }
        });
        jPanel7.add(btnBoChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 122, -1));
        jPanel7.add(txtMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 148, 27));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Mã KH");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 60, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Họ");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 60, -1));
        jPanel7.add(txtHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 148, 27));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Ngày sinh");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Tên");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 60, -1));
        jPanel7.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 148, 27));
        jPanel7.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 148, 27));
        jPanel7.add(txtGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 148, 27));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Giới tính");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 62, -1));

        tblDSKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ", "Tên", "Ngày sinh", "Giới tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSKHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSKH);

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, 630, 280));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSKHMouseClicked
        int k = tblDSKH.getSelectedRow();
        txtMaKH.setText(tblDSKH.getModel().getValueAt(k, 0).toString());
        txtHo.setText(tblDSKH.getModel().getValueAt(k, 1).toString());
        txtTen.setText(tblDSKH.getModel().getValueAt(k, 2).toString());
        txtNgaySinh.setText(tblDSKH.getModel().getValueAt(k, 3).toString());
        txtGioiTinh.setText(tblDSKH.getModel().getValueAt(k, 4).toString());
    }//GEN-LAST:event_tblDSKHMouseClicked

    private void btnClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClose1MouseClicked
        dispose();
    }//GEN-LAST:event_btnClose1MouseClicked

    private void btnChonLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonLoaiMouseClicked
        dispose();
    }//GEN-LAST:event_btnChonLoaiMouseClicked

    private void btnBoChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoChonMouseClicked
        dispose();
    }//GEN-LAST:event_btnBoChonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBoChon;
    private javax.swing.JLabel btnChonLoai;
    private javax.swing.JLabel btnClose1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnHeader2;
    private javax.swing.JTable tblDSKH;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
