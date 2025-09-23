package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Mascota;

public class MascotaDAO implements DAO<Mascota> {
	private ArrayList<Mascota> lista;
	private String SERIAL_FILE_NAME = "mascotas.secn";
	/**
	 * Constructor que inicializa la lista y carga el archivo serializado.
	 */
	public MascotaDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}
	/**
	 * Carga la lista desde el archivo serializado.
	 */
	@Override	public void cargarArchivoSerializado() {
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Mascota>) contenido;
			} else {
				lista = new ArrayList<>();
			}
		} catch (Exception e) {
			lista = new ArrayList<>();
		}
	}
	/**
	 * Escribe la lista en el archivo serializado.
	 */
	@Override	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, lista);
	}
	/**
	 * Crea un nuevo registro de Mascota y persiste el cambio.
	 */
	@Override	public void crear(Mascota nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}
	/**
	 * Actualiza un registro en la posición indicada.
	 */
	@Override	public boolean actualizar(int indice, Mascota actualizarDato) {
		if (indice < 0 || indice >= lista.size()) {
			return false;
		} else {
			lista.set(indice, actualizarDato);
			escribirArchivoSerializado();
			return true;
		}
	}
	/**
	 * Elimina el registro en la posición indicada.
	 */
	@Override	public boolean eliminar(int indice) {
		if (indice < 0 || indice >= lista.size()) {
			return false;
		} else {
			lista.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}
	/**
	 * Elimina el producto indicado de la lista.
	 */
	public boolean eliminar(Mascota producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			lista.remove(producto);
			escribirArchivoSerializado();
			return true;
		}
	}
	/**
	 * Disminuye en una unidad el stock del producto indicado y persiste el cambio.
	 */
	public boolean bajarUnidades(Mascota producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			producto.setUnidades(producto.getUnidades() - 1);
			lista.set(lista.indexOf(producto), producto);
			escribirArchivoSerializado();
			return true;
		}
	}
	/**
	 * Aumenta en una unidad el stock del producto indicado y persiste el cambio.
	 */
	public boolean subirUnidades(Mascota producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			producto.setUnidades(producto.getUnidades() + 1);
			lista.set(lista.indexOf(producto), producto);
			escribirArchivoSerializado();
			return true;
		}
	}
	/**
	 * Devuelve el contenido de la lista como texto (una línea por producto).
	 */
	@Override	public String mostrarDatos() {
		StringBuilder contenido = new StringBuilder();
		for (Mascota mascota : lista) {
			contenido.append(mascota.toString()).append("\n");
		}
		return contenido.toString();
	}
	/**
	 * Devuelve el número de elementos en la lista.
	 */
	@Override	public int contar() {
		return lista.size();
	}
	public ArrayList<Mascota> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Mascota> lista) {
		this.lista = lista;
	}
}