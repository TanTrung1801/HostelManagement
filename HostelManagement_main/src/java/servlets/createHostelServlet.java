/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import daos.HostelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lekha
 */
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String city         = request.getParameter("firstName");
            String district     = request.getParameter("lastName");
            String ward         = request.getParameter("email");
            String street       = request.getParameter("phone").trim();
            String name         = request.getParameter("idCardNumber");
            
            int    ownerId      = Integer.parseInt(request.getParameter("ownerId"));
            
            if (city!=null && district !=null && ward!=null && street !=null && name!=null){
                if(HostelDAO.getByColumn("address", city+" - "+district+" - "+ward+" - "+street).isEmpty()){
                    if(HostelDAO.addHostel(ownerId, city, district, ward, street, name)){
                        out.println("<h6>add successful</h6>");
                    }
                    else{
                        request.setAttribute("ERROR", "Create hostel error");
                    }
                }
                else{
                    request.setAttribute("ERROR", "this address is already bound to another hostel");
                }
            }
            else{
                request.setAttribute("ERROR", "Please enter all the required fields");
            }
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
