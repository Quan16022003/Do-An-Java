/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.NhanVienDTO_u_nvdv_pass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class NVdao_updateNVDV_Pass {
    private mySQLConnection mySQL = new mySQLConnection();

    public NVdao_updateNVDV_Pass() {
    }

    public ArrayList<NhanVienDTO_u_nvdv_pass> list() {
        ArrayList<NhanVienDTO_u_nvdv_pass> dsnvu = new ArrayList<>();
        try {
            mySQL.openConnection();
            String sql = "SELECT manv,tennv,madv,ngsinh FROM nhanvien WHERE 1";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {

                String manv = rs.getString("manv");
                String tennv = rs.getString("tennv");
                String madv = rs.getString("madv");
                String ngsinh = rs.getString("ngsinh");
                NhanVienDTO_u_nvdv_pass nv = new NhanVienDTO_u_nvdv_pass(manv, tennv,madv,ngsinh);
                dsnvu.add(nv);
            }
            rs.close();
            mySQL.closeConnection();

        } catch (SQLException ex) {

        }

        return dsnvu;
    }
   
}
