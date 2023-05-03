/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.GiaoVien;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author apple
 */
public class GiaoVienBUS extends javax.swing.JDialog{
       public boolean check(GiaoVien gv){
           String EMAIL_PATTERN = 
            "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
           if (Pattern.matches("\\d{12}",gv.getCCCD())==false)
            {
                   JOptionPane.showMessageDialog(rootPane, "CCCD"); return false;
            }      
           if (Pattern.matches("^[a-zA-Z0-9\\s\\/]*$",gv.getDiaChi())==false)
           {
                   JOptionPane.showMessageDialog(rootPane, "DiaChi"); return false;
           }
           if (Pattern.matches("[a-z0-9]*",gv.getMaGV())==false)
           {
                   JOptionPane.showMessageDialog(rootPane, "Ma GV"); return false;
           }
           if (Pattern.matches("[a-z0-9\\s]*",gv.getHoTen())==false)
           {
                   JOptionPane.showMessageDialog(rootPane, "Ho ten"); return false;
           }
           if (Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",gv.getNgaySinh())==false)
                   {
                   JOptionPane.showMessageDialog(rootPane, "Ngay sinh "); return false;
           }
//           if (Pattern.matches("[a-z\\s]*",gv.getMonHoc())==false)
//                   {
//                   JOptionPane.showMessageDialog(rootPane, "Mon hoc "); return false;
//           }
//           if (Pattern.matches("(?i)(nam|nu)",gv.getGioiTinh())==false)
//                   {
//                   JOptionPane.showMessageDialog(rootPane, " gioi tinh "); return false;
//           }
           if (Pattern.matches("[a-z\\s]*",gv.getNoiSinh())==false)
               {
                   JOptionPane.showMessageDialog(rootPane, "Noi Sinh "); return false;
           }
           if (Pattern.matches("[a-z\\s]*",gv.getQueQuan())==false)
                   {
                   JOptionPane.showMessageDialog(rootPane, "Que quan "); return false;
           }
           if (Pattern.matches("^[a-zA-Z0-9\\s\\/]*$",gv.getNoiO())==false)
                  {
                   JOptionPane.showMessageDialog(rootPane, "Noi o "); return false;
           }
           if (Pattern.matches("\\d{10}",gv.getSoDienThoai())==false)
                   {
                   JOptionPane.showMessageDialog(rootPane, "So dien thoai "); return false;
           }
           if (Pattern.matches(EMAIL_PATTERN,gv.getEmail())==false)
                   {
                   JOptionPane.showMessageDialog(rootPane, "Email "); return false;
           }
//           if (Pattern.matches("[a-z\\s]*",gv.getToChuyenMon())==false)
//                   {
//                   JOptionPane.showMessageDialog(rootPane, "To chuyen mon"); return false;
//           }
            if (Pattern.matches("[a-z0-9\\s]*",gv.getDanToc())==false)
                   {
                   JOptionPane.showMessageDialog(rootPane, "Dan toc "); return false;
           }
            if (Pattern.matches("[a-z0-9\\s]*",gv.getTonGiao())==false)
                   {
                   JOptionPane.showMessageDialog(rootPane, "Ton giao "); return false;
           }
            if (Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",gv.getNgayCap())==false)
                   {
                   JOptionPane.showMessageDialog(rootPane, "Ngay cap "); return false;
           }
            if (Pattern.matches("^[a-zA-Z0-9\\s\\/]*$",gv.getNoiCap())==false)
                   {
                   JOptionPane.showMessageDialog(rootPane, "Noi Cap "); return false;
           }    
           if (              
                    gv.getCCCD().isEmpty()
                    |gv.getDiaChi().isEmpty()
                    |gv.getMaGV().isEmpty()
                    |gv.getHoTen().isEmpty()
                    |gv.getNgaySinh().isEmpty()
//                    |gv.getMonHoc().isEmpty()
//                    |gv.getGioiTinh().isEmpty()
                    |gv.getNoiSinh().isEmpty()
                    |gv.getQueQuan().isEmpty()
                    |gv.getNoiO().isEmpty()
                    |gv.getSoDienThoai().isEmpty()
                    |gv.getEmail().isEmpty()
//                    |gv.getToChuyenMon().isEmpty()
                    |gv.getDanToc().isEmpty()
                    |gv.getTonGiao().isEmpty()
                    |gv.getNgayCap().isEmpty()
                    |gv.getNoiCap().isEmpty()
              )
               return false;
           return true;
       }
}

