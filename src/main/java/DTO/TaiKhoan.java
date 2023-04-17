/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    private String maGiaoVien;
    private String role;

    public TaiKhoan() {
    }

    public TaiKhoan(ResultSet rs) throws SQLException {
        setUsername(rs.getString("username"));
        setPassword(rs.getString("password"));
        setMaGiaoVien(rs.getString("ma_giao_vien"));
        setRole(rs.getString("role"));
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

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", maGiaoVien='" + maGiaoVien + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
