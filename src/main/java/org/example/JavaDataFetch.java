package org.example;

import java.sql.*;

public class JavaDataFetch {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Root_1234";

        String query = "SELECT * FROM emp";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {
            while (rs.next()) {
                int id = rs.getInt("id"); // or rs.getInt(1)
                String name = rs.getString("name");
                String city = rs.getString("city");

                System.out.println("ID: " + id + ", Name: " + name + ", City: " + city);
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
