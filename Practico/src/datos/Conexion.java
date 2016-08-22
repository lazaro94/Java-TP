package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private Connection con = null;
	
	public Connection conectar() throws Exception{
		String cadena = "jdbc:mysql://vps-1039890-x.dattaweb.com/javadb";
        try{
        	Class.forName("com.mysql.jdbc.Driver");         
            con = DriverManager.getConnection(cadena,"prueba","123456");
        }
        
        catch(SQLException sqlex){
        	throw sqlex;
        }
        
        catch(Exception ex){
            throw ex;
        }
        return con;
	}
}
