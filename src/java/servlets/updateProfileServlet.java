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
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lekha
 */
public class updateProfileServlet extends HttpServlet {

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

            String firstname = request.getParameter("firstName");
            String lastname = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String txtDateOfBirth = request.getParameter("dateOfBirth");

            int accountId = (Integer) request.getSession().getAttribute("loginId");
            
            boolean check = true;
            AccountDAO dao = new AccountDAO();
            Account acc = null;

            if(firstname != null && lastname != null && phone != null && txtDateOfBirth != null){
                if (!phone.matches("[0-9]{10,10}") || phone.length() != 10) {
                    check = false;
                    request.setAttribute("ERROR_PHONE", "phone must only contains number with length of 10");
                }
                
                acc = dao.getOne("phone", phone);
                if (acc != null) {
                    if(acc.getAccountId()!=accountId){
                        check = false;
                        request.setAttribute("ERROR_PHONE", "this phone number is bound to another account!!");
                    }
                }
            }
            else{
                check = false;
                request.setAttribute("ERROR", "please enter all required fields!!");
            }
            
            if(check){
                Date dateOfBirth = Date.valueOf(txtDateOfBirth);
                
                acc = dao.getOne("account_id", accountId+"");

                HashMap<String, String> columnValuePair = new HashMap<String, String>();
                
                if(!acc.getFirstname().equals(firstname)) columnValuePair.put("first_name", firstname);
                if(!acc.getLastname().equals(lastname)) columnValuePair.put("last_name", lastname);
                if(!acc.getPhone().equals(phone)) columnValuePair.put("phone", phone);
                if(!acc.getDateOfBirth().equals(dateOfBirth)) columnValuePair.put("date_of_birth", txtDateOfBirth);
                
                if(!columnValuePair.isEmpty()){
                    if (dao.update(accountId, columnValuePair)) {
                        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {                         
                            request.getRequestDispatcher("/WEB-INF/jspf/profileContent/profileDetails.jsp").include(request, response);
                            return;
                        }
                        else{
                            request.setAttribute("pageTitle", "Profile");
                            request.setAttribute("profileContent", "view");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            return;
                        }
                    }
                    else{
                        request.setAttribute("ERROR", "Update failed!!");                
                    }
                }
                else{
                    if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                        request.getRequestDispatcher("/WEB-INF/jspf/profileContent/profileDetails.jsp").include(request, response);
                        return;
                    }
                }
            }
            
            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                request.getRequestDispatcher("/WEB-INF/jspf/profileContent/updateForm.jsp").include(request, response);
                return;
            } else {
                request.setAttribute("pageTitle", "Profile");
                request.setAttribute("profileContent", "view");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
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
