package co.edu.unbosque.util.exception;

/**
 * Excepción que indica un error relacionado con el nombre proporcionado.
 */
public class NombreException extends Exception {
	
	public NombreException(String mensaje) {
		super(mensaje);
	}
	
}