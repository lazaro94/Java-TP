package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			conn.close();
		}
		catch(SQLException sqlex){
			
		}
		catch(Exception ex){
			
		}
	}
	
	public ArrayList<Personaje> getPersonajes(){
		Connection conn = null;
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		try{
			String query = "SELECT * FROM Personajes";
			conn=con.conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Personaje per = new Personaje(rs.getString("Nombre"), rs.getInt("Defensa"), rs.getInt("Evasion"), rs.getInt("Puntos"), rs.getDouble("Vida"), rs.getDouble("Energia"));
				personajes.add(per);
			}			
		}
		catch(SQLException sqlex){
			
		}
		catch(Exception ex){
			
		}
		return personajes;
	}
}
