package BLL;

import DTO.Luong;

import java.util.List;

public class LuongBUS extends AbstractElementBUS<Luong, Integer>{

    @Override
    public boolean insert(Luong luong) {
        return false;
    }

    @Override
    public boolean update(Luong luong) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Luong select(Integer integer) {
        return null;
    }

    @Override
    public List<Luong> selectAll() {
        return null;
    }
}
