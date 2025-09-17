package co.edu.unbosque.util.persistence;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LanzadorExcepciones {

	public static void verificarNombre(String nombre) throws NombreException {
		if (nombre == null || nombre.isEmpty()) {
			throw new NombreException("El nombre no puede estar vacio");
		}

		if (nombre.contains(" ")) {
			throw new NombreException("El nombre no puede contener espacios");
		}

		String contenido = "^[a-zA-Z0-9]+$";

		if (!nombre.matches(contenido)) {
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
			if (idTemp == id) {
				throw new IDExistenteException();
			}
		}
	}

	public static void verificarNumeroNegativo(int numero) throws NumeroNegativoException {
		if (numero < 0) {
			throw new NumeroNegativoException();
		}
	}

	public static void verificarNumeroNegativo(double numero) throws NumeroNegativoException {
		if (numero < 0) {
			throw new NumeroNegativoException();
		}
	}

	public static void verificarTextoVacio(String texto) throws TextoVacioException {
		if (texto == null || texto.isEmpty()) {
			throw new TextoVacioException();
		}
	}

	public static void verificarNumeroTarjeta(String numeroTarjeta) throws NumeroTarjetaException {
		if (numeroTarjeta == null || numeroTarjeta.isEmpty()) {
			throw new NumeroTarjetaException("El numero de tarjeta no puede estar vacio");
		}
		
		String contenido = "^[0-9]+$";

		if (!numeroTarjeta.matches(contenido)) {
			throw new NumeroTarjetaException("El numero de tarjeta solo puede contener numeros");
		} 	
		
		if (numeroTarjeta.length() != 16) {
			throw new NumeroTarjetaException("El numero de tarjeta debe tener 16 digitos");
		}

	}
	
	public static void verificarFechaVencimiento(String fechaVencimiento) throws FechaVencimientoException {
		if (fechaVencimiento == null || fechaVencimiento.isEmpty()) {
			throw new FechaVencimientoException("La fecha de vencimiento no puede estar vacia");
		}
		
		String contenido = "^(0[1-9]|1[0-2])/(\\d{2})$";

		if (!fechaVencimiento.matches(contenido)) {
			throw new FechaVencimientoException("La fecha de vencimiento debe tener el formato MM/AA");
		}
	}
	
	public static void verificarCodigoSeguridad(String codigoSeguridad) throws CodigoSeguridadException {
		if (codigoSeguridad == null || codigoSeguridad.isEmpty()) {
			throw new CodigoSeguridadException("El codigo de seguridad no puede estar vacio");
		}
		
		String contenido = "^[0-9]+$";

		if (!codigoSeguridad.matches(contenido)) {
			throw new CodigoSeguridadException("El codigo de seguridad solo puede contener numeros");
		} 	
		
		if (codigoSeguridad.length() != 3) {
			throw new CodigoSeguridadException("El codigo de seguridad debe tener 3 digitos");
		}

	}
	
	public static void verificarFechaVencimientoBelleza(String fecha) throws FechaVencimientoException {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		if (fecha == null || fecha.isEmpty()) {
			throw new FechaVencimientoException("La fecha de vencimiento no puede estar vacia");
		}
		
		try {
			LocalDate f = LocalDate.parse(fecha, formato);;
		} catch (Exception e) {
			throw new FechaVencimientoException("La fecha de vencimiento debe tener el formato dd/MM/yyyy");
		}
		
	}
}
