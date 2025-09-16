package co.edu.unbosque.model;

public class Musica extends Producto {

	private String formato;
	private String artista;

	public Musica() {
		// TODO Auto-generated constructor stub
	}

	public Musica(String formato, String artista) {
		super();
		this.formato = formato;
		this.artista = artista;
	}

	public Musica(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	public Musica(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			String formato, String artista) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.formato = formato;
		this.artista = artista;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return super.toString() + formato + ";" + artista;
	}

}
