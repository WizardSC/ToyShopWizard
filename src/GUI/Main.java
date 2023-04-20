package GUI;

import javax.swing.UIManager;

/**
 * ^
 * ^^^
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        
            //Đăng nhập
//        new DangNhapGUI().setVisible(true);
        //Nhân viên quản lý
//        new MainForQuanLyGUI("NV03").setVisible(true);
        //Nhân viên kho
//        new MainForNVKhoGUI("").setVisible(true);
        //Nhân viên bán hàng
        new MainForNhanVienGUI("NV02").setVisible(true);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
    }
}
