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

/**
 *
 * @author Truong Thanh Trung
 */
public class RoomsDAO implements DAOInterface<Rooms> {

    public static List<Rooms> getAllListRoom(String indexValue) throws SQLException, Exception {
        Connection cn = null;
        List<Rooms> room = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();

            String sql = "SELECT *\n"
                    + "FROM rooms\n"
                    + "WHERE hostel_id =" + indexValue + ";";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs != null && rs.next()) {
                int room_id = rs.getInt("room_id");
                int hostel_id = rs.getInt("hostel_id");
                String name = rs.getString("name");
                String room_slug = rs.getString("room_slug");
                int max_contract = rs.getInt("max_contract");
                room.add(new Rooms(room_id, hostel_id, name, room_slug, max_contract));
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

    public static Rooms getRooms(String index, String indexValue) {
        Connection cn = null;
        Rooms room = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
//                String columns = "";
//                for (int i = 0; i < indexNames.length; i++) {
//                    if (i == 0) {
//                        columns = indexNames[i];
//                    } else {
//                        columns = columns + "," + indexNames[i];
//                    }
//                }
                String sql = "SELECT* \n"
                        + "FROM rooms\n"
                        + "WHERE " + index + "= ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, indexValue);
                //pst.setString(2, password);
                ResultSet rs = pst.executeQuery();

                if (rs != null && rs.next()) {

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

//    public boolean addRooms(String hostel_id , String owner_id, String city, String distrinct, String ward, String street, String name, String hostel_slug) {
//        
//        Connection cn = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            cn = DatabaseConnection.makeConnection();
//            if (cn != null) {
//                String sql = "INSERT INTO hostels( hostel_id, owner_id, city, distrinct, ward, street, name, hostel_slug)\n"
//                        + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);";
//                PreparedStatement pst = cn.prepareStatement(sql);
//                pst.setString(1, hostel_id);
//                pst.setString(2, owner_id);
//                pst.setString(3, city);
//                pst.setString(4, distrinct);
//                pst.setString(5, ward);
//                pst.setString(6, street);
//                pst.setString(7, name);
//                pst.setString(8, hostel_slug);
//                int affectedCol = pst.executeUpdate();
//                if (affectedCol == 1) {
//                    System.out.println("Insert successfully");
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return false;
//    }
    public static void main(String[] args) throws Exception {

        List<Rooms> listRooms = getAllListRoom("1");
        Rooms ro = new Rooms();
        ro = getRooms("hostel_id", "1");
        System.out.println(listRooms);
        System.out.println(ro);
    }

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
                pst.setString(3, room.getRoom_slug());
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
                        + "FROM Rooms\n"
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
                String sql = "SELECT room_id, hostel_id, name, room_slug, max_contract\n"
                        + "FROM Rooms\n"
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
