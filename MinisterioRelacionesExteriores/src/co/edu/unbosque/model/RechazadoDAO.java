package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.controller.FileHandler;

public class RechazadoDAO implements OperacionesDAO {

	private ArrayList<RechazadoDTO> lista;

	public RechazadoDAO() {
		try {
			lista = cargarArchivo();
		} catch (Exception e) {
			lista = new ArrayList<RechazadoDTO>();
		}
	}

	public ArrayList<RechazadoDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<RechazadoDTO> lista) {
		this.lista = lista;
	}

	public ArrayList<RechazadoDTO> cargarArchivo() {
		ArrayList<RechazadoDTO> desde_archivo = new ArrayList<RechazadoDTO>();
		String contenido = FileHandler.abrirArchivoText("rechazados.csv");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attr = linea.split(",");
			String nombres = attr[0];
			String apellidos = attr[1];
			Date fecha_nacimiento = new Date(attr[2]);
			String pais_origen = attr[3];
			String nombre_imagen = attr[4];
			desde_archivo.add(new RechazadoDTO(nombres, apellidos, fecha_nacimiento, pais_origen, nombre_imagen));
		}
		return desde_archivo;
	}

	public void escribirArchivo() {
		StringBuilder sb = new StringBuilder();
		int pos = lista.size();
		SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
		for (RechazadoDTO a : lista) {
			sb.append(a.getNombres() + ",");
			sb.append(a.getApellidos() + ",");
			sb.append(date_format.format(a.getFecha_nacimiento()) + ",");
			sb.append(a.getPais_origen() + ",");
			sb.append(a.getNombre_imagen());
			if (pos == 1) {
				continue;
			} else {
				pos--;
				sb.append("\n");
			}
		}
		FileHandler.escribirArchivo("rechazados.csv", sb.toString());
	}

	@Override
	public void crear(Object obj) {
		lista.add((RechazadoDTO) obj);
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
			lista.set(index, (RechazadoDTO) obj);
			escribirArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String mostrarTodo() {
		if (lista.isEmpty()) {
			return "No existen Rechazados";
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < lista.size(); i++) {
				sb.append("No°" + i + "\n");
				sb.append(lista.get(i).toString());
				sb.append("\n");
			}
			return sb.toString();
		}
	}

}
