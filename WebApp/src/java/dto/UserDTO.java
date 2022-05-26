/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;



/**
 *
 * @author nguye
 */
public class UserDTO {
    private String userID;
    private String password;
    private String roleID;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String IDcard;
    private Date DoB;
    private int status;

    public UserDTO() {
        this.userID = "";
        this.password = "";
        this.roleID = "";
        this.fullName = "";
        this.email = "";
        this.phoneNumber = "";
        this.IDcard = "";
        this.DoB = null;
        this.status = 0;
    }

    public UserDTO(String userID, String password, String roleID, String fullName, String email, String phoneNumber, String IDcard, Date DoB, int status) {
        this.userID = userID;
        this.password = password;
        this.roleID = roleID;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.IDcard = IDcard;
        this.DoB = DoB;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date DoB) {
        this.DoB = DoB;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

    
    
}
