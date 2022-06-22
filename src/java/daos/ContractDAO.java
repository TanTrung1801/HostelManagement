/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Contract;
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
public class ContractDAO implements DAOInterface<Contract> {

    @Override
    public boolean add(Contract entity) {
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
    public Contract getOne(String column, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contract> getList(String column, String value) {
        Connection cn = null;
        List<Contract> contract = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT* \n"
                        + "FROM contracts\n"
                        + "WHERE " + column + "= ?;";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int contract_id = rs.getInt("contract_id");
                    int room_id = rs.getInt("room_id");
                    int client_id = rs.getInt("client_id");
                    double room_price = rs.getDouble("room_price");
                    Date start_date = rs.getDate("start_date");
                    Date end_date = rs.getDate("end_date");
                    int contract_status = rs.getInt("contract_status");
                    double deposit = rs.getDouble("deposit");
                    Date createdAt = rs.getDate("created_at");
                    contract.add(new Contract(contract_id, room_id, client_id, room_price, start_date, end_date, contract_status, deposit, createdAt));
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
        return contract;
    }
    public String getHostelID(String column, String value) {
        Connection cn = null;
        String hostel_id = "";
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT R.hostel_id\n"
                        + "FROM rooms R LEFT JOIN contracts C\n"
                        + "ON R.room_id = C.room_id\n"
                        + "WHERE " + column + "= ?;";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    hostel_id = rs.getString("hostel_id");
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
        return hostel_id;
    }
    
    public static void main(String[] args) {
        try {
            ContractDAO dao = new ContractDAO();
            System.out.println(dao.getHostelID("client_id", "1"));
        } catch (Exception e) {
        }
    }

    

    

}
