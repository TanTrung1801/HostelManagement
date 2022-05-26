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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import utl.DBUtils;

/**
 *
 * @author nguye
 */
public class UserDAO {

    private static final String LOGIN = "SELECT fullName, roleID, email, phoneNumber, IDcard, DoB, status FROM tblUsers WHERE userID=? AND password =?";
    private static final String CHECK_DUPLICATE = "SELECT fullName FROM tblUsers WHERE userID=?";
    private static final String CHECK_Email_DUPLICATE = "SELECT fullName FROM tblUsers WHERE email=?";
    private static final String CREATE = "INSERT INTO tblUsers(userID, password, roleID, fullName, email, phoneNumber, IDcard, DoB, status) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SEARCH_ALL = "SELECT userID, roleID, fullName, email, phoneNumber, IDcard, DoB, status FROM tblUsers";
    
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
                    String email = rs.getString("email");
                    String phoneNumber = rs.getString("phoneNumber");
                    String IDcard = rs.getString("IDcard");
                    Date DoB = rs.getDate("DoB");
                    int status = rs.getInt("status");
                    user = new UserDTO(userID, "", roleID, fullName, email, phoneNumber, IDcard, DoB, status);

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
    
    
    public boolean checkDuplicate(String userID) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if(rs.next()){
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
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
    
    public boolean checkEmailDuplicate(String email) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                ptm = conn.prepareStatement(CHECK_Email_DUPLICATE);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if(rs.next()){
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
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
    
    public boolean createUser(UserDTO user) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getPassword());
                ptm.setString(3, user.getRoleID());
                ptm.setString(4, user.getFullName());
                ptm.setString(5, user.getEmail());
                ptm.setString(6, user.getPhoneNumber());
                ptm.setString(7, user.getIDcard());
                ptm.setDate(8, user.getDoB());
                ptm.setInt(9, user.getStatus());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ptm!=null)   ptm.close();
            if(conn!=null)  conn.close();
        }
        return check;
    }
    
    
    public List<UserDTO> getListUser() throws SQLException {
        List<UserDTO> listUser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_ALL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String roleID = rs.getString("roleID");
                    String fullName = rs.getString("fullName");
                    String email = rs.getString("email");
                    String phoneNumber = rs.getString("phoneNumber");
                    String IDcard = rs.getString("IDcard");
                    Date dob = rs.getDate("DoB");
                    int status = rs.getInt("status");
                    String password = "***";
                    listUser.add(new UserDTO(userID, password, roleID, fullName, email, phoneNumber, IDcard, dob, status));
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
        return listUser;
    }

}
