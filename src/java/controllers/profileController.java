/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
public class profileController extends HttpServlet {

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
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            switch (request.getParameter("action")){
                case "getUpdateForm":
                    request.getRequestDispatcher("/WEB-INF/jspf/profileContent/updateForm.jsp").include(request, response);
                    return;
                    
                case "getView":
                    request.getRequestDispatcher("/WEB-INF/jspf/profileContent/profileDetails.jsp").include(request, response);
                    return;
            }
        }
        else{
            HttpSession session = request.getSession();
            String processingPath = (String) request.getAttribute("processingPath");
            String contextPath = request.getContextPath();

            String[] splitter = processingPath.split("/");

            if (splitter.length > 3) {
                request.setAttribute("homeContent", "profile");

                switch(splitter[3]){
                    case "view":
                        request.setAttribute("profileContent", "view");
                        String action = request.getParameter("action");
                        if (action != null){
                            switch (request.getParameter("action")){
                                case "getUpdateForm":
                                    request.setAttribute("viewContent", "updateForm");
                                    break;

                                case "getView":
                                    request.setAttribute("viewContent", "profileDetails");
                                    break;
                            }        
                        }
                        else request.setAttribute("viewContent", "profileDetails");
                        break;

                    case "change-password":
                        request.setAttribute("profileContent", "changePasswordForm");
                        break;
                }

                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else{
                response.sendRedirect(contextPath+"/home/profile/view");
            }
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
        HttpSession session = request.getSession();
        String processingPath = (String) request.getAttribute("processingPath");
        String contextPath = request.getContextPath();

        String[] splitter = processingPath.split("/");

        if (splitter.length > 3) {
            request.setAttribute("homeContent", "profile");

            switch (request.getParameter("action")) {
                case "updateProfile":
                    System.out.println(Colors.YELLOW + "profileController forward to updateProfileServlet" + Colors.RESET);
                    request.getRequestDispatcher("updateProfileServlet").forward(request, response);
                    return;

                case "changePassword":
                    System.out.println(Colors.YELLOW + "profileController forward to changePasswordServlet" + Colors.RESET);
                    request.getRequestDispatcher("changePasswordServlet").forward(request, response);
                    return;
            }
        } else {
            response.sendRedirect(contextPath + "/home/profile/view");
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
