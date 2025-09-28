/* Q2. Write a JDBC program to update number_of_students of “BCA Science” to 1000. Create a 
table Course (Code,name, department,number_of_students) in PostgreSQL database. Insertvalues 
in the table. [20 Marks]*/

import java.sql.*;

public class UpdateCourse {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/SanchetDB";
        String user = "postgres";
        String password = "mit@2025";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            String sql = "UPDATE Course SET number_of_students = 1000 WHERE name = 'BCA Science'";
            int rows = stmt.executeUpdate(sql);

            if (rows > 0) {
                System.out.println("Updated number_of_students for BCA Science to 1000.");
            } else {
                System.out.println("Course not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
