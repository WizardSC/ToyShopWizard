/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTPhieuNhapDTO;
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
public class CTPhieuNhapDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();

    public ArrayList<CTPhieuNhapDTO> getListCTPN() {
        try {
            ArrayList<CTPhieuNhapDTO> dsctpn = new ArrayList<>();
            String sql = "SELECT * FROM ctphieunhap";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                CTPhieuNhapDTO ctpn = new CTPhieuNhapDTO(
                        rs.getString("MaPN"),
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getInt("ThanhTien")
                );
                dsctpn.add(ctpn);
            }
            return dsctpn;
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public void insertCTPN(CTPhieuNhapDTO ctpn) {
        try {
            String sql = "INSERT INTO ctphieunhap VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ctpn.getMaPN());
            ps.setString(2, ctpn.getMaSP());
            ps.setString(3, ctpn.getTenSP());
            ps.setInt(4, ctpn.getSoLuong());
            ps.setInt(5, ctpn.getDonGia());
            ps.setInt(6, ctpn.getThanhTien());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }

    }
}
