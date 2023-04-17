package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPasaporte extends JPanel {

	private JPanel pasaporte;
	private JLabel imagen_pasaporte,ind_nombre, ind_apellido, ind_fecha, ind_edad, ind_pais, imagen;
	
	public PanelPasaporte() {

		setBounds(0, 0, 720, 450);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		pasaporte = new JPanel();
		pasaporte.setBounds(20, 20, 680, 410);
		pasaporte.setLayout(null);
		add(pasaporte);
		
		imagen_pasaporte = new JLabel(new ImageIcon("src/Assets/istockphoto-1182535081-612x612.jpg"));
		imagen_pasaporte.setBounds(0, 0, 680, 410);
		
		pasaporte.add(imagen_pasaporte);
		
		
		ind_nombre = new JLabel("N");
		add(ind_nombre);
		
		
		ind_apellido = new JLabel("Apellido / Summame");
		add(ind_apellido);
		
		
		ind_fecha = new JLabel("Fecha Nacimiento / Date of bith");
		add(ind_fecha);
		
		ind_edad = new JLabel("Edad Actual / Actual age");
		add(ind_edad);
		
		ind_pais = new JLabel("Pais / Country");
		add(ind_pais);
		
		
		
		setVisible(true);
	
	}

	public JPanel getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(JPanel pasaporte) {
		this.pasaporte = pasaporte;
	}

	public JLabel getImagen_pasaporte() {
		return imagen_pasaporte;
	}

	public void setImagen_pasaporte(JLabel imagen_pasaporte) {
		this.imagen_pasaporte = imagen_pasaporte;
	}

	public JLabel getInd_nombre() {
		return ind_nombre;
	}

	public void setInd_nombre(JLabel ind_nombre) {
		this.ind_nombre = ind_nombre;
	}

	public JLabel getInd_apellido() {
		return ind_apellido;
	}

	public void setInd_apellido(JLabel ind_apellido) {
		this.ind_apellido = ind_apellido;
	}

	public JLabel getInd_fecha() {
		return ind_fecha;
	}

	public void setInd_fecha(JLabel ind_fecha) {
		this.ind_fecha = ind_fecha;
	}

	public JLabel getInd_edad() {
		return ind_edad;
	}

	public void setInd_edad(JLabel ind_edad) {
		this.ind_edad = ind_edad;
	}

	public JLabel getInd_pais() {
		return ind_pais;
	}

	public void setInd_pais(JLabel ind_pais) {
		this.ind_pais = ind_pais;
	}

	public JLabel getImagen() {
		return imagen;
	}

	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
	}

	
	
}
