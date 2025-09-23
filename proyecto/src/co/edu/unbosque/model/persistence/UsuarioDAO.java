package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Usuario;

public class UsuarioDAO implements DAO<Usuario> {

	private ArrayList<Usuario> lista;
	private String SERIAL_FILE_NAME = "usuario.secn";

	/**
	 * Constructor que inicializa la lista y carga el archivo serializado.
	 */
	public UsuarioDAO() {
		lista = new ArrayList<>();
		cargarArchivoSerializado();
	}

	/**
	 * Carga la lista desde el archivo serializado.
	 */
	@Override
	public void cargarArchivoSerializado() {
		try {
			Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
			if (contenido != null) {
				lista = (ArrayList<Usuario>) contenido;
			} else {
				lista = new ArrayList<>();
			}
		} catch (Exception e) {
			lista = new ArrayList<>();
		}
	}

	/**
	 * Escribe la lista en el archivo serializado.
	 */
	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, lista);
	}

	/**
	 * Crea un nuevo usuario y persiste el cambio.
	 */
	@Override
	public void crear(Usuario nuevoDato) {
		lista.add(nuevoDato);
		escribirArchivoSerializado();
	}

	/**
	 * Actualiza un usuario en la posición indicada.
	 */
	@Override
	public boolean actualizar(int indice, Usuario actualizarDato) {
		if (indice < 0 || indice >= lista.size()) {
			return false;
		} else {
			lista.set(indice, actualizarDato);
			escribirArchivoSerializado();
			return true;
		}
	}

	/**
	 * Elimina el usuario en la posición indicada.
	 */
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

	/**
	 * Devuelve la representación en texto de todos los usuarios.
	 */
	@Override
	public String mostrarDatos() {
		StringBuilder contenido = new StringBuilder();
		for (Usuario usuario : lista) {
			contenido.append(usuario.toString()).append("\n");
		}
		return contenido.toString();
	}

	/**
	 * Devuelve el número de usuarios almacenados.
	 */
	@Override
	public int contar() {
		return lista.size();
	}

	public ArrayList<Usuario> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Usuario> lista) {
		this.lista = lista;
	}
}