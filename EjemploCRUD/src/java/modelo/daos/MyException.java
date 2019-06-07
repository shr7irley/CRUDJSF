/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.daos;

/**
 *
 * @author myException
 * @author Rodrigo Aranda Fernandez
 */
public class MyException extends Exception{
    private static final long serialVersionUID = 1L;

    public MyException(String msg){
        super(msg);
    }
}
