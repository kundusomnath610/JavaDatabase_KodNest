package org.example;

import java.sql.*;
import java.util.Scanner;

public class DeleteQuery {
    private static final String url = "jdbc:mysql://localhost:3306/my_db";
    private static final String username = "root";
    private static final String password = "Root_1234";

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            System.out.print("Enter the ID of the employee to delete: ");
            int id = scn.nextInt();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver not found: " + e.getMessage());
                return;
            }

            String query = "DELETE FROM emp WHERE id = ?";

            try (
                    Connection con = DriverManager.getConnection(url, username, password);
                    PreparedStatement preparedStatement = con.prepareStatement(query)
            ) {
                preparedStatement.setInt(1, id);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Record deleted successfully.");
                } else {
                    System.out.println("No record found with ID: " + id);
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }
}
