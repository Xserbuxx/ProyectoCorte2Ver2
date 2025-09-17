package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Deporte;

public class DeporteDAO implements DAO<Deporte> {

	private ArrayList<Deporte> lista;
	private String SERIAL_FILE_NAME = "deporte.secn";

	public DeporteDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

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

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, lista);
	}

	@Override
	public void crear(Deporte nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}

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
		for (Deporte deporte : lista) {
			contenido.append(deporte.toString()).append("\n");
		}
		return contenido.toString();
	}

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