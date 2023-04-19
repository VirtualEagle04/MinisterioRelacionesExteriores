package co.edu.unbosque.model;

public interface OperacionesDAO {

	/**
	 * Se llama al momento de crear un nuevo Viaje de cualquier tipo.
	 * 
	 * @param obj El objeto de crear. Puede ser del cualquier clase que herede de
	 *            ViajeDTO.
	 * 
	 */
	public void crear(Object obj);

	/**
	 * Se llama al momento de eliminar un Viaje de cualquier tipo, previamente
	 * creado.
	 * 
	 * @param index La posicion del Viaje a eliminar.
	 * @return Retorna true si se pudo completar la eliminacion, de lo contrario,
	 *         devuelve false.
	 */

	public boolean eliminar(int index);

	/**
	 * Se llama al momento de actualizar un viaje de cualquier tipo, previamente
	 * creado.
	 * 
	 * @param index La posicion del Viaje a actualizar.
	 * @param obj   El objeto que reemplazara el previo objeto de la posicion dada.
	 * @return Retorna true si se pudo completar la eliminacion, de lo contrario,
	 *         devuelve false.
	 */
	public boolean actualizar(int index, Object obj);

}
