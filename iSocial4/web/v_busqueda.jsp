<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controlador.*" %>
<%@page import="Modelo.*" %>
<%@page import="lib.*" %>
<%@page language="java" import="javazoom.upload.*" %>
<%@page language="java" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%
    String direccion = request.getSession().getServletContext().getRealPath("/subirImagenes/images/");
%>


<jsp:useBean id="upBean" scope="page" class="javazoom.upload.UploadBean" >
    <jsp:setProperty name="upBean" property="folderstore" value="<%=direccion%>" />
    <jsp:setProperty name="upBean" property="whitelist" value="*.jpg,*.gif" />
    <jsp:setProperty name="upBean" property="overwritepolicy" value="nametimestamp"/>
</jsp:useBean>

<%
    if (MultipartFormDataRequest.isMultipartFormData(request)) {
        MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
        String todo = null;
        if (mrequest != null) {
            todo = mrequest.getParameter("todo");
        }
        if ((todo != null) && (todo.equalsIgnoreCase("upload"))) {
            Hashtable files = mrequest.getFiles();
            if ((files != null) && (!files.isEmpty())) {
                String archivo = ((UploadFile) mrequest.getFiles().get("uploadfile")).getFileName();
                int posicionPunto = archivo.indexOf(".");
                String nombreImagen = archivo.substring(0, posicionPunto);
                String extension = archivo.substring(posicionPunto);
                nombreImagen = nombreImagen + extension;
                ((UploadFile) mrequest.getFiles().get("uploadfile")).setFileName(nombreImagen);
                UploadFile file = (UploadFile) files.get("uploadfile");
                
                //Sube la imagen usando el Bean
                upBean.store(mrequest, "uploadfile");

                db_Lugar lugar = new db_Lugar();
                Collection tipos = lugar.getTipos();
                request.setAttribute("tipo", tipos);
                String nombreLugar = mrequest.getParameter("nombreLugar");
                m_Lugar aux = new m_Lugar(0, nombreLugar, "", "", 0, "");
                request.setAttribute("nombreLugar", aux);
                request.setAttribute("url", "subirImagenes/images/"+file.getFileName());
                session.setAttribute("url2", "subirImagenes/images/"+file.getFileName());
            } else {
              out.println("Archivos no subidos");
            }
        } else {
          out.println("<br/> todo=" + todo);
        }
    }
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />



<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="styles/stylesDivs.css"/>

</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="#">iSocial</a></h1>
		</div>
		<div id="menu">
			<ul>
				<li>
                                    <form method="POST" action="LoginServlet" id="myForm" >
                                        <input class="botonTrans" type="submit" value="Inicio"/>
                                    </form>
                                </li>
				<li><a class="activo" href="loginPage.jsp" accesskey="2" title="">Login</a></li>
				<li><a class="activo" href="v_contrato.jsp" accesskey="3" title="">About</a></li>
                                <li><a class="activo" href="v_casosUso.jsp" accesskey="4" title="">Casos</a></li>
                                <li><a class="activo" href="v_busqueda.jsp" accesskey="5" title="">Buscar</a></li>
                                <li>
                                    <form action="Logout.jsp" method="post">
                                            <input class="botonTrans" type="submit" value="Logout" />
                                        </form>
                                </li>
			</ul>
			<p>&nbsp;</p>
		</div>
	</div>
</div>
<div id="featured-wrapper">
	<div id="featured" class="container">
		<div class="box box1"><img src="images/pic02.jpg" alt="" /></div>
		<div class="box box2"><img src="images/pic03.jpg" alt="" /></div>
		<div class="box box3"><img src="images/pic04.jpg" alt="" /></div>
		<div class="box box4"><img src="images/pic05.jpg" alt="" /></div>
		<div class="box box5"><img src="images/pic06.jpg" alt="" /></div>
		<div class="box box6"><img src="images/pic07.jpg" alt="" /></div>
	</div>
