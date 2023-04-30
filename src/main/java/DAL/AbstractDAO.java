package DAL;

import java.sql.ResultSet;
import java.util.List;


public abstract class AbstractDAO<T, K> {
    protected final MySQLConnection mySQLConnection = new MySQLConnection();
    
    public abstract boolean insert(T t);
    public abstract boolean update(T t);
    public abstract boolean updateDeleted(T t);
    public abstract List<T> find(K k);
    public abstract boolean delete(K k);
    public abstract T select(K k);
    public abstract List<T> selectAll();

}
