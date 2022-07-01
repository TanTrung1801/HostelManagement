/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import daos.FeedbackDAO;
import daos.RoomDAO;
import dtos.Feedback;
import dtos.Room;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tantrung
 */
public class createFeedbackServlet extends HttpServlet {

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

            //content of feedback
            String hostel_id = request.getParameter("hostel_id");
            String room_id = request.getParameter("room_id");
            String content = request.getParameter("feedback");
            //
            //client_id
            int client_id = (Integer) session.getAttribute("loginId");

            FeedbackDAO dao = new FeedbackDAO();
            Feedback feedback = null;

            if (room_id == null) {
                feedback = new Feedback(Integer.parseInt(hostel_id), 0, client_id, content);
                if (dao.add(feedback));

                
                request.setAttribute("pageTitle", "Send Feedback");
                request.setAttribute("homeDetails", "rentingRoom/sendFeedback.jsp");
                request.setAttribute("sendFeedbackContent", "createFeedback-succeed.jsp");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            } else {
                RoomDAO roomDAO = new RoomDAO();
                Room room = roomDAO.getOne("room_id", room_id);
                String room_slug = room.getRoom_slug();
                feedback = new Feedback(Integer.parseInt(hostel_id), Integer.parseInt(room_id), client_id, content);
                if (dao.add(feedback)) {
                    request.setAttribute("room_id", room_id);
                    request.setAttribute("hostel_id", hostel_id);
                    request.setAttribute("room_slug", room_slug);
                    request.setAttribute("pageTitle", "Send Feedback");
                    request.setAttribute("homeDetails", "rentingRoom/sendFeedback.jsp");
                    request.setAttribute("sendFeedbackContent", "createFeedback-succeed.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
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
