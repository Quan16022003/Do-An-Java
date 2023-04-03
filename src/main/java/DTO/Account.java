/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class Account {
    private String userName;
    private String password;
    private String ma_giao_vien;

    public Account() {
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMa_giao_vien() {
        return ma_giao_vien;
    }

    public void setMa_giao_vien(String ma_giao_vien) {
        this.ma_giao_vien = ma_giao_vien;
    }
    
    
    
}
