/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QLLuong;

import BLL.QLLuongBUS;
import DTO.Luong;
import GUI.Content;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Nguyen Hoang Quan
 */
public final class QuanLyLuongContent extends Content {
    public QuanLyLuongContent() {
        super();
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Xem bảng lương hiện tại", new XemLuongHienTai());
        tabbedPane.addTab("Xem lịch sử bảng lương", new XemLichSu());
        add(tabbedPane);
    }
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new QuanLyLuongContent());
        frame.pack();
        frame.setVisible(true);
    }

}
