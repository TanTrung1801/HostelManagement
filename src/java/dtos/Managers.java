/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Truong Thanh Trung
 */
public class Managers {
    private int manager_id;
    private int account_id;
    private int hostel_id; 

    public Managers() {
        this.manager_id = 0;
        this.account_id = 0;
        this.hostel_id = 0;
    }

    public Managers(int manager_id, int account_id, int hostel_id) {
        this.manager_id = manager_id;
        this.account_id = account_id;
        this.hostel_id = hostel_id;
    }

    public Managers(int account_id, int hostel_id) {
        this.account_id = account_id;
        this.hostel_id = hostel_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(int hostel_id) {
        this.hostel_id = hostel_id;
    }
    
    
}
