package co.edu.unbosque.model;

public class Vehiculo extends Producto {

	private int anio;
	private String modelo;

	/**
	 * Constructor vacío para inicializar un vehículo vacío.
	 */
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar un vehículo con año y modelo.
	 */
	public Vehiculo(int anio, String modelo) {
		super();
		this.anio = anio;
		this.modelo = modelo;
	}

	public Vehiculo(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar un vehículo con todos sus atributos.
	 */
	public Vehiculo(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			int anio, String modelo) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.anio = anio;
		this.modelo = modelo;
	}

	/**
	 * Devuelve el año del vehículo.
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * Configura el año del vehículo.
	 */
	public void setYear(int anio) {
		this.anio = anio;
	}

	/**
	 * Devuelve el modelo del vehículo.
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Configura el modelo del vehículo.
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Devuelve la representación en cadena del vehículo.
	 */
	@Override
	public String toString() {
		return super.toString() + anio + ";" + modelo;
	}

}