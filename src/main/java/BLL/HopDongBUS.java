/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.HopDongDAO;
import DTO.HopDong;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author apple
 */
public class HopDongBUS extends javax.swing.JDialog{
    private List<HopDong> HopDongs;
    private HopDongDAO Dao;
    public boolean check(HopDong nv){
        Dao = new HopDongDAO();
        System.out.println("Checking...");
        HopDongs = Dao.selectAll();
        for (HopDong key : HopDongs)
        if (key.getMaHD().equals(nv.getMaHD()))
            {
                   JOptionPane.showMessageDialog(rootPane, "Mã hợp đồng này đang được sử dụng "); return false;
            } 
        if (Pattern.matches("[a-z0-9]*",nv.getMaNV())==false)
            {
                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : mã nhân viên "); return false;
            }
        if (Pattern.matches("[a-z0-9]*",nv.getMaHD())==false)
            {
                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : mã hợp đồng"); return false;
            }
//        if (Pattern.matches("\\d{12}",nv.getSTK())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : số tài khoản"); return false;
//            }
//        if (Pattern.matches("[a-z0-9\\s]*",nv.getHocVi())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : học vị"); return false;
//            }
//        if (Pattern.matches("[a-z0-9]*",nv.getMaSoThue())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : mã số thuế"); return false;
//            }
//        if (Pattern.matches("[a-z0-9\\s]*",nv.getNganHang())==false)     
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : ngân hàng"); return false;
//            }
        if (Pattern.matches("[a-z0-9\\s]*",nv.getTenHD())==false)
            {
                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : tên hợp đồng"); return false;
            }
//        if (Pattern.matches("[a-z0-9\\s]*",nv.getCucThue())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : cục thuế"); return false;
//            }
        if (Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",nv.getNgayKy())==false)
            {
                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : ngày ký"); return false;
            }
        if (Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",nv.getHanHD())==false)
            {
                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : hạn dùng"); return false;
            }
//        if (Pattern.matches("[a-z0-9\\s]*",nv.getBac())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : bậc"); return false;
//            }
//        if (Pattern.matches("[+-]?([0-9]*[.])?[0-9]+",nv.getHeSoLuong())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : hệ số lương"); return false;
//            }
//        if (Pattern.matches("[+-]?([0-9]*[.])?[0-9]+",nv.getHeSoPhuCap())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : hệ số phụ cấp"); return false;
//            }    
        
        if (              
                  nv.getMaHD().isEmpty()
//                |nv.getMaLoaiHD().isEmpty()
                |nv.getMaNV().isEmpty()
                |nv.getNgayKy().isEmpty()
                |nv.getHanHD().isEmpty()
//                |nv.getHocVi().isEmpty()
//                |nv.getHang().isEmpty()
//                |nv.getBac().isEmpty()
//                |nv.getMaSoThue().isEmpty()
//                |nv.getCucThue().isEmpty()
//                |nv.getSTK().isEmpty()
//                |nv.getNganHang().isEmpty()
                |nv.getTenHD().isEmpty()
//                |nv.getHeSoLuong().isEmpty()
//                |nv.getHeSoPhuCap().isEmpty()
              )
               return false;
           return true;
    }
}
