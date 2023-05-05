/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.HopDong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author apple
 */
public class HopDongBUS extends javax.swing.JDialog{
    public boolean check(HopDong nv){
        
        
        if (              
                  nv.getMaHD().isEmpty()
                |nv.getMaLoaiHD().isEmpty()
                |nv.getMaNV().isEmpty()
                |nv.getNgayKy().isEmpty()
                |nv.getHanHD().isEmpty()
                |nv.getHocVi().isEmpty()
                |nv.getHang().isEmpty()
                |nv.getBac().isEmpty()
                |nv.getMaSoThue().isEmpty()
                |nv.getCucThue().isEmpty()
                |nv.getSTK().isEmpty()
                |nv.getNganHang().isEmpty()
                |nv.getSoTietGiangDay().isEmpty()
              )
               return false;
           return true;
    }
}
