/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author nguye
 */
public class DBUtils {
    
    private static String DATABASE_NAME ="UserHostel"; 
    private static String DATABASE_USERID="sa";
    private static String DATABASE_PASSWORD="1234";
    
    public static final Connection getConnection() throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName="+DATABASE_NAME;
        conn = DriverManager.getConnection(url, DATABASE_USERID, DATABASE_PASSWORD);
        return conn;
    }
    
    
}
