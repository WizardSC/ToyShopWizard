package DAO;

import DTO.CTHoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang
 */
public class ThongKeDAO {

    private MySQLConnect mySQL = new MySQLConnect();
    private ArrayList<CTHoaDonDTO> dstkSP = new ArrayList<>();
    private Connection connection = mySQL.getConnection();

    public ArrayList<CTHoaDonDTO> getDLSP() {
        try {
            ArrayList<CTHoaDonDTO> dstkSP = new ArrayList<>();
            String sql = "SELECT MaSP, TenSP, SUM(SoLuong) as TongSL FROM hoadon hd,cthoadon cthd WHERE hd.MaHD=cthd.MaHD AND NgayLap BETWEEN '2023-03-02' AND '2023-03-10' GROUP BY MaSP ORDER BY TongSL DESC LIMIT 5";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                CTHoaDonDTO hd = new CTHoaDonDTO(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("TongSL")
                );
                dstkSP.add(hd);
            }
            return dstkSP;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public ArrayList<Object> getDoanhThu(String ngayBD, String ngayKT) {
        try {
            ArrayList<Object> dsDT = new ArrayList<>();
            String sql = "SELECT SUM(TongTien) as DoanhThu, "
                    + "(SELECT SUM(TongTien) FROM hoadon WHERE NgayLap BETWEEN '"+ngayBD+"' AND '"+ngayKT+"')"
                    + "/"
                    + "(SELECT SUM(TongTien) FROM hoadon)*100 AS ChiemTongDT "
                    + "FROM hoadon WHERE NgayLap BETWEEN '"+ngayBD+"' AND '"+ngayKT+"'";
            System.out.println(sql);
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if(rs.getBigDecimal("DoanhThu")!=null){
                    dsDT.add(rs.getBigDecimal("DoanhThu").toBigInteger());
                }
                else{
                    dsDT.add(0);
                }
                dsDT.add(rs.getDouble("ChiemTongDT"));
            }
            return dsDT;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
}
