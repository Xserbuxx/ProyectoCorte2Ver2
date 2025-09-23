package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Hogar;

public class HogarDAO implements DAO<Hogar> {
	private ArrayList<Hogar> lista;
	private String SERIAL_FILE_NAME = "hogar.secn";
	/**
	 * Constructor que inicializa la lista y carga el archivo serializado.
	 */
	public HogarDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}
	/**
	 * Carga la lista desde el archivo serializado.
	 */
	@Override	public void cargarArchivoSerializado() {
		try {			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);			if (contenido != null) {				lista = (ArrayList<Hogar>) contenido;			} else {				lista = new ArrayList<>();			}		} catch (Exception e) {			lista = new ArrayList<>();		}	}
	/**
	 * Escribe la lista en el archivo serializado.
	 */
	@Override	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, lista);
	}
	/**
	 * Crea un nuevo registro de Hogar y persiste el cambio.
	 */
	@Override	public void crear(Hogar nuevoDato) {		lista.add(nuevoDato);		escribirArchivoSerializado();
	}
	/**
	 * Actualiza un registro en la posición indicada.
	 */
	@Override	public boolean actualizar(int indice, Hogar actualizarDato) {		if (indice < 0 || indice >= lista.size()) {			return false;		} else {			lista.set(indice, actualizarDato);			escribirArchivoSerializado();			return true;		}	}
	/**
	 * Elimina el registro en la posición indicada.
	 */
	@Override	public boolean eliminar(int indice) {		if (indice < 0 || indice >= lista.size()) {			return false;		} else {			lista.remove(indice);			escribirArchivoSerializado();			return true;		}	}
	/**
	 * Elimina el producto indicado de la lista.
	 */
	public boolean eliminar(Hogar producto) {		if (producto == null || !lista.contains(producto)) {			return false;		} else {			lista.remove(producto);			escribirArchivoSerializado();			return true;		}	}
	/**
	 * Disminuye en una unidad el stock del producto indicado y persiste el cambio.
	 */
	public boolean bajarUnidades(Hogar producto) {		if (producto == null || !lista.contains(producto)) {			return false;		} else {			producto.setUnidades(producto.getUnidades() - 1);			lista.set(lista.indexOf(producto), producto);			escribirArchivoSerializado();			return true;		}	}
	/**
	 * Aumenta en una unidad el stock del producto indicado y persiste el cambio.
	 */
	public boolean subirUnidades(Hogar producto) {		if (producto == null || !lista.contains(producto)) {			return false;		} else {			producto.setUnidades(producto.getUnidades() + 1);			lista.set(lista.indexOf(producto), producto);			escribirArchivoSerializado();			return true;		}	}
	/**
	 * Devuelve el contenido de la lista como texto (una línea por producto).
	 */
	@Override	public String mostrarDatos() {		StringBuilder contenido = new StringBuilder();		for (Hogar hogar : lista) {			contenido.append(hogar.toString()).append("\n");		}		return contenido.toString();	}
	/**
	 * Devuelve el número de elementos en la lista.
	 */
	@Override	public int contar() {		return lista.size();	}
	public ArrayList<Hogar> getLista() {		return lista;	}
	public void setLista(ArrayList<Hogar> lista) {		this.lista = lista;	}
}