/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.K_TaiKhoandao;
import DTO.K_NhanVienDTO_u_nvdv_pass;
import DTO.K_TaiKhoanDTO;
import GUI.QLTaiKhoan.K_check_Val;

import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class K_TaiKhoanbus {

    private ArrayList<K_TaiKhoanDTO> dstk;

    public K_TaiKhoanbus() {
        list();
    }

    public K_TaiKhoanbus(int i) {
        list();
    }

    public void list() {
        K_TaiKhoandao tkdao = new K_TaiKhoandao();
        dstk = new ArrayList<>();
        dstk = tkdao.list();
    }
    
    public void createTK() throws ParseException {
        K_NVbus_updateNVDV_Pass unv = new K_NVbus_updateNVDV_Pass();
        ArrayList<K_NhanVienDTO_u_nvdv_pass> dsnv_tocra = new ArrayList<>();
        dsnv_tocra = unv.getList();
        for(K_NhanVienDTO_u_nvdv_pass tempNV : dsnv_tocra) {
            if(!is_exist(tempNV.getmanv())) {
                System.out.println("Cr account: "+tempNV.getmanv()+"|" + K_check_Val.datetoStr(tempNV.getngsinh())+"|"+ tempNV.getmanv());
                boolean h = add(new K_TaiKhoanDTO(tempNV.getmanv(), K_check_Val.datetoStr(tempNV.getngsinh()), tempNV.getmanv()));
            }
        }
        
    }
    public void reset(String manv) throws ParseException {
        K_TaiKhoandao tkdao = new K_TaiKhoandao();
        tkdao.reset(manv);
    }

    public ArrayList<K_TaiKhoanDTO> getList() {
        return dstk;
    }

    public boolean add(K_TaiKhoanDTO tk) {
        K_TaiKhoandao tkdao = new K_TaiKhoandao();
        return tkdao.add(tk);
    }
    
    public String getRole(K_TaiKhoanDTO tk) {
        K_TaiKhoandao tkdao = new K_TaiKhoandao();
        return tkdao.getRole(tk.getManv());
    }

    public boolean is_exist(String sUSER) {
        K_TaiKhoandao tkdao = new K_TaiKhoandao();
        return tkdao.is_exist(sUSER);
    }

    public int set(K_TaiKhoanDTO tk) {
        for (int i = 0; i < dstk.size(); i++) {
            if (dstk.get(i).getUser().equals(tk.getUser())) {
                dstk.set(i, tk);
                K_TaiKhoandao tkdao = new K_TaiKhoandao();
                tkdao.set(tk);
                return i;
            }
        }
        return -1;
    }

}
