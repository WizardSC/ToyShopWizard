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

    public void docDanhSach() {
        this.listTaiKhoan = tkDAO.getListTaiKhoan();
    }

    public void docDanhSach1() {
        this.listTaiKhoan = tkDAO.getListMaNVChuaCoTK();
    }

    public ArrayList<TaiKhoanDTO> getListTaiKhoan() {
        return listTaiKhoan;
    }

    public ArrayList<TaiKhoanDTO> getListMaNVChuaCoTK() {
        return listTaiKhoan;
    }

    public void listTK() {
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        listTaiKhoan = new ArrayList<>();
        listTaiKhoan = tkDAO.getListTaiKhoan();
    }

    public void add(TaiKhoanDTO tk) {
        listTaiKhoan.add(tk);
        tkDAO.insertTaiKhoan(tk);
    }

    public void update(String MatKhauCu, String MatKhauMoi, String TenDangNhap) {
        this.docDanhSach();

        for (int i = 0; i < listTaiKhoan.size(); i++) {
            if (listTaiKhoan.get(i).getTenDangNhap().equals(TenDangNhap) && !MatKhauCu.equals("111111")) { 
                System.out.println(listTaiKhoan.get(i).getTenDangNhap());
                listTaiKhoan.get(i).setMatKhau("111111");
                MatKhauMoi = "111111";
                tkDAO.updateTaiKhoan(MatKhauMoi, TenDangNhap);

                return;
            } else if (listTaiKhoan.get(i).getTenDangNhap().equals(TenDangNhap) && MatKhauCu.equals("111111")){
                listTaiKhoan.get(i).setMatKhau(MatKhauMoi);
                tkDAO.updateTaiKhoan(MatKhauMoi, TenDangNhap);
                System.out.println(MatKhauMoi);
                System.out.println( listTaiKhoan.get(i).getMatKhau());
                return;
            }
        }
    }
    
    public void lock(boolean TinhTrang, String TenDangNhap) {
        this.docDanhSach();
        for(int i=0;i<listTaiKhoan.size();i++){
            if(listTaiKhoan.get(i).getTenDangNhap().equals(TenDangNhap) && listTaiKhoan.get(i).isTinhTrang() == false){
                listTaiKhoan.get(i).setTinhTrang(true);
                TinhTrang = true;
                tkDAO.lockTaikhoan(TinhTrang,TenDangNhap);
                return;
            }
            if(listTaiKhoan.get(i).getTenDangNhap().equals(TenDangNhap) && listTaiKhoan.get(i).isTinhTrang() == true){
                listTaiKhoan.get(i).setTinhTrang(true);
                TinhTrang = false;
                tkDAO.lockTaikhoan(TinhTrang,TenDangNhap);
                return;
            }
        }
    }

    public TaiKhoanDTO check(String userName, char[] pass) {

        for (TaiKhoanDTO tk : listTaiKhoan) {
            char[] correctPass = tk.getMatKhau().toCharArray();
            if (tk.getTenDangNhap().equals(userName) && Arrays.equals(pass, correctPass)) {
                return tk;
            }
        }
        return null;
    }

}
