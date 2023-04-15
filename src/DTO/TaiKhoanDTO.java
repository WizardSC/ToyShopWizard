/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class TaiKhoanDTO {
    private String MaNV;
    private String TenDangNhap;
    private String MatKhau;
    private String PhanQuyen;
    private boolean TinhTrang;

    public TaiKhoanDTO(String MaNV, String TenDangNhap, String MatKhau, String PhanQuyen, boolean TinhTrang) {
        this.MaNV = MaNV;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.PhanQuyen = PhanQuyen;
        this.TinhTrang = TinhTrang;
    }

    public TaiKhoanDTO(String MaNV) {
        this.MaNV = MaNV;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    

    

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getPhanQuyen() {
        return PhanQuyen;
    }

    public void setPhanQuyen(String PhanQuyen) {
        this.PhanQuyen = PhanQuyen;
    }
    
}
