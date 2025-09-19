package co.edu.unbosque.util.persistence;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LanzadorExcepciones {

	public static void verificarNombre(String nombre, String error1, String error2, String error3) throws NombreException {
		if (nombre == null || nombre.isEmpty()) {
			throw new NombreException(error1);
		}

		if (nombre.contains(" ")) {
			throw new NombreException(error2);
		}

		String contenido = "^[a-zA-Z0-9]+$";

		if (!nombre.matches(contenido)) {
			throw new NombreException(error3);
		}
	}

	public static void verificarContrasena(String contrasena, String mensaje) throws ContrasenaException {
		if (contrasena == null || contrasena.isEmpty()) {
			throw new ContrasenaException(mensaje);

		}
	}

	public static void verificarIDExistente(int id, ArrayList<Integer> ids, String mensaje) throws IDExistenteException {
		for (Integer idTemp : ids) {
			if (idTemp == id) {
				throw new IDExistenteException(mensaje);
			}
		}
	}

	public static void verificarNumeroNegativo(int numero, String mensaje) throws NumeroNegativoException {
		if (numero < 0) {
			throw new NumeroNegativoException(mensaje);
		}
	}

	public static void verificarNumeroNegativo(double numero, String mensaje) throws NumeroNegativoException {
		if (numero < 0) {
			throw new NumeroNegativoException(mensaje);
		}
	}

	public static void verificarTextoVacio(String texto, String mensaje) throws TextoVacioException {
		if (texto == null || texto.isEmpty()) {
			throw new TextoVacioException(mensaje);
		}
	}

	public static void verificarNumeroTarjeta(String numeroTarjeta, String error1, String error2, String error3) throws NumeroTarjetaException {
		if (numeroTarjeta == null || numeroTarjeta.isEmpty()) {
			throw new NumeroTarjetaException(error1);
		}
		
		String contenido = "^[0-9]+$";

		if (!numeroTarjeta.matches(contenido)) {
			throw new NumeroTarjetaException(error2);
		} 	
		
		if (numeroTarjeta.length() != 16) {
			throw new NumeroTarjetaException(error3);
		}

	}
	
	public static void verificarFechaVencimiento(String fechaVencimiento, String error1, String error2) throws FechaVencimientoException {
		if (fechaVencimiento == null || fechaVencimiento.isEmpty()) {
			throw new FechaVencimientoException(error1);
		}
		
		String contenido = "^(0[1-9]|1[0-2])/(\\d{2})$";

		if (!fechaVencimiento.matches(contenido)) {
			throw new FechaVencimientoException(error2);
		}
	}
	
	public static void verificarCodigoSeguridad(String codigoSeguridad, String error1, String error2, String error3) throws CodigoSeguridadException {
		if (codigoSeguridad == null || codigoSeguridad.isEmpty()) {
			throw new CodigoSeguridadException(error1);
		}
		
		String contenido = "^[0-9]+$";

		if (!codigoSeguridad.matches(contenido)) {
			throw new CodigoSeguridadException(error2);
		} 	
		
		if (codigoSeguridad.length() != 3) {
			throw new CodigoSeguridadException(error3);
		}

	}
	
	public static void verificarFechaVencimientoBelleza(String fecha, String error1, String error2) throws FechaVencimientoException {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		if (fecha == null || fecha.isEmpty()) {
			throw new FechaVencimientoException(error1);
		}
		
		try {
			LocalDate f = LocalDate.parse(fecha, formato);;
		} catch (Exception e) {
			throw new FechaVencimientoException(error2);
		}
		
	}
	
	public static void verificarUnidadesDisponibles(int unidades, String mensaje) throws UnidadesProductoException{
		if (unidades <= 0) {
			throw new UnidadesProductoException(mensaje);
		}
	}
	
	public static void verificarFormatoFoto(String nombreArchivo, String exceptionvacio, String formatoinvalido) throws FormatoFotoException {
		if (nombreArchivo == null || nombreArchivo.isEmpty()) {
			throw new FormatoFotoException(exceptionvacio);
		}

		if (!nombreArchivo.endsWith(".jpg") && !nombreArchivo.endsWith(".png") && !nombreArchivo.endsWith(".jpeg")) {
			throw new FormatoFotoException(formatoinvalido);
		} 	
		
	}
}
