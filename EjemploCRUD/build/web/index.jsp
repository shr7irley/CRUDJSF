<%-- 
    Document   : index
    Created on : 03-nov-2014, 9:16:38
    Author     : admin
--%>


      


<%-- 
    Document   : login
    Created on : 3/12/2014, 01:11:48 PM
    Author     : Sena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Acceso a Bases de Datos desde Java WEB</title>
   
        <link rel="stylesheet" type="text/css" href="../css/mystyle.css">
    </head>
    <body>
        
        <h3>Bienvenidos</h3>
        
        <fieldset>
            <form name="" action="Controlador" method="POST"
                  <label for="btnRegistro"></label>
                <input type="submit" values="registrarse" name="btnRegistrarse"/>
                <label for="btnIngreso"<></label>
                <input type="submit" values="Ingreso" name="btnIngreso"/>
                          
            </form>
            
        </fieldset>
      
                <%
                    if(request.getParameter("msg")!= null){
                        out.print(request.getParameter("msg"));
                        
                    }
                %>
                
            </div>
                
                <hr>
                
                
                
                
    </body>
</html>