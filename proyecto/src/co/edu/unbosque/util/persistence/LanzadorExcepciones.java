package co.edu.unbosque.util.persistence;

import java.util.ArrayList;

public class LanzadorExcepciones {

	public static void verificarNombre(String nombre) throws NombreException {
		if(nombre == null || nombre.isEmpty()) {
			throw new NombreException("El nombre no puede estar vacio");
		}
		
		if(nombre.contains(" ")) {
			throw new NombreException("El nombre no puede contener espacios");
		}
		
		String contenido = "^[a-zA-Z0-9]+$";
		
		if(!nombre.matches(contenido)) {
			throw new NombreException("El nombre solo puede contener letras y numeros");
		}
	}

	public static void verificarContrasena(String contrasena) throws ContrasenaException {
		if (contrasena == null || contrasena.isEmpty()) {
			throw new ContrasenaException();

		}
	}
	
	public static void verificarIDExistente(int id, ArrayList<Integer> ids) throws IDExistenteException {
		for (Integer idTemp : ids) {
			if(idTemp == id) {
				throw new IDExistenteException();
			}
		}
	}
	
	public static void verificarNumeroNegativo(int numero) throws NumeroNegativoException {
		if(numero < 0) {
			throw new NumeroNegativoException();
		}
	}
	
	public static void verificarNumeroNegativo(double numero) throws NumeroNegativoException {
		if(numero < 0) {
			throw new NumeroNegativoException();
		}
	}
	
	public static void verificarTextoVacio(String texto) throws TextoVacioException {
		if(texto == null || texto.isEmpty()) {
			throw new TextoVacioException();
		}
	}
}
