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

    public TaiKhoanDTO(String MaTK, String TenDangNhap, String MatKhau, String PhanQuyen) {
        this.MaNV = MaTK;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.PhanQuyen = PhanQuyen;
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
