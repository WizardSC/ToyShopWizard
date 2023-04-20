/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChucVuDAO;
import DTO.ChucVuDTO;
import MyCustom.XuLyException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

/**
 *
 * @author wizardsc
 */
public class ChucVuBUS {

    public ArrayList<ChucVuDTO> listChucVu = null;
    private ChucVuDAO cvDAO = new ChucVuDAO();

    public void docDanhSach() {
        this.listChucVu = cvDAO.getListChucVu();
    }

    public ArrayList<ChucVuDTO> getListChucVu() {
        return listChucVu;
    }

    public void add(ChucVuDTO cv) {
        listChucVu.add(cv);
        cvDAO.insertChucVu(cv);
    }

    public void update(ChucVuDTO cv) {
        for (int i = 0; i < listChucVu.size(); i++) {
            if ((cv.getMaCV()).equals(listChucVu.get(i).getMaCV())) {
                listChucVu.set(i, cv);

                cvDAO.updateChucVu(cv);
                return;
            }
        }
    }

    public void delete(String MaCV) throws XuLyException {
        for (ChucVuDTO cv : listChucVu) {
            if (cv.getMaCV().equals(MaCV)) {
                listChucVu.remove(cv);
                try {
                    cvDAO.deleteChucVu(MaCV);
                } catch (SQLIntegrityConstraintViolationException e) {
                    throw new XuLyException("Không thể xóa chức vụ vì đã có dữ liệu liên quan đến chức vụ này trong cơ sở dữ liệu.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        
    }
}
