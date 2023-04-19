package co.edu.unbosque.util.exceptions;

/**
 * Excepci�n para controlar el ingreso de paises inexistentes.
 * 
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 *
 */
public class PaisInexistenteException extends Exception {
	/**
	 * Muestra un mensaje de error predeterminado.
	 */
	public PaisInexistenteException() {
		super("El pais ingresado no existe.");
	}

}
