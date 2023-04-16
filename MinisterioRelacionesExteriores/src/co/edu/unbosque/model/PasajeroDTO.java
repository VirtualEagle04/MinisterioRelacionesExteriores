package co.edu.unbosque.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PasajeroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7528421382431875335L;
	private String nombres;
	private String apellidos;
	private Date fecha_nacimiento;
	private String pais_origen;
	private String nombre_imagen;

	public PasajeroDTO() {
		// TODO Auto-generated constructor stub
	}

	public PasajeroDTO(String nombres, String apellidos, Date fecha_nacimiento, String pais_origen, String nombre_imagen) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.pais_origen = pais_origen;
		this.nombre_imagen = nombre_imagen;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getPais_origen() {
		return pais_origen;
	}

	public void setPais_origen(String pais_origen) {
		this.pais_origen = pais_origen;
	}

	public String getNombre_imagen() {
		return nombre_imagen;
	}

	public void setNombre_imagen(String nombre_imagen) {
		this.nombre_imagen = nombre_imagen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
		sb.append("   Nombre completo: "+ getApellidos() + " " + getNombres()+"\n");
		sb.append("   Fecha de Nacimiento: "+ date_format.format(getFecha_nacimiento()) + "\n");
		sb.append("   Pais de Origen: "+ getPais_origen()+"\n");
		sb.append("   Nombre de la Fotografia: "+getNombre_imagen()+"\n");
		sb.append("----------\n");
		return sb.toString();
	}

}
