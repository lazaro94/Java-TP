package logica;

import datos.CatalogoPersonajes;
import entidades.Personaje;

public class ControladorAbm {

	private CatalogoPersonajes cp = new CatalogoPersonajes();
	public void altaPersonaje(Personaje per){
		
		cp.guardarPersonaje(per);
	}
	public void modificarPersonaje(Personaje per){
		
	}
}
