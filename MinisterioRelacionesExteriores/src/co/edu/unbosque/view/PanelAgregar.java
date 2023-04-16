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



public class PanelAgregar extends JPanel{
	
	private JLabel id_nombres, id_apellidos, id_fecha, id_pais, id_foto;
	private JTextField nombres, apellidos, pais, fecha_seleccionada, foto_nombre;
	private JButton sel_fecha, confirmar_fecha, busqueda_foto, confirmar_agregar;
	private JPanel panel_calendario, panel_boton, panel_selecctor;
	private Font fuente;
	private JCalendar calendario;
	private JFileChooser selector;
	

	public PanelAgregar() {
		setBounds(0, 0, 720, 450);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		fuente = new Font("Consolas", Font.PLAIN, 20);
		
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
		fecha_seleccionada.setFont(new Font("Consolas", Font.PLAIN,20 ));
		add(fecha_seleccionada);
		
		sel_fecha = new JButton("Seleccionar");
		sel_fecha.setBounds(572, 70, 110, 30);
		sel_fecha.setFocusable(false);
		sel_fecha.setBorderPainted(false);
		add(sel_fecha);
		
		panel_boton = new JPanel();
		panel_boton.setBounds(475,310,100,30);
		panel_boton.setLayout(null);
		panel_boton.setBackground(Color.RED);
		
		add(panel_boton).setVisible(false);
		
		
		confirmar_fecha = new JButton("Confirmar");
		confirmar_fecha.setBounds(0,0,100,30);
		confirmar_fecha.setFocusable(false);
		confirmar_fecha.setBorderPainted(false);
		confirmar_fecha.setContentAreaFilled(false);
		
		panel_boton.add(confirmar_fecha);
		
		
		panel_calendario = new JPanel();
		panel_calendario.setBounds(370, 98, 313, 250);

		
		add(panel_calendario).setVisible(false);

		
		calendario = new JCalendar();
		calendario.setPreferredSize(new Dimension(313,200));
		panel_calendario.add(calendario);
		
		
		id_foto = new JLabel("Cargar Imagen");
		id_foto.setBounds(370, 150, 200, 30);
		id_foto.setForeground(Color.BLACK);
		id_foto.setFont(fuente);
		add(id_foto);
		
		foto_nombre = new JTextField();
		foto_nombre.setBounds(370, 180, 200, 30);
		foto_nombre.setEditable(false);
		foto_nombre.setFont(new Font("Consolas", Font.PLAIN,20 ));
		add(foto_nombre);
		
		busqueda_foto = new JButton("Seleccionar");
		busqueda_foto.setBounds(572, 180, 110, 30);
		busqueda_foto.setFocusable(false);
		busqueda_foto.setBorderPainted(false);
		add(busqueda_foto);
		
		
		selector = new JFileChooser();
		selector.setDialogTitle("Seleccione Una Foto");
		selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
		selector.setBounds(0, 0, 700, 380);
		
		panel_selecctor = new JPanel();
		panel_selecctor.setBounds(0, 0, 720, 450);
		panel_selecctor.setBackground(new Color(0, 0, 0, 0));
		panel_selecctor.setLayout(null);
		
		panel_selecctor.add(selector);
		add(panel_selecctor).setVisible(false);
		
		
		confirmar_agregar = new JButton("Agregar");
		confirmar_agregar.setBounds(460, 290, 110, 30);
		confirmar_agregar.setFocusable(false);
		confirmar_agregar.setBorderPainted(false);
		
		
		add(confirmar_agregar);

		
		
		
		setVisible(true);
	}


	public JLabel getId_nombres() {
		return id_nombres;
	}


	public void setId_nombres(JLabel id_nombres) {
		this.id_nombres = id_nombres;
	}


	public JLabel getId_apellidos() {
		return id_apellidos;
	}


	public void setId_apellidos(JLabel id_apellidos) {
		this.id_apellidos = id_apellidos;
	}


	public JLabel getId_fecha() {
		return id_fecha;
	}


	public void setId_fecha(JLabel id_fecha) {
		this.id_fecha = id_fecha;
	}


	public JLabel getId_pais() {
		return id_pais;
	}


	public void setId_pais(JLabel id_pais) {
		this.id_pais = id_pais;
	}


	public JLabel getId_foto() {
		return id_foto;
	}


	public void setId_foto(JLabel id_foto) {
		this.id_foto = id_foto;
	}


	public JTextField getNombres() {
		return nombres;
	}


	public void setNombres(JTextField nombres) {
		this.nombres = nombres;
	}


	public JTextField getApellidos() {
		return apellidos;
	}


	public void setApellidos(JTextField apellidos) {
		this.apellidos = apellidos;
	}


	public JTextField getPais() {
		return pais;
	}


	public void setPais(JTextField pais) {
		this.pais = pais;
	}


	public JTextField getFecha_seleccionada() {
		return fecha_seleccionada;
	}


	public void setFecha_seleccionada(JTextField fecha_seleccionada) {
		this.fecha_seleccionada = fecha_seleccionada;
	}


	public JTextField getFoto_nombre() {
		return foto_nombre;
	}


	public void setFoto_nombre(JTextField foto_nombre) {
		this.foto_nombre = foto_nombre;
	}


	public JButton getSel_fecha() {
		return sel_fecha;
	}


	public void setSel_fecha(JButton sel_fecha) {
		this.sel_fecha = sel_fecha;
	}


	public JButton getConfirmar_fecha() {
		return confirmar_fecha;
	}


	public void setConfirmar_fecha(JButton confirmar_fecha) {
		this.confirmar_fecha = confirmar_fecha;
	}


	public JButton getBusqueda_foto() {
		return busqueda_foto;
	}


	public void setBusqueda_foto(JButton busqueda_foto) {
		this.busqueda_foto = busqueda_foto;
	}


	public JButton getConfirmar_agregar() {
		return confirmar_agregar;
	}


	public void setConfirmar_agregar(JButton confirmar_agregar) {
		this.confirmar_agregar = confirmar_agregar;
	}


	public JPanel getPanel_calendario() {
		return panel_calendario;
	}


	public void setPanel_calendario(JPanel panel_calendario) {
		this.panel_calendario = panel_calendario;
	}


	public JPanel getPanel_boton() {
		return panel_boton;
	}


	public void setPanel_boton(JPanel panel_boton) {
		this.panel_boton = panel_boton;
	}


	public JPanel getPanel_selecctor() {
		return panel_selecctor;
	}


	public void setPanel_selecctor(JPanel panel_selecctor) {
		this.panel_selecctor = panel_selecctor;
	}


	public Font getFuente() {
		return fuente;
	}


	public void setFuente(Font fuente) {
		this.fuente = fuente;
	}


	public JCalendar getCalendario() {
		return calendario;
	}


	public void setCalendario(JCalendar calendario) {
		this.calendario = calendario;
	}


	public JFileChooser getSelector() {
		return selector;
	}


	public void setSelector(JFileChooser selector) {
		this.selector = selector;
	}
	
	
	
	
	
}
