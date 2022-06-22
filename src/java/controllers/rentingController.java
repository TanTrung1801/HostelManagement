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
 * @author nguye
 */
public class rentingController extends HttpServlet {

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
        HttpSession session = request.getSession();
        String processingPath = (String) request.getAttribute("processingPath");
        String contextPath = request.getContextPath();

        String[] splitter = processingPath.split("/");

        if (splitter.length == 3) {
            response.sendRedirect(contextPath + "/home/renting/view");
            return;
        } else {
            request.setAttribute("homeContent", "renting");
            switch (splitter[3]) {
                

                case "view":
                    request.setAttribute("rentingContent", "view");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;

                case "create-feedback":
                    request.setAttribute("rentingContent", "createFeedbackForm");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                case "view-payment":
                    request.setAttribute("rentingContent", "viewPayment");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                case "view-payment-detail":
                    request.setAttribute("rentingContent", "viewPaymentDetail");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
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
            request.setAttribute("homeContent", "renting");

            switch (request.getParameter("action")) {
                case "createFeedback":
                    System.out.println(Colors.YELLOW + "rentingController forward to createFeedbackServlet" + Colors.RESET);
                    request.getRequestDispatcher("createFeedbackServlet").forward(request, response);
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
