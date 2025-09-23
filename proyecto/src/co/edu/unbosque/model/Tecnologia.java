package co.edu.unbosque.model;

public class Tecnologia extends Producto {

	private String marca;
	private String modelo;

	/**
	 * Constructor vacío para inicializar un objeto Tecnologia.
	 */
	public Tecnologia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar Tecnologia con marca y modelo.
	 */
	public Tecnologia(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}

	public Tecnologia(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar Tecnologia con todos sus atributos.
	 */
	public Tecnologia(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			String marca, String modelo) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.marca = marca;
		this.modelo = modelo;
	}

	/**
	 * Devuelve la marca.
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Configura la marca.
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Devuelve el modelo.
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Configura el modelo.
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Devuelve la representación en cadena de Tecnologia.
	 */
	@Override
	public String toString() {
		return super.toString() + marca + ";" + modelo;
	}

}