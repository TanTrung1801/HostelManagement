/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import daos.AccountDAO;
import daos.UpdateTokenDAO;
import dtos.Account;
import dtos.UpdateToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.TokenGenerator;
//import javax.activation.*;

/**
 *
 * @author lekha
 */
public class sendEmailVerificationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int accountId = (Integer) request.getSession().getAttribute("loginId");
        AccountDAO accDao = new AccountDAO();
        Account acc = accDao.getOne("account_id", accountId+"");
        
        // Recipient's email ID needs to be mentioned.
        String to = acc.getEmail();

        // Sender's email
        String myAccountEmail = "HostelManagementSE1633@gmail.com";
        String password = "gfrnbfkypeojkbef";

        // Get system properties
        Properties props = System.getProperties();

        // Setup mail server
        props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.socketFactory.port", "465");
                    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", "465");
                    
        // Set Session object.
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(myAccountEmail));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            String token = TokenGenerator.generateNewToken();
            
            UpdateTokenDAO updateTokenDao = new UpdateTokenDAO();
            UpdateToken updateToken = new UpdateToken(token, accountId, 60, "email");
            
            updateTokenDao.add(updateToken);
            // Send the actual HTML message, as big as you like
            message.setContent("<h1>Please click the link below to verify your email at Hostel City</h1><br/><a href='http://localhost:8080"+request.getContextPath()+"/verify?token="+token+"'>Verify</a>", "text/html");

            // Send message
            Transport.send(message);
            
            request.setAttribute("sent", true);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        finally{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
