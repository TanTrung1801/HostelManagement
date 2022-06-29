package utilities;

import java.io.Serializable;
import java.security.SecureRandom;
import java.text.Normalizer;
import java.util.Base64;
import java.util.regex.Pattern;

public class StringUtil implements Serializable{
    
    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
    
    public static String trimMid(String name) {
        String splitter[] = name.split("  ");
        String newName = "";     
        for (int i=0; i<splitter.length; i++){
           if (!splitter[i].trim().equals("")) newName=newName.trim()+" "+splitter[i].trim();
        }
        return newName.trim();
    }
    
    public static String removeAccent(String s) { 
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); 
        temp = pattern.matcher(temp).replaceAll("");
        temp = temp.replaceAll("Đ", "D");
        return temp.replaceAll("đ", "d"); 
    }
    
    public static String generateSlug(String name){
        return removeAccent(trimMid(name.trim()).toLowerCase()).replaceAll("[^a-zA-Z0-9\\s]", "").replace(" ", "-");    
    }
}
