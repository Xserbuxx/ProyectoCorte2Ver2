package co.edu.unbosque.model;

import java.util.ArrayList;

public class Carrito {
	private String nombre;
	private ArrayList<Producto> productos;
	
	public Carrito() {
		// TODO Auto-generated constructor stub
	}

	public Carrito(String nombre, ArrayList<Producto> productos) {
		super();
		this.nombre = nombre;
		this.productos = productos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
}
