/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.UIManager;

/**^
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        //new MainForQuanLyGUI().setVisible(true);
//       new MainForNhanVienGUI().setVisible(true);
//        new MainForQuanLyGUI().setVisible(true);

//         new DangNhapGUI().setVisible(true);
//      new MainForNhanVienGUI().setVisible(true);
        // new DangNhapGUI().setVisible(true);
//        new MainForNhanVienGUI().setVisible(true);
        new MainForKeToanGUI().setVisible(true);
//        new MainForNVKhoGUI().setVisible(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
    }
}
