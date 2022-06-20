/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author lekha
 */
public class Account implements Serializable{
    private int accountId;
    private String username;
    private String hashedPassword;
    private int role;
    private String firstname;
    private String lastname;
    private String fullname;
    private String email;
    private String phone;
    private String idCardNumber;
    private int status;
    private Date dateOfBirth;
    private Timestamp createdAt;

    public Account() {
        this.role = 0;
        this.status = 1;
    }

    public Account(String username, String hashedPassword, int role, String firstname, String lastname, String email, String phone, String idCardNumber, int status, Date dateOfBirth){
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.idCardNumber = idCardNumber;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
    }
    
    public Account(int accountId, String username, String hashedPassword, int role, String firstname, String lastname, String fullname, String email, String phone, String idCardNumber, int status, Date dateOfBirth, Timestamp createdAt) {
        this.accountId = accountId;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.idCardNumber = idCardNumber;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
