<%-- 
    Document   : v_casosUso
    Created on : 11/04/2014, 12:34:10 AM
    Author     : Miguel
--%>

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
				<li><a class="activo" href="loginPage.jsp" accesskey="1" title="">Login</a></li>
				<li><a class="activo" href="v_contrato.jsp" accesskey="2" title="">About</a></li>
                                <li><a class="activo" href="v_casosUso.jsp" accesskey="3" title="">Casos</a></li>
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
	
<div class="CSSTableGenerator">
            <table>
                <tr>
                    <td>Caso de uso</td>
                    <td>Descripción</td>
                </tr>
                <tr>
                    <td>Iniciar Sesión</td>
                    <td>
                        El usuario es capaz de iniciar sesión con su usuario y password correspondientes. Se valida 
                        que la contraseña contenga al menos un número y una letra mayúscula. Si es incorrecto muestra 
                        error.
                    </td>
                </tr>
                <tr>
                    <td>Cerrar sesión</td>
                    <td>
                        El usuario es capaz de cerrar su sesión. En cuanto esto ocurre, las variables de sesión se borran 
                        y se regresa a la página de loggin.
                    </td>
                </tr>
                <tr>
                    <td>Registrar usuario</td>
                    <td>
                        Se puede registrar a un nuevo usuario, dando un nombre de usuario y una contraseña, así como un 
                        correo electrónico. Una vez dado de alta puede iniciar sesión con sus datos.
                    </td>
                </tr>
                <tr>
                    <td>Consultar mejores lugares</td>
                    <td>
                        El usuario es capaz de ver los lugares con las mejores calificaciones, ordenados de mayor a 
                        menor y con un límite de 5 lugares por consulta. 
                        Los Top se dividen en: Top5(general), Top5(Comida), Top5(Bebidas), Top5(Entretenimiento).
                    </td>
                </tr>
                <tr>
                    <td>Buscar Lugares</td>
                    <td>
                        El usuario es capaz de buscar lugares en base a palabras clave. Al momento de buscar, se mostrarán 
                        los lugares con un nombre similar al introducido en la forma.
                    </td>
                </tr>
                <tr>
                    <td>Verificar si lugar existe</td>
                    <td>
                        Durante la opción de búsqueda se mostrarán dos posibles resultados. Si el lugar existe o existen 
                        lugares con un nombre similar, se mostrarán los posibles lugares y el usuario podrá elegir entre 
                        calificar y comentar alguno de ellos ó, en caso dado que ninguno de estos lugares sea el deseado, 
                        se podrá agregar un nuevo lugar. Si por el contrario durante la búsqueda no se encuentran lugares 
                        similares, se procederá automáticamente a agregar un nuevo lugar.
                    </td>
                </tr>
                <tr>
                    <td>Calificar lugares</td>
                    <td>
                        Al momento de realizar la búsqueda de un lugar, si este existe podrá aparecer entre los posibles 
                        resultados. El usuario podrá entonces seleccionar la opción de calificar para poder agregar un 
                        comentario acerca del mismo, así como para agregar la calificación correspondiente que le ha dado 
                        para que pueda promediarse junto con las otras.
                    </td>
                </tr>
                <tr>
                    <td>Agregar lugares</td>
                    <td>
                        Durante la búsqueda de un lugar, si el lugar deseado no aparece entre los posibles resultados, 
                        se mostrará la opción de agregar un nuevo lugar. Se podrá subir una foto del lugar nuevo (opcional), 
                        y se pedirán los datos necesarios (nombre, dirección, descripción), y posteriormente se agregará el 
                        nuevo lugar para ser calificado y para poder aparecer en próximas búsquedas.
                    </td>
                </tr>
                <tr>
                    <td>Comentar lugar</td>
                    <td>
                        Durante la calificación del lugar, se podrá agregar un comentario, el cual dependerá del usuario que 
                        se encuentre conectado actualmente. Se agregará el comentario así como la calificación y se mostrarán 
                        todos los comentarios que se han hecho del lugar.
                    </td>
                </tr>
            </table>
        </div>
        <br/>
</div>
<div id="footer-wrapper">
</div>
<div id="copyright" class="container">
	<p>Copyright (c) 2013 isocial.com. All rights reserved. | Photos by the 
	whole world.</p>
</div>
</body>
</html>
