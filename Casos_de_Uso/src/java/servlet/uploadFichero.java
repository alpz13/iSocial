/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "uploadFichero", urlPatterns = {"/uploadFichero"})
public class uploadFichero extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, FileUploadException, Exception {
        File  destino = new File ("C:\\Devtroce\\Uploads\\");
		ServletRequestContext src = new ServletRequestContext(request);
 
		if(ServletFileUpload.isMultipartContent(src)){
			DiskFileItemFactory factory = new DiskFileItemFactory((1024*1024),destino);
			ServletFileUpload upload = new  ServletFileUpload(factory);
 
			java.util.List  lista = upload.parseRequest(src);
			File  file = null;
			java.util.Iterator  it = lista.iterator();
 
			while(it.hasNext()){
				FileItem item=(FileItem)it.next();
				if(item.isFormField())
					out.println(item.getFieldName()+"<br>");
				else
				{
					file=new File (item.getName());
					item.write(new File (destino,file.getName()));
					out.println("Fichero subido");
				} // end if
			} // end while
		} // end if
    }

    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(uploadFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}