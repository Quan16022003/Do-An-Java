/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import GUI.QLTaiKhoan.K_check_Val;
import DTO.K_DonViDTO;
import DTO.K_NhanVienDTO_u_nvdv_pass;
import DTO.K_NhanVienDonViDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Kiet
 */
public class K_NVdao_updateNVDV_Pass {

    private K_MySQLConnect mySQL = new K_MySQLConnect();

    public K_NVdao_updateNVDV_Pass() {
    }

    public ArrayList<K_NhanVienDTO_u_nvdv_pass> list() throws ParseException {
        ArrayList<K_NhanVienDTO_u_nvdv_pass> dsnvu = new ArrayList<>();
        try {

            String sql = "SELECT manv,ten,madv,ngsinh FROM nhan_vien WHERE 1";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {

                String manv = rs.getString("manv");
                String tennv = rs.getString("ten");
                String madv = rs.getString("madv");

                String ngsinh = rs.getString("ngsinh");
                SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = originalFormat.parse(ngsinh);
                ngsinh = targetFormat.format(date);
                K_NhanVienDTO_u_nvdv_pass nv = new K_NhanVienDTO_u_nvdv_pass(manv, tennv, madv, ngsinh);
                dsnvu.add(nv);
            }
            rs.close();
            mySQL.disConnect();

        } catch (SQLException ex) {

        }

        return dsnvu;
    }

    public void set(K_NhanVienDonViDTO nv) {
        K_MySQLConnect mySQL = new K_MySQLConnect();
        String sql = "UPDATE nhan_vien SET ";
        sql += "MADV='" + nv.getmadonvi() + "'";
        sql += "WHERE MANV='" + nv.getmanv() + "'";
        System.out.println(sql);
        System.out.println("Hoan tat cap nhat ma don vi tu bang 'nhan vien don vi' sang bang 'nhan vien'");
        mySQL.executeUpdate(sql);
    }

    public String pass_reset(String manv) throws ParseException {
        String rtPass = "";
        try {
            String sql = "SELECT ngsinh FROM nhan_vien WHERE manv='" + manv + "'";
            try ( ResultSet rs = mySQL.executeQuery(sql)) {
                while (rs.next()) {
                    rtPass = rs.getString("ngsinh");
                    SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = originalFormat.parse(rtPass);
                    rtPass = targetFormat.format(date);
                    return K_check_Val.datetoStr(rtPass);
                }
            }
            mySQL.disConnect();
        } catch (SQLException ex) {

        }
        return K_check_Val.datetoStr(rtPass);
    }
}
