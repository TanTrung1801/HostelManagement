/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import daos.HostelDAO;
import daos.RoomDAO;
import dtos.Hostel;
import dtos.Room;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lekha
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
            /* TODO output your page here. You may use following sample code. */
            String processingPath = (String) request.getAttribute("processingPath");
            String contextPath = request.getContextPath();

            String[] splitter = processingPath.split("/");
            
            String name         = request.getParameter("name");
            String txtMaxContract  = request.getParameter("maxContract");
 
            if (name != null && txtMaxContract != null && !name.equals("") && !txtMaxContract.equals("")) {
                try {
                    int maxContract = Integer.parseInt(txtMaxContract);
                    
                    HostelDAO hostelDAO = new HostelDAO();
                    Hostel hostel = hostelDAO.getOne("hostel_slug", splitter[4]);

                    if (hostel != null) {
                        HashMap<String, String> columnValuePair = new HashMap<String, String>();
                        columnValuePair.put("hostel_id", hostel.getHostelId() + "");
                        columnValuePair.put("name", name);

                        RoomDAO roomDAO = new RoomDAO();
                        Room room = roomDAO.getOne(columnValuePair);

                        if (room == null) {
                            room = new Room(hostel.getHostelId(), name, maxContract);
                            if(roomDAO.add(room)){
                                request.setAttribute("pageTitle", "Create Room");
                                request.setAttribute("homeDetails", "hostel/createRoom.jsp");
                                request.setAttribute("createRoomContent", "createRoom-succeed.jsp");
                                request.getRequestDispatcher("index.jsp").forward(request, response);
                                return;
                            }
                            else request.setAttribute("ERROR", "Add failed");
                        } else {
                            request.setAttribute("ERROR", "Name already exist");
                        }
                    } else {
                        request.setAttribute("ERROR", "Invalid hostel");
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("ERROR", "Max Contract must be a number");
                    e.printStackTrace();
                }
            }
            else{
                request.setAttribute("ERROR", "Please enter all the required fields");
            }
            request.setAttribute("pageTitle", "Create Room");
            request.setAttribute("homeDetails", "hostel/createRoom.jsp");
            request.setAttribute("createRoomContent", "createRoom-form.jsp");
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
