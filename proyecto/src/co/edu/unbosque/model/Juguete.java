package co.edu.unbosque.model;

public class Juguete extends Producto {

	private int edadRecomendada;
	private String material;

	public Juguete() {
		// TODO Auto-generated constructor stub
	}

	public Juguete(int edadRecomendada, String material) {
		super();
		this.edadRecomendada = edadRecomendada;
		this.material = material;
	}

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

	public int getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return super.toString()+edadRecomendada+";"+material;
	}

}
