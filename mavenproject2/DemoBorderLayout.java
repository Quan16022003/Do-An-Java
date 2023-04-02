/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;
import newpackage.Chucnangtieude;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.*;

public class DemoBorderLayout {
//    public static JPanel pn1;
    
    
    
    public DemoBorderLayout() {
        init();
    }
    
    private void init(){
        
        JFrame f = new JFrame();
        f.setLayout(new BorderLayout(5,5));
        f.setUndecorated(true);

        f.setSize(1280  , 720);
        
        //JPanel pn1 = new HomeFrm();
        JPanel pn1 = new HomeformGiaoVien();
//        pn1.setBackground(Color.red);
        pn1.setPreferredSize(new Dimension(500,200));
        
        JPanel pn2 = new JPanel();
        pn2.setBackground(Color.green);
        pn2.setPreferredSize(new Dimension(200,0));
        
        JPanel pn3 = new JPanel();
        pn3.setBackground(Color.blue);
        pn3.setPreferredSize(new Dimension(0,100)); 
        
        Chucnangtieude pn4 = new Chucnangtieude(f);
        pn4.setBackground(Color.yellow);
        pn4.setPreferredSize(new Dimension(0,60));
        
        
        f.add(pn1,BorderLayout.EAST);
        
        f.add(pn2,BorderLayout.WEST);
        f.add(pn3,BorderLayout.SOUTH);
        f.add(pn4,BorderLayout.NORTH);
        
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        
    } 
    public static void main(String[] args) {
        DemoBorderLayout d = new DemoBorderLayout();
        
    }
}
