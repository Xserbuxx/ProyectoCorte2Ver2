package co.edu.unbosque.util.exception;

/**
 * Excepción que indica que se proporcionó un número negativo cuando no estaba permitido.
 */
public class NumeroNegativoException extends Exception {		public NumeroNegativoException(String mensaje) {		super(mensaje);	}
}