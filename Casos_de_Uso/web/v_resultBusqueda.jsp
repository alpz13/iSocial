
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados</title>
    </head>
    <body>
        <div>
            <jsp:useBean id="db" class="lugares.c_Lugares" />
            <table>
                <c:forEach items="${db.Lugar}" var="contact"> 
                            <tr>
                                <td><c:out value="${contact.name}" /></td>
                                <td><c:out value="${contact.lastnames}" /></td>
                                <td>${contact.telephone}</td>
                            </tr>
                </c:forEach>   
            </table>             
        </div>
    </body>
</html>
