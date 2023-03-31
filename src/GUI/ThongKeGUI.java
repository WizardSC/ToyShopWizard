package GUI;

import BUS.ThongKeBUS;
import DTO.CTHoaDonDTO;
import DTO.KhoDTO;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;


public class ThongKeGUI extends javax.swing.JPanel {
    private ThongKeBUS tkBUS;
    DefaultTableModel modelSP, modelKho;
    
    public ThongKeGUI() {
        initComponents();
        
        tkBUS = new ThongKeBUS();
        modelSP = (DefaultTableModel) tblTKSP.getModel();
        modelKho = (DefaultTableModel) tblTKSPKho.getModel();
        
        JTextFieldDateEditor editorMua = (JTextFieldDateEditor) ngayTKThang.getDateEditor();
        editorMua.setEditable(false);
        
        JTextFieldDateEditor editorKho = (JTextFieldDateEditor) txtThang.getDateEditor();
        editorKho.setEditable(false);

        txtSoLuong.setEditor(new JSpinner.DefaultEditor(txtSoLuong));
        txtSLKho.setEditor(new JSpinner.DefaultEditor(txtSLKho));
        
        loadData();
    }
    public void showAll(ArrayList<CTHoaDonDTO> dstk){
        
        modelSP.setRowCount(0);
        for(int i=0;i<dstk.size();i++){
            System.out.println(dstk.get(i));
            modelSP.addRow(new String[]{
                dstk.get(i).getMaSP(),
                dstk.get(i).getTenSP(),
                String.valueOf(dstk.get(i).getSoLuong())
            });
        }
    }
    
    public void showAllKho(ArrayList<KhoDTO> dstk){
        
        modelKho.setRowCount(0);
        for(int i=0;i<dstk.size();i++){
            System.out.println(dstk.get(i));
            modelKho.addRow(new String[]{
                dstk.get(i).getMaSP(),
                dstk.get(i).getTenSP(),
                String.valueOf(dstk.get(i).getSoLuong())
            });
        }
    }
    
