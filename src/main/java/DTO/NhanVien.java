/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author apple
 */
public class NhanVien {
    private String MaNV, MaDV, MaLoaiNV, MaChucVu, Ten, GioiTinh, NgSinh, SDT,
            SoNha, Duong, Phuong_Xa, Quan_Huyen, TP_Tinh, CCCD, NgCap, NoiCap, NgVaoLam, image;
    public NhanVien(){
        this.MaDV = "0";
    }
    public NhanVien(String MaNV, String MaDV, String MaLoaiNV, String MaChucVu
            ,String Ten, String GioiTinh, String NgSinh, String SDT, String SoNha, String Duong, String Phuong_Xa,
            String Quan_Huyen, String TP_Tinh, String CCCD, String NgCap, String NoiCap, String NgVaoLam, String image)
            {
        this.MaNV = MaNV; ///2 k
        this.MaDV = MaDV;/////////2k
        this.MaLoaiNV = MaLoaiNV;//////2k
        this.MaChucVu = MaChucVu;/////2    11111
        this.Ten = Ten;  /////1k
        this.GioiTinh = GioiTinh;////1k
        this.NgSinh = NgSinh;///1 k
        this.SDT = SDT;/////1k
        this.SoNha = SoNha;/////1o
        this.Duong = Duong;/////1o
        this.Phuong_Xa = Phuong_Xa;///////1o
        this.Quan_Huyen = Quan_Huyen;///////1o
        this.TP_Tinh = TP_Tinh;//////1o
        this.CCCD = CCCD;//////1k
        this.NgCap = NgCap;//////1k
        this.NoiCap = NoiCap;//////1k
        this.NgVaoLam = NgVaoLam;   ////////2k 2222
        this.image = image;
        /////5 2
        ////12 1
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public String getMaLoaiNV() {
        return MaLoaiNV;
    }

    public void setMaLoaiNV(String MaLoaiNV) {
        this.MaLoaiNV = MaLoaiNV;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgSinh() {
        return NgSinh;
    }

    public void setNgSinh(String NgSinh) {
        this.NgSinh = NgSinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getSoNha() {
        return SoNha;
    }

    public void setSoNha(String SoNha) {
        this.SoNha = SoNha;
    }

    public String getDuong() {
        return Duong;
    }

    public void setDuong(String Duong) {
        this.Duong = Duong;
    }

    public String getPhuong_Xa() {
        return Phuong_Xa;
    }

    public void setPhuong_Xa(String Phuong_Xa) {
        this.Phuong_Xa = Phuong_Xa;
    }

    public String getQuan_Huyen() {
        return Quan_Huyen;
    }

    public void setQuan_Huyen(String Quan_Huyen) {
        this.Quan_Huyen = Quan_Huyen;
    }

    public String getTP_Tinh() {
        return TP_Tinh;
    }

    public void setTP_Tinh(String TP_Tinh) {
        this.TP_Tinh = TP_Tinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getNgCap() {
        return NgCap;
    }

    public void setNgCap(String NgCap) {
        this.NgCap = NgCap;
    }

    public String getNoiCap() {
        return NoiCap;
    }

    public void setNoiCap(String NoiCap) {
        this.NoiCap = NoiCap;
    }

    public String getNgVaoLam() {
        return NgVaoLam;
    }

    public void setNgVaoLam(String NgVaoLam) {
        this.NgVaoLam = NgVaoLam;
    }
    
    
}
