/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class NhanVienDTO_u_nvdv_pass {

    private String manv, tennv, madv,tendv, ngsinh;

    public NhanVienDTO_u_nvdv_pass() {
    }

    public NhanVienDTO_u_nvdv_pass(String manvi, String tennvi) {

        this.manv = manvi;
        this.tennv = tennvi;

    }

    public NhanVienDTO_u_nvdv_pass(String manvi, String tennvi, String madvi, String ngsinhi) {

        this.manv = manvi;
        this.tennv = tennvi;
        this.madv = madvi;
        this.ngsinh = ngsinhi;

    }
    public NhanVienDTO_u_nvdv_pass(String manvi, String tennvi, String madvi,String tendvi, String ngsinhi) {

        this.manv = manvi;
        this.tennv = tennvi;
        this.madv = madvi;
        this.ngsinh = ngsinhi;

    }

    public String getmanv() {
        return manv;
    }

    public void setmanv(String manvi) {
        this.manv = manvi;
    }
    
    
    public String gettendv() {
        return manv;
    }

    public void settendv(String tendvi) {
        this.tendv = tendvi;
    }

    public String gettennv() {
        return tennv;
    }

    public void settennv(String tennvi) {
        this.tennv = tennvi;
    }

    public String getmadv() {
        return madv;
    }

    public void setmadv(String manvi) {
        this.madv = manvi;
    }

    public String getngsinh() {
        return ngsinh;
    }

    public void setngsinh(String ngsinhi) {
        this.ngsinh = ngsinhi;
    }

}
