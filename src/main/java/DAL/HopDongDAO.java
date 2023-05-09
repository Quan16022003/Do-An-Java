package DAL;

import DTO.HopDong;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HopDongDAO extends AbstractDAO<HopDong, Integer>{
    @Override

    public boolean insert(HopDong hd) {
        String query = "INSERT INTO Hop_Dong(MaHD, MaNV, TenHD, NgayKy, HanHD,HeSoLuong, HeSoPhuCap) VALUES (?,?,?,?,?,?,?)";
        mySQLConnection.openConnection();
        int rowInserted = mySQLConnection.executeUpdate(query, hd.getMaHD(), hd.getMaNV(), hd.getTenHD(), hd.getNgayKy(), hd.getHanHD()
            ,hd.getHeSoLuong(),hd.getHeSoPhuCap());
        mySQLConnection.closeConnection();
        return rowInserted > 0;
    }

    @Override
    public boolean update(HopDong hd) {
        String query = "UPDATE Hop_Dong SET MaNV, TenHD, NgayKy, HanHD,HeSoLuong, HeSoPhuCap WHERE MaHD = ?";
        mySQLConnection.openConnection();
        int rowUpdated = mySQLConnection.executeUpdate(query,  hd.getMaNV(), hd.getTenHD(), hd.getNgayKy(), hd.getHanHD()
            ,hd.getHeSoLuong(),hd.getHeSoPhuCap());
        mySQLConnection.closeConnection();
        return rowUpdated > 0;
    }

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM Hop_Dong WHERE MaHD = ?";
        mySQLConnection.openConnection();
        int rowDeleted = mySQLConnection.executeUpdate(query, id);
        mySQLConnection.closeConnection();
        return rowDeleted > 0;
    }

    @Override
    public HopDong select(Integer integer) {
        return null;
    }

    @Override
    public List<HopDong> selectAll() {
        List<HopDong> list = new ArrayList<HopDong>();
        String query = "SELECT * FROM Hop_Dong";
        mySQLConnection.openConnection();
        ResultSet rs = mySQLConnection.executeQuery(query);
        try {
            while (rs.next()){
                var MaHD = rs.getString("MaHD");
//                var MaLoaiHD = rs.getString("MaLoaiHD");
                var MaNV = rs.getString("MaNV");
                var TenHD = rs.getString("TenHD");
                var NgayKy = rs.getString("NgayKy");
                var HanHD = rs.getString("HanHD");
//                var HocVi = rs.getString("HocVi");
//                var Hang = rs.getString("Hang");
//                var Bac = rs.getString("Bac");
//                var MaSoThue = rs.getString("MaSoThue");
//                var CucThue = rs.getString("CucThue");
//                var STK = rs.getString("STK");
//                var NganHang = rs.getString("NganHang");
//                var CongViecDuocGiao =rs.getString("CongViecDuocGiao");
                var HeSoLuong =rs.getString("HeSoLuong");
                var HeSoPhuCap =rs.getString("HeSoPhuCap");
             
                HopDong nv;
                nv = new HopDong(MaHD, MaNV, TenHD, NgayKy, HanHD, HeSoLuong, HeSoPhuCap);
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

