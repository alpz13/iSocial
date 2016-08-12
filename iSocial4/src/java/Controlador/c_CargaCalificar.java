/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lib.*;
import Controlador.*;
import Modelo.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author alex
 */
@WebServlet(name = "c_CargaCalificar", urlPatterns = {"/c_CargaCalificar"})
public class c_CargaCalificar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String direction = "";
        int promedio;
        String cal0;
        String calificar = request.getParameter("Calificar");
        System.out.println(calificar);
        try {
            if(calificar.equals("Calificar"))
            {
                String nombre = session.getAttribute("nom")+"";
                db_Usuario usuario = new db_Usuario();
                usuario.getUsuarioId(nombre);
                String idlugar = request.getParameter("idLugar");
                db_CargaCalificar calilugar = new db_CargaCalificar();   
                Collection comentarios = calilugar.getComentarios(Integer.parseInt(idlugar));
                m_CaliProm prom = calilugar.getCalificacion(Integer.parseInt(idlugar));          
                c_Lugares insertar = new c_Lugares();
                
                int id = Integer.parseInt(idlugar);
                m_Lugar lugarAnterior = insertar.getLugarUnicoId(id);

                direction = "/v_LugarCalifComen.jsp";

                if(prom.getCalificacion() == 0 || prom.getContador() == 0) {
                    cal0 = "Calificación no disponible";
                    session.setAttribute("id", usuario.getUsuarioId(nombre));
                    request.setAttribute("lugar", lugarAnterior);
                    request.setAttribute("comentarios", comentarios);
                    request.setAttribute("promedio", cal0);
                } else {
                    if(lugarAnterior != null && comentarios != null)
                    {
                        session.setAttribute("id", usuario.getUsuarioId(nombre));
                        promedio = prom.getCalificacion()/prom.getContador();
                        request.setAttribute("lugar", lugarAnterior);
                        request.setAttribute("comentarios", comentarios);
                        request.setAttribute("promedio", promedio);
                    }
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher(direction);
                dispatcher.forward(request, response);
            } else {
                out.println("Ocurió un error");
            }
        }
        finally{
            out.close();

        }

        //*****************************
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
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
