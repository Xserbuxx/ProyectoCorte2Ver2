package co.edu.unbosque.model;

public class Deporte extends Producto {
	
	private String tipoDeporte;
	private String marca;
	
	/**
	 * Constructor vacío para inicializar un objeto Deporte.
	 */
	public Deporte() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor para inicializar Deporte con tipo y marca.
	 */
	public Deporte(String tipoDeporte, String marca) {
		super();
		this.tipoDeporte = tipoDeporte;
		this.marca = marca;
	}

	/**
	 * Constructor para inicializar Deporte con todos sus atributos.
	 */
	public Deporte(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			String tipoDeporte, String marca) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.tipoDeporte = tipoDeporte;
		this.marca = marca;
	}

	public Deporte(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}
		
	/**
	 * Devuelve la representación en cadena de Deporte.
	 */
	@Override
	public String toString() {
		return super.toString()+tipoDeporte+";"+marca;
	}
	
	/**
	 * Devuelve el tipo de deporte.
	 */
	public String getTipoDeporte() {
		return tipoDeporte;
	}

	/**
	 * Configura el tipo de deporte.
	 */
	public void setTipoDeporte(String tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}

	/**
	 * Devuelve la marca.
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Configura la marca.
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
		
}