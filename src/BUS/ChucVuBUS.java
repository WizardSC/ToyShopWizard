/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChucVuDAO;
import DTO.ChucVuDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class ChucVuBUS {
    public ArrayList<ChucVuDTO> listChucVu = null;
    private ChucVuDAO cvDAO = new ChucVuDAO();
    
    public void docDanhSach(){
        this.listChucVu = cvDAO.getListChucVu();
    }
    
    public ArrayList<ChucVuDTO> getListChucVu(){
        return listChucVu;
    }
}