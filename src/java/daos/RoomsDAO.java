/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Hostel;
import dtos.Rooms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utilities.DatabaseConnection;
import utilities.SlugGenerator;

/**
 *
 * @author Truong Thanh Trung
 */
public class RoomsDAO implements DAOInterface<Rooms> {
    @Override
    public boolean add(Rooms room) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO Rooms(hostel_id, name, room_slug, max_contract)\n"
                        + "VALUES (?, ?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, room.getHostel_id());
                pst.setString(2, room.getName());
                
                String slug=SlugGenerator.generateSlug(room.getName());
                if(!getList("room_slug", slug).isEmpty()){
                    int i=1;
                    while(true){
                        if(!getList("room_slug", slug+"-"+i).isEmpty()){
                            i=i+1;
                        }
                        else{
                            slug=slug+"-"+i;
                            break;
                        }
                    }
                }                              
                pst.setString(3, slug);
                pst.setInt(4, room.getMax_contract());
                
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
        boolean check = false;
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String set = "";
                ArrayList<String> setValues = new ArrayList();
                for (String column : columnValuePair.keySet()) {
                    set = set + " " + column + "=?";
                    setValues.add(columnValuePair.get(column));
                }
                set = set.trim().replace(" ", " ");

                String sql = "UPDATE Rooms\n"
                        + "SET " + set + "\n"
                        + " WHERE room_id =?;";
                PreparedStatement pst = cn.prepareStatement(sql);

                for (int i = 0; i < setValues.size(); i++) {
                    pst.setString(i + 1, setValues.get(i));
                }
                pst.setString(setValues.size() + 1, id + "");

                check = pst.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rooms getOne(String column, String value) {
        Connection cn = null;
        Rooms room = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT room_id, hostel_id, name, room_slug, max_contract\n"
                        + "FROM rooms\n"
                        + "WHERE " + (column) + " = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();

                while (rs != null && rs.next()) {
                    int room_id = rs.getInt("room_id");
                    int hostel_id = rs.getInt("hostel_id");
                    String name = rs.getString("name");
                    String room_slug = rs.getString("room_slug");
                    int max_contract = rs.getInt("max_contract");

                    room = new Rooms(room_id, hostel_id, name, room_slug, max_contract);
                }
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
        return room;
    }

    @Override
    public List<Rooms> getList(String column, String value) {
        Connection cn = null;
        List<Rooms> room = new ArrayList<>();
        try {

            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT* \n"
                        + "FROM rooms\n"
                        + "WHERE " + (column) + " = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();

                while (rs != null && rs.next()) {
                    int room_id = rs.getInt("room_id");
                    int hostel_id = rs.getInt("hostel_id");
                    String name = rs.getString("name");
                    String room_slug = rs.getString("room_slug");
                    int max_contract = rs.getInt("max_contract");
                    room.add(new Rooms(room_id, hostel_id, name, room_slug, max_contract));
                }
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
        return room;
    }

}
