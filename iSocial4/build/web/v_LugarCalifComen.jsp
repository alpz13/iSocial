<%-- 
    Document   : v_LugarCalifComen
    Created on : 3/04/2014, 06:36:36 PM
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controlador.*" %>
<%@page import="Modelo.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />



<title>Comenta lugar</title>
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
	
    <div class="centralTable">
        <h1>${lugar.nombre}</h1>
    </div>

        <div class="tablaCentral">
            <h3>Calificacion ${promedio}</h3>
            <br/><br/>
            <label>Comentarios</label>
            <br/>
            <table>
                <c:forEach items="${comentarios}" var="comentarios">
                    <tr>
                        <td><strong>${comentarios.usuario}</strong></td>
                        <td>${comentarios.comentario}</td>
                        <td>&nbsp;&nbsp;&nbsp;<strong>${comentarios.calificacion}</strong></td>
                    </tr>
                </c:forEach>
           </table>
        </div>
            <br/><br/>
        <div align="left">
            <form name="CalifComent" action="CalificarComentar" method="POST" class="tablaCentral">
                 <input type='hidden' name='idLugar' value='${lugar.id}'/>
                <table>
                    <tr>
                        <td>Usuario: <%=session.getAttribute("nom")%>
                            &nbsp;&nbsp;&nbsp;
                            Calificacion
                            <select id="DropCalificacion" name="DropCalificacion">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                        </td>
                        <td> 
                            
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <textarea name="txtArea" rows="10" cols="40"></textarea>
                        </td>
                    </tr>
                </table>
                <input class="button" type="submit" value="Enviar" name="Comentar"/>
          </form>
     </div>

	
</div>
<div id="footer-wrapper">
</div>
<div id="copyright" class="container">
	<p>Copyright (c) 2013 isocial.com. All rights reserved. | Photos by the 
	whole world.</p>
</div>
</body>
</html>
