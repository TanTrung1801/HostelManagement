/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.UpdateToken;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import utilities.DatabaseConnection;
import utilities.SlugGenerator;

/**
 *
 * @author lekha
 */
public class UpdateTokenDAO implements DAOInterface<UpdateToken>, Serializable {

    @Override
    public boolean add(UpdateToken updateToken) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO update_tokens( token, account_id, time_out, type)\n"
                        + "VALUES ( ?, ?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, updateToken.getToken());
                pst.setInt(2, updateToken.getAccountId());
                pst.setInt(3, updateToken.getTimeout());
                pst.setString(4, updateToken.getType());
                
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
    
    public boolean delete(String token) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM update_tokens\n"
                        + "WHERE token = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, token);
                
                int affectedCol = pst.executeUpdate();
                if (affectedCol == 1) {
                    System.out.println("Delete successfully");
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
    public UpdateToken getOne(String column, String value) {
        Connection cn = null;
        UpdateToken updateToken = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT *\n"
                        + "FROM update_tokens\n"
                        + "WHERE "+column+" = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();

                if (rs != null && rs.next()) {
                    String      token = rs.getString("token");
                    int         accountId   = rs.getInt("account_id");
                    Timestamp   createdAt   = rs.getTimestamp("created_at");
                    int         timeout     = rs.getInt("time_out");
                    int         status      = rs.getInt("status");
                    String      type        = rs.getString("type");

                    updateToken = new UpdateToken(token, accountId, createdAt, timeout, status, type);
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
        return updateToken;
    }

    @Override
    public List<UpdateToken> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
