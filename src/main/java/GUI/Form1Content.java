/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.modal.Content;
import BLL.ToChuyenMonBLL;
import DTO.ToChuyenMon;
import java.awt.Color;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class Form1Content extends Content{

    public Form1Content() {
        super();
        setBackground(Color.red);
        
        // Tổ chuyên môn
        ToChuyenMonBLL tcmBLL = ToChuyenMonBLL.getInstance();
        System.out.println(tcmBLL);
    }
    
    
}
