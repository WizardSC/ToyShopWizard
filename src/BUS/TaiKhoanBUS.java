/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class TaiKhoanBUS {
    private TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    private ArrayList<TaiKhoanDTO> listTaiKhoan = null;
    
    public void docDanhSach(){
        this.listTaiKhoan = tkDAO.getListTaiKhoan();
    }
    public void docDanhSach1(){
         this.listTaiKhoan = tkDAO.getListMaNVChuaCoTK();
    }
    
    public ArrayList<TaiKhoanDTO> getListTaiKhoan(){
        return listTaiKhoan;
    }
    public ArrayList<TaiKhoanDTO> getListMaNVChuaCoTK(){
        return listTaiKhoan;
    }
    public void listTK(){
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        listTaiKhoan = new ArrayList<>();
        listTaiKhoan = tkDAO.getListTaiKhoan();
    }
    
    public TaiKhoanDTO check(String userName,char[] pass)
    {
        
        for(TaiKhoanDTO tk : listTaiKhoan)
        {   
            char[] correctPass = tk.getMatKhau().toCharArray();
            if( tk.getTenDangNhap().equals(userName) && Arrays.equals(pass, correctPass))
            {
                return tk;
            }
        }
        return null;
    }
    
    
}
