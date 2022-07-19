/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Contract;
import dtos.Room;
import dtos.RoomModel;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utilities.DatabaseConnection;

/**
 *
 * @author lekha
 */
public class RoomModelDAO implements Serializable, DAO<RoomModel> {

    @Override
    public boolean add(RoomModel entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public RoomModel getOne(String column, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public RoomModel getOne(HashMap<String, String> columnValuePair) {    
        Connection cn = null;
        RoomModel roomModel = null;
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
                    
                    //System.out.println(where);
                    
                    String sql = "SELECT *\n"
                            + "FROM Rooms \n"
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
                        
                        List<Contract> activeContracts = new ArrayList();
                        
                        sql = "SELECT *\n"
                            + "FROM contracts \n"
                            + "WHERE room_id = ? AND contract_status = 1";
                        pst = cn.prepareStatement(sql);
                        pst.setString(1, roomId+"");
                        
                        rs = pst.executeQuery();
                        while(rs != null && rs.next()){
                            
                            int contractId =rs.getInt("contract_id");
                            //int roomId =rs.getInt("room_id");
                            int clientId =rs.getInt("client_id");
                            BigDecimal roomPrice = rs.getBigDecimal("room_price");
                            Date startDate =rs.getDate("start_date");
                            Date endDate =rs.getDate("end_date");
                            int status =rs.getInt("contract_status");
                            BigDecimal deposit = rs.getBigDecimal("deposit");
                            Timestamp createdAt = rs.getTimestamp("created_at");
                                      
                            activeContracts.add(new Contract(contractId, roomId, clientId, roomPrice, startDate, endDate, status, deposit, createdAt));
                                                    
                        }
                        roomModel = new RoomModel(roomId, hostelId, name, roomSlug, maxContract, activeContracts);                        
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
        return roomModel;
    }
    
    public RoomModel getOne(Room room) {
        Connection cn = null;
        RoomModel roomModel = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                List<Contract> activeContracts = new ArrayList();

                String sql = "SELECT *\n"
                        + "FROM contracts \n"
                        + "WHERE room_id = ? AND contract_status = 1";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, room.getRoomId() + "");

                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {

                    int contractId = rs.getInt("contract_id");
                    //int roomId =rs.getInt("room_id");
                    int clientId = rs.getInt("client_id");
                    BigDecimal roomPrice = rs.getBigDecimal("room_price");
                    Date startDate = rs.getDate("start_date");
                    Date endDate = rs.getDate("end_date");
                    int status = rs.getInt("contract_status");
                    BigDecimal deposit = rs.getBigDecimal("deposit");
                    Timestamp createdAt = rs.getTimestamp("created_at");

                    activeContracts.add(new Contract(contractId, room.getRoomId(), clientId, roomPrice, startDate, endDate, status, deposit, createdAt));

                }
                roomModel = new RoomModel(room.getRoomId(), room.getHostelId(), room.getName(), room.getRoomSlug(), room.getMaxContract(), activeContracts);

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
        return roomModel;
    }

    @Override
    public List<RoomModel> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RoomModel> getList(String column, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
