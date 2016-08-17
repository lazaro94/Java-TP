package entidades;

import java.util.UUID;

public class Personaje {
	
	private UUID codigo; //La clase UUID crea identificadores únicos.
	private String nombre; //Tiene que ser unico!
	private double vida;
	private double energia;
	private int defensa;
	private int evasion;
	private int ptosTotales;
	
	public Personaje(){
		
	}
	public Personaje(String nombre, int defensa, int evasion, int ptosTotales, double vida, double energia){
		this.nombre=nombre;
		this.defensa=defensa;
		this.evasion=evasion;
		this.ptosTotales=ptosTotales;
		this.vida=vida;
		this.energia=energia;
	}
	public UUID getCodigo() {
		return codigo;
	}
	public void setCodigo(UUID codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getVida() {
		return vida;
	}
	public void setVida(double vida) {
		this.vida = vida;
	}
	public double getEnergia() {
		return energia;
	}
	public void setEnergia(double energia) {
		this.energia = energia;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}
	public int getPtosTotales() {
		return ptosTotales;
	}
	public void setPtosTotales(int ptosTotales) {
		this.ptosTotales = ptosTotales;
	}
	
	public void generarIdentificador(){
	    this.codigo = UUID.randomUUID();
	}
}
