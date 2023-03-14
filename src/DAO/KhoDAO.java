/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhoDTO;
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
public class KhoDAO {

    private ArrayList<KhoDTO> dskho = new ArrayList<>();
    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();

    public ArrayList<KhoDTO> getListKho() {
        try {
            ArrayList<KhoDTO> dskho = new ArrayList<>();
            String sql = "SELECT * FROM kho";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                KhoDTO kho = new KhoDTO(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getInt("GiaNhap"),
                        rs.getString("DonViTinh"),
                        rs.getString("MaLoai"),
                        rs.getString("IMG")
                );
                dskho.add(kho);
            }
            return dskho;
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    
    //Hàm này dùng cho trường hợp sau khi thêm sản phẩm vào giỏ hàng thì sản phẩm tự giảm đúng số lượng đã thêm
    public void capNhatSoLuongSP(String MaSP, int SoLuongNhap, int SoLuongTrongKho) {
        try {
            String sql = "UPDATE kho SET SoLuong=? WHERE MaSP= ?" ;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (SoLuongNhap+SoLuongTrongKho));
            statement.setString(2,MaSP);
            statement.executeUpdate();
        } catch (SQLException e) {
        } finally {
            mySQL.Disconnect();
        }

    }

}
