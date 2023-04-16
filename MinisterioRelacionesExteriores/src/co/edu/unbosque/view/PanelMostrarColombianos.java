package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelMostrarColombianos extends JPanel{

	private JTextArea mostrar_colombiano;
	private JScrollPane barra1;
	private JTextField indice1;
	private JButton busqueda_c;
	private Font fuente;
	private JLabel id_col;
	
	public PanelMostrarColombianos() {
		
		setBounds(0, 0, 720, 450);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		fuente = new Font("Consolas", Font.PLAIN,20);
		
		id_col = new JLabel("Lista de Colombianos");
		id_col.setBounds(250, 10, 250, 20);
		id_col.setForeground(Color.BLACK);
		id_col.setFont(fuente);
		add(id_col);
		
		mostrar_colombiano = new JTextArea();
		mostrar_colombiano.setBounds(150, 30, 400, 300);
		mostrar_colombiano.setBackground(new Color(232, 231, 231));
		mostrar_colombiano.setEditable(false);
		mostrar_colombiano.setFont(fuente);
		mostrar_colombiano.setForeground(Color.BLACK);
		
		barra1 = new JScrollPane();
		barra1.setBounds(150,30,400,300);
		barra1.setViewportView(mostrar_colombiano);
		add(barra1);
		
		indice1 = new JTextField();
		indice1.setBounds(230, 340, 130, 30);
		indice1.setFont(fuente);
		add(indice1);
		
		busqueda_c = new JButton("Buscar");
		busqueda_c.setBounds(380,340,100,30);
		busqueda_c.setFocusable(false);
		busqueda_c.setBorderPainted(false);
		add(busqueda_c);
	
		
		setVisible(true);
	}

	public JTextArea getMostrar_colombiano() {
		return mostrar_colombiano;
	}

	public void setMostrar_colombiano(JTextArea mostrar_colombiano) {
		this.mostrar_colombiano = mostrar_colombiano;
	}

	public JScrollPane getBarra1() {
		return barra1;
	}

	public void setBarra1(JScrollPane barra1) {
		this.barra1 = barra1;
	}

	public JTextField getIndice1() {
		return indice1;
	}

	public void setIndice1(JTextField indice1) {
		this.indice1 = indice1;
	}

	public JButton getBusqueda_c() {
		return busqueda_c;
	}

	public void setBusqueda_c(JButton busqueda_c) {
		this.busqueda_c = busqueda_c;
	}

	public Font getFuente() {
		return fuente;
	}

	public void setFuente(Font fuente) {
		this.fuente = fuente;
	}
	
	
	
}
