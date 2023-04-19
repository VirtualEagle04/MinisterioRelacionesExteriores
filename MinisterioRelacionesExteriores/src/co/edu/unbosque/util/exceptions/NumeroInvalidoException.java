package co.edu.unbosque.util.exceptions;

/**
 * Excepción para controlar el ingreso de numeros en lecturas de tipo String.
 * 
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 *
 */

public class NumeroInvalidoException extends Exception {

	/**
	 * Muestra un mensaje de error predeterminado.
	 */

	public NumeroInvalidoException() {

		super("Ha ingresado un numero invalido");

	}

}
