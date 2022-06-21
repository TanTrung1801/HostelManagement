/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import daos.AccountDAO;
import daos.UpdateTokenDAO;
import dtos.UpdateToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lekha
 */
public class verifyEmailServlet extends HttpServlet {

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
            
            String token = request.getParameter("token");
            
            UpdateTokenDAO updateTokenDao = new UpdateTokenDAO();
            UpdateToken updateToken = updateTokenDao.getOne("token", token);
            
            request.setAttribute("verifyStatus", "failed"); //if success override this later
            if (updateToken!=null){
                if(updateToken.getType().equals("email")){
                    if(updateToken.getStatus()==0){
                        request.setAttribute("ERROR", "This link is expired");
                    }
                    else{
                        HashMap<String, String> columnValuePair = new HashMap<String, String>();
                        columnValuePair.put("account_status", "2");
                        
                        AccountDAO accDao = new AccountDAO();
                        if(accDao.update(updateToken.getAccountId(), columnValuePair)){
                            request.setAttribute("verifyStatus", "succeeded");
                            updateTokenDao.delete(token);
                        }
                        else{
                            request.setAttribute("ERROR", "Update Status Failed");
                        }
                    }
                }
                else{                
                    request.setAttribute("ERROR", "Invalid Action");
                }
            }
            else{
                request.setAttribute("ERROR", "Invalid Token");
            }
            request.setAttribute("mainContent", "verifyEmail.jsp");
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
