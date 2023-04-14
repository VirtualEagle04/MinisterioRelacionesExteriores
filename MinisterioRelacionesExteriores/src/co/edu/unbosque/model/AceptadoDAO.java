package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.controller.FileHandler;

public class AceptadoDAO implements OperacionesDAO {

	private ArrayList<AceptadoDTO> lista;

	public AceptadoDAO() {
		try {
			lista = cargarArchivo();
		} catch (Exception e) {
			lista = new ArrayList<AceptadoDTO>();
		}
	}

	public ArrayList<AceptadoDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AceptadoDTO> lista) {
		this.lista = lista;
	}

	public ArrayList<AceptadoDTO> cargarArchivo() {
		ArrayList<AceptadoDTO> desde_archivo = new ArrayList<AceptadoDTO>();
		String contenido = FileHandler.abrirArchivoText("aceptados.csv");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attr = linea.split(",");
			String nombres = attr[0];
			String apellidos = attr[1];
			Date fecha_nacimiento = new Date(attr[2]);
			String pais_origen = attr[3];
			String nombre_imagen = attr[4];
			desde_archivo.add(new AceptadoDTO(nombres, apellidos, fecha_nacimiento, pais_origen, nombre_imagen));
		}
		return desde_archivo;
	}

	public void escribirArchivo() {
		StringBuilder sb = new StringBuilder();
		int pos = lista.size();
		SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
		for (AceptadoDTO a : lista) {
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
		FileHandler.escribirArchivo("aceptados.csv", sb.toString());
	}

	@Override
	public void crear(Object obj) {
		lista.add((AceptadoDTO) obj);
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
			lista.set(index, (AceptadoDTO) obj);
			escribirArchivo();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String mostrarTodo() {
		if (lista.isEmpty()) {
			return "No existen Aceptados";
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
