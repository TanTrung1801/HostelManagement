/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Room;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utilities.Colors;
import utilities.DatabaseConnection;
import utilities.StringUtil;

/**
 *
 * @author lekha
 */
public class RoomDAO implements DAO<Room>, Serializable {

    @Override
    public boolean add(Room room) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO Rooms(hostel_id, name, room_slug, max_contract)\n"
                        + "VALUES ( ?, ?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                
                pst.setInt(1, room.getHostelId());
                pst.setString(2, room.getName());
                pst.setString(3, StringUtil.generateSlug(room.getName()));
                pst.setInt(4, room.getMaxContract());

                int affectedCol = pst.executeUpdate();
                if (affectedCol == 1) {
                    System.out.println(Colors.GREEN + "Insert successfully" + Colors.RESET);
                    if (cn != null) {
                        try {
                            cn.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return true;
                } else {
                    System.out.println(Colors.RED + "Insert failed" + Colors.RESET);
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(Colors.RED + "Insert failed" + Colors.RESET);
            return false;
        }
        System.out.println(Colors.RED + "Insert failed" + Colors.RESET);
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
    public Room getOne(String column, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Room getOne(HashMap<String, String> columnValuePair) {    
        Connection cn = null;
        Room room = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                if (columnValuePair.size() > 0) {
                    String where = "";
                    ArrayList<String> whereValues = new ArrayList();

                    for (String column : columnValuePair.keySet()) {
                        where = where + "  " + column + "=?";
                        whereValues.add(columnValuePair.get(column));
                    }
                    where = where.trim().replace("  ", " AND ");
                    
                    System.out.println(where);
                    
                    String sql = "SELECT *\n"
                            + "FROM Rooms\n"
                            + "WHERE "+ where;
                    PreparedStatement pst = cn.prepareStatement(sql);
                    for (int i = 0; i < whereValues.size(); i++) {
                        pst.setString(i + 1, whereValues.get(i));
                    }
                    ResultSet rs = pst.executeQuery();

                    if (rs != null && rs.next()) {                     
                        int roomId = rs.getInt("room_id");
                        int hostelId = rs.getInt("hostel_id");
                        String name = rs.getString("name");
                        String roomSlug = rs.getString("room_slug");
                        int maxContract = rs.getInt("max_contract");

                        room = new Room(roomId, hostelId, name, roomSlug, maxContract);
                    }
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
    public List<Room> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Room> getList(String column, String value) {
        Connection cn = null;
        List<Room> list = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();

            String sql = "SELECT *\n"
                    + "FROM rooms\n"
                    + "WHERE " + column + " = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            while (rs != null && rs.next()) {
                int roomId= rs.getInt("room_id");
                int hostelId = rs.getInt("hostel_id");
                String name = rs.getString("name");
                String roomSlug = rs.getString("room_slug");
                int maxContract=rs.getInt("max_contract");
                
                
                list.add(new Room(roomId, hostelId, name, roomSlug, maxContract));
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
        return list;
    }
    
}
