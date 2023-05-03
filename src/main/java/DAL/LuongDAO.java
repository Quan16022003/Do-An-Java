package DAL;

import DTO.Luong;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LuongDAO implements IDAO<Luong, Integer> {
    private final MySQLConnection mySQLConnection = new MySQLConnection();
    @Override

    public boolean insert(Luong luong) {
        String query = "INSERT INTO luong(MaNV, NgayCongQD, NgayCongTT, LuongCB, HeSoLuong, LuongHuong, MucPC, MucBH, ThucLinh)" +
                       "VALUES (?,?,?,?,?,?,?,?,?)";
        mySQLConnection.openConnection();
        int rowInserted = mySQLConnection.executeUpdate(query, luong.getMaNV(), luong.getNgayCongQD(), luong.getNgayCongTT(),
                luong.getLuongCB(), luong.getHsLuong(), luong.getLuongHuong(), luong.getMucPC(), luong.getMucBH(), luong.getThucLinh());
        mySQLConnection.closeConnection();
        return rowInserted > 0;
    }

    @Override
    public boolean update(Luong luong) {
        String query = "UPDATE luong SET LuongCB = ?, LuongHuong = ?, MucPC = ?, MucBH = ?, ThucLinh = ? WHERE id = ?";
        mySQLConnection.openConnection();
        int rowUpdated = mySQLConnection.executeUpdate(query, luong.getLuongCB(), luong.getId());
        mySQLConnection.closeConnection();
        return rowUpdated > 0;
    }

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM luong WHERE id = ?";
        mySQLConnection.openConnection();
        int rowDeleted = mySQLConnection.executeUpdate(query, id);
        mySQLConnection.closeConnection();
        return rowDeleted > 0;
    }

    @Override
    public Luong select(Integer integer) {
        return null;
    }

    @Override
    public List<Luong> selectAll() {
        List<Luong> list = new ArrayList<Luong>();
        String query = "SELECT luong.*, HoTenNV FROM luong JOIN nhan_vien ON luong.MaNV = nhan_vien.MaNV " +
                "WHERE month(NgayTao) = ? AND year(NgayTao) = ?";
        mySQLConnection.openConnection();
        ResultSet rs = mySQLConnection.executeQuery(query, LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        try {
            while (rs.next()) {
                Luong luong = new Luong();
                luong.setId(rs.getInt("id"));
                luong.setMaNV(rs.getString("MaNV"));
                luong.setTenNV(rs.getString("HoTenNV"));
                luong.setHsLuong(rs.getDouble("HeSoLuong"));
                luong.setTyLePC(rs.getInt("TyLePC"));
                luong.setHsChucVu(rs.getDouble("HsCV"));
                luong.setNgayCongQD(rs.getInt("ngay_cong_qd"));
                luong.setNgayCongTT(rs.getInt("ngay_cong_tt"));
                luong.tinhLuong();
                list.add(luong);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        mySQLConnection.closeConnection();
        for (var luong : list) {
            System.out.println(luong);
        }
        return list;
    }

    public List<Luong> selectAllByDate(LocalDate localDate) {
        List<Luong> list = new ArrayList<Luong>();
        String query = "SELECT luong.*, HoTenNV FROM luong JOIN nhan_vien ON luong.MaNV = nhan_vien.MaNV " +
                       "WHERE month(NgayTao) = ? AND year(NgayTao) = ?";
        mySQLConnection.openConnection();
        ResultSet rs = mySQLConnection.executeQuery(query, localDate.getMonthValue(), localDate.getYear());
        try {
            while (rs.next()) {
                Luong luong = new Luong();
                luong.setId(rs.getInt("id"));
                luong.setMaNV(rs.getString("MaNV"));
                luong.setTenNV(rs.getString("HoTenNV"));
                luong.setNgayCongQD(rs.getInt("NgayCongQD"));
                luong.setNgayCongTT(rs.getInt("NgayCongTT"));
                luong.setLuongCB(rs.getInt("LuongCB"));
                luong.setHsLuong(rs.getDouble("HeSoLuong"));
                luong.setLuongHuong(rs.getInt("LuongHuong"));
                luong.setMucPC(rs.getInt("MucPC"));
                luong.setMucBH(rs.getInt("MucBH"));
                luong.setThucLinh(rs.getInt("ThucLinh"));
                list.add(luong);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        mySQLConnection.closeConnection();
        for (var luong : list) {
            System.out.println(luong);
        }
        return list;
    }
    public List<Luong> createNew(LocalDate localDate) {
        List<Luong> list = new ArrayList<Luong>();
        String query = "SELECT *, (SELECT LuongCB FROM luongcb ORDER BY id DESC LIMIT 1) AS luongCB\n" +
                "FROM nhan_vien\n" +
                "JOIN chuc_vu cv ON cv.MaCV = nhan_vien.MaCV\n" +
                "JOIN (SELECT ma_nhan_vien MaNV, COUNT(*) as ngay_cong_qd FROM `cham_cong` WHERE month(ngay_cham_cong) = "+ localDate.getMonthValue() +" AND year(ngay_cham_cong) = "+ localDate.getYear() +" GROUP BY ma_nhan_vien) tk1 ON tk1.MaNV = nhan_vien.MaNV\n" +
                "JOIN (SELECT ma_nhan_vien MaNV, COUNT(*) as ngay_cong_tt FROM `cham_cong` WHERE xac_nhan = 1 AND  month(ngay_cham_cong) = "+ localDate.getMonthValue() +" AND year(ngay_cham_cong) = "+ localDate.getYear() + " GROUP BY ma_nhan_vien) tk2 ON tk2.MaNV = nhan_vien.MaNV";
        mySQLConnection.openConnection();
        ResultSet rs = mySQLConnection.executeQuery(query);
        try {
            while (rs.next()) {
                Luong luong = new Luong();
                luong.setMaNV(rs.getString("MaNV"));
                luong.setTenNV(rs.getString("HoTenNV"));
                luong.setHsLuong(rs.getDouble("HeSoLuong"));
                luong.setTyLePC(rs.getInt("TyLePC"));
                luong.setHsChucVu(rs.getDouble("HsCV"));
                luong.setNgayCongQD(rs.getInt("ngay_cong_qd"));
                luong.setNgayCongTT(rs.getInt("ngay_cong_tt"));
                luong.setLuongCB(rs.getInt("luongCB"));
                luong.tinhLuong();
                list.add(luong);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        mySQLConnection.closeConnection();
        for (var luong : list) {
            System.out.println(luong);
        }
        return list;
    }

    public boolean updateLuongCB(int luongCB) {
        String query = "INSERT INTO luongcb (LuongCB) VALUES (?)";
        mySQLConnection.openConnection();
        int luongCBInserted = mySQLConnection.executeUpdate(query, luongCB);
        mySQLConnection.closeConnection();
        return luongCBInserted > 0;
    }
}
