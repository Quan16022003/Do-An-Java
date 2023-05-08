/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.ChamCong;
import DTO.TaiKhoan;

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
public class TaiKhoanDAO extends AbstractDAO<TaiKhoan, String> {

    private static final Logger LOGGER = Logger.getLogger(TaiKhoanDAO.class.getName());

    @Override
    public boolean insert(TaiKhoan taiKhoan) {
        String query = "INSERT INTO tai_khoan(username, password, MaNV, role) VALUES (?, ?, ?, ?)";
        mySQLConnection.openConnection();
        int rowsInserted = mySQLConnection.executeUpdate(query, taiKhoan.getUsername(), taiKhoan.getPassword(), taiKhoan.getMaNhanVien(), taiKhoan.getRole());
        LOGGER.log(Level.SEVERE, (rowsInserted > 0) ? "insert successfully" : "insert failed");
        mySQLConnection.closeConnection();
        return rowsInserted > 0;
    }

    @Override
    public boolean update(TaiKhoan taiKhoan) {
        String query = "UPDATE tai_khoan SET password=?, role=? WHERE username=?";
        mySQLConnection.openConnection();
        int rowsUpdated = mySQLConnection.executeUpdate(query, taiKhoan.getPassword(), taiKhoan.getRole(), taiKhoan.getUsername());
        LOGGER.log(Level.SEVERE, (rowsUpdated > 0)? "update successfully" : "update failed");
        mySQLConnection.closeConnection();
        return rowsUpdated > 0;
    }

    @Override
    public boolean delete(String username) {
        String query = "UPDATE tai_khoan SET is_deleted=1 WHERE username = ?";
        mySQLConnection.openConnection();
        int rowsDeleted = mySQLConnection.executeUpdate(query, username);
        LOGGER.log(Level.SEVERE, (rowsDeleted > 0)? "delete successfully" : "delete failed");
        mySQLConnection.closeConnection();
        return rowsDeleted > 0;
    }

    @Override
    public TaiKhoan select(String username) {
        String query = "SELECT * FROM tai_khoan WHERE username=? AND is_deleted=0";
        try {
            mySQLConnection.openConnection();
            ResultSet rs = mySQLConnection.executeQuery(query, username);
            TaiKhoan taiKhoan = null;
            if (rs.next()) {
                taiKhoan = new TaiKhoan(rs);
            }
            mySQLConnection.closeConnection();
            return taiKhoan;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<TaiKhoan> selectAll() {
        String query = "SELECT * FROM tai_khoan WHERE is_deleted=0";
        try {
            mySQLConnection.openConnection();
            List<TaiKhoan> taiKhoans = new ArrayList<>();
            ResultSet rs = mySQLConnection.executeQuery(query);
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(rs);
                taiKhoans.add(taiKhoan);
            }
            mySQLConnection.closeConnection();
            return taiKhoans;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return new ArrayList<>();
        }
    }

}