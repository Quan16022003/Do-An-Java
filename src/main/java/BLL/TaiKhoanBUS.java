package BLL;

import DAL.TaiKhoanDAO;
import DTO.TaiKhoan;

import java.util.List;

public class TaiKhoanBUS extends AbstractElementBUS<TaiKhoan, String> {
    private final TaiKhoanDAO dao = new TaiKhoanDAO();
    private List<TaiKhoan> taiKhoans;

    @Override
    public boolean insert(TaiKhoan taiKhoan) {
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
        if (taiKhoans == null) {
            taiKhoans = dao.selectAll();
        }
        return taiKhoans;
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
