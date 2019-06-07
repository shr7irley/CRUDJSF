/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.daos;

import Dtos.ProfesorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Conectar;
import utilidades.MiExcepcion;

/**
 *
 * @author ProfesorDAO
 * @author Rodrigo Aranda Fernandez
 */
public class ProfesorDAO {

    PreparedStatement pstmt = null;
    Connection cnn = null;
    ResultSet rs = null;

    public ProfesorDAO() {
        cnn = Conectar.getInstance();
    }

    /**
     * Este metodo permite insertar un nuevo registro profesor en la base de
     * datos
     *
     * @param newProfesor Un objeto que contiene los atributos de la entidad
     * Profesor
     * @return una cadena de confirmación de la acción realizada
     */
    public String crearProfesor(ProfesorDTO newProfesor) throws MiExcepcion {
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("INSERT INTO profesores VALUES (null, ?, ?, ?,?)");
            pstmt.setString(1, newProfesor.getNombreCompleto());
            pstmt.setString(2, newProfesor.getCorreoElectronico());
            pstmt.setString(3, newProfesor.getUserName());
            pstmt.setInt(4, newProfesor.getClaveProfesor());
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "El usuario ha sido registrado exitosamente. " + resultado + "filas afectadas";
            } else {
                // salida = "Ha ocurrido un problema al crear el profesor. Contacte al administrador";
                throw new MiExcepcion("ha ocurrido un problema");
            }
        } catch (SQLException sqle) {
            salida = "Ocurrió la siguiente exception : " + sqle.getMessage();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }
public String actualizarProfesor(ProfesorDTO newProfesor) throws MiExcepcion {
        String salida = "";
        try {

            int resultado = 0;
            pstmt = cnn.prepareStatement("UPDATE profesores SET nombre=? ,correoElectronico=?, user=?  WHERE id=?");
            pstmt.setString(1, newProfesor.getNombreCompleto());
            pstmt.setString(2, newProfesor.getCorreoElectronico());
            pstmt.setString(3, newProfesor.getUserName());
            pstmt.setInt(4, newProfesor.getClaveProfesor());
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "El usuario ha sido actualizado exitosamente.";
            } else {
                // salida = "Ha ocurrido un problema al crear el profesor. Contacte al administrador";
                throw new MiExcepcion("ha ocurrido un problema");
            }
        } catch (SQLException sqle) {
            salida = "Ocurrió la siguiente exception : " + sqle.getMessage();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex); // se deja por defecto en este caso
            }
        }

        return salida;

    }
    /**
     * Este método permite listar los profesores disponibles en la tabla
     *
     */
    public List<ProfesorDTO> getAll() throws MyException, SQLException {
        LinkedList<ProfesorDTO> listaProfes = new LinkedList<ProfesorDTO>();
        try {


            String query = "SELECT  id, nombre, correoElectronico, user "
                    + " FROM profesores ";
            pstmt = cnn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ProfesorDTO newProfe = new ProfesorDTO();
                newProfe.setClaveProfesor(rs.getInt("id"));
                newProfe.setNombreCompleto(rs.getString("nombre"));
                newProfe.setCorreoElectronico(rs.getString("correoElectronico"));
                newProfe.setUserName(rs.getString("user"));
                listaProfes.add(newProfe);
            }
        } catch (SQLException ex) {
            throw new MyException("Error al listar los elementos " + ex.getSQLState() + " - " + ex.getMessage());
        } finally {
            pstmt.close();
        }

        return listaProfes;
    }
public ProfesorDTO listarUno(int id) {
         ProfesorDTO Profesor = new ProfesorDTO();
         
        try {
             String query ="SELECT nombre,correoElectronico,user from profesores WHERE id=?";
            pstmt = cnn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Profesor.setNombreCompleto(rs.getString("nombre"));
                Profesor.setCorreoElectronico(rs.getString("correoElectronico"));
                 Profesor.setUserName(rs.getString("user"));
            }
        } catch (SQLException ex) {
            System.out.println("Error de sql "+ex.getMessage());;
        }
        return Profesor;
    }
    public ProfesorDTO validarUsuario(String login, String pass) throws MyException {
        ProfesorDTO pdto = new ProfesorDTO();
        try {

            pstmt = cnn.prepareStatement("SELECT id, nombre "
                    + " FROM profesores WHERE user = ? AND clave  = ?;");
            pstmt.setString(1, login);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    pdto.setClaveProfesor(rs.getInt("id"));
                    pdto.setNombreCompleto(rs.getString("nombre"));
                }
            } else {
                pdto = null;
            }
            return pdto;
        } catch (SQLException ex) {
            throw new MyException(" Datos errones. Revise!");
        }

    }

    public String eliminarPersona(int clave_profesor) {

        String salida = "";
        try {
            int resul = 0;
            pstmt = cnn.prepareStatement("DELETE FROM profesores WHERE id=?");
            pstmt.setInt(1, clave_profesor);
            resul = pstmt.executeUpdate();

            if (resul != 0) {
                salida = "Proceso Exitoso " + resul + " Registro Eliminado";
            } else {
                salida = "No se eliminaron Registros";
            }

        } catch (SQLException sqle) {
            System.out.println("Error de My SQL" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return salida;
    }

    /**
     * Con este método se valida la existencia de un nombre de usuario
     *
     * @param userName el nombre de usuario que se desea verificar
     * @return El resultado de la validación : disponible o no disponible
     */
    public StringBuilder validarUserName(String userName) throws MyException {

        StringBuilder salida = new StringBuilder("");
        try {

            pstmt = cnn.prepareStatement("SELECT id, nombre, user FROM profesores WHERE user=?");
            pstmt.setString(1, userName);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                salida.append("El username '").append(userName).append("' ya se encuentra registrado!");
            } else {
                salida.append("Username Disponible");
            }

        } catch (SQLException sqle) {
            throw new MyException("Error de My SQL" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return salida;
    }
}
