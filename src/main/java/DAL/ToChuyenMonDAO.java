/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.ToChuyenMon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class ToChuyenMonDAO {
    // Singleton instance
    private static ToChuyenMonDAO instance;
    private Connection conn;
    
    private ToChuyenMonDAO() throws SQLException{
        conn = DBConnection.getInstance().getConnection();
    }
    
    // get singleton instance
    public static ToChuyenMonDAO getInstance(){
        if (instance == null) {
            try {
                instance = new ToChuyenMonDAO();
            } catch (SQLException ex) {
                Logger.getLogger(ToChuyenMonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }
    
    public ToChuyenMon get(String ma) {
        ToChuyenMon to = new ToChuyenMon();
        String query = "SELECT * FROM to_chuyen_mon WHERE ma = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, ma);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                to.setMaTCM(rs.getString("ma"));
                to.setTenTCM(rs.getString("ten_to"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToChuyenMonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return to;
    }
    public List<ToChuyenMon> getAll() {
        List<ToChuyenMon> list = new ArrayList<>();
        String query = "SELECT * FROM to_chuyen_mon";
        try (PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ToChuyenMon tcm = new ToChuyenMon();
                tcm.setMaTCM(rs.getString("ma"));
                tcm.setTenTCM(rs.getString("ten_to"));
                list.add(tcm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToChuyenMonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
