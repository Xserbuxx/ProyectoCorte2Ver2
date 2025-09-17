package co.edu.unbosque.util.persistence;

public class IDExistenteException extends Exception {
	
	public IDExistenteException() {
		super("El ID ya existe");
	}

}
