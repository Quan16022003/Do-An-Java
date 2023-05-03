package BLL;

import DTO.Luong;

import java.time.LocalDate;
import java.util.List;

public abstract class AbstractElementBUS<T, K> {
    public abstract boolean insert(T t);
    public abstract boolean update(T t);
    public abstract boolean delete(K k);
    public abstract T select(K k);
    public abstract List<T> selectAll();
}