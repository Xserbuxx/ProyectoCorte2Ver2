package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Vehiculos;

public class VehiculosDAO implements DAO<Vehiculos> {

	private ArrayList<Vehiculos> lista;
	private String SERIAL_FILE_NAME = "vehiculos.secn";

	public VehiculosDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

	@Override
	public void cargarArchivoSerializado() {
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Vehiculos>) contenido;
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
	public void crear(Vehiculos nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}

	@Override
	public boolean actualizar(int indice, Vehiculos actualizarDato) {
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

	@Override
	public String mostrarDatos() {
		StringBuilder contenido = new StringBuilder();
		for (Vehiculos vehiculo : lista) {
			contenido.append(vehiculo.toString()).append("\n");
		}
		return contenido.toString();
	}

	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Vehiculos> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Vehiculos> lista) {
		this.lista = lista;
	}
}