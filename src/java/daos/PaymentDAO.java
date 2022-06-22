/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Payment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utilities.DatabaseConnection;

/**
 *
 * @author nguye
 */
public class PaymentDAO implements DAOInterface<Payment>{

    @Override
    public boolean add(Payment payment) {
        Connection cn = null;
        try {

            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO Payments(contract_id, sender_id, receiver_id, payment_status)\n"
                        + "VALUES (?, ?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, payment.getContract_id());
                pst.setInt(2, payment.getSender_id());
                pst.setInt(3, payment.getReceiver_id());
                pst.setInt(4, payment.getPayment_status());

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
    public boolean update(int paymentId, HashMap<String, String> columnValuePair) {
        boolean check = false;
        Connection cn = null;
        
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                
                String set = "";
                ArrayList<String> setValues = new ArrayList();
                for(String column: columnValuePair.keySet()){
                    set = set + " " + column + "=?";
                    setValues.add(columnValuePair.get(column));
                }
                set = set.trim().replace(" ", " ");
                
                String sql = "UPDATE Rooms\n"
                        +"SET " + set + "\n"
                        +" WHERE room_id =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                
                for(int i = 0; i<setValues.size(); i++){
                    pst.setString(i+1, setValues.get(i));
                }
                pst.setString(setValues.size()+1, paymentId+"");

                check = pst.executeUpdate()>0?true: false;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return check;
    }
    
    
    public boolean update(int status, Date paid, int payment_id){
        boolean check = false;
        Connection cn = null;
        try {
    
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "UPDATE Payments SET payment_status=?, paid_at=?\n"
                        +" WHERE payment_id =?;";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setDate(2, paid);
                pst.setInt(3, payment_id);

                check = pst.executeUpdate()>0?true: false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean delete(int id) {
        boolean check = false;
        Connection cn = null;
        
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
               String sql = "DELETE FROM Payment_details WHERE detail_id = ?;";
               
               PreparedStatement pst = cn.prepareStatement(sql);
               pst.setInt(1, id);
               
               check = pst.executeUpdate() >0?true: false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            
        }
        return check;
    }
    

    @Override
    public Payment getOne(String column, String value) {
        Connection cn = null;
        Payment payment = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT payment_id, contract_id, sender_id, receiver_id, created_at, paid_at, payment_status\n"
                        + "FROM Payments\n"
                        + "WHERE "+(column)+" = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();

                while (rs != null && rs.next()) {
                    int     payment_id  = rs.getInt("payment_id");
                    int     contract_id = rs.getInt("contract_id");
                    int     sender_id   = rs.getInt("sender_id");
                    int     receiver_id = rs.getInt("receiver_id");
                    Date    create_at   = rs.getDate("created_at");
                    Date    paid_at     = rs.getDate("paid_at");
                    int     status      = rs.getInt("payment_status");
                    
                    payment = new Payment(payment_id, contract_id, sender_id, receiver_id, create_at, paid_at, status);
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
        return payment;
    }

    @Override
    public List<Payment> getList(String column, String value) {
        Connection cn = null;
        List<Payment> payment = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT payment_id, contract_id, sender_id, receiver_id, created_at, paid_at, payment_status\n"
                        + "FROM Payments\n"
                        + "WHERE "+(column)+" = ?;";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();

                while (rs != null && rs.next()) {
                    int     payment_id  = rs.getInt("payment_id");
                    int     contract_id = rs.getInt("contract_id");
                    int     sender_id   = rs.getInt("sender_id");
                    int     receiver_id = rs.getInt("receiver_id");
                    Date    create_at   = rs.getDate("created_at");
                    Date    paid_at     = rs.getDate("paid_at");
                    int     status      = rs.getInt("payment_status");
                    
                    payment.add(new Payment(payment_id, contract_id, sender_id, receiver_id, create_at, paid_at, status));
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
        return payment;
    }
    
}
