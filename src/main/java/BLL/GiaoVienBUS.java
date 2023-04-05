/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.GiaoVien;

/**
 *
 * @author apple
 */
public class GiaoVienBUS {
       public boolean check(GiaoVien gv){
           int cccd = 0;
           if (gv.getCCCD().isBlank() != false)
               cccd = Integer.parseInt(gv.getCCCD());
           if (
                   cccd * 0 != 0
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

