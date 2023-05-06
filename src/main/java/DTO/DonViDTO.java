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
public class DonViDTO {

    private String madv, ten, role;

    public DonViDTO() {
    }

    public DonViDTO(String madvi, String teni) {

        this.madv = madvi;
        this.ten = teni;

    }
    public DonViDTO(String madvi, String teni,String rolei) {

        this.madv = madvi;
        this.ten = teni;
        this.role = rolei;
    }

    public String getmadv() {
        return madv;
    }

    public void setmadv(String madvi) {
        this.madv = madvi;
    }

    public String getten() {
        return ten;
    }

    public void setten(String teni) {
        this.ten = teni;
    }
    public String gettrole() {
        return role;
    }

    public void setrole(String rolei) {
        this.role = rolei;
    }

    @Override
    public String toString() {
        return "Mã đơn vị: " + madv + "| Tên đơn vị: " + ten;
    }

}
