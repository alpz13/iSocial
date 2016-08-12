/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import Controlador.*;
import Modelo.*;
import javax.servlet.RequestDispatcher;
import lib.*;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "c_insertarLugar", urlPatterns = {"/c_insertarLugar"})
public class c_insertarLugar extends HttpServlet {

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
            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            String descripcion = request.getParameter("descripcion");
            String tipo = request.getParameter("tipo");
            String url = request.getParameter("url");
            c_Lugares insertar = new c_Lugares();
            int tipo2 = Integer.parseInt(tipo);
            m_Lugar lugar = new m_Lugar(0, nombre, direccion, descripcion, tipo2, url);
            
            if(insertar.insertarLugares(lugar)) {
                String calificar = request.getParameter("Registrar");
                m_Lugar lugarAnterior = insertar.getLugarUnico(nombre);
                System.out.println("Nombre:"+nombre);
                //Es el mismo metodo de c_cargaCalificar
                
                String direction = "";
                int promedio;
                String cal0;
                try {
                    if(calificar.equals("Registrar lugar"))
                    {
                        System.out.println("Lugar anterior: "+lugarAnterior.getId());
                        String idlugar = lugarAnterior.getId()+"";
                        System.out.println(idlugar);
                        db_CargaCalificar calilugar = new db_CargaCalificar();   
                        Collection comentarios = calilugar.getComentarios(Integer.parseInt(idlugar));
                        m_CaliProm prom = calilugar.getCalificacion(Integer.parseInt(idlugar));          

                        direction = "/v_LugarCalifComen.jsp";
                        
                        if(prom.getCalificacion() == 0 || prom.getContador() == 0) {
                            cal0 = "Calificación no disponible";
                            request.setAttribute("lugar", lugarAnterior);
                            request.setAttribute("comentarios", comentarios);
                            request.setAttribute("promedio", cal0);
                        } else {
                            if(lugarAnterior != null && comentarios != null)
                            {
                                promedio = prom.getCalificacion()/prom.getContador();
                                request.setAttribute("lugar", lugarAnterior);
                                request.setAttribute("comentarios", comentarios);
                                request.setAttribute("promedio", promedio);
                            }
                        }

                        RequestDispatcher dispatcher = request.getRequestDispatcher(direction);
                        dispatcher.forward(request, response);
                    }
                }
                finally{
                    out.close();

                }
                
                //*****************************
                
                
            } else {
                out.println("Ocurió un error");
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
