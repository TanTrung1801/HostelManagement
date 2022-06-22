/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.PermissionOfManager;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import utilities.DatabaseConnection;

/**
 *
 * @author Truong Thanh Trung
 */
public class PermissionOfManagerDAO implements DAOInterface<PermissionOfManager>, Serializable {

    @Override
    public boolean add(PermissionOfManager pom) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO contracts(permission_id, manager_id)\n"
                        + "VALUES ( ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, pom.getPermission_id());
                pst.setInt(2, pom.getManager_id());
                int affectedCol = pst.executeUpdate();
                if (affectedCol == 1) {
                    System.out.println("Insert successfully");
                    return true;
                } else {
                    System.out.println("INSERT FAIL!!!");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean update(int id, HashMap<String, String> columnValuePair) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PermissionOfManager getOne(String column, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PermissionOfManager> getList(String column, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
