
package capaPersistencia;
//url base de datos
//jdbc:mysql://localhost:3306/persona?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]

import capaExcepcion.BDException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class Conexion {
    
    public static Connection getConnection() throws BDException { //el throws es para traer varios errores a la vez
        Connection con= null;
        try{ 
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/persona?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", ""); //root es nombre de usuario y lo otro la contraseña
        }catch(SQLException sqle){
          throw new BDException ("Error de conexion a la base de datos", sqle);
        }
        return con;
    }
    
    
    
}
