/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.GiaoVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author apple
 */
public class GiaoVienDAO {
    public void add(GiaoVien gv) {
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO giaovien(ma, mama) VALUES (?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, gv.getMaGV());
            stmt.setString(2, gv.getMonHoc());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void edit(GiaoVien gv) {
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "UPDATE giaovien SET mama=? WHERE ma=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(2, gv.getMaGV());
            stmt.setString(1, gv.getMonHoc());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
            
    }

//    @Override
//    public boolean insert(GiaoVien gv) {
//        String query = "INSERT INTO ban_than(ma_giao_vien, ho_ten, gioi_tinh, ngay_sinh, noi_sinh, que_quan, dia_chi_thuong_tru, noi_o_hien_tai, sdt, dan_toc, ton_giao, so_cccd, ngay_cap, noi_cap) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        return executeUpdate(query, gv.getMaGV(),gv.getHoTen(),gv.getGioiTinh(),gv.getNgaySinh(),gv.getNoiSinh(),gv.getQueQuan(),gv.getDiaChi(),gv.getNoiO(),gv.getSoDienThoai(),gv.getDanToc(),gv.getTonGiao(),gv.getCCCD(),gv.getNgayCap(),gv.getNoiCap());
//    }
//
//    @Override
//    public boolean update(GiaoVien t) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public boolean delete(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public GiaoVien select(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<GiaoVien> selectAll() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
}
