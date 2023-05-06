/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DonViDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author ADMIN
 */
public class DVdao {

    private mySQLConnection mySQL = new mySQLConnection();

    public DVdao() {
    }

    public ArrayList<DonViDTO> list() {
        ArrayList<DonViDTO> dsdv = new ArrayList<>();
        try {
            mySQL.openConnection();
            String sql = "SELECT madv,tendv,ROLE FROM donvi WHERE 1";
            ResultSet rs = mySQL.executeQuery(sql);
            while (rs.next()) {

                String madv = rs.getString("MADV");
                String tendv = rs.getString("TENDV");
                String rolei = rs.getString("ROLE");
                DonViDTO dv = new DonViDTO(madv, tendv, rolei);
                dsdv.add(dv);
            }
            rs.close();
            mySQL.closeConnection();

        } catch (SQLException ex) {

        }

        return dsdv;
    }

    public void add(DonViDTO dv) {
        mySQL.openConnection();
        String sql = "INSERT INTO donvi VALUES (";
        sql += "'" + dv.getmadv() + "',";
        sql += "'" + dv.getten() + "','"+ dv.gettrole() + "');";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }

    public void set(DonViDTO dv) {
        mySQL.openConnection();
        String sql = "UPDATE donvi SET ";
        sql += "TENDV='" + dv.getten() + "',ROLE='";
        sql += dv.gettrole();
        sql += "' WHERE MADV='" + dv.getmadv() + "'";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
        mySQL.closeConnection();
    }

    public void delete(String madv) {
        mySQL.openConnection();
        String sql = "DELETE FROM donvi WHERE MADV='" + madv + "'";
        mySQL.executeUpdate(sql);
        System.out.println(sql);
        mySQL.closeConnection();
    }

}
