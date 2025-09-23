package co.edu.unbosque.model.persistence;

/**
 * Interfaz generica DAO.
 */
public interface DAO <E>{
		
	/**	 * Carga los datos desde el archivo serializado en la implementación.	 */	public void cargarArchivoSerializado();
	/**	 * Escribe los datos en el archivo serializado en la implementación.	 */	public void escribirArchivoSerializado();
	
	/**	 * Crea un nuevo registro en la fuente de datos.	 */	public void crear(E nuevoDato);
	/**	 * Actualiza un registro existente en la posición indicada.	 */	public boolean actualizar(int indice,E actualizarDato);
	/**	 * Elimina el registro en la posición indicada.	 */	public boolean eliminar(int indice);
	/**	 * Devuelve una representación textual de los datos almacenados.	 */	public String mostrarDatos();
	/**	 * Devuelve el número de elementos almacenados.	 */	public int contar();
	
}