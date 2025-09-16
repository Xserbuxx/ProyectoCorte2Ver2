package co.edu.unbosque.model;

public class Tecnologia extends Producto {

	private String marca;
	private String modelo;

	public Tecnologia() {
		// TODO Auto-generated constructor stub
	}

	public Tecnologia(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}

	public Tecnologia(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	public Tecnologia(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			String marca, String modelo) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return super.toString() + marca + ";" + modelo;
	}

}
