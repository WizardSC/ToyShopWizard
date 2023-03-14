/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class PhieuNhapBUS {
    private PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    private ArrayList<PhieuNhapDTO> listPhieuNhap = null;
    
    public void docDanhSach(){
        this.listPhieuNhap = pnDAO.getListPhieuNhap();
    }
    
    public ArrayList<PhieuNhapDTO> getListPhieuNhap(){
        return listPhieuNhap;
    }
    
    public void add(PhieuNhapDTO pn){
        listPhieuNhap.add(pn);
        pnDAO.insertPhieuNhap(pn);
    }
}
