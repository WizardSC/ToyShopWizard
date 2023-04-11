package GUI;

import javax.swing.UIManager;

/**^
 *^^
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        //new MainForQuanLyGUI().setVisible(true);

//         new DangNhapGUI().setVisible(true);
//      new MainForNhanVienGUI().setVisible(true);
      new MainForNVKhoGUI().setVisible(true);


//        new MainForKeToanGUI().setVisible(true);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
    }
}
