/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Nguyen Hoang Quan
 */

public class GiaoVien {
    private String maGiaoVien;
    private BanThan banThan;
    private String monHocGiangDay;
    private String toChuyenMon;
    private String chuNhiemLop;
    private Date ngayVaoNganh;
   
    private int hang;
    private int bacLuong;
    private double heSoLuong;
    private double heSoPhuCap;
    private double heSoThamNien;
    
    private List<ThoiKhoaBieu> thoiKhoaBieus;
    
    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public BanThan getBanThan() {
        return banThan;
    }

    public void setBanThan(BanThan banThan) {
        this.banThan = banThan;
    }

    public String getMonHocGiangDay() {
        return monHocGiangDay;
    }

    public void setMonHocGiangDay(String monHocGiangDay) {
        this.monHocGiangDay = monHocGiangDay;
    }

    public String getToChuyenMon() {
        return toChuyenMon;
    }

    public void setToChuyenMon(String toChuyenMon) {
        this.toChuyenMon = toChuyenMon;
    }

    public String getChuNhiemLop() {
        return chuNhiemLop;
    }

    public void setChuNhiemLop(String chuNhiemLop) {
        this.chuNhiemLop = chuNhiemLop;
    }

    public Date getNgayVaoNganh() {
        return ngayVaoNganh;
    }

    public void setNgayVaoNganh(Date ngayVaoNganh) {
        this.ngayVaoNganh = ngayVaoNganh;
    }

    public int getHang() {
        return hang;
    }

    public void setHang(int hang) {
        this.hang = hang;
    }

    public int getBacLuong() {
        return bacLuong;
    }

    public void setBacLuong(int bacLuong) {
        this.bacLuong = bacLuong;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getHeSoPhuCap() {
        return heSoPhuCap;
    }

    public void setHeSoPhuCap(double heSoPhuCap) {
        this.heSoPhuCap = heSoPhuCap;
    }

    public double getHeSoThamNien() {
        return heSoThamNien;
    }

    public void setHeSoThamNien(double heSoThamNien) {
        this.heSoThamNien = heSoThamNien;
    }

    public List<ThoiKhoaBieu> getThoiKhoaBieus() {
        return thoiKhoaBieus;
    }

    public void setThoiKhoaBieus(List<ThoiKhoaBieu> thoiKhoaBieus) {
        this.thoiKhoaBieus = thoiKhoaBieus;
    }
    
}
