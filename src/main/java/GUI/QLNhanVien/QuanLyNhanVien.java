package GUI.QLNhanVien;

import GUI.Model.Content;

import javax.swing.*;
import java.awt.*;

public class QuanLyNhanVien extends Content {
    public QuanLyNhanVien() {
        super();
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Xem danh sách nhân viên", new NhanVienGUI());
        tabbedPane.addTab("Xem danh sách hợp đồng", new HopDongGUI());
        add(tabbedPane);
    }
}
