/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import daos.HostelDAO;
import dtos.Hostel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Truong Thanh Trung
 */
@WebServlet(name = "createHostelServlet", urlPatterns = {"/createHostelServlet"})
public class createHostelServlet extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession();
            String contextPath = request.getContextPath();

            HostelDAO host = new HostelDAO();
            String city = request.getParameter("city");
            String district = request.getParameter("dítrict");
            String ward = request.getParameter("ward");
            String street = request.getParameter("street");
            String name = request.getParameter("name");
            int ownerId = (int) session.getAttribute("loginId");

            if (city != null && district != null && ward != null && street != null && name != null) {
//                if(HostelDAO.getByColumn("address", city+" - "+district+" - "+ward+" - "+street).isEmpty()){                
                if (host.add(new Hostel(ownerId, city, district, ward, street, name))) {
                    out.println("<h6>add successful</h6>");
                    request.setAttribute("SUCCESS", "Create Hostel Successful!!");
                } else {
                    request.setAttribute("ERROR", "Create hostel error");
                }
//                }
//                else{
//                    request.setAttribute("ERROR", "this address is already bound to another hostel");
//                }
            } else {
                request.setAttribute("ERROR", "Please enter all the required fields");
            }
            response.sendRedirect(contextPath + "/home/owning/create-hostel");
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
