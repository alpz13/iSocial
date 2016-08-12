/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lib.*;

/**
 *
 * @author nx3
 */
@WebServlet(name = "registeruser", urlPatterns = {"/registeruser"})
public class registeruser extends HttpServlet {

 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */   
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

public void doPost(HttpServletRequest request, HttpServletResponse response)
                                 throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();String direction = "";
    try{
      
      String operation = request.getParameter("crearcuenta");
      if(operation.equals("Crear Cuenta"))
      {
            String Username = request.getParameter("username");
            String Pwd = request.getParameter("pwd1");
            String Email = request.getParameter("email");
            System.out.println(Email);
            m_RegistraUsuario usuario = new m_RegistraUsuario(Username,Pwd,Email);
            db_RegistraUsuario registrauser = new db_RegistraUsuario();
            if(registrauser.insertaUsuario(usuario))
            {
                 System.out.println("Se ha insertado su Usuario");
                 request.setAttribute("usuario", usuario);
                 direction="/regsuccess.jsp";
                 RequestDispatcher dispatcher = request.getRequestDispatcher(direction);
                 dispatcher.forward(request, response);                 
            }else{
                PrintWriter out = response.getWriter();  
                response.setContentType("text/html");  
                System.out.println("No se pudo instertar su Usuario");
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Lo sentimos "+Username+ ",pero la cuenta no se pudo crear.);");  
                out.println("</script>");
            }      
          
      }
      
    }
    catch (ServletException | IOException e){
      pw.println(e.getMessage());
    }
    catch (Exception e){
      pw.println(e);
    }
  }
}