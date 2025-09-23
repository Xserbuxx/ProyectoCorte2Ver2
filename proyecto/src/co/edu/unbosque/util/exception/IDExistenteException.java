package co.edu.unbosque.util.exception;

/**
 * Excepción que indica que un identificador ya existe en la colección.
 */
public class IDExistenteException extends Exception {
	/**
	 * Crea la excepción con un mensaje descriptivo.
	 */
	public IDExistenteException(String mensaje) {
		super(mensaje);
	}
}
