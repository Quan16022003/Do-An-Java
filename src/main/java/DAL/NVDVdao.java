/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.NhanVienDonViDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class NVDVdao {

    private mySQLConnection mySQL = new mySQLConnection();

    public NVDVdao() {
    }

    public ArrayList<NhanVienDonViDTO> list() {
        ArrayList<NhanVienDonViDTO> dsnvdv = new ArrayList<>();
        try {
            mySQL.openConnection();
            String sql = "SELECT * FROM nhanviendonvi WHERE 1";
            try ( ResultSet rs = mySQL.executeQuery(sql)) {
                while (rs.next()) {

                    String manv = rs.getString("MANV");
                    String ten = rs.getString("TENNV");
                    String madv = rs.getString("MADV");
                    String tendv = rs.getString("TENDV");

                    NhanVienDonViDTO nvdv = new NhanVienDonViDTO(manv, ten, madv, tendv);
                    dsnvdv.add(nvdv);
                }
            }
            mySQL.closeConnection();

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

    public void add(NhanVienDonViDTO nvdv) {
        mySQL.openConnection();
        String sql = "INSERT INTO nhanviendonvi(MANV,TENNV,MADV,TENDV) VALUES ('";
        sql+=nvdv.getmanv();
        sql+="','";
        sql+=nvdv.getten();
        String x = "','0','0')";
        sql+=x;
        
        System.out.println(sql);
        mySQL.executeUpdate(sql);
        mySQL.closeConnection();
    }
    public void set(NhanVienDonViDTO nvdv) {
        mySQL.openConnection();
        String sql = "UPDATE nhanviendonvi SET ";
        sql += "MADV='" + nvdv.getmadonvi() + "',";
        sql += "TENDV='" + nvdv.gettendonvi() + "',";
        sql += "TENNV='" + nvdv.getten() + "'";
        sql += "WHERE MANV='" + nvdv.getmanv() + "'";
        System.out.println(sql);
        System.out.println("Ket thuc  1 set");
        mySQL.executeUpdate(sql);
        mySQL.closeConnection();
    }

//    public void set_loaibo(NhanVienDonViDTO nvdv) {
//        MySQLConnect mySQL = new MySQLConnect();
//        String sql = "UPDATE nhanviendonvi SET ";
//
//        sql += "TENNV='" + nvdv.getten() + ",";
//        sql += "MADV='" + 0 + ",";
//        sql += "TENDV='" + 0 + ",";
//        sql += "WHERE MANV='" + nvdv.getmanv() + "';";
//        System.out.println(sql);
//        mySQL.executeUpdate(sql);
//    }
//
//    public void set_chuyendonvi(NhanVienDonViDTO nvdv) {
//        MySQLConnect mySQL = new MySQLConnect();
//        String sql = "UPDATE nhanviendonvi SET ";
//
//        sql += "TENNV='" + nvdv.getten() + ",";
//        sql += "MADV='" + nvdv.getmadonvi() + ",";
//        sql += "TENDV='" + nvdv.gettendonvi() + ",";
//        sql += "WHERE MANV='" + nvdv.getmanv() + "';";
//        System.out.println(sql);
//        mySQL.executeUpdate(sql);
//    }
//    public void delete(String madv) {
//        MySQLConnect mySQL = new MySQLConnect();
//        String sql = "DELETE FROM donvi WHERE MADV='" + madv + "'";
//        mySQL.executeUpdate(sql);
//        System.out.println(sql);
//    }
}
