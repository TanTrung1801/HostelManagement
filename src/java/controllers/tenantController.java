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
 * @author tantrung
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

        HttpSession session = request.getSession();
        String processingPath = (String) request.getAttribute("processingPath");
        String contextPath = request.getContextPath();

        String[] splitter = processingPath.split("/");

        String[] rights;

        if (splitter.length == 3) {
            response.sendRedirect(contextPath + processingPath + "/tenant-list");
            return;
        } else {
            request.setAttribute("hasTools", true);
            request.setAttribute("homeTools", "tenantTools.jsp");
            switch (splitter[3]) {
                case "tenant-room":
                    System.out.println(Colors.YELLOW + "rentingController forward to rentingRoomController" + Colors.RESET);
                    request.getRequestDispatcher("rentingRoomController").forward(request, response);
                    return;
                case "tenant-list":
                    
                    
//                    if (splitter.length == 5) {
//                        response.sendRedirect(contextPath + processingPath + "/view");
//                        return;
//                    } else {
//                        String room_slug = splitter[4];
//                        System.out.println(room_slug);
//                        
//                        request.setAttribute("hasTools", true);
//                        request.setAttribute("homeTools", "tenantRoomTools.jsp");
//                        ///
//                        switch (splitter[6]) {
//                            case "view":
//                                request.setAttribute("room_slug", room_slug);
//                                request.setAttribute("homeDetails", "renting/roomTenantList.jsp");
//                                request.getRequestDispatcher("index.jsp").forward(request, response);
//                                return;
//                        }
//                    }
                    request.setAttribute("pageTitle", "Hostel List");
                    request.setAttribute("homeDetails", "renting/rentingList.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;

                case "view-payment":
                    request.setAttribute("pageTitle", "Payment List");
                    request.setAttribute("homeDetails", "renting/paymentList.jsp");
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
        
        String processingPath = (String) request.getAttribute("processingPath");
        String contextPath = request.getContextPath();

        String[] splitter = processingPath.split("/");
        
        request.setAttribute("hasTools", true);
        request.setAttribute("homeTools", "tenantRoomTools.jsp");
        
        switch (request.getParameter("action")) {
            case "createFeedback":
                System.out.println(Colors.YELLOW + "tenantController forward to createFeedbackServlet" + Colors.RESET);
                request.getRequestDispatcher("createFeedbackServlet").forward(request, response);
                return;
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
