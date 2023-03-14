/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTHoaDonDTO;
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
public class CTHoaDonDAO {
    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<CTHoaDonDTO> dscthd = new ArrayList<>();
    private Connection connection = mySQL.getConnection();

    public ArrayList<CTHoaDonDTO> getListCTHoaDon() {
        try {
            ArrayList<CTHoaDonDTO> dscthd = new ArrayList<>();
            String sql = "SELECT * FROM cthoadon";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                CTHoaDonDTO cthd = new CTHoaDonDTO(
                        rs.getString("MaHD"),
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getInt("ThanhTien"));
                dscthd.add(cthd);
            }
            return dscthd;
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    public void insertHoaDon(CTHoaDonDTO cthd) {
        try {
            String sql = "INSERT INTO cthoadon VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cthd.getMaHD());
            statement.setString(2, cthd.getMaSP());
            statement.setString(3, cthd.getTenSP());
            statement.setInt(4, cthd.getSoLuong());
            statement.setInt(5, cthd.getDonGia());
            statement.setInt(6, cthd.getThanhTien());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }

    }
}
