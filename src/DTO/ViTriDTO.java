/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Phuc Toan
 */
public class ViTriDTO {
    private String MaVT;
    private String TenVT;

    public ViTriDTO(String MaVT, String TenVT) {
        this.MaVT = MaVT;
        this.TenVT = TenVT;
    }

    public String getMaVT() {
        return MaVT;
    }

    public void setMaVT(String MaVT) {
        this.MaVT = MaVT;
    }

    public String getTenVT() {
        return TenVT;
    }

    public void setTenVT(String TenVT) {
        this.TenVT = TenVT;
    }
    
}
