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
