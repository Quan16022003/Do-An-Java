/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class NV_quyenDTO {

    private String manv,madv,r1, r2, r3, r4, r5;

    
    public NV_quyenDTO() {
        
    }
    
    public NV_quyenDTO(String manv, String madv, String r1, String r2, String r3, String r4, String r5) {
        this.manv = manv;
        this.madv = madv;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.r5 = r5;
    }
    
    
    
    
    
    
    public String getmadv() {
        return this.madv;
    }
    public void setmadv(String madvi) {
        this.madv = madvi;
    }
    
    public String getmanv() {
        return this.manv;
    }

    public String getr1() {
        return this.r1;
    }

    public String getr2() {
        return this.r2;
    }

    public String getr3() {
        return this.r3;
    }

    public String getr4() {
        return this.r4;
    }

    public String getr5() {
        return this.r5;
    }

    public void setmanv(String manvi) {
        this.manv = manvi;
    }

    public void setr1(String r1i) {
        this.r1 = r1i;
    }

    public void setr2(String r2i) {
        this.r2 = r2i;
    }

    public void setr3(String r3i) {
        this.r3 = r3i;
    }

    public void setr4(String r4i) {
        this.r4 = r4i;
    }

    public void setr5(String r5i) {
        this.r5 = r5i;
    }

}
