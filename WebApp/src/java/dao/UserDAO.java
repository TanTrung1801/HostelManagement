/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dto.UserDTO;
import java.security.NoSuchAlgorithmException;
import javax.naming.NamingException;
import utl.DBUtils;
import utl.Encryption;
/**
 *
 * @author nguye
 */
public class UserDAO {

    private static final String DATABASE_NAME = "tblUsers";

    private static final String LOGIN = "SELECT fullName, roleID FROM" + DATABASE_NAME + "WHERE userID=? AND password =?";
    private static final String CHECK_DUPLICATE = "SELECT fullname, roleID FROM" + DATABASE_NAME + " WHERE userID=?";
    private static final String CHECK_DUPLICATE_EMAIL ="SELECT fullname, roleID FROM" + DATABASE_NAME + " WHERE email=?";
    private static final String CREATE =  "INSERT INTO tblUsers(userID, fullName, roleID, password,email, phone, idCard, status, dateOfBirth) VALUES(?,?,?,?,?,?,?,?,?)";
    
    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, fullName, roleID, "", "", "", "", true, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareCall(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean checkDuplicateEmail(String email) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareCall(CHECK_DUPLICATE_EMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean createUser(UserDTO user) throws SQLException, ClassNotFoundException, NamingException, NoSuchAlgorithmException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(CREATE);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, user.getRoleID());
                ptm.setString(4, Encryption.getPasswordEncryption(user.getPassword()));
                ptm.setString(5, user.getEmail());
                ptm.setString(6, user.getPhone());
                ptm.setString(7, user.getIdCard());
                ptm.setBoolean(8, user.isStatus());
                ptm.setDate(9, user.getDateOfBirth());
                check = ptm.executeUpdate()>0? true: false;
            }
            
        }finally{
            if(ptm!=null) ptm.close();
            if(conn !=null) conn.close();
        }
        return check;
    }
}
