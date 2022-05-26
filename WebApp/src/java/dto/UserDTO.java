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
    private String fullName;
    private String roleID;
    private String password;
    private String email; 
    private String phone; 
    private String idCard;
    private boolean status; 
    private Date dateOfBirth;
    
    public UserDTO() {
        this.userID = "";
        this.fullName = "";
        this.roleID = "";
        this.password = "";
        this.dateOfBirth = null;
        this.email="";
        this.phone="";
        this.idCard="";
        this.status=false;
    }

    public UserDTO(String userID, String fullName, String roleID, String password, String email, String phone, String idCard, boolean status, Date dateOfBirth) {
        this.userID = userID;
        this.fullName = fullName;
        this.roleID = roleID;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.idCard = idCard;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

  
    
}
