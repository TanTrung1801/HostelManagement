/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RoomDAO;
import dtos.Room;
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
public class rentingRoomController extends HttpServlet {

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

        if (splitter.length == 4) {
            response.setStatus(404);
            return;
        } else {
            request.setAttribute("hasTools", true);
            request.setAttribute("homeTools", "tenantRoomTools.jsp");

            String room_slug = splitter[4];

            System.out.println(room_slug);

            RoomDAO dao = new RoomDAO();
            if (dao.getList("room_slug", room_slug).isEmpty()) {
                response.setStatus(404);
                return;
            }
            if (splitter.length == 5) {
                response.sendRedirect(contextPath + processingPath + "/room-details");
                return;
            }

            Room room = dao.getOne("room_slug", room_slug);
            int room_id = room.getRoom_id();
            int hostel_id = room.getHostel_id();

            switch (splitter[5]) {
                case "room-details":

                    request.setAttribute("room_id", room_id);
                    request.setAttribute("room_slug", room_slug);
                    request.setAttribute("pageTitle", "Room Details");
                    request.setAttribute("homeDetails", "rentingRoom/roomTenantList.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                case "send-feedback":

                    request.setAttribute("room_id", room_id);
                    request.setAttribute("hostel_id", hostel_id);
                    request.setAttribute("room_slug", room_slug);
                    request.setAttribute("pageTitle", "Send Feedback");
                    request.setAttribute("homeDetails", "rentingRoom/sendFeedback.jsp");
                    request.setAttribute("sendFeedbackContent", "createFeedback-form.jsp");
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

//        HttpSession session = request.getSession();
//        String processingPath = (String) request.getAttribute("processingPath");
//        String contextPath = request.getContextPath();
//
//        String[] splitter = processingPath.split("/");
//        
//        if (splitter.length == 4) {
//            response.setStatus(404);
//            return;
//        } else {
//            request.setAttribute("hasTools", true);
//            request.setAttribute("homeTools", "tenantRoomTools.jsp");
//            
//            String action = request.getParameter("action");
//        
//        switch(action){
//            
//            case "createFeedback":
//                System.out.println(Colors.YELLOW + "rentingRoomController forward to createFeedbackServlet" + Colors.RESET);
//                request.getRequestDispatcher("createFeedbackServlet").forward(request, response);
//                return;
//                
//        }
//        }
          
        

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
