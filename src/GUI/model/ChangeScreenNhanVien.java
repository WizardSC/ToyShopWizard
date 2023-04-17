/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;


import GUI.ChucVuGUI;
import GUI.DSHoaDonGUI;
import GUI.HoaDonGUI;
import GUI.KhachHangGUI;
import GUI.MainForNhanVienGUI;
import GUI.NhanVienGUI;
import GUI.SanPhamForNVGUI;

import GUI.TaiKhoanGUI;
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
public class ChangeScreenNhanVien {
    private JPanel pnRoot;
    private String kindSelected = "";
    private ArrayList<DanhMuc> list = null;

    public ChangeScreenNhanVien(JPanel pnRoot) {
        this.pnRoot = pnRoot;
    }

    public void setView(JPanel pnItem, JLabel lblItem) {

//        pnItem.setBackground(new Color(130,120,210));
//        lblItem.setBackground(new Color(130,120,210));
        pnRoot.removeAll();
        pnRoot.setLayout(new BorderLayout());
        pnRoot.add(new MainForNhanVienGUI(""));
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
                case "HoaDon":
                    node = new HoaDonGUI();
                    break;
                case "SanPham":
                    node = new SanPhamForNVGUI();
                    break;
                case "DSHoaDon":
                    node = new DSHoaDonGUI();
                    break;
                case "KhachHang":
                    node = new KhachHangGUI();
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
            pnItem.setBackground(new Color(188, 206, 248));
            lblItem.setBackground(new Color(188, 206, 248));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            pnItem.setBackground(new Color(233, 246, 255));
            lblItem.setBackground(new Color(233, 246, 255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                pnItem.setBackground(new Color(188, 206, 248));
                lblItem.setBackground(new Color(188, 206, 248));
            }
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
