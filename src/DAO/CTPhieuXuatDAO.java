/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTPhieuXuatDTO;
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
public class CTPhieuXuatDAO {
    ArrayList<CTPhieuXuatDTO> dsctpx = new ArrayList<>();
    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();

    public ArrayList<CTPhieuXuatDTO> getListCTPX() {
        try {
            ArrayList<CTPhieuXuatDTO> dsctpx = new ArrayList<>();
            String sql = "SELECT * FROM ctphieuxuat";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                CTPhieuXuatDTO ctpx = new CTPhieuXuatDTO(
                        rs.getString("MaPX"),
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getInt("ThanhTien")
                );
                dsctpx.add(ctpx);
            }
            return dsctpx;
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    
    public void insertCTPX(CTPhieuXuatDTO ctpx){
        try {
            String sql = "INSERT INTO ctphieuxuat VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,ctpx.getMaPX());
            ps.setString(2,ctpx.getMaSP());
            ps.setString(3,ctpx.getTenSP());
            ps.setInt(4,ctpx.getSoLuong());
            ps.setInt(5,ctpx.getDonGia());
            ps.setInt(6,ctpx.getThanhTien());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        
    } 

    
}
