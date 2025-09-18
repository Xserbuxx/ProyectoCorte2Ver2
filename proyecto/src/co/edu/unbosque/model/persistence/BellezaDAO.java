package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Belleza;

public class BellezaDAO implements DAO<Belleza> {

	private ArrayList<Belleza> lista;
	private String SERIAL_FILE_NAME = "belleza.secn";

	public BellezaDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

	@Override
	public void cargarArchivoSerializado() {
		
		//quitar try en todos los daos
		
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Belleza>) contenido;
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
	public void crear(Belleza nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();

	}

	@Override
	public boolean actualizar(int indice, Belleza actualizarDato) {
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
	
	public boolean eliminar(Belleza producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			lista.remove(producto);
			escribirArchivoSerializado();
			return true;
		}
	}
	
	public boolean bajarUnidades(Belleza producto) {
		if (producto == null || !lista.contains(producto)) {
			return false;
		} else {
			producto.setUnidades(producto.getUnidades() - 1);
			lista.set(lista.indexOf(producto), producto);
			escribirArchivoSerializado();
			return true;
		}
	}
	
	public boolean subirUnidades(Belleza producto) {
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
		String contenido = "";
		for (Belleza belleza : lista) {
			contenido += belleza.toString() + "\n";
		}

		return contenido;
	}

	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Belleza> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Belleza> lista) {
		this.lista = lista;
	}

}
