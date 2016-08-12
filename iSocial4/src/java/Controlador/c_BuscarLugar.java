/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import lib.*;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "c_BuscarLugar", urlPatterns = {"/c_BuscarLugar"})
public class c_BuscarLugar extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String direction = "";
        try {
            String buscar = request.getParameter("Buscar");
            if(buscar != null) {
                if(buscar.equals("Buscar")) {
                    String datos = request.getParameter("busqueda");
                    db_Lugar lugar = new db_Lugar();
                    Collection lugares = lugar.getLugar(datos);
                    Collection tipos = lugar.getTipos();
                    direction = "/v_busqueda.jsp";
                    if(lugares != null) {
                        request.setAttribute("lugar", lugares);
                    } else {  
                        m_Lugar aux = new m_Lugar(0, datos, "", "", 0, "");
                        request.setAttribute("nombreLugar", aux);
                        request.setAttribute("tipo", tipos);
                    }
                }
            } else if(request.getParameter("Nuevo") != null) {
                direction = "/v_busqueda.jsp";
                db_Lugar lugar = new db_Lugar();
                Collection tipos = lugar.getTipos();
                m_Lugar aux = new m_Lugar(0, "", "", "", 0, "");
                request.setAttribute("tipo", tipos);
                request.setAttribute("nombreLugar", aux);
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(direction);
            dispatcher.forward(request, response);
        } finally {
            out.close();
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
