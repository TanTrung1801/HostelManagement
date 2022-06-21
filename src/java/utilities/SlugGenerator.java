/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.Serializable;

/**
 *
 * @author lekha
 */
public class SlugGenerator implements Serializable {
    public static String generateSlug(String name){
        return trimMid(name.trim()).replace(" ", "-");      
    }
    
    public static String trimMid(String name) {
        String splitter[] = name.split("  ");
        String newName = "";     
        for (int i=0; i<splitter.length; i++){
           if (!splitter[i].trim().equals("")) newName=newName.trim()+" "+splitter[i].trim();
        }
        return newName.trim();
    }
}
