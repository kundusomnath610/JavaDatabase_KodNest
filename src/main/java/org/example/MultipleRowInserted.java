package org.example;

import java.sql.*;
import java.util.Scanner;

public class MultipleRowInserted {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Root_1234";
        String sql = "INSERT INTO emp(name, city) VALUES (?, ?)";

        try (
                Scanner scn = new Scanner(System.in);
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = con.prepareStatement(sql)
        ) {
            System.out.print("Enter the number of rows to insert: ");
            int rows = scn.nextInt();
            scn.nextLine(); // Consume leftover newline

            for (int i = 0; i < rows; i++) {
                System.out.print("Enter name: ");
                String name = scn.nextLine();

                System.out.print("Enter city: ");
                String city = scn.nextLine();

                statement.setString(1, name);
                statement.setString(2, city);

                int affected = statement.executeUpdate();
                System.out.println("Row inserted: " + affected);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
