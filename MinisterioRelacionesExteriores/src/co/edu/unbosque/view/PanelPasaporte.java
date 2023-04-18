package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPasaporte extends JPanel {

	private JPanel pasaporte;
	private JLabel titulo_es, titulo_en, fondo_pasaporte, ind_nombre, ind_apellido, ind_fecha, ind_edad, ind_pais,
			imagen;
	private JLabel apellidos, nombres, fecha, edad, pais;
	private Font fuente;

	public PanelPasaporte() {

		fuente = new Font("Consolas", Font.PLAIN, 15);

		setBounds(0, 0, 720, 450);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		pasaporte = new JPanel();
		pasaporte.setBounds(35, 35, 630, 310);
		pasaporte.setLayout(null);
		pasaporte.setBackground(Color.LIGHT_GRAY);
		add(pasaporte);

		titulo_es = new JLabel("Identificación Internacional");
		titulo_es.setBounds(210, 10, 270, 20);
		titulo_es.setFont(new Font("Consolas", Font.BOLD, 15));
		titulo_es.setForeground(Color.BLACK);
		pasaporte.add(titulo_es);
		
		titulo_en = new JLabel("International Indentification");
		titulo_en.setBounds(207, 30, 270, 20);
		titulo_en.setFont(new Font("Consolas", Font.BOLD, 15));
		titulo_en.setForeground(Color.BLACK);
		pasaporte.add(titulo_en);

		imagen = new JLabel();
		imagen.setBounds(20, 70, 150, 200);
		imagen.setIcon(new ImageIcon("src/Assets/POpop.jpg"));
		pasaporte.add(imagen);

		ind_apellido = new JLabel("Apellidos / Surnames:");
		ind_apellido.setFont(new Font("Consolas", Font.BOLD, 12));
		ind_apellido.setForeground(Color.BLACK);
		ind_apellido.setBounds(180, 70, 200, 20);
		pasaporte.add(ind_apellido);

		apellidos = new JLabel();
		apellidos.setBounds(180, 85, 210, 20);
		apellidos.setFont(fuente);
		apellidos.setForeground(Color.BLACK);
		pasaporte.add(apellidos);

		ind_nombre = new JLabel("Nombres / Names:");
		ind_nombre.setFont(new Font("Consolas", Font.BOLD, 12));
		ind_nombre.setForeground(Color.BLACK);
		ind_nombre.setBounds(180, 110, 200, 20);
		pasaporte.add(ind_nombre);

		nombres = new JLabel();
		nombres.setBounds(180, 125, 200, 20);
		nombres.setFont(fuente);
		nombres.setForeground(Color.BLACK);
		pasaporte.add(nombres);

		ind_pais = new JLabel("Pais de Origen / Country of Origin:");
		ind_pais.setFont(new Font("Consolas", Font.BOLD, 12));
		ind_pais.setForeground(Color.BLACK);
		ind_pais.setBounds(180, 150, 250, 20);
		pasaporte.add(ind_pais);

		pais = new JLabel();
		pais.setBounds(180, 165, 200, 20);
		pais.setFont(fuente);
		pais.setForeground(Color.BLACK);
		pasaporte.add(pais);

		ind_fecha = new JLabel("Fecha Nacimiento / Date of Birth:");
		ind_fecha.setFont(new Font("Consolas", Font.BOLD, 12));
		ind_fecha.setForeground(Color.BLACK);
		ind_fecha.setBounds(180, 190, 250, 20);
		pasaporte.add(ind_fecha);

		fecha = new JLabel();
		fecha.setBounds(180, 205, 200, 20);
		fecha.setFont(fuente);
		fecha.setForeground(Color.BLACK);
		pasaporte.add(fecha);

		ind_edad = new JLabel("Edad Actual / Age:");
		ind_edad.setFont(new Font("Consolas", Font.BOLD, 12));
		ind_edad.setForeground(Color.BLACK);
		ind_edad.setBounds(180, 230, 200, 20);
		pasaporte.add(ind_edad);

		edad = new JLabel();
		edad.setBounds(180, 245, 290, 20);
		edad.setFont(fuente);
		edad.setForeground(Color.BLACK);
		pasaporte.add(edad);

		fondo_pasaporte = new JLabel(new ImageIcon("src/Assets/bg_pasaporte.jpg"));
		fondo_pasaporte.setBounds(0, 0, 630, 310);
		pasaporte.add(fondo_pasaporte);

		setVisible(true);

	}

	public JLabel getApellidos() {
		return apellidos;
	}

	public void setApellidos(JLabel apellidos) {
		this.apellidos = apellidos;
	}

	public JLabel getNombres() {
		return nombres;
	}

	public void setNombres(JLabel nombres) {
		this.nombres = nombres;
	}

	public JLabel getFecha() {
		return fecha;
	}

	public void setFecha(JLabel fecha) {
		this.fecha = fecha;
	}

	public JLabel getEdad() {
		return edad;
	}

	public void setEdad(JLabel edad) {
		this.edad = edad;
	}

	public JLabel getPais() {
		return pais;
	}

	public void setPais(JLabel pais) {
		this.pais = pais;
	}

	public Font getFuente() {
		return fuente;
	}

	public void setFuente(Font fuente) {
		this.fuente = fuente;
	}

	public JPanel getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(JPanel pasaporte) {
		this.pasaporte = pasaporte;
	}

	public JLabel getTitulo_es() {
		return titulo_es;
	}

	public void setTitulo_es(JLabel titulo_es) {
		this.titulo_es = titulo_es;
	}

	public JLabel getTitulo_en() {
		return titulo_en;
	}

	public void setTitulo_en(JLabel titulo_en) {
		this.titulo_en = titulo_en;
	}

	public JLabel getFondo_pasaporte() {
		return fondo_pasaporte;
	}

	public void setFondo_pasaporte(JLabel fondo_pasaporte) {
		this.fondo_pasaporte = fondo_pasaporte;
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
