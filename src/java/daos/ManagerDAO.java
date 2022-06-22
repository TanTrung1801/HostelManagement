/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Hostel;
import dtos.Managers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utilities.DatabaseConnection;

/**
 *
 * @author Truong Thanh Trung
 */
public class ManagerDAO implements DAOInterface<Managers>, Serializable  {

    @Override
    public boolean add(Managers managers) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO contracts(account_id, hostel_id)\n"
                        + "VALUES ( ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, managers.getAccount_id());
                pst.setInt(2, managers.getHostel_id());
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
    public Managers getOne(String column, String value) {
        Connection cn = null;
        Managers managers = new Managers();
        try {
            cn = DatabaseConnection.makeConnection();

            String sql = "SELECT *\n"
                    + "FROM managers\n"
                    + "WHERE " + column + " = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            while (rs != null && rs.next()) {
                int manager_id = rs.getInt("manager_id");
                int account_id = rs.getInt("account_id");
                int hostel_id = rs.getInt("hostel_id"); 
                managers = new Managers(manager_id, account_id, hostel_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return managers;
    }

    @Override
    public List<Managers> getList(String column, String value) {
        Connection cn = null;
        List<Managers> managers = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();

            String sql = "SELECT *\n"
                    + "FROM managers\n"
                    + "WHERE " + column + " = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            while (rs != null && rs.next()) {
                int manager_id = rs.getInt("manager_id");
                int account_id = rs.getInt("account_id");
                int hostel_id = rs.getInt("hostel_id");
                
                managers.add(new Managers(manager_id, account_id, hostel_id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return managers;
    }
    
}
