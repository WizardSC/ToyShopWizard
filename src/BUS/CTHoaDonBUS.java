/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CTHoaDonDAO;
import DTO.CTHoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class CTHoaDonBUS {
    private ArrayList<CTHoaDonDTO> listChiTietHoaDon = null;
    private CTHoaDonDAO cthdDAO = new CTHoaDonDAO();
    public void listCTHD()
    {
        CTHoaDonDAO cthdDAO = new CTHoaDonDAO();
        listChiTietHoaDon = new ArrayList<>();
        listChiTietHoaDon = cthdDAO.getListCTHoaDon();
    }
    public void docListCTHoaDon(){
        this.listChiTietHoaDon = cthdDAO.getListCTHoaDon();
    }
    public ArrayList<CTHoaDonDTO> getListCTHoaDon(){
        return listChiTietHoaDon;
    }
    
    public ArrayList<CTHoaDonDTO> getListCTHDTheoMaHD(String MaHD){
        ArrayList<CTHoaDonDTO> dscthd = new ArrayList<>();
        for(CTHoaDonDTO cthd : listChiTietHoaDon){
            if(MaHD.equals(cthd.getMaHD())){
                dscthd.add(cthd);
            }
        }
        return dscthd;
    }
    public void add(CTHoaDonDTO cthd){
        listChiTietHoaDon.add(cthd);
        CTHoaDonDAO cthdDAO = new CTHoaDonDAO();
        cthdDAO.insertHoaDon(cthd);
    }
}
