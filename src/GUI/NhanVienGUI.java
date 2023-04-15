/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChucVuBUS;
import BUS.NhanVienBUS;
import DTO.ChucVuDTO;
import DTO.NhanVienDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Administrator
 */
public class NhanVienGUI extends javax.swing.JPanel {

    private ChucVuBUS cvBUS = new ChucVuBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
    DefaultTableModel dtmNhanVien;
    DefaultTableModel dtmChucVu;

    private BufferedImage i = null;
    String imgName = "null";

    String TuKhoaTimKiem;

    /**
     * Creates new form NhanVienGUI
     */
    public NhanVienGUI() {
        initComponents();

        dtmNhanVien = (DefaultTableModel) tblDSNV.getModel();
        dtmChucVu = (DefaultTableModel) tblDSCV.getModel();
        init();
        initRecentChucVuGUI();
        loadData();
        loadDataDSCV();
    }

    public void init() {

        tblDSNV.setFocusable(false);
        tblDSNV.setIntercellSpacing(new Dimension(0, 0));

        tblDSNV.setRowHeight(25);
        tblDSNV.setFillsViewportHeight(true);

        tblDSNV.getTableHeader().setOpaque(false);
        tblDSNV.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSNV.getTableHeader().setForeground(Color.WHITE);
        tblDSNV.setSelectionBackground(new Color(188, 206, 248));
        tblDSNV.setSelectionForeground(Color.BLACK);
        tblDSNV.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSNV.getTableHeader().setReorderingAllowed(false);
        tblDSNV.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
        cbxTimKiem.setSelectedIndex(0);
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(TuKhoaTimKiem);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(TuKhoaTimKiem);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(TuKhoaTimKiem);
            }
        });
    }

    public void initRecentChucVuGUI() {
        tblDSCV.setFocusable(false);
        tblDSCV.setIntercellSpacing(new Dimension(0, 0));

        tblDSCV.setRowHeight(25);
        tblDSCV.setFillsViewportHeight(true);

        tblDSCV.getTableHeader().setOpaque(false);
        tblDSCV.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSCV.getTableHeader().setForeground(Color.WHITE);
        tblDSCV.setSelectionBackground(new Color(188, 206, 248));
        tblDSCV.setSelectionForeground(Color.BLACK);
        tblDSCV.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSCV.getTableHeader().setReorderingAllowed(false);
        tblDSCV.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));

    }

    public void showAllDSCV(ArrayList<ChucVuDTO> dscv) {
        dtmChucVu.setRowCount(0);
        for (int i = 0; i < dscv.size(); i++) {
            dtmChucVu.addRow(new String[]{
                dscv.get(i).getMaCV(),
                dscv.get(i).getTenCV(),
              
            });
        }
    }

    public void loadDataDSCV() {
        cvBUS.docDanhSach();
        ArrayList<ChucVuDTO> dscv = cvBUS.getListChucVu();
        showAllDSCV(dscv);
    }

    public void showAll(ArrayList<NhanVienDTO> dsnv) {
        dtmNhanVien.setRowCount(0);
        for (int i = 0; i < dsnv.size(); i++) {
            dtmNhanVien.addRow(new String[]{
                dsnv.get(i).getMaNV(),
                dsnv.get(i).getHo(),
                dsnv.get(i).getTen(),
                dsnv.get(i).getNgaySinh(),
                dsnv.get(i).getGioiTinh(),
                dsnv.get(i).getDiaChi(),
                dsnv.get(i).getSoDT(),
                dsnv.get(i).getMaCV(),
                dsnv.get(i).getIMG()
            });
        }
    }

    public void loadData() {
        nvBUS.docDanhSach();
        ArrayList<NhanVienDTO> dsnv = nvBUS.getListNhanVien();
        showAll(dsnv);

    }

    private void search(String tk) {
        if (tk.equals("Mã NV")) {
            ArrayList<NhanVienDTO> dsnv = nvBUS.searchMaNV(txtTimKiem.getText().toString());
            showAll(dsnv);
        }
        if (tk.equals("Họ")){
            ArrayList<NhanVienDTO> dsnv = nvBUS.searchHo(txtTimKiem.getText().toString());
            showAll(dsnv);
        }
        if(tk.equals("Tên")){
            ArrayList<NhanVienDTO> dsnv = nvBUS.searchTen(txtTimKiem.getText().toString());
            showAll(dsnv);
        }

    }

    public void saveIMG() {
        try {
            if (i != null) {
                File save = new File("src/image/NhanVien/" + imgName);//Tạo file
                ImageIO.write(i, "jpg", save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RecentChucVuGUI = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSCV = new javax.swing.JTable();
        pnHeader1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnChonLoai = new javax.swing.JLabel();
        btnBoChon = new javax.swing.JLabel();
        txtMaCVinMaCV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenCVinCV = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtTimKiem1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSNV = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblMaNV = new javax.swing.JLabel();
        lblHo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtHo = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblSoDT = new javax.swing.JLabel();
        lblMaCV = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        txtMaCV = new javax.swing.JTextField();
        txtIMG = new javax.swing.JLabel();
        btnMaCV = new javax.swing.JButton();
        cbxGioiTinh = new javax.swing.JComboBox<>();
        btnChonAnh = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cbxTimKiem = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        btnChinhSua = new javax.swing.JLabel();
        btnImportExcel = new javax.swing.JLabel();
        btnImportExcel1 = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(250, 247, 240));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        tblDSCV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", null}
            },
            new String [] {
                "Mã CV", "Tên CV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSCV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSCVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSCV);
        if (tblDSCV.getColumnModel().getColumnCount() > 0) {
            tblDSCV.getColumnModel().getColumn(0).setResizable(false);
            tblDSCV.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblDSCV.getColumnModel().getColumn(1).setResizable(false);
            tblDSCV.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        pnHeader1.setBackground(new java.awt.Color(152, 168, 248));
        pnHeader1.setPreferredSize(new java.awt.Dimension(102, 40));

        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lblChucVu.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Baloo 2 ExtraBold", 1, 18)); // NOI18N
        jLabel9.setText("QUẢN LÝ CHỨC VỤ");

        javax.swing.GroupLayout pnHeader1Layout = new javax.swing.GroupLayout(pnHeader1);
        pnHeader1.setLayout(pnHeader1Layout);
        pnHeader1Layout.setHorizontalGroup(
            pnHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHeader1Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnHeader1Layout.setVerticalGroup(
            pnHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnHeader1Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(250, 247, 240));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỌN CHỨC VỤ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 0, 18), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("KIẾM TRA THÔNG TIN");

        btnChonLoai.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonLoai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChonLoai.setText("Chọn NV");
        btnChonLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonLoaiMouseClicked(evt);
            }
        });

        btnBoChon.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnBoChon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBoChon.setText("Bỏ chọn");
        btnBoChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBoChonMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Mã CV");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Tên CV");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaCVinMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenCVinCV, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChonLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnChonLoai)
                        .addGap(27, 27, 27)
                        .addComponent(btnBoChon))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaCVinMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTenCVinCV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(250, 247, 240));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2", 1, 18), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel7.setToolTipText("");
        jPanel7.setPreferredSize(new java.awt.Dimension(368, 300));

        jComboBox2.setEditable(true);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã KH" }));
        jComboBox2.setFocusable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(pnHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RecentChucVuGUILayout = new javax.swing.GroupLayout(RecentChucVuGUI.getContentPane());
        RecentChucVuGUI.getContentPane().setLayout(RecentChucVuGUILayout);
        RecentChucVuGUILayout.setHorizontalGroup(
            RecentChucVuGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        RecentChucVuGUILayout.setVerticalGroup(
            RecentChucVuGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(1089, 756));

        jPanel2.setBackground(new java.awt.Color(250, 247, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(1089, 700));

        tblDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ", "Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Số ĐT", "Mã CV", "IMG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSNV);
        if (tblDSNV.getColumnModel().getColumnCount() > 0) {
            tblDSNV.getColumnModel().getColumn(0).setResizable(false);
            tblDSNV.getColumnModel().getColumn(0).setPreferredWidth(23);
            tblDSNV.getColumnModel().getColumn(1).setResizable(false);
            tblDSNV.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblDSNV.getColumnModel().getColumn(2).setResizable(false);
            tblDSNV.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblDSNV.getColumnModel().getColumn(3).setResizable(false);
            tblDSNV.getColumnModel().getColumn(3).setPreferredWidth(25);
            tblDSNV.getColumnModel().getColumn(3).setHeaderValue("Ngày Sinh");
            tblDSNV.getColumnModel().getColumn(4).setResizable(false);
            tblDSNV.getColumnModel().getColumn(4).setPreferredWidth(15);
            tblDSNV.getColumnModel().getColumn(4).setHeaderValue("Giới Tính");
            tblDSNV.getColumnModel().getColumn(5).setResizable(false);
            tblDSNV.getColumnModel().getColumn(5).setPreferredWidth(25);
            tblDSNV.getColumnModel().getColumn(5).setHeaderValue("Địa Chỉ");
            tblDSNV.getColumnModel().getColumn(6).setResizable(false);
            tblDSNV.getColumnModel().getColumn(6).setPreferredWidth(20);
            tblDSNV.getColumnModel().getColumn(6).setHeaderValue("Số ĐT");
            tblDSNV.getColumnModel().getColumn(7).setResizable(false);
            tblDSNV.getColumnModel().getColumn(7).setPreferredWidth(15);
            tblDSNV.getColumnModel().getColumn(7).setHeaderValue("Mã CV");
            tblDSNV.getColumnModel().getColumn(8).setResizable(false);
            tblDSNV.getColumnModel().getColumn(8).setPreferredWidth(25);
            tblDSNV.getColumnModel().getColumn(8).setHeaderValue("IMG");
        }

        jPanel1.setBackground(new java.awt.Color(250, 247, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QUẢN LÝ NHÂN VIÊN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Baloo 2 ExtraBold", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N

        lblMaNV.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaNV.setText("Mã NV");

        lblHo.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblHo.setText("Họ");

        jLabel3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel3.setText("Tên");

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel5.setText("Giới tính");

        lblDiaChi.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblDiaChi.setText("Địa chỉ");

        lblSoDT.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblSoDT.setText("Số ĐT");

        lblMaCV.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaCV.setText("Mã CV");

        txtIMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIMG.setText("IMAGE");
        txtIMG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnMaCV.setText("...");
        btnMaCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaCVActionPerformed(evt);
            }
        });

        cbxGioiTinh.setEditable(true);
        cbxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        btnChonAnh.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChonAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/upload.png"))); // NOI18N
        btnChonAnh.setText("Upload ảnh");
        btnChonAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChonAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaNV)
                            .addComponent(lblHo)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtHo)
                            .addComponent(txtTen))))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblDiaChi)
                    .addComponent(lblSoDT)
                    .addComponent(lblMaCV))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMaCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtSoDT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(36, 36, 36)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChonAnh))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiaChi)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoDT)
                            .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaCV)
                            .addComponent(txtMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMaNV)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHo)
                            .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(250, 247, 240));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Baloo 2 ExtraBold", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N

        cbxTimKiem.setEditable(true);
        cbxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NV", "Họ", "Tên", "Ngày sinh", "Giới tính", "Địa chỉ", "SĐT" }));
        cbxTimKiem.setToolTipText("");
        cbxTimKiem.setFocusable(false);
        cbxTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(250, 247, 240));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỨC NĂNG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baloo 2 ExtraBold", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThem.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnAdd.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        jPanel4.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        btnXoa.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnDelete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        jPanel4.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        btnChinhSua.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/btnUpdate.png"))); // NOI18N
        btnChinhSua.setText("Sửa");
        btnChinhSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChinhSuaMouseClicked(evt);
            }
        });
        jPanel4.add(btnChinhSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        btnImportExcel.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnImportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import.png"))); // NOI18N
        btnImportExcel.setText("Nhập Excel");
        btnImportExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImportExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportExcelMouseClicked(evt);
            }
        });
        jPanel4.add(btnImportExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        btnImportExcel1.setFont(new java.awt.Font("Baloo 2", 1, 18)); // NOI18N
        btnImportExcel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xls.png"))); // NOI18N
        btnImportExcel1.setText("Xuất Excel");
        btnImportExcel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImportExcel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportExcel1MouseClicked(evt);
            }
        });
        jPanel4.add(btnImportExcel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 776, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemActionPerformed
        TuKhoaTimKiem = cbxTimKiem.getSelectedItem().toString();
        txtTimKiem.setText("");
    }//GEN-LAST:event_cbxTimKiemActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        String MaNV = txtMaNV.getText().toUpperCase();
        String Ho = txtHo.getText();
        String Ten = txtTen.getText();
        String NgaySinh = txtNgaySinh.getText();
        String GioiTinh = cbxGioiTinh.getSelectedItem().toString();
        String DiaChi = txtDiaChi.getText();
        String SoDT = txtSoDT.getText();
        String MaCV = txtMaCV.getText();
        String IMG = imgName;
        NhanVienDTO nv = new NhanVienDTO(MaNV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SoDT, MaCV, IMG);
        nvBUS.add(nv);
        saveIMG();
        loadData();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // nvBUS.delete(txtMaNV.getText());
        //saveIMG();
        //loadData();      

        if (tblDSNV.getSelectedRowCount() == 1) {
            int result = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa sản phẩm này?");
            if (result == 0) {
                nvBUS.delete(txtMaNV.getText());
                saveIMG();
                loadData();
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm muốn xóa!");
        }


    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnChinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChinhSuaMouseClicked
        String MaNV = txtMaNV.getText();
        String Ho = txtHo.getText();
        String Ten = txtTen.getText();
        String NgaySinh = txtNgaySinh.getText();
        String GioiTinh = cbxGioiTinh.getSelectedItem().toString();
        String DiaChi = txtDiaChi.getText();
        String SoDT = txtSoDT.getText();
        String MaCV = txtMaCV.getText();
        //String Luong = txtLuong.getText();
        String IMG = imgName;
        NhanVienDTO nv = new NhanVienDTO(MaNV, Ho, Ten, NgaySinh, GioiTinh, DiaChi, SoDT, MaCV, IMG);
        nvBUS.updates(nv);
        saveIMG();
        loadData();
    }//GEN-LAST:event_btnChinhSuaMouseClicked

    private void tblDSNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNVMouseClicked
        int k = tblDSNV.getSelectedRow();
        txtMaNV.setText(tblDSNV.getModel().getValueAt(k, 0).toString());
        txtHo.setText(tblDSNV.getModel().getValueAt(k, 1).toString());
        txtTen.setText(tblDSNV.getModel().getValueAt(k, 2).toString());
        txtNgaySinh.setText(tblDSNV.getModel().getValueAt(k, 3).toString());
        cbxGioiTinh.setSelectedItem(tblDSNV.getModel().getValueAt(k, 4).toString());
        txtDiaChi.setText(tblDSNV.getModel().getValueAt(k, 5).toString());
        txtSoDT.setText(tblDSNV.getModel().getValueAt(k, 6).toString());
        txtMaCV.setText(tblDSNV.getModel().getValueAt(k, 7).toString());
        imgName = tblDSNV.getModel().getValueAt(k, 8).toString();
        txtMaNV.setEnabled(false);
        Image newImage;

        newImage = new ImageIcon("./src/image/NhanVien/" + imgName).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);

        txtIMG.setIcon(new ImageIcon(newImage));
    }//GEN-LAST:event_tblDSNVMouseClicked

    private void btnChonAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonAnhMouseClicked
        JFileChooser fc = new JFileChooser("./src/image/NhanVien");
        FileNameExtensionFilter filter;
        filter = new FileNameExtensionFilter(
                "JPG, PNG & JPEG images", "jpg", "png", "jpeg");
        fc.setFileFilter(filter);
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile(); //Lấy URL hình
                i = ImageIO.read(file); // Lấy hình
                imgName = txtTen.getText().concat(".jpg"); //Tên hình
                // Thay đổi hình hiển thị
                txtIMG.setText("");
                txtIMG.setIcon(new ImageIcon(i.getScaledInstance(200, 230, Image.SCALE_DEFAULT)));

                revalidate();
                repaint();
            } catch (IOException ex) {
                Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnChonAnhMouseClicked

    private void btnImportExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportExcelMouseClicked
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/checkOption.png"));
        JFileChooser fc = new JFileChooser("./report");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Excel", "xlsx");
        fc.setFileFilter(filter);
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile(); //Lấy URL
            nvBUS.ImportExcel(file);
            nvBUS.listNV();
            JOptionPane.showMessageDialog(null, "Đã nhập file excel thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE, icon);

        }
        saveIMG();
        loadData();
    }//GEN-LAST:event_btnImportExcelMouseClicked

    private void btnMaCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaCVActionPerformed
        RecentChucVuGUI.setUndecorated(true);
        RecentChucVuGUI.pack();
        RecentChucVuGUI.setLocationRelativeTo(null);
        RecentChucVuGUI.setVisible(true);
    }//GEN-LAST:event_btnMaCVActionPerformed

    private void tblDSCVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSCVMouseClicked
        int k = tblDSCV.getSelectedRow();
        txtMaCVinMaCV.setText(tblDSCV.getModel().getValueAt(k, 0).toString());
        txtTenCVinCV.setText(tblDSCV.getModel().getValueAt(k, 1).toString());

        txtMaCVinMaCV.setEnabled(false);
        txtTenCVinCV.setEnabled(false);
    }//GEN-LAST:event_tblDSCVMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        RecentChucVuGUI.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnChonLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonLoaiMouseClicked
        RecentChucVuGUI.dispose();
    }//GEN-LAST:event_btnChonLoaiMouseClicked

    private void btnBoChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoChonMouseClicked
        RecentChucVuGUI.dispose();
    }//GEN-LAST:event_btnBoChonMouseClicked

    private void btnImportExcel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportExcel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImportExcel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog RecentChucVuGUI;
    private javax.swing.JLabel btnBoChon;
    private javax.swing.JLabel btnChinhSua;
    private javax.swing.JLabel btnChonAnh;
    private javax.swing.JLabel btnChonLoai;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnImportExcel;
    private javax.swing.JLabel btnImportExcel1;
    private javax.swing.JButton btnMaCV;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private javax.swing.JComboBox<String> cbxTimKiem;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMaCV;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblSoDT;
    private javax.swing.JPanel pnHeader1;
    private javax.swing.JTable tblDSCV;
    private javax.swing.JTable tblDSNV;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHo;
    private javax.swing.JLabel txtIMG;
    private javax.swing.JTextField txtMaCV;
    private javax.swing.JTextField txtMaCVinMaCV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenCVinCV;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    // End of variables declaration//GEN-END:variables
}
