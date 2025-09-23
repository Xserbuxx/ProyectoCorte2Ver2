package co.edu.unbosque.util.exception;

/**
 * Excepción que indica que un texto está vacío o es nulo.
 */
public class TextoVacioException extends Exception {

	public TextoVacioException(String mensaje) {
		super(mensaje);
	}

}