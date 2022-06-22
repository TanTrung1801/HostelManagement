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
public class Permission {
    private int permission_id;
    private String name; 

    public Permission() {
        this.permission_id = 0;
        this.name = "";
    }

    public Permission(int permission_id, String name) {
        this.permission_id = permission_id;
        this.name = name;
    }

    public Permission(String name) {
        this.name = name;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
