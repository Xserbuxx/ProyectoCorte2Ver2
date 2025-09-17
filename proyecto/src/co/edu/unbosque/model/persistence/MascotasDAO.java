package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Mascotas;

public class MascotasDAO implements DAO<Mascotas> {

	private ArrayList<Mascotas> lista;
	private String SERIAL_FILE_NAME = "mascotas.secn";

	public MascotasDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

	@Override
	public void cargarArchivoSerializado() {
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Mascotas>) contenido;
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
	public void crear(Mascotas nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}

	@Override
	public boolean actualizar(int indice, Mascotas actualizarDato) {
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
		for (Mascotas mascota : lista) {
			contenido.append(mascota.toString()).append("\n");
		}
		return contenido.toString();
	}

	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Mascotas> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Mascotas> lista) {
		this.lista = lista;
	}
}