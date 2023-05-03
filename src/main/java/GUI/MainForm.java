/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import GUI.QLChamCong.ChamCongForm;
import GUI.QLLuong.QuanLyLuongContent;
import GUI.QLNhanVien.Form1Content;
import GUI.QLTaiKhoan.Form4Content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;


/**
 *
 * @author Nguyen Hoang Quan
 */
public class MainForm extends JFrame{
    private final Dimension FRAME_SIZE = new Dimension(1280, 720);
    private final Color FRAME_COLOR = new Color(238,238,238);
    private final SideBar sideBar;
    private Content pContent;
    
    private String[] menus = new String[]{"Quản lý giáo viên","Chấm công giáo viên", "Xin chào", "Tạm biệt"};
    

    public MainForm(String username) {
        
        setSize(FRAME_SIZE);
        setResizable(true);
        setBackground(FRAME_COLOR);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(false);
        getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(34,40,49));
//        getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);
        ImageIcon icon = new ImageIcon("./src/main/java/Image/management_48px.png");
        setIconImage(icon.getImage());
        setTitle(username);
        setLayout(new BorderLayout());
        
//        titleBar = new TitleBar(this);
        sideBar = new SideBar(this);
        pContent = new Nhan_Vien_GUI();
        
        //this.add(titleBar, BorderLayout.PAGE_START);
        add(sideBar, BorderLayout.WEST);
        add(pContent, BorderLayout.CENTER);
        pack();
    }
    
    public void changeContent(JLabel menu) {
        remove(pContent);
        switch (menu.getText()) {
            case "Quản lý nhân viên" -> pContent = new new Nhan_Vien_GUI();
            case "Quản lý chấm công" -> pContent = new ChamCongForm();
            case "Quản lý lương" -> pContent = new QuanLyLuongContent();
            case "Quản lý tài khoản" -> pContent = new Form4Content();


            default -> throw new AssertionError();
        }
        add(pContent, BorderLayout.CENTER);
        repaint();
        validate();
    }

    
    
    public String[] getMenus() {
        return menus;
    }

}
