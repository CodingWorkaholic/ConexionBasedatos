
package capaPersistencia;

import capaExcepcion.BDException;
import capaLogica.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class guardarPersona {
    // [acá van las consultas MySQL, cómo atributos privados]
    //[Acá van las clases propias de Java que prepara los datos, para guardarlos]
    //[Creamos el método para guardar el objeto]
    //[Cerrar la conexión]
    //esta es la capa intermediaria
    
    private static final String SQLguardar=("INSERT INTO persona.Persona(CI, Nombre, Apellido)Values (?,?,?)");
    public Conexion cone=new Conexion();
    public PreparedStatement ps; //prepara los datos
    public ResultSet rs; //muestra los datos
    private ResultSet resultado; 
    
    public void guardarPersona(Persona per) throws Exception,BDException {
    try{
        int resultado=0; //variable que guarda la conexión
        Connection con= cone.getConnection(); //Me conecto
        ps=(PreparedStatement)con.prepareStatement(SQLguardar); //"con" es la variable en la cual se guarda la conexión
        
        ps.setString(1,per.getCi());
        ps.setString(2,per.getNombre());
        ps.setString(3,per.getApellido());
        
       resultado=ps.executeUpdate();
    }   catch (SQLException sqle) {
        throw new Exception("Error en base de datos");
            
        }
}
    
}
