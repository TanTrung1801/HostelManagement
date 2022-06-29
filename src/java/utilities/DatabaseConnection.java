package utilities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

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
