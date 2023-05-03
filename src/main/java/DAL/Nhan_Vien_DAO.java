/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Nhan_Vien;
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
public class Nhan_Vien_DAO {
    public void add(Nhan_Vien nv) {
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO Nhan_Vien(MaNV, MaDV, MaLoaiNV, MaChucVu, Ten, GioiTinh, NgSinh, SDT, SoNha, Duong, Phuong_Xa, Quan_Huyen, Tp_Tinh, CCCD, NgCap, NoiCap, NgVaoLam, image) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nv.getMaNV());
            stmt.setString(2, nv.getMaDV());
            stmt.setString(3, nv.getMaLoaiNV());
            stmt.setString(4, nv.getMaChucVu());
            stmt.setString(5, nv.getTen());
            stmt.setString(6, nv.getGioiTinh());
            stmt.setString(7, nv.getNgSinh());
            stmt.setString(8, nv.getSDT());
            stmt.setString(9, nv.getSoNha());
            stmt.setString(10, nv.getDuong());
            stmt.setString(11, nv.getPhuong_Xa());
            stmt.setString(12, nv.getQuan_Huyen());
            stmt.setString(13, nv.getTP_Tinh());
            stmt.setString(14, nv.getCCCD());
            stmt.setString(15, nv.getNgCap());
            stmt.setString(16, nv.getNoiCap());
            stmt.setString(17, nv.getNgVaoLam());
            stmt.setString(18, nv.getImage());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void edit(Nhan_Vien nv) {
        Connection conn = DBConnection.getInstance().getConnection();
        String query = "UPDATE Nhan_Vien SET MaDV = ?, MaLoaiNV = ?, MaChucVu = ?, Ten = ?, GioiTinh = ?, NgSinh = ?, SDT = ?, SoNha = ?, Duong = ?, Phuong_Xa = ?, Quan_Huyen = ?, Tp_Tinh = ?, CCCD = ?, NgCap = ?, NoiCap = ?, NgVaoLam = ?, image = ? WHERE MaNV=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(18, nv.getMaNV());
            stmt.setString(1, nv.getMaDV());
            stmt.setString(2, nv.getMaLoaiNV());
            stmt.setString(3, nv.getMaChucVu());
            stmt.setString(4, nv.getTen());
            stmt.setString(5, nv.getGioiTinh());
            stmt.setString(6, nv.getNgSinh());
            stmt.setString(7, nv.getSDT());
            stmt.setString(8, nv.getSoNha());
            stmt.setString(9, nv.getDuong());
            stmt.setString(10, nv.getPhuong_Xa());
            stmt.setString(11, nv.getQuan_Huyen());
            stmt.setString(12, nv.getTP_Tinh());
            stmt.setString(13, nv.getCCCD());
            stmt.setString(14, nv.getNgCap());
            stmt.setString(15, nv.getNoiCap());
            stmt.setString(16, nv.getNgVaoLam());
            stmt.setString(17, nv.getImage());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
            
    }
}
