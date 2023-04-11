/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuXuatDAO;
import DTO.PhieuXuatDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class PhieuXuatBUS {
    private PhieuXuatDAO pxDAO = new PhieuXuatDAO();
    private ArrayList<PhieuXuatDTO> listPhieuXuat = null;
    
    public void docDanhSach(){
        this.listPhieuXuat = pxDAO.getListPhieuXuat();
    }
    
    public ArrayList<PhieuXuatDTO> getListPhieuXuat(){
        return listPhieuXuat;
    }
    
    public void add(PhieuXuatDTO px){
        listPhieuXuat.add(px);
        pxDAO.insertPhieuXuat(px);
    }
    
    //Tìm kiếm theo Mã PX
    public ArrayList<PhieuXuatDTO> searchMaPX(String tk){
        tk=tk.toLowerCase();
        ArrayList<PhieuXuatDTO> dspx = new ArrayList<>();
        for(PhieuXuatDTO px : listPhieuXuat){
            String MaPX = px.getMaPX().toLowerCase();
            if(MaPX.contains(tk)){
                dspx.add(px);
            }
        }
        return dspx;
    }
    //Tìm kiếm theo Mã NV
}
