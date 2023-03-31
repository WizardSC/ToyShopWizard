/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

}
