/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.NhanVienDTO;
import GUI.model.ChangeScreenQuanLy;
import GUI.model.DanhMuc;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
//import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Administrator
 */
public class MainForQuanLyGUI extends javax.swing.JFrame {

    TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    NhanVienBUS nvBUS = new NhanVienBUS();
    private String MaNV;
    private String TenNV;

    public MainForQuanLyGUI(String MaNV) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);

        ImageIcon logo = new ImageIcon("./src/image/iconshop.png");
        setIconImage(logo.getImage());

//        setTime();
        ChangeScreenQuanLy controller = new ChangeScreenQuanLy(pnView);
//        controller.setView(pnNhanVien,lblNhanVien);
//        
        ArrayList<DanhMuc> list = new ArrayList<>();
        list.add(new DanhMuc("NhanVien", pnNhanVien, lblNhanVien));

        list.add(new DanhMuc("NhaCungCap", pnNhaCungCap, lblNhaCungCap));
        list.add(new DanhMuc("TaiKhoan", pnTaiKhoan, lblTaiKhoan));

        list.add(new DanhMuc("ChucVu", pnChucVu, lblChucVu));
        list.add(new DanhMuc("SanPham", pnSanPham, lblSanPham));
        list.add(new DanhMuc("KhuyenMai", pnKhuyenMai, lblKhuyenMai));
        list.add(new DanhMuc("NhanVien", pnNhanVien, lblNhanVien));
        list.add(new DanhMuc("ThongKe", pnThongKe, lblThongKe));
        list.add(new DanhMuc("SaoLuu", pnSaoLuu, lblSaoLuu));
        controller.setEvent(list);

        nvBUS.docDanhSach();
        ArrayList<NhanVienDTO> dsnv = nvBUS.getListNhanVien();
        for (NhanVienDTO nv : dsnv) {
            if (nv.getMaNV().equals(MaNV)) {
                String Ho = nv.getHo();
                String Ten = nv.getTen();
                System.out.println(Ho);
                System.out.println(Ten);
                TenNV = Ho + " " + Ten;
            }

        }
        System.out.println(TenNV);

        lblTenNV.setText(TenNV);
        lblMaNV.setText(MaNV);
        setTime();
        ChayChuoi();
    }

    public void fadeIn(JComponent comp) {
        Timer timer = new Timer(2, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float alpha = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 0.05f;
                if (alpha >= 1f) {
                    alpha = 1f;
                    timer.stop();
                }
                comp.setOpaque(true);
                comp.setBackground(new Color(152,168,248, (int) (255 * alpha)));
            }
        });
        timer.start();
    }

    public void fadeOut(JComponent comp) {
        Timer timer = new Timer(2, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float alpha = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 0.05f;
                if (alpha <= 0f) {
                    alpha = 0f;
                    timer.stop();
                }
                comp.setOpaque(true);
                comp.setBackground(new Color(152,168,248, (int) (255 * alpha)));
            }

            
        });
        timer.start();
    }

    public void ChayChuoi() {
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            fadeOut(lblThongTin);
            Timer timer2 = new Timer(300, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lblThongTin.setLocation(-lblThongTin.getWidth(), lblThongTin.getY());
                    fadeIn(lblThongTin);
                }
            });
            timer2.setRepeats(false);
            timer2.start();
        }
    });
    timer.setRepeats(true);
    timer.start();
}

    /* Hàm set thời gian ở thanh Header */
    public void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainForQuanLyGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat timeformat = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat dateformat = new SimpleDateFormat("EEEE,dd-MM-yyyy");
                    String time = timeformat.format(date);

                    lblTime.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    lblDate.setText(dateformat.format(date));

                }
            }

        }).start();
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
        lblHome = new javax.swing.JLabel();
        cbxPhanQuyen = new javax.swing.JComboBox<>();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblThongTin = new javax.swing.JLabel();
        pnView = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        lblIconHotel = new javax.swing.JLabel();
        pnTaiKhoan = new javax.swing.JPanel();
        lblTaiKhoan = new javax.swing.JLabel();
        pnNhaCungCap = new javax.swing.JPanel();
        lblNhaCungCap = new javax.swing.JLabel();
        pnChucVu = new javax.swing.JPanel();
        lblChucVu = new javax.swing.JLabel();
        pnSanPham = new javax.swing.JPanel();
        lblSanPham = new javax.swing.JLabel();
        pnKhuyenMai = new javax.swing.JPanel();
        lblKhuyenMai = new javax.swing.JLabel();
        pnNhanVien = new javax.swing.JPanel();
        lblNhanVien = new javax.swing.JLabel();
        pnThongKe = new javax.swing.JPanel();
        lblThongKe = new javax.swing.JLabel();
        pnSaoLuu = new javax.swing.JPanel();
        lblSaoLuu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();

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

        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblHome.png"))); // NOI18N

        cbxPhanQuyen.setBackground(new java.awt.Color(250, 247, 240));
        cbxPhanQuyen.setEditable(true);
        cbxPhanQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý" }));
        cbxPhanQuyen.setEnabled(false);

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblThongTin.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        lblThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongTin.setText("BẠN ĐANG ĐĂNG NHẬP VỚI TƯ CÁCH");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(274, 274, 274)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxPhanQuyen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMinimize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnView.setBackground(new java.awt.Color(250, 247, 240));
        pnView.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        pnView.setPreferredSize(new java.awt.Dimension(1089, 730));

        javax.swing.GroupLayout pnViewLayout = new javax.swing.GroupLayout(pnView);
        pnView.setLayout(pnViewLayout);
        pnViewLayout.setHorizontalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
        );
        pnViewLayout.setVerticalGroup(
            pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );

        pnMenu.setBackground(new java.awt.Color(188, 206, 248));
        pnMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 0, new java.awt.Color(0, 0, 0)));
        pnMenu.setPreferredSize(new java.awt.Dimension(211, 650));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconHotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/storage-box.png"))); // NOI18N
        pnMenu.add(lblIconHotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 191, 150));

        pnTaiKhoan.setBackground(new java.awt.Color(188, 206, 248));
        pnTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        pnTaiKhoan.setPreferredSize(new java.awt.Dimension(300, 43));

        lblTaiKhoan.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblAccount.png"))); // NOI18N
        lblTaiKhoan.setText("  Tài khoản");

        javax.swing.GroupLayout pnTaiKhoanLayout = new javax.swing.GroupLayout(pnTaiKhoan);
        pnTaiKhoan.setLayout(pnTaiKhoanLayout);
        pnTaiKhoanLayout.setHorizontalGroup(
            pnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTaiKhoan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTaiKhoanLayout.setVerticalGroup(
            pnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnMenu.add(pnTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 213, 196, -1));

        pnNhaCungCap.setBackground(new java.awt.Color(188, 206, 248));
        pnNhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        pnNhaCungCap.setPreferredSize(new java.awt.Dimension(300, 43));

        lblNhaCungCap.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblNhaCungCap.png"))); // NOI18N
        lblNhaCungCap.setText("  Nhà cung cấp");

        javax.swing.GroupLayout pnNhaCungCapLayout = new javax.swing.GroupLayout(pnNhaCungCap);
        pnNhaCungCap.setLayout(pnNhaCungCapLayout);
        pnNhaCungCapLayout.setHorizontalGroup(
            pnNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        pnNhaCungCapLayout.setVerticalGroup(
            pnNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnMenu.add(pnNhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 493, 191, -1));

        pnChucVu.setBackground(new java.awt.Color(188, 206, 248));
        pnChucVu.setForeground(new java.awt.Color(255, 255, 255));
        pnChucVu.setPreferredSize(new java.awt.Dimension(300, 43));

        lblChucVu.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblChucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblChucVu.png"))); // NOI18N
        lblChucVu.setText("  Chức vụ");

        javax.swing.GroupLayout pnChucVuLayout = new javax.swing.GroupLayout(pnChucVu);
        pnChucVu.setLayout(pnChucVuLayout);
        pnChucVuLayout.setHorizontalGroup(
            pnChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChucVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnChucVuLayout.setVerticalGroup(
            pnChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnMenu.add(pnChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 381, 196, -1));

        pnSanPham.setBackground(new java.awt.Color(188, 206, 248));
        pnSanPham.setForeground(new java.awt.Color(255, 255, 255));

        lblSanPham.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblSanPham.png"))); // NOI18N
        lblSanPham.setText("  Sản phẩm");

        javax.swing.GroupLayout pnSanPhamLayout = new javax.swing.GroupLayout(pnSanPham);
        pnSanPham.setLayout(pnSanPhamLayout);
        pnSanPhamLayout.setHorizontalGroup(
            pnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSanPhamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnSanPhamLayout.setVerticalGroup(
            pnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSanPhamLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnMenu.add(pnSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 325, -1, -1));

        pnKhuyenMai.setBackground(new java.awt.Color(188, 206, 248));
        pnKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));

        lblKhuyenMai.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblKhuyenMai.png"))); // NOI18N
        lblKhuyenMai.setText("  Khuyến mãi");

        javax.swing.GroupLayout pnKhuyenMaiLayout = new javax.swing.GroupLayout(pnKhuyenMai);
        pnKhuyenMai.setLayout(pnKhuyenMaiLayout);
        pnKhuyenMaiLayout.setHorizontalGroup(
            pnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnKhuyenMaiLayout.setVerticalGroup(
            pnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhuyenMaiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnMenu.add(pnKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 269, -1, -1));

        pnNhanVien.setBackground(new java.awt.Color(188, 206, 248));
        pnNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        pnNhanVien.setPreferredSize(new java.awt.Dimension(300, 43));

        lblNhanVien.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblNhanVien.png"))); // NOI18N
        lblNhanVien.setText("  Nhân viên");

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnMenu.add(pnNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 437, 191, -1));

        pnThongKe.setBackground(new java.awt.Color(188, 206, 248));
        pnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        pnThongKe.setPreferredSize(new java.awt.Dimension(300, 43));

        lblThongKe.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblThongKe.png"))); // NOI18N
        lblThongKe.setText("  Thống kê");

        javax.swing.GroupLayout pnThongKeLayout = new javax.swing.GroupLayout(pnThongKe);
        pnThongKe.setLayout(pnThongKeLayout);
        pnThongKeLayout.setHorizontalGroup(
            pnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnThongKeLayout.setVerticalGroup(
            pnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        pnMenu.add(pnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 549, 191, 45));

        pnSaoLuu.setBackground(new java.awt.Color(188, 206, 248));
        pnSaoLuu.setForeground(new java.awt.Color(255, 255, 255));
        pnSaoLuu.setPreferredSize(new java.awt.Dimension(300, 43));

        lblSaoLuu.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 20)); // NOI18N
        lblSaoLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backup.png"))); // NOI18N
        lblSaoLuu.setText("  Sao lưu");

        javax.swing.GroupLayout pnSaoLuuLayout = new javax.swing.GroupLayout(pnSaoLuu);
        pnSaoLuu.setLayout(pnSaoLuuLayout);
        pnSaoLuuLayout.setHorizontalGroup(
            pnSaoLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSaoLuuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSaoLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
        );
        pnSaoLuuLayout.setVerticalGroup(
            pnSaoLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSaoLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        pnMenu.add(pnSaoLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 607, 191, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/manager.png"))); // NOI18N
        pnMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblTenNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTenNV.setText("Tên nhân viên");
        pnMenu.add(lblTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 20));

        lblMaNV.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMaNV.setText("Mã NV");
        pnMenu.add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JComboBox<String> cbxPhanQuyen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblIconHotel;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblNhaCungCap;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lblSaoLuu;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JLabel lblThongTin;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel pnChucVu;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnKhuyenMai;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnNhaCungCap;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JPanel pnSanPham;
    private javax.swing.JPanel pnSaoLuu;
    private javax.swing.JPanel pnTaiKhoan;
    private javax.swing.JPanel pnThongKe;
    private javax.swing.JPanel pnView;
    // End of variables declaration//GEN-END:variables
}
