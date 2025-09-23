package co.edu.unbosque.model;

public class Mascota extends Producto {

	private String tipoAnimal;
	private String tamaño;

	/**
	 * Constructor vacío para inicializar una Mascota vacía.
	 */
	public Mascota() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar Mascota con tipo de animal y tamaño.
	 */
	public Mascota(String tipoAnimal, String tamaño) {
		super();
		this.tipoAnimal = tipoAnimal;
		this.tamaño = tamaño;
	}

	public Mascota(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para inicializar Mascota con todos sus atributos.
	 */
	public Mascota(String nombre, String descripcion, String rutaFoto, int id, int unidades, double precio,
			String tipoAnimal, String tamaño) {
		super(nombre, descripcion, rutaFoto, id, unidades, precio);
		this.tipoAnimal = tipoAnimal;
		this.tamaño = tamaño;
	}

	/**
	 * Devuelve el tipo de animal.
	 */
	public String getTipoAnimal() {
		return tipoAnimal;
	}

	/**
	 * Configura el tipo de animal.
	 */
	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	/**
	 * Devuelve el tamaño.
	 */
	public String getTamaño() {
		return tamaño;
	}

	/**
	 * Configura el tamaño.
	 */
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	/**
	 * Devuelve la representación en cadena de Mascota.
	 */
	@Override
	public String toString() {
		return super.toString() + tipoAnimal + ";" + tamaño;
	}

}