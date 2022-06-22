/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lekha
 */
public class DatabaseConnection implements Serializable {
    public static Connection makeConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/hostelmanagement";
        String user = "root";
        String password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    
    
}
