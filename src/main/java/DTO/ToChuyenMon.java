/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class ToChuyenMon {
    private String maTCM;
    private String tenTCM;

    public ToChuyenMon() {
    }

    public ToChuyenMon(String maTCM, String tenTCM) {
        this.maTCM = maTCM;
        this.tenTCM = tenTCM;
    }

    public String getMaTCM() {
        return maTCM;
    }

    public void setMaTCM(String maTCM) {
        this.maTCM = maTCM;
    }

    public String getTenTCM() {
        return tenTCM;
    }

    public void setTenTCM(String tenTCM) {
        this.tenTCM = tenTCM;
    }
    
    
}
