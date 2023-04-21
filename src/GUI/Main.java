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
//        new MainForQuanLyGUI("NV01").setVisible(true);
        //Nhân viên kho
        new MainForNVKhoGUI("NV02").setVisible(true);
        //Nhân viên bán hàng
//        new MainForNhanVienGUI("NV03").setVisible(true);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
    }
}
