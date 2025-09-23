package co.edu.unbosque.util.exception;

/**
 * Excepción que indica que no hay unidades disponibles para un producto.
 */
public class UnidadesProductoException extends Exception {	/**
	 * Crea la excepción con un mensaje describiendo el error.
	 */
	public UnidadesProductoException(String message) {
		super(message);
	}
}