/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import dao.UserDAO;
import dto.GoogleDTO;
import dto.UserDTO;
import utl.GoogleUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
@WebServlet(name = "LoginGoogleController", urlPatterns = {"/LoginGoogleController"})
public class LoginGoogleController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginGoogleController() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GoogleDTO googleDTO = GoogleUtils.getUserInfo(accessToken);
//            request.setAttribute("id", googleDTO.getId());
//            request.setAttribute("name", googleDTO.getName());
//            request.setAttribute("email", googleDTO.getEmail());
//            request.setAttribute("roleID", "US");

            String userID = googleDTO.getId();
            UserDAO dao = new UserDAO();
            boolean checkDuplicate = dao.checkDuplicate(userID);
            if(checkDuplicate){
                UserDTO loginUser = new UserDTO(googleDTO.getId(),"","US",googleDTO.getGiven_name(), googleDTO.getEmail(),"","",null,1);
                HttpSession session = request.getSession();
                session.setAttribute("LOGIN_USER", loginUser);
                RequestDispatcher dis = request.getRequestDispatcher("user.jsp");
                dis.forward(request, response);
            }else{
                UserDTO loginUser = new UserDTO(googleDTO.getId(),"","US",googleDTO.getGiven_name(), googleDTO.getEmail(),"","",null,1);
                boolean checkCreate = dao.createUser(loginUser);
                if(checkCreate){
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", loginUser);
                    RequestDispatcher dis = request.getRequestDispatcher("user.jsp");
                    dis.forward(request, response);
                }
            }
            
            
            
            
            
            
//            UserDTO loginUser = new UserDTO(googleDTO.getId(),"","US",googleDTO.getGiven_name(), googleDTO.getEmail(),"","","",1);
//            HttpSession session = request.getSession();
//            session.setAttribute("LOGIN_USER", loginUser);
//            RequestDispatcher dis = request.getRequestDispatcher("user.jsp");
//            dis.forward(request, response);
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
            Logger.getLogger(LoginGoogleController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginGoogleController.class.getName()).log(Level.SEVERE, null, ex);
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
