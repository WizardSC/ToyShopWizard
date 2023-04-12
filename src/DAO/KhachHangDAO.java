/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHangDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author wizardsc
 */
public class KhachHangDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<KhachHangDTO> dskh = new ArrayList<>();
    private Connection connection = mySQL.getConnection();

    public ArrayList<KhachHangDTO> getListKhachHang() {
        try {
            ArrayList<KhachHangDTO> dskh = new ArrayList<>();
            String sql = "SELECT * FROM khachhang";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                KhachHangDTO kh = new KhachHangDTO(
                        rs.getString("MaKH"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getString("NgaySinh"),
                        rs.getString("GioiTinh"),
                        rs.getString("DiaChi"),
                        rs.getString("SoDT"),
                        rs.getString("IMG")
                );
                dskh.add(kh);
            }
            return dskh;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public void insertKhachHang(KhachHangDTO kh) {
        try {
            String sql = "INSERT INTO khachhang VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getHo());
            ps.setString(3, kh.getTen());
            ps.setString(4, kh.getNgaySinh());
            ps.setString(5, kh.getGioiTinh());
            ps.setString(6, kh.getDiaChi());
            ps.setString(7, kh.getSoDT());
            ps.setString(8, kh.getIMG());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }

    }

    public void updateKhachHang(KhachHangDTO kh) {
        try {
            String sql = "UPDATE khachhang SET Ho = ?, Ten = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, SoDT = ?, IMG = ?"
                    + "WHERE MaKH = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, kh.getHo());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getNgaySinh());
            ps.setString(4, kh.getGioiTinh());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getSoDT());
            ps.setString(7, kh.getIMG());
            ps.setString(8, kh.getMaKH());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                String MaKH = row.getCell(0).getStringCellValue();
                String Ho = row.getCell(1).getStringCellValue();
                String Ten = row.getCell(2).getStringCellValue();
                String NgaySinh = row.getCell(3).getStringCellValue();
                String GioiTinh = row.getCell(4).getStringCellValue();
                String DiaChi = row.getCell(5).getStringCellValue();
                String SoDT = row.getCell(6).getStringCellValue();
                String IMG = row.getCell(7).getStringCellValue();
                String sql_check = "SELECT * FROM khachhang WHERE MaKH='" + MaKH + "'";
                ResultSet rs = mySQL.executeQuery(sql_check);
                if (!rs.next()) {
                    String sql = "INSERT INTO khachhang VALUES(?,?,?,?,?,?,?,?)";
                    PreparedStatement pstatement = connection.prepareStatement(sql);
                    pstatement.setString(1, MaKH);
                    pstatement.setString(2, Ho);
                    pstatement.setString(3, Ten);
                    pstatement.setString(4, NgaySinh);
                    pstatement.setString(5, GioiTinh);
                    pstatement.setString(6, DiaChi);
                    pstatement.setString(7, SoDT);
                    pstatement.setString(8, IMG);
                    pstatement.executeUpdate();

                    System.out.println(sql);

                } else {
                    String sql = "UPDATE khachhang SET Ho = ?, Ten = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, SoDT = ?, IMG = ? WHERE MaKH = ?";
                    PreparedStatement pstatement = connection.prepareStatement(sql);

                    pstatement.setString(1, Ho);
                    pstatement.setString(2, Ten);
                    pstatement.setString(3, NgaySinh);
                    pstatement.setString(4, GioiTinh);
                    pstatement.setString(5, DiaChi);
                    pstatement.setString(6, SoDT);
                    pstatement.setString(7, IMG);
                    pstatement.setString(8, MaKH);
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
}
