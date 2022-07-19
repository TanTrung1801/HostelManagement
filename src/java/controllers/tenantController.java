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
public class tenantController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet tenantController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet tenantController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            response.sendRedirect(contextPath+processingPath + "/renting-rooms");
            return;
        } else {
            request.setAttribute("hasTools", true);
            request.setAttribute("homeTools", "tenantTools.jsp");
            switch (splitter[3]) {
                case "hostels":
                    System.out.println(Colors.YELLOW + "vendorController forward to hostelController" + Colors.RESET);
                    request.getRequestDispatcher("hostelController").forward(request, response);
                    return;

                case "renting-rooms":
                    request.setAttribute("pageTitle", "Renting Rooms");
                    request.setAttribute("homeDetails", "tenant/roomList.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;

                case "send-feedback":
                    request.setAttribute("pageTitle", "Send Feedback");
                    request.setAttribute("homeDetails", "tenant/sendFeedback.jsp");
                    request.setAttribute("createHostelContent", "createHostel-form.jsp");
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