    public void loadData(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
        Date date = new Date();
        ngayTKThang.setDate(date);
        txtThang.setDate(date);
        
        // Doanh Thu
        tkBUS.ThongkeDT(dateFormat.format(ngayTKThang.getDate()));
        setPanelDT(dateFormat.format(ngayTKThang.getDate())
                , tkBUS.listTKDT.get(0)
                , (Double)tkBUS.listTKDT.get(1)
                , (Double)tkBUS.listTKDT.get(2));
            
        // So luong Hoa don
        setPanelHD(dateFormat.format(ngayTKThang.getDate())
                , tkBUS.ThongkeHD(dateFormat.format(ngayTKThang.getDate())));
        
        // Thong ke san pham Mua
        tkBUS.ThongkeSP(dateFormat.format(date), "", "Giảm");
        txtSoLuong.setValue(tkBUS.listTKSP.size()); // Lấy số lượng tối đa
        showAll(tkBUS.listTKSP);
        
        // Tong Tien Nhap
        tkBUS.ThongkeTN(dateFormat.format(txtThang.getDate()));
        setPanelTN(dateFormat.format(txtThang.getDate())
                , tkBUS.listTKTN.get(0)
                , (Double)tkBUS.listTKTN.get(1)
                , (Double)tkBUS.listTKTN.get(2));
            
        // So Luong Nhap
        setPanelSLNhap(dateFormat.format(txtThang.getDate())
                , tkBUS.ThongkeSLN(dateFormat.format(txtThang.getDate())));
        
        // Thong ke san pham Ton Kho
        tkBUS.ThongkeSPKho("", "Giảm");
        txtSLKho.setValue(tkBUS.listTKTon.size()); // Lấy số lượng tối đa
        showAllKho(tkBUS.listTKTon);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PnTKMua = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTKSP = new javax.swing.JTable();
        PnDTMua = new javax.swing.JPanel();
        txtDoanhThu = new javax.swing.JLabel();
        iconUp = new javax.swing.JLabel();
        valueUp = new javax.swing.JLabel();
        ChiemDT = new javax.swing.JLabel();
        PnHD = new javax.swing.JPanel();
        txtSLHD = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboxQuyDT = new javax.swing.JComboBox<>();
        ngayTKThang = new com.toedter.calendar.JDateChooser();
        btnTK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JSpinner();
        cboxSort = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        PnTKKho = new javax.swing.JPanel();
        txtThang = new com.toedter.calendar.JDateChooser();
        btnTKKho = new javax.swing.JButton();
        cboxQuyKho = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtSLKho = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        cboxSortKho = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTKSPKho = new javax.swing.JTable();
        PnTienNhap = new javax.swing.JPanel();
        txtTienNhap = new javax.swing.JLabel();
        iconUpKho = new javax.swing.JLabel();
        valueUpKho = new javax.swing.JLabel();
        ChiemNhap = new javax.swing.JLabel();
        PnSLNhap = new javax.swing.JPanel();
        txtSLNhap = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        PnTKMua.setBackground(new java.awt.Color(250, 247, 240));
        PnTKMua.setPreferredSize(new java.awt.Dimension(1089, 750));
        PnTKMua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnTKMuaMouseClicked(evt);
            }
        });

        tblTKSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblTKSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Tổng Số Lượng Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTKSP.setRowHeight(25);
        tblTKSP.setRowSelectionAllowed(false);
        tblTKSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTKSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTKSP);
        if (tblTKSP.getColumnModel().getColumnCount() > 0) {
            tblTKSP.getColumnModel().getColumn(0).setMaxWidth(80);
            tblTKSP.getColumnModel().getColumn(2).setMinWidth(130);
            tblTKSP.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        PnDTMua.setBackground(new java.awt.Color(0, 204, 204));
        PnDTMua.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng Doanh Thu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 28), new java.awt.Color(255, 255, 255))); // NOI18N

        txtDoanhThu.setBackground(new java.awt.Color(153, 102, 255));
        txtDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        txtDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        txtDoanhThu.setText("200000000vnd");

        iconUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow-up.png"))); // NOI18N

        valueUp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueUp.setForeground(new java.awt.Color(51, 153, 0));
        valueUp.setText("50%");

        ChiemDT.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        ChiemDT.setForeground(new java.awt.Color(255, 0, 51));
        ChiemDT.setText("Chiếm % Tổng DT");

        javax.swing.GroupLayout PnDTMuaLayout = new javax.swing.GroupLayout(PnDTMua);
        PnDTMua.setLayout(PnDTMuaLayout);
        PnDTMuaLayout.setHorizontalGroup(
            PnDTMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnDTMuaLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(PnDTMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDoanhThu)
                    .addGroup(PnDTMuaLayout.createSequentialGroup()
                        .addComponent(ChiemDT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(iconUp)
                        .addGap(0, 0, 0)
                        .addComponent(valueUp)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        PnDTMuaLayout.setVerticalGroup(
            PnDTMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnDTMuaLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(PnDTMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChiemDT)
                    .addGroup(PnDTMuaLayout.createSequentialGroup()
                        .addGroup(PnDTMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconUp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valueUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(txtDoanhThu)))
                .addContainerGap())
        );

        PnHD.setBackground(new java.awt.Color(0, 102, 204));
        PnHD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng Đơn Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 28), new java.awt.Color(255, 255, 255))); // NOI18N

        txtSLHD.setBackground(new java.awt.Color(153, 102, 255));
        txtSLHD.setFont(new java.awt.Font("Tahoma", 1, 55)); // NOI18N
        txtSLHD.setForeground(new java.awt.Color(255, 255, 255));
        txtSLHD.setText("0");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Đơn");

        javax.swing.GroupLayout PnHDLayout = new javax.swing.GroupLayout(PnHD);
        PnHD.setLayout(PnHDLayout);
        PnHDLayout.setHorizontalGroup(
            PnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnHDLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSLHD)
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(27, 27, 27))
        );
        PnHDLayout.setVerticalGroup(
            PnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnHDLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(PnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSLHD)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        cboxQuyDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboxQuyDT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Quý Thống Kê", "Quý 1", "Quý 2", "Quý 3", "Quý 4" }));
        cboxQuyDT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxQuyDTItemStateChanged(evt);
            }
        });

        ngayTKThang.setDateFormatString("MM-yyyy");
        ngayTKThang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnTK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTK.setText("Thống Kê");
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Số Sản Phẩm");

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSoLuong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtSoLuongStateChanged(evt);
            }
        });

        cboxSort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm", "Tăng" }));
        cboxSort.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxSortItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Sắp xếp");

        javax.swing.GroupLayout PnTKMuaLayout = new javax.swing.GroupLayout(PnTKMua);
        PnTKMua.setLayout(PnTKMuaLayout);
        PnTKMuaLayout.setHorizontalGroup(
            PnTKMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnTKMuaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PnTKMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnTKMuaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnTKMuaLayout.createSequentialGroup()
                        .addGroup(PnTKMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ngayTKThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxQuyDT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addComponent(btnTK)))
                .addGap(31, 31, 31)
                .addGroup(PnTKMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnDTMua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        PnTKMuaLayout.setVerticalGroup(
            PnTKMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnTKMuaLayout.createSequentialGroup()
                .addGroup(PnTKMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnTKMuaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PnDTMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(PnHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnTKMuaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(PnTKMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngayTKThang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cboxQuyDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(PnTKMuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(324, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("   MUA HÀNG   ", PnTKMua);
        PnTKMua.getAccessibleContext().setAccessibleDescription("");

        txtThang.setDateFormatString("MM-yyyy");
        txtThang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnTKKho.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTKKho.setText("Thống Kê");
        btnTKKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKKhoActionPerformed(evt);
            }
        });

        cboxQuyKho.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboxQuyKho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Quý Thống Kê", "Quý 1", "Quý 2", "Quý 3", "Quý 4" }));
        cboxQuyKho.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxQuyKhoItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Số Sản Phẩm");

        txtSLKho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSLKho.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtSLKhoStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Sắp xếp");

        cboxSortKho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxSortKho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm", "Tăng" }));
        cboxSortKho.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxSortKhoItemStateChanged(evt);
            }
        });

        tblTKSPKho.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblTKSPKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Tổng Số Lượng Tồn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTKSPKho.setRowHeight(25);
        tblTKSPKho.setRowSelectionAllowed(false);
        tblTKSPKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTKSPKhoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTKSPKho);
        if (tblTKSPKho.getColumnModel().getColumnCount() > 0) {
            tblTKSPKho.getColumnModel().getColumn(0).setMaxWidth(80);
            tblTKSPKho.getColumnModel().getColumn(2).setMinWidth(130);
            tblTKSPKho.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        PnTienNhap.setBackground(new java.awt.Color(0, 204, 204));
        PnTienNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng Tiền Nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 28), new java.awt.Color(255, 255, 255))); // NOI18N

        txtTienNhap.setBackground(new java.awt.Color(153, 102, 255));
        txtTienNhap.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        txtTienNhap.setForeground(new java.awt.Color(255, 255, 255));
        txtTienNhap.setText("200000000vnd");

        iconUpKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow-up.png"))); // NOI18N

        valueUpKho.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueUpKho.setForeground(new java.awt.Color(51, 153, 0));
        valueUpKho.setText("50%");

        ChiemNhap.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        ChiemNhap.setForeground(new java.awt.Color(255, 0, 51));
        ChiemNhap.setText("Chiếm % Tổng Tiền Nhập");

        javax.swing.GroupLayout PnTienNhapLayout = new javax.swing.GroupLayout(PnTienNhap);
        PnTienNhap.setLayout(PnTienNhapLayout);
        PnTienNhapLayout.setHorizontalGroup(
            PnTienNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnTienNhapLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(PnTienNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTienNhap)
                    .addGroup(PnTienNhapLayout.createSequentialGroup()
                        .addComponent(ChiemNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(iconUpKho)
                        .addGap(0, 0, 0)
                        .addComponent(valueUpKho)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        PnTienNhapLayout.setVerticalGroup(
            PnTienNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnTienNhapLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(PnTienNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChiemNhap)
                    .addGroup(PnTienNhapLayout.createSequentialGroup()
                        .addGroup(PnTienNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconUpKho, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valueUpKho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(txtTienNhap)))
                .addContainerGap())
        );

        PnSLNhap.setBackground(new java.awt.Color(0, 102, 204));
        PnSLNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Số Lượng Nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 28), new java.awt.Color(255, 255, 255))); // NOI18N

        txtSLNhap.setBackground(new java.awt.Color(153, 102, 255));
        txtSLNhap.setFont(new java.awt.Font("Tahoma", 1, 55)); // NOI18N
        txtSLNhap.setForeground(new java.awt.Color(255, 255, 255));
        txtSLNhap.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sản phẩm");

        javax.swing.GroupLayout PnSLNhapLayout = new javax.swing.GroupLayout(PnSLNhap);
        PnSLNhap.setLayout(PnSLNhapLayout);
        PnSLNhapLayout.setHorizontalGroup(
            PnSLNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnSLNhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSLNhap)
                .addGap(9, 9, 9)
                .addComponent(jLabel6)
                .addGap(10, 10, 10))
        );
        PnSLNhapLayout.setVerticalGroup(
            PnSLNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnSLNhapLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(PnSLNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSLNhap)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        javax.swing.GroupLayout PnTKKhoLayout = new javax.swing.GroupLayout(PnTKKho);
        PnTKKho.setLayout(PnTKKhoLayout);
        PnTKKhoLayout.setHorizontalGroup(
            PnTKKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnTKKhoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PnTKKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnTKKhoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSLKho, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxSortKho, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnTKKhoLayout.createSequentialGroup()
                        .addGroup(PnTKKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxQuyKho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addComponent(btnTKKho)))
                .addGap(31, 31, 31)
                .addGroup(PnTKKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PnSLNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnTienNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnTKKhoLayout.setVerticalGroup(
            PnTKKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnTKKhoLayout.createSequentialGroup()
                .addGroup(PnTKKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnTKKhoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PnTienNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(PnSLNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnTKKhoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(PnTKKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTKKho, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cboxQuyKho, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(PnTKKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSLKho, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxSortKho, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(324, Short.MAX_VALUE))
        );

        PnTienNhap.getAccessibleContext().setAccessibleName("Tổng Tiền Nhập");

        jTabbedPane1.addTab("    KHO    ", PnTKKho);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("MUA HÀNG");
    }// </editor-fold>//GEN-END:initComponents

    private void tblTKSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTKSPMouseClicked
        
    }//GEN-LAST:event_tblTKSPMouseClicked

    private void cboxQuyDTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxQuyDTItemStateChanged
        tkBUS.ThongkeDTQuy(String.valueOf(cboxQuyDT.getSelectedItem()));        
        
        // Doanh thu
        setPanelDT(String.valueOf(cboxQuyDT.getSelectedItem())
                    , tkBUS.listTKDT.get(0)
                    , (Double)tkBUS.listTKDT.get(1)
                    , (Double)tkBUS.listTKDT.get(2));
        
        // So luong Hoa don
        setPanelHD(String.valueOf(cboxQuyDT.getSelectedItem())
                , tkBUS.ThongkeHDQuy(String.valueOf(cboxQuyDT.getSelectedItem())));
        
        // Thong ke San Pham
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
        if((int)txtSoLuong.getValue() == -1 || (int)txtSoLuong.getValue() == 0){
            txtSoLuong.setValue(1);
            tkBUS.ThongkeSPQuy(String.valueOf(cboxQuyDT.getSelectedItem()), "1", String.valueOf(cboxSort.getSelectedItem()));
        }
        else{
            
            tkBUS.ThongkeSPQuy(String.valueOf(cboxQuyDT.getSelectedItem()), String.valueOf(txtSoLuong.getValue()), String.valueOf(cboxSort.getSelectedItem()));
        }
        showAll(tkBUS.listTKSP);
    }//GEN-LAST:event_cboxQuyDTItemStateChanged

    private void PnTKMuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnTKMuaMouseClicked
        PnTKMua.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_PnTKMuaMouseClicked

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
        if(ngayTKThang.getDate() != null){
            
                tkBUS.ThongkeDT(dateFormat.format(ngayTKThang.getDate()));

                PnHD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng Đơn Hàng "+dateFormat.format(ngayTKThang.getDate())
                        , javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION
                        , javax.swing.border.TitledBorder.DEFAULT_POSITION
                        , new java.awt.Font("Tahoma", 1, 28)
                        , new java.awt.Color(255, 255, 255)));

                // Doanh Thu
                setPanelDT(dateFormat.format(ngayTKThang.getDate())
                        , tkBUS.listTKDT.get(0)
                        , (Double)tkBUS.listTKDT.get(1)
                        , (Double)tkBUS.listTKDT.get(2));

                // So luong Hoa don
                setPanelHD(dateFormat.format(ngayTKThang.getDate())
                        , tkBUS.ThongkeHD(dateFormat.format(ngayTKThang.getDate())));

                // Thong ke San Pham
                if((int)txtSoLuong.getValue() == -1 || (int)txtSoLuong.getValue() == 0){
                    txtSoLuong.setValue(1);
                    tkBUS.ThongkeSP(dateFormat.format(ngayTKThang.getDate()), "1", String.valueOf(cboxSort.getSelectedItem()));
                }
                else{
                    tkBUS.ThongkeSP(dateFormat.format(ngayTKThang.getDate()), String.valueOf(txtSoLuong.getValue()), String.valueOf(cboxSort.getSelectedItem()));
                }
                showAll(tkBUS.listTKSP);
            
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Chưa nhập thời gian thống kế doanh thu hoac sai dinh dang (MM-yyyy)!!");
        }
    }//GEN-LAST:event_btnTKActionPerformed

    private void cboxSortItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxSortItemStateChanged
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
        if((int)txtSoLuong.getValue() == -1 || (int)txtSoLuong.getValue() == 0){
            txtSoLuong.setValue(1);
            tkBUS.ThongkeSP(dateFormat.format(ngayTKThang.getDate()), "1", String.valueOf(cboxSort.getSelectedItem()));
        }
        else{
            tkBUS.ThongkeSP(dateFormat.format(ngayTKThang.getDate()), String.valueOf(txtSoLuong.getValue()), String.valueOf(cboxSort.getSelectedItem()));
        }
        showAll(tkBUS.listTKSP);
    }//GEN-LAST:event_cboxSortItemStateChanged

    private void txtSoLuongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtSoLuongStateChanged
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
        if((int)txtSoLuong.getValue() == -1 || (int)txtSoLuong.getValue() == 0){
            txtSoLuong.setValue(1);
            tkBUS.ThongkeSP(dateFormat.format(ngayTKThang.getDate()), "1", String.valueOf(cboxSort.getSelectedItem()));
        }
        else{
            tkBUS.ThongkeSP(dateFormat.format(ngayTKThang.getDate()), String.valueOf(txtSoLuong.getValue()), String.valueOf(cboxSort.getSelectedItem()));
        }
        showAll(tkBUS.listTKSP);
    }//GEN-LAST:event_txtSoLuongStateChanged

    private void btnTKKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKKhoActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
        if(txtThang.getDate() != null){
            tkBUS.ThongkeTN(dateFormat.format(txtThang.getDate()));

            // Tong Tien Nhap
            setPanelTN(dateFormat.format(txtThang.getDate())
                    , tkBUS.listTKTN.get(0)
                    , (Double)tkBUS.listTKTN.get(1)
                    , (Double)tkBUS.listTKTN.get(2));

            // So Luong Nhap
            setPanelSLNhap(dateFormat.format(txtThang.getDate())
                    , tkBUS.ThongkeSLN(dateFormat.format(txtThang.getDate())));
        }
        else{
            JOptionPane.showMessageDialog(null, "Chưa nhập thời gian thống kế kho hoac sai dinh dang (MM-yyyy)!!");
        }
        
    }//GEN-LAST:event_btnTKKhoActionPerformed

    private void cboxQuyKhoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxQuyKhoItemStateChanged
        // TODO add your handling code here:
        tkBUS.ThongkeTNQuy(String.valueOf(cboxQuyKho.getSelectedItem()));        
        
        // Tong Tien Nhap
        setPanelTN(String.valueOf(cboxQuyKho.getSelectedItem())
                    , tkBUS.listTKTN.get(0)
                    , (Double)tkBUS.listTKTN.get(1)
                    , (Double)tkBUS.listTKTN.get(2));
        
        // So luong Nhap
        setPanelSLNhap(String.valueOf(cboxQuyKho.getSelectedItem())
                , tkBUS.ThongkeSLNQuy(String.valueOf(cboxQuyKho.getSelectedItem())));
        
    }//GEN-LAST:event_cboxQuyKhoItemStateChanged

    private void txtSLKhoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtSLKhoStateChanged
        // TODO add your handling code here:
        if((int)txtSLKho.getValue() == -1 || (int)txtSLKho.getValue() == 0){
            txtSLKho.setValue(1);
            tkBUS.ThongkeSPKho("1", String.valueOf(cboxSortKho.getSelectedItem()));
        }
        else{
            tkBUS.ThongkeSPKho(String.valueOf(txtSLKho.getValue()), String.valueOf(cboxSortKho.getSelectedItem()));
        }
        showAllKho(tkBUS.listTKTon);
    }//GEN-LAST:event_txtSLKhoStateChanged

    private void cboxSortKhoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxSortKhoItemStateChanged
        // TODO add your handling code here:
        if((int)txtSLKho.getValue() == -1 || (int)txtSLKho.getValue() == 0){
            txtSLKho.setValue(1);
            tkBUS.ThongkeSPKho("1", String.valueOf(cboxSortKho.getSelectedItem()));
        }
        else{
            tkBUS.ThongkeSPKho(String.valueOf(txtSLKho.getValue()), String.valueOf(cboxSortKho.getSelectedItem()));
        }
        showAllKho(tkBUS.listTKTon);
    }//GEN-LAST:event_cboxSortKhoItemStateChanged

    private void tblTKSPKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTKSPKhoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTKSPKhoMouseClicked
    
    private void setPanelDT(String titlePanel, Object DoanhThu, Double percentDT, Double valueDel){
        PnDTMua.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng Doanh Thu " + titlePanel
                    , javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION
                    , javax.swing.border.TitledBorder.DEFAULT_POSITION
                    , new java.awt.Font("Tahoma", 1, 28)
                    , new java.awt.Color(255, 255, 255)));
        
        txtDoanhThu.setText(DoanhThu+"vnd");
        ChiemDT.setText("Chiếm "+String.valueOf(Math.round(percentDT*100)/100)+"% Tổng DT");
        valueUp.setText(String.valueOf(Math.round(valueDel*100)/100)+"%");
            
        if(valueDel >= 0){
            valueUp.setForeground(new Color(51,153,0));
            iconUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow-up.png")));
        }
        else{
            valueUp.setForeground(new Color(204,0,0));
            iconUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow-down.png")));
        }
    }
    
    private void setPanelHD(String titlePanel, String Soluong){
        
        PnHD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng Đơn Hàng "+titlePanel
                    , javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION
                    , javax.swing.border.TitledBorder.DEFAULT_POSITION
                    , new java.awt.Font("Tahoma", 1, 28)
                    , new java.awt.Color(255, 255, 255)));
        
        txtSLHD.setText(Soluong);
    }
    
    private void setPanelTN(String titlePanel, Object DoanhThu, Double percentDT, Double valueDel){
        PnTienNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng Tiền Nhập " + titlePanel
                    , javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION
                    , javax.swing.border.TitledBorder.DEFAULT_POSITION
                    , new java.awt.Font("Tahoma", 1, 28)
                    , new java.awt.Color(255, 255, 255)));
        
        txtTienNhap.setText(DoanhThu+"vnd");
        ChiemNhap.setText("Chiếm "+String.valueOf(Math.round(percentDT*100)/100)+"% Tổng Tiền Nhập");
        valueUpKho.setText(String.valueOf(Math.round(valueDel*100)/100)+"%");
            
        if(valueDel >= 0){
            valueUpKho.setForeground(new Color(51,153,0));
            iconUpKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow-up.png")));
        }
        else{
            valueUpKho.setForeground(new Color(204,0,0));
            iconUpKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow-down.png")));
        }
    }
    
    private void setPanelSLNhap(String titlePanel, String Soluong){
        
        PnSLNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Số Lượng Nhập "+titlePanel
                    , javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION
                    , javax.swing.border.TitledBorder.DEFAULT_POSITION
                    , new java.awt.Font("Tahoma", 1, 28)
                    , new java.awt.Color(255, 255, 255)));
        
        txtSLNhap.setText(Soluong);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChiemDT;
    private javax.swing.JLabel ChiemNhap;
    private javax.swing.JPanel PnDTMua;
    private javax.swing.JPanel PnHD;
    private javax.swing.JPanel PnSLNhap;
    private javax.swing.JPanel PnTKKho;
    private javax.swing.JPanel PnTKMua;
    private javax.swing.JPanel PnTienNhap;
    private javax.swing.JButton btnTK;
    private javax.swing.JButton btnTKKho;
    private javax.swing.JComboBox<String> cboxQuyDT;
    private javax.swing.JComboBox<String> cboxQuyKho;
    private javax.swing.JComboBox<String> cboxSort;
    private javax.swing.JComboBox<String> cboxSortKho;
    private javax.swing.JLabel iconUp;
    private javax.swing.JLabel iconUpKho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser ngayTKThang;
    private javax.swing.JTable tblTKSP;
    private javax.swing.JTable tblTKSPKho;
    private javax.swing.JLabel txtDoanhThu;
    private javax.swing.JLabel txtSLHD;
    private javax.swing.JSpinner txtSLKho;
    private javax.swing.JLabel txtSLNhap;
    private javax.swing.JSpinner txtSoLuong;
    private com.toedter.calendar.JDateChooser txtThang;
    private javax.swing.JLabel txtTienNhap;
    private javax.swing.JLabel valueUp;
    private javax.swing.JLabel valueUpKho;
    // End of variables declaration//GEN-END:variables
}
