package GUI;

import BUS.CTHoaDonBUS;
import BUS.HoaDonBUS;
import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wizardsc
 */
public class DSHoaDonGUI extends javax.swing.JPanel {

    private HoaDonBUS hdBUS = new HoaDonBUS();
    private CTHoaDonBUS cthdBUS = new CTHoaDonBUS();
    DefaultTableModel dtmDSHoaDon;
    DefaultTableModel dtmDSCTHoaDon;
    String tuKhoaTimKiem;

    public DSHoaDonGUI() {
        initComponents();
        dtmDSHoaDon = (DefaultTableModel) tblDSHD.getModel();
        dtmDSCTHoaDon = (DefaultTableModel) tblDSCTHD.getModel();
        init();
        loadDataDSHD();

    }

    public void init() {
        //set giao diện cho Table
        //DSHD
        tblDSHD.setFocusable(false);
        tblDSHD.setIntercellSpacing(new Dimension(0, 0));
        tblDSHD.setRowHeight(25);
        tblDSHD.setFillsViewportHeight(true);
        tblDSHD.getTableHeader().setOpaque(false);
        tblDSHD.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSHD.getTableHeader().setForeground(Color.WHITE);
        tblDSHD.setSelectionBackground(new Color(188, 206, 248));
        tblDSHD.setSelectionForeground(Color.BLACK);
        tblDSHD.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSHD.getTableHeader().setReorderingAllowed(false);
        tblDSHD.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
        //DSCTHD
        tblDSCTHD.setFocusable(false);
        tblDSCTHD.setIntercellSpacing(new Dimension(0, 0));
        tblDSCTHD.setRowHeight(25);
        tblDSCTHD.setFillsViewportHeight(true);
        tblDSCTHD.getTableHeader().setOpaque(false);
        tblDSCTHD.getTableHeader().setBackground(new Color(152, 168, 248));
        tblDSCTHD.getTableHeader().setForeground(Color.WHITE);
        tblDSCTHD.setSelectionBackground(new Color(188, 206, 248));
        tblDSCTHD.setSelectionForeground(Color.BLACK);
        tblDSCTHD.setFont(new Font("Arial", Font.PLAIN, 13));
        tblDSCTHD.getTableHeader().setReorderingAllowed(false);
        tblDSCTHD.setBorder(BorderFactory.createLineBorder(new Color(152, 168, 248), 1));
        tuKhoaTimKiem = cbxTimKiem.getSelectedItem().toString();
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(tuKhoaTimKiem);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(tuKhoaTimKiem);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(tuKhoaTimKiem);
            }
        });
        

    }
    
    public void search(String tk){
        if(tk.equals("Mã HD")){
            ArrayList<HoaDonDTO> dshd = hdBUS.searchMaHD(txtTimKiem.getText().toString());
            showAllDSHD(dshd);
        }
    }
    public void showAllDSHD(ArrayList<HoaDonDTO> dshd) {
        dtmDSHoaDon.setRowCount(0);
        for (int i = 0; i < dshd.size(); i++) {
            dtmDSHoaDon.addRow(new String[]{
                dshd.get(i).getMaHD(),
                dshd.get(i).getMaKH(),
                dshd.get(i).getMaNV(),
                dshd.get(i).getNgayLap(),
                String.valueOf(dshd.get(i).getTongTien())
            });
        }

    }

    public void loadDataDSHD() {
        hdBUS.docDanhSach();
        ArrayList<HoaDonDTO> dshd = hdBUS.getListHoaDon();
        showAllDSHD(dshd);
    }

    public void showAllDSCTHD(ArrayList<CTHoaDonDTO> dscthd) {
        dtmDSCTHoaDon.setRowCount(0);
        for (int i = 0; i < dscthd.size(); i++) {
            dtmDSCTHoaDon.addRow(new String[]{
                dscthd.get(i).getMaHD(),
                dscthd.get(i).getMaSP(),
                dscthd.get(i).getTenSP(),
                String.valueOf(dscthd.get(i).getSoLuong()),
                String.valueOf(dscthd.get(i).getDonGia()),
                String.valueOf(dscthd.get(i).getThanhTien())
            });
        }
    }

    public void loadDataDSCTHD() {
        cthdBUS.docListCTHoaDon();
        ArrayList<CTHoaDonDTO> dscthd = cthdBUS.getListCTHoaDon();
        showAllDSCTHD(dscthd);
    }

    public void loadDataDSCTHDTheoMaHD(String MaHD) {
        if (cthdBUS.getListCTHoaDon() == null) {
            cthdBUS.listCTHD();
        }
        ArrayList<CTHoaDonDTO> dscthd = cthdBUS.getListCTHDTheoMaHD(MaHD);
        dtmDSCTHoaDon.setRowCount(0);
        showAllDSCTHD(dscthd);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnRoot = new javax.swing.JPanel();
        pnDSSP = new javax.swing.JPanel();
        lblDSSP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSHD = new javax.swing.JTable();
        lblMaSP = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        lblHo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgayLap = new com.toedter.calendar.JDateChooser();
        txtTimKiem = new javax.swing.JTextField();
        txtFrom = new javax.swing.JTextField();
        txtTo = new javax.swing.JTextField();
        lblMaPN = new javax.swing.JLabel();
        lblMaPN2 = new javax.swing.JLabel();
        cbxTimKiemNC = new javax.swing.JComboBox<>();
        cbxTimKiem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnTimKiemNC = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        pnGioHang = new javax.swing.JPanel();
        lblGioHang = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDSCTHD = new javax.swing.JTable();
        lblMaPNinDSPN = new javax.swing.JLabel();
        txtMaPNinDSHD = new javax.swing.JTextField();
        lblTenSPinDSPN = new javax.swing.JLabel();
        txtTenSPinDSHD = new javax.swing.JTextField();
        lblSoLuonginDSPN = new javax.swing.JLabel();
        txtSoLuonginDSHD = new javax.swing.JTextField();
        lblThanhTieninDSPN = new javax.swing.JLabel();
        txtThanhTieninDSHD = new javax.swing.JTextField();
        txtDonGiainDSHD = new javax.swing.JTextField();
        lblDonGiainDSPN = new javax.swing.JLabel();
        lblSanPhaminDSPN = new javax.swing.JLabel();
        txtMaSPinDSHD = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnRoot.setBackground(new java.awt.Color(250, 247, 240));

        pnDSSP.setBackground(new java.awt.Color(250, 247, 240));
        pnDSSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 4, new java.awt.Color(0, 0, 0)));
        pnDSSP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDSSP.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblDSSP.setForeground(new java.awt.Color(255, 51, 51));
        lblDSSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDSSP.setText("Danh sách hóa đơn");
        pnDSSP.add(lblDSSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 30));

        tblDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã KH", "Mã NV", "Ngày lập", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSHD);
        if (tblDSHD.getColumnModel().getColumnCount() > 0) {
            tblDSHD.getColumnModel().getColumn(0).setResizable(false);
            tblDSHD.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblDSHD.getColumnModel().getColumn(1).setResizable(false);
            tblDSHD.getColumnModel().getColumn(1).setPreferredWidth(5);
            tblDSHD.getColumnModel().getColumn(2).setResizable(false);
            tblDSHD.getColumnModel().getColumn(2).setPreferredWidth(5);
            tblDSHD.getColumnModel().getColumn(3).setResizable(false);
            tblDSHD.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblDSHD.getColumnModel().getColumn(4).setResizable(false);
            tblDSHD.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        pnDSSP.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 480, 410));

        lblMaSP.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaSP.setText("Mã HD");
        pnDSSP.add(lblMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDActionPerformed(evt);
            }
        });
        pnDSSP.add(txtMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 160, 24));
        pnDSSP.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 160, 24));

        lblHo.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblHo.setText("Mã NV");
        pnDSSP.add(lblHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        jLabel3.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel3.setText("Mã KH");
        pnDSSP.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, -1, -1));

        jLabel4.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel4.setText("Ngày lập");
        pnDSSP.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, -1, -1));
        pnDSSP.add(txtMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 160, 24));
        pnDSSP.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 160, 24));

        jLabel5.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        jLabel5.setText("Tổng tiền");
        pnDSSP.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, -1, -1));

        txtNgayLap.setDateFormatString("dd/MM/yyyy");
        pnDSSP.add(txtNgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 160, 24));

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        pnDSSP.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 310, 30));
        pnDSSP.add(txtFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 650, 120, 30));
        pnDSSP.add(txtTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 650, 120, 30));

        lblMaPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaPN.setText("Đến");
        pnDSSP.add(lblMaPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, 40, 30));

        lblMaPN2.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPN2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaPN2.setText("Từ");
        pnDSSP.add(lblMaPN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 650, 30, 30));

        cbxTimKiemNC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày lập", "Tổng tiền" }));
        cbxTimKiemNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemNCActionPerformed(evt);
            }
        });
        pnDSSP.add(cbxTimKiemNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, 100, 30));

        cbxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã HD", "Mã NV", "Mã KH" }));
        cbxTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemActionPerformed(evt);
            }
        });
        pnDSSP.add(cbxTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 100, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        pnDSSP.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        btnTimKiemNC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTimKiemNC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemNCMouseClicked(evt);
            }
        });
        pnDSSP.add(btnTimKiemNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

        jTextField1.setText("Tháng");
        pnDSSP.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 100, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        pnDSSP.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
        pnDSSP.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 610, 310, 30));

        pnGioHang.setBackground(new java.awt.Color(250, 247, 240));

        lblGioHang.setFont(new java.awt.Font("Baloo 2 ExtraBold", 0, 20)); // NOI18N
        lblGioHang.setForeground(new java.awt.Color(255, 51, 51));
        lblGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioHang.setText("Chi tiết hóa đơn");

        tblDSCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSCTHDMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDSCTHD);
        if (tblDSCTHD.getColumnModel().getColumnCount() > 0) {
            tblDSCTHD.getColumnModel().getColumn(0).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblDSCTHD.getColumnModel().getColumn(1).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblDSCTHD.getColumnModel().getColumn(2).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(2).setPreferredWidth(230);
            tblDSCTHD.getColumnModel().getColumn(3).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(3).setPreferredWidth(25);
            tblDSCTHD.getColumnModel().getColumn(4).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblDSCTHD.getColumnModel().getColumn(5).setResizable(false);
            tblDSCTHD.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        lblMaPNinDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblMaPNinDSPN.setText("Mã HD");

        lblTenSPinDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblTenSPinDSPN.setText("Tên SP");

        lblSoLuonginDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblSoLuonginDSPN.setText("Số lượng");

        lblThanhTieninDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblThanhTieninDSPN.setText("Thành tiền");

        lblDonGiainDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblDonGiainDSPN.setText("Đơn giá");

        lblSanPhaminDSPN.setFont(new java.awt.Font("Baloo 2 SemiBold", 1, 14)); // NOI18N
        lblSanPhaminDSPN.setText("Mã SP");

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
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addComponent(lblSoLuonginDSPN)
                                .addGap(18, 18, 18)
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnGioHangLayout.createSequentialGroup()
                                        .addComponent(txtSoLuonginDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(lblDonGiainDSPN)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDonGiainDSHD))
                                    .addGroup(pnGioHangLayout.createSequentialGroup()
                                        .addComponent(txtMaPNinDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtTenSPinDSHD)))
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addComponent(lblMaPNinDSPN)
                                .addGap(257, 257, 257)
                                .addComponent(lblSanPhaminDSPN)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaSPinDSHD))
                            .addGroup(pnGioHangLayout.createSequentialGroup()
                                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTenSPinDSPN)
                                    .addGroup(pnGioHangLayout.createSequentialGroup()
                                        .addComponent(lblThanhTieninDSPN)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtThanhTieninDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnGioHangLayout.setVerticalGroup(
            pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGioHangLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPNinDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaPNinDSPN)
                    .addComponent(lblSanPhaminDSPN)
                    .addComponent(txtMaSPinDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenSPinDSPN)
                    .addComponent(txtTenSPinDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSoLuonginDSPN)
                        .addComponent(txtSoLuonginDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDonGiainDSPN)
                        .addComponent(txtDonGiainDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThanhTieninDSPN)
                    .addComponent(txtThanhTieninDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRootLayout.createSequentialGroup()
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnGioHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDSSP, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, -1, 760));
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSHDMouseClicked
        int k = tblDSHD.getSelectedRow();
        //        int SoLuong = Integer.parseInt(tblDSHD.getModel().getValueAt(k, 2).toString());
        //        if (SoLuong < -100) {
        //            JOptionPane.showMessageDialog(pnRoot, "Sản phẩm đã hết hàng", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
        //            return;
        //        }
        //        //-- setModel cho txtSoLuong, căn trái số,....
        //        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, -10, SoLuong, 1);
        //        txtSoLuong.setModel(modeSpinner);
        //        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) txtSoLuong.getEditor()).getTextField();
        //        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
        //        txtSpinner.setEditable(false);
        //        txtSpinner.setHorizontalAlignment(JTextField.LEFT);
        //--
        txtMaHD.setText(tblDSHD.getModel().getValueAt(k, 0).toString());
        txtMaNV.setText(tblDSHD.getModel().getValueAt(k, 2).toString());
        txtMaKH.setText(tblDSHD.getModel().getValueAt(k, 1).toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date NgayLap = new Date();
        try {
            NgayLap = sdf.parse(tblDSHD.getModel().getValueAt(k, 3).toString());
        } catch (ParseException ex) {
            System.out.println("Sai thgian");
            Logger.getLogger(HoaDonGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNgayLap.setDate(NgayLap);
        txtTongTien.setText(tblDSHD.getModel().getValueAt(k, 4).toString());

        txtMaHD.setEnabled(false);
        txtMaNV.setEnabled(false);
        txtMaKH.setEnabled(false);
        txtNgayLap.setEnabled(false);
        txtTongTien.setEnabled(false);
        String MaHD = txtMaHD.getText();
        loadDataDSCTHDTheoMaHD(MaHD);
    }//GEN-LAST:event_tblDSHDMouseClicked

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDActionPerformed

    private void tblDSCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSCTHDMouseClicked
        int k = tblDSCTHD.getSelectedRow();
        txtMaPNinDSHD.setText(tblDSCTHD.getModel().getValueAt(k, 0).toString());
        txtMaSPinDSHD.setText(tblDSCTHD.getModel().getValueAt(k, 1).toString());
        txtTenSPinDSHD.setText(tblDSCTHD.getModel().getValueAt(k, 2).toString());
        txtSoLuonginDSHD.setText(tblDSCTHD.getModel().getValueAt(k, 3).toString());
        txtDonGiainDSHD.setText(tblDSCTHD.getModel().getValueAt(k, 4).toString());
        txtThanhTieninDSHD.setText(tblDSCTHD.getModel().getValueAt(k, 5).toString());

        txtMaPNinDSHD.setEnabled(false);
        txtMaSPinDSHD.setEnabled(false);
        txtTenSPinDSHD.setEnabled(false);
        txtSoLuonginDSHD.setEnabled(false);
        txtDonGiainDSHD.setEnabled(false);
        txtThanhTieninDSHD.setEnabled(false);
    }//GEN-LAST:event_tblDSCTHDMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void cbxTimKiemNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemNCActionPerformed
//        tuKhoaTimKiem = cbxTimKiemNC.getSelectedItem().toString();
//        System.out.println(tuKhoaTimKiem);
    }//GEN-LAST:event_cbxTimKiemNCActionPerformed

    private void cbxTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemActionPerformed
        tuKhoaTimKiem = cbxTimKiem.getSelectedItem().toString();
        System.out.println(tuKhoaTimKiem);
        txtTimKiem.setText("");
    }//GEN-LAST:event_cbxTimKiemActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDSSP;
    private javax.swing.JLabel lblDonGiainDSPN;
    private javax.swing.JLabel lblGioHang;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblMaPN;
    private javax.swing.JLabel lblMaPN2;
    private javax.swing.JLabel lblMaPNinDSPN;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblSanPhaminDSPN;
    private javax.swing.JLabel lblSoLuonginDSPN;
    private javax.swing.JLabel lblTenSPinDSPN;
    private javax.swing.JLabel lblThanhTieninDSPN;
    private javax.swing.JPanel pnDSSP;
    private javax.swing.JPanel pnGioHang;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JTable tblDSCTHD;
    private javax.swing.JTable tblDSHD;
    private javax.swing.JTextField txtDonGiainDSHD;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPNinDSHD;
    private javax.swing.JTextField txtMaSPinDSHD;
    private com.toedter.calendar.JDateChooser txtNgayLap;
    private javax.swing.JTextField txtSoLuonginDSHD;
    private javax.swing.JTextField txtTenSPinDSHD;
    private javax.swing.JTextField txtThanhTieninDSHD;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTo;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
