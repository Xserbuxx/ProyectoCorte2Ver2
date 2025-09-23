package co.edu.unbosque.model;

public class Libro extends Producto {
	
	private String autor;
	private long isbn;
	
	/**
	 * Constructor vacío para inicializar un libro vacío.
	 */
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar un libro con autor e ISBN.
	 */
	public Libro(String autor, long isbn) {
		super();
		this.autor = autor;
		this.isbn = isbn;
	}

	/**
	 * Constructor para inicializar un libro con todos sus atributos.
	 */
	public Libro(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio, String autor,
			long isbn) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.autor = autor;
		this.isbn = isbn;
	}

	public Libro(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Devuelve el autor del libro.
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Configura el autor del libro.
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * Devuelve el ISBN del libro.
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * Configura el ISBN del libro.
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * Devuelve la representación en cadena del libro.
	 */
	@Override
	public String toString() {
		return super.toString()+autor+";"+isbn;
	}
	
}