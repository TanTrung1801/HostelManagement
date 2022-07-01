/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Hostel;
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
 * @author lekha
 */
public class HostelDAO implements DAO<Hostel>, Serializable {

    @Override
    public boolean add(Hostel hostel) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public Hostel getOne(String column, String value) {
        Connection cn = null;
        Hostel host = null;
        try {
            cn = DatabaseConnection.makeConnection();

            String sql = "SELECT *\n"
                    + "FROM hostels\n"
                    + "WHERE " + column + " = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            if (rs != null && rs.next()) {
                int hostel_id = rs.getInt("hostel_id");
                int owner_id = rs.getInt("owner_id");
                String city = rs.getString("city");
                String distrinct = rs.getString("distrinct");
                String ward = rs.getString("ward");
                String street = rs.getString("street");
                String name = rs.getString("name");
                String hostel_slug = rs.getString("hostel_slug");
                
                host = new Hostel(hostel_id, owner_id, city, distrinct, ward, street, name, hostel_slug);
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
        return host;
    }
    

    public List<Hostel> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Hostel> getList(String column, String value) {
        Connection cn = null;
        List<Hostel> host = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();

            String sql = "SELECT *\n"
                    + "FROM hostels\n"
                    + "WHERE " + column + " = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            while (rs != null && rs.next()) {
                int hostel_id = rs.getInt("hostel_id");
                int owner_id = rs.getInt("owner_id");
                String city = rs.getString("city");
                String district = rs.getString("distrinct");
                String ward = rs.getString("ward");
                String street = rs.getString("street");
                String name = rs.getString("name");
                String hostel_slug = rs.getString("hostel_slug");
                
                host.add(new Hostel(hostel_id, owner_id, city, district, ward, street, name, hostel_slug));
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
        return host;
    }
    
    
    
    
}
