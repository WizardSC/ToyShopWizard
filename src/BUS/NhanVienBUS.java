/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.io.File;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class NhanVienBUS {

    private ArrayList<NhanVienDTO> listNhanVien = null;
    public NhanVienDAO nvDAO = new NhanVienDAO();

    public void docDanhSach() {
        this.listNhanVien = nvDAO.getListNhanVien();
    }

    public void docDanhSachTheoMaCV(String MaCV) {
        this.listNhanVien = nvDAO.getListNhanVienTheoMaCV(MaCV);
    }

    public ArrayList<NhanVienDTO> getListNhanVien() {
        return listNhanVien;
    }

    public ArrayList<NhanVienDTO> getListNhanVienTheoMaCV(String MaCV) {
        return listNhanVien;
    }

    public void add(NhanVienDTO nv) {
        listNhanVien.add(nv);
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvDAO.insertNhanVien(nv);
    }

    public void delete(String MaNV) {
        for (NhanVienDTO nv : listNhanVien) {
            if (nv.getMaNV().equals(MaNV)) {
                listNhanVien.remove(nv);
                NhanVienDAO nvDAO = new NhanVienDAO();
                try {
                    nvDAO.deleteNhanVien(MaNV);
                } catch (SQLIntegrityConstraintViolationException e) {
                    JOptionPane.showMessageDialog(null, "Không thể xóa nhân viên vì đã có dữ liệu liên quan đến nhân viên này trong cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }

    public void updates(NhanVienDTO nv) {
        for (int i = 0; i < listNhanVien.size(); i++) {
            System.out.println(listNhanVien.get(i).getMaNV());
            if (listNhanVien.get(i).getMaNV().equals(nv.getMaNV())) {
                listNhanVien.set(i, nv);
                // NhanVienDAO nvDao = new NhanVienDAO();
                nvDAO.updatesNhanVien(nv);
                return;
            }
        }
    }

    public ArrayList<NhanVienDTO> searchMaNV(String tk) {  // tk có nghĩa là từ khóa
        tk = tk.toLowerCase();
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for (NhanVienDTO nv : listNhanVien) {
            String MaNV = nv.getMaNV().toLowerCase();
            if (MaNV.contains(tk)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public ArrayList<NhanVienDTO> searchHo(String tk) {
        tk = tk.toLowerCase();
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for (NhanVienDTO nv : listNhanVien) {
            String Ho = nv.getHo().toLowerCase();
            if (Ho.contains(tk)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public ArrayList<NhanVienDTO> searchTen(String tk) {
        tk = tk.toLowerCase();
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for (NhanVienDTO nv : listNhanVien) {
            String Ten = nv.getTen().toLowerCase();
            if (Ten.contains(tk)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public void ExportExcel() {
        nvDAO.ExportExcel();
    }

    public void ImportExcel(File file) {
        nvDAO.ImportExcel(file);
    }

    public void listNV() {
        NhanVienDAO nvDAO = new NhanVienDAO();
        listNhanVien = new ArrayList<>();
        listNhanVien = nvDAO.getListNhanVien();
    }
}
