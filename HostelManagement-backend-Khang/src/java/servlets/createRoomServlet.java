/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import daos.RoomDAO;
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
 * @author SE151471 Hoang Minh Tuan>
 */
public class createRoomServlet extends HttpServlet {

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
            
          
            String name         = request.getParameter("name");
            String maxContract     =request.getAttribute("maxContract");
            String roomSlug     = request.getParameter("roomSlug");
            int    hostelId     = (Integer) session.getAttribute("hostelId");
            
            if (name!=null && maxContract !=null  && roomSlug != null){
                Room room = new Room(hostelId, name, roomSlug, hostelId);
               
                RoomDAO dao  new RoomDAO();
                if(dao.getList(name, roomId){
                    if (dao.add(room)) {
                        request.setAttribute("pageTitle", "Create Hostel");
                        request.setAttribute("homeDetails", "vendor/createHostel.jsp");
                        request.setAttribute("createRoomContent", "createRoom-succeed.jsp");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                        return;
                    } else {
                        request.setAttribute("ERROR", "Create hostel error");
                    }
                }
                else{
                    request.setAttribute("ERROR", "This address is bound to another Hostel");
                }
            }
            else{
                request.setAttribute("ERROR", "Please enter all the required fields");
            }
            
            request.setAttribute("pageTitle", "Create Hostel");
            request.setAttribute("homeDetails", "vendor/createHostel.jsp");
            request.setAttribute("createHostelContent", "createHostel-form.jsp");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;

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
