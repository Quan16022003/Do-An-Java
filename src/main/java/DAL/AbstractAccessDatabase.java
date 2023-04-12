package DAL;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public abstract class AbstractAccessDatabase<T> {
    private ResultSetHandler<T> resultSetHandler;
    private ResultSetHandler<List<T>> resultSetHandlerList;
    private QueryRunner queryRunner = new QueryRunner();
    private MySQLConnection mySQLConnection = new MySQLConnection();

    protected T executeQuery(String query, Object... params) {
        mySQLConnection.openConnection();
        try {
            return queryRunner.query(mySQLConnection.getConnection(), query, resultSetHandler, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mySQLConnection.closeConnection();
        }
        return null;
    }

    protected boolean executeUpdate(String query, Object... params) {
        mySQLConnection.openConnection();
        try {
            return queryRunner.update(mySQLConnection.getConnection(), query, params) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mySQLConnection.closeConnection();
        }
        return false;
    }
    protected List<T> executeQueryList(String query, Object... params) {
        mySQLConnection.openConnection();
        try {
            return queryRunner.query(mySQLConnection.getConnection(), query, resultSetHandlerList, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mySQLConnection.closeConnection();
        }
        return null;
    }

    protected void setClazz(Class<T> clazz) {
        this.resultSetHandler = new BeanHandler<>(clazz);
        this.resultSetHandlerList = new BeanListHandler<>(clazz);
    }

}
