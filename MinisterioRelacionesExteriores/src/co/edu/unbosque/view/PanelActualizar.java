package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
/**
 * Panel que contiene los indicadores de registro de los pasajeros.
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 * @param id_nombres2 Indicador de los nombres del pasajero
 * @param id_apellidos2 Indicador de los apellidos del pasajero
 * @param id_fecha2 Indicador de la fecha de nacimiento del pasajero
 * @param id_pais2 Indicador del pais de origen del pasajero
 * @param id_foto2 Indicador del nombre de la foto del pasajero
 * @param id_indice Indicador de la posicion a actualizar
 * @param nombres2 Campo de entrada para los nombres del pasajero
 * @param apellidos2 Campo de entrada para los apellidos del pasajero
 * @param pais_2 Campo de entrada para el pais del pasajero
 * @param fecha_seleccionada2 Campo para la escritura de la fecha seleccionada del calendario
 * @param foto_nombre2 Campo para la escritura del nombre de la foto seleccionada en el FileChooser
 * @param indice Campo para la entrada de la posicion a actualizar
 * @param sel_fecha2 Boton para desplegar el calendario
 * @param confirmar_fecha2 Boton para confirmar la fecha seleccionada en el calendario
 * @param busqueda_foto2 Boton para desplegar el JFileChooser de seleccion de fotos
 * @param confirmar_actualizar Boton para confirmar la actualizacion de un pasajero
 * @param panel_calendario2 Panel que contiene el JCalendar
 * @param panel_boton2 Panel que contiene el boton de confirmar fecha
 * @param panel_selector Panel que contiene el JFileChooser
 * @param fuente2 Objeto que almacena la fuente
 * @param calendario2 JCalendar para la seleccion explicita de la fecha
 * @param selector2 JFileChooser para la seleccion de la imagen
 */
public class PanelActualizar  extends JPanel{

	private JLabel id_nombre2, id_apellido2, id_fecha2, id_pais2, id_foto2, id_indice;
	private JTextField nombres2, apellidos2, fecha_seleccionada2, pais_2, foto_nombre2, indice;
	private JButton sel_fecha2, confirmar_fecha2, busqueda_foto2, confirmar_actualizar;
	private JPanel panel_calendario2, panel_boton2, panel_selector;
	private Font fuente2;
	private JCalendar calendario2;
	private JFileChooser selector2;
	
	
	public PanelActualizar() {

		setBounds(0, 0, 720, 450);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		fuente2 = new Font("Consolas", Font.PLAIN,20);
		
		id_nombre2 = new JLabel("Nombres: ");
		id_nombre2.setBounds(20, 40, 170, 30);
		id_nombre2.setForeground(Color.BLACK);
		id_nombre2.setFont(fuente2);
		add(id_nombre2);
		
		nombres2 = new JTextField();
		nombres2.setBounds(20, 70, 300, 30);
		nombres2.setFont(fuente2);
		add(nombres2);
		

		id_apellido2 = new JLabel("Apellidos: ");
		id_apellido2.setBounds(20, 150, 170, 30);
		id_apellido2.setForeground(Color.BLACK);
		id_apellido2.setFont(fuente2);
		add(id_apellido2);
		
		apellidos2 = new JTextField();
		apellidos2.setBounds(20, 180, 300, 30);
		apellidos2.setFont(fuente2);
		add(apellidos2);
		
		id_pais2 = new JLabel("Pais de Origen: ");
		id_pais2.setBounds(20, 260, 230, 30);
		id_pais2.setForeground(Color.BLACK);
		id_pais2.setFont(fuente2);
		add(id_pais2);
		
		pais_2 = new JTextField();
		pais_2.setBounds(20, 290, 300, 30);
		pais_2.setFont(fuente2);
		add(pais_2);
		
		id_fecha2 = new JLabel("Fecha de Nacimiento: ");
		id_fecha2.setBounds(370, 40, 310, 30);
		id_fecha2.setForeground(Color.BLACK);
		id_fecha2.setFont(fuente2);
		add(id_fecha2);
		
		fecha_seleccionada2 = new JTextField();
		fecha_seleccionada2.setEditable(false);
		fecha_seleccionada2.setBounds(370, 70, 200, 30);
		fecha_seleccionada2.setFont(new Font("Consolas", Font.PLAIN,20 ));
		add(fecha_seleccionada2);
		
		sel_fecha2 = new JButton("Seleccionar");
		sel_fecha2.setBounds(572, 70, 110, 30);
		sel_fecha2.setFocusable(false);
		sel_fecha2.setBorderPainted(false);
		add(sel_fecha2);
		
		panel_boton2 = new JPanel();
		panel_boton2.setBounds(475,310,100,30);
		panel_boton2.setLayout(null);

		
		add(panel_boton2).setVisible(false);
		
		confirmar_fecha2 = new JButton("Confirmar");
		confirmar_fecha2.setBounds(0,0,100,30);
		confirmar_fecha2.setFocusable(false);
		confirmar_fecha2.setBorderPainted(false);
		
		panel_boton2.add(confirmar_fecha2);
		
		panel_calendario2 = new JPanel();
		panel_calendario2.setBounds(370, 98, 313, 250);

		
		add(panel_calendario2).setVisible(false);
		
		calendario2 = new JCalendar();
		calendario2.setPreferredSize(new Dimension(313,200));
		panel_calendario2.add(calendario2);
		
		id_foto2 = new JLabel("Cargar Imagen");
		id_foto2.setBounds(370, 150, 200, 30);
		id_foto2.setForeground(Color.BLACK);
		id_foto2.setFont(fuente2);
		add(id_foto2);
		
		foto_nombre2 = new JTextField();
		foto_nombre2.setBounds(370, 180, 200, 30);
		foto_nombre2.setEditable(false);
		foto_nombre2.setFont(new Font("Consolas", Font.PLAIN,20 ));
		add(foto_nombre2);
		
		busqueda_foto2 = new JButton("Seleccionar");
		busqueda_foto2.setBounds(572, 180, 110, 30);
		busqueda_foto2.setFocusable(false);
		busqueda_foto2.setBorderPainted(false);
		add(busqueda_foto2);
		
		selector2 = new JFileChooser();
		selector2.setDialogTitle("Seleccione Una Foto");
		selector2.setFileSelectionMode(JFileChooser.FILES_ONLY);
		selector2.setBounds(0, 0, 700, 380);
		
		panel_selector = new JPanel();
		panel_selector.setBounds(0, 0, 720, 450);
		panel_selector.setBackground(new Color(0, 0, 0, 0));
		panel_selector.setLayout(null);
		
		panel_selector.add(selector2);
		add(panel_selector).setVisible(false);
		
		id_indice = new JLabel("Posicion a Actualizar");
		id_indice.setBounds(370, 260, 300, 30);
		id_indice.setForeground(Color.BLACK);
		id_indice.setFont(fuente2);
		add(id_indice);
		
		indice = new JTextField();
		indice.setBounds(370, 290, 313, 30);
		indice.setFont(fuente2);
		add(indice);
		
		confirmar_actualizar = new JButton("Actualizar");
		confirmar_actualizar.setBounds(280, 340, 130, 30);
		confirmar_actualizar.setFocusable(false);
		confirmar_actualizar.setBorderPainted(false);
		
		
		add(confirmar_actualizar);
		
	}


