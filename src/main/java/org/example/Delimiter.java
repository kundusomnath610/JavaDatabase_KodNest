package org.example;

import com.mysql.cj.jdbc.CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delimiter {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Root_1234";

        String callEmp = "CALL emp(404)";
        Connection con = DriverManager.getConnection(url, username, password);

        CallableStatement cs = (CallableStatement) con.prepareCall(callEmp);
        ResultSet rs = cs.executeQuery();
        System.out.println("The message is: " + cs);
    }
}
