/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaExcepcion;

import java.sql.SQLException;

/**
 *
 * @author alex
 */
public class BDException extends Exception{
    public BDException(String error, SQLException sqle){
        super(error);
    }
    
}
