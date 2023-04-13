/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoaiDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc Toan
 */
public class LoaiDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<LoaiDTO> dsloai = new ArrayList<>();
    private Connection connection = mySQL.getConnection();

    public ArrayList<LoaiDTO> getListLoai() {
        try {
            String sql = "SELECT * FROM loai";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                LoaiDTO loai = new LoaiDTO(
                        rs.getString("MaLoai"),
                        rs.getString("TenLoai")
                );
                dsloai.add(loai);
            }
            return dsloai;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
