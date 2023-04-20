/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import DTO.SanPham_ViTriDTO;
import MyCustom.XuLyException;
import java.io.File;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wizardsc
 */
public class SanPhamBUS {

    private ArrayList<SanPhamDTO> listSanPham = null;
    private ArrayList<SanPham_ViTriDTO> listSPCuaHang = null;
    private SanPhamDAO spDAO = new SanPhamDAO();

    public void docDanhSach() {
        this.listSanPham = spDAO.getListSanPham();

    }

    public void listSP() {
        SanPhamDAO spDAO = new SanPhamDAO();

        listSanPham = new ArrayList<>();
        listSanPham = spDAO.getListSanPham();
    }
//    public void docDanhSach1(){
//        this.listSPCuaHang = spDAO.getListSanPhamCuaHang();
//    }

    public ArrayList<SanPhamDTO> getListSanPham() {
        return listSanPham;
    }

    public ArrayList<SanPham_ViTriDTO> getListSPCuahang() {
        return listSPCuaHang;
    }

    public void add(SanPhamDTO sp) {
        listSanPham.add(sp);
        spDAO.insertSanPham(sp);
    }

    public void update(SanPhamDTO sp) {
        for (int i = 0; i < listSanPham.size(); i++) {
            if (listSanPham.get(i).getMaSP().equals(sp.getMaSP())) {
                listSanPham.set(i, sp);
                SanPhamDAO spDAO = new SanPhamDAO();
                spDAO.updateSanPham(sp);
                return;
            }
        }
    }

    public void delete(String MaSP) throws XuLyException {
        for (SanPhamDTO sp : listSanPham) {
            if (sp.getMaSP().equals(MaSP)) {
                listSanPham.remove(sp);
                try {
                    spDAO.deleteSanPham(MaSP);
                } catch (SQLIntegrityConstraintViolationException e) {
                    throw new XuLyException("Không thể xóa sản phẩm vì đã có dữ liệu liên quan đến sản phẩm này trong cơ sở dữ liệu.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }

    public void capNhatSoLuongHD(String MaSP, int SoLuongMua, int SoLuongTrongKho) {

        spDAO.capNhatSoLuongHD(MaSP, SoLuongMua, SoLuongTrongKho);

    }

    public void importExcel(File file) {
        spDAO.ImportExcel(file);
    }

    public void ExportExcel() {
        spDAO.ExportExcel();
    }
}
