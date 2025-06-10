package org.example;

import java.sql.*;
import java.util.Scanner;

public class JdbcApp {

    private static final String url = "jdbc:mysql://localhost:3306/my_db";
    private static final String username = "root";
    private static final String password = "Root_1234";

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
//            System.out.print("Enter the Id: ");
//            int id = scn.nextInt();
//            scn.nextLine();

            System.out.print("Enter the name: ");
            String name = scn.nextLine();

            System.out.print("Enter the city: ");
            String city = scn.nextLine();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Class Loader in memory..
            } catch (ClassNotFoundException e) {
                System.out.println("Class Not found " + e.getMessage());
                return;
            }

            String Query = "INSERT INTO emp (name, city) VALUES (?, ?)";
            try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = con.prepareStatement(Query)
            ) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, city);

                int rowAffected = preparedStatement.executeUpdate();
                System.out.println("Inserted Successfully in Row " + rowAffected);
            } catch (SQLException e) {
                System.out.println("Database Error " + e.getMessage());
            }

        }
    }
}