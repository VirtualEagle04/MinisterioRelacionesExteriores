package co.edu.unbosque.util.exceptions;

/**
 * Excepción para controlar el ingreso de numeros negativos.
 * 
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 *
 */
public class NumeroNegativoException extends Exception{
	/**
	 * Muestra un mensaje de error predeterminado.
	 */
	public NumeroNegativoException() {

		super("Ha ingresado un digito menor que 0");
		
	}
	
}
