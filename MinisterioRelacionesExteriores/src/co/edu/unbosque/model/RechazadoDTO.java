package co.edu.unbosque.model;

import java.util.Date;

/**
 * Clase que representa los pasajeros Rechazados, heredando atributos de todos los PasajerosDTO.
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 *
 */
public class RechazadoDTO extends PasajeroDTO{

	public RechazadoDTO() {
		// TODO Auto-generated constructor stub
	}

	public RechazadoDTO(String nombres, String apellidos, Date fecha_nacimiento, String pais_origen,
			String nombre_imagen) {
		super(nombres, apellidos, fecha_nacimiento, pais_origen, nombre_imagen);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
