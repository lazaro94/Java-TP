package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.Personaje;
import util.AppException;

public class CatalogoPersonajes {
	
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

		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		String query = "SELECT * FROM Personajes";
		
		try{			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(query);
			rs = stmt.executeQuery();
			while(rs!=null && rs.next()){
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
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				FactoryConexion.getInstancia().releaseConn();
			} 
			catch(SQLException sqlex){
				throw sqlex;
			}
			catch (Exception ex) {
				throw ex;
			}
		}
		return personajes;
	}
	
	public void modificarPersonaje(Personaje per) throws Exception{
		PreparedStatement stmt = null;
		
		String query ="UPDATE Personajes SET Nombre='" + per.getNombre() + "', Defensa='" + per.getDefensa() + "', Energia='" + per.getEnergia() + "', Evasion='" + per.getEvasion() +
	    "', Puntos='"  +	per.getPtosTotales() + "', Vida='" + per.getVida() + "' WHERE Personajes.IdPersonaje=" + per.getCodigo();// De donde trae el codigo ese? No entender yo
		
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(query);
			stmt.executeUpdate();
		}		
		catch(SQLException sqlex){
			throw sqlex;
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				FactoryConexion.getInstancia().releaseConn();
			}
			catch(SQLException sqlex){
				throw sqlex;
			}
			catch (Exception ex) {
				// TODO Auto-generated catch block
				throw ex;
			}
		}
	}
	
	public Personaje getByNombre(Personaje p) throws Exception{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM Personajes WHERE Nombre=?";
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(query);
			stmt.setString(1, p.getNombre());
			rs=stmt.executeQuery();
			if(rs.next()){
				p.setCodigo(rs.getInt("idPersonaje"));
				p.setDefensa(rs.getInt("Defensa"));
				p.setEnergia(rs.getDouble("Energia"));
				p.setEvasion(rs.getInt("Evasion"));
				p.setPtosTotales(rs.getInt("Puntos"));
				p.setVida(rs.getDouble("Vida"));
			}
		}
		catch(SQLException sqlex){
			throw sqlex;
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				FactoryConexion.getInstancia().releaseConn();
			}
			catch(SQLException sqlex){
				throw sqlex;
			}
			catch (Exception ex) {
				throw ex;
			}
		}
		return p;
	}
	
	public void setPuntos(Personaje p) throws Exception{
		PreparedStatement stmt = null;
		String query = "UPDATE Personajes SET Puntos=? WHERE idPersonaje=?";
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(query);
			stmt.setInt(1, p.getPtosTotales());
			stmt.setInt(2, p.getCodigo());
			stmt.executeUpdate();
		}
		catch(SQLException sqlex){
			throw sqlex;
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				FactoryConexion.getInstancia().releaseConn();
			}
			catch(SQLException sqlex){
				throw sqlex;
			}
			catch (Exception ex) {
				throw ex;
			}
		}
	}
}
