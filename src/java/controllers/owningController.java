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
public class owningController extends HttpServlet {

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
            String processingPath = (String) request.getAttribute("processingPath");

            String[] splitter = processingPath.split("/");

            if (splitter.length > 2) {
//                if (splitter[2].equals("tool")){
//                    request.getRequestDispatcher("owningToolController").forward(request, response);
//                }
//                else{
                request.getRequestDispatcher("hostelController").forward(request, response);
//                }
            } else {
                request.setAttribute("homeContent", "owning");
                if (request.getParameter("action") != null) {
                    String action = request.getParameter("action");
                    switch (action) {
                        case "create-Hostel":
                            request.getRequestDispatcher("createHostelServlet").forward(request, response);
                            return;
                        case "s":
                            request.getRequestDispatcher("s").forward(request, response);
                            return;
                    }
                }
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
<<<<<<< HEAD
        request.setCharacterEncoding("utf-8");
=======
        request.setCharacterEncoding("utf-8");   
>>>>>>> ec13895d2b45dc633cde81c974619f3c1a9e779b
        HttpSession session = request.getSession();
        String processingPath = (String) request.getAttribute("processingPath");
        String contextPath = request.getContextPath();

        String[] splitter = processingPath.split("/");
        if (splitter.length == 3) {
            response.sendRedirect(contextPath + "/home/owning/view");
            return;
        } else {
            request.setAttribute("homeContent", "owning");
            switch (splitter[3]) {
                case "hostels":
<<<<<<< HEAD
                    if (splitter.length == 5) {
                        request.setAttribute("owningContent", "hostel");
                        request.setAttribute("hostelSlug", splitter[4]);
                        System.out.println(request.getAttribute("hostelSlug"));
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                        return;
                    } else {
                        switch (splitter[5]) {
                            case "room":
                                request.setAttribute("owningContent", "room");
                                request.setAttribute("roomSlug", splitter[6]);
                                System.out.println(request.getAttribute("roomSlug"));
                                request.getRequestDispatcher("index.jsp").forward(request, response);
                                return;
                        }
                    }
=======
                    request.setAttribute("owningContent", "hostel");
                    request.setAttribute("hostelSlug", splitter[4]);
                    System.out.println(request.getAttribute("hostelSlug"));
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
>>>>>>> ec13895d2b45dc633cde81c974619f3c1a9e779b
                case "view":
                    request.setAttribute("owningContent", "view");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                case "create-hostel":
                    request.setAttribute("owningContent", "createHostel");
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
        String processingPath = (String) request.getAttribute("processingPath");
        String contextPath = request.getContextPath();

        String[] splitter = processingPath.split("/");

        if (splitter.length > 3) {
            request.setAttribute("homeContent", "owning");

            switch (request.getParameter("action")) {
                case "":
                    System.out.println(Colors.YELLOW + "owningController forward to updateProfileServlet" + Colors.RESET);
                    request.getRequestDispatcher("").forward(request, response);
                    return;

                case "c":
                    System.out.println(Colors.YELLOW + "owningController forward to changePasswordServlet" + Colors.RESET);
                    request.getRequestDispatcher("").forward(request, response);
                    return;
                case "createHostel":
                    System.out.println(Colors.YELLOW + "owningController forward to createHostelServlet" + Colors.RESET);
                    request.getRequestDispatcher("createHostelServlet").forward(request, response);
                    return;
            }
        } else {
            response.sendRedirect(contextPath + "/home/owning");
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
