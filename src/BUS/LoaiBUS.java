/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.LoaiDAO;
import DTO.LoaiDTO;
import java.util.ArrayList;

/**
 *
 * @author Phuc Toan
 */
public class LoaiBUS {
    private ArrayList<LoaiDTO> listLoai;
    public LoaiDAO loaiDAO = new LoaiDAO();
    public void docDanhSach(){
        this.listLoai = loaiDAO.getListLoai();
    }
    
    public ArrayList<LoaiDTO> getListLoai(){
        return listLoai;
    }
    
}
