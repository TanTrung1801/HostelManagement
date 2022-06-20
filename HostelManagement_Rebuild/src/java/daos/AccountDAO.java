/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Account;
import java.io.Serializable;
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
public class AccountDAO implements DAOInterface<Account>, Serializable {

    @Override
    public boolean add(Account account) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO Accounts( username, hashed_password, role, first_name, last_name, email, phone, id_card_number, account_status, date_of_birth)\n"
                        + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, account.getUsername());
                pst.setString(2, account.getHashedPassword());
                pst.setInt(3, account.getRole());
                pst.setString(4, account.getFirstname());
                pst.setString(5, account.getLastname());
                pst.setString(6, account.getEmail());
                pst.setString(7, account.getPhone());
                pst.setString(8, account.getIdCardNumber());
                pst.setInt(9, account.getStatus());
                pst.setDate(10, account.getDateOfBirth());

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
    public boolean update(int accountId, HashMap<String, String> columnValuePair) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                if (columnValuePair.size()>0){
                    String set = "";
                    ArrayList<String> setValues = new ArrayList();

                    for (String column : columnValuePair.keySet()) {
                        set = set + "  " + column + "=?";
                        setValues.add(columnValuePair.get(column));
                    }
                    set = set.trim().replace("  ", ", ");
                    
                    String sql = "UPDATE Accounts\n"
                            + "SET "+set+"\n"
                            + "WHERE account_id=?";
                    PreparedStatement pst = cn.prepareStatement(sql);
                    
                    for(int i=0; i<setValues.size(); i++){
                        pst.setString(i+1, setValues.get(i));
                    }
                    pst.setString(setValues.size()+1, accountId+"");
                    
                    int affectedCol = pst.executeUpdate();
                    if (affectedCol == 1) {
                        System.out.println("Update successfully");
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean delete(int accountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getOne(String column, String value) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "SELECT account_id, username, hashed_password, role, first_name, last_name, full_name, email, phone, id_card_number, account_status, date_of_birth, created_at\n"
                        + "FROM Accounts\n"
                        + "WHERE "+column+" = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, value);
                ResultSet rs = pst.executeQuery();

                if (rs != null && rs.next()) {
                    int accountId = rs.getInt("account_id");
                    String username = rs.getString("username");
                    String hashedPassword = rs.getString("hashed_password");
                    int role = rs.getInt("role");
                    String firstname = rs.getString("first_name");
                    String lastname = rs.getString("last_name");
                    String fullname = rs.getString("full_name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String idCardNumber = rs.getString("id_card_number");
                    int status = rs.getInt("account_status");
                    Date dateOfBirth = rs.getDate("date_of_birth");
                    Timestamp createdAt = rs.getTimestamp("created_at");

                    acc = new Account(accountId, username, hashedPassword, role, firstname, lastname, fullname, email, phone, idCardNumber, status, dateOfBirth, createdAt);
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
        return acc;
    }

    public Account getOne(String[] indexNames, String indexValue) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String columns = "";
                for(int i =0; i<indexNames.length; i++){
                    if (i==0) columns = indexNames[i];
                    else columns = columns + "," + indexNames[i];
                }
                
                String sql = "SELECT account_id, username, hashed_password, role, first_name, last_name, full_name, email, phone, id_card_number, account_status, date_of_birth, created_at\n"
                        + "FROM Accounts\n"
                        + "WHERE ? IN ("+columns+")";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, indexValue);
                ResultSet rs = pst.executeQuery();

                if (rs != null && rs.next()) {
                    int         accountId       = rs.getInt("account_id");
                    String      username        = rs.getString("username");
                    String      hashedPassword  = rs.getString("hashed_password");
                    int         role            = rs.getInt("role");
                    String      firstname       = rs.getString("first_name");
                    String      lastname        = rs.getString("last_name");
                    String      fullname        = rs.getString("full_name");
                    String      email           = rs.getString("email");
                    String      phone           = rs.getString("phone");
                    String      idCardNumber    = rs.getString("id_card_number");
                    int         status          = rs.getInt("account_status");
                    Date        dateOfBirth     = rs.getDate("date_of_birth");
                    Timestamp   createdAt       = rs.getTimestamp("created_at");         

                    acc = new Account(accountId, username, hashedPassword, role, firstname, lastname, fullname, email, phone, idCardNumber, status, dateOfBirth, createdAt);
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
        return acc;
    }
    
    @Override
    public List<Account> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
