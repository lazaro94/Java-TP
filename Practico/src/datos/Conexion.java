package datos;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	private Connection con = null;
	
	public Connection conectar() throws Exception{
		String cadena = "jdbc:mysql://localhost/javadb";
        try{
        	Class.forName("com.mysql.jdbc.Driver");         
            con = DriverManager.getConnection(cadena,"root","root");
        }catch(Exception ex){
            throw ex;
        }
        return con;
	}
}
