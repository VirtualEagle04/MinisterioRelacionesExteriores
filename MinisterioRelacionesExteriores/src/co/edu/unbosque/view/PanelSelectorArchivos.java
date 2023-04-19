package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 * Panel que permite a la seleccion de archivos mediante un JFileChooser
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 * @param archivos Selector de archivos
 * @param p1 Panel que contiene el selector de archivos
 */
public class PanelSelectorArchivos extends JPanel{

	private JFileChooser archivos;
	private JPanel p1;
	
	public PanelSelectorArchivos() {
		
		setBounds(0, 0, 720, 450);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		
		p1 = new JPanel();
		p1.setBounds(0, 0, 720, 450);
		p1.setBackground(Color.LIGHT_GRAY);
		add(p1);
		
		archivos = new JFileChooser();
		archivos.setDialogTitle("Seleccione un archivo");
		archivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
		archivos.setBounds(0, 0, 720, 450);
//		p1.add(archivos);
		
		
		setVisible(true);
	}

	public JFileChooser getArchivos() {
		return archivos;
	}

	public void setArchivos(JFileChooser archivos) {
		this.archivos = archivos;
	}

	public JPanel getP1() {
		return p1;
	}

	public void setP1(JPanel p1) {
		this.p1 = p1;
	}
	
	
	
}
