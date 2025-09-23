package co.edu.unbosque.util.exception;

/**
 * Excepción que indica que el número de tarjeta proporcionado es inválido.
 */
public class NumeroTarjetaException extends Exception {
	
	public NumeroTarjetaException(String mensaje) {
		super(mensaje);
	}
	
}