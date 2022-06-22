/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Contracts;

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
 * @author Truong Thanh Trung
 */
public class ContractsDAO implements DAOInterface<Contracts> {

    @Override
    public boolean add(Contracts contracts) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO contracts(room_id, client_id, room_price, start_date, end_date, contract_status, deposit)\n"
                        + "VALUES ( ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, contracts.getRoom_id());
                pst.setInt(2, contracts.getClient_id());
                pst.setDouble(3, contracts.getRoom_price());
                pst.setDate(4, contracts.getStart_date());
                pst.setDate(5, contracts.getEnd_date());
                pst.setInt(6, contracts.getContract_status());
                pst.setDouble(7, contracts.getDeposit());
                int affectedCol = pst.executeUpdate();
                if (affectedCol == 1) {
                    System.out.println("Insert successfully");
                    return true;
                } else {
                    System.out.println("INSERT FAIL!!!");
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
    public Contracts getOne(String column, String value) {
        Connection cn = null;
        Contracts contract = new Contracts();
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT* \n"
                        + "FROM contracts\n"
                        + "WHERE " + column + "= ?;";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int contract_id = rs.getInt("contract_id");
                    int room_id = rs.getInt("room_id");
                    int client_id = rs.getInt("client_id");
                    double room_price = rs.getDouble("room_price");
                    Date start_date = rs.getDate("start_date");
                    Date end_date = rs.getDate("end_date");
                    int contract_status = rs.getInt("contract_status");
                    double deposit = rs.getDouble("deposit");
                    Timestamp createdAt = rs.getTimestamp("created_at");
                    contract = new Contracts(contract_id, room_id, client_id, room_price, start_date, end_date, contract_status, deposit, createdAt);
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

    @Override
    public List<Contracts> getList(String column, String value) {
        Connection cn = null;
        List<Contracts> contract = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT* \n"
                        + "FROM contracts\n"
                        + "WHERE " + column + "= ?;";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int contract_id = rs.getInt("contract_id");
                    int room_id = rs.getInt("room_id");
                    int client_id = rs.getInt("client_id");
                    double room_price = rs.getDouble("room_price");
                    Date start_date = rs.getDate("start_date");
                    Date end_date = rs.getDate("end_date");
                    int contract_status = rs.getInt("contract_status");
                    double deposit = rs.getDouble("deposit");
                    Timestamp createdAt = rs.getTimestamp("created_at");
                    contract.add(new Contracts(contract_id, room_id, client_id, room_price, start_date, end_date, contract_status, deposit, createdAt));
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
    
    
    public List<Contracts> getListContractsStatus(String column, String value) {
        Connection cn = null;
        List<Contracts> contract = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT* \n"
                        + "FROM contracts\n"
                        + "WHERE " + column + "= ? AND contract_status = 1;";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int contract_id = rs.getInt("contract_id");
                    int room_id = rs.getInt("room_id");
                    int client_id = rs.getInt("client_id");
                    double room_price = rs.getDouble("room_price");
                    Date start_date = rs.getDate("start_date");
                    Date end_date = rs.getDate("end_date");
                    int contract_status = rs.getInt("contract_status");
                    double deposit = rs.getDouble("deposit");
                    Timestamp createdAt = rs.getTimestamp("created_at");
                    contract.add(new Contracts(contract_id, room_id, client_id, room_price, start_date, end_date, contract_status, deposit, createdAt));
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
    
    
    public static void main(String[] args) throws Exception {
        ContractsDAO con = new ContractsDAO();
//        List<Contracts> conList = con.getList("room_id", "1");
//        System.out.println(conList);
              List<Contracts> conList = con.getListContractsStatus("room_id","2");
              System.out.println(conList);
//        boolean check = con.add(new Contracts());
//        System.out.println(check);
    }
}
