
package capaPersistencia;

import capaExcepcion.BDException;
import capaExcepcion.PersonaExepcion;
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
    private static final String SQL_CONSULTA_PERSONA = ("SELECT * FROM persona.Persona where CI=?");
    private static final String EliminarPersona =("DELETE * FROM persona.Persona where CI=?;");
    public Conexion cone=new Conexion();
    public PreparedStatement ps; //prepara los datos
    public ResultSet rs; //muestra los datos
    private ResultSet resultado; 
    
    public void guardarPersona(Persona pers) throws Exception,BDException {
    try{
        int resultado=0; //variable que guarda la conexión
        Connection con= cone.getConnection(); //Me conecto
        ps=(PreparedStatement)con.prepareStatement(SQLguardar); //"con" es la variable en la cual se guarda la conexión
        
        ps.setString(1,pers.getCi());
        ps.setString(2,pers.getNombre());
        ps.setString(3,pers.getApellido());
        
       resultado=ps.executeUpdate();
       System.out.println(resultado);
    }   catch (SQLException sqle) {
        throw new Exception("Error en base de datos");
            
        }
    }
    /**
     *
     * @param ci
     * @return
     * @throws Exception
     * @throws BDException
     */
    public Persona busquedaCI (String ci) throws Exception, BDException, PersonaExepcion{
        Persona pers= new Persona();
        
        try{
            Connection con;
            con = cone.getConnection();
            ps=(PreparedStatement)con.prepareStatement(SQL_CONSULTA_PERSONA); //"con" es la variable en la cual se guarda la conexión
            ps.setString(1, ci);
            rs = ps.executeQuery();
            
            if (rs.next()){
                
                String Ci= rs.getString("CI");
                String Nombre= rs.getString("Nombre");
                String Apellido= rs.getString("Apellido");
                
                pers.setCi(Ci);
                pers.setNombre(Nombre);
                pers.setApellido(Apellido);
                
            }else{
                throw new PersonaExepcion("La persona no se encuentra en la base de datos");
            }
            con.close();
        
            
        }catch (Exception e){
            System.out.println(e);
            throw new PersonaExepcion("No se puede obtener la persona");
        }
        return pers;
    }
    
    public Persona eliminarPer (String ci) throws Exception, BDException, PersonaExepcion{
       Persona pers=new Persona();
        
       try{
           Connection con;
           con= cone.getConnection();
           ps=(PreparedStatement)con.prepareStatement(EliminarPersona);
           ps.setString(1, ci);
           rs = ps.executeQuery();
       }catch (Exception e){
            System.out.println(e);
            throw new PersonaExepcion("No se puede eliminar la persona");
    }
        return pers;

    }
}
