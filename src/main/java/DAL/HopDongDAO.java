
 

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
        String query = "INSERT INTO Hop_Dong(MaHD, MaLoaiHD, MaNV, TenHD, NgayKy, HanHD, HocVi, Hang, Bac, MaSoThue, CucThue, STK, NganHang, SoTietGiangDay) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        mySQLConnection.openConnection();
        int rowInserted = mySQLConnection.executeUpdate(query, hd.getMaHD(), hd.getMaLoaiHD(), hd.getMaNV(), hd.getTenHD(), hd.getNgayKy(), hd.getHanHD(), hd.getHocVi(), hd.getHang(), hd.getBac(), hd.getMaSoThue()
            , hd.getCucThue(), hd.getSTK(), hd.getNganHang(), hd.getSoTietGiangDay());
        mySQLConnection.closeConnection();
        return rowInserted > 0;
    }

    @Override
    public boolean update(HopDong hd) {
        String query = "UPDATE Hop_Dong SET MaHD = ?, MaLoaiHD = ?, MaNV = ?, TenHD = ?, NgayKy = ?, HanHD = ?, HocVi = ?, Hang = ?, Bac = ?, MaSoThue = ?, CucThue = ?, STK = ?, NganHang = ?, SoTietGiangDay = ? WHERE MaHD = ?";
        mySQLConnection.openConnection();
        int rowUpdated = mySQLConnection.executeUpdate(query, hd.getMaHD(), hd.getMaLoaiHD(),hd.getMaNV(),hd.getTenHD(),hd.getNgayKy(),hd.getHanHD(),hd.getHocVi(),hd.getHang(),hd.getBac(),hd.getMaSoThue(),hd.getCucThue(),hd.getSTK(),hd.getNganHang(),hd.getSoTietGiangDay());
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
        String query = "INSERT INTO Hop_Dong(MaHD, MaLoaiHD, MaNV, TenHD, NgayKy, HanHD, HocVi, Hang, Bac, MaSoThue, CucThue, STK, NganHang, SoTietGiangDay) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        mySQLConnection.openConnection();
        ResultSet rs = mySQLConnection.executeQuery(query, LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        try {
            while (rs.next()){
                var MaHD = rs.getString("MaHD");
                var MaLoaiHD = rs.getString("MaLoaiHD");
                var MaNV = rs.getString("MaNV");
                var TenHD = rs.getString("TenHD");
                var NgayKy = rs.getString("NgayKy");
                var HanHD = rs.getString("HanHD");
                var HocVi = rs.getString("HocVi");
                var Hang = rs.getString("Hang");
                var Bac = rs.getString("Bac");
                var MaSoThue = rs.getString("MaSoThue");
                var CucThue = rs.getString("CucThue");
                var STK = rs.getString("STK");
                var NganHang = rs.getString("NganHang");
                var SoTietGiangDay = rs.getString("SoTietGiangDay");
             
                HopDong nv = new HopDong(MaHD, MaLoaiHD, MaNV, TenHD, NgayKy, HanHD, HocVi, Hang, Bac, MaSoThue
            , CucThue, STK, NganHang, SoTietGiangDay);
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

