package util;

public class AppException extends Exception{

	//Constructores
	public AppException (){
		super();
	}
	
	public AppException(String mensaje){
		super(mensaje);
	}
	public AppException(String mensaje, Throwable cause){
		super(mensaje,cause);
	}
}
