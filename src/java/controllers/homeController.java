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
import utilities.Colors;

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
           
            HttpSession session = request.getSession();
            
            String contextPath = request.getContextPath();
            String processingPath = (String) request.getAttribute("processingPath");
   
            request.setAttribute("pageTitle", "Home");
            request.setAttribute("mainContent", "home.jsp");
            
            String[] splitter = processingPath.split("/");
            
            if(splitter.length >= 3){
                if(splitter[2].equals("profile")){
                    System.out.println(Colors.YELLOW + "homeController forward to profileController" + Colors.RESET);
                    request.getRequestDispatcher("profileController").forward(request, response);
                    return;
                }
            }
          
            int id = (Integer) session.getAttribute("loginId");
            AccountDAO dao = new AccountDAO();
            Account acc = dao.getOne("account_id", id + "");
            System.out.println(acc);
            
            switch (acc.getStatus()) {
                case 0:
                    request.setAttribute("homeContent", "disabledAccount.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;

                case 1:
                    request.setAttribute("homeContent", "unverifiedAccount.jsp");
                    //request.getRequestDispatcher("index.jsp").forward(request, response);
                    System.out.println(Colors.YELLOW + "homeController forward to unverifiedAccountController" + Colors.RESET);
                    request.getRequestDispatcher("unverifiedAccountController").forward(request, response);
                    return;

                case 2:
                    if (acc.getRole() == 0) {
                        if (splitter.length >= 3){
                            if (splitter[2].equals("admin")){
                                response.setStatus(403);
                                return;
                            }
                            else{
                                if(splitter[2].equals("owning") || splitter[2].equals("managing")){
                                    System.out.println(Colors.YELLOW + "homeController forward to vendorController" + Colors.RESET);
                                    request.getRequestDispatcher("vendorController").forward(request, response);
                                    return;
                                }
                                if(splitter[2].equals("renting")){
                                    System.out.println(Colors.YELLOW + "homeController forward to tenantController" + Colors.RESET);
                                    request.getRequestDispatcher("tenantController").forward(request, response);
                                    return;
                                }
                                System.out.println(Colors.YELLOW + "homeController forward to "+splitter[2]+"Controller" + Colors.RESET);
                                request.getRequestDispatcher(splitter[2] + "Controller").forward(request, response);
                                return;
                            }
                        } else {
                            request.setAttribute("homeContent", "default.jsp");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            return;
                        }
                    } else {
                        if (splitter.length >= 3){
                            if (splitter[2].equals("admin")){
                                System.out.println(Colors.YELLOW + "homeController forward to adminController" + Colors.RESET);
                                request.getRequestDispatcher("adminController").forward(request, response);
                                return;
                            }else{
                                response.setStatus(403);
                                return;
                            }
                        }
                        else{
                            response.sendRedirect(contextPath + "/admin");
                            return;
                        }
                    }
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
