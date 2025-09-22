package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Mascota;

public class MascotaDAO implements DAO<Mascota> {

	private ArrayList<Mascota> lista;
	private String SERIAL_FILE_NAME = "mascotas.secn";

	public MascotaDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

	@Override
	public void cargarArchivoSerializado() {
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Mascota>) contenido;
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
	public void crear(Mascota nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}

	@Override
	public boolean actualizar(int indice, Mascota actualizarDato) {
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
	
	public boolean eliminar(Mascota producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			lista.remove(producto);
			escribirArchivoSerializado();
			return true;
		}
	}
	
	public boolean bajarUnidades(Mascota producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			producto.setUnidades(producto.getUnidades() - 1);
			lista.set(lista.indexOf(producto), producto);
			escribirArchivoSerializado();
			return true;
		}
	}
	
	public boolean subirUnidades(Mascota producto) {
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
		for (Mascota mascota : lista) {
			contenido.append(mascota.toString()).append("\n");
		}
		return contenido.toString();
	}

	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Mascota> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Mascota> lista) {
		this.lista = lista;
	}
}