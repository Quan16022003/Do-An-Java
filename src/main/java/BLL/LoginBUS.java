package BLL;

import DAL.TaiKhoanDAO;
import DTO.TaiKhoan;

public class LoginBUS {
    TaiKhoanBUS bus = new TaiKhoanBUS();

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
        
        if (bus.validate(username, password)) {
            return "OK";
        } else {
            return "Tài khoản hoặc mật khẩu không đúng";
        }
    }

    public String getMaGiaoVien(String username) {
        return taiKhoanDAO.selectByUsername(username).getMaGiaoVien();

}
