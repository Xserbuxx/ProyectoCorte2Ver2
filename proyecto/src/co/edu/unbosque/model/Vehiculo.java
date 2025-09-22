package co.edu.unbosque.model;

public class Vehiculo extends Producto {

	private int anio;
	private String modelo;

	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}

	public Vehiculo(int anio, String modelo) {
		super();
		this.anio = anio;
		this.modelo = modelo;
	}

	public Vehiculo(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	public Vehiculo(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			int anio, String modelo) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.anio = anio;
		this.modelo = modelo;
	}

	public int getAnio() {
		return anio;
	}

	public void setYear(int anio) {
		this.anio = anio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return super.toString() + anio + ";" + modelo;
	}

}
