package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelEliminar extends JPanel {

	private JLabel id_eliminar;
	private JTextField eliminar;
	private JButton confirmar_eliminar;
	private Font fuente;
	
	public PanelEliminar() {
		setBounds(0, 0, 720, 450);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		fuente = new Font("Consolas", Font.PLAIN, 20);
		
		id_eliminar = new JLabel("Digite la posicion a eliminar");
		id_eliminar.setBounds(190, 40, 330, 30);
		id_eliminar.setForeground(Color.BLACK);
		id_eliminar.setFont(fuente);
		add(id_eliminar);
		
		eliminar = new JTextField();
		eliminar.setBounds(250,140,190,40);
		eliminar.setFont(fuente);
		add(eliminar);
		
		confirmar_eliminar = new JButton("Eliminar");
		confirmar_eliminar.setBounds(260,260,170,30);
		confirmar_eliminar.setFocusable(false);
		confirmar_eliminar.setBorderPainted(false);
		add(confirmar_eliminar);
		
		setVisible(true);
		
		
		
	}

	public JLabel getId_eliminar() {
		return id_eliminar;
	}

	public void setId_eliminar(JLabel id_eliminar) {
		this.id_eliminar = id_eliminar;
	}

	public JTextField getEliminar() {
		return eliminar;
	}

	public void setEliminar(JTextField eliminar) {
		this.eliminar = eliminar;
	}

	public JButton getConfirmar_eliminar() {
		return confirmar_eliminar;
	}

	public void setConfirmar_eliminar(JButton confirmar_eliminar) {
		this.confirmar_eliminar = confirmar_eliminar;
	}

	public Font getFuente() {
		return fuente;
	}

	public void setFuente(Font fuente) {
		this.fuente = fuente;
	}
	
	
	
	
}
