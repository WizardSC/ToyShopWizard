/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChucVuDTO;
import DTO.NhanVienDTO;
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
public class ChucVuDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<ChucVuDTO> dscv = new ArrayList<>();
    private Connection connection = mySQL.getConnection();

    public ArrayList<ChucVuDTO> getListChucVu() {
        try {
            ArrayList<ChucVuDTO> dscv = new ArrayList<>();
            String sql = "SELECT * FROM chucvu";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                ChucVuDTO cv = new ChucVuDTO(
                        rs.getString("MaCV"),
                        rs.getString("TenCV"));

                dscv.add(cv);
            }
            return dscv;
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public void insertChucVu(ChucVuDTO cv) {
        try {
            String sql = "INSERT INTO chucvu VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cv.getMaCV());
            ps.setString(2, cv.getTenCV());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateChucVu(ChucVuDTO cv) {
        try {
            String sql = "UPDATE chucvu SET TenCV = ? where MaCV = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cv.getTenCV());
            ps.setString(2, cv.getMaCV());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteChucVu(String MaCV) throws SQLException, SQLIntegrityConstraintViolationException {
        try {
            String sql = "DELETE FROM chucvu WHERE MaCV = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, MaCV);
            ps.executeUpdate();
        } catch(SQLIntegrityConstraintViolationException e){
            throw e;
        } 

    }
}