</div>
<div id="page" class="container">
	
        <br/><br/>
        <div class="centralTable">
            <form action='c_BuscarLugar' method='POST'>
                <label>Nombre del lugar: </label><input type='text' size='25' name='busqueda' />
                <input class="button" type='submit' name='Buscar' value='Buscar'/>
            </form>
        </div>
        <br/>
        <c:choose>
            <c:when test="${lugar != null}">
                <div class="CSSTableGenerator">
                    <h3>Buscas alguno de estos lugares?</h3>
                    <br/>
                    
                    <table>
                        <tr>
                            <td></td>
                            <td>Nombre</td>
                            <td>Dirección</td>
                            <td>Descripción</td>
                        </tr>
                        <c:forEach items="${lugar}" var="lugar"> 
                            <tr>
                                <td>
                                    <form action ='c_CargaCalificar' method='POST'>
                                    <input type='hidden' name='idLugar' value='${lugar.id}'/>
                                    <input class="button" type='submit' name='Calificar' value='Calificar'/>
                                    </form>
                                </td>
                                <td>${lugar.nombre}</td>
                                <td>${lugar.direccion}</td>
                                <td>${lugar.descripcion}</td>
                            </tr>
                        </c:forEach> 
                    </table>
                    <br/>
                    <h3>No es ninguno de ellos? Agrega un nuevo lugar!</h3>
                    <form action="c_BuscarLugar" method="POST">
                        <input class="button" type="submit" value="Nuevo" name="Nuevo"/>
                    </form>
                </div>
            </c:when>
            <c:when test="${tipo != null}">
                <div>
                    <div class="centralTable">
                        <h3>Agregar un nuevo lugar</h3>
                    </div>
                    <br/>
                    <c:if test="${url == null}">
                        <form method="POST" action="v_busqueda.jsp" name="upform" enctype="multipart/form-data" class="tablaCentral">
                            <table >
                                <tr>
                                    <td>Archivo:</td>
                                    <td><input type="file" name="uploadfile" /></td>
                                    <td>
                                        <input type="hidden" name="todo" value="upload" />
                                        <input type='hidden' name='nombreLugar' value='${nombreLugar.nombre}'/>
                                        <input class="button" type="submit" value="Agregar"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </c:if>
                    <form action='c_insertarLugar' method='POST' class="tablaCentral">
                        <c:if test="${url != null}">
                            <img class="fotoUrl" src="<%=session.getAttribute("url2")%>" alt="<%=session.getAttribute("url2")%>"/>
                            <input type="hidden" name="url" value="<%=session.getAttribute("url2")%>"/>
                            <br/>
                        </c:if>
                        <c:if test="${url == null}">
                            <input type="hidden" name="url" value=""/>
                        </c:if>
                            <table>
                                <tr>
                                    <td><label>Nombre del lugar: </label></td>
                                    <td><input type='text' name='nombre' size='40' value='${nombreLugar.nombre}'/></td>
                                </tr>
                                <tr>
                                    <td><label>Dirección: </label></td>
                                    <td><input type='text' name='direccion'  size='40'/></td>
                                </tr>
                                <tr>
                                    <td><label>Descripción: </label></td>
                                    <td><textarea name='descripcion'  rows="10" cols='32'></textarea></td>
                                </tr>
                                <tr>
                                    <td><label>Tipo: </label></td>
                                    <td>
                                        <select name='tipo'>
                                            <c:forEach items="${tipo}" var="tipo">
                                                <option value='${tipo.id}'>${tipo.tipo}</option>
                                            </c:forEach>
                                      </select>
                                    </td>
                                </tr>
                            </table>
                        <input class="button" type='submit' name="Registrar" value='Registrar lugar'/>
                    </form>
                </div>
            </c:when>
        </c:choose>

	
</div>
<div id="footer-wrapper">
</div>
<div id="copyright" class="container">
	<p>Copyright (c) 2013 isocial.com. All rights reserved. | Photos by the 
	whole world.</p>
</div>
</body>
</html>

