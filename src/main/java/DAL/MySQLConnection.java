/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Hoang Quan
 * 
 * Database connection singleton
 */
public class MySQLConnection {

    private Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String USER = "root";
    private final String PASSWORD = "";
    private String database;
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    MySQLConnection() {
        DbUtils.loadDriver(JDBC_DRIVER);
    }
    
    public Connection getConnection() {
        return connection;
    }
    public void openConnection() {
        try {
            connection = DriverManager.getConnection(URL + database, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void closeConnection() {
        DbUtils.closeQuietly(connection);
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}