package co.edu.unbosque.util.persistence;

public class TextoVacioException extends Exception {

	public TextoVacioException() {
		super("Algun campo de texto esta vacio");
	}

}
