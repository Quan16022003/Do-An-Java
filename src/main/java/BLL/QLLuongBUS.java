package BLL;

import DAL.LuongDAO;
import DTO.Luong;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class QLLuongBUS {
    private LuongDAO dao;
    private List<Luong> luongs;

    public QLLuongBUS() {
        dao = new LuongDAO();
    }

    public boolean insert() {
        for (var luong : luongs) {
            dao.insert(luong);
        }
        return true;
    }

    public boolean update() {
        for (var luong : luongs) {
            dao.update(luong);
        }
        return true;
    }

    public boolean delete() {
        for (var luong : luongs) {
            dao.delete(luong.getId());
        }
        luongs.clear();
        return true;
    }

    public List<Luong> selectAll() {
        return luongs;
    }

    public List<Luong> selectAllByDate(LocalDate date) {
        luongs = dao.selectAllByDate(date);
        return luongs;
    }
    public void createNew(LocalDate localDate) {
        luongs = dao.createNew(localDate);
    }
    public boolean updateLuongCB(int luongCB) {
        if (dao.updateLuongCB(luongCB)) {
            for (int i = 0; i < luongs.size(); i++ ) {
                luongs.get(i).setLuongCB(luongCB);
            }
            return true;
        }
        return false;
    }
}
