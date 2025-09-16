package co.edu.unbosque.model;

public class Libro extends Producto {
	
	private String autor;
	private long isbn;
	
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Libro(String autor, long isbn) {
		super();
		this.autor = autor;
		this.isbn = isbn;
	}

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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return super.toString()+autor+";"+isbn;
	}
	
}
