package BLL;

import DAL.TaiKhoanDAO;
import DTO.TaiKhoan;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class TaiKhoanBUS extends AbstractElementBUS<TaiKhoan, String> {
    private final TaiKhoanDAO dao = new TaiKhoanDAO();

    @Override
    public boolean insert(TaiKhoan taiKhoan) {
        taiKhoan.setPassword(encryptedPassword(taiKhoan.getPassword()));
        return dao.insert(taiKhoan);
    }

    @Override
    public boolean update(TaiKhoan taiKhoan) {
        return dao.update(taiKhoan);
    }

    @Override
    public boolean delete(String username) {
        return dao.delete(username);
    }

    @Override
    public TaiKhoan select(String username) {
        return dao.select(username);
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return null;
    }

    private String encryptedPassword(String password) {
        String encrypted = null;
        try
        {
            /* MessageDigest instance for MD5. */
            MessageDigest m = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            m.update(password.getBytes());

            /* Convert the hash value into bytes */
            byte[] bytes = m.digest();

            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            /* Complete hashed password in hexadecimal format */
            encrypted = s.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return encrypted;
    }

    public boolean validate(String username, String password) {
        TaiKhoan taiKhoan = select(username);
        if (taiKhoan != null) {
            if (taiKhoan.getPassword().equals(encryptedPassword(password))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateDeleted(TaiKhoan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TaiKhoan> find(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
