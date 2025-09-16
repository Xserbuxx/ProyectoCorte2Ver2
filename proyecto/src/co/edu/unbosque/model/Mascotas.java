package co.edu.unbosque.model;

public class Mascotas extends Producto {

	private String tipoAnimal;
	private String tamaño;

	public Mascotas() {
		// TODO Auto-generated constructor stub
	}

	public Mascotas(String tipoAnimal, String tamaño) {
		super();
		this.tipoAnimal = tipoAnimal;
		this.tamaño = tamaño;
	}

	public Mascotas(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	public Mascotas(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			String tipoAnimal, String tamaño) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.tipoAnimal = tipoAnimal;
		this.tamaño = tamaño;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	@Override
	public String toString() {
		return super.toString()+tipoAnimal+";"+tamaño;
	}
}
