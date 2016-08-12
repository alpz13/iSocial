/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lib.*;

/**
 *
 * @author alex
 */
@WebServlet(name = "c_LugarCalifComen", urlPatterns = {"/CalificarComentar"})
public class c_LugarCalifComen extends HttpServlet {

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
        HttpSession session = request.getSession();
        String idsesion = session.getAttribute("id")+"";
        try  
        {
            String operation = request.getParameter("Comentar");
            
            if(operation.equals("Enviar"))
            {
                System.out.println("Entro a equals Enviar");
                //String usuario = request.getParameter("");
                String idlugar = request.getParameter("idLugar");
                System.out.println(idlugar);
                String texto = request.getParameter("txtArea");
                String calificacion = request.getParameter("DropCalificacion"); 
                System.out.println(texto);
                m_InsertaComentarios comentarios = new m_InsertaComentarios(Integer.parseInt(idsesion),Integer.parseInt(idlugar),Integer.parseInt(calificacion),texto);
                db_Comentarios comentariosdb = new db_Comentarios();
                if(comentariosdb.insertaComentarios(comentarios))
                {
                    System.out.println("Entro primer if");
                    System.out.println("Se ha insertado su comentario");
                    
                    //Otra vez aqui
                    c_Lugares buscar = new c_Lugares();
                    int id = Integer.parseInt(idlugar);
                    m_Lugar lugarAgain = buscar.getLugarUnicoId(id);
                    System.out.println(lugarAgain.getId());
                    System.out.println(lugarAgain.getNombre());
                    
                    int promedio;
                    String cal0;
                    String direction;
                    
                    db_CargaCalificar calilugar = new db_CargaCalificar();   
                    Collection allComentarios = calilugar.getComentarios(Integer.parseInt(idlugar));
                    m_CaliProm prom = calilugar.getCalificacion(Integer.parseInt(idlugar));    
                    
                     direction = "/v_LugarCalifComen.jsp";
                     System.out.println("La direccion es:" + direction);
                     if(prom.getCalificacion() == 0 || prom.getContador() == 0) {
                            cal0 = "Calificación no disponible";
                            System.out.println(cal0);
                            request.setAttribute("lugar", lugarAgain);
                            request.setAttribute("comentarios", allComentarios);
                            request.setAttribute("promedio", cal0);
                        } else {
                            if(lugarAgain != null && allComentarios != null)
                            {
                                System.out.println("Paso todos los if");
                                promedio = prom.getCalificacion()/prom.getContador();
                                request.setAttribute("lugar", lugarAgain);
                                request.setAttribute("comentarios", allComentarios);
                                request.setAttribute("promedio", promedio);
                            }
                        }
                     
                    RequestDispatcher dispatcher = request.getRequestDispatcher(direction);
                    dispatcher.forward(request, response);
                    
                    //****
                    
                }else{
                    System.out.println("No se pudo insertar su comentario");
                }      
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
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
