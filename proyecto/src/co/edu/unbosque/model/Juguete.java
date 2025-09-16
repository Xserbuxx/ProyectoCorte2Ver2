package co.edu.unbosque.model;

public class Juguete extends Producto {

	private String tipoJuguete;
	private String material;

	public Juguete() {
		// TODO Auto-generated constructor stub
	}

	public Juguete(String tipoJuguete, String material) {
		super();
		this.tipoJuguete = tipoJuguete;
		this.material = material;
	}

	public Juguete(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			String tipoJuguete, String material) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.tipoJuguete = tipoJuguete;
		this.material = material;
	}

	public Juguete(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	public String getTipoJuguete() {
		return tipoJuguete;
	}

	public void setTipoJuguete(String tipoJuguete) {
		this.tipoJuguete = tipoJuguete;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return super.toString()+tipoJuguete+";"+material;
	}

}
