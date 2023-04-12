/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package g.ult;

/**
 *
 * @author ADMIN
 */
public class ULT {

    public static void main(String[] args) {
        String[] columnNames1 = {" Tiết ", " Thứ 2 ", " Thứ 3 ", " Thứ 4 ", " Thứ 5 ", " Thứ 6 ", " Thứ 7 "};
        Object[][] data1 = {
            {"      1 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
            {"      2 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
            {"      3 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
            {"      4 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
            {"      5 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
            {"      6 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
            {"      7 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
            {"      8 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
            {"      9 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
            {"      10 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},};

        FormXemTKB x = new FormXemTKB("Khanh", "from", "to", true, columnNames1, data1);
        
    }

}
