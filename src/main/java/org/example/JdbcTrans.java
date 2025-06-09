package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTrans {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Root_1234";

        String sql1 = "Update bank SET balance = balance + 5000 WHERE name = 'rohit'"; // 45000 // 40000
        String sql2 = "Update bank SET balance = balance - 5000 WHERE name = 'virat'"; // 25000 // 30000

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);
            Statement st = con.createStatement();

            try {
                st.executeUpdate(sql1);
                st.executeUpdate(sql2);
                con.commit();

            } catch (Exception e) {
                System.out.println("Some Problem is there!!..");

            }

        } catch (SQLException e) {
            System.out.println("No problem occure: " + e.getMessage());
        }
    }
}
