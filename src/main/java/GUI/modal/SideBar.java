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
    private final Color SIDEBAR_COLOR = new Color(57,62,70);
    private JPanel imagePanel, menuPanel;
    private JLabel[] menusLabel;
    private JLabel itemActiveLabel;
    private final MainForm _main;
    public SideBar(MainForm main) {
        _main = main;
        Dimension SIDEBAR_SIZE = new Dimension(200, 688);
        setPreferredSize(SIDEBAR_SIZE);
        setBackground(SIDEBAR_COLOR);
        setLayout(new BorderLayout(0, 20));
        initImage();
        initMenu();
        add(imagePanel, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
    }
    
    private void initImage() {
        imagePanel = new JPanel(new BorderLayout());
        imagePanel.setPreferredSize(new Dimension(200,200));
        imagePanel.setBackground(new Color(45,49,56));
        JLabel lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon("./src/main/java/Image/Books_160px.png"));
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(lblImage, BorderLayout.CENTER);
    }
    
    private void initMenu() {
        menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        menuPanel.setBackground(new Color(57, 62, 70));
        String[] menus = _main.getMenus();
        menusLabel = new JLabel[menus.length];
        for (int i = 0; i < menus.length; i++) {
            menusLabel[i] = new RoundedLabel(menus[i]);
            menusLabel[i].setPreferredSize(new Dimension(180, 50));
            menusLabel[i].setForeground(Color.WHITE);
            menusLabel[i].setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menusLabel[i].setBackground(SIDEBAR_COLOR);
            menusLabel[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            menusLabel[i].addMouseListener(this);
            menuPanel.add(menusLabel[i]);
        }
        itemActiveLabel = menusLabel[0];
        itemActiveLabel.setBackground(new Color(0,173,181));
        itemActiveLabel.setForeground(Color.BLACK);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JLabel && e.getSource() != itemActiveLabel) {
            itemActiveLabel = (JLabel) e.getSource();
            for (JLabel lblMenu : menusLabel) {
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
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() != itemActiveLabel) {
            JLabel lblEntered = (JLabel) e.getSource();
            lblEntered.setBackground(new Color(0,173,181,15));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() != itemActiveLabel) {
            JLabel lblExited = (JLabel) e.getSource();
            lblExited.setBackground(SIDEBAR_COLOR);
        }
    }
}