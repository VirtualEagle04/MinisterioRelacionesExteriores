package co.edu.unbosque.util.exceptions;

/**
 * Excepción para controlar el ingreso de caracteres invalidos.
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 *
 */

public class CaracterInvalidoException extends Exception{

	/**
	 * Muestra un mensaje de error predeterminado.
	 */
	public CaracterInvalidoException() {
	
		
		super("Ha ingresado un caracter especial");
		
	}
	
}
