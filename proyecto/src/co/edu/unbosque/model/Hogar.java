package co.edu.unbosque.model;

public class Hogar extends Producto{
	
	private String material;
	private String tipoProducto;
	
	/**
	 * Constructor vacío para inicializar un objeto Hogar.
	 */
	public Hogar() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor para inicializar Hogar con material y tipo.
	 */
	public Hogar(String material, String tipoProducto) {
		super();
		this.material = material;
		this.tipoProducto = tipoProducto;
	}

	/**
	 * Constructor para inicializar Hogar con todos sus atributos.
	 */
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

	/**
	 * Devuelve el material del producto.
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Configura el material del producto.
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Devuelve el tipo de producto.
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}

	/**
	 * Configura el tipo de producto.
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	/**
	 * Devuelve la representación en cadena de Hogar.
	 */
	@Override
	public String toString() {
		return super.toString()+material+";"+tipoProducto;
	}
	
}