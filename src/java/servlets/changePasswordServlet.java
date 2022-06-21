/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import daos.AccountDAO;
import dtos.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilities.PasswordHash;
import static utilities.PasswordHash.validatePassword;

/**
 *
 * @author lekha
 */
public class changePasswordServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            String contextPath = request.getContextPath();
            
            String currentPass = request.getParameter("currentPass");
            String newPass = request.getParameter("newPass");
            String confirmPass = request.getParameter("confirmPass");

            try {
                if (currentPass != null && newPass != null && confirmPass != null) {
                    int accountId =(Integer) session.getAttribute("loginId");
                    AccountDAO dao = new AccountDAO();
                    Account acc = dao.getOne("account_id", accountId+"");
                    if (acc != null) {
                        if (validatePassword(currentPass, acc.getHashedPassword())) {
                            if (newPass.length() >= 8 && newPass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
                                if (newPass.equals(confirmPass)) {
                                    HashMap<String, String> columnValuePair = new HashMap();
                                    columnValuePair.put("hashed_password", PasswordHash.createHash(newPass));
                                    if (dao.update(accountId, columnValuePair)) {
                                        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                                            request.getRequestDispatcher("/WEB-INF/jspf/profileContent/changePasswordSucceed.jsp").forward(request, response);
                                        } else {
                                            request.setAttribute("profileContent", "changePasswordSucceed");
                                            request.getRequestDispatcher("/index.jsp").forward(request, response);
                                        }
                                        return;
                                    } else {
                                        request.setAttribute("ERROR", "Change password failed, password remain unchanged");
                                    }
                                } else {
                                    request.setAttribute("ERROR", "your new password and password confirm do not match!!");                         
                                }
                            } else {
                                request.setAttribute("ERROR", "password must be longer than 8 characters and contain at least 1 uppercase, 1 lower case and 1 number!!");                               
                            }
                        } else {
                            request.setAttribute("ERROR", "Wrong Password!");
                        }
                    } else {
                        request.setAttribute("ERROR", "Login session error");
                    }                   
                } else {
                    request.setAttribute("ERROR", "Please enter all the required fields!");
                }
                if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                    request.getRequestDispatcher("/WEB-INF/jspf/profileContent/changePasswordForm.jsp").forward(request, response);
                }else{
                    request.setAttribute("profileContent", "changePasswordForm");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException  e) {
                e.printStackTrace();
            }
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