	public JLabel getId_nombre2() {
		return id_nombre2;
	}


	public void setId_nombre2(JLabel id_nombre2) {
		this.id_nombre2 = id_nombre2;
	}


	public JLabel getId_apellido2() {
		return id_apellido2;
	}


	public void setId_apellido2(JLabel id_apellido2) {
		this.id_apellido2 = id_apellido2;
	}


	public JLabel getId_fecha2() {
		return id_fecha2;
	}


	public void setId_fecha2(JLabel id_fecha2) {
		this.id_fecha2 = id_fecha2;
	}


	public JLabel getId_pais2() {
		return id_pais2;
	}


	public void setId_pais2(JLabel id_pais2) {
		this.id_pais2 = id_pais2;
	}


	public JLabel getId_foto2() {
		return id_foto2;
	}


	public void setId_foto2(JLabel id_foto2) {
		this.id_foto2 = id_foto2;
	}


	public JLabel getId_indice() {
		return id_indice;
	}


	public void setId_indice(JLabel id_indice) {
		this.id_indice = id_indice;
	}


	public JTextField getNombres2() {
		return nombres2;
	}


	public void setNombres2(JTextField nombres2) {
		this.nombres2 = nombres2;
	}


	public JTextField getApellidos2() {
		return apellidos2;
	}


	public void setApellidos2(JTextField apellidos2) {
		this.apellidos2 = apellidos2;
	}


	public JTextField getFecha_seleccionada2() {
		return fecha_seleccionada2;
	}


	public void setFecha_seleccionada2(JTextField fecha_seleccionada2) {
		this.fecha_seleccionada2 = fecha_seleccionada2;
	}


	public JTextField getPais_2() {
		return pais_2;
	}


	public void setPais_2(JTextField pais_2) {
		this.pais_2 = pais_2;
	}


	public JTextField getFoto_nombre2() {
		return foto_nombre2;
	}


	public void setFoto_nombre2(JTextField foto_nombre2) {
		this.foto_nombre2 = foto_nombre2;
	}


	public JTextField getIndice() {
		return indice;
	}


	public void setIndice(JTextField indice) {
		this.indice = indice;
	}


	public JButton getSel_fecha2() {
		return sel_fecha2;
	}


	public void setSel_fecha2(JButton sel_fecha2) {
		this.sel_fecha2 = sel_fecha2;
	}


	public JButton getConfirmar_fecha2() {
		return confirmar_fecha2;
	}


	public void setConfirmar_fecha2(JButton confirmar_fecha2) {
		this.confirmar_fecha2 = confirmar_fecha2;
	}


	public JButton getBusqueda_foto2() {
		return busqueda_foto2;
	}


	public void setBusqueda_foto2(JButton busqueda_foto2) {
		this.busqueda_foto2 = busqueda_foto2;
	}


	public JButton getConfirmar_actualizar() {
		return confirmar_actualizar;
	}


	public void setConfirmar_actualizar(JButton confirmar_actualizar) {
		this.confirmar_actualizar = confirmar_actualizar;
	}


	public JPanel getPanel_calendario2() {
		return panel_calendario2;
	}


	public void setPanel_calendario2(JPanel panel_calendario2) {
		this.panel_calendario2 = panel_calendario2;
	}


	public JPanel getPanel_boton2() {
		return panel_boton2;
	}


	public void setPanel_boton2(JPanel panel_boton2) {
		this.panel_boton2 = panel_boton2;
	}


	public JPanel getPanel_selector() {
		return panel_selector;
	}


	public void setPanel_selector(JPanel panel_selector) {
		this.panel_selector = panel_selector;
	}


	public Font getFuente2() {
		return fuente2;
	}


	public void setFuente2(Font fuente2) {
		this.fuente2 = fuente2;
	}


	public JCalendar getCalendario2() {
		return calendario2;
	}


	public void setCalendario2(JCalendar calendario2) {
		this.calendario2 = calendario2;
	}


	public JFileChooser getSelector2() {
		return selector2;
	}


	public void setSelector2(JFileChooser selector2) {
		this.selector2 = selector2;
	}
	
	
	
}
