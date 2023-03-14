/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import GUI.LuongGUI;
import GUI.MainForKeToanGUI;
import GUI.ThongKeGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author wizardsc
 */
public class ChangeScreenKeToan {
    private JPanel pnRoot;
    private String kindSelected = "";
    private ArrayList<DanhMuc> list = null;
     public ChangeScreenKeToan(JPanel pnRoot) {
        this.pnRoot = pnRoot;
    }

    public void setView(JPanel pnItem, JLabel lblItem) {

        pnRoot.removeAll();
        pnRoot.setLayout(new BorderLayout());
        pnRoot.add(new MainForKeToanGUI());
        pnRoot.validate();
        pnRoot.repaint();
    }

    public void setEvent(ArrayList<DanhMuc> list) {
        this.list = list;
        for (DanhMuc item : list) {
            item.getLbl().addMouseListener(new LabelEvent(item.getKind(), item.getPn(), item.getLbl()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel pnItem;
        private JLabel lblItem;

        public LabelEvent(String kind, JPanel pnItem, JLabel lblItem) {
            this.kind = kind;
            this.pnItem = pnItem;
            this.lblItem = lblItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "ThongKe":
                    node = new ThongKeGUI();
                    break;
                case "Luong":
                    node = new LuongGUI();
                    break;

                default:
                    break;
            }
            pnRoot.removeAll();
            pnRoot.setLayout(new BorderLayout());
            pnRoot.add(node);
            pnRoot.validate();
            pnRoot.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            pnItem.setBackground(new Color(188,206,248));
            lblItem.setBackground(new Color(188,206,248));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            pnItem.setBackground(new Color(232, 255, 194));
//            lblItem.setBackground(new Color(232, 255, 194));
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            if (!kindSelected.equalsIgnoreCase(kind)) {
//                pnItem.setBackground(new Color(76,175,80));
//                lblItem.setBackground(new Color(76,175,80));
//            }
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMuc item : list) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getPn().setBackground(new Color(233, 246, 255));
                item.getLbl().setBackground(new Color(233, 246, 255));
            } else {
                item.getPn().setBackground(new Color(188,206,248));
                item.getLbl().setBackground(new Color(188,206,248));
            }
        }
    }
}
