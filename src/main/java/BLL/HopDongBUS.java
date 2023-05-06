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
        if (Pattern.matches("[a-z0-9]*",nv.getMaNV())==false
                |Pattern.matches("[a-z0-9]*",nv.getMaHD())==false
                |Pattern.matches("\\d{12}",nv.getSTK())==false
                |Pattern.matches("[a-z0-9\\s]*",nv.getHocVi())==false
                |Pattern.matches("[a-z0-9]*",nv.getMaSoThue())==false
                |Pattern.matches("[a-z0-9\\s]*",nv.getNganHang())==false
                |Pattern.matches("[a-z0-9\\s]*",nv.getCongViecDuocGiao())==false
                |Pattern.matches("[a-z0-9\\s]*",nv.getCucThue())==false
                |Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",nv.getNgayKy())==false
                |Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",nv.getHanHD())==false
                |Pattern.matches("[a-z0-9\\s]*",nv.getHanHD())==false
                |Pattern.matches("[a-z0-9\\s]*",nv.getBac())==false
                |Pattern.matches("[+-]?([0-9]*[.])?[0-9]+",nv.getHeSoLuong())==false
                |Pattern.matches("[+-]?([0-9]*[.])?[0-9]+",nv.getHeSoPhuCap())==false
                )
            {
                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập quá yếu kém"); return false;
            }    
        
        if (              
                  nv.getMaHD().isEmpty()
//                |nv.getMaLoaiHD().isEmpty()
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
                |nv.getCongViecDuocGiao().isEmpty()
                |nv.getHeSoLuong().isEmpty()
                |nv.getHeSoPhuCap().isEmpty()
              )
               return false;
           return true;
    }
}
