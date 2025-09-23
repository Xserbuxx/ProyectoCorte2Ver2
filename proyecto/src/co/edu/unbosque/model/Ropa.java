package co.edu.unbosque.model;

public class Ropa extends Producto {

	private String talla;
	private String color;

	/**
	 * Constructor vacío para inicializar un objeto Ropa.
	 */
	public Ropa() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar Ropa con talla y color.
	 */
	public Ropa(String talla, String color) {
		super();
		this.talla = talla;
		this.color = color;
	}

	public Ropa(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar Ropa con todos sus atributos.
	 */
	public Ropa(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio, String talla,
			String color) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.talla = talla;
		this.color = color;
	}

	/**
	 * Devuelve la talla de la ropa.
	 */
	public String getTalla() {
		return talla;
	}

	/**
	 * Configura la talla de la ropa.
	 */
	public void setTalla(String talla) {
		this.talla = talla;
	}

	/**
	 * Devuelve el color de la ropa.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Configura el color de la ropa.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Devuelve la representación en cadena de la ropa.
	 */
	@Override
	public String toString() {
		return super.toString() + talla + ";" + color;
	}

}