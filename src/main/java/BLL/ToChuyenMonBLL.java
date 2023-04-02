/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ToChuyenMonDAO;
import DTO.ToChuyenMon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Hoang Quan
 */
public final class ToChuyenMonBLL {
    private static ToChuyenMonBLL instance;
    private List<ToChuyenMon> list;
    private ToChuyenMonBLL() {
        list = getAll();
        for (ToChuyenMon toChuyenMon : list) {
            System.out.println(toChuyenMon.getMaTCM() + " " + toChuyenMon.getTenTCM());
        }
    }
    
    public static ToChuyenMonBLL getInstance() {
        if (instance == null) {
            instance = new ToChuyenMonBLL();
        }
        return instance;
    }
    
    public List<ToChuyenMon> getAll() {
        list = DAL.ToChuyenMonDAO.getInstance().getAll();
        return list;
    }
}
