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
	private int turno;

	public int generarTurno(){
		Random r = new Random();
		
		if(r.nextFloat()>0.5){
			turno=1;
			return turno;
		}
		else{
			turno=2;
			return turno;
		}
			
	}
	
	public int getTurnoActual(){
		if(turno==1){
			turno=2;
			return turno;
		}
		else{
			return(turno=1);
		}
	}
	
	public void setPersonaje(String nombre) throws Exception{
		
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

	public void ataque(int energia) throws AppException{		
		switch(turno){
		case 1:
			if(!personaje2.evadeAtaque()){
				personaje2.setVidaBatalla(personaje2.getVidaBatalla()-energia);
			}
			personaje1.setEnergiaBatalla(personaje1.getEnergiaBatalla()-energia);
			break;
		case 2:
			if(!personaje1.evadeAtaque()){
				personaje1.setVidaBatalla(personaje1.getVidaBatalla()-energia);
			}
			personaje2.setEnergiaBatalla(personaje2.getEnergiaBatalla()-energia);
		}
	}
	
	public void defensa(){
		
	}
}
