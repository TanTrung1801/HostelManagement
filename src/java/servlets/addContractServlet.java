/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import daos.ContractsDAO;
import daos.RoomsDAO;
import dtos.Contracts;
import dtos.Rooms;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Truong Thanh Trung
 */
@WebServlet(name = "addContractServlet", urlPatterns = {"/addContractServlet"})
public class addContractServlet extends HttpServlet {

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
            RoomsDAO room = new RoomsDAO();
            ContractsDAO con = new ContractsDAO();

            int room_id = Integer.parseInt(request.getParameter("room_id"));
            int client_id = Integer.parseInt(request.getParameter("client_id"));
            double room_price = Double.parseDouble(request.getParameter("room_price"));
            Date start_date = Date.valueOf(request.getParameter("start_date"));
            Date end_date = Date.valueOf(request.getParameter("end_date"));
            double deposit = Double.parseDouble(request.getParameter("deposit"));

            if (room_id != 0 && client_id != 0 && room_price != 0 && start_date != null && end_date != null && deposit != 0) {
                if (!room.getList("room_id", room_id + "").isEmpty()) { // check phòng tồn tại không 
                    if (!con.getList("room_id", room_id + "").isEmpty()) { // kiểm tra xem phòng đó có contracts nào chưa
                        if (room.getOne("room_id", room_id + "").getMax_contract() > con.getListContractsStatus("room_id", room_id + "").size()) { // kiểm tra số Max_contracts của phòng với số con_status=1 của phòng đó 
                            con.add(new Contracts(room_id, client_id, room_price, start_date, end_date, 1, deposit));
                        } else {
                            request.setAttribute("ERROR", "NUMBER OF CONSTRACTS > MAX_CONTRACTS");
                        }
                    } else {
                        con.add(new Contracts(room_id, client_id, room_price, start_date, end_date, 1, deposit));
                    }
                } else {
                    request.setAttribute("ERROR", "Can't find the room");
                }
            } else {
                request.setAttribute("ERROR", "Please enter all the required fields");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
