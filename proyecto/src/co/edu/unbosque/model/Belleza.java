package co.edu.unbosque.model;

public class Belleza extends Producto{
	
	private String tipoProducto;
	private String fechaExpiracion;
	
	/**
	 * Constructor vacío para inicializar un objeto Belleza.
	 */
	public Belleza() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor para inicializar Belleza con tipo y fecha de expiración.
	 */
	public Belleza(String tipoProducto, String fechaExpiracion) {
		super();
		this.tipoProducto = tipoProducto;
		this.fechaExpiracion = fechaExpiracion;
	}

	/**
	 * Constructor para inicializar Belleza con todos sus atributos.
	 */
	public Belleza(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			String tipoProducto, String fechaExpiracion) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.tipoProducto = tipoProducto;
		this.fechaExpiracion = fechaExpiracion;
	}

	public Belleza(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Devuelve el tipo de producto de Belleza.
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}

	/**
	 * Configura el tipo de producto de Belleza.
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	/**
	 * Devuelve la fecha de expiración del producto.
	 */
	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	/**
	 * Configura la fecha de expiración del producto.
	 */
	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	
	/**
	 * Devuelve la representación en cadena de Belleza.
	 */
	@Override
	public String toString() {
		return super.toString()+tipoProducto+";"+fechaExpiracion;
	}
	
}