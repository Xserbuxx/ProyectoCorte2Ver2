package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando el formato del archivo de imagen no es válido.
 */
public class FormatoFotoException extends Exception {
	
	public FormatoFotoException(String mensaje) {
		super(mensaje);
	}
	
}