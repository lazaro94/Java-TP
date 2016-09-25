package logica;

import java.util.Random;

import entidades.Personaje;
import util.AppException;

public class ControladorBatallas {


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
