<%-- 
    Document   : welcome
    Created on : Apr 9, 2014, 5:41:13 PM
    Author     : nx3
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="Controlador.*" %>
<%@page import="Modelo.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="javascript/jQuery/jQuery.js"></script>
<script type="text/javascript" src="javascript/js.js"></script>


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
                        <div id="helloUsuario">
                            <h4>Hello,${usuario.usuario}</h4>
                        </div>
                        <br/>
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
	
        <div id="mostrarGeneral">
            <h3>Top 5</h3>
        </div>
        <br/>
        <div id="top5" class="CSSTableGenerator">
            <table>
                <tr>
                    <td></td>
                    <td>Nombre</td>
                    <td>Dirección</td>
                    <td>Descripción</td>
                </tr>
                <c:forEach items="${top5}" var="top5"> 
                    <tr>
                        <td>
                            <form action ='c_CargaCalificar' method='POST'>
                               <input type='hidden' name='idLugar' value='${top5.id_lugar}'/>
                               <input class="button" type='submit' name='Calificar' value='Calificar'/>
                            </form>
                        </td>
                        <td>${top5.nombre}</td>
                        <td>${top5.direccion}</td>
                        <td>${top5.descripcion}</td>
                    </tr>
                </c:forEach> 
           </table>
        </div>
        <br/>
        <div id="mostrarComidas">
            <h3>Comidas</h3>
        </div>
        <br/>
        <div id="topComida" class="CSSTableGenerator">
            <table>
                <tr>
                    <td></td>
                    <td>Nombre</td>
                    <td>Dirección</td>
                    <td>Descripción</td>
                </tr>
                <c:if test="${top5comida != null}" >
                    <c:forEach items="${top5comida}" var="top5comida"> 
                        <tr>
                            <td>
                                <form action ='c_CargaCalificar' method='POST'>
                                   <input type='hidden' name='idLugar' value='${top5comida.id_lugar}'/>
                                   <input class="button" type='submit' name='Calificar' value='Calificar'/>
                                </form>
                            </td>
                            <td>${top5comida.nombre}</td>
                            <td>${top5comida.direccion}</td>
                            <td>${top5comida.descripcion}</td>
                        </tr>
                    </c:forEach> 
                </c:if>
           </table>
        </div>
        <br/>
        <div id="mostrarBebidas">
            <h3>Bebidas</h3>
        </div>
        <br/>
        <div id="topBebida" class="CSSTableGenerator">
            <table>
                <tr>
                    <td></td>
                    <td>Nombre</td>
                    <td>Dirección</td>
                    <td>Descripción</td>
                </tr>
                <c:if test="${top5bebida != null}" >
                    <c:forEach items="${top5bebida}" var="top5bebida"> 
                        <tr>
                            <td>
                                <form action ='c_CargaCalificar' method='POST'>
                                   <input type='hidden' name='idLugar' value='${top5bebida.id_lugar}'/>
                                   <input class="button" type='submit' name='Calificar' value='Calificar'/>
                                </form>
                            </td>
                            <td>${top5bebida.nombre}</td>
                            <td>${top5bebida.direccion}</td>
                            <td>${top5bebida.descripcion}</td>
                        </tr>
                    </c:forEach> 
                </c:if>
           </table>
        </div>
        <br/>
        <div id="mostrarEntretenimiento">
            <h3>Entretenimiento</h3>
        </div>
        <br/>
        <div id="topEntretenimiento" class="CSSTableGenerator">
            <table>
                <tr>
                    <td></td>
                    <td>Nombre</td>
                    <td>Dirección</td>
                    <td>Descripción</td>
                </tr>
                <c:if test="${top5entretenimiento != null}" >
                    <c:forEach items="${top5entretenimiento}" var="top5entretenimiento"> 
                        <tr>
                            <td>
                                <form action ='c_CargaCalificar' method='POST'>
                                   <input type='hidden' name='idLugar' value='${top5entretenimiento.id_lugar}'/>
                                   <input class="button" type='submit' name='Calificar' value='Calificar'/>
                                </form>
                            </td>
                            <td>${top5entretenimiento.nombre}</td>
                            <td>${top5entretenimiento.direccion}</td>
                            <td>${top5entretenimiento.descripcion}</td>
                        </tr>
                    </c:forEach> 
                </c:if>
           </table>
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
