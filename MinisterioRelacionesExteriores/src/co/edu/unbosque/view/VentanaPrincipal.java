package co.edu.unbosque.view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * 
 * Clase que hereda de JFrame y que contiene todos los paneles donde se mostrara los elementos visuales de la Pokedex.
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 * @param menubar Barra en el menu que contiene las opciones de seleccion.
 * @param agregar Opcion agregar de seleccion
 * @param eliminar Opcion eliminar de seleccion
 * @param actualizar Opcion actualizar de seleccion
 * @param mostrar Opcion mostrar de seleccion
 * @param consultar Opcion consultar de seleccion
 * @param agregar_pasajero Item de seleccion 1
 * @param eliminar_pasajero Item de seleccion 2
 * @param actualziar_pasajero Item de seleccion 3
 * @param consultar_pasajero Item de seleccion 4
 * @param mostrar_colombiano Item de seleccion 5
 * @param mostrar_extranjeros Item de seleccion 6
 * @param panel_agregar Objeto de la clase PanelAgregar
 * @param panel_eliminar Objeto de la clase PanelEliminar
 * @param panel_actualizar Objeto de la clase PanelActualizar
 * @param panel_colombianos Objeto de la clase PanelMostrarColombianos
 * @param panel_extranjeros Objeto de la clase PanelMostrarExtranjeros
 * @param panel_archivos Objecto de la clase PanelSelectorArchivos
 * @param panel_pasaporte Objeto de la clase PanelPasaporte
 */
public class VentanaPrincipal extends JFrame {

	private JMenuBar menubar;
	private JMenu agregar, eliminar, actualizar, mostrar, consultar;
	private JMenuItem agregar_pasajero, eliminar_pasajero, actualizar_pasajero, consultar_pasajero, mostrar_colombiano,
			mostrar_extranjero;
	private PanelAgregar panel_agregar;
	private PanelEliminar panel_eliminar;
	private PanelActualizar panel_actualziar;
	private PanelMostrarColombianos panel_colombianos;
	private PanelMostrarExtranjeros panel_extranjeros;
	private PanelSelectorArchivos panel_archivos;
	private PanelPasaporte panel_pasaporte;

	public VentanaPrincipal() {
		setSize(720, 450);
		setMinimumSize(new Dimension(720, 450));
		setTitle("Ministerio de Relaciones Exteriores");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setFocusable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("src/Assets/MinRelEx_logo.png");
		setIconImage(img.getImage());

		panel_agregar = new PanelAgregar();
		panel_eliminar = new PanelEliminar();
		panel_actualziar = new PanelActualizar();
		panel_colombianos = new PanelMostrarColombianos();
		panel_extranjeros = new PanelMostrarExtranjeros();
		panel_archivos = new PanelSelectorArchivos();
		panel_pasaporte = new PanelPasaporte();
				

		

		menubar = new JMenuBar();
		setJMenuBar(menubar);

		agregar = new JMenu("Agregar");
		eliminar = new JMenu("Eliminar");
		actualizar = new JMenu("Actualizar");
		mostrar = new JMenu("Mostrar");
		consultar = new JMenu("Consultar Archivos");

		agregar_pasajero = new JMenuItem("Agregar Pasajero");
		eliminar_pasajero = new JMenuItem("Eliminar Pasajero");
		actualizar_pasajero = new JMenuItem("Actualizar Pasajero");
		consultar_pasajero = new JMenuItem("Consultar Pasajero");

		mostrar_colombiano = new JMenuItem("Lista de Pasajeros Colombianos");
		mostrar_extranjero = new JMenuItem("Lista de Pasajeros Extranjeros");

		agregar.add(agregar_pasajero);

		eliminar.add(eliminar_pasajero);

		actualizar.add(actualizar_pasajero);

		mostrar.add(mostrar_colombiano);
		mostrar.add(mostrar_extranjero);

		consultar.add(consultar_pasajero);

		menubar.add(agregar);
		menubar.add(eliminar);
		menubar.add(actualizar);
		menubar.add(mostrar);
		menubar.add(consultar);

		add(panel_agregar);
		add(panel_eliminar).setVisible(false);
		add(panel_actualziar).setVisible(false);
		add(panel_colombianos).setVisible(false);
		add(panel_extranjeros).setVisible(false);
		add(panel_archivos).setVisible(false);
		add(panel_pasaporte).setVisible(false);
		setVisible(true);

	}

	
	
	
	public PanelPasaporte getPanel_pasaporte() {
		return panel_pasaporte;
	}




