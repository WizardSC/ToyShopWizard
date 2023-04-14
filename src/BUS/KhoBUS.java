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
    
    public ArrayList<KhoDTO> searchMaSP(String tuKhoa){
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhoDTO> dskho = new ArrayList<>();
        for(KhoDTO kho : listKho){
            String MaSP = kho.getMaSP().toLowerCase();
            if(MaSP.contains(tuKhoa)){
                dskho.add(kho);
            }
        }
        return dskho;
    }
    
    public ArrayList<KhoDTO> searchTenSP(String tuKhoa){
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhoDTO> dskho = new ArrayList<>();
        for(KhoDTO kho : listKho){
            String TenSP = kho.getTenSP().toLowerCase();
            if(TenSP.contains(tuKhoa)){
                dskho.add(kho);
            }
        }
        return dskho;
    }
    public ArrayList<KhoDTO> searchDonViTinh(String tuKhoa){
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhoDTO> dskho = new ArrayList<>();
        for(KhoDTO kho : listKho){
            String DonViTinh = kho.getDonViTinh().toLowerCase();
            if(DonViTinh.contains(tuKhoa)){
                dskho.add(kho);
            }
        }
        return dskho;
    }
    public ArrayList<KhoDTO> searchMaLoai(String tuKhoa){
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhoDTO> dskho = new ArrayList<>();
        for(KhoDTO kho : listKho){
            String MaLoai = kho.getMaLoai().toLowerCase();
            if(MaLoai.contains(tuKhoa)){
                dskho.add(kho);
            }
        }
        return dskho;
    }
}
