package entidades;

import java.util.Random;

public class Personaje {
	//Tanto el codigo como el nombre deben controlarse con un �ndice UNIQUE en la BD.
	private int codigo; // Usamos AI desde la BD Requerimiento del TP.
	private String nombre; //Tiene que ser unico! --> Requerimiento
	private double vida;
	private double energia;
	private int defensa;
	private int evasion;
	private int ptosTotales;
	private double vidaBatalla;
	private double energiaBatalla;
	
	public Personaje(int codigo, String nombre, int defensa, int evasion, int ptosTotales, double vida, double energia){
		this.codigo=codigo;
		this.nombre=nombre;
		this.defensa=defensa;
		this.evasion=evasion;
		this.ptosTotales=ptosTotales;
		this.vida=vida;
		this.energia=energia;	
	}
	
	public double getVidaBatalla() {
		return vidaBatalla;
	}

	public void setVidaBatalla(double vidaBatalla) {
		this.vidaBatalla = vidaBatalla;
	}

	public double getEnergiaBatalla() {
		return energiaBatalla;
	}

	public void setEnergiaBatalla(double energiaBatalla) {
		this.energiaBatalla = energiaBatalla;
	}

	public Personaje(){
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
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
	
	public void atacar(){
		
	}
	
	public boolean evadeAtaque(){
		Random r = new Random();
		if (r.nextDouble()*100<this.defensa){
			return false;
		} else {
			return true;
		}		
	}
	
	//Uso este override para agregar personajes a los combobox
	@Override
	public String toString(){
		return (this.getNombre());
	}
	
	@Override
	public boolean equals(Object per){
		return per instanceof Personaje && ((Personaje)per).getNombre() == this.getNombre();
	}
}
