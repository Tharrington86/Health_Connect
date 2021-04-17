/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */
package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Health {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* main makes a connection to the database and prints out the usernames and passwords
            so that a functionality can be tested. Additionally the login window is generated
         */

        @SuppressWarnings("UnusedAssignment")
        // test connection
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://104-128-64-141.cloud-xip.io:" +
                    "3306/healthconnect?serverTimezone=UTC", "root", "Healthconnect1");
            //JOptionPane.showMessageDialog (null, "Connected");            
            Statement statement = conn.createStatement();
            ResultSet hc = statement.executeQuery("select * from Patient");
            while (hc.next()) {
                System.out.println("Patient Username = " + hc.getString("Username"));
                System.out.println("Patient Password = " + hc.getString("Password"));
            }
            hc = statement.executeQuery("select * from Doctor");
            while (hc.next()) {
                System.out.println("Doctor Username = " + hc.getString("Username"));
                System.out.println("Doctor Password = " + hc.getString("Password"));
            }            //open login page            
            NewJFrame s = new NewJFrame();
            s.setVisible(true);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}