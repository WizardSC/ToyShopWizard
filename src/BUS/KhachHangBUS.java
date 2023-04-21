/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import MyCustom.XuLyException;
import java.io.File;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class KhachHangBUS {

    private ArrayList<KhachHangDTO> listKhachHang = null;
    public KhachHangDAO khDAO = new KhachHangDAO();

    public void docDanhSach() {
        this.listKhachHang = khDAO.getListKhachHang();
    }

    public ArrayList<KhachHangDTO> getListKhachHang() {
        return listKhachHang;
    }
    public void docDanhSach1(String MaKH) {
        this.listKhachHang = khDAO.getListThongTinKhachHang(MaKH);
    }

    public ArrayList<KhachHangDTO> getListThongTinKhachHang() {
        return listKhachHang;
    }

    public void listKH() {
        KhachHangDAO khDAO = new KhachHangDAO();

        listKhachHang = new ArrayList<>();
        listKhachHang = khDAO.getListKhachHang();
    }

    public void add(KhachHangDTO kh) {
        listKhachHang.add(kh);
        KhachHangDAO khDAO = new KhachHangDAO();
        khDAO.insertKhachHang(kh);
    }

    public void update(KhachHangDTO kh) {
        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getMaKH().equals(kh.getMaKH())) {
                listKhachHang.set(i, kh);
                khDAO.updateKhachHang(kh);
                return;
            }
        }
    }

    public void delete(String MaKH) throws XuLyException {
        for (KhachHangDTO kh : listKhachHang) {
            if (kh.getMaKH().equals(MaKH)) {
                try {
                    listKhachHang.remove(kh);
                    khDAO.deleteKhachHang(MaKH);
                } catch (SQLIntegrityConstraintViolationException e) {
                    throw new XuLyException("Không thể xóa khách hàng vì đã có dữ liệu liên quan đến khách hàng này trong cơ sở dữ liệu.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;

            }
        }
    }

    public void ImportExcel(File file) {
        khDAO.ImportExcel(file);
    }

    public void ExportExcel() {
        khDAO.ExportExcel();
    }
}
