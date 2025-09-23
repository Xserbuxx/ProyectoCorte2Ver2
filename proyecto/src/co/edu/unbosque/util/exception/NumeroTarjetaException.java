package co.edu.unbosque.util.exception;

public class NumeroTarjetaException extends Exception {
	public NumeroTarjetaException() {
		super("Debe ingresar un numero de tarjeta valido");
	}
	
	public NumeroTarjetaException(String mensaje) {
		super(mensaje);
	}
	
}
