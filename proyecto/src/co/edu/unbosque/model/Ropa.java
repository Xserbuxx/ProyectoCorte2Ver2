package co.edu.unbosque.model;

public class Ropa extends Producto {

	private String talla;
	private String color;

	public Ropa() {
		// TODO Auto-generated constructor stub
	}

	public Ropa(String talla, String color) {
		super();
		this.talla = talla;
		this.color = color;
	}

	public Ropa(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	public Ropa(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio, String talla,
			String color) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.talla = talla;
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + talla + ";" + color;
	}

}