	public void setPanel_pasaporte(PanelPasaporte panel_pasaporte) {
		this.panel_pasaporte = panel_pasaporte;
	}




	public PanelSelectorArchivos getPanel_archivos() {
		return panel_archivos;
	}



	public void setPanel_archivos(PanelSelectorArchivos panel_archivos) {
		this.panel_archivos = panel_archivos;
	}



	public PanelMostrarExtranjeros getPanel_extranjeros() {
		return panel_extranjeros;
	}



	public void setPanel_extranjeros(PanelMostrarExtranjeros panel_extranjeros) {
		this.panel_extranjeros = panel_extranjeros;
	}



	public PanelMostrarColombianos getPanel_colombianos() {
		return panel_colombianos;
	}



	public void setPanel_colombianos(PanelMostrarColombianos panel_colombianos) {
		this.panel_colombianos = panel_colombianos;
	}



	public PanelActualizar getPanel_actualziar() {
		return panel_actualziar;
	}



	public void setPanel_actualziar(PanelActualizar panel_actualziar) {
		this.panel_actualziar = panel_actualziar;
	}



	public PanelEliminar getPanel_eliminar() {
		return panel_eliminar;
	}



	public void setPanel_eliminar(PanelEliminar panel_eliminar) {
		this.panel_eliminar = panel_eliminar;
	}



	public PanelAgregar getPanel_agregar() {
		return panel_agregar;
	}

	public void setPanel_agregar(PanelAgregar panel_agregar) {
		this.panel_agregar = panel_agregar;
	}

	public JMenuItem getAgregar_pasajero() {
		return agregar_pasajero;
	}

	public void setAgregar_pasajero(JMenuItem agregar_pasajero) {
		this.agregar_pasajero = agregar_pasajero;
	}

	public JMenuItem getEliminar_pasajero() {
		return eliminar_pasajero;
	}

	public void setEliminar_pasajero(JMenuItem eliminar_pasajero) {
		this.eliminar_pasajero = eliminar_pasajero;
	}

	public JMenuItem getActualizar_pasajero() {
		return actualizar_pasajero;
	}

	public void setActualizar_pasajero(JMenuItem actualizar_pasajero) {
		this.actualizar_pasajero = actualizar_pasajero;
	}

	public JMenuItem getConsultar_pasajero() {
		return consultar_pasajero;
	}

	public void setConsultar_pasajero(JMenuItem consultar_pasajero) {
		this.consultar_pasajero = consultar_pasajero;
	}

	public JMenu getAgregar() {
		return agregar;
	}

	public void setAgregar(JMenu agregar) {
		this.agregar = agregar;
	}

	public JMenu getEliminar() {
		return eliminar;
	}

	public void setEliminar(JMenu eliminar) {
		this.eliminar = eliminar;
	}

	public JMenu getActualizar() {
		return actualizar;
	}

	public void setActualizar(JMenu actualizar) {
		this.actualizar = actualizar;
	}

	public JMenu getMostrar() {
		return mostrar;
	}

	public void setMostrar(JMenu mostrar) {
		this.mostrar = mostrar;
	}

	public JMenu getConsultar() {
		return consultar;
	}

	public void setConsultar(JMenu consultar) {
		this.consultar = consultar;
	}

	public JMenuItem getMostrar_colombiano() {
		return mostrar_colombiano;
	}

	public void setMostrar_colombiano(JMenuItem mostrar_colombiano) {
		this.mostrar_colombiano = mostrar_colombiano;
	}

	public JMenuItem getMostrar_extranjero() {
		return mostrar_extranjero;
	}

	public void setMostrar_extranjero(JMenuItem mostrar_extranjero) {
		this.mostrar_extranjero = mostrar_extranjero;
	}

}
