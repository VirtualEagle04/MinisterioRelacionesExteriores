package co.edu.unbosque.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame{
	
	private JMenuBar menubar;
	private JMenu agregar, eliminar, actualizar, mostrar, consultar;
	private JMenuItem mostrar_colombiano, mostrar_extranjero;
	private PanelAgregar panel_agregar;
	
	public VentanaPrincipal() {
		setSize(720, 540);
		setMinimumSize(new Dimension(720, 540));
		setTitle("Ministerio de Relaciones Exteriores");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(true);
		setFocusable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		agregar = new JMenu("Agregar");
		eliminar = new JMenu("Eliminar");
		actualizar = new JMenu("Actualizar");
		mostrar = new JMenu("Mostrar");
		consultar = new JMenu("Consultar Archivos");
		mostrar_colombiano = new JMenuItem("Lista de Pasajeros Colombianos");
		mostrar_extranjero = new JMenuItem("Lista de Pasajeros Extranjeros");
		
		mostrar.add(mostrar_colombiano);
		mostrar.add(mostrar_extranjero);
		
		menubar.add(agregar);
		menubar.add(eliminar);
		menubar.add(actualizar);
		menubar.add(mostrar);
		menubar.add(consultar);
		
		panel_agregar = new PanelAgregar();
		add(panel_agregar);
		
		
		setVisible(true);
		
	}
	
	
}
