package entidades;

public class Personaje {
	
	private String codigo;
	private String nombre;
	private double vida;
	private double energia;
	private int defensa;
	private int evasion;
	private int ptosTotales;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
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
}
