package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Deporte;

public class DeporteDAO implements DAO<Deporte> {

	private ArrayList<Deporte> lista;
	private String SERIAL_FILE_NAME = "deporte.secn";

	/**
	 * Constructor que inicializa la lista y carga el archivo serializado.
	 */
	public DeporteDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

	/**
	 * Carga la lista desde el archivo serializado.
	 */
	@Override
	public void cargarArchivoSerializado() {
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Deporte>) contenido;
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
	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, lista);
	}

	/**
	 * Crea un nuevo registro de Deporte y persiste el cambio.
	 */
	@Override
	public void crear(Deporte nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}

	/**
	 * Actualiza un registro en la posición indicada.
	 */
	@Override
	public boolean actualizar(int indice, Deporte actualizarDato) {
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
	@Override
	public boolean eliminar(int indice) {
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
	public boolean eliminar(Deporte producto) {
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
	public boolean bajarUnidades(Deporte producto) {
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
	public boolean subirUnidades(Deporte producto) {
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
	@Override
	public String mostrarDatos() {
		StringBuilder contenido = new StringBuilder();
		for (Deporte deporte : lista) {
			contenido.append(deporte.toString()).append("\n");
		}
		return contenido.toString();
	}

	/**
	 * Devuelve el número de elementos en la lista.
	 */
	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Deporte> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Deporte> lista) {
		this.lista = lista;
	}

}