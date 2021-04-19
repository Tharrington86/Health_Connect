package sample;

import javax.swing.*;
import java.sql.*;

public class Database {

    private static String dbURL = "jdbc:mysql://104-128-64-141" +
            ".cloud-xip.io:3306/healthconnect?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "Healthconnect1";
    public static Connection conn = null;

    // Create a connection to the database
    public static Connection getConnection() {
        if (conn == null) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(dbURL,username,password);
                System.out.println("Database connection established");

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
                System.out.println("Database connection failed");
            }
        }
        return conn;
    }
}
