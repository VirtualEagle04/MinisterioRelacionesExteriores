package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import co.edu.unbosque.controller.FileHandler;

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

	public void escribirArchivo() {
		FileHandler.escribirSerializado("general.txt", lista);
	}

	public void agregarAceptado(ArrayList<AceptadoDTO> lista_aceptados) {
		lista.addAll(lista_aceptados);
		escribirArchivo();
	}

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

	public String mostrarColombiano() {
		if (lista.isEmpty()) {
			return "No existe ningun Pasajero.";
		} else {
			StringBuilder sb = new StringBuilder();
			ArrayList<PasajeroDTO> temp = new ArrayList<>();
			SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
			sb.append("Pasajeros Colombianos: \n");
			for (PasajeroDTO p : lista) {
				if (p.getPais_origen().equalsIgnoreCase("Colombia")) {
					temp.add(p);
				}
			}
			for (int i = 0; i < temp.size(); i++) {
				sb.append("No°" + i + "\n");
				sb.append(temp.get(i).toString());

			}
			return sb.toString();
		}
	}

	public String mostrarExtranjero() {
		if (lista.isEmpty()) {
			return "No existe ningun Pasajero.";
		} else {
			StringBuilder sb = new StringBuilder();
			ArrayList<PasajeroDTO> temp = new ArrayList<>();
			SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
			sb.append("Pasajeros Extranjeros: \n");
			for (PasajeroDTO p : lista) {
				if (p.getPais_origen().equalsIgnoreCase("Colombia") == false) {
					temp.add(p);
				}
			}
			for (int i = 0; i < temp.size(); i++) {
				sb.append("No°" + i + "\n");
				sb.append(temp.get(i).toString());

			}

			return sb.toString();
		}
	}

}
