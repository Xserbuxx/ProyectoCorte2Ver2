package co.edu.unbosque.model;

import java.io.Serializable;

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String contrasena;
	
	/**
	 * Constructor vacío para inicializar un usuario vacío.
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor para inicializar un usuario con su nombre y contraseña.
	 */
	public Usuario(String nombre, String contrasena) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
	}
	
	/**
	 * Devuelve el nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Configura el nombre del usuario.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve la contraseña del usuario.
	 */
	public String getContrasena() {
		return contrasena;
	}
	
	/**
	 * Configura la contraseña del usuario.
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	/**
	 * Devuelve la representación en cadena del usuario.
	 */
	@Override
	public String toString() {
		return nombre + ";" + contrasena;
	}
	
}