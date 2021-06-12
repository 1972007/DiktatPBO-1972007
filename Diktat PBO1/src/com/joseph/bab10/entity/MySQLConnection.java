/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab10.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemodb","joseph_demodb","");
        connection.setAutoCommit(false);
        return connection;
    }
}
