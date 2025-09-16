package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Juguete;

public class JugueteDAO implements DAO<Juguete> {

    private ArrayList<Juguete> lista;
    private String SERIAL_FILE_NAME = "juguete.secn";

    public JugueteDAO() {
        lista = new ArrayList<>();
        cargarArchivoSerializado();
    }

    @Override
    public void cargarArchivoSerializado() {
        Object contenido = FileHandler.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (contenido != null) {
            lista = (ArrayList<Juguete>) contenido;
        } else {
            lista = new ArrayList<>();
        }
    }

    @Override
    public void escribirArchivoSerializado() {
        FileHandler.escribirArchivoSerializado(SERIAL_FILE_NAME, lista);
    }

    @Override
    public void crear(Juguete nuevoDato) {
        lista.add(nuevoDato);
        escribirArchivoSerializado();
    }

    @Override
    public boolean actualizar(int indice, Juguete actualizarDato) {
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
        for (Juguete juguete : lista) {
            contenido.append(juguete.toString()).append("\n");
        }
        return contenido.toString();
    }

    @Override
    public int contar() {
        return lista.size();
    }

	public ArrayList<Juguete> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Juguete> lista) {
		this.lista = lista;
	}
}