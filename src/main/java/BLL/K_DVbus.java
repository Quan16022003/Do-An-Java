/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.K_DVdao;
import DTO.K_DonViDTO;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class K_DVbus {

    private ArrayList<K_DonViDTO> dsdv;

    public K_DVbus() {
        list();
    }

    public K_DVbus(int i) {
        list();
    }

    public void list() {
        K_DVdao dvdao = new K_DVdao();
        dsdv = new ArrayList<>();
        dsdv = dvdao.list();
    }

    public ArrayList<K_DonViDTO> getList() {
        return dsdv;
    }
    
    public String getRole(String madvi) {
        K_DVdao dvdao = new K_DVdao();
        return dvdao.getRole(madvi);
    }

    public void add(K_DonViDTO dv) {
        String mdvr = "dv"+gRS(2)+gRS(3)+gRS(3);
        dv.setmadv(mdvr);
        dsdv.add(dv);
        K_DVdao dvdao = new K_DVdao();
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
        for (K_DonViDTO dv : dsdv) {
            if (dv.getmadv().equals(maDV)) {
                dsdv.remove(dv);
                K_DVdao dvdao = new K_DVdao();
                dvdao.delete(maDV);
                return;
            }
        }
    }

    public int set(K_DonViDTO dv) {
        for (int i = 0; i < dsdv.size(); i++) {
            if (dsdv.get(i).getmadv().equals(dv.getmadv())) {
                dsdv.set(i, dv);
                K_DVdao dvdao = new K_DVdao();
                dvdao.set(dv);
                return i;
            }
        }
        return -1;
    }
}
