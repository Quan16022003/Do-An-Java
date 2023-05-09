package DTO;

import java.text.DecimalFormat;

public class Luong {
    private int id;
    private String maNV;
    private String tenNV;
    private int luongCB;
    private int ngayCongQD;
    private int ngayCongTT;
    private double hsLuong;
    private int luongHuong;
    private double hsChucVu;
    private double heSoPhuCap;
    private int mucPC;
    private int mucBH;
    private int thucLinh;

    public Luong() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(int luongCB) {
        this.luongCB = luongCB;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public double getHsChucVu() {
        return hsChucVu;
    }

    public void setHsChucVu(double hsChucVu) {
        this.hsChucVu = hsChucVu;
    }

    public double getHsLuong() {
        return hsLuong;
    }

    public void setHsLuong(double hsLuong) {
        this.hsLuong = hsLuong;
    }

    public int getLuongHuong() {
        return luongHuong;
    }

    public void setLuongHuong(int luongHuong) {
        this.luongHuong = luongHuong;
    }

    public int getMucPC() {
        return mucPC;
    }

    public void setMucPC(int mucPC) {
        this.mucPC = mucPC;
    }

    public int getMucBH() {
        return mucBH;
    }

    public void setMucBH(int mucBH) {
        this.mucBH = mucBH;
    }

    public int getThucLinh() {
        return thucLinh;
    }

    public void setThucLinh(int thucLinh) {
        this.thucLinh = thucLinh;
    }

    public double getHeSoPhuCap() {
        return heSoPhuCap;
    }

    public void setHeSoPhuCap(double heSoPhuCap) {
        this.heSoPhuCap = heSoPhuCap;
    }

    public int getNgayCongQD() {
        return ngayCongQD;
    }

    public void setNgayCongQD(int ngayCongQD) {
        this.ngayCongQD = ngayCongQD;
    }

    public int getNgayCongTT() {
        return ngayCongTT;
    }

    public void setNgayCongTT(int ngayCongTT) {
        this.ngayCongTT = ngayCongTT;
    }

    public void tinhLuong() {
        double tyLeNC = ngayCongTT * 1.0 / ngayCongQD;
        DecimalFormat df = new DecimalFormat("#.#");
        luongHuong = (int) (Double.valueOf(df.format(luongCB / 1000 * hsLuong * tyLeNC)) * 1000);
        mucPC = (int) (luongCB*1.0 / 1000 * (hsLuong + hsChucVu) * heSoPhuCap) * 1000;
        mucBH = (int) (Double.valueOf(df.format(luongHuong /1000 * 8.5 / 100)) * 1000);
        thucLinh = luongHuong + mucPC - mucBH;
        System.out.println(luongCB*1.0 / 1000 * (hsLuong + hsChucVu) * heSoPhuCap / 100);
    }

    @Override
    public String toString() {
        return "Luong{" +
                "maNV='" + maNV + '\'' +
                ", tenNV='" + tenNV + '\'' +
                ", luongCB=" + luongCB +
                ", ngayCongQD=" + ngayCongQD +
                ", ngayCongTT=" + ngayCongTT +
                ", hsChucVu=" + hsChucVu +
                ", hsLuong=" + hsLuong +
                ", luongHuong=" + luongHuong +
                ", HsPC=" + heSoPhuCap +
                ", mucPC=" + mucPC +
                ", mucBH=" + mucBH +
                ", thucLinh=" + thucLinh +
                '}';
    }
}