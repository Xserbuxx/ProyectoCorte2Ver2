package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Belleza;

public class BellezaDAO implements DAO<Belleza> {

	private ArrayList<Belleza> lista;
	private String SERIAL_FILE_NAME = "belleza.secn";

	/**
	 * Constructor que inicializa la lista y carga el archivo serializado.
	 */
	public BellezaDAO() {
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
				lista = (ArrayList<Belleza>) contenido;
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
	 * Crea un nuevo registro de Belleza y persiste el cambio.
	 */
	@Override
	public void crear(Belleza nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();

	}

	/**
	 * Actualiza un registro en la posición indicada.
	 */
	@Override
	public boolean actualizar(int indice, Belleza actualizarDato) {
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
	public boolean eliminar(Belleza producto) {
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
	public boolean bajarUnidades(Belleza producto) {
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
	public boolean subirUnidades(Belleza producto) {
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
		String contenido = "";
		for (Belleza belleza : lista) {
			contenido += belleza.toString() + "\n";
		}

		return contenido;
	}

	/**
	 * Devuelve el número de elementos en la lista.
	 */
	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Belleza> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Belleza> lista) {
		this.lista = lista;
	}

}