/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author wizardsc
 */
public class ChucVuDTO {
    private String MaCV;
    private String TenCV;
    private int Luong;

    public ChucVuDTO(String MaCV, String TenCV, int Luong) {
        this.MaCV = MaCV;
        this.TenCV = TenCV;
        this.Luong = Luong;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String TenCV) {
        this.TenCV = TenCV;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }
    
}
