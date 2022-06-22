/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Feedback;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utilities.DatabaseConnection;

/**
 *
 * @author nguye
 */
public class FeedbackDAO implements DAOInterface<Feedback>{
    public static List<Feedback> getFeedBack(String column, int value) {
        Connection cn = null;
        List<Feedback> fb = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                
                String sql = "SELECT feedback_id, hostel_id, room_id, client_id, content, send_at\n"
                        + "FROM Feedbacks\n"
                        + "WHERE "+column +"=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, value);
                ResultSet rs = pst.executeQuery();

                while (rs != null && rs.next()) {
                    int         feedback_id     = rs.getInt("feedback_id");
                    int         hostel_id       = rs.getInt("hostel_id");
                    int         room_id         = rs.getInt("room_id");
                    int         client_id       = rs.getInt("client_id");
                    String      content         = rs.getString("content");
                    Date        send_at         = rs.getDate("send_at");
                    
                    fb.add(new Feedback(feedback_id, hostel_id, room_id, client_id, content, send_at));
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
        return fb;
    }
    
    public static boolean createFeedBack(int hostel_id, int room_id, int client_id, String content) {
        Connection cn = null;
        try {

            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO Feedbacks(hostel_id, room_id, client_id, content)\n"
                        + "VALUES (?, ?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, hostel_id);
                if(room_id == 0){
                    pst.setNull(2, java.sql.Types.INTEGER);
                }
                else{
                    pst.setInt(2, room_id);
                }   
                pst.setInt(3, client_id);
                pst.setString(4, content);
                

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
    public boolean add(Feedback feedback) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO Feedbacks(hostel_id, client_id, content)\n"
                        + "VALUES (?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, feedback.getHostel_id());
                pst.setInt(2, feedback.getClient_id());
                pst.setString(3, feedback.getContent());
                

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
    public Feedback getOne(String column, String value) {
        Connection cn = null;
        Feedback feedback = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT feedback_id, hostel_id, room_id, client_id, content, send_at\n"
                        + "FROM Payments\n"
                        + "WHERE "+(column)+" = ?;";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();

                while (rs != null && rs.next()) {
                    int     feedback_id = rs.getInt("feedback_id");
                    int     hostel_id   = rs.getInt("hostel_id");
                    int     room_id     = rs.getInt("sender_id");
                    int     client_id   = rs.getInt("receiver_id");
                    String  content     = rs.getString("created_at");
                    Date    send_at     = rs.getDate("send_at");

                    feedback = new Feedback(feedback_id, hostel_id, room_id, client_id, content, send_at);
                    
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
        return feedback;
    }

    @Override
    public List<Feedback> getList(String column, String value) {
        Connection cn = null;
        List<Feedback> feedback = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT feedback_id, hostel_id, room_id, client_id, content, send_at\n"
                        + "FROM Payments\n"
                        + "WHERE "+(column)+" = ?;";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();

                while (rs != null && rs.next()) {
                    int     feedback_id = rs.getInt("feedback_id");
                    int     hostel_id   = rs.getInt("hostel_id");
                    int     room_id     = rs.getInt("sender_id");
                    int     client_id   = rs.getInt("receiver_id");
                    String  content     = rs.getString("created_at");
                    Date    send_at     = rs.getDate("send_at");

                    feedback.add(new Feedback(feedback_id, hostel_id, room_id, client_id, content, send_at));
                    
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
        return feedback;
    }
}
