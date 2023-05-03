/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QLNhanVien;

import GUI.QLChamCong.*;
import GUI.Content;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class Form1Content extends Content {

    public Form1Content() {
        super();
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel;
        for (int i = 0; i < 3; i++) {
            panel = new JPanel();
            panel.add(new JLabel("This is tab " + i));
            tabbedPane.addTab("Tab " + i, panel);
        }
        add(tabbedPane, BorderLayout.PAGE_START);
    }
    
    
}
