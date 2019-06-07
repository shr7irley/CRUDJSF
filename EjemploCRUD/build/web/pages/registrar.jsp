
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- De estra forma se incluye una hoja de estilos. Tener presente la ruta donde se 
        encuentra respecto de la carpeta web pages-->        
        <link rel="stylesheet" href="css/mystyle.css" type="css/txt" >
        <SCRIPT language="JavaScript" src="js/ValidaUsuario.js"></SCRIPT>
          <title>Inicio</title>
   
         </head>
    
</html>
<body onload="focusIn();">
        <!-- 
        Para este ejemplo se usa Java EE 6 Web y servidor GalssFish 3.1.1
        Iniciamos con una inserción de un nuevo profesor, para la cual su user sera
        las iniciales del nombre
        -->
        <% 
          HttpSession miSesion = request.getSession(false);
          if  (miSesion.getAttribute("usuarioLogueado") == null){
              response.sendRedirect("index.jsp");
          }else {%>
          
        <h3>Registro de un nuevo profesor</h3>

        <form name="registroprofe" action="../Controlador" method="POST">
            <div>
            <label for="txtUserName">Usuario</label>
            <input type="text" name="txtUserName" id="txtUserName" value="" size="10" />
            </div>
            <br>
            <div>
            <label for="txtNombre">Nombre completo</label>
            <input type="text" name="txtNombre" id="txtNombre" value="" size="40" required="true"/>
            </div><br>
            <div><label for="txtCorreo">Correo Electrónico</label>
            <input type="text" name="txtCorreo" id="txtCorreo" value="" size="40" required="true"/>
            </div><br>
            <div>
            <label for="txtClave">Clave</label>
            <input type="password" name="txtClave" id="txtClave" value="" size="40" required="true"/>
            </div> <br>
            <div><input type="hidden" name="rProfesor" id="rProfesor" value="" />
            <input type="submit" value="Registrar" name="btnRegistrarProfe" id="btnRegistrarProfe"/>
            </div><br>
        </form>

        <%
            if (request.getParameter("msg") != null) {

        %>
        <div class="confirmarOK"><%=request.getParameter("msg")%></div>        

        <%
            }
            // si es null el objeto, es decir, no se ha creado aun, no mostramos nada
            
          } 
        %>
        
    </body>
