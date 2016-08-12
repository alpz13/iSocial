<%-- 
    Document   : Logout
    Created on : Apr 9, 2014, 6:53:01 PM
    Author     : nx3
--%>

<%
session.setAttribute("userid", null);
session.setAttribute("name", null);
session.invalidate();
response.sendRedirect("index.html");
%>