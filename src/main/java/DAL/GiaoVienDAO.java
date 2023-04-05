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
    
}
