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
import utilities.SlugGenerator;

/**
 *
 * @author lekha
 */
public class HostelDAO implements DAOInterface<Hostel>, Serializable {

    @Override
    public boolean add(Hostel hostel) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO hostels( owner_id, city, district, ward, street, name, hostel_slug)\n"
                        + "VALUES ( ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, hostel.getOwnerId());
                pst.setString(2, hostel.getCity());
                pst.setString(3, hostel.getDistrict());
                pst.setString(4, hostel.getWard());
                pst.setString(5, hostel.getStreet());
                pst.setString(6, hostel.getName());
                
                String slug=SlugGenerator.generateSlug(hostel.getName());
                if(!getList("hostel_slug", slug).isEmpty()){
                    int i=1;
                    while(true){
                        if(!getList("hostel_slug", slug+"-"+i).isEmpty()){
                            i=i+1;
                        }
                        else{
                            slug=slug+"-"+i;
                            break;
                        }
                    }
                }
                pst.setString(7, slug);
                
                int affectedCol = pst.executeUpdate();
                if (affectedCol == 1) {
                    System.out.println("Insert successfully");
                    return true;
                } else {
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
    public Hostel getOne(String column, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

@Override
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
                String district = rs.getString("district");
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
