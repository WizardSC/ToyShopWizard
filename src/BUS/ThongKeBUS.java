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
    public void ThongkeSP(String ngayTK, String limit, String sort){
        listTKSP = new ArrayList<>();
        if(sort.equals("Tăng")){
            sort = "ASC";
        }
        else{
            sort = "DESC";
        }
        listTKSP = tkDAO.getDLSP(ngayTK.split("-"), limit, sort);
    }
    public void ThongkeSPQuy(String quy, String limit, String sort){
        listTKSP = new ArrayList<>();
        if(sort.equals("Tăng")){
            sort = "ASC";
        }
        else{
            sort = "DESC";
        }
        String[] arrDate = new String[4]; // [0]: bắt đầu quý TK, [1]: kết thúc quý TK, [2]: bat dau quy truoc quy TK, [3]: ket thuc quy truoc quy TK
        //Lấy năm hiện tại
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("yyyy");
        String year = dateFormat.format(date);
        
        if(quy.equals("Quý 1")){
            arrDate[0] = year + "-01-01";
            arrDate[1] = year + "-03-31";
        }
        else{
            if(quy.equals("Quý 2")){
                arrDate[0] = year+"-04-01";
                arrDate[1] = year+"-06-30";
            }
            else{
                if(quy.equals("Quý 3")){
                    arrDate[0] = year+"-07-01";
                    arrDate[1] = year+"-09-30";
                }
                else{
                    if(quy.equals("Quý 4")){
                        arrDate[0] = year+"-10-01";
                        arrDate[1] = year+"-12-31";
                    }
                }
            }
        }
        listTKSP = tkDAO.getDLSPQuy(arrDate, limit, sort);
    }
    public void ThongkeDT(String ngayTK){
        listTKDT = new ArrayList<>();
        String[] arrDate = new String[4]; // [0]: thang TK, [1]: nam TK, [2]: thang truoc TK, [3]: nam truoc TK
        String[] arrSplit = ngayTK.split("-");
        
        arrDate[0]= arrSplit[0];
        arrDate[1]= arrSplit[1];
            
        if(Integer.parseInt(arrSplit[0]) == 1){
            arrDate[2]= "12";
            arrDate[3]= String.valueOf(Integer.parseInt(arrSplit[1])-1);
        }
        else{
            arrDate[2]= String.valueOf(Integer.parseInt(arrSplit[0])-1);
            arrDate[3]= arrSplit[1];
        }
        listTKDT = tkDAO.getDoanhThu(arrDate);
    }
    public void ThongkeDTQuy(String quy){
        listTKDT = new ArrayList<>();
        
        String[] arrDate = new String[4]; // [0]: bắt đầu quý TK, [1]: kết thúc quý TK, [2]: bat dau quy truoc quy TK, [3]: ket thuc quy truoc quy TK
        //Lấy năm hiện tại
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("yyyy");
        String year = dateFormat.format(date);
        
        if(quy.equals("Quý 1")){
            arrDate[0] = year + "-01-01";
            arrDate[1] = year + "-03-31";
            
            String beforeYear = String.valueOf(Integer.parseInt(year)-1);
            
            arrDate[2] = beforeYear + "-10-01";
            arrDate[3] = beforeYear + "-12-31";
            
            listTKDT = tkDAO.getDoanhThuQuy(arrDate);
        }
        else{
            if(quy.equals("Quý 2")){
                arrDate[0] = year+"-04-01";
                arrDate[1] = year+"-06-30";
            
                arrDate[2] = year + "-01-01";
                arrDate[3] = year + "-03-31";
            
                listTKDT = tkDAO.getDoanhThuQuy(arrDate);
            }
            else{
                if(quy.equals("Quý 3")){
                    arrDate[0] = year+"-07-01";
                    arrDate[1] = year+"-09-30";
            
                    arrDate[2] = year+"-04-01";
                    arrDate[3] = year+"-06-30";
            
                    listTKDT = tkDAO.getDoanhThuQuy(arrDate);
                }
                else{
                    if(quy.equals("Quý 4")){
                        arrDate[0] = year+"-10-01";
                        arrDate[1] = year+"-12-31";

                        arrDate[2] = year+"-07-01";
                        arrDate[3] = year+"-09-30";

                        listTKDT = tkDAO.getDoanhThuQuy(arrDate);
                    }
                }
            }
        }
    }
    
    public String ThongkeHD(String ngayTK){
        String[] arrDate = ngayTK.split("-"); // [0]: thang TK, [1]: nam TK   
        return String.valueOf(tkDAO.getSLHoaDon(arrDate[0], arrDate[1]));
    }
    
    
    public String ThongkeHDQuy(String quy){
        //Lấy năm hiện tại
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("yyyy");
        String year = dateFormat.format(date);
        
        if(quy.equals("Quý 1")){
            return String.valueOf(tkDAO.getSLHoaDonQuy(year+"-01-01-", year+"-03-31"));
        }
        else{
            if(quy.equals("Quý 2")){
                return String.valueOf(tkDAO.getSLHoaDonQuy(year+"-04-01", year+"-06-30"));
            }
            else{
                if(quy.equals("Quý 3")){
                    return String.valueOf(tkDAO.getSLHoaDonQuy(year+"-07-01", year+"-09-30"));
                }
                else{
                    if(quy.equals("Quý 4")){
                        return String.valueOf(tkDAO.getSLHoaDonQuy(year+"-10-01", year+"-12-31"));
                    }
                    else{
                        return "0";
                    }
                }
            }
        }
    }
}
