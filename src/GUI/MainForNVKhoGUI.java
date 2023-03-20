/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.model.ChangeScreenNVKho;

import GUI.model.DanhMuc;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author wizardsc
 */
public class MainForNVKhoGUI extends javax.swing.JFrame {

    
    public MainForNVKhoGUI() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        ImageIcon logo = new ImageIcon("./src/image/lblIconShop32x32.png");
        setIconImage(logo.getImage());
        
        ChangeScreenNVKho controller = new ChangeScreenNVKho(pnView);
        ArrayList<DanhMuc> list = new ArrayList<>();
        list.add(new DanhMuc("NhapHang", pnNhapHang, lblNhapHang));
        list.add(new DanhMuc("CTPhieuNhap",pnPhieuNhap,lblPhieuNhap));
        list.add(new DanhMuc("Kho", pnKho, lblKho));
        list.add(new DanhMuc("XuatHang", pnXuatHang, lblXuatHang));
        list.add(new DanhMuc("CTPhieuXuat",pnPhieuXuat,lblPhieuXuat));
        controller.setEvent(list);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRoot = new javax.swing.JPanel();
        pnHeader = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        lblThongTin = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        cbxPhanQuyen = new javax.swing.JComboBox<>();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        pnView = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        lblIconHotel = new javax.swing.JLabel();
        pnNhapHang = new javax.swing.JPanel();
        lblNhapHang = new javax.swing.JLabel();
        pnPhieuNhap = new javax.swing.JPanel();
        lblPhieuNhap = new javax.swing.JLabel();
        pnNhanVien = new javax.swing.JPanel();
        lblNhanVien = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnDangXuat = new javax.swing.JPanel();
        lblDangXuat = new javax.swing.JLabel();
        pnKho = new javax.swing.JPanel();
        lblKho = new javax.swing.JLabel();
        pnXuatHang = new javax.swing.JPanel();
        lblXuatHang = new javax.swing.JLabel();
        pnPhieuXuat = new javax.swing.JPanel();
        lblPhieuXuat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnRoot.setBackground(new java.awt.Color(255, 255, 255));
        pnRoot.setPreferredSize(new java.awt.Dimension(1300, 713));

