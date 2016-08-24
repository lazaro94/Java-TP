package logica;

import java.util.ArrayList;

import datos.CatalogoPersonajes;
import entidades.Personaje;

public class ControladorPersonaje {

	private CatalogoPersonajes cp = new CatalogoPersonajes();
	
	public void altaPersonaje(Personaje per) throws Exception{
		
		try{
			cp.guardarPersonaje(per);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public void modificarPersonaje(Personaje per){
		
	}
	
	public ArrayList<Personaje> todosPersonajes() throws Exception{
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		try{
			personajes=cp.getPersonajes();
		}
		catch(Exception ex){
			throw ex;
		}
		return personajes;
	}
}
