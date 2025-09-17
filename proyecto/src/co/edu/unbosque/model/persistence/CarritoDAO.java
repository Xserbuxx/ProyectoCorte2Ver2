package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Carrito;
import co.edu.unbosque.model.Producto;

public class CarritoDAO implements DAO<Carrito> {

	private ArrayList<Carrito> lista;
	private String SERIAL_FILE_NAME = "carrito.secn";

	public CarritoDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

	@Override
	public void cargarArchivoSerializado() {
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Carrito>) contenido;
			} else {
				lista = new ArrayList<>();
			}
		} catch (Exception e) {
			lista = new ArrayList<>();
		}
	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, lista);
	}

	@Override
	public void crear(Carrito nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}

	@Override
	public boolean actualizar(int indice, Carrito actualizarDato) {
		if (indice < 0 || indice >= lista.size()) {
			return false;
		} else {
			lista.set(indice, actualizarDato);
			escribirArchivoSerializado();
			return true;
		}
	}
	
	public void agregarProducto(String carrito, Producto producto) {
		lista.forEach((carro) -> {
			if (carro.getNombre().equals(carrito)) {
				carro.getProductos().add(producto);
				return;
			}
		});
		escribirArchivoSerializado();
	}

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
	
	public boolean eliminar(Carrito carrito) {
		if (carrito == null || !lista.contains(carrito)) {
			return false;
		} else {
			lista.remove(carrito);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public String mostrarDatos() {
		StringBuilder contenido = new StringBuilder();
		for (Carrito carrito : lista) {
			contenido.append(carrito.toString()).append("\n");
		}
		return contenido.toString();
	}

	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Carrito> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Carrito> lista) {
		this.lista = lista;
	}
}