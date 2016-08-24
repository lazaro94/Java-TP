package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entidades.Personaje;

public class CatalogoPersonajes {

	//CORREGIR ORDEN DE LOS DATOS EN EL QUERY CON LAS COLUMNAS DE LA BD.
	//MANEJO DE EXCEPCIONES.
	//TODOS LOS VALORES QUE NO SON STRING HAY QUE CONVERTIRLOS.
	//METODO GENERICO PARA EJECUTAR LOS QUERY.
	
	private Conexion con = new Conexion();
	
	public void guardarPersonaje(Personaje per) throws Exception{		
		Connection conn = null; 
		try{
			String query="INSERT INTO Personajes (Nombre, Defensa, Energia, Evasion, Vida, Puntos) VALUES('" + per.getNombre() +"', '" + Integer.toString(per.getDefensa()) + 
			"', '" + Integer.toString(per.getEvasion()) + "', '" + Double.toString(per.getEnergia()) + "', '" + Double.toString(per.getVida()) + "', '" + Integer.toString(per.getPtosTotales()) + "')" ;
			conn=con.conectar();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.close();
		}
		catch(SQLException sqlex){
			throw sqlex;
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public ArrayList<Personaje> getPersonajes() throws Exception{		
		Connection conn = null;
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		String query = "SELECT * FROM Personajes";
		
		try{			
			conn=con.conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Personaje per = new Personaje(rs.getInt("IdPersonaje"), rs.getString("Nombre"), rs.getInt("Defensa"), rs.getInt("Evasion"), rs.getInt("Puntos"), rs.getDouble("Vida"), rs.getDouble("Energia"));
				personajes.add(per);
			}			
		}
		catch(SQLException sqlex){
			throw sqlex;
		}
		catch(Exception ex){
			throw ex;
		}
		return personajes;
	}
	
	public void modificarPersonaje(Personaje per) throws Exception{
		
		Connection conn = null;
		//Cuando esté la BD armada definitivamente --> ORDENAR el query. (aca no va por ej: codigo= per.gertcodigo(), nombre= per.getNombre()??) 
		String query ="UPDATE Personajes SET( Nombre=" + per.getNombre() + ", Defensa" + per.getDefensa() + ", Energia=" + per.getEnergia() + ", Evasion=" + per.getEvasion() +
	    ", Puntos="  +	per.getPtosTotales() + ", Vida=" + per.getVida() + ") WHERE Personaje.IdPersonaje=" + per.getCodigo();// De donde trae el codigo ese? No entender yo
		
		try{
			conn=con.conectar();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.close();
		}		
		catch(SQLException sqlex){
			throw sqlex;
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public void agregarPersonaje(Personaje per) throws Exception{
		Connection conn = null;
		String query = "INSERT INTO Personajes (Nombre, Defensa, Energia, Evasion, Vida, Puntos) VALUES(" + per.getNombre() + ", " + per.getDefensa() + ", " +per.getEnergia() + ", " + per.getEvasion() + ", " +
		per.getVida() + ", " + per.getPtosTotales() + ") "; 
		
		try{
			conn=con.conectar();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.close();
		}
		catch(SQLException sqlex){
			throw sqlex;
		}
		catch(Exception ex){
			throw ex;
		}
	}
}
