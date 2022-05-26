/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UserEmailDAO;
import dto.UserDTO;
import dto.UserEmailDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "SendEmailController", urlPatterns = {"/SendEmailController"})
public class SendEmailController extends HttpServlet {

    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "verify.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            UserEmailDAO se = new UserEmailDAO();
            UserDTO user = (UserDTO) request.getAttribute("VERIFY_USER");
            String userID = user.getUserID();
            String email = user.getEmail();
            String fullName = user.getFullName();
            String password = user.getPassword();
            String roleID = user.getRoleID();
            String phone = user.getPhoneNumber();
            Date dateOfBirth = user.getDoB();
            String idCard = user.getIDcard();
            String code = se.getRandom();
            UserEmailDTO ue = new UserEmailDTO(userID, fullName, roleID, password, email, phone, idCard, dateOfBirth, code);
            boolean check = se.sendEmail(ue);
            if (check) {
                HttpSession session = request.getSession();
                session.setAttribute("AUTHCODE",  ue);
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR", "Unknown error, try again!");
            }
        } catch (Exception e) {
            log("Error at SendEmailController: " + e.toString());
        } finally {
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
