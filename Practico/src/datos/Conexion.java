package datos;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	private Connection con = null;
	
	public Connection conectar() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String cadena = "jdbc:mysql://localhost/";//+nombre_BD;
            con = DriverManager.getConnection("localhost");//Si la bd esta protegida con usr y psw hay que usar una
            //sobrecarga del metodo con usuario y contraseña
        }catch(Exception ex){
            throw ex;
        }
        return con;
	}
}
