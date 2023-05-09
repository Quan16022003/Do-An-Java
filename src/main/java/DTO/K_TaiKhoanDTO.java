/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import org.apache.xmlbeans.UserType;

/**
 *
 * @author ADMIN
 */
public class K_TaiKhoanDTO {
    private String user, pass, manv;

    public K_TaiKhoanDTO(String user, String pass, String manv) {
        this.user = user;
        this.pass = pass;
        this.manv = manv;
    }

    public String getManv() {
        return manv;
    }

    public String getPass() {
        return pass;
    }

    public String getUser() {
        return user;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
    
}
