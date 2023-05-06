/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GUI.QLTaiKhoan;

import java.nio.charset.Charset;

/**
 *
 * @author ADMIN
 */
public class check_Val {
    
    public static boolean isNNameDV(String input) {
        return input != null && input.matches("^[\\p{L}0-9\\s]*[\\p{L}0-9][\\p{L}0-9\\s]*$");
    }
    public static boolean ss2DV(String str1,String str2) {
    if (str1 == null || str2 == null) {
        return false;
    }
    return str1.toLowerCase().equals(str2.toLowerCase());
}
    
    public static boolean is_newPass(String password) {
        String regex = "^[a-dA-D0-9@]*$";
        return password.matches(regex) && isASCII(password);
    }

    private static boolean isASCII(String str) {
        return Charset.forName("US-ASCII").newEncoder().canEncode(str);
    }

    public static String datetoStr(String d) {
        return d.replace("/", "").replace("-", "");
    }

    public static boolean isR0(String r) {
        return true;
    }

    public static boolean isR1(String r) {
        // gia tri 5 la false, 9 la true
        String t = r.substring(0, 1);
        System.out.println("--------"+t);
        int c = Integer.parseInt(t);
        System.out.println("Role R1 - " + c);
        return (c != 5);
    }

    public static boolean isR2(String r) {
        String t = r.substring(1, 2);
        int c = Integer.parseInt(t);
        System.out.println("Role R2 - " + c);
        return (c != 5);
    }

    public static boolean isR3(String r) {
        String t = r.substring(2, 3);
        int c = Integer.parseInt(t);
        System.out.println("Role R3 - " + c);
        return (c != 5);
    }

    public static boolean isR4(String r) {
        String t = r.substring(3, 4);
        int c = Integer.parseInt(t);
        System.out.println("Role R4 - " + c);
        return (c != 5);
    }

    public static boolean isR5(String r) {
        String t = r.substring(4, 5);
        int c = Integer.parseInt(t);
        System.out.println("Role R5 - " + c);
        return (c != 5);
    }

    public static String toRole(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {

        String rs = "";
        if (r1 == true) {
            rs += "9";
        } else {
            rs += "5";
        }
        if (r2 == true) {
            rs += "9";
        } else {
            rs += "5";
        }
        if (r3 == true) {
            rs += "9";
        } else {
            rs += "5";
        }
        if (r4 == true) {
            rs += "9";
        } else {
            rs += "5";
        }
        if (r5 == true) {
            rs += "9";
        } else {
            rs += "5";
        }

        return rs;
    }
}
