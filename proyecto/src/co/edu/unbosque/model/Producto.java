package co.edu.unbosque.model;

import java.io.Serializable;

public class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private String rutaFoto;
	private int id;
	private int unidades;
	private double precio;
	
	/**
	 * Constructor vacío para inicializar un producto vacío.
	 */
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor para inicializar un producto con todos sus atributos.
	 */
	public Producto(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rutaFoto = rutaFoto;
		this.id = id;
		this.unidades = unidades;
		this.precio = precio;
	}
	
	/**
	 * Devuelve el nombre del producto.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Configura el nombre del producto.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve la descripción del producto.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Configura la descripción del producto.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Devuelve la ruta de la foto del producto.
	 */
	public String getRutaFoto() {
		return rutaFoto;
	}
	
	/**
	 * Configura la ruta de la foto del producto.
	 */
	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}
	
	/**
	 * Devuelve el identificador del producto.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Configura el identificador del producto.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Devuelve las unidades disponibles del producto.
	 */
	public int getUnidades() {
		return unidades;
	}
	
	/**
	 * Configura las unidades disponibles del producto.
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	/**
	 * Devuelve el precio del producto.
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * Configura el precio del producto.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/**
	 * Devuelve la representación en cadena del producto.
	 */
	@Override
	public String toString() {
		return nombre+";"+descripcion+";"+rutaFoto+";"+id+";"+unidades+";"+precio+";";
	}
	
}