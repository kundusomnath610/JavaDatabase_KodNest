/*
*
* This is for only DataBase connectivity for Mysql.
*
*/

package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaDataBase {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Root_1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("DataBase Connected Successfully.." + con);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Not Connected " + e.getMessage());

        }


    }
}
