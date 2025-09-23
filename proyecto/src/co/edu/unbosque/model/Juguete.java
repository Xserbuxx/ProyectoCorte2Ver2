package co.edu.unbosque.model;

public class Juguete extends Producto {

	private int edadRecomendada;
	private String material;

	/**
	 * Constructor vacío para inicializar un juguete vacío.
	 */
	public Juguete() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar un juguete con edad recomendada y material.
	 */
	public Juguete(int edadRecomendada, String material) {
		super();
		this.edadRecomendada = edadRecomendada;
		this.material = material;
	}

	/**
	 * Constructor para inicializar un juguete con todos sus atributos.
	 */
	public Juguete(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			int edadRecomendada, String material) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.edadRecomendada = edadRecomendada;
		this.material = material;
	}

	public Juguete(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Devuelve la edad recomendada para el juguete.
	 */
	public int getEdadRecomendada() {
		return edadRecomendada;
	}

	/**
	 * Configura la edad recomendada para el juguete.
	 */
	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	/**
	 * Devuelve el material del juguete.
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Configura el material del juguete.
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Devuelve la representación en cadena del juguete.
	 */
	@Override
	public String toString() {
		return super.toString() + edadRecomendada + ";" + material;
	}

}