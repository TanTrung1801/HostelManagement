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
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lekha
 */
public class updateHostelDetailsServlet extends HttpServlet {

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

            String processingPath = (String) request.getAttribute("processingPath");
            String contextPath = request.getContextPath();

            String[] splitter = processingPath.split("/");

            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String ward = request.getParameter("ward");
            String street = request.getParameter("street").trim();
            String name = request.getParameter("hostel_name");

            
            HostelDAO dao = new HostelDAO();
            Hostel hostel = new Hostel();
            hostel = dao.getOne("hostel_slug", splitter[4]);

            HashMap<String, String> columnValuePair = new HashMap<String, String>();

            boolean check = true;

            if (city != null && district != null && ward != null && street != null && name != null && !city.equals("") && !district.equals("") && !ward.equals("") && !street.equals("") && !name.equals("")) {
                if (!hostel.getCity().equals(city)) {
                    columnValuePair.put("city", city);
                }
                if (!hostel.getDistrict().equals(district)) {
                    columnValuePair.put("district", district);
                }
                if (!hostel.getWard().equals(ward)) {
                    columnValuePair.put("ward", ward);
                }
                if (!hostel.getStreet().equals(street)) {
                    columnValuePair.put("street", street);
                }
                if (!hostel.getName().equals(name)) {
                    columnValuePair.put("name", name);
                }

                if (columnValuePair.containsKey("city") || columnValuePair.containsKey("district") || columnValuePair.containsKey("ward") || columnValuePair.containsKey("street")) {
                    if (!dao.getList("address", city + " - " + district + " - " + ward + " - " + street).isEmpty()) {
                        check = false;
                        request.setAttribute("ERROR", "This address is bound to a hostel!!");
                    }
                }
            } else {
                check = false;
                request.setAttribute("ERROR", "please enter all required fields!!");
            }

            if (check) {
                if (dao.update(hostel.getHostelId(), columnValuePair)) {
                    request.setAttribute("pageTitle", "Room List");
                    request.setAttribute("homeDetails", "hostel/hostelDetails.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                }
            }
            
            request.setAttribute("pageTitle", "Room List");
            request.setAttribute("homeDetails", "hostel/hostelDetails.jsp");
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
