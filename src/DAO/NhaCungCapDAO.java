/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhaCungCapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wizardsc
 */
public class NhaCungCapDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();
    private ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();

    public ArrayList<NhaCungCapDTO> getListNhaCungCap() {
        try {
            ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
            String sql = "SELECT * FROM nhacungcap";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO(
                        rs.getString("MaNCC"),
                        rs.getString("TenNCC"),
                        rs.getString("DiaChi"),
                        rs.getString("SoDT")
                );
                dsncc.add(ncc);
            }
            return dsncc;
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public void insertNhaCungCap(NhaCungCapDTO ncc) {
        try {
            String sql = "INSERT INTO nhacungcap VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ncc.getMaNCC());
            ps.setString(2, ncc.getTenNCC());
            ps.setString(3, ncc.getDiaChi());
            ps.setString(4, ncc.getSoDT());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
    }

    public void updateNhaCungCap(NhaCungCapDTO ncc) {
        try {
            String sql = "UPDATE nhacungcap SET TenNCC = ?, DiaChi = ?, SoDT = ? WHERE MaNCC = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getDiaChi());
            ps.setString(3, ncc.getSoDT());
            ps.setString(4, ncc.getMaNCC());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }

    }

    public void deleteNhaCungCap(String MaNCC) throws SQLException, SQLIntegrityConstraintViolationException {
        try {
            String sql = "DELETE FROM nhacungcap WHERE MaNCC = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, MaNCC);
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw e;
        }
    }
}
