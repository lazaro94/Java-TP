package logica;

import java.util.ArrayList;

import datos.CatalogoPersonajes;
import entidades.Personaje;

public class ControladorPersonaje {

	private CatalogoPersonajes cp = new CatalogoPersonajes();
	public void modificarPersonaje(Personaje per) throws Exception{
		
		try{
			if(per.getCodigo()>0){
				cp.modificarPersonaje(per);
			}
			else {
				cp.agregarPersonaje(per);
			}
		}
		catch(Exception ex){
			throw ex;
		}

		
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
