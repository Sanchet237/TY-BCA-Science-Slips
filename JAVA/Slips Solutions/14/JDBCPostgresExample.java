/* Q1. Write a program to create JDBC connection. On successful connection with database display 
appropriate message to user. [10 Marks] */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCPostgresExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/SanchetDB";
        String user = "postgres";
        String password = "mit@2025";

        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("PostgreSQL Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}