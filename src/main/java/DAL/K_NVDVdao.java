/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.K_DonViDTO;
import DTO.K_NhanVienDonViDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class K_NVDVdao {

    private K_MySQLConnect mySQL = new K_MySQLConnect();

    public K_NVDVdao() {
    }

    public ArrayList<K_NhanVienDonViDTO> list() {
        ArrayList<K_NhanVienDonViDTO> dsnvdv = new ArrayList<>();
        try {

            String sql = "SELECT * FROM nhanviendonvi WHERE 1";
            try ( ResultSet rs = mySQL.executeQuery(sql)) {
                while (rs.next()) {

                    String manv = rs.getString("MANV");
                    String ten = rs.getString("TENNV");
                    String madv = rs.getString("MADV");
                    String tendv = rs.getString("TENDV");

                    K_NhanVienDonViDTO nvdv = new K_NhanVienDonViDTO(manv, ten, madv, tendv);
                    dsnvdv.add(nvdv);
                }
            }
            mySQL.disConnect();

        } catch (SQLException ex) {

        }

        return dsnvdv;
    }

    public static String generateRandomString(int n) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        String randomString = sb.toString();
        return randomString;
    }

    public void add(K_NhanVienDonViDTO nvdv) {
        K_MySQLConnect mySQL = new K_MySQLConnect();
        String sql = "INSERT INTO nhanviendonvi(MANV,TENNV,MADV,TENDV) VALUES ('";
        sql += nvdv.getmanv();
        sql += "','";
        sql += nvdv.getten();
        String x = "','0','0')";
        sql += x;

        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }

    public void set(K_NhanVienDonViDTO nvdv) {
        K_MySQLConnect mySQL = new K_MySQLConnect();
        K_NVdao_updateNVDV_Pass nvdao = new K_NVdao_updateNVDV_Pass();
        
        nvdao.set(nvdv);
        String sql = "UPDATE nhanviendonvi SET ";
        sql += "MADV='" + nvdv.getmadonvi() + "',";
        sql += "TENDV='" + nvdv.gettendonvi() + "',";
        sql += "TENNV='" + nvdv.getten() + "'";
        sql += "WHERE MANV='" + nvdv.getmanv() + "'";
        System.out.println(sql);
        System.out.println("Ket thuc  1 set");
        mySQL.executeUpdate(sql);
    }

    public String getMADV(String manvi) {
        String MADVS = "";
        try {

            String sql = "SELECT MADV FROM nhanviendonvi WHERE MANV='" + manvi + "'";
            try ( ResultSet rs = mySQL.executeQuery(sql)) {
                while (rs.next()) {

                    MADVS = rs.getString("MADV");

                }
            }
            mySQL.disConnect();

        } catch (SQLException ex) {

        }

        return MADVS;
    }


}
