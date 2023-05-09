package DAL;

import DTO.ChucNang;
import DTO.CodeCN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChucNangDAO extends AbstractDAO<ChucNang, Integer> {
    @Override
    public boolean insert(ChucNang chucNang) {
        return false;
    }

    @Override
    public boolean update(ChucNang chucNang) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public ChucNang select(Integer integer) {
        return null;
    }

    @Override
    public List<ChucNang> selectAll() {
        return null;
    }
    public List<ChucNang> selectAllByUsername(String username) {
        String query = "SELECT cn.name_chuc_nang, code_chuc_nang\n" +
                "FROM tai_khoan tk, loai_quyen_truy_cap lqtc, quyen_truy_cap qtc, chuc_nang cn\n" +
                "WHERE username = ? and tk.Ma_loai_QTC = lqtc.id_loai_QTC and lqtc.id_loai_QTC = qtc.id_loai_QTC and qtc.id_chuc_nang = cn.id_chuc_nang";
        mySQLConnection.openConnection();

        List<ChucNang> chucNangs = new ArrayList<ChucNang>();
        ResultSet rs = mySQLConnection.executeQuery(query, username);
        try {
            while (rs.next()) {
                ChucNang chucNang = new ChucNang();
                chucNang.setTenCN(rs.getString("name_chuc_nang"));
                chucNang.setCodeCN(CodeCN.valueOf(rs.getString("code_chuc_nang")));
                chucNangs.add(chucNang);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        mySQLConnection.closeConnection();
        return chucNangs;
    }
}
