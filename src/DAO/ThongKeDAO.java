package DAO;

import DTO.CTHoaDonDTO;
import DTO.KhoDTO;
import java.sql.CallableStatement;
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
            + "GROUP BY MaSP ORDER BY TongSL VAR3 VAR4";

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
                    + "WHERE hd.MaHD=cthd.MaHD AND NgayLap BETWEEN '" + arrDate[0] + "' AND '" + arrDate[1] + "' "
                    + "GROUP BY MaSP ORDER BY TongSL " + sort + " " + limit;

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
            String sql_per = "(((SELECT SUM(TongTien) FROM hoadon WHERE Month(NgayLap)=" + arrDate[0] + " AND Year(NgayLap)=" + arrDate[1] + ") "
                    + "- (SELECT SUM(TongTien) FROM hoadon WHERE Month(NgayLap)=" + arrDate[2] + " AND Year(NgayLap)=" + arrDate[3] + "))"
                    + "/ (SELECT SUM(TongTien) FROM hoadon WHERE Month(NgayLap)=" + arrDate[2] + " AND Year(NgayLap)=" + arrDate[3] + "))*100 AS Tang";

            String sql = "SELECT SUM(TongTien) as DoanhThu, "
                    + "(SELECT SUM(TongTien) FROM hoadon WHERE Month(NgayLap)=" + arrDate[0] + " AND Year(NgayLap)=" + arrDate[1] + ")"
                    + "/"
                    + "(SELECT SUM(TongTien) FROM hoadon)*100 AS ChiemTongDT, " + sql_per + " "
                    + "FROM hoadon WHERE Month(NgayLap)=" + arrDate[0] + " AND Year(NgayLap)=" + arrDate[1];

            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("DoanhThu") != null) {
                    dsDT.add(rs.getBigDecimal("DoanhThu").toBigInteger());
                } else {
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
            String sql_per = "(((SELECT SUM(TongTien) FROM hoadon WHERE NgayLap BETWEEN '" + arrDate[0] + "' AND '" + arrDate[1] + "') "
                    + "- (SELECT SUM(TongTien) FROM hoadon WHERE NgayLap BETWEEN '" + arrDate[2] + "' AND '" + arrDate[3] + "'))"
                    + "/ (SELECT SUM(TongTien) FROM hoadon WHERE NgayLap BETWEEN '" + arrDate[2] + "' AND '" + arrDate[3] + "'))*100 AS Tang";

            String sql = "SELECT SUM(TongTien) as DoanhThu, "
                    + "(SELECT SUM(TongTien) FROM hoadon WHERE NgayLap BETWEEN '" + arrDate[0] + "' AND '" + arrDate[1] + "')"
                    + "/"
                    + "(SELECT SUM(TongTien) FROM hoadon)*100 AS ChiemTongDT, " + sql_per + " "
                    + "FROM hoadon WHERE NgayLap BETWEEN '" + arrDate[0] + "' AND '" + arrDate[1] + "'";

            System.out.println(sql);
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("DoanhThu") != null) {
                    dsDT.add(rs.getBigDecimal("DoanhThu").toBigInteger());
                } else {
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
//            String sql = "CALL sp_getSoLuongHoaDon(" + thang + ", " + nam + ", @soLuong)";
////        
//            System.out.println(sql);
            Integer count = 0;
            ResultSet rs = mySQL.executeQuery(sql);
//            ResultSet rs1 = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("SoLuong") != null) {
                    count = rs.getInt("SoLuong");
                } else {
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
            String sql = "SELECT COUNT(MaHD) AS SoLuong FROM hoadon WHERE NgayLap BETWEEN '" + dateStart + "' AND '" + dateEnd + "'";
            System.out.println(sql);
            Integer count = 0;
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("SoLuong") != null) {
                    count = rs.getInt("SoLuong");
                } else {
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

    // Thong Ke Kho
    public ArrayList<Object> getTienNhap(String[] arrDate) {
        try {
            ArrayList<Object> dsDT = new ArrayList<>();
            String sql_per = "(((SELECT SUM(TongTien) FROM phieunhap WHERE Month(NgayLap)=" + arrDate[0] + " AND Year(NgayLap)=" + arrDate[1] + ") "
                    + "- (SELECT SUM(TongTien) FROM phieunhap WHERE Month(NgayLap)=" + arrDate[2] + " AND Year(NgayLap)=" + arrDate[3] + "))"
                    + "/ (SELECT SUM(TongTien) FROM phieunhap WHERE Month(NgayLap)=" + arrDate[2] + " AND Year(NgayLap)=" + arrDate[3] + "))*100 AS Tang";

            String sql = "SELECT SUM(TongTien) as TienNhap, "
                    + "(SELECT SUM(TongTien) FROM phieunhap WHERE Month(NgayLap)=" + arrDate[0] + " AND Year(NgayLap)=" + arrDate[1] + ")"
                    + "/"
                    + "(SELECT SUM(TongTien) FROM phieunhap)*100 AS ChiemTongTN, " + sql_per + " "
                    + "FROM phieunhap WHERE Month(NgayLap)=" + arrDate[0] + " AND Year(NgayLap)=" + arrDate[1];

            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("TienNhap") != null) {
                    dsDT.add(rs.getBigDecimal("TienNhap").toBigInteger());
                } else {
                    dsDT.add(0);
                }
                dsDT.add(rs.getDouble("ChiemTongTN"));
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

    public ArrayList<Object> getTienXuat(String[] arrDate) {
        try {
            ArrayList<Object> dsDT = new ArrayList<>();
            String sql_per = "(((SELECT SUM(TongTien) FROM phieuxuat WHERE Month(NgayLap)=" + arrDate[0] + " AND Year(NgayLap)=" + arrDate[1] + ") "
                    + "- (SELECT SUM(TongTien) FROM phieuxuat WHERE Month(NgayLap)=" + arrDate[2] + " AND Year(NgayLap)=" + arrDate[3] + "))"
                    + "/ (SELECT SUM(TongTien) FROM phieuxuat WHERE Month(NgayLap)=" + arrDate[2] + " AND Year(NgayLap)=" + arrDate[3] + "))*100 AS Tang";

            String sql = "SELECT SUM(TongTien) as TienXuat, "
                    + "(SELECT SUM(TongTien) FROM phieuxuat WHERE Month(NgayLap)=" + arrDate[0] + " AND Year(NgayLap)=" + arrDate[1] + ")"
                    + "/"
                    + "(SELECT SUM(TongTien) FROM phieuxuat)*100 AS ChiemTongTX, " + sql_per + " "
                    + "FROM phieuxuat WHERE Month(NgayLap)=" + arrDate[0] + " AND Year(NgayLap)=" + arrDate[1];

            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("TienXuat") != null) {
                    dsDT.add(rs.getBigDecimal("TienXuat").toBigInteger());
                } else {
                    dsDT.add(0);
                }
                dsDT.add(rs.getDouble("ChiemTongTX"));
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

    public Integer getSLNhap(String thang, String nam) {
        try {
            String sql = "SELECT SUM(SoLuong) AS SoLuong FROM phieunhap pn,ctphieunhap ct WHERE pn.MaPN=ct.MaPN AND "
                    + "Month(NgayLap)=" + thang + " AND Year(NgayLap)=" + nam;
            System.out.println(sql);
            Integer count = 0;
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("SoLuong") != null) {
                    count = rs.getInt("SoLuong");
                } else {
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

    public Integer getSLXuat(String thang, String nam) {
        try {
            String sql = "SELECT SUM(SoLuong) AS SoLuong FROM phieuxuat px,ctphieuxuat ct WHERE px.MaPX=ct.MaPX AND "
                    + "Month(NgayLap)=" + thang + " AND Year(NgayLap)=" + nam;
            System.out.println(sql);
            Integer count = 0;
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("SoLuong") != null) {
                    count = rs.getInt("SoLuong");
                } else {
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

    public ArrayList<KhoDTO> getDLSPKho(String limit, String sort) {
        try {
            ArrayList<KhoDTO> dstkSPKho = new ArrayList<>();
            String sql = "SELECT MaSP, TenSP, SoLuong FROM kho"
                    + " WHERE SoLuong > 0"
                    + " ORDER BY SoLuong " + sort + " " + limit;

            ResultSet rs = mySQL.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
                KhoDTO sp = new KhoDTO(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong")
                );
                dstkSPKho.add(sp);
            }
            return dstkSPKho;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public ArrayList<Object> getTienNhapQuy(String[] arrDate) {
        try {
            ArrayList<Object> dsTN = new ArrayList<>();
            String sql_per = "(((SELECT SUM(TongTien) FROM phieunhap WHERE NgayLap BETWEEN '" + arrDate[0] + "' AND '" + arrDate[1] + "') "
                    + "- (SELECT SUM(TongTien) FROM phieunhap WHERE NgayLap BETWEEN '" + arrDate[2] + "' AND '" + arrDate[3] + "'))"
                    + "/ (SELECT SUM(TongTien) FROM phieunhap WHERE NgayLap BETWEEN '" + arrDate[2] + "' AND '" + arrDate[3] + "'))*100 AS Tang";

            String sql = "SELECT SUM(TongTien) as TienNhap, "
                    + "(SELECT SUM(TongTien) FROM phieunhap WHERE NgayLap BETWEEN '" + arrDate[0] + "' AND '" + arrDate[1] + "')"
                    + "/"
                    + "(SELECT SUM(TongTien) FROM phieunhap)*100 AS ChiemTN, " + sql_per + " "
                    + "FROM phieunhap WHERE NgayLap BETWEEN '" + arrDate[0] + "' AND '" + arrDate[1] + "'";

            System.out.println(sql);
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("TienNhap") != null) {
                    dsTN.add(rs.getBigDecimal("TienNhap").toBigInteger());
                } else {
                    dsTN.add(0);
                }
                dsTN.add(rs.getDouble("ChiemTN"));
                dsTN.add(rs.getDouble("Tang"));
            }
            return dsTN;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public ArrayList<Object> getTienXuatQuy(String[] arrDate) {
        try {
            ArrayList<Object> dsTN = new ArrayList<>();
            String sql_per = "(((SELECT SUM(TongTien) FROM phieuxuat WHERE NgayLap BETWEEN '" + arrDate[0] + "' AND '" + arrDate[1] + "') "
                    + "- (SELECT SUM(TongTien) FROM phieuxuat WHERE NgayLap BETWEEN '" + arrDate[2] + "' AND '" + arrDate[3] + "'))"
                    + "/ (SELECT SUM(TongTien) FROM phieuxuat WHERE NgayLap BETWEEN '" + arrDate[2] + "' AND '" + arrDate[3] + "'))*100 AS Tang";

            String sql = "SELECT SUM(TongTien) as TienXuat, "
                    + "(SELECT SUM(TongTien) FROM phieuxuat WHERE NgayLap BETWEEN '" + arrDate[0] + "' AND '" + arrDate[1] + "')"
                    + "/"
                    + "(SELECT SUM(TongTien) FROM phieuxuat)*100 AS ChiemTX, " + sql_per + " "
                    + "FROM phieuxuat WHERE NgayLap BETWEEN '" + arrDate[0] + "' AND '" + arrDate[1] + "'";

            System.out.println(sql);
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("TienXuat") != null) {
                    dsTN.add(rs.getBigDecimal("TienXuat").toBigInteger());
                } else {
                    dsTN.add(0);
                }
                dsTN.add(rs.getDouble("ChiemTX"));
                dsTN.add(rs.getDouble("Tang"));
            }
            return dsTN;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.Disconnect();
        }
        return null;
    }

    public Integer getSLNhapQuy(String dateStart, String dateEnd) {
        try {
            String sql = "SELECT SUM(SoLuong) AS SoLuong FROM phieunhap pn,ctphieunhap ct"
                    + " WHERE pn.MaPN=ct.MaPN AND NgayLap BETWEEN '" + dateStart + "' AND '" + dateEnd + "'";
            System.out.println(sql);
            Integer count = 0;
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("SoLuong") != null) {
                    count = rs.getInt("SoLuong");
                } else {
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

    public Integer getSLXuatQuy(String dateStart, String dateEnd) {
        try {
            String sql = "SELECT SUM(SoLuong) AS SoLuong FROM phieuxuat px,ctphieuxuat ct"
                    + " WHERE px.MaPX=ct.MaPX AND NgayLap BETWEEN '" + dateStart + "' AND '" + dateEnd + "'";
            System.out.println(sql);
            Integer count = 0;
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                if (rs.getBigDecimal("SoLuong") != null) {
                    count = rs.getInt("SoLuong");
                } else {
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
