package co.edu.unbosque.util.exception;

/**
 * Excepción que indica un error con la contraseña proporcionada.
 */
public class ContrasenaException extends Exception{
	
	public ContrasenaException(String mensaje) {
		super(mensaje);
	}
	
}