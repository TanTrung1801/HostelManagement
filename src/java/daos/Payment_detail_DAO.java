/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Payment;
import dtos.Payment_detail;
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
public class Payment_detail_DAO implements DAOInterface<Payment_detail>{

    @Override
    public boolean add(Payment_detail paymentDetail) {
        Connection cn = null;
        try {

            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO Payment_details(payment_id, name, price)\n"
                        + "VALUES (?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, paymentDetail.getPayment_id());
                pst.setString(2, paymentDetail.getName());
                pst.setFloat(3, paymentDetail.getPrice());

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
        return false;}

    @Override
    public boolean update(int id, HashMap<String, String> columnValuePair) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment_detail getOne(String column, String value) {
        Connection cn = null;
        Payment_detail detail = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT detail_id, payment_id, name, price\n"
                        + "FROM Payment_details\n"
                        + "WHERE "+(column)+" = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();

                while (rs != null && rs.next()) {
                    int     detail_id   = rs.getInt("detail_id");
                    int     payment_id  = rs.getInt("payment_id");
                    String  name        = rs.getString("name");
                    float   price       = rs.getFloat("price");
                    
                    detail = new Payment_detail(detail_id, payment_id, name, price);
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
        return detail;
    }

    @Override
    public List<Payment_detail> getList(String column, String value) {
        Connection cn = null;
        List<Payment_detail> detail = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT detail_id, payment_id, name, price\n"
                        + "FROM Payment_details\n"
                        + "WHERE "+(column)+" = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();

                while (rs != null && rs.next()) {
                    int     detail_id   = rs.getInt("detail_id");
                    int     payment_id  = rs.getInt("payment_id");
                    String  name        = rs.getString("name");
                    float   price       = rs.getFloat("price");
                    
                    detail.add(new Payment_detail(detail_id, payment_id, name, price));
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
        return detail;
    }

    
    
}
