package co.edu.unbosque.model;

public class Hogar extends Producto{
	
	private String material;
	private String tipoProducto;
	
	public Hogar() {
		// TODO Auto-generated constructor stub
	}
	
	public Hogar(String material, String tipoProducto) {
		super();
		this.material = material;
		this.tipoProducto = tipoProducto;
	}

	public Hogar(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			String material, String tipoProducto) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.material = material;
		this.tipoProducto = tipoProducto;
	}

	public Hogar(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	@Override
	public String toString() {
		return super.toString()+material+";"+tipoProducto;
	}
	
}
