package RepositoryPattern;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/banco";
    private static final String USER = "root";
    private static final String PASSWORD = "karate1_";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
