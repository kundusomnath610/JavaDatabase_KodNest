package org.example;

import java.sql.*;
import java.util.*;

public class FetchDataByID {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Root_1234";

        try (Scanner scn = new Scanner(System.in)) {
            System.out.print("Enter the Id: ");
            int id = scn.nextInt();
            scn.nextLine();

//            System.out.print("Enter the name: ");
//            String name = scn.nextLine();
//
//            System.out.print("Enter the city: ");
//            String city = scn.nextLine();

            String sql = "SELECT * FROM emp";
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " - "
                        + rs.getString(2) + " - " + rs.getString(3));
            }
        }
    }
}
