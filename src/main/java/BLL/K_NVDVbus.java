/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.K_DVdao;
import DAL.K_NVDVdao;
import DTO.K_DonViDTO;
import DTO.K_NhanVienDonViDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class K_NVDVbus {

    private ArrayList<K_NhanVienDonViDTO> dsnvdv;

    public K_NVDVbus() {
        list();
    }

    public K_NVDVbus(int i) {
        list();
    }

    public void list() {
        K_NVDVdao nvdvdao = new K_NVDVdao();
        dsnvdv = new ArrayList<>();
        dsnvdv = nvdvdao.list();
    }

    public ArrayList<K_NhanVienDonViDTO> getList() {
        return dsnvdv;
    }

    public void add(K_NhanVienDonViDTO nvdv) {
        boolean check = true;

        for (K_NhanVienDonViDTO t : dsnvdv) {
            if (t.getmanv().equals(nvdv.getmanv())) {
                check = false;
                break;
            }
        }
        if (check == true) {
            dsnvdv.add(nvdv);
            K_NVDVdao nvdvdao = new K_NVDVdao();
            nvdvdao.add(nvdv);
        }

    }

    public String getMADV(String manvi) {

        K_NVDVdao nvdvdao = new K_NVDVdao();
        return nvdvdao.getMADV(manvi);
    }

    public int set(K_NhanVienDonViDTO nvdvs) {
        for (int i = 0; i < dsnvdv.size(); i++) {
            if (dsnvdv.get(i).getmanv().equals(nvdvs.getmanv())) {
                dsnvdv.set(i, nvdvs);
                K_NVDVdao nvdvdao = new K_NVDVdao();
                nvdvdao.set(nvdvs);
                return i;
            }
        }
        return -1;
    }


}
