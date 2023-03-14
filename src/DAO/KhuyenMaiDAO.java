/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhuyenMaiDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wizardsc
 */
public class KhuyenMaiDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();
    private ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();

    public ArrayList<KhuyenMaiDTO> getListKhuyenMai() {
        try {
            ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
            String sql = "SELECT * FROM khuyenmai";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                KhuyenMaiDTO km = new KhuyenMaiDTO(
                        rs.getString("MaKM"),
                        rs.getString("TenKM"),
                        rs.getInt("PhanTramKM"),
                        rs.getInt("DieuKien"),
                        rs.getDate("NgayBatDau"),
                        rs.getDate("NgayKetThuc")
                );
                dskm.add(km);
            }
            return dskm;
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public void insertKhuyenMai(KhuyenMaiDTO km) {
        try {
            String sql = "INSERT INTO khuyenmai VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, km.getMaKM());
            ps.setString(2, km.getTenKM());
            ps.setInt(3, km.getPhanTramKM());
            ps.setInt(4, km.getDieuKien());
            ps.setTimestamp(5, new Timestamp(km.getNgayBatDau().getTime()));
            ps.setTimestamp(6, new Timestamp(km.getNgayKetThuc().getTime()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteKhuyenMai(String MaKM){
        try {
            String sql = "DELETE FROM khuyenmai WHERE MaKM = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, MaKM);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateKhuyenMai(KhuyenMaiDTO km){
        try {
            String sql = "UPDATE khuyenmai SET TenKM = ?, PhanTramKM = ?, DieuKien = ?, NgayBatDau = ?, NgayKetThuc = ? WHERE MaKM = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, km.getTenKM());
            ps.setInt(2,km.getPhanTramKM());
            ps.setInt(3,km.getDieuKien());
            ps.setTimestamp(4, new Timestamp(km.getNgayBatDau().getTime()));
            ps.setTimestamp(5, new Timestamp(km.getNgayKetThuc().getTime()));
            ps.setString(6, km.getMaKM());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
