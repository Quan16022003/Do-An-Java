/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author anhkhoa
 */
public class K_NhanVienDonViDTO {

    private String  manv, tennv, tendonvi, madonvi;

    public K_NhanVienDonViDTO() {
    }

    public K_NhanVienDonViDTO( String manvi, String tennvi, String madonvii, String tendonvii) {
       
        manv = manvi;
        tennv = tennvi;
        tendonvi = tendonvii;
        madonvi = madonvii;
        
    }

  

    public String getmanv() {
        return manv;
    }

    public void setmanv(String manvi) {
         manv = manvi;
    }

    public String getten() {
        return tennv;
    }

    public void setten(String tennvi) {
        this.tennv = tennvi;
    }
    
    public String gettendonvi() {
        return tendonvi;
    }

    public void settendonvi(String tendonvii) {
        this.tendonvi = tendonvii;
    }

     public String getmadonvi() {
        return madonvi;
    }

    public void setmadonvi(String madonvii) {
        this.madonvi = madonvii;
    }
    @Override
    public String toString() {
        return "Mã nhân viên: "+manv+"|Tên nhân viên: "+tennv+"|Mã đơn vị: "+madonvi+"|Tên đơn vị: "+tendonvi;
    }
    public String toString2() {
        return "MANV: "+manv+"|TENNV: "+tennv+"|MADV: "+madonvi+"|TENDV: "+tendonvi;
    }
}
