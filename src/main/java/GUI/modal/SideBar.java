/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.modal;

import GUI.MainForm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class SideBar extends JPanel implements MouseListener{
    private final Dimension SIDEBAR_SIZE = new Dimension(200, 688);
    private final Color SIDEBAR_COLOR = new Color(57,62,70);
    private JPanel pnImage, pnMenu;
    private JLabel[] lblMenus;
    private JLabel lblItemActive;
    private final MainForm _main;
    public SideBar(MainForm main) {
        _main = main;
        setPreferredSize(SIDEBAR_SIZE);
        setBackground(SIDEBAR_COLOR);
        setLayout(new BorderLayout(0, 20));
        initImage();
        initMenu();
        add(pnImage, BorderLayout.NORTH);
        add(pnMenu, BorderLayout.CENTER);
    }
    
    private void initImage() {
        pnImage = new JPanel(new BorderLayout());
        pnImage.setPreferredSize(new Dimension(200,200));
        pnImage.setBackground(new Color(45,49,56));
        JLabel lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon("./src/main/java/Image/Books_160px.png"));
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        pnImage.add(lblImage, BorderLayout.CENTER);
    }
    
    private void initMenu() {
        pnMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        pnMenu.setBackground(new Color(57, 62, 70));
        String[] menus = _main.getMenus();
        lblMenus = new JLabel[menus.length];
        for (int i = 0; i < menus.length; i++) {
            lblMenus[i] = new RoundedLabel(menus[i]);
            lblMenus[i].setPreferredSize(new Dimension(180, 50));
            lblMenus[i].setForeground(Color.WHITE);
            lblMenus[i].setFont(new Font("Segoe UI", 0, 18));
            lblMenus[i].setBackground(SIDEBAR_COLOR);
            lblMenus[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lblMenus[i].addMouseListener(this);
            pnMenu.add(lblMenus[i]);
        }
        lblItemActive = lblMenus[0];
        lblItemActive.setBackground(new Color(0,173,181));
        lblItemActive.setForeground(Color.BLACK);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JLabel && e.getSource() != lblItemActive) {
            lblItemActive = (JLabel) e.getSource();
            for (JLabel lblMenu : lblMenus) {
                lblMenu.setBackground(SIDEBAR_COLOR);
                lblMenu.setForeground(Color.WHITE);
            }
            lblItemActive.setBackground(new Color(0,173,181));
            lblItemActive.setForeground(Color.BLACK);
            System.out.println("label is clicked: " + lblItemActive.getText());
            _main.changeContent(lblItemActive);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() != lblItemActive) {
            JLabel lblEntered = (JLabel) e.getSource();
            lblEntered.setBackground(new Color(0,173,181,20));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() != lblItemActive) {
            JLabel lblExited = (JLabel) e.getSource();
            lblExited.setBackground(SIDEBAR_COLOR);
        }
    }
}