package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.Personaje;
import util.AppException;

public class CatalogoPersonajes {

	//CORREGIR ORDEN DE LOS DATOS EN EL QUERY CON LAS COLUMNAS DE LA BD.
	//MANEJO DE EXCEPCIONES.
	//TODOS LOS VALORES QUE NO SON STRING HAY QUE CONVERTIRLOS.
	//METODO GENERICO PARA EJECUTAR LOS QUERY.
	
	public void agregarPersonaje(Personaje per) throws Exception{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try{
			String query="INSERT INTO Personajes (Nombre, Defensa, Energia, Evasion, Vida, Puntos) VALUES('" + per.getNombre() +"', '" + Integer.toString(per.getDefensa()) + 
			"', '" + Integer.toString(per.getEvasion()) + "', '" + Double.toString(per.getEnergia()) + "', '" + Double.toString(per.getVida()) + "', '" + Integer.toString(per.getPtosTotales()) + "')" ;
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(query);
			stmt.execute();
		}
		catch(SQLException sqlex){
			throw sqlex;
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} 
			catch (AppException appex) {
				appex.printStackTrace();
			}
			catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
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
		String query ="UPDATE Personajes SET Nombre='" + per.getNombre() + "', Defensa='" + per.getDefensa() + "', Energia='" + per.getEnergia() + "', Evasion='" + per.getEvasion() +
	    "', Puntos='"  +	per.getPtosTotales() + "', Vida='" + per.getVida() + "' WHERE Personajes.IdPersonaje=" + per.getCodigo();// De donde trae el codigo ese? No entender yo
		
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
