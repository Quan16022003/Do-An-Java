/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.K_DVbus;
import BLL.K_NVDVbus;
import DTO.K_NhanVienDonViDTO;
import DTO.K_TaiKhoanDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class K_TaiKhoandao {

    private K_MySQLConnect mySQL = new K_MySQLConnect();

    public K_TaiKhoandao() {
    }

    public ArrayList<K_TaiKhoanDTO> list() {
        ArrayList<K_TaiKhoanDTO> dstk = new ArrayList<>();
        try {

            String sql = "SELECT * FROM tai_khoan WHERE 1";
            try ( ResultSet rs = mySQL.executeQuery(sql)) {
                while (rs.next()) {

                    String user = rs.getString("USER");
                    String pass = rs.getString("PASS");
                    String manv = rs.getString("MANV");

                    K_TaiKhoanDTO tk = new K_TaiKhoanDTO(user, pass, manv);
                    dstk.add(tk);
                }
            }
            mySQL.disConnect();

        } catch (SQLException ex) {

        }

        return dstk;
    }
    
    
    

    public boolean is_exist(String sUSER) {
        boolean kq = false;
        try {
            String sql = "SELECT COUNT(*) FROM tai_khoan WHERE USER = '" + sUSER + "'";
            try ( ResultSet rs = mySQL.executeQuery(sql)) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    if (count > 0) {
                        kq = true;
                    }
                }
            }
            mySQL.disConnect();

        } catch (SQLException ex) {

        }

        return kq;
    }

    public boolean add(K_TaiKhoanDTO tk) {
        K_MySQLConnect mySQL = new K_MySQLConnect();

        Boolean cd = is_exist(tk.getUser());

        if (!cd) {
            String sql = "INSERT INTO tai_khoan(USER,PASS,MANV) VALUES ('";
            sql += tk.getUser() + "','" + tk.getPass() + "','" + tk.getManv() + "')";
            System.out.println(sql);
            mySQL.executeUpdate(sql);

        } else {
            System.out.println("User da ton tai : " + tk.getUser());
        }

        return cd;
    }

    public void set (K_TaiKhoanDTO tk) {
        K_MySQLConnect mySQL = new K_MySQLConnect();
        String sql = "UPDATE tai_khoan SET ";    
        sql += "pass='" + tk.getPass() + "'";
        sql += "WHERE user='" + tk.getUser() + "'";
        System.out.println(sql);
        System.out.println("Ket thuc  thay doi mat khau User: "+tk.getUser());
        mySQL.executeUpdate(sql);
    }

    public String getRole(String manv) {
        K_NVDVbus nvdv = new K_NVDVbus();  
        String maDV = nvdv.getMADV(manv);
        K_DVbus dv = new K_DVbus();
        return dv.getRole(maDV);
    }
    public void reset(String manv) throws ParseException {
        K_NVdao_updateNVDV_Pass unvdao = new K_NVdao_updateNVDV_Pass();
        String dfp = unvdao.pass_reset(manv);
        System.out.println("pass df rs :"+dfp);
        set(new K_TaiKhoanDTO(manv,dfp,manv));
    }

}
