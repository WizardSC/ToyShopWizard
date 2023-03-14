/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuNhapDTO;
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
public class PhieuNhapDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();

    public ArrayList<PhieuNhapDTO> getListPhieuNhap() {
        try {
            ArrayList<PhieuNhapDTO> dspn = new ArrayList<>();
            String sql = "SELECT * FROM phieunhap";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                PhieuNhapDTO pn = new PhieuNhapDTO(
                        rs.getString("MaPN"),
                        rs.getString("MaNCC"),
                        rs.getString("MaNV"),
                        rs.getString("NgayLap"),
                        rs.getInt("TongTien")
                );
                dspn.add(pn);
            }
            return dspn;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    
    public void insertPhieuNhap(PhieuNhapDTO pn){
        try {
            String sql = "INSERT INTO phieunhap VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pn.getMaPN());
            ps.setString(2,pn.getMaNCC());
            ps.setString(3,pn.getMaNV());
            ps.setString(4,pn.getNgayLap());
            ps.setInt(5,pn.getTongTien());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        
    }
}
