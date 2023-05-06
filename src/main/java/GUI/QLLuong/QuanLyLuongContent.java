/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QLLuong;

import GUI.modal.Content;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;

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

}
