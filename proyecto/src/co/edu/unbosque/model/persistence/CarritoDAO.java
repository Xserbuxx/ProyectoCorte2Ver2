package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Carrito;
import co.edu.unbosque.model.Producto;

public class CarritoDAO implements DAO<Carrito> {
	private ArrayList<Carrito> lista;
	private String SERIAL_FILE_NAME = "carrito.secn";
	/**
	 * Constructor que inicializa la lista y carga el archivo serializado.
	 */
	public CarritoDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}
	/**
	 * Carga la lista desde el archivo serializado.
	 */
	@Override	public void cargarArchivoSerializado() {
		try {			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);			if (contenido != null) {				lista = (ArrayList<Carrito>) contenido;			} else {				lista = new ArrayList<>();			}		} catch (Exception e) {			lista = new ArrayList<>();		}	}
	/**
	 * Escribe la lista en el archivo serializado.
	 */
	@Override	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, lista);
	}
	/**
	 * Crea un nuevo carrito y persiste el cambio.
	 */
	@Override	public void crear(Carrito nuevoDato) {		lista.add(nuevoDato);		escribirArchivoSerializado();	}
	/**
	 * Actualiza un carrito en la posición indicada.
	 */
	@Override	public boolean actualizar(int indice, Carrito actualizarDato) {		if (indice < 0 || indice >= lista.size()) {			return false;		} else {			lista.set(indice, actualizarDato);			escribirArchivoSerializado();			return true;		}	}
	/**
	 * Agrega un producto a un carrito identificado por su nombre y persiste el cambio.
	 */
	public void agregarProducto(String carrito, Producto producto) {		lista.forEach((carro) -> {			if (carro.getNombre().equals(carrito)) {				carro.getProductos().add(producto);				return;			}		});		escribirArchivoSerializado();	}
	/**
	 * Elimina el carrito en la posición indicada.
	 */
	@Override	public boolean eliminar(int indice) {		if (indice < 0 || indice >= lista.size()) {			return false;		} else {			lista.remove(indice);			escribirArchivoSerializado();			return true;		}	}
	/**
	 * Elimina el carrito indicado.
	 */
	public boolean eliminar(Carrito carrito) {		if (carrito == null || !lista.contains(carrito)) {			return false;		} else {			lista.remove(carrito);			escribirArchivoSerializado();			return true;		}	}
	/**
	 * Devuelve la representación en texto de todos los carritos.
	 */
	@Override	public String mostrarDatos() {		StringBuilder contenido = new StringBuilder();		for (Carrito carrito : lista) {			contenido.append(carrito.toString()).append("\n");		}		return contenido.toString();	}
	/**
	 * Devuelve el número de carritos almacenados.
	 */
	@Override	public int contar() {		return lista.size();	}
	public ArrayList<Carrito> getLista() {		return lista;	}
	public void setLista(ArrayList<Carrito> lista) {		this.lista = lista;	}
}