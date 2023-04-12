/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g.ult;

import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class OTKB {

    public String maGV;
    public String htkb[] = {"Tiết", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7"};
    public String tkb[][] = {
        {"1", "0", "0", "0", "0", "0", "0"},
        {"2", "0", "0", "0", "0", "0", "0"},
        {"3", "0", "0", "0", "0", "0", "0"},
        {"4", "0", "0", "0", "0", "0", "0"},
        {"5", "0", "0", "0", "0", "0", "0"},
        {"6", "0", "0", "0", "0", "0", "0"},
        {"7", "0", "0", "0", "0", "0", "0"},
        {"8", "0", "0", "0", "0", "0", "0"},
        {"9", "0", "0", "0", "0", "0", "0"},
        {"10", "0", "0", "0", "0", "0", "0"},};

    public JTable rr(String h[], String d[][]) {
        return new JTable(d, h);
    }

    OTKB() {

    }

}
