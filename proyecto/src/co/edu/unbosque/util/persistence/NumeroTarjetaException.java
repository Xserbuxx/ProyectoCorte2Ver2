package co.edu.unbosque.util.persistence;

public class NumeroTarjetaException extends Exception {
	public NumeroTarjetaException() {
		super("Debe ingresar un numero de tarjeta valido");
	}
	
	public NumeroTarjetaException(String mensaje) {
		super(mensaje);
	}
	
}
