/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DVdao;
import DTO.DonViDTO;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class DVbus {

    private ArrayList<DonViDTO> dsdv;

    public DVbus() {
        list();
    }

    public DVbus(int i) {
        list();
    }

    public void list() {
        DVdao dvdao = new DVdao();
        dsdv = new ArrayList<>();
        dsdv = dvdao.list();
    }

    public ArrayList<DonViDTO> getList() {
        return dsdv;
    }

    public void add(DonViDTO dv) {
        String mdvr = "dv"+gRS(2)+gRS(3)+gRS(3);
        dv.setmadv(mdvr);
        dsdv.add(dv);
        DVdao dvdao = new DVdao();
        dvdao.add(dv);
    }

    public static String gRS(int n) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        String randomString = sb.toString();
        return randomString;
    }

    public void delete(String maDV) {
        for (DonViDTO dv : dsdv) {
            if (dv.getmadv().equals(maDV)) {
                dsdv.remove(dv);
                DVdao dvdao = new DVdao();
                dvdao.delete(maDV);
                return;
            }
        }
    }

    public int set(DonViDTO dv) {
        for (int i = 0; i < dsdv.size(); i++) {
            if (dsdv.get(i).getmadv().equals(dv.getmadv())) {
                dsdv.set(i, dv);
                DVdao dvdao = new DVdao();
                dvdao.set(dv);
                return i;
            }
        }
        return -1;
    }
}
