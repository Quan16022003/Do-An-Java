/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.MainFormBUS;
import DTO.ChucNang;
import DTO.CodeCN;
import GUI.Model.Content;
import GUI.QLNhanVien.NhanVienGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;
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
    private final MainFormBUS bus = new MainFormBUS();
    private List<ChucNang> dsChucNang;

    public MainForm(String username) {
        System.out.println(username );
        dsChucNang = bus.getDsTenCN(username);
        setSize(FRAME_SIZE);
        setResizable(true);
        setBackground(FRAME_COLOR);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Bạn có muốn đóng ứng dụng không", "Confirm close", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
            }
        });
        setResizable(false);
        getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(34,40,49));
        getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);
        ImageIcon icon = new ImageIcon("./src/main/java/Image/management_48px.png");
        setIconImage(icon.getImage());
        setTitle(username);
        setLayout(new BorderLayout());

//        titleBar = new TitleBar(this);
        sideBar = new SideBar(this);
        pContent = bus.changeContent(sideBar.getActiveLabel().getText());

        //this.add(titleBar, BorderLayout.PAGE_START);
        add(sideBar, BorderLayout.WEST);
        add(pContent, BorderLayout.CENTER);
        pack();

    }

    public void changeContent(JLabel menu) {
        remove(pContent);
        pContent = bus.changeContent(menu.getText());
        add(pContent, BorderLayout.CENTER);
        repaint();
        validate();
    }

    @Override
    public void setTitle(String title) {
        String newTitle = "QUẢN LÝ GIÁO VIÊN    -   " + (title == null ? "ADMIN" : title.toUpperCase());
        super.setTitle(newTitle);
    }

    public List<ChucNang> getDsChucNang() {
        return dsChucNang;
    }

    public void logout() {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
        dispose();
    }
}