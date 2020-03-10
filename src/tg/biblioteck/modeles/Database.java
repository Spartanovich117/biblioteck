/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.biblioteck.modeles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Spartanovich_117
 */
public class Database {
    
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            try {
            conn =
            DriverManager.getConnection("jdbc:mysql://localhost/biblioteck_db?" +
                                   "user=Spartan_117&password=Admin_117");
            } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
        } catch (Exception ex) {
            // handle the error
        }
        return conn;
    }
}
