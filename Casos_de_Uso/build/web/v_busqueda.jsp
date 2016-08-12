<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lugares.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Búsqueda de lugares</title>
    </head>
    <body>
        <div>
            <form action='c_BuscarLugar' method='POST'>
                <input type='text' size='25' name='busqueda' placeholder="Nombre del lugar"/>
                <input type='submit' name='Buscar' value='Buscar'/>
            </form>
        </div>
        <br/>
        <c:choose>
            <c:when test="${lugar != null}">
                <div>
                    <label>Buscas alguno de estos lugares?</label>
                    <br/>
                    <table>
                        <c:forEach items="${lugar}" var="lugar"> 
                            <tr>
                                <td>
                                    <input type='hidden' name='idLugar' value='${lugar.id}'/>
                                    <input type='button' value='Calificar'/>
                                </td>
                                <td>${lugar.nombre}</td>
                                <td>${lugar.direccion}</td>
                                <td>${lugar.descripcion}</td>
                            </tr>
                        </c:forEach> 
                    </table>
                </div>
            </c:when>
            <c:when test="${tipo != null}">
                <div>
                    <label>Agregar un nuevo lugar</label>
                    <br/>
                    <form action='c_insertarLugar' method='POST'>
                        <input type='text' name='nombre' placeholder="Nombre" size='40' value='${nombreLugar.nombre}'/><br/>
                        <input type='text' name='direccion' placeholder="Dirección" size='40'/><br/>
                        <textarea name='descripcion' placeholder="Descripción" rows="10" cols='32'/></textarea>
                        <br/>
                        <select name='tipo'>
                            <c:forEach items="${tipo}" var="tipo">
                                <option value='${tipo.id}'>${tipo.tipo}</option>
                            </c:forEach>
                        </select>
                        <br/>
                        <input type='text' name='url' placeholder="Url" size='40'/><br/><br/>
                        <input type='submit' value='Registrar lugar'/>
                    </form>
                </div>
            </c:when>
        </c:choose>
    </body>
</html>
