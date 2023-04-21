/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class HoaDonBUS {
    
    private ArrayList<HoaDonDTO> listHoaDon = null;
    private HoaDonDAO hdDAO = new HoaDonDAO();
    
    public void docDanhSach(){
        this.listHoaDon = hdDAO.getListHoaDon();
    }
    public void docDanhSach1(String MaKH){
        this.listHoaDon = hdDAO.selectThongTinKH(MaKH);
        
                
    }
    public ArrayList<HoaDonDTO> getThongTinKH(){
        return listHoaDon;
    }
    public ArrayList<HoaDonDTO> getListHoaDon(){
        return listHoaDon;
    }
    
    public void add(HoaDonDTO hd){
        listHoaDon.add(hd);
        hdDAO.insertHoaDon(hd);
    }
    
    public ArrayList<HoaDonDTO> searchMaHD(String tk) {
        tk = tk.toLowerCase();
        ArrayList<HoaDonDTO> dshd = new ArrayList<>();
        for (HoaDonDTO hd : listHoaDon) {
            String MaHD = hd.getMaHD().toLowerCase();
            if (MaHD.contains(tk)) {
                dshd.add(hd);
            }
        }
        return dshd;
    }
    public ArrayList<HoaDonDTO> searchMaNV(String tk){
        tk=tk.toLowerCase();
        ArrayList<HoaDonDTO> dshd= new ArrayList<>();
        for(HoaDonDTO hd : listHoaDon){
            String MaHD = hd.getMaNV().toLowerCase();
            if(MaHD.contains(tk)){
                dshd.add(hd);
            }
        }
        return dshd;
    }
    public ArrayList<HoaDonDTO> searchMaKH(String tk){
        tk=tk.toLowerCase();
        ArrayList<HoaDonDTO> dshd= new ArrayList<>();
        for(HoaDonDTO hd : listHoaDon){
            String MaHD = hd.getMaKH().toLowerCase();
            if(MaHD.contains(tk)){
                dshd.add(hd);
            }
        }
        return dshd;
    }
    
    public ArrayList<HoaDonDTO> searchThang(int thang) {
        ArrayList<HoaDonDTO> dspn = new ArrayList<>();
        for (HoaDonDTO pn : listHoaDon) {
            String NgayLap = pn.getNgayLap().toString();
            LocalDate date = LocalDate.parse(NgayLap);
            int month = date.getMonthValue();
            System.out.println("Thang truyen vao: " +thang);
            System.out.println("Thang trong DB: "+month);
            if (thang == month) {
                dspn.add(pn);
            }
        }
        return dspn;

    }
    public ArrayList<HoaDonDTO> searchTongTien(int tienmin, int tienmax){
        ArrayList<HoaDonDTO> dshd = new ArrayList<>();
        for(HoaDonDTO hd : listHoaDon){
            String TongTien = hd.getTongTien();
            if ( tienmin <= Integer.parseInt(TongTien) && Integer.parseInt(TongTien) <= tienmax){
                dshd.add(hd);
            }
        }
        return dshd;
    }
   
//   public ArrayList<HoaDonDTO> searchNgayLap(String)
    
}
