/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CTPhieuNhapDAO;
import DTO.CTPhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class CTPhieuNhapBUS {

    private CTPhieuNhapDAO ctpnDAO = new CTPhieuNhapDAO();
    private ArrayList<CTPhieuNhapDTO> listCTPN = null;

    public void docDanhSach() {
        this.listCTPN = ctpnDAO.getListCTPN();
    }

    public void listCTPN() {
        CTPhieuNhapDAO ctpnDAO = new CTPhieuNhapDAO();
        listCTPN = new ArrayList<>();
        listCTPN = ctpnDAO.getListCTPN();
    }

    public ArrayList<CTPhieuNhapDTO> getListCTPN() {
        return listCTPN;
    }
    public ArrayList<CTPhieuNhapDTO> getListCTPNtheoMaPN(String MaPN){
        ArrayList<CTPhieuNhapDTO> dsctpn = new ArrayList<>();
        for(CTPhieuNhapDTO ctpn : listCTPN){
            if(ctpn.getMaPN().equals(MaPN)){
                dsctpn.add(ctpn);
            }
        }
        return dsctpn;
    }
    public void add(CTPhieuNhapDTO ctpn) {
        listCTPN.add(ctpn);
        ctpnDAO.insertCTPN(ctpn);
    }
}
