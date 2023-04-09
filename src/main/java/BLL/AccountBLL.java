/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.AccountDAO;
import DTO.Account;
import java.util.HashMap;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class AccountBLL {
    private final AccountDAO accountDAO;
    private HashMap<String, Account> map = new HashMap<>();
    public AccountBLL() {
        accountDAO = new AccountDAO();
        map = accountDAO.getAll();
    }
    
    public HashMap getLoginInfo() {
        return map;
    }
    
}


