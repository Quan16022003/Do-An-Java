/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class TitleBar extends JPanel{
    private final Color TITLEBAR_COLOR = new Color(34,40,49);
    private final Dimension TITLEBAR_SIZE = new Dimension(1280, 32);
    private JFrame frame;
    private JPanel pnControlButton, pnTitle;
    private JLabel lblminimize, lblClose, lblIcon, lblTitle;
    
    
    public TitleBar(JFrame f) {
        frame = f;
        setBackground(TITLEBAR_COLOR);
        setPreferredSize(TITLEBAR_SIZE);
        setLayout(new BorderLayout(0,0));
        initControlButton();
        initTitle();
        add(pnControlButton, BorderLayout.EAST);
        add(pnTitle, BorderLayout.WEST);
    }
    
    private void initControlButton() {
        pnControlButton = new JPanel(new GridLayout());
        pnControlButton.setBackground(TITLEBAR_COLOR);
        pnControlButton.setPreferredSize(new Dimension(64, 32));
        // Tạo nút minimize
        lblminimize = new JLabel();
        lblminimize.setBackground(new Color(134,134,134));
        lblminimize.setOpaque(true);
        // Tạo nút close
        lblClose = new JLabel();
        lblClose.setBackground(new Color(244,0,0));
        lblClose.setOpaque(true);
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
            }
        });
        
        pnControlButton.add(lblminimize);
        pnControlButton.add(lblClose);
    }
    private void initTitle(){
        pnTitle = new JPanel();
        pnTitle.setLayout(new BorderLayout(10,0));
        pnTitle.setBackground(TITLEBAR_COLOR);
        
        lblTitle = new JLabel();
        lblTitle.setText("QUẢN LÝ GIÁO VIÊN");
        lblTitle.setFont(new Font("Segoe UI", 0, 20));
        lblTitle.setForeground(Color.WHITE);
        
        pnTitle.add(lblTitle, BorderLayout.CENTER);
    }
}