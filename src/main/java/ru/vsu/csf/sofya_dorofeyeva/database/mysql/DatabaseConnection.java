package ru.vsu.csf.sofya_dorofeyeva.database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/estate?useSSL=false&serverTimezone=UTC";
    private static final String USER = "bestuser";
    private static final String PASSWORD = "bestuser";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}