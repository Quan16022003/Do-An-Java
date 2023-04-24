/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.ChamCong;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class ChamCongDAO extends AbstractDAO<ChamCong, String> {

        private static final Logger LOGGER = Logger.getLogger(ChamCongDAO.class.getName());

    @Override
    public boolean insert(ChamCong t) {
        String query = "INSERT INTO cham_cong(ma_nhan_vien, ten_nhan_vien, ngay_cham_cong, gio_bd, gio_kt) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            mySQLConnection.openConnection();
            int rowsInserted = mySQLConnection.executeUpdate(query,t.getMaNV(),t.getHoTen(),t.getNgayThang(),t.getTimeIn(),t.getTimeOut());
            LOGGER.log(Level.SEVERE, (rowsInserted > 0) ? "insert successfully" : "insert failed");
            mySQLConnection.closeConnection();
            
            return rowsInserted >0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;    
    }
   
    @Override
    public boolean update(ChamCong t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChamCong select(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChamCong> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public ArrayList<ChamCong> getListChamCong() {
        ArrayList<ChamCong> listChamCong = new ArrayList<>();
        String query = "SELECT * FROM cham_cong";
        try {
            mySQLConnection.openConnection();
            ResultSet rs = mySQLConnection.executeQuery(query);
            while (rs.next()) {
                ChamCong chamCong = new ChamCong();
                chamCong.setMaNV(rs.getString("ma_nhan_vien"));
                chamCong.setHoTen(rs.getString("ten_nhan_vien"));
                chamCong.setNgayThang(rs.getDate("ngay_cham_cong"));
                chamCong.setTimeIn(rs.getInt("gio_bd"));
                chamCong.setTimeOut(rs.getInt("gio_kt"));
                
                listChamCong.add(chamCong);
            }
            mySQLConnection.closeConnection();
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return new ArrayList<>();
        }

        return listChamCong;
    }
}
