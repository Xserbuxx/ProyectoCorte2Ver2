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
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rutaFoto = rutaFoto;
		this.id = id;
		this.unidades = unidades;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return nombre+";"+descripcion+";"+rutaFoto+";"+id+";"+unidades+";"+precio+";";
	}
	
}
