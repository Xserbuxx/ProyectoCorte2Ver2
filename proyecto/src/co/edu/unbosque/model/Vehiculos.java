package co.edu.unbosque.model;

public class Vehiculos extends Producto {

	private String Año;
	private String modelo;

	public Vehiculos() {
		// TODO Auto-generated constructor stub
	}

	public Vehiculos(String año, String modelo) {
		super();
		Año = año;
		this.modelo = modelo;
	}

	public Vehiculos(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	public Vehiculos(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			String año, String modelo) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		Año = año;
		this.modelo = modelo;
	}

	public String getAño() {
		return Año;
	}

	public void setAño(String año) {
		Año = año;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return super.toString() + Año + ";" + modelo;
	}

}
