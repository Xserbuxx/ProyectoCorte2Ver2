package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Ropa;

public class RopaDAO implements DAO<Ropa> {

	private ArrayList<Ropa> lista;
	private String SERIAL_FILE_NAME = "ropa.secn";

	public RopaDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

	@Override
	public void cargarArchivoSerializado() {
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Ropa>) contenido;
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
	public void crear(Ropa nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}

	@Override
	public boolean actualizar(int indice, Ropa actualizarDato) {
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
		for (Ropa ropa : lista) {
			contenido.append(ropa.toString()).append("\n");
		}
		return contenido.toString();
	}

	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Ropa> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Ropa> lista) {
		this.lista = lista;
	}
}