<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lugares.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <div>
            <table>
                <c:forEach items="${lugar}" var="lugar"> 
                    <tr>
                        <td>${lugar.nombre}</td>
                        <td>${lugar.direccion}</td>
                        <td>${lugar.descripcion}</td>
                    </tr>
                </c:forEach> 
            </table>
        </div>
    </body>
</html>
