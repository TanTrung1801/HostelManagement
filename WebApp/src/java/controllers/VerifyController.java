/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UserDAO;
import dto.UserDTO;
import dto.UserEmailDTO;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
@WebServlet(name = "VerifyController", urlPatterns = {"/VerifyController"})
public class VerifyController extends HttpServlet {

    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "login.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, NamingException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try{
        HttpSession session = request.getSession();
            UserEmailDTO userEmail = (UserEmailDTO) session.getAttribute("AUTHCODE");
            String otp = request.getParameter("otp");
            if (otp.equals(userEmail.getCodeVerify())) {
                String userID = userEmail.getUserID();
                String email = userEmail.getEmail();
                String fullName = userEmail.getFullName();
                String password = userEmail.getPassword();
                String roleID = userEmail.getRoleID();
                String phone = userEmail.getPhone();
                Date dateOfBirth = userEmail.getDateOfBirth();
                String idCard = userEmail.getIdCard();
                UserDTO user = new UserDTO(userID, fullName, roleID, password, email, phone,idCard,true,dateOfBirth);
                UserDAO dao = new UserDAO();
                boolean check = dao.createUser(user);
                if (check) {
                    url = SUCCESS;
                    request.setAttribute("SUCCESS_MESSAGE", "Your account has been activated!");
                    session.invalidate();
                } else {
                    request.setAttribute("ERROR", "Unknown Error, try again!");
                    session.invalidate();
                }
            } else {
                request.setAttribute("ERROR", "OTP code is incorrect, please check and re-enter again!");
                url = "verify.jsp";
            }
        }catch (Exception e) {
            log("Error at VerifyUserController: " + e.toString());            
        }finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VerifyController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerifyController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(VerifyController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VerifyController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VerifyController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerifyController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(VerifyController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VerifyController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
