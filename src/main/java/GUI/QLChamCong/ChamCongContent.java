/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QLChamCong;

import GUI.Content;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class ChamCongContent extends Content {

    public ChamCongContent() {
        super();
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Chấm công", new ChamCongForm());
        add(tabbedPane, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChamCongContent());
        frame.pack();
        frame.setVisible(true);
    }
}
