/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import daos.AccountDAO;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import utilities.DatabaseConnection;
import utilities.PasswordHash;
import static utilities.PasswordHash.createHash;
import static utilities.PasswordHash.validatePassword;

/**
 *
 * @author lekha
 */
public class test_function {

    public static void main(String[] args)
            throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {
        try
        {
            String Password1="Khang31032002";
            String Password2="Khang@123";
            
            String Hash1 = createHash(Password1);
            String Hash2 = createHash(Password2);
            String Hash3 = createHash(Password1);
            
            System.out.println(Hash1);
            System.out.println(Hash2);
            System.out.println(Hash3);
            
            System.out.println(validatePassword(Password1, Hash1));
            System.out.println(validatePassword("khang31032002", Hash1));
            System.out.println(validatePassword(Password2, Hash2));
            System.out.println(validatePassword(Password1, Hash3));
            
            

            // Test password validation
            boolean failure = false;
            System.out.println("Running tests...");
            for(int i = 0; i < 100; i++)
            {
                String password = ""+i;
                String hash = createHash(password);
                String secondHash = createHash(password);
                if(hash.equals(secondHash)) {
                    System.out.println("FAILURE: TWO HASHES ARE EQUAL!");
                    failure = true;
                }
                String wrongPassword = ""+(i+1);
                if(validatePassword(wrongPassword, hash)) {
                    System.out.println("FAILURE: WRONG PASSWORD ACCEPTED!");
                    failure = true;
                }
                if(!validatePassword(password, hash)) {
                    System.out.println("FAILURE: GOOD PASSWORD NOT ACCEPTED!");
                    failure = true;
                }
            }
            if(failure)
                System.out.println("TESTS FAILED!");
            else
                System.out.println("TESTS PASSED!");
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: " + ex);
        }
        
        HashMap<String, String> test = new HashMap<>();
        test.put("greeting", "hello");
        test.put("greet", "hi");
        
        System.out.println(test.size());
        
//        String[] test2 = {"Volvo", "BMW", "Ford", "Mazda"};
//        
//        String columns = "";
//                for(int i =0; i<test2.length; i++){
//                    if (i==0) columns = test2[i];
//                    else columns = columns + "," + test2[i];
//                }
//        
//        System.out.println(columns);
//        
//        System.out.println("Kaaa".matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$"));
//        System.out.println("lekhang8@gmail.com".matches("^[a-z0-9._%+-]+@(gmail.com|fpt.edu.vn|yahoo.com)$"));
//        
//        Date d = Date.valueOf("2002-03-31");
//        System.out.println("7abea1a82e58881284c13e25a223e5578b305bfa5c255c7b".length());
//        System.out.println(AccountDAO.addAccount("Lumethys", "1000:7abea1a82e58881284c13e25a223e5578b305bfa5c255c7b:1d96ac55461a66615744ac30f2dac277f6db01e2035d880e", 0, "Nguyên Khang", "Lê", "lekhang8@gmail.com", "0974555081", "352693636", 1, d));
//        
        
//        try (Connection cn = DatabaseConnection.makeConnection()) {
//            System.out.println("HELLOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//            System.out.println(cn.getCatalog());
//        } catch (SQLException ex) {
//            //Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        HashMap<String, String> a = new HashMap();
        a.put("account_id", "1");
        a.put("username", "Khang");
        a.put("email", "l@gmail.com");
        a.put("asdasd", "hihih");
        a.put("qwert", "hahaha");
        a.put("fdgf", "hohoho");
        
        String b = "";
        ArrayList<String> c = new ArrayList();
        for(String aa : a.keySet()){
            b = b + "  " +aa+"=?";
            c.add(a.get(aa));
        }
        
        b = b.trim().replace("  ", ", ");
        
        System.out.println(b);
        
        for(int i=0; i<c.size(); i++){
            System.out.println(i+1 + "=" + c.get(i));
        }
        System.out.println(c.size()+1 +"=123");
    }
}
