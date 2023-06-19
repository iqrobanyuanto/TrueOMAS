/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBPr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iqro Banyuanto
 */
public class DBConnection {
    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/OMASSSS?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String username = "root";
    private static final String password = "";
    private static final String className = "com.mysql.jdbc.Driver";
    
    public static Connection getConnection() throws SQLException{
        if (connection == null){
            try {
                Class.forName(className);
               connection = DriverManager.getConnection(url,username,password);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
