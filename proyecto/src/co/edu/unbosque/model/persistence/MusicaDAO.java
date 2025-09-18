package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Musica;

public class MusicaDAO implements DAO<Musica> {

	private ArrayList<Musica> lista;
	private String SERIAL_FILE_NAME = "musica.secn";

	public MusicaDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

	@Override
	public void cargarArchivoSerializado() {
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Musica>) contenido;
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
	public void crear(Musica nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}

	@Override
	public boolean actualizar(int indice, Musica actualizarDato) {
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
	
	public boolean eliminar(Musica producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			lista.remove(producto);
			escribirArchivoSerializado();
			return true;
		}
	}
	
	public boolean bajarUnidades(Musica producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			producto.setUnidades(producto.getUnidades() - 1);
			lista.set(lista.indexOf(producto), producto);
			escribirArchivoSerializado();
			return true;
		}
	}
	
	public boolean subirUnidades(Musica producto) {
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
		for (Musica musica : lista) {
			contenido.append(musica.toString()).append("\n");
		}
		return contenido.toString();
	}

	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Musica> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Musica> lista) {
		this.lista = lista;
	}
}