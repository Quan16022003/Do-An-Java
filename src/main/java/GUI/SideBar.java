/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.ChucNang;
import DTO.CodeCN;
import GUI.Model.RoundedLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.*;

import static DTO.CodeCN.*;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class SideBar extends JPanel implements MouseListener{
    private final Color SIDEBAR_COLOR = new Color(57,62,70);
    private final Font SIDEBAR_FONT = new Font("Segoe UI", Font.PLAIN, 18);
    private JPanel imagePanel, menuPanel, logoutPanel;
    private JLabel[] menuLabels;
    private JLabel itemActiveLabel, logoutLabel;
    private final MainForm _main;
    public SideBar(MainForm main) {
        _main = main;
        Dimension SIDEBAR_SIZE = new Dimension(200, 688);
        setPreferredSize(SIDEBAR_SIZE);
        setBackground(SIDEBAR_COLOR);
        setLayout(new BorderLayout(0, 20));
        initImage();
        initMenu();
        initLogout();
        add(imagePanel, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
        add(logoutPanel, BorderLayout.SOUTH);
    }
    
    private void initImage() {
        imagePanel = new JPanel(new BorderLayout());
        imagePanel.setPreferredSize(new Dimension(200,200));
        imagePanel.setBackground(SIDEBAR_COLOR);
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("./src/main/java/Image/Books_160px.png"));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);
    }
    
    private void initMenu() {
        menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        menuPanel.setBackground(SIDEBAR_COLOR);
//        String[] menus = _main.getMenus();
//        menusLabel = new JLabel[menus.length];
//        for (int i = 0; i < menus.length; i++) {
//            menusLabel[i] = new RoundedLabel(menus[i]);
//            menusLabel[i].setPreferredSize(new Dimension(180, 50));
//            menusLabel[i].setForeground(Color.WHITE);
//            menusLabel[i].setFont(SIDEBAR_FONT);
//            menusLabel[i].setBackground(SIDEBAR_COLOR);
//            menusLabel[i].addMouseListener(this);
//            menuPanel.add(menusLabel[i]);
//        }
        List<ChucNang> dsChucNang = _main.getDsChucNang();
        Map<CodeCN, String> menus = new HashMap<>();
        for (var chucNang : dsChucNang) {
            menus.put(chucNang.getCodeCN(), chucNang.getTenCN());
        }
        Set menuKeys = menus.keySet();
        menuLabels = new JLabel[menuKeys.size()];
        int i = 0;
        if (menuKeys.contains(QLNV)) menuLabels[i++] = initMenuLabel(menus.get(QLNV));
        if (menuKeys.contains(QLHD)) menuLabels[i++] = initMenuLabel(menus.get(QLHD));
        if (menuKeys.contains(QLCC)) menuLabels[i++] = initMenuLabel(menus.get(QLCC));
        if (menuKeys.contains(QLTL)) menuLabels[i++] = initMenuLabel(menus.get(QLTL));
        if (menuKeys.contains(QLTK)) menuLabels[i++] = initMenuLabel(menus.get(QLTK));
        if (menuKeys.contains(CHANGE_PASS)) menuLabels[i++] = initMenuLabel(menus.get(CHANGE_PASS));

        for (i = 0; i < menuLabels.length; i++) {
            menuPanel.add(menuLabels[i]);
        }

        itemActiveLabel = menuLabels[0];
        itemActiveLabel.setBackground(new Color(0,173,181));
        itemActiveLabel.setForeground(Color.BLACK);
    }

    private void initLogout() {
        logoutPanel = new JPanel(new FlowLayout());
        logoutPanel.setBackground(SIDEBAR_COLOR);
        Icon icon = new ImageIcon("./src/main/java/Image/logout_32px.png");
        logoutLabel = new RoundedLabel("Đăng xuất");
        logoutLabel.setIcon(icon);
        logoutLabel.setPreferredSize(new Dimension(180, 40));
        logoutLabel.setForeground(Color.WHITE);
        logoutLabel.setBackground(new Color(194, 28, 28));
        logoutLabel.setFont(SIDEBAR_FONT);
        logoutLabel.addMouseListener(this);
        logoutPanel.add(logoutLabel);
    }


    private JLabel initMenuLabel(String name) {
        JLabel menuLabel = new RoundedLabel(name);
        menuLabel.setPreferredSize(new Dimension(180, 50));
        menuLabel.setForeground(Color.WHITE);
        menuLabel.setFont(SIDEBAR_FONT);
        menuLabel.setBackground(SIDEBAR_COLOR);
        menuLabel.addMouseListener(this);
        return menuLabel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == logoutLabel) {
            _main.logout();
            return;
        }
        if (e.getSource() instanceof JLabel && e.getSource() != itemActiveLabel) {
            itemActiveLabel = (JLabel) e.getSource();
            for (JLabel lblMenu : menuLabels) {
                lblMenu.setBackground(SIDEBAR_COLOR);
                lblMenu.setForeground(Color.WHITE);
            }
            itemActiveLabel.setBackground(new Color(0,173,181));
            itemActiveLabel.setForeground(Color.BLACK);
            System.out.println("label is clicked: " + itemActiveLabel.getText());
            _main.changeContent(itemActiveLabel);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == logoutLabel) {
            logoutLabel.setBackground(Color.RED);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() != itemActiveLabel && e.getSource() != logoutLabel) {
            JLabel lblEntered = (JLabel) e.getSource();
            lblEntered.setBackground(new Color(0,173,181,15));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() != itemActiveLabel && e.getSource() != logoutLabel) {
            JLabel lblExited = (JLabel) e.getSource();
            lblExited.setBackground(SIDEBAR_COLOR);
        }
    }

    public JLabel getActiveLabel() {
        return itemActiveLabel;
    }
}