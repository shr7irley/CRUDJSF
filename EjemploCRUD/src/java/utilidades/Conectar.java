package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    protected static Connection conexion = null;

    private static void conectar() {
        try {
         
            Class.forName("com.mysql.jdbc.Driver"); 
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root",""); 
        } catch (SQLException e) {  
          System.out.println("Error de MySQL: " + e.getMessage()); 
        }  catch (Exception e) {
          System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    private Conectar() {
        
    }

    public static Connection getInstance() {
        if (conexion == null) {
            conectar();
        }
        return conexion;
    }
    
    
}
