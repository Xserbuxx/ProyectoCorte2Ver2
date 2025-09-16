package co.edu.unbosque.model.persistence;

public interface DAO <E>{
		
	public void cargarArchivoSerializado();
	public void escribirArchivoSerializado();
	
	public void crear(E nuevoDato);
	public boolean actualizar(int indice,E actualizarDato);
	public boolean eliminar(int indice);
	public String mostrarDatos();
	public int contar();
	
}
