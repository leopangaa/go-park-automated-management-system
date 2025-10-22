/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
/**
 *
 * @author earlc
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/parking_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "leopanga";
    private static final String PASS = "earlpanga0801";
    
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException{
        if(connection==null || connection.isClosed()){
            connection = DriverManager.getConnection(URL, USER, PASS);
        }
        return connection;
    }
}
