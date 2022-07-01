/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author lekha
 */
public class test {
    public static void main(String[] args){
        HashMap<String, String> columnValuePair = new HashMap();
        columnValuePair.put("room_id", "131231");
        columnValuePair.put("name", "oiaudhuis");
        columnValuePair.put("asdasd", "oiaudhuis");
        
        String where = "";
                    ArrayList<String> whereValues = new ArrayList();

                    for (String column : columnValuePair.keySet()) {
                        where = where + "  " + column + "=?";
                        whereValues.add(columnValuePair.get(column));
                    }
                    where = where.trim().replace("  ", " AND ");
                    
                    System.out.println(where);
    }
}
