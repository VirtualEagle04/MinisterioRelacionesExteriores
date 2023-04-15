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
	
	public String mostrarTodo() {
		if(lista.isEmpty()) {
			return "No hay ningun pasajero";
		}else {
			StringBuilder sb = new StringBuilder();
			SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
			sb.append("General: \n");
			for (PasajeroDTO p : lista) {
				sb.append("   "+ p.getApellidos() + " " + p.getNombres()+"\n");
				sb.append("   "+ date_format.format(p.getFecha_nacimiento()) + "\n");
				sb.append("   "+ p.getPais_origen()+"\n");
				sb.append("   "+p.getNombre_imagen()+"\n");
				if(p instanceof AceptadoDTO) {
					sb.append("   Aceptado\n");
				}
				else if (p instanceof RechazadoDTO) {
					sb.append("   Rechazado\n");
				}
				sb.append("------------------------------------\n");
			}
			return sb.toString();
		}
		
	}

}
