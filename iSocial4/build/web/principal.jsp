<%-- 
    Document   : principal
    Created on : 1/04/2014, 11:48:34 AM
    Author     : Miguel
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="#">iSocial</a></h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="welcome.jsp" accesskey="1" title="">Inicio</a></li>
				<li><a href="loginPage.jsp" accesskey="2" title="">Login</a></li>
				<li><a href="v_contrato.jsp" accesskey="3" title="">About</a></li>
                                <li><a href="v_casosUso.jsp" accesskey="4" title="">Casos</a></li>
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
	
<h1>Hello World!</h1>
        <jsp:useBean id="db" class="lib.db_Usuario"/>
        <table>
            <c:forEach items="${db.usuario}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.idUsuario}"/></td>
                    <td><c:out value="${usuario.usuario}"/></td>
                    <td><c:out value="${usuario.contrasena}"/></td>
                    <td><c:out value="${usuario.correo}"/></td>
        <td>Hla</td>
                </tr>                
            </c:forEach>           
        </table>

	
</div>
<div id="footer-wrapper">
</div>
<div id="copyright" class="container">
	<p>Copyright (c) 2013 isocial.com. All rights reserved. | Photos by the 
	whole world.</p>
</div>
</body>
</html>