        pnHeader.setBackground(new java.awt.Color(152, 168, 248));
        pnHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        pnHeader.setToolTipText("");
        pnHeader.setPreferredSize(new java.awt.Dimension(102, 40));

        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/minus.png"))); // NOI18N
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });

        lblThongTin.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        lblThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongTin.setText("BẠN ĐANG ĐĂNG NHẬP VỚI TƯ CÁCH");

        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblHome.png"))); // NOI18N

        cbxPhanQuyen.setBackground(new java.awt.Color(250, 247, 240));
        cbxPhanQuyen.setEditable(true);
        cbxPhanQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NV Kho" }));
        cbxPhanQuyen.setEnabled(false);

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThongTin)
                .addGap(14, 14, 14)
                .addComponent(cbxPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnView.setBackground(new java.awt.Color(250, 247, 240));
        pnView.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        pnView.setPreferredSize(new java.awt.Dimension(1089, 730));

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel3");

        javax.swing.GroupLayout pnViewLayout = new javax.swing.GroupLayout(pnView);
        pnView.setLayout(pnViewLayout);
        pnViewLayout.setHorizontalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnViewLayout.createSequentialGroup()
                .addGap(0, 1061, Short.MAX_VALUE)
                .addComponent(jLabel4))
            .addGroup(pnViewLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnViewLayout.setVerticalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 647, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        pnMenu.setBackground(new java.awt.Color(188, 206, 248));
        pnMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 0, new java.awt.Color(0, 0, 0)));
        pnMenu.setPreferredSize(new java.awt.Dimension(211, 650));

        lblIconHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconHotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/toy-shop.png"))); // NOI18N

        pnNhapHang.setBackground(new java.awt.Color(188, 206, 248));
        pnNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        pnNhapHang.setPreferredSize(new java.awt.Dimension(300, 43));

        lblNhapHang.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblNhapHang.png"))); // NOI18N
        lblNhapHang.setText("  Nhập hàng");

        javax.swing.GroupLayout pnNhapHangLayout = new javax.swing.GroupLayout(pnNhapHang);
        pnNhapHang.setLayout(pnNhapHangLayout);
        pnNhapHangLayout.setHorizontalGroup(
            pnNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhapHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnNhapHangLayout.setVerticalGroup(
            pnNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnPhieuNhap.setBackground(new java.awt.Color(188, 206, 248));
        pnPhieuNhap.setForeground(new java.awt.Color(255, 255, 255));
        pnPhieuNhap.setPreferredSize(new java.awt.Dimension(300, 43));

        lblPhieuNhap.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblBill.png"))); // NOI18N
        lblPhieuNhap.setText("  Phiếu nhập");

        javax.swing.GroupLayout pnPhieuNhapLayout = new javax.swing.GroupLayout(pnPhieuNhap);
        pnPhieuNhap.setLayout(pnPhieuNhapLayout);
        pnPhieuNhapLayout.setHorizontalGroup(
            pnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhieuNhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnPhieuNhapLayout.setVerticalGroup(
            pnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnNhanVien.setBackground(new java.awt.Color(188, 206, 248));
        pnNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        pnNhanVien.setPreferredSize(new java.awt.Dimension(300, 43));

        lblNhanVien.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblNhanVien.png"))); // NOI18N
        lblNhanVien.setText("  Nhân viên");

        jLabel1.setFont(new java.awt.Font("Baloo 2 SemiBold", 0, 14)); // NOI18N
        jLabel1.setText("Hello");

        jLabel2.setFont(new java.awt.Font("Baloo 2 SemiBold", 0, 14)); // NOI18N
        jLabel2.setText("Username");

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnDangXuat.setBackground(new java.awt.Color(188, 206, 248));
        pnDangXuat.setForeground(new java.awt.Color(255, 255, 255));

        lblDangXuat.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblDangXuat.setText("  Đăng xuất");

        javax.swing.GroupLayout pnDangXuatLayout = new javax.swing.GroupLayout(pnDangXuat);
        pnDangXuat.setLayout(pnDangXuatLayout);
        pnDangXuatLayout.setHorizontalGroup(
            pnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDangXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnDangXuatLayout.setVerticalGroup(
            pnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDangXuatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnKho.setBackground(new java.awt.Color(188, 206, 248));
        pnKho.setForeground(new java.awt.Color(255, 255, 255));

        lblKho.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblKhoHang.png"))); // NOI18N
        lblKho.setText("  Kho");

        javax.swing.GroupLayout pnKhoLayout = new javax.swing.GroupLayout(pnKho);
        pnKho.setLayout(pnKhoLayout);
        pnKhoLayout.setHorizontalGroup(
            pnKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblKho, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnKhoLayout.setVerticalGroup(
            pnKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblKho, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnXuatHang.setBackground(new java.awt.Color(188, 206, 248));
        pnXuatHang.setForeground(new java.awt.Color(255, 255, 255));
        pnXuatHang.setPreferredSize(new java.awt.Dimension(300, 43));

        lblXuatHang.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblXuatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblXuatHang.png"))); // NOI18N
        lblXuatHang.setText("  Xuất hàng");

        javax.swing.GroupLayout pnXuatHangLayout = new javax.swing.GroupLayout(pnXuatHang);
        pnXuatHang.setLayout(pnXuatHangLayout);
        pnXuatHangLayout.setHorizontalGroup(
            pnXuatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnXuatHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblXuatHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnXuatHangLayout.setVerticalGroup(
            pnXuatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblXuatHang, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnPhieuXuat.setBackground(new java.awt.Color(188, 206, 248));
        pnPhieuXuat.setForeground(new java.awt.Color(255, 255, 255));
        pnPhieuXuat.setPreferredSize(new java.awt.Dimension(300, 43));

        lblPhieuXuat.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblPhieuXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblBill.png"))); // NOI18N
        lblPhieuXuat.setText("  Phiếu xuất");

        javax.swing.GroupLayout pnPhieuXuatLayout = new javax.swing.GroupLayout(pnPhieuXuat);
        pnPhieuXuat.setLayout(pnPhieuXuatLayout);
        pnPhieuXuatLayout.setHorizontalGroup(
            pnPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhieuXuatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnPhieuXuatLayout.setVerticalGroup(
            pnPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPhieuXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addComponent(pnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnNhapHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(pnKho, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnXuatHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIconHotel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnPhieuNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnPhieuXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnXuatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE))
            .addComponent(pnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, Short.MAX_VALUE)
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRootLayout.createSequentialGroup()
                .addComponent(pnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // System.exit(0);
        //       setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //        int result=JOptionPane.showConfirmDialog(null,"Do yout want to exit?","Congfig",JOptionPane.YES_NO_OPTION);
        //        if(result==0){
            System.exit(0);
            //        }
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JComboBox<String> cbxPhanQuyen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblIconHotel;
    private javax.swing.JLabel lblKho;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblNhapHang;
    private javax.swing.JLabel lblPhieuNhap;
    private javax.swing.JLabel lblPhieuXuat;
    private javax.swing.JLabel lblThongTin;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblXuatHang;
    private javax.swing.JPanel pnDangXuat;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnKho;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JPanel pnNhapHang;
    private javax.swing.JPanel pnPhieuNhap;
    private javax.swing.JPanel pnPhieuXuat;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JPanel pnView;
    private javax.swing.JPanel pnXuatHang;
    // End of variables declaration//GEN-END:variables
}
