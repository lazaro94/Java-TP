package datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Personaje;

public class CatalogoPersonajes {

	private Conexion con = new Conexion();
	
	public void guardarPersonaje(Personaje per){		
		Connection conn = null; 
		try{
			String query="INSERT INTO Personajes VALUES('" + per.getCodigo() + "', '" + per.getNombre() +"', '" + Integer.toString(per.getDefensa()) + 
			"', '" + Integer.toString(per.getEvasion()) + "', '" + Double.toString(per.getEnergia()) + "', '" + Double.toString(per.getVida()) + "', '" + Integer.toString(per.getPtosTotales()) + "')" ;
			conn=con.conectar();
			Statement stmt = conn.createStatement();
			stmt.executeQuery(query); 
		}
		catch(SQLException sqlex){
			
		}
		catch(Exception ex){
			
		}
		
		
	}
}
