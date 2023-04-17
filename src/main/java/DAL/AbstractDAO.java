package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractDAO<T, Id> {
    protected final MySQLConnection mySQLConnection = new MySQLConnection();

    protected abstract List<T> convertResultSetToList(ResultSet rs);

    public abstract boolean insert(T t);
    public abstract boolean update(T t);
    public abstract boolean delete(Id id);
    public abstract T select(Id id);
    public abstract List<T> selectAll();

}
