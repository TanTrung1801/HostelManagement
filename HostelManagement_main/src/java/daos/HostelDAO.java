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
import java.util.List;
import utilities.DatabaseConnection;
import utilities.SlugGenerator;

/**
 *
 * @author lekha
 */
public class HostelDAO implements Serializable {
    public static List<Hostel> getByColumn(String column, String value){
        Connection cn = null;
        List<Hostel> host = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();

             String sql = "SELECT *\n"
                        + "FROM hostels\n"
                        + "WHERE "+column+" = ?";
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
    
    public static boolean addHostel(int ownerId, String city, String district, String ward, String street, String name) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO Accounts( owner-id, city, district, ward, street, name, hostel_slug)\n"
                        + "VALUES ( ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, ownerId);
                pst.setString(2, city);
                pst.setString(3, district);
                pst.setString(4, ward);
                pst.setString(5, street);
                pst.setString(6, name);
                
                String slug=SlugGenerator.generateSlug(name);
                if(!getByColumn("hostel_slug", slug).isEmpty()){
                    int i=1;
                    while(true){
                        if(!getByColumn("hostel_slug", slug+"-"+i).isEmpty()){
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
}
