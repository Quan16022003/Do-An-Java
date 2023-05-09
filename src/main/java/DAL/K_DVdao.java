/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.K_DonViDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class K_DVdao {

    private K_MySQLConnect mySQL = new K_MySQLConnect();

    public K_DVdao() {
    }

    public ArrayList<K_DonViDTO> list() {
        ArrayList<K_DonViDTO> dsdv = new ArrayList<>();
        try {

            String sql = "SELECT madv,tendv,ROLE FROM donvi WHERE 1";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {

                String madv = rs.getString("MADV");
                String tendv = rs.getString("TENDV");
                String rolei = rs.getString("ROLE");
                K_DonViDTO dv = new K_DonViDTO(madv, tendv, rolei);
                dsdv.add(dv);
            }
            rs.close();
            mySQL.disConnect();

        } catch (SQLException ex) {

        }

        return dsdv;
    }

    public void add(K_DonViDTO dv) {
        K_MySQLConnect mySQL = new K_MySQLConnect();

        String sql = "INSERT INTO donvi VALUES (";
        sql += "'" + dv.getmadv() + "',";
        sql += "'" + dv.getten() + "','" + dv.gettrole() + "');";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }

    public void set(K_DonViDTO dv) {
        K_MySQLConnect mySQL = new K_MySQLConnect();
        String sql = "UPDATE donvi SET ";
        sql += "TENDV='" + dv.getten() + "',ROLE='";
        sql += dv.gettrole();
        sql += "' WHERE MADV='" + dv.getmadv() + "'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }

    public void delete(String madv) {
        K_MySQLConnect mySQL = new K_MySQLConnect();
        String sql = "DELETE FROM donvi WHERE MADV='" + madv + "'";
        mySQL.executeUpdate(sql);
        System.out.println(sql);
    }

    public String getRole(String madvi) {
        String rl = "";
        try {

            String sql = "SELECT ROLE FROM donvi WHERE MADV='" + madvi + "'";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {
                rl = rs.getString("ROLE");
            }
            rs.close();
            mySQL.disConnect();

        } catch (SQLException ex) {

        }
        if (madvi.equals("0")) {
            rl = "55555";

        }
        

        return rl;
    }

}
