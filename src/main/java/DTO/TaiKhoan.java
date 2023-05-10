package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class TaiKhoan {
    private String username;
    private String password;
    private String maNhanVien;
    private int role;

    public TaiKhoan() {
    }

    public TaiKhoan(ResultSet rs) throws SQLException {
        setUsername(rs.getString("username"));
        setPassword(rs.getString("password"));
        setMaNhanVien(rs.getString("MaNV"));
        setRole(rs.getInt("role"));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", maGiaoVien='" + maNhanVien + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}