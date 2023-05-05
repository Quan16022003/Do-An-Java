package DAL;

import java.util.List;

public abstract class AbstractDAO<T, K> {
    protected mySQLConnection mySQLConnection = new mySQLConnection();
    public abstract boolean insert(T t);
    public abstract boolean update(T t);
    public abstract boolean delete(K k);
    public abstract T select(K k);
    public abstract List<T> selectAll();

}