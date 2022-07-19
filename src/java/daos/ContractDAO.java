/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Contract;
import dtos.Hostel;
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
public class ContractDAO implements Serializable, DAO<Contract> {

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
    public List<Contract> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contract> getList(String column, String value) {
        Connection cn = null;
        List<Contract> list = new ArrayList<>();
        try {
            cn = DatabaseConnection.makeConnection();

            String sql = "SELECT *\n"
                    + "FROM contracts\n"
                    + "WHERE " + column + " = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();

            while (rs != null && rs.next()) {

                int contractId = rs.getInt("contract_id");
                int roomId =rs.getInt("room_id");
                int clientId = rs.getInt("client_id");
                BigDecimal roomPrice = rs.getBigDecimal("room_price");
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                int status = rs.getInt("contract_status");
                BigDecimal deposit = rs.getBigDecimal("deposit");
                Timestamp createdAt = rs.getTimestamp("created_at");

                list.add(new Contract(contractId, roomId, clientId, roomPrice, startDate, endDate, status, deposit, createdAt));

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
