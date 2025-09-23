package co.edu.unbosque.model;

public class Musica extends Producto {

	private String formato;
	private String artista;

	/**
	 * Constructor vacío para inicializar un objeto Musica.
	 */
	public Musica() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar Musica con formato y artista.
	 */
	public Musica(String formato, String artista) {
		super();
		this.formato = formato;
		this.artista = artista;
	}

	public Musica(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar Musica con todos sus atributos.
	 */
	public Musica(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			String formato, String artista) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.formato = formato;
		this.artista = artista;
	}

	/**
	 * Devuelve el formato de la música.
	 */
	public String getFormato() {
		return formato;
	}

	/**
	 * Configura el formato de la música.
	 */
	public void setFormato(String formato) {
		this.formato = formato;
	}

	/**
	 * Devuelve el artista.
	 */
	public String getArtista() {
		return artista;
	}

	/**
	 * Configura el artista.
	 */
	public void setArtista(String artista) {
		this.artista = artista;
	}

	/**
	 * Devuelve la representación en cadena de Musica.
	 */
	@Override
	public String toString() {
		return super.toString() + formato + ";" + artista;
	}

}