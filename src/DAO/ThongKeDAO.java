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
    private String sqlSP_Thang = "SELECT MaSP, TenSP, SUM(SoLuong) as TongSL FROM hoadon hd,cthoadon cthd "
            + "WHERE hd.MaHD=cthd.MaHD AND Month(NgayLap)=VAR1 AND Year(NgayLap)=VAR2 " 
            + "GROUP BY MaSP ORDER BY TongSL VAR3 LIMIT VAR4";

    public ArrayList<CTHoaDonDTO> getDLSP(String[] arrDate, String limit, String sort) {
        try {
            ArrayList<CTHoaDonDTO> dstkSP = new ArrayList<>();
            String sql = sqlSP_Thang;
            sql = sql.replace("VAR1", arrDate[0]);
            sql = sql.replace("VAR2", arrDate[1]);
            sql = sql.replace("VAR3", sort);
            sql = sql.replace("VAR4", limit);
            
            ResultSet rs = mySQL.executeQuery(sql);
            System.out.println(sql);
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
    
    public ArrayList<CTHoaDonDTO> getDLSPQuy(String[] arrDate, String limit, String sort) {
        try {
            ArrayList<CTHoaDonDTO> dstkSP = new ArrayList<>();
            String sql = "SELECT MaSP, TenSP, SUM(SoLuong) as TongSL FROM hoadon hd,cthoadon cthd "
            + "WHERE hd.MaHD=cthd.MaHD AND NgayLap BETWEEN '"+arrDate[0]+"' AND '"+arrDate[1]+"' "
            + "GROUP BY MaSP ORDER BY TongSL "+sort+" LIMIT "+limit;
            
            ResultSet rs = mySQL.executeQuery(sql);
            System.out.println(sql);
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
    
    public ArrayList<Object> getDoanhThu(String[] arrDate) {
        try {
            ArrayList<Object> dsDT = new ArrayList<>();
            String sql_per = "(((SELECT SUM(TongTien) FROM hoadon WHERE Month(NgayLap)="+arrDate[0]+" AND Year(NgayLap)="+arrDate[1]+") "
                    + "- (SELECT SUM(TongTien) FROM hoadon WHERE Month(NgayLap)="+arrDate[2]+" AND Year(NgayLap)="+arrDate[3]+"))" +
"/ (SELECT SUM(TongTien) FROM hoadon WHERE Month(NgayLap)="+arrDate[2]+" AND Year(NgayLap)="+arrDate[3]+"))*100 AS Tang";
            
            String sql = "SELECT SUM(TongTien) as DoanhThu, "
                    + "(SELECT SUM(TongTien) FROM hoadon WHERE Month(NgayLap)="+arrDate[0]+" AND Year(NgayLap)="+arrDate[1]+")"
                    + "/"
                    + "(SELECT SUM(TongTien) FROM hoadon)*100 AS ChiemTongDT, "+sql_per+" "
                    + "FROM hoadon WHERE Month(NgayLap)="+arrDate[0]+" AND Year(NgayLap)="+arrDate[1];

            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if(rs.getBigDecimal("DoanhThu")!=null){
                    dsDT.add(rs.getBigDecimal("DoanhThu").toBigInteger());
                }
                else{
                    dsDT.add(0);
                }
                dsDT.add(rs.getDouble("ChiemTongDT"));
                dsDT.add(rs.getDouble("Tang"));
            }
            return dsDT;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public ArrayList<Object> getDoanhThuQuy(String[] arrDate) {
        try {
            ArrayList<Object> dsDT = new ArrayList<>();
            String sql_per = "(((SELECT SUM(TongTien) FROM hoadon WHERE NgayLap BETWEEN '"+arrDate[0]+"' AND '"+arrDate[1]+"') "
                    + "- (SELECT SUM(TongTien) FROM hoadon WHERE NgayLap BETWEEN '"+arrDate[2]+"' AND '"+arrDate[3]+"'))" +
"/ (SELECT SUM(TongTien) FROM hoadon WHERE NgayLap BETWEEN '"+arrDate[2]+"' AND '"+arrDate[3]+"'))*100 AS Tang";
            
            String sql = "SELECT SUM(TongTien) as DoanhThu, "
                    + "(SELECT SUM(TongTien) FROM hoadon WHERE NgayLap BETWEEN '"+arrDate[0]+"' AND '"+arrDate[1]+"')"
                    + "/"
                    + "(SELECT SUM(TongTien) FROM hoadon)*100 AS ChiemTongDT, "+sql_per+" "
                    + "FROM hoadon WHERE NgayLap BETWEEN '"+arrDate[0]+"' AND '"+arrDate[1]+"'";

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
                dsDT.add(rs.getDouble("Tang"));
            }
            return dsDT;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    
    public Integer getSLHoaDon(String thang, String nam) {
        try {
            String sql = "SELECT COUNT(MaHD) AS SoLuong FROM hoadon WHERE Month(NgayLap)="+thang+" AND Year(NgayLap)="+nam;
            System.out.println(sql);
            Integer count = 0;
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if(rs.getBigDecimal("SoLuong")!=null){
                    count = rs.getInt("SoLuong");
                }
                else{
                    count = 0;
                }
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
    public Integer getSLHoaDonQuy(String dateStart, String dateEnd) {
        try {
            String sql = "SELECT COUNT(MaHD) AS SoLuong FROM hoadon WHERE NgayLap BETWEEN '"+dateStart+"' AND '"+dateEnd+"'";
            System.out.println(sql);
            Integer count = 0;
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if(rs.getBigDecimal("SoLuong")!=null){
                    count = rs.getInt("SoLuong");
                }
                else{
                    count = 0;
                }
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }
}
