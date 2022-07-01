/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.HostelDAO;
import dtos.Hostel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
public class roomController extends HttpServlet {

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
            out.println("<title>Servlet roomController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet roomController at " + request.getContextPath() + "</h1>");
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
        int hostelId = (Integer) request.getAttribute("hostelId");

        String[] splitter = processingPath.split("/");
                
        if (splitter.length == 6) {
            response.setStatus(404);
            return;
        } else {
            request.setAttribute("hasTools", true);
            request.setAttribute("homeTools", "vendorRoomTools.jsp");
            
            HostelDAO hostelDao = new HostelDAO();
            Hostel hostel = hostelDao.getOne("hostel_id", hostelId+"");
                             
            if(hostel==null){
                response.setStatus(404);
                return;
            }else{
//                HashMap<String, String> columnValuePair = new HashMap<String, String>();
//                columnValuePair.put("hostel_id", hostelId+"");
//                columnValuePair.put("room_slug", splitter[6]);
//
//                RoomDAO roomDao = new RoomDAO();
//                Room room = roomDao.getOne(columnValuePair);
//                
//                if (room==null){
//                    response.setStatus(404);
//                    return;
//                }
            }
            if(splitter.length == 7){
                response.sendRedirect(contextPath+processingPath+"/room-details");
                return;
            }
            
            switch (splitter[7]) {  
                case "room-details":
                    request.setAttribute("pageTitle", "Room Details");
                    request.setAttribute("homeDetails", "room/roomDetails.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;

                case "contract-list":
                    request.setAttribute("pageTitle", "Contract List");
                    request.setAttribute("homeDetails", "room/contractList.jsp");
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
