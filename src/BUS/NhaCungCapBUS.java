/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class NhaCungCapBUS {

    private NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    private ArrayList<NhaCungCapDTO> listNhaCungCap = null;

    public void docDanhSach() {
        this.listNhaCungCap = nccDAO.getListNhaCungCap();
    }

    public ArrayList<NhaCungCapDTO> getListNhaCungCap() {
        return listNhaCungCap;
    }
    public void insert(NhaCungCapDTO ncc){
        listNhaCungCap.add(ncc);
        nccDAO.insertNhaCungCap(ncc);
    }
    public void update(NhaCungCapDTO ncc) {
        for (int i = 0; i < listNhaCungCap.size(); i++) {
            if (listNhaCungCap.get(i).getMaNCC().equals(ncc.getMaNCC())) {
                listNhaCungCap.set(i, ncc);
                nccDAO.updateNhaCungCap(ncc);
                return;
            }
        }
    }

    public void delete(String MaNCC){
        for(NhaCungCapDTO ncc : listNhaCungCap){
            if(ncc.getMaNCC().equals(MaNCC)){
                listNhaCungCap.remove(ncc);
                nccDAO.deleteNhaCungCap(MaNCC);
                return;
            }
        }
    }
}
