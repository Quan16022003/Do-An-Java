package DAL;

import java.util.List;

public interface IDAO<T, Id> {
    public boolean insert(T t);
    public boolean update(T t);
    public boolean delete(Id id);
    public T select(Id id);
    public List<T> selectAll();
}
