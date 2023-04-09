/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class AccountDAO {
    private final Connection conn = DBConnection.getInstance().getConnection();

    public AccountDAO() {
    }
    
    
    public HashMap<String, Account> getAll() {
        HashMap<String, Account> map = new HashMap<>();
        
        String query = "SELECT * FROM tai_khoan";
        try (PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setUserName(rs.getString("user_name"));
                a.setPassword(rs.getString("password"));
                a.setMa_giao_vien(rs.getString("ma_giao_vien"));
                map.put(a.getUserName(), a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToChuyenMonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Map.Entry m : map.entrySet()){   
            Account a = (Account) m.getValue();
            System.out.println(m.getKey()+" " + a.getUserName() + " " + a.getPassword() + " " + a.getMa_giao_vien());    
        }  
        return map;
    } 
    
            
            
}
