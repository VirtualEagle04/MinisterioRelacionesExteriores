package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * Panel que permite mostrar en un listado informacion de los pasajeros extranjeros
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 * @param mostrar_extranjero Lista que contiene la informacion de los pasajeros extranjeros
 * @param barra2 JScrollPane que contiene la lista para permitir el desplazamiento en caso tal de ser muy extensa la informacion
 * @param indice2 Filtro para seleccionar la posicion del pasajero
 * @param busqueda_e Boton para confirmar la busqueda del pasajero
 * @param fuente Objeto que almancena la fuente
 * @param id_ex Indicador del titulo del panel de extranjeros
 */
public class PanelMostrarExtranjeros extends JPanel {

	private JTextArea mostrar_extranjero;
	private JScrollPane barra2;
	private JTextField indice2;
	private JButton busqueda_e;
	private Font fuente;
	private JLabel id_ex;

	public PanelMostrarExtranjeros() {

		setBounds(0, 0, 720, 450);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		fuente = new Font("Consolas", Font.PLAIN, 15);

		id_ex = new JLabel("Lista de Extranjeros");
		id_ex.setBounds(250, 10, 250, 20);
		id_ex.setForeground(Color.BLACK);
		id_ex.setFont(fuente);
		add(id_ex);

		mostrar_extranjero = new JTextArea();
		mostrar_extranjero.setBounds(150, 30, 400, 300);
		mostrar_extranjero.setBackground(new Color(232, 231, 231));
		mostrar_extranjero.setEditable(false);
		mostrar_extranjero.setFont(fuente);
		mostrar_extranjero.setForeground(Color.BLACK);

		barra2 = new JScrollPane();
		barra2.setBounds(150, 30, 400, 300);
		barra2.setViewportView(mostrar_extranjero);
		add(barra2);

		indice2 = new JTextField();
		indice2.setBounds(230, 340, 130, 30);
		indice2.setFont(fuente);
		add(indice2);

		busqueda_e = new JButton("Buscar");
		busqueda_e.setBounds(380, 340, 100, 30);
		busqueda_e.setFocusable(false);
		busqueda_e.setBorderPainted(false);
		add(busqueda_e);

		setVisible(true);

	}

	public JTextArea getMostrar_extranjero() {
		return mostrar_extranjero;
	}

	public void setMostrar_extranjero(JTextArea mostrar_extranjero) {
		this.mostrar_extranjero = mostrar_extranjero;
	}

	public JScrollPane getBarra2() {
		return barra2;
	}

	public void setBarra2(JScrollPane barra2) {
		this.barra2 = barra2;
	}

	public JTextField getIndice2() {
		return indice2;
	}

	public void setIndice2(JTextField indice2) {
		this.indice2 = indice2;
	}

	public JButton getBusqueda_e() {
		return busqueda_e;
	}

	public void setBusqueda_e(JButton busqueda_e) {
		this.busqueda_e = busqueda_e;
	}

	public Font getFuente() {
		return fuente;
	}

	public void setFuente(Font fuente) {
		this.fuente = fuente;
	}

}
