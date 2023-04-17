package BLL;

import DAL.TaiKhoanDAO;
import DTO.TaiKhoan;

import java.util.List;

public class LoginBUS {
    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

    public LoginBUS() {
        List<TaiKhoan> taiKhoans= taiKhoanDAO.selectAll();
        for (var tk : taiKhoans) {
            System.out.println(tk.toString());
        }
    }

    public String validateLogin(String username, String password) {
        if (username.matches(".*[^a-zA-Z0-9].*")) {
            return "Tài khoản không được chứa ký tự đặc biệt";
        }
        if (password.matches(".*[^a-zA-Z0-9].*")) {
            return "Mật khẩu không được chứa ký tự đặc biệt";
        }
        if (username.isEmpty()) {
            return "Tài khoản không được để trống";
        }
        if (password.isEmpty()) {
            return "Mật khẩu không được để trống";
        }

        TaiKhoan taiKhoan = taiKhoanDAO.select(username);

        if (taiKhoan != null) {
            if (taiKhoan.getPassword().equals(password)) {
                return "OK";
            } else {
                return "Mật khẩu không đúng";
            }
        }
        return "Tài khoản không tồn tại";
    }

    public String getMaGiaoVien(String username) {
        return taiKhoanDAO.select(username).getMaGiaoVien();

    }
}
