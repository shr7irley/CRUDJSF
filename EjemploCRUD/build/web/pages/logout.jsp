<%-- 
    Document   : logout
    Created on : 3/12/2014, 01:12:17 PM
    Author     : Sena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Sesión</title>
    </head>
    <body>
        <h1>Salir</h1>
        
        <%
         
            HttpSession misesion = request.getSession(false);
            
            if (misesion.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect("login.jsp?msg= redireccion desde logout");

            } else {
                misesion.removeAttribute("usuarioLogueado");
                misesion.invalidate();
                 response.sendRedirect("../index.jsp?msg= Sesion cerrada");
            }
        %>    
        
        
        
    </body>
</html>
