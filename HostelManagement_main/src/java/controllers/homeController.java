/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AccountDAO;
import dtos.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lekha
 */
public class homeController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String processingPath = (String) request.getAttribute("processingPath");

            String[] splitter = processingPath.split("/");
            
            if(session.getAttribute("loginedAccount")==null){
                response.sendRedirect("/HostelManagement_main/login");
                return;
            }
            
            String[] indexNames ={"account_id"};
            int id = (Integer) session.getAttribute("loginedAccount");
            Account acc = AccountDAO.getAccount(indexNames, id+"");
            switch (acc.getStatus()){
                case 0:
                    request.setAttribute("pageTitle", "Home");
                    request.setAttribute("pageContent", "disabledAccount.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                    
                case 1:
                    request.setAttribute("pageTitle", "Home");
                    request.setAttribute("pageContent", "verifyOTP.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                    
                case 2:
                    if(acc.getRole()==0){
                        request.setAttribute("pageTitle", "Home");
                        request.setAttribute("pageContent", "home.jsp");
                        
                        if (splitter.length < 2) {
                            request.setAttribute("homeContent", "default");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            return;
                        } else {      
//                            processingPath = splitter[1];
//                            for (int processingPathi = 2; i < splitter.length; i++) {
//                                processingPath = processingPath + "/" + splitter[i];
//                            }
                            System.out.println("processing path: " + processingPath);

                            request.setAttribute("processingPath", processingPath);
                            request.getRequestDispatcher(splitter[1] + "Controller").forward(request, response);
                            return;
                        }
                    }
                    else{
                        response.sendRedirect("/HostelManagement_main/admin");
                        return;
                    }
                    
                default:
                    response.setStatus(404);
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
