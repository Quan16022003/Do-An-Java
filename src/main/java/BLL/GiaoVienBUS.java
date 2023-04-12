/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.GiaoVien;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author apple
 */
public class GiaoVienBUS {
       public boolean check(GiaoVien gv){
           String EMAIL_PATTERN = 
            "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
           if (
                    Pattern.matches("[0-9]*",gv.getCCCD())
//                    |Pattern.matches("^[1-zA-Z0-9\\s\\/]*$",gv.getDiaChi())
//                    |Pattern.matches("[a-z0-9]*",gv.getMaGV())
//                    |Pattern.matches("[a-z0-9\\s]*",gv.getHoTen())
//                    |Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$", gv.getNgaySinh())
//                    |Pattern.matches("[a-z\\s]*",gv.getMonHoc())
//                    |Pattern.matches("(?i)(nam|nu)",gv.getGioiTinh())
//                    |Pattern.matches("[a-z\\s]*",gv.getNoiSinh())
//                    |Pattern.matches("[a-z\\s]*",gv.getQueQuan())
//                    |Pattern.matches("^[1-zA-Z0-9\\s\\/]*$",gv.getNoiO())
//                    |Pattern.matches("[0-9\\s]*", gv.getSoDienThoai())
//                    |Pattern.matches(EMAIL_PATTERN, gv.getEmail())
//                    |Pattern.matches("[a-z\\s]*",gv.getToChuyenMon())
                    |gv.getCCCD().isEmpty()
                    |gv.getDiaChi().isEmpty()
                    |gv.getMaGV().isEmpty()
                    |gv.getHoTen().isEmpty()
                    |gv.getNgaySinh().isEmpty()
                    |gv.getMonHoc().isEmpty()
                    |gv.getGioiTinh().isEmpty()
                    |gv.getNoiSinh().isEmpty()
                    |gv.getQueQuan().isEmpty()
                    |gv.getNoiO().isEmpty()
                    |gv.getSoDienThoai().isEmpty()
                    |gv.getEmail().isEmpty()
                    |gv.getToChuyenMon().isEmpty()
              )
               return false;
           return true;
       }
}

