/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class BanThan {
    private String maGiaoVien;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String noiSinh;
    private String queQuan;
    private String DiaChiThuongTru;
    private String noiOHienNay;
    private String sdt;
    private String danToc;
    private String tonGiao;

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getDiaChiThuongTru() {
        return DiaChiThuongTru;
    }

    public void setDiaChiThuongTru(String diaChiThuongTru) {
        DiaChiThuongTru = diaChiThuongTru;
    }

    public String getNoiOHienNay() {
        return noiOHienNay;
    }

    public void setNoiOHienNay(String noiOHienNay) {
        this.noiOHienNay = noiOHienNay;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }
}
