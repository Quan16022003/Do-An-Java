package DAL;

import java.util.List;


public interface IDAO<T, K> {
    public abstract boolean insert(T t);
    public abstract boolean update(T t);
    public abstract boolean delete(K k);
    public abstract T select(K k);
    public abstract List<T> selectAll();

}
