package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Libro;

public class LibroDAO implements DAO<Libro> {

	private ArrayList<Libro> lista;
	private String SERIAL_FILE_NAME = "libro.secn";

	public LibroDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

	@Override
	public void cargarArchivoSerializado() {
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Libro>) contenido;
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
	public void crear(Libro nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}

	@Override
	public boolean actualizar(int indice, Libro actualizarDato) {
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
		for (Libro libro : lista) {
			contenido.append(libro.toString()).append("\n");
		}
		return contenido.toString();
	}

	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Libro> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Libro> lista) {
		this.lista = lista;
	}
}