package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;
import java.io.*;

public final class up_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<title>Subidor Devtroce</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<form action=up.jsp method=post enctype=multipart/form-data>\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t<td>Fichero</td>\n");
      out.write("\t\t\t<td><input type=file name=fichero></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr><td colspan=2><input type=submit value=enviar name=enviar>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t</form>\n");
      out.write(" \n");
      out.write("\t<!-- codigo para subir el fichero al servidor-->\n");
      out.write("\t");

		//Ruta donde se guardara el fichero
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
	
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
