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
public class PermissionOfManager {
    private int pom;
    private int permission_id; 
    private int manager_id;

    public PermissionOfManager() {
        this.pom = 0;
        this.permission_id = 0;
        this.manager_id = 0;
    }

    public PermissionOfManager(int pom, int permission_id, int manager_id) {
        this.pom = pom;
        this.permission_id = permission_id;
        this.manager_id = manager_id;
    }

    public PermissionOfManager(int permission_id, int manager_id) {
        this.permission_id = permission_id;
        this.manager_id = manager_id;
    }

    public int getPom() {
        return pom;
    }

    public void setPom(int pom) {
        this.pom = pom;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }
    
}
