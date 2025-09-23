package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Carrito implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Producto> productos;
	
    /**
     * Constructor vacío para inicializar un carrito vacío.
     */
	
	public Carrito() {
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Constructor para inicializar un carrito con un nombre y una lista de productos.
     */

	public Carrito(String nombre, ArrayList<Producto> productos) {
		super();
		this.nombre = nombre;
		this.productos = productos;
	}
	
    /**
     * Devuelve el nombre del carrito.
     */

	public String getNombre() {
		return nombre;
	}
	
	 /**
     * Configura el nombre del carrito.
     */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
     * Devuelve la lista de productos incluidos en el carrito.
     */

	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
	/**
     * Configura la lista de productos incluidos en el carrito.
     */
	
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
}
