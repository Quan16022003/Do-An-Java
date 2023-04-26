/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.TaiKhoan;

import java.util.List;

/**
 *
 * @author Nguyen Hoang Quan
 */
public class TaiKhoanDAO extends AbstractAccessDatabase<TaiKhoan> implements IDAO<TaiKhoan, Integer> {
    public TaiKhoanDAO() {
        setClazz(TaiKhoan.class);
    }

    @Override
    public boolean insert(TaiKhoan taiKhoan) {
        String query = "INSERT INTO tai_khoan(username, password, ma_giao_vien, role) VALUES (?, ?, ?, ?)";
        return executeUpdate(query, taiKhoan.getUsername(), taiKhoan.getPassword(), taiKhoan.getMaGiaoVien(), taiKhoan.getRole());
    }

    @Override
    public boolean update(TaiKhoan taiKhoan) {
        String query = "UPDATE tai_khoan SET username=?,password=?,ma_giao_vien=?,role=?,is_delete=? WHERE id=?";
        return executeUpdate(query, taiKhoan.getUsername(), taiKhoan.getPassword(), taiKhoan.getMaGiaoVien(), taiKhoan.getRole(), taiKhoan.getIs_deleted(), taiKhoan.getId());
    }

    @Override
    public boolean delete(Integer id) {
        String query = "UPDATE tai_khoan SET is_delete=1 WHERE id=?";
        return executeUpdate(query, id);
    }

    @Override
    public TaiKhoan select(Integer id) {
        String query = "SELECT * FROM tai_khoan WHERE id=? AND is_delete=0";
        return executeQuery(query, id);
    }

    @Override
    public List<TaiKhoan> selectAll() {
        String query = "SELECT * FROM tai_khoan WHERE is_delete=0";
        return executeQueryList(query);
    }

    public TaiKhoan selectByUsername(String username) {
        String query = "SELECT * FROM tai_khoan WHERE username=? AND is_delete=0";
        return executeQuery(query, username);
    }
}
