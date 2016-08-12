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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import Modelo.*;
import java.util.*;
import lib.*;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author nx3
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
        String direction = "";
        HttpSession session = request.getSession();
        String nom, pas;
        
        db_Usuario consusuario = new db_Usuario();
        db_Lugar lugar = new db_Lugar();
        Collection top5 = lugar.getTop5();
        Collection tipos = lugar.getTipos();
        
        Collection top5comida,top5bebida,top5entretenimiento;
        top5comida = lugar.getTop5TiposComida();
        top5bebida = lugar.getTop5TiposBebida();
        top5entretenimiento = lugar.getTop5TiposEntretenimiento();
        
        nom = request.getParameter("username");
        pas = request.getParameter("pwd1");
        
        if(nom != null || pas != null) {
            session.setAttribute("nom", request.getParameter("username"));  
            session.setAttribute("pas", request.getParameter("pwd1"));  
            System.out.println(nom+"   "+pas);
            System.out.println("Paso el normal");
        } else {
            System.out.println("Entro catch");
            nom = session.getAttribute("nom")+"";
            pas = session.getAttribute("pas")+""; 
            System.out.println(nom+"   "+pas);
        }
        
        System.out.println("hola que hace");
        m_Usuario usuario = new m_Usuario(0,nom,pas,"");
        
        
        System.out.println("Despues de los top5");
        //****
        
        if(consusuario.validate(usuario))
        {
            System.out.println("Entro en el if");
            request.setAttribute("top5", top5);
            request.setAttribute("tipos", tipos);
            request.setAttribute("usuario", usuario);
            
            
            if(top5comida.size() > 0) {
                request.setAttribute("top5comida", top5comida);
                System.out.println("comida no es null");
            }
            if(top5bebida.size() > 0) {
                request.setAttribute("top5bebida", top5bebida);
                System.out.println("bebida no es null");
            }
            if(top5entretenimiento.size() > 0) {
                request.setAttribute("top5entretenimiento", top5entretenimiento);
                System.out.println("entre no es null");
            }
//            
            direction = "welcome.jsp";
            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher(direction);
                dispatcher.forward(request, response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }       

        else{  
            System.out.println("Entro en el else");
            direction = "loginPage.jsp";
            out.print("<p style=\"color:red\">Sorry username or password error</p>");  
            RequestDispatcher dispatcher =request.getRequestDispatcher(direction);  
            dispatcher.forward(request, response);
        }       

        out.close();  
    } 

    }
