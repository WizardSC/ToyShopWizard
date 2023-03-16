package BUS;

import DAO.ThongKeDAO;
import DTO.CTHoaDonDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hoang
 */
public class ThongKeBUS {
    public static ArrayList<CTHoaDonDTO> listTKSP;
    public static ArrayList<Object> listTKDT;
    private ThongKeDAO tkDAO;
    
    public ThongKeBUS(){
        tkDAO = new ThongKeDAO();
    }
    public void ThongkeSP(){
        listTKSP = new ArrayList<>();
        listTKSP = tkDAO.getDLSP();
    }
    public void ThongkeDT(String ngayBD, String ngayKT){
        listTKDT = new ArrayList<>();
        listTKDT = tkDAO.getDoanhThu(ngayBD, ngayKT);
    }
    public void ThongkeDTQuy(String quy){
        listTKDT = new ArrayList<>();
        //Lấy năm hiện tại
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("yyyy");
        String year = dateFormat.format(date);
        
        if(quy.equals("Quý 1")){
            listTKDT = tkDAO.getDoanhThu(year+"-01-01-", year+"-03-31");
        }
        else{
            if(quy.equals("Quý 2")){
                listTKDT = tkDAO.getDoanhThu(year+"-04-01", year+"-06-30");
            }
            else{
                if(quy.equals("Quý 3")){
                    listTKDT = tkDAO.getDoanhThu(year+"-07-01", year+"-09-30");
                }
                else{
                    listTKDT = tkDAO.getDoanhThu(year+"-10-01", year+"-12-31");
                }
            }
        }
    }
}
