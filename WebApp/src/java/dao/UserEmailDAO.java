/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UserEmailDTO;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ACER
 */
public class UserEmailDAO {
    
    public String getRandom() {
        Random rm = new Random();
        int number = rm.nextInt(999999);
        return String.format("%06d", number);
    }

    public boolean sendEmail(UserEmailDTO user) throws MessagingException {
        boolean check = false;
        Properties pr = new Properties();
        pr.put("mail.smtp.auth", "true");
        pr.put("mail.smtp.starttls.enable", "true");
        pr.put("mail.smtp.host", "smtp.gmail.com");
        pr.put("mail.smtp.port", "587");
        
        String myAccountEmail = "htmloan1974@gmail.com";
        String password = "truongthanhtrung123";

        Session session = Session.getInstance(pr, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);

            }

        });

        Message message = prepareMessage(session, myAccountEmail, user);
        Transport.send(message);
        check = true;
        return check;
    }

    private static Message prepareMessage(Session session, String myAccountEmail, UserEmailDTO user) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail, "Hostel Management"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setSubject("Email Verification Code Regarding Member account Registration");
            String mess = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    <title>Document</title>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <div style=\"font-family: Helvetica,Arial,sans-serif;min-width:1000px;overflow:auto;line-height:2\">\n"
                    + "        <div style=\"margin:50px auto;width:70%;padding:20px 0\">\n"
                    + "            <div style=\"border-bottom:1px solid #eee\">\n"
                    + "                <a href=\"\" style=\"font-size:1.4em;color: #9aaf86;text-decoration:none;font-weight:600\">Vegetable\n"
                    + "                    Store</a>\n"
                    + "            </div>\n"
                    + "            <p style=\"font-size:1.1em\">Hi, "+ user.getFullName() +"</p>\n"
                    + "            <p>Thank you for choosing Hostel Managerment. Use the following OTP to complete your Sign Up procedures.</p>\n"
                    + "            <h2\n"
                    + "                style=\"background: #9aaf86;margin: 0 auto;width: max-content;padding: 0 10px;color: #fff;border-radius: 4px;\">\n"
                    + "                "+ user.getCodeVerify() +"</h2>\n"
                    + "            <p style=\"font-size:0.9em;\">Regards,<br />Vegetable Store</p>\n"
                    + "            <hr style=\"border:none;border-top:1px solid #eee\" />\n"
                    + "            <div style=\"float:right;padding:8px 0;color:#aaa;font-size:0.8em;line-height:1;font-weight:300\">\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";
            message.setContent(mess, "text/html");
            return message;
        } catch (Exception e) {
        }
        return null;
    }
}
