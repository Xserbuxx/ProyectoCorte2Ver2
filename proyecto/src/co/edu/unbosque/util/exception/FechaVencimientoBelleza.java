package co.edu.unbosque.util.exception;

/**
 * Excepción lanzada cuando la fecha de vencimiento para productos de belleza es inválida.
 */
public class FechaVencimientoBelleza extends Exception {
	public FechaVencimientoBelleza(String message) {
		super(message);
	}

}