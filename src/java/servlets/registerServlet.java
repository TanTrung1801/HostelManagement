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
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.PasswordHash;

/**
 *
 * @author lekha
 */
public class registerServlet extends HttpServlet {

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

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirm");
            int role = 0;
            String firstname = request.getParameter("firstName");
            String lastname = request.getParameter("lastName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String idCardNumber = request.getParameter("idCardNumber");
            int status = 1;
            String txtDateOfBirth = request.getParameter("dateOfBirth");

            boolean check = true;

            System.out.println(txtDateOfBirth);
            AccountDAO dao = new AccountDAO();

            if (username != null && password != null && confirmPassword != null && firstname != null && lastname != null && email != null && phone != null && idCardNumber != null && txtDateOfBirth != null) {

//                (?=.*[a-z])  -- check lower case letter
//                (?=.*[A-Z]) -- check upper case letter
//                (?=.*\d) -- check one digit exists
                if (password.length() < 8 || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
                    check = false;
                    System.out.println("IM THE STORM THE IS APPROACHING 1");
                    request.setAttribute("ERROR_PASSWORD", "password must be longer than 8 characters and contain at least 1 uppercase, 1 lower case and 1 number!!");
                }

                if (!email.matches("^[a-z0-9._%+-]+@(gmail.com|fpt.edu.vn|yahoo.com)$")) {
                    check = false;
                    System.out.println("IM THE STORM THE IS APPROACHING 2");
                    request.setAttribute("ERROR_EMAIL", "email must not contain any uppercase letter and must end with @gmail.com or @fpt.edu.vn or @yahoo.com");
                }

                if (!phone.matches("[0-9]{10,10}") || phone.length() != 10) {
                    check = false;
                    request.setAttribute("ERROR_PHONE", "phone must only contains number with length of 10");
                }

                if (dao.getOne("username", username) != null) {
                    check = false;
                    System.out.println("IM THE STORM THE IS APPROACHING 3");
                    request.setAttribute("ERROR_USERNAME", "this username is bound to another account!!");
                }

                if (dao.getOne("email", email) != null) {
                    check = false;
                    System.out.println("IM THE STORM THE IS APPROACHING 4");
                    request.setAttribute("ERROR_EMAIL", "this email is bound to another account!!");
                }

                if (dao.getOne("phone", phone) != null) {
                    check = false;
                    System.out.println("IM THE STORM THE IS APPROACHING 5");
                    request.setAttribute("ERROR_PHONE", "this phone number is bound to another account!!");
                }

                if (dao.getOne("id_card_number", idCardNumber) != null) {
                    check = false;
                    System.out.println("IM THE STORM THE IS APPROACHING 6");
                    request.setAttribute("ERROR_IDCARDNUMBER", "this id card number is bound to another account!!");
                }

                if (!password.equals(confirmPassword)) {
                    check = false;
                    System.out.println("IM THE STORM THE IS APPROACHING 7");
                    request.setAttribute("ERROR_CONFIRMPASSWORD", "your password and password confirm do not match!!");
                }
            } else {
                check = false;
                System.out.println("IM THE STORM THE IS APPROACHING 8");
                request.setAttribute("ERROR", "please enter all required fields!!");
            }

            if (check) {
                Date dateOfBirth = Date.valueOf(txtDateOfBirth);

                String hashedPassword = PasswordHash.createHash(password);

                Account acc = new Account(username, hashedPassword, role, firstname, lastname, email, phone, idCardNumber, status, dateOfBirth);

                if (dao.add(acc)) {
                    String contextPath = request.getContextPath();
                    
                    request.setAttribute("pageTitle", "Login");
                    request.setAttribute("mainContent", "loginForm.jsp");
                    response.sendRedirect(contextPath+"/login");
                }
                else{
                    request.setAttribute("ERROR", "Update failed!!");
                }
            }
            
            request.setAttribute("pageTitle", "Register");
            request.setAttribute("mainContent", "registerForm.jsp");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
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
