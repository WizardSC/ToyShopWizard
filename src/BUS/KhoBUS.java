/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhoDAO;
import DAO.SanPhamDAO;
import DTO.KhoDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class KhoBUS {
    private KhoDAO khoDAO = new KhoDAO();
    
    private ArrayList<KhoDTO> listKho = null;
    
    public void docDanhSach(){
        this.listKho = khoDAO.getListKho();
    }
    public ArrayList<KhoDTO> getListKho(){
        return listKho;
    }
    
    public void capNhatSoLuongSP(String MaPN, int SoLuongNhap, int SoLuongTrongKho){
        khoDAO.capNhatSoLuongSP(MaPN, SoLuongNhap, SoLuongTrongKho);
    }
}
