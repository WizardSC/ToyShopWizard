/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChucVuDTO;
import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
