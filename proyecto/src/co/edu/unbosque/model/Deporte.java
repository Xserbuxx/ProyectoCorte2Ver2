package co.edu.unbosque.model;

public class Deporte extends Producto {
	
	private String tipoDeporte;
	private String marca;
	
	public Deporte() {
		// TODO Auto-generated constructor stub
	}
	
	public Deporte(String tipoDeporte, String marca) {
		super();
		this.tipoDeporte = tipoDeporte;
		this.marca = marca;
	}

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
		
	@Override
	public String toString() {
		return super.toString()+tipoDeporte+";"+marca;
	}

	public String getTipoDeporte() {
		return tipoDeporte;
	}

	public void setTipoDeporte(String tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
