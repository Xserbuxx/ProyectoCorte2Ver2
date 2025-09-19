package co.edu.unbosque.model;

public class Belleza extends Producto{
	
	private String tipoProducto;
	private String fechaExpiracion;
	
	public Belleza() {
		// TODO Auto-generated constructor stub
	}
	
	public Belleza(String tipoProducto, String fechaExpiracion) {
		super();
		this.tipoProducto = tipoProducto;
		this.fechaExpiracion = fechaExpiracion;
	}

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

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	
	@Override
	public String toString() {
		return super.toString()+tipoProducto+";"+fechaExpiracion;
	}
	
}
