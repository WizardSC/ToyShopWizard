package DTO;

/**
 *
 * @author wizardsc
 */
public class KhoDTO {
    private String MaSP;
    private String TenSP;
    private int SoLuong;
    private int GiaNhap;
    private String DonViTinh;
    private String MaLoai;
    private String IMG;

    public KhoDTO(String MaSP, String TenSP, int SoLuong) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
    }
    
    public KhoDTO(String MaSP, String TenSP, int SoLuong, int GiaNhap, String DonViTinh, String MaLoai, String IMG) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.DonViTinh = DonViTinh;
        this.MaLoai = MaLoai;
        this.IMG = IMG;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(int GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }
    
}
