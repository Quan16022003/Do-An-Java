/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.NVDVdao;
import DTO.NhanVienDonViDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class NVDVbus {

    private ArrayList<NhanVienDonViDTO> dsnvdv;

    public NVDVbus() {
        list();
    }

    public NVDVbus(int i) {
        list();
    }

    public void list() {
        NVDVdao nvdvdao = new NVDVdao();
        dsnvdv = new ArrayList<>();
        dsnvdv = nvdvdao.list();
    }

    public ArrayList<NhanVienDonViDTO> getList() {
        return dsnvdv;
    }

    public void add(NhanVienDonViDTO nvdv) {
        boolean check = true;
        
        for (NhanVienDonViDTO t : dsnvdv) {
            if (t.getmanv().equals(nvdv.getmanv())) {
                check = false;
                break;
            }
        }
        if (check==true) {
            dsnvdv.add(nvdv);
            NVDVdao nvdvdao = new NVDVdao();
            nvdvdao.add(nvdv);
        }

    }

//    public void delete(String maDV) {
//        for (DonViDTO dv : dsdv) {
//            if (dv.getmadv().equals(maDV)) {
//                dsdv.remove(dv);
//                DVdao dvdao = new DVdao();
//                dvdao.delete(maDV);
//                return;
//            }
//        }
//    }
    public int set(NhanVienDonViDTO nvdvs) {
        for (int i = 0; i < dsnvdv.size(); i++) {
            if (dsnvdv.get(i).getmanv().equals(nvdvs.getmanv())) {
                dsnvdv.set(i, nvdvs);
                NVDVdao nvdvdao = new NVDVdao();
                nvdvdao.set(nvdvs);
                return i;
            }
        }
        return -1;
    }
//    public int set_loaibo(NhanVienDonViDTO nvdv) {
//        for (int i = 0; i < dsnvdv.size(); i++) {
//            if (dsnvdv.get(i).getmanv().equals(nvdv.getmanv())) {
//                dsnvdv.set(i, nvdv);
//                NVDVdao nvdvdao = new NVDVdao();
//                nvdvdao.set_loaibo(nvdv);
//                return i;
//            }
//        }
//        return -1;
//    }
//    public int set_chuyendonvi(NhanVienDonViDTO nvdv) {
//        for (int i = 0; i < dsnvdv.size(); i++) {
//            if (dsnvdv.get(i).getmanv().equals(nvdv.getmanv())) {
//                dsnvdv.set(i, nvdv);
//                NVDVdao nvdvdao = new NVDVdao();
//                nvdvdao.set(nvdv);
//                return i;
//            }
//        }
//        return -1;
//    }

}
