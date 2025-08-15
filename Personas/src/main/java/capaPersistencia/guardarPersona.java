
package capaPersistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class guardarPersona {
    // [acá van las consultas MySQL, cómo atributos privados]
    //[Acá van las clases propias de Java que prepara los datos, para guardarlos]
    //[Creamos el método para guardar el objeto]
    //[Cerrar la conexión]
    //esta es la capa intermediaria
    
    private static final String SQLguardar=("INSERT INTO persona.Personas(CI, Nombre, Apellido)Values (?,?,?)");
    public Conexion cone=new Conexion();
    public PreparedStatement ps; //prepara los datos
    public ResultSet rs; //muestra los datos
    
}
