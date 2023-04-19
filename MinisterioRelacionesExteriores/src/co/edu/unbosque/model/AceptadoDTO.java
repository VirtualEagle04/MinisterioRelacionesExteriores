package co.edu.unbosque.model;

import java.util.Date;

/**
 * Clase que representa los pasajeros Admitidos, heredando atributos de todos los PasajerosDTO.
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 *
 */

public class AceptadoDTO extends PasajeroDTO{

	public AceptadoDTO() {
		// TODO Auto-generated constructor stub
	}

	public AceptadoDTO(String nombres, String apellidos, Date fecha_nacimiento, String pais_origen,
			String nombre_imagen) {
		super(nombres, apellidos, fecha_nacimiento, pais_origen, nombre_imagen);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
