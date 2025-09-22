package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Vehiculo;

public class VehiculoDAO implements DAO<Vehiculo> {

	private ArrayList<Vehiculo> lista;
	private String SERIAL_FILE_NAME = "vehiculos.secn";

	public VehiculoDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

	@Override
	public void cargarArchivoSerializado() {
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Vehiculo>) contenido;
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
	public void crear(Vehiculo nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}

	@Override
	public boolean actualizar(int indice, Vehiculo actualizarDato) {
		if (indice < 0 || indice >= lista.size()) {
			return false;
		} else {
			lista.set(indice, actualizarDato);
			escribirArchivoSerializado();
			return true;
		}
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
	
	public boolean eliminar(Vehiculo producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			lista.remove(producto);
			escribirArchivoSerializado();
			return true;
		}
	}
	
	public boolean bajarUnidades(Vehiculo producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			producto.setUnidades(producto.getUnidades() - 1);
			lista.set(lista.indexOf(producto), producto);
			escribirArchivoSerializado();
			return true;
		}
	}
	
	public boolean subirUnidades(Vehiculo producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			producto.setUnidades(producto.getUnidades() + 1);
			lista.set(lista.indexOf(producto), producto);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public String mostrarDatos() {
		StringBuilder contenido = new StringBuilder();
		for (Vehiculo vehiculo : lista) {
			contenido.append(vehiculo.toString()).append("\n");
		}
		return contenido.toString();
	}

	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Vehiculo> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Vehiculo> lista) {
		this.lista = lista;
	}
}