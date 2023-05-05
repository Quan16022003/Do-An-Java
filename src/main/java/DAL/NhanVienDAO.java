
package DAL;

import DTO.NhanVien;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO  extends AbstractDAO<NhanVien, Integer> {
    @Override

    public boolean insert(NhanVien nv) {
         String query = "INSERT INTO Nhan_Vien(MaNV, MaDV, MaLoaiNV, MaChucVu, Ten, GioiTinh, NgSinh, SDT, SoNha, Duong, Phuong_Xa, Quan_Huyen, Tp_Tinh, CCCD, NgCap, NoiCap, NgVaoLam, image) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        mySQLConnection.openConnection();
        int rowInserted = mySQLConnection.executeUpdate(query, nv.getMaDV(),nv.getMaLoaiNV(),nv.getMaChucVu()
        , nv.getTen(),nv.getGioiTinh(),nv.getNgSinh(),nv.getSDT(),nv.getSoNha(),nv.getDuong()
        ,nv.getPhuong_Xa(),nv.getQuan_Huyen(),nv.getTP_Tinh(),nv.getCCCD(),nv.getNgCap()
        ,nv.getNoiCap(),nv.getNgVaoLam(),nv.getImage());
        mySQLConnection.closeConnection();
        return rowInserted > 0;
    }


    @Override
    public boolean update(NhanVien nv) {
        String query = "UPDATE Nhan_Vien SET MaDV = ?, MaLoaiNV = ?, MaChucVu = ?, Ten = ?, GioiTinh = ?, NgSinh = ?, SDT = ?, SoNha = ?, Duong = ?, Phuong_Xa = ?, Quan_Huyen = ?, Tp_Tinh = ?, CCCD = ?, NgCap = ?, NoiCap = ?, NgVaoLam = ?, image = ? WHERE MaNV=?";
        mySQLConnection.openConnection();
        int rowUpdated = mySQLConnection.executeUpdate(query, nv.getMaDV(),nv.getMaLoaiNV(),nv.getMaChucVu()
        , nv.getTen(),nv.getGioiTinh(),nv.getNgSinh(),nv.getSDT(),nv.getSoNha(),nv.getDuong()
        ,nv.getPhuong_Xa(),nv.getQuan_Huyen(),nv.getTP_Tinh(),nv.getCCCD(),nv.getNgCap()
        ,nv.getNoiCap(),nv.getNgVaoLam(),nv.getImage());
        mySQLConnection.closeConnection();
        return rowUpdated > 0;
    }

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM Nhan_Vien WHERE MaNV = ?";
        mySQLConnection.openConnection();
        int rowDeleted = mySQLConnection.executeUpdate(query, id);
        mySQLConnection.closeConnection();
        return rowDeleted > 0;
    }

    @Override
    public NhanVien select(Integer integer) {
        return null;
    }

    @Override
    public List<NhanVien> selectAll() {
        List<NhanVien> list = new ArrayList<NhanVien>();
         String query = "SELECT * FROM Nhan_Vien";
        mySQLConnection.openConnection();
        ResultSet rs = mySQLConnection.executeQuery(query, LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        try {
            while (rs.next()) {
                var MaNV = rs.getString("MaNV");
                var MaDV = rs.getString("MaDV");
                var MaLoaiNV = rs.getString("MaLoaiNV");
                var MaChucVu = rs.getString("MaChucVu");
                var Ten = rs.getString("Ten");
                var GioiTinh = rs.getString("GioiTinh");
                var SDT = rs.getString("SoNha");
                var Duong = rs.getString("Duong");
                var Phuong_Xa = rs.getString("Phuong_Xa");
                var Quan_Huyen = rs.getString("Quan_Huyen");
                var Tp_Tinh = rs.getString("Tp_Tinh");
                var CCCD = rs.getString("CCCD");
                var NgCap = rs.getString("NgCap");
                var NoiCap = rs.getString("NoiCap");
                var NgVaoLam = rs.getString("NgVaoLam");
                var image = rs.getString("image");
                NhanVien nv = new NhanVien(MaNV, MaDV, MaLoaiNV, MaChucVu, Ten, GioiTinh, NgCap, SDT, NoiCap, Duong, Phuong_Xa, Quan_Huyen, Tp_Tinh, CCCD, NgCap, NoiCap, NgVaoLam, image);
                       list.add(nv);
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

}
