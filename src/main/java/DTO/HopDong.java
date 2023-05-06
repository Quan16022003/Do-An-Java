/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author apple
 */
public class HopDong {
    private String MaHD, MaLoaiHD, MaNV, TenHD, NgayKy, HanHD, HocVi, Hang, Bac, MaSoThue
            , CucThue, STK, NganHang, CongViecDuocGiao, HeSoLuong, HeSoPhuCap;
    public HopDong(String MaHD,String MaLoaiHD,String MaNV,String TenHD,String NgayKy,
            String HanHD,String HocVi,String Hang,String Bac,String MaSoThue
            ,String CucThue, String STK,String NganHang,String CongViecDuocGiao,String HeSoLuong,
            String HeSoPhuCap)
    {
        this.MaHD = MaHD;
        this.MaLoaiHD = MaLoaiHD;
        this.MaNV = MaNV;
        this.TenHD = TenHD;
        this.NgayKy = NgayKy;
        this.HanHD = HanHD;
        this.HocVi = HocVi;
        this.Hang = Hang;
        this.Bac = Bac;
        this.MaSoThue = MaSoThue;
        this.CucThue = CucThue;
        this.STK = STK;
        this.NganHang = NganHang;
        this.CongViecDuocGiao = CongViecDuocGiao;
        this.HeSoLuong = HeSoLuong;
        this.HeSoPhuCap = HeSoPhuCap;
    }

    public HopDong() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public String getCongViecDuocGiao() {
        return CongViecDuocGiao;
    }

    public void setCongViecDuocGiao(String CongViecDuocGiao) {
        this.CongViecDuocGiao = CongViecDuocGiao;
    }

    public String getHeSoLuong() {
        return HeSoLuong;
    }

    public void setHeSoLuong(String HeSoLuong) {
        this.HeSoLuong = HeSoLuong;
    }

    public String getHeSoPhuCap() {
        return HeSoPhuCap;
    }

    public void setHeSoPhuCap(String HeSoPhuCap) {
        this.HeSoPhuCap = HeSoPhuCap;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaLoaiHD() {
        return MaLoaiHD;
    }

    public void setMaLoaiHD(String MaLoaiHD) {
        this.MaLoaiHD = MaLoaiHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenHD() {
        return TenHD;
    }

    public void setTenHD(String TenHD) {
        this.TenHD = TenHD;
    }

    public String getNgayKy() {
        return NgayKy;
    }

    public void setNgayKy(String NgayKy) {
        this.NgayKy = NgayKy;
    }

    public String getHanHD() {
        return HanHD;
    }

    public void setHanHD(String HanHD) {
        this.HanHD = HanHD;
    }

    public String getHocVi() {
        return HocVi;
    }

    public void setHocVi(String HocVi) {
        this.HocVi = HocVi;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    public String getBac() {
        return Bac;
    }

    public void setBac(String Bac) {
        this.Bac = Bac;
    }

    public String getMaSoThue() {
        return MaSoThue;
    }

    public void setMaSoThue(String MaSoThue) {
        this.MaSoThue = MaSoThue;
    }

    public String getCucThue() {
        return CucThue;
    }

    public void setCucThue(String CucThue) {
        this.CucThue = CucThue;
    }

    public String getSTK() {
        return STK;
    }

    public void setSTK(String STK) {
        this.STK = STK;
    }

    public String getNganHang() {
        return NganHang;
    }

    public void setNganHang(String NganHang) {
        this.NganHang = NganHang;
    }
    
}
