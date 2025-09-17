package co.edu.unbosque.util.persistence;

public class NombreException extends Exception {
	
	public NombreException() {
		super("El nombre ingresado no es valido, intente de nuevo");
	}
	
	public NombreException(String mensaje) {
		super(mensaje);
	}
	
}
