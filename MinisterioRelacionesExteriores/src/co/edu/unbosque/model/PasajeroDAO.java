package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import co.edu.unbosque.controller.FileHandler;

/**
 * Al implenetar la interfaz OperacionesDAO, obliga a darle funcionalidad a los
 * metodos por medio de la palabra clase 'Override'
 * 
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 * @param lista ArrayList de tipo PasajeroDTO que contiene la informacion de
 *              todos los pasajeros
 *
 */

public class PasajeroDAO implements OperacionesDAO {

	private ArrayList<PasajeroDTO> lista;

	public PasajeroDAO() {
		lista = (ArrayList<PasajeroDTO>) FileHandler.leerSerializado("general.txt");
		if (lista == null) {
			lista = new ArrayList<PasajeroDTO>();
		}
	}

	public ArrayList<PasajeroDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<PasajeroDTO> lista) {
		this.lista = lista;
	}

	/**
	 * Sobreescribe el archivo serializado de todos los pasajeros con la informacion registrada en la lista.
	 */
	public void escribirArchivo() {
		FileHandler.escribirSerializado("general.txt", lista);
	}
	/**
	 * Metodo para agregar la lista de AceptadosDTO a la lista general
	 * @param lista_aceptados Lista de AceptadosDTO
	 */

	public void agregarAceptado(ArrayList<AceptadoDTO> lista_aceptados) {
		lista.addAll(lista_aceptados);
		escribirArchivo();
	}
	/**
	 * Metodo para agregar la lista de RechazadosDTO a la lista general
	 * @param lista_aceptados Lista de RechazadosDTO
	 */
	
	public void agregarRechazado(ArrayList<RechazadoDTO> lista_rechazados) {
		lista.addAll(lista_rechazados);
		escribirArchivo();
	}

	@Override
	public void crear(Object obj) {
		lista.add((PasajeroDTO) obj);
		escribirArchivo();
	}

	@Override
	public boolean eliminar(int index) {
		try {
			lista.remove(index);
			escribirArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean actualizar(int index, Object obj) {
		try {
			lista.set(index, (PasajeroDTO) obj);
			escribirArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Metodo que filtra pasajeros por nacionalidad colombiana.
	 * @return Retorna un String con toda la informacion de pasajeros colombianos.
	 */
	public String mostrarColombiano() {
		if (lista.isEmpty()) {
			return "No existe ningun Pasajero.";
		} else {
			StringBuilder sb = new StringBuilder();
			SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
			sb.append("Pasajeros Colombianos: \n");
			for (PasajeroDTO p : lista) {
				if (p.getPais_origen().equalsIgnoreCase("Colombia")) {
					sb.append("No°" + lista.indexOf(p) + "\n");
					sb.append(p.toString());
				}
			}
			return sb.toString();
		}
	}

	/**
	 * Metodo que filtra pasajeros extranjeros.
	 * @return Retorna un String con toda la informacion de pasajeros extranjeros.
	 */
	
	public String mostrarExtranjero() {
		if (lista.isEmpty()) {
			return "No existe ningun Pasajero.";
		} else {
			StringBuilder sb = new StringBuilder();
			SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
			sb.append("Pasajeros Extranjeros: \n");
			for (PasajeroDTO p : lista) {
				if (p.getPais_origen().equalsIgnoreCase("Colombia") == false) {
					sb.append("No°" + lista.indexOf(p) + "\n");
					sb.append(p.toString());
				}
			}
			return sb.toString();
		}
	}

}
