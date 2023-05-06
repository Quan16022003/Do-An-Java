/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.NhanVien;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author apple
 */
public class NhanVienBUS extends javax.swing.JDialog{
    public boolean check(NhanVien nv){
        if (Pattern.matches("[a-z0-9]*",nv.getMaNV())==false
                |Pattern.matches("[a-z0-9]*",nv.getMaDV())==false
                |Pattern.matches("[a-z0-9]*",nv.getMaLoaiNV())==false
                |Pattern.matches("[a-z0-9]*",nv.getMaChucVu())==false
                |Pattern.matches("\\d{10}",nv.getSDT())==false
                |Pattern.matches("\\d{12}",nv.getCCCD())==false
                |Pattern.matches("^[a-zA-Z0-9\\s\\/]*$",nv.getSoNha())==false
                |Pattern.matches("^[a-zA-Z0-9\\s\\/]*$",nv.getDuong())==false
                |Pattern.matches("^[a-zA-Z0-9\\s\\/]*$",nv.getPhuong_Xa())==false
                |Pattern.matches("^[a-zA-Z0-9\\s\\/]*$",nv.getQuan_Huyen())==false
                |Pattern.matches("[a-z0-9\\s]*",nv.getTP_Tinh())==false
                |Pattern.matches("[a-z0-9\\s]*",nv.getNoiCap())==false
                |Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",nv.getNgSinh())==false
                |Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",nv.getNgCap())==false
                |Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",nv.getNgVaoLam())==false
                |Pattern.matches("[a-z0-9\\s]*",nv.getTen())==false
                |Pattern.matches("(?i)(nam|nu)",nv.getGioiTinh())==false
                )
            {
                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập quá yếu kém"); return false;
            } 
        
        if (              
                  nv.getMaNV().isEmpty()
                |nv.getMaDV().isEmpty()
                |nv.getMaLoaiNV().isEmpty()
                |nv.getMaChucVu().isEmpty()
                |nv.getTen().isEmpty()
                |nv.getGioiTinh().isEmpty()
                |nv.getNgSinh().isEmpty()
                |nv.getSDT().isEmpty()
                |nv.getSoNha().isEmpty()
                |nv.getDuong().isEmpty()
                |nv.getPhuong_Xa().isEmpty()
                |nv.getQuan_Huyen().isEmpty()
                |nv.getTP_Tinh().isEmpty()
                |nv.getCCCD().isEmpty()
                |nv.getNgCap().isEmpty()
                |nv.getNoiCap().isEmpty()
                |nv.getNgVaoLam().isEmpty()
                |nv.getImage().isEmpty()
              )
               return false;
           return true;
    }
}
