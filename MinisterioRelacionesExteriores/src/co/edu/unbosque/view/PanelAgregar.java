package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregar extends JPanel{
	
	private JLabel id_nombres, id_apellidos, id_fecha, id_pais, id_foto;
	private JTextField nombres, apellidos, pais, fecha_seleccionada, foto_nombre;
	private JButton sel_fecha, confirmar_fecha, busqueda_foto, confirmar_agregar;
	private JPanel panel_calendario;
	private Font fuente;
	
	

	public PanelAgregar() {
		setBounds(0, 0, 720, 545);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		fuente = new Font("Consolas", Font.PLAIN, 25);
		
		id_nombres = new JLabel("Nombres: ");
		id_nombres.setBounds(20, 40, 170, 30);
		id_nombres.setForeground(Color.BLACK);
		id_nombres.setFont(fuente);
		add(id_nombres);
		
		nombres = new JTextField();
		nombres.setBounds(20, 70, 300, 30);
		nombres.setFont(fuente);
		add(nombres);
		
		id_apellidos = new JLabel("Apellidos: ");
		id_apellidos.setBounds(20, 150, 170, 30);
		id_apellidos.setForeground(Color.BLACK);
		id_apellidos.setFont(fuente);
		add(id_apellidos);
		
		apellidos = new JTextField();
		apellidos.setBounds(20, 180, 300, 30);
		apellidos.setFont(fuente);
		add(apellidos);
		
		id_pais = new JLabel("Pais de Origen: ");
		id_pais.setBounds(20, 260, 230, 30);
		id_pais.setForeground(Color.BLACK);
		id_pais.setFont(fuente);
		add(id_pais);
		
		pais = new JTextField();
		pais.setBounds(20, 290, 300, 30);
		pais.setFont(fuente);
		add(pais);
		
		id_fecha = new JLabel("Fecha de Nacimiento: ");
		id_fecha.setBounds(370, 40, 310, 30);
		id_fecha.setForeground(Color.BLACK);
		id_fecha.setFont(fuente);
		add(id_fecha);
		
		fecha_seleccionada = new JTextField();
		fecha_seleccionada.setEditable(false);
		fecha_seleccionada.setBounds(370, 70, 200, 30);
		fecha_seleccionada.setFont(fuente);
		add(fecha_seleccionada);
		
		sel_fecha = new JButton("sexo");
		sel_fecha.setBounds(572, 70, 100, 30);
		sel_fecha.setFocusable(false);
		add(sel_fecha);
		
		id_foto = new JLabel("Cargar Imagen");
		id_foto.setBounds(370, 150, 200, 30);
		id_foto.setForeground(Color.BLACK);
		id_foto.setFont(fuente);
		add(id_foto);
		
		foto_nombre = new JTextField();
		foto_nombre.setBounds(370, 180, 200, 30);
		foto_nombre.setEditable(false);
		foto_nombre.setFont(fuente);
		add(foto_nombre);
		
		busqueda_foto = new JButton("sexo");
		busqueda_foto.setBounds(572, 180, 100, 30);
		busqueda_foto.setFocusable(false);
		add(busqueda_foto);
		
		
		
		setVisible(true);
	}
	
}
