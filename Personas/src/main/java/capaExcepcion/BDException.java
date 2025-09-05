package capaExcepcion;

import java.sql.SQLException;

public class BDException extends Exception{
    public BDException(String error, SQLException sqle){
        super(error);
    }
}
