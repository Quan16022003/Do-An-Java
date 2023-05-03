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
        String query = "INSERT INTO cham_cong(ma_nhan_vien, ngay_cham_cong, gio_bd, gio_kt, xac_nhan, is_deleted) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            mySQLConnection.openConnection();
            int rowsInserted = mySQLConnection.executeUpdate(query, t.getMaNV(), t.getNgayThang(), t.getTimeIn(), t.getTimeOut(), t.getxacNhan(), 0);
            LOGGER.log(Level.SEVERE, (rowsInserted > 0) ? "insert successfully" : "insert failed");
            mySQLConnection.closeConnection();

            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ChamCong t) {
        String query = "UPDATE cham_cong SET xac_nhan=?, gio_kt=?, gio_bd=? "
                + "WHERE ma_nhan_vien=? AND ngay_cham_cong=? ";
        try {
            mySQLConnection.openConnection();
            int rowsUpdated = mySQLConnection.executeUpdate(query, t.getxacNhan(), t.getTimeOut(), t.getTimeIn(),
                    t.getMaNV(), t.getNgayThang());
            LOGGER.log(Level.SEVERE, (rowsUpdated > 0) ? "update successfully" : "update failed");
            mySQLConnection.closeConnection();

            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDeleted(ChamCong t) {
        String query = "UPDATE cham_cong SET is_deleted=1 "
                + "WHERE ma_nhan_vien=? AND ngay_cham_cong=?";
        try {
            mySQLConnection.openConnection();
            int rowsUpdated = mySQLConnection.executeUpdate(query, t.getMaNV(), t.getNgayThang());
            LOGGER.log(Level.SEVERE, (rowsUpdated > 0) ? "update successfully" : "update failed");
            mySQLConnection.closeConnection();

            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ChamCong> find(String k) {
        List<ChamCong> listChamCong = new ArrayList<>();
        String query = "SELECT * FROM cham_cong WHERE (ma_nhan_vien like '%"+k+"%' OR ngay_cham_cong like '%"+k+"%' OR gio_bd like '%"+k+"%' OR gio_kt like '%"+k+"%' ) and is_deleted =0";
        try {
            mySQLConnection.openConnection();
            ResultSet rowsFound = mySQLConnection.executeQuery(query);
            while (rowsFound.next()) {
                ChamCong x = new ChamCong();
                x.setMaNV(rowsFound.getString("ma_nhan_vien"));
                x.setxacNhan(rowsFound.getString("xac_nhan"));
                x.setNgayThang(rowsFound.getDate("ngay_cham_cong"));
                x.setTimeIn(rowsFound.getString("gio_bd"));
                x.setTimeOut(rowsFound.getString("gio_kt"));
                listChamCong.add(x);
            }
            mySQLConnection.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChamCong;
    }

    @Override
    public boolean delete(String k) {

        return false;
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
        String query = "SELECT * FROM cham_cong WHERE is_deleted=0 AND gio_bd != gio_kt";
        try {
            mySQLConnection.openConnection();
            ResultSet rs = mySQLConnection.executeQuery(query);
            while (rs.next()) {
                ChamCong chamCong = new ChamCong();
                chamCong.setMaNV(rs.getString("ma_nhan_vien"));
                chamCong.setxacNhan(rs.getString("xac_nhan"));
                chamCong.setNgayThang(rs.getDate("ngay_cham_cong"));
                chamCong.setTimeIn(rs.getString("gio_bd"));
                chamCong.setTimeOut(rs.getString("gio_kt"));

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
