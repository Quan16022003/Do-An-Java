/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.K_NVdao_updateNVDV_Pass;
import DTO.K_NhanVienDTO_u_nvdv_pass;
import DTO.K_NhanVienDonViDTO;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class K_NVbus_updateNVDV_Pass {
    
    private ArrayList<K_NhanVienDTO_u_nvdv_pass> dsnv_u_NVDV_Pass;
    
    public void set(K_NhanVienDonViDTO nv) {
        K_NVdao_updateNVDV_Pass nvdao = new K_NVdao_updateNVDV_Pass();
        nvdao.set(nv);
    }
    
    public K_NVbus_updateNVDV_Pass() throws ParseException {
        list();
    }

    public K_NVbus_updateNVDV_Pass(int i) throws ParseException {
        list();
    }

    public void list() throws ParseException {
        K_NVdao_updateNVDV_Pass unvdao = new K_NVdao_updateNVDV_Pass();
        dsnv_u_NVDV_Pass = new ArrayList<>();
        dsnv_u_NVDV_Pass = unvdao.list();
    }

    public ArrayList<K_NhanVienDTO_u_nvdv_pass> getList() {
        return dsnv_u_NVDV_Pass;
    }
}
