/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SanPhamDTO;
import DTO.SanPham_ViTriDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.commons.compress.utils.Lists.newArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author wizardsc
 */
public class SanPhamDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<SanPhamDTO> dssp = new ArrayList<>();
    private Connection connection = mySQL.getConnection();

    public ArrayList<SanPhamDTO> getListSanPham() {
        try {
            ArrayList<SanPhamDTO> dssp = new ArrayList<>();
            String sql = "SELECT * FROM sanpham";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                SanPhamDTO sp = new SanPhamDTO(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getString("DonViTinh"),
                        rs.getString("MaLoai"),
                        rs.getString("IMG")
                );
                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    public ArrayList<SanPhamDTO> getListSanPhamKho() {
        try {
            ArrayList<SanPhamDTO> dssp = new ArrayList<>();
            String sql = "SELECT * FROM sanpham";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                SanPhamDTO sp = new SanPhamDTO(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getString("DonViTinh"),
                        rs.getString("MaLoai"),
                        rs.getString("IMG")
                );
                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    public ArrayList<SanPham_ViTriDTO> getListSanPhamCuaHang() {
        try {
            ArrayList<SanPham_ViTriDTO> dssp = new ArrayList<>();
             String sql = "select sp.MaSP, sp.TenSP, spvt.SoLuong, spvt.DonGia, sp.DonViTinh, sp.MaLoai, sp.IMG from sanpham as sp join sanpham_vitri as spvt on spvt.MaSP = sp.MaSP";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                SanPham_ViTriDTO sp = new SanPham_ViTriDTO(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getString("DonViTinh"),
                        rs.getString("MaLoai"),
                        rs.getString("IMG")
                );
                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

   

    public void insertSanPham(SanPhamDTO sp) {
        try {
            String sql = "INSERT INTO sanpham VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setInt(3, sp.getSoLuong());
            ps.setInt(4, sp.getDonGia());
            ps.setString(5, sp.getDonViTinh());
            ps.setString(6, sp.getMaLoai());
            ps.setString(7, sp.getIMG());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        
    }

    public void updateSanPham(SanPhamDTO sp) {
        try {
            String sql = "UPDATE sanpham SET TenSP = ?, SoLuong = ?, DonGia = ?, DonViTinh = ?, MaLoai = ?, IMG = ? WHERE MaSP = ?";
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, sp.getTenSP());
            pstatement.setInt(2, sp.getSoLuong());
            pstatement.setInt(3, sp.getDonGia());
            pstatement.setString(4, sp.getDonViTinh());
            pstatement.setString(5, sp.getMaLoai());
            pstatement.setString(6, sp.getIMG());
            pstatement.setString(7, sp.getMaSP());
            pstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }

    }

    public void deleteSanPham(String MaSP) {
        String queryDeleteSanPham = "DELETE FROM sanpham WHERE MaSP = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(queryDeleteSanPham);

            pre.setString(1, MaSP);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Hàm này dùng cho trường hợp sau khi thêm sản phẩm vào giỏ hàng thì sản phẩm tự giảm đúng số lượng đã thêm
    public void capNhatSoLuongHD(String MaSP, int SoLuongMua, int SoLuongTrongKho) {
        try {
            String sql = "UPDATE sanpham SET SoLuong=? WHERE MaSP= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (SoLuongMua + SoLuongTrongKho));
            statement.setString(2, MaSP);
            statement.executeUpdate();
        } catch (SQLException e) {
        } finally {
            mySQL.Disconnect();
        }

    }
    
    
    public void ImportExcel(File file) {

        try {

            FileInputStream in = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(0);
            org.apache.poi.ss.usermodel.Row row;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                String MaSP = row.getCell(0).getStringCellValue();
                String TenSP = row.getCell(1).getStringCellValue();
                int SoLuong = (int) row.getCell(2).getNumericCellValue();
                int GiaNhap = (int) row.getCell(3).getNumericCellValue();
                String DonViTinh = row.getCell(4).getStringCellValue();
                String MaLoai = row.getCell(5).getStringCellValue();
                String IMG = row.getCell(6).getStringCellValue();
//            
                String sql_check = "SELECT * FROM sanpham WHERE MaSP='" + MaSP + "'";
                ResultSet rs = mySQL.executeQuery(sql_check);
                if (!rs.next()) {
                    String sql = "INSERT INTO sanpham VALUES(?,?,?,?,?,?,?)";
                    PreparedStatement pstatement = connection.prepareStatement(sql);
                    pstatement.setString(1, MaSP);
                    pstatement.setString(2, TenSP);
                    pstatement.setInt(3, SoLuong);
                    pstatement.setInt(4, GiaNhap);
                    pstatement.setString(5, DonViTinh);
                    pstatement.setString(6, MaLoai);
                    pstatement.setString(7, IMG);
                    pstatement.executeUpdate();

                    System.out.println(sql);

                } else {
                    String sql = "UPDATE sanpham SET TenSP = ?, SoLuong = ?, DonGia = ?, DonViTinh = ?, MaLoai = ?, IMG = ? WHERE MaSP = ?";
                    PreparedStatement pstatement = connection.prepareStatement(sql);

                    
                    pstatement.setString(1, TenSP);
                    pstatement.setInt(2, SoLuong);
                    pstatement.setInt(3, GiaNhap);
                    pstatement.setString(4, DonViTinh);
                    pstatement.setString(5, MaLoai);
                    pstatement.setString(6, IMG);
                    pstatement.setString(7, MaSP);
                    pstatement.executeUpdate();

                    System.out.println(sql);

                }
            }
            in.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ExportExcel() {

        try {

            String sql = "SELECT * FROM sanpham";
            ResultSet rs = mySQL.executeQuery(sql);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("SanPham");

            XSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short) 14);
            font.setBold(true);

            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);

            XSSFRow row = sheet.createRow(0);
            XSSFCell cell;

            cell = row.createCell(0);
            cell.setCellValue("MaSP");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("TenSP");
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue("SoLuong");
            cell.setCellStyle(style);
            cell = row.createCell(3);
            cell.setCellValue("DonGia");
            cell.setCellStyle(style);
            cell = row.createCell(4);
            cell.setCellValue("DonViTinh");
            cell.setCellStyle(style);
            cell = row.createCell(5);
            cell.setCellValue("MaLoai");
            cell.setCellStyle(style);
            cell = row.createCell(6);
            cell.setCellValue("IMG");
            cell.setCellStyle(style);
            
            int i = 1;

            while (rs.next()) {
                row = sheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(rs.getString("MaSP"));
                cell = row.createCell(1);
                cell.setCellValue(rs.getString("TenSP"));
                cell = row.createCell(2);
                cell.setCellValue(rs.getInt("SoLuong"));
                cell = row.createCell(3);
                cell.setCellValue(rs.getInt("DonGia"));
                cell = row.createCell(4);
                cell.setCellValue(rs.getString("DonViTinh"));
                cell = row.createCell(5);
                cell.setCellValue(rs.getString("MaLoai"));
                cell = row.createCell(6);
                cell.setCellValue(rs.getString("IMG"));
             
                i++;
            }
            for (int colNum = 0; colNum < row.getLastCellNum(); colNum++) {
                sheet.autoSizeColumn((short) (colNum));
            }

            FileOutputStream out = new FileOutputStream(new File("./reports/SanPham.xlsx"));
            workbook.write(out);
            out.close();

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
