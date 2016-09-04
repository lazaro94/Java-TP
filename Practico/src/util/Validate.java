package util;

public class Validate {

	//Para validar que no sea un texto vacío
	public boolean notEmpty(String texto){
		if (!texto.equals("") && texto!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean numeroDecimal(String texto){
		if(texto.matches("[0-9]+([,.][0-9]{1,2})?")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean numeroEntero(String texto){
		if(texto.matches("[0-9]*")){
			return true;
		}
		else{
			return false;
		}
	}
}
