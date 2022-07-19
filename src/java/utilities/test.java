/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import dtos.RoomModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

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
                    
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(5);
        format.setRoundingMode(RoundingMode.HALF_EVEN);
        System.out.println(format.format(BigDecimal.valueOf(2000)));

        RoomModel rm = new RoomModel();
        
        System.out.println("".equals(null));
    }
}
