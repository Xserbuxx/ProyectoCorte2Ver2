package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza para indicar un error relacionado con el código de seguridad.
 */
public class CodigoSeguridadException extends Exception {
	/**
	 * Constructor que crea la excepción de código de seguridad con un mensaje.
	 */
	public CodigoSeguridadException(String message) {
		super(message);
	}
	
}