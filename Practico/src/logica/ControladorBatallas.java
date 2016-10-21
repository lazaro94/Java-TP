package logica;

import java.sql.SQLException;
import java.util.Random;

import datos.CatalogoPersonajes;
import entidades.Personaje;
import util.AppException;

public class ControladorBatallas {
	
	private CatalogoPersonajes cp;
	private Personaje personaje1 = new Personaje();
	private Personaje personaje2 = new Personaje();
	
	public int generarTurno(){
		Random r = new Random();
		if(r.nextFloat()<0.5){
			return 1;
		}
		else {
			return 2;
		}
	}

	public void setPersonaje1(String nombre) throws Exception{
		
		cp = new CatalogoPersonajes();
		Personaje p = new Personaje();
		p.setNombre(nombre);
		try{
			personaje1=cp.getByNombre(p);			
		}
		catch(SQLException sqlex){
			throw sqlex;
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public void setPersonaje2(String nombre) throws Exception{
		
		cp = new CatalogoPersonajes();
		Personaje p = new Personaje();
		p.setNombre(nombre);
		try{
			personaje2=cp.getByNombre(p);			
		}
		catch(SQLException sqlex){
			throw sqlex;
		}
		catch(Exception ex){
			throw ex;
		}
	}

	public void ataque(Personaje atacante, Personaje atacado, int energia) throws AppException{
		Random r = new Random();
		
		if(atacante.getEnergia()<energia) {
			throw new AppException("La energ�a a utilizar es mayor a la disponible");
		}
		
		if (atacado.evadeAtaque()){
			//EVADE EL ATAQUE
		}
		else {
			//RECIBE EL ATAQUE
		}
		atacante.setEnergia((atacante.getEnergia()-energia));
	}
	
	public void defensa(){
		
	}
}
