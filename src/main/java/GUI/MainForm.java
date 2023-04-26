/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.modal.Content;
import GUI.modal.SideBar;
import GUI.modal.TitleBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class MainForm extends JFrame{
    private final Dimension FRAME_SIZE = new Dimension(1280, 720);
    private final Color FRAME_COLOR = new Color(238,238,238);
//    private final TitleBar titleBar;
    private final SideBar sideBar;
    private Content pContent;
    
    private String[] menus = new String[]{"Quản lý giáo viên","Chấm công giáo viên", "Xin chào", "Tạm biệt"};
    
    public MainForm(String username) throws HeadlessException {
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
            case "Quản lý giáo viên" -> {
                pContent = new Nhan_Vien_GUI();
            }
            case "Chấm công giáo viên" -> {
                pContent = new ChamCong_Form();
            }
            case "Xin chào" -> {
                pContent = new Form2Content();
            }
            case "Tạm biệt" -> {
                pContent = new Form3Content();
            }

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
