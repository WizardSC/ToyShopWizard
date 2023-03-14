/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuXuatDTO;
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
public class PhieuXuatDAO {
    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();
    public ArrayList<PhieuXuatDTO> getListPhieuXuat() {
        try {
            ArrayList<PhieuXuatDTO> dspx = new ArrayList<>();
            String sql = "SELECT * FROM phieuxuat";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                PhieuXuatDTO px = new PhieuXuatDTO(
                        rs.getString("MaPX"),
                        rs.getString("MaNV"),
                        rs.getString("NgayLap"),
                        rs.getInt("TongTien")
                );
                dspx.add(px);
            }
            return dspx;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    
    public void insertPhieuXuat(PhieuXuatDTO pn){
        try {
            String sql = "INSERT INTO phieuxuat VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pn.getMaPX());
            ps.setString(2,pn.getMaNV());
            ps.setString(3,pn.getNgayLap());
            ps.setInt(4,pn.getTongTien());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        
    }
}
