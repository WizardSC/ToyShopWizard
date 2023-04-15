/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class TaiKhoanDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private Connection connection = mySQL.getConnection();
    private ArrayList<TaiKhoanDTO> dstk = new ArrayList<>();

    public ArrayList<TaiKhoanDTO> getListTaiKhoan() {
        try {
            ArrayList<TaiKhoanDTO> dstk = new ArrayList<>();
            String sql = "SELECT * FROM taikhoan ";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO(
                        rs.getString("MaNV"),
                        rs.getString("TenDangNhap"),
                        rs.getString("MatKhau"),
                        rs.getString("PhanQuyen"),
                        rs.getBoolean("TinhTrang")
                );
                dstk.add(tk);
            }
            return dstk;

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;

    }
    
    public ArrayList<TaiKhoanDTO> getListMaNVChuaCoTK(){
        try {
            ArrayList<TaiKhoanDTO> dstk = new ArrayList<>();
//            String sql = "SELECT MaNV from nhanvien where nhanvien.MaNV not in (select MaNV from taikhoan) ORDER BY nhanvien.manv asc";
            String sql = "CALL sp_get_nhanvien_without_taikhoan();"; //Thực thi stored procedure
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next()){
                TaiKhoanDTO tk = new TaiKhoanDTO(
                        rs.getString("MaNV")
                );
                dstk.add(tk);
                    }
            return dstk;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public insertTaiKhoan(TaiKhoanDTO tk){
//        String sql = "INSERT INTO taikhoan VALUES(?,?,?,"
//    }
}
