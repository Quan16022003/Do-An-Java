/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.NhanVienDAO;
import DTO.NhanVien;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.apache.commons.collections4.IterableUtils;
/**
 *
 * @author apple
 */
public class NhanVienBUS extends javax.swing.JDialog{
    private List<NhanVien> NhanViens;
    private NhanVienDAO Dao;
    
    public boolean check(NhanVien nv){
        Dao = new NhanVienDAO();
        System.out.println("Checking...");
        NhanViens = Dao.selectAll();
        for (NhanVien key : NhanViens)
        if (key.getMaNV().equals(nv.getMaNV()))
            {
                   JOptionPane.showMessageDialog(rootPane, "Mã nhân viên này đang được sử dụng "); return false;
            } 
        if (Pattern.matches("[a-z0-9]*",nv.getMaNV())==false)
                {
                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : mã nhân viên "); return false;
            }
        if (Pattern.matches("[a-z0-9]*",nv.getMaDV())==false)
            {
                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : mã đơn vị "); return false;
            }
//        if (Pattern.matches("[a-z0-9]*",nv.getMaLoaiNV())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : loại nhân viên "); return false;
//            }
        if (Pattern.matches("[a-z0-9]*",nv.getMaChucVu())==false)
            {
                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : mã chức vụ "); return false;
            }
//        if (Pattern.matches("\\d{10}",nv.getSDT())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : số điện thoại "); return false;
//            }
//        if (Pattern.matches("\\d{12}",nv.getCCCD())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : căn cước công dân "); return false;
//            }
//        if (Pattern.matches("^[a-zA-Z0-9\\s\\/]*$",nv.getSoNha())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : số nhà "); return false;
//            }
//        if (Pattern.matches("^[a-zA-Z0-9\\s\\/]*$",nv.getDuong())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : Đường "); return false;
//            }
//        if (Pattern.matches("^[a-zA-Z0-9\\s\\/]*$",nv.getPhuong_Xa())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : Phường/Xã "); return false;
//            }
//        if (Pattern.matches("^[a-zA-Z0-9\\s\\/]*$",nv.getQuan_Huyen())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : Quận/Huyện "); return false;
//            }
//        if (Pattern.matches("[a-z0-9\\s]*",nv.getTP_Tinh())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : Thành phố/Tỉnh "); return false;
//            }
//        if (Pattern.matches("[a-z0-9\\s]*",nv.getNoiCap())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : nơi cấp "); return false;
//            }
//        if (Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",nv.getNgSinh())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : ngày sinh "); return false;
//            }
//        if (Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",nv.getNgCap())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : ngày cấp "); return false;
//            }
//        if (Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",nv.getNgVaoLam())==false)
//            {
//                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : ngày vào làm "); return false;
//            }
        if (Pattern.matches("[a-z0-9\\s]*",nv.getTen())==false)
            {
                   JOptionPane.showMessageDialog(rootPane, "Bạn nhập không hợp lệ : tên "); return false;
            }

        
        if (              
                  nv.getMaNV().isEmpty()
                |nv.getMaDV().isEmpty()
//                |nv.getMaLoaiNV().isEmpty()
                |nv.getMaChucVu().isEmpty()
                |nv.getTen().isEmpty()
//                |nv.getNgSinh().isEmpty()
//                |nv.getSDT().isEmpty()
//                |nv.getSoNha().isEmpty()
//                |nv.getDuong().isEmpty()
//                |nv.getPhuong_Xa().isEmpty()
//                |nv.getQuan_Huyen().isEmpty()
//                |nv.getTP_Tinh().isEmpty()
//                |nv.getCCCD().isEmpty()
//                |nv.getNgCap().isEmpty()
//                |nv.getNoiCap().isEmpty()
//                |nv.getNgVaoLam().isEmpty()
              )
               {
                   JOptionPane.showMessageDialog(rootPane, "Dữ liệu nhập chưa đủ"); return false;
            } 
        if (nv.getImage().isBlank())
            {
                   JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn Image"); return false;
            } 
           return true;
    }
}
