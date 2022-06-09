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
import utilities.DatabaseConnection;

/**
 *
 * @author lekha
 */
public class AccountDAO implements Serializable {

    /**
     *
     * @param indexNames (search by one of the columns - username/ email/ phone)
     * @param indexValue (keyword to search)
     * @return
     */
    public static Account getAccount(String[] indexNames, String indexValue) {
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
                //pst.setString(2, password);
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
    
    public static boolean addAccount(String username, String hashedPassword, int role, String firstname, String lastname, String email, String phone, String idCardNumber, int status, Date dateOfBirth) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO Accounts( username, hashed_password, role, first_name, last_name, email, phone, id_card_number, account_status, date_of_birth)\n"
                        + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, hashedPassword);
                pst.setInt(3, role);
                pst.setString(4, firstname);
                pst.setString(5, lastname);
                pst.setString(6, email);
                pst.setString(7, phone);
                pst.setString(8, idCardNumber);
                pst.setInt(9, status);
                pst.setDate(10, dateOfBirth);

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
    
        public static boolean updateAccount(int accountId, HashMap<String, String> columnValuePair) {
        Connection cn = null;
        try {
            cn = DatabaseConnection.makeConnection();
            if (cn != null) {
                if (columnValuePair.size()>0){
                    String set = "";
                    ArrayList<String> setValue = new ArrayList();

                    for (String column : columnValuePair.keySet()) {
                        set = set + "  " + column + "=?";
                        setValue.add(columnValuePair.get(column));
                    }
                    set = set.trim().replace("  ", ", ");
                    
                    String sql = "UPDATE Accounts\n"
                            + "SET "+set+"\n"
                            + "WHERE account_id=?";
                    PreparedStatement pst = cn.prepareStatement(sql);
                    
                    for(int i=0; i<setValue.size(); i++){
                        pst.setString(i+1, setValue.get(i));
                    }
                    pst.setString(setValue.size()+1, accountId+"");
                    
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
}

