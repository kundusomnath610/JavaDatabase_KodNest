package org.example;

import java.sql.*;
import java.util.Scanner;

public class JdbcApp {

    private static final String url = "jdbc:mysql://localhost:3306/my_db";
    private static final String username = "root";
    private static final String password = "Root_1234";

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = scn.nextLine();

        System.out.print("Enter the city: ");
        String city = scn.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            return;
        }

        String query = "INSERT INTO emp (name, city) VALUES (?, ?)";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setString(1, name);
            pstmt.setString(2, city);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Inserted successfully. Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
