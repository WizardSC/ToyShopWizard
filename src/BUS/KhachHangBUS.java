/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class KhachHangBUS {
    private ArrayList<KhachHangDTO> listKhachHang = null;
    public KhachHangDAO khDAO = new KhachHangDAO();
    public void docDanhSach(){
        this.listKhachHang = khDAO.getListKhachHang();
    }
    public ArrayList<KhachHangDTO> getListKhachHang(){
        return listKhachHang;
    }
}
