package co.edu.unbosque.util.exceptions;

/**
 * Excepción para controlar el ingreso de formatos no numericos.
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 *
 */

public class NumeroIncorrectoException extends NumberFormatException {

	/**
	 * Muestra un mensaje de error predeterminado.
	 */
	public NumeroIncorrectoException() {

		super("Ha ingresado un dato invalido");
		
	}
	
}
