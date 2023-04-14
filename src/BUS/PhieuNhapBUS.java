/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class PhieuNhapBUS {

    private PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    private ArrayList<PhieuNhapDTO> listPhieuNhap = null;

    public void docDanhSach() {
        this.listPhieuNhap = pnDAO.getListPhieuNhap();
    }

    public ArrayList<PhieuNhapDTO> getListPhieuNhap() {
        return listPhieuNhap;
    }

    public void add(PhieuNhapDTO pn) {
        listPhieuNhap.add(pn);
        pnDAO.insertPhieuNhap(pn);
    }

    public ArrayList<PhieuNhapDTO> searchThang(int thang) {
        ArrayList<PhieuNhapDTO> dspn = new ArrayList<>();
        for (PhieuNhapDTO pn : listPhieuNhap) {
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
}
