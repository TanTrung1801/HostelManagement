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
        Properties props = new Properties();
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.socketFactory.port", "465");
                    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", "465");
                    
        String myAccountEmail = "HostelManagementSE1633@gmail.com";
        String password = "gfrnbfkypeojkbef";

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);

            }

        });
        Message message = prepareMessage(session, myAccountEmail, user);
        Transport.send(message);
        System.out.println("message sent successfully");
        check = true;
        return check;
    }

    private static Message prepareMessage(Session session, String myAccountEmail, UserEmailDTO user) {
        try {
            String otpvalue = user.getCodeVerify();
            MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(myAccountEmail));// change accordingly
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
                        message.setSubject("Hello");
                        message.setText("Your OTP is: " + otpvalue + ". Please do not reveal this OTP to anyone");
            return message;
        } catch (Exception e) {
            
        }
        return null;
    }
}
