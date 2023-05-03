/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


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
    public Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/quanlygiaovien";

    private final String USER = "root";
    private final String PASSWORD = "123456";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final Logger LOGGER = Logger.getLogger(MySQLConnection.class.getName());
    public MySQLConnection() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void openConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
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