package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registrar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <!-- De estra forma se incluye una hoja de estilos. Tener presente la ruta donde se \n");
      out.write("        encuentra respecto de la carpeta web pages-->        \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/mystyle.css\" type=\"css/txt\" >\n");
      out.write("        <SCRIPT language=\"JavaScript\" src=\"js/ValidaUsuario.js\"></SCRIPT>\n");
      out.write("          <title>Inicio</title>\n");
      out.write("   \n");
      out.write("         </head>\n");
      out.write("    \n");
      out.write("</html>\n");
      out.write("<body onload=\"focusIn();\">\n");
      out.write("        <!-- \n");
      out.write("        Para este ejemplo se usa Java EE 6 Web y servidor GalssFish 3.1.1\n");
      out.write("        Iniciamos con una inserción de un nuevo profesor, para la cual su user sera\n");
      out.write("        las iniciales del nombre\n");
      out.write("        -->\n");
      out.write("        ");
 
          HttpSession miSesion = request.getSession(false);
          if  (miSesion.getAttribute("usuarioLogueado") == null){
              response.sendRedirect("index.jsp");
          }else {
      out.write("\n");
      out.write("          \n");
      out.write("        <h3>Registro de un nuevo profesor</h3>\n");
      out.write("\n");
      out.write("        <form name=\"registroprofe\" action=\"../Controlador\" method=\"POST\">\n");
      out.write("            <div>\n");
      out.write("            <label for=\"txtUserName\">Usuario</label>\n");
      out.write("            <input type=\"text\" name=\"txtUserName\" id=\"txtUserName\" value=\"\" size=\"10\" />\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <div>\n");
      out.write("            <label for=\"txtNombre\">Nombre completo</label>\n");
      out.write("            <input type=\"text\" name=\"txtNombre\" id=\"txtNombre\" value=\"\" size=\"40\" required=\"true\"/>\n");
      out.write("            </div><br>\n");
      out.write("            <div><label for=\"txtCorreo\">Correo Electrónico</label>\n");
      out.write("            <input type=\"text\" name=\"txtCorreo\" id=\"txtCorreo\" value=\"\" size=\"40\" required=\"true\"/>\n");
      out.write("            </div><br>\n");
      out.write("            <div>\n");
      out.write("            <label for=\"txtClave\">Clave</label>\n");
      out.write("            <input type=\"password\" name=\"txtClave\" id=\"txtClave\" value=\"\" size=\"40\" required=\"true\"/>\n");
      out.write("            </div> <br>\n");
      out.write("            <div><input type=\"hidden\" name=\"rProfesor\" id=\"rProfesor\" value=\"\" />\n");
      out.write("            <input type=\"submit\" value=\"Registrar\" name=\"btnRegistrarProfe\" id=\"btnRegistrarProfe\"/>\n");
      out.write("            </div><br>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

            if (request.getParameter("msg") != null) {

        
      out.write("\n");
      out.write("        <div class=\"confirmarOK\">");
      out.print(request.getParameter("msg"));
      out.write("</div>        \n");
      out.write("\n");
      out.write("        ");

            }
            // si es null el objeto, es decir, no se ha creado aun, no mostramos nada
            
          } 
        
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
