package co.edu.unbosque.controller;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import javax.swing.filechooser.FileFilter;

import co.edu.unbosque.model.AceptadoDAO;
import co.edu.unbosque.model.AceptadoDTO;
import co.edu.unbosque.model.PasajeroDAO;
import co.edu.unbosque.model.PasajeroDTO;
import co.edu.unbosque.model.RechazadoDAO;
import co.edu.unbosque.model.RechazadoDTO;
import co.edu.unbosque.util.exceptions.CaracterInvalidoException;
import co.edu.unbosque.util.exceptions.NumeroIncorrectoException;
import co.edu.unbosque.util.exceptions.NumeroInvalidoException;
import co.edu.unbosque.util.exceptions.NumeroNegativoException;
import co.edu.unbosque.util.exceptions.PaisInexistenteException;
import co.edu.unbosque.view.VentanaPrincipal;

/**
 * Establece la l�gica entre la interfaz de usuario y las representaciones
 * planetadas en el modelo.
 * 
 * @author Federico Vargas Rozo, Juan Esteban Quintero
 * @param vp                    Objeto de la clase VentanaPrincipal
 * @param pdao                  Objeto de la clase PasajeroDAO
 * @param adao                  Objeto de la clase AceptadoDAO
 * @param rdao                  Objeto de la clase RechazadoDAO
 * @param paises_vetados        Array con los nombres de los paises vetados
 * @param paises                ArrayList con los nombres de todos los paises
 *                              del mundo
 * @param nombre_temp           Variable temporal para almacenar el nombre de
 *                              entrada
 * @param apellidos_temp        Variable temporal para almacenar el apellido de
 *                              entrada
 * @param pais_temp             Variable temporal para almancenar el pais de
 *                              entrada
 * @param fecha_temp            Variable temporal para almacenar la fecha de
 *                              entrada
 * @param nombre_foto_temp      Variable temporal para almancenar el nombre de
 *                              la foto seleccionada
 * @param nombre_foto_pasaporte Variable temporal para almancenar el nombre de
 *                              la foto seleccionada
 * @param fecha2                Variable que funciona como conversion de la
 *                              fecha temporal al formato Date
 * @param eliminar              Variables temporal para almancenar la posicion a
 *                              eliminar
 * @param actualizar            Variables temporal para almancenar la posicion a
 *                              actualizar
 * @param posicion              Variables temporal para almancenar la posicion a
 *                              mostrar
 */

public class Controller implements ActionListener, ComponentListener {

	private VentanaPrincipal vp;
	private PasajeroDAO pdao;
	private AceptadoDAO adao;
	private RechazadoDAO rdao;
	private String[] paises_vetados = { "Rusia", "Corea del Norte", "Guinea Ecuatorial", "Somalia", "Australia" };
	private ArrayList<String> paises;

	private String nombres_temp, apellidos_temp, pais_temp, fecha_temp, nombre_foto_temp, nombre_foto_pasaporte;
	private Date fecha2;
	private int eliminar, actualizar, posicion;

	public Controller() {
		vp = new VentanaPrincipal();
		pdao = new PasajeroDAO();
		adao = new AceptadoDAO();
		rdao = new RechazadoDAO();

		agregarLectores();

		paises = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoText("paises.csv");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String nombre_pais = linea;
			paises.add(nombre_pais);
		}

	}

	/**
	 * Se llama cuando el componente con un ComponentListener es redimensionado.
	 */
	@Override
	public void componentResized(ComponentEvent e) {

		Dimension nuevas_dim = e.getComponent().getSize();

		// PanelPasaporte
		vp.getPanel_pasaporte().setSize(nuevas_dim);
		// JPanel pasaporte
		vp.getPanel_pasaporte().getPasaporte().setSize(nuevas_dim.width - 90, nuevas_dim.height - 140);
		// JLabel fondo_pasaporte
		vp.getPanel_pasaporte().getFondo_pasaporte().setSize(vp.getPanel_pasaporte().getPasaporte().getSize());
		// Redimensi�n setIcon de fondo_pasaporte
		ImageIcon imageIcon = null;
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/Assets/bg_pasaporte.jpg"));
		} catch (IOException e2) {
		}
		Image dimg = img.getScaledInstance(nuevas_dim.width - 90, nuevas_dim.height - 140, Image.SCALE_FAST);
		imageIcon = new ImageIcon(dimg);
		// Actualizacion del tama�o fondo_pasaporte setIcon
		vp.getPanel_pasaporte().getFondo_pasaporte().setIcon(imageIcon);

		// Componentes
		vp.getPanel_pasaporte().getTitulo_es().setLocation((nuevas_dim.width / 2) - 150, 10);
		vp.getPanel_pasaporte().getTitulo_en().setLocation((nuevas_dim.width / 2) - 153, 30);
		vp.getPanel_pasaporte().getInd_apellido().setLocation((nuevas_dim.width / 2) - 180, 70);
		vp.getPanel_pasaporte().getApellidos().setLocation((nuevas_dim.width / 2) - 180, 85);
		vp.getPanel_pasaporte().getInd_nombre().setLocation((nuevas_dim.width / 2) - 180, 110);
		vp.getPanel_pasaporte().getNombres().setLocation((nuevas_dim.width / 2) - 180, 125);
		vp.getPanel_pasaporte().getInd_pais().setLocation((nuevas_dim.width / 2) - 180, 150);
		vp.getPanel_pasaporte().getPais().setLocation((nuevas_dim.width / 2) - 180, 165);
		vp.getPanel_pasaporte().getInd_fecha().setLocation((nuevas_dim.width / 2) - 180, 190);
		vp.getPanel_pasaporte().getFecha().setLocation((nuevas_dim.width / 2) - 180, 205);
		vp.getPanel_pasaporte().getInd_edad().setLocation((nuevas_dim.width / 2) - 180, 230);
		vp.getPanel_pasaporte().getEdad().setLocation((nuevas_dim.width / 2) - 180, 245);

		// JLabel imagen
		vp.getPanel_pasaporte().getImagen().setSize(vp.getPanel_pasaporte().getApellidos().getLocation().x - 30,
				nuevas_dim.height - 250);

		// Redimension ImageIcon de imagen
		int nueva_alt = vp.getPanel_pasaporte().getImagen().getHeight();
		int nuevo_anch = vp.getPanel_pasaporte().getImagen().getWidth();

		ImageIcon imageIcon2 = null;
		BufferedImage img2 = null;
		try {
			img2 = ImageIO.read(new File("src/UserImages/" + nombre_foto_pasaporte));
		} catch (IOException e2) {
		}
		Image dimg2 = img2.getScaledInstance(nuevo_anch, nueva_alt, Image.SCALE_FAST);
		imageIcon2 = new ImageIcon(dimg2);
		// Actualizacion del tama�o fondo_pasaporte setIcon
		vp.getPanel_pasaporte().getImagen().setIcon(imageIcon2);

	}

	/**
	 * Se crean los lectores para que todo JButton, JTextField y JList, permitan la
	 * lectura.
	 */
	public void agregarLectores() {

		vp.addComponentListener(this);

		vp.getAgregar_pasajero().addActionListener(this);
		vp.getAgregar_pasajero().setActionCommand("Agregar");

		vp.getEliminar_pasajero().addActionListener(this);
		vp.getEliminar_pasajero().setActionCommand("Eliminar");

		vp.getActualizar_pasajero().addActionListener(this);
		vp.getActualizar_pasajero().setActionCommand("Actualizar");

		vp.getMostrar_colombiano().addActionListener(this);
		vp.getMostrar_colombiano().setActionCommand("Mostrar_colombiano");

		vp.getMostrar_extranjero().addActionListener(this);
		vp.getMostrar_extranjero().setActionCommand("Mostrar_extranjero");

		vp.getConsultar_pasajero().addActionListener(this);
		vp.getConsultar_pasajero().setActionCommand("Consultar");
//		____________________________________________________________

		vp.getPanel_agregar().getSel_fecha().addActionListener(this);
		vp.getPanel_agregar().getSel_fecha().setActionCommand("Seleccionar_fecha");

		vp.getPanel_agregar().getConfirmar_fecha().addActionListener(this);
		vp.getPanel_agregar().getConfirmar_fecha().setActionCommand("Confirmar_fecha");

		vp.getPanel_agregar().getBusqueda_foto().addActionListener(this);
		vp.getPanel_agregar().getBusqueda_foto().setActionCommand("Seleccionar_foto");

		vp.getPanel_agregar().getSelector().addActionListener(this);
		vp.getPanel_agregar().getSelector().setApproveButtonText("Seleccionar");

		vp.getPanel_agregar().getConfirmar_agregar().addActionListener(this);
		vp.getPanel_agregar().getConfirmar_agregar().setActionCommand("Confirmar_agregar");

//		______________________________________________________________

		vp.getPanel_eliminar().getConfirmar_eliminar().addActionListener(this);
		vp.getPanel_eliminar().getConfirmar_eliminar().setActionCommand("Confirmar_eliminar");

//		______________________________________________________________

		vp.getPanel_actualziar().getSel_fecha2().addActionListener(this);
		vp.getPanel_actualziar().getSel_fecha2().setActionCommand("Seleccionar_fecha2");

		vp.getPanel_actualziar().getConfirmar_fecha2().addActionListener(this);
		vp.getPanel_actualziar().getConfirmar_fecha2().setActionCommand("Confirmar_fecha2");

		vp.getPanel_actualziar().getBusqueda_foto2().addActionListener(this);
		vp.getPanel_actualziar().getBusqueda_foto2().setActionCommand("Seleccionar_foto2");

		vp.getPanel_actualziar().getSelector2().addActionListener(this);
		vp.getPanel_actualziar().getSelector2().setApproveButtonText("Seleccionar2");

		vp.getPanel_actualziar().getConfirmar_actualizar().addActionListener(this);
		vp.getPanel_actualziar().getConfirmar_actualizar().setActionCommand("Confirmar_actualizar");

//		__________________________________________________________________

		vp.getPanel_colombianos().getBusqueda_c().addActionListener(this);
		vp.getPanel_colombianos().getBusqueda_c().setActionCommand("Busqueda_c");

		vp.getPanel_extranjeros().getBusqueda_e().addActionListener(this);
		vp.getPanel_extranjeros().getBusqueda_e().setActionCommand("Busqueda_e");
	}

	/**
	 * Se llama cuando se presiona un JButton previamente inicializado. Establece
	 * los comandos y la funcionalidad de cada elemento interactivo.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "Agregar": {

			vp.getPanel_agregar().setVisible(true);
			vp.getPanel_eliminar().setVisible(false);
			vp.getPanel_actualziar().setVisible(false);
			vp.getPanel_colombianos().setVisible(false);
			vp.getPanel_extranjeros().setVisible(false);
			vp.getPanel_archivos().setVisible(false);

			break;
		}
		case "Eliminar": {

			vp.getPanel_agregar().setVisible(false);
			vp.getPanel_eliminar().setVisible(true);
			vp.getPanel_actualziar().setVisible(false);
			vp.getPanel_colombianos().setVisible(false);
			vp.getPanel_extranjeros().setVisible(false);
			vp.getPanel_archivos().setVisible(false);

			break;
		}
		case "Actualizar": {

			vp.getPanel_agregar().setVisible(false);
			vp.getPanel_eliminar().setVisible(false);
			vp.getPanel_actualziar().setVisible(true);
			vp.getPanel_colombianos().setVisible(false);
			vp.getPanel_extranjeros().setVisible(false);
			vp.getPanel_archivos().setVisible(false);

			break;
		}
		case "Mostrar_colombiano": {

			vp.getPanel_agregar().setVisible(false);
			vp.getPanel_eliminar().setVisible(false);
			vp.getPanel_actualziar().setVisible(false);
			vp.getPanel_colombianos().setVisible(true);
			vp.getPanel_extranjeros().setVisible(false);
			vp.getPanel_archivos().setVisible(false);

			vp.getPanel_colombianos().getMostrar_colombiano().setText(pdao.mostrarColombiano());

			break;
		}
		case "Mostrar_extranjero": {

			vp.getPanel_agregar().setVisible(false);
			vp.getPanel_eliminar().setVisible(false);
			vp.getPanel_actualziar().setVisible(false);
			vp.getPanel_colombianos().setVisible(false);
			vp.getPanel_extranjeros().setVisible(true);
			vp.getPanel_archivos().setVisible(false);

			vp.getPanel_extranjeros().getMostrar_extranjero().setText(pdao.mostrarExtranjero());

			break;
		}
		case "Consultar": {

			vp.getPanel_agregar().setVisible(false);
			vp.getPanel_eliminar().setVisible(false);
			vp.getPanel_actualziar().setVisible(false);
			vp.getPanel_colombianos().setVisible(false);
			vp.getPanel_extranjeros().setVisible(false);
			vp.getPanel_archivos().getP1().setVisible(true);
//			

			String ruta = System.getProperty("user.dir");
			File ruta_directorio = new File(ruta);
			vp.getPanel_archivos().getArchivos().setCurrentDirectory(ruta_directorio);

			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos CSV", "csv");
			vp.getPanel_archivos().getArchivos().setFileFilter(filtro);

			int seleccion = vp.getPanel_archivos().getArchivos().showOpenDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {

				File archivo = vp.getPanel_archivos().getArchivos().getSelectedFile();
				try {
					Desktop.getDesktop().open(archivo);
				} catch (IOException e2) {
					e2.printStackTrace();
				}

			} else {

				JOptionPane.showMessageDialog(null, "No selecciono ningun archivo");
			}
			break;
		}
		case "Seleccionar_fecha": {

			vp.getPanel_agregar().setVisible(true);
			vp.getPanel_agregar().getPanel_boton().setVisible(true);
			vp.getPanel_agregar().getPanel_calendario().setVisible(true);
			vp.getPanel_agregar().getConfirmar_agregar().setVisible(false);

			break;
		}
		case "Confirmar_fecha": {

			if (vp.getPanel_agregar().getCalendario().getCalendar() != null) {

				Calendar fecha_seleccionada = vp.getPanel_agregar().getCalendario().getCalendar();

				int dia = fecha_seleccionada.get(Calendar.DAY_OF_MONTH);
				int mes = fecha_seleccionada.get(Calendar.MONTH) + 1;
				int anio = fecha_seleccionada.get(Calendar.YEAR);

				LocalDate fecha_nacimiento = LocalDate.of(anio, mes, dia);
				LocalDate fecha_actual = LocalDate.now();

				Period periodo = Period.between(fecha_nacimiento, fecha_actual);

				int dias = periodo.getDays();
				int meses = periodo.getMonths();
				int anios = periodo.getYears();

				int dias_totales = anios * 365 + meses * 30 + dias;

				for (int i = fecha_nacimiento.getYear(); i <= fecha_actual.getYear(); i++) {

					if (Year.of(i).isLeap()) {

						LocalDate primer_dia_anio = LocalDate.of(i, mes, dia);
						if (primer_dia_anio.isAfter(fecha_nacimiento) || primer_dia_anio.isEqual(fecha_nacimiento)
								&& (primer_dia_anio.isBefore(fecha_actual) || primer_dia_anio.isEqual(fecha_actual))) {

							dias_totales++;

						}
					}

				}

				int meses_totales = (anios * 12) + meses;

				fecha_temp = dia + "/" + mes + "/" + anio;

				vp.getPanel_agregar().getFecha_seleccionada().setText(fecha_temp);

			}

			vp.getPanel_agregar().getPanel_boton().setVisible(false);
			vp.getPanel_agregar().getPanel_calendario().setVisible(false);
			vp.getPanel_agregar().getConfirmar_agregar().setVisible(true);

			break;
		}

		case "Seleccionar_foto": {

			vp.getPanel_agregar().setVisible(true);

			File directorio = FileSystemView.getFileSystemView().getDefaultDirectory();
			File directorio_f = new File(directorio, "Imagenes");

			vp.getPanel_agregar().getSelector().setCurrentDirectory(directorio_f);
			vp.getPanel_agregar().getSelector().setFileSelectionMode(JFileChooser.FILES_ONLY);

//			break;
		}
		case "Seleccionar": {

			FileFilter filtro = new FileFilter() {

				@Override
				public boolean accept(File archivo) {

					if (archivo.isDirectory()) {
						return true;
					}

					String extension = obtenerExtencion(archivo);
					if (extension != null) {
						return extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png");
					}

					return false;
				}

				@Override
				public String getDescription() {

					return "Imagenes (*.jpg, *.jpeg, *.png)";
				}

			};

			vp.getPanel_agregar().getSelector().setFileFilter(filtro);
			vp.getPanel_agregar().setVisible(true);

			int resultado = vp.getPanel_agregar().getSelector().showOpenDialog(null);

			if (resultado == JFileChooser.APPROVE_OPTION) {

				File archivo_s = vp.getPanel_agregar().getSelector().getSelectedFile();
				String nombre_foto = archivo_s.getName();

				nombre_foto_temp = nombre_foto;

				vp.getPanel_agregar().getFoto_nombre().setText(nombre_foto_temp);

				ImageIcon imagen = new ImageIcon(archivo_s.getAbsolutePath());

				int ancho_definido = 121;
				int alto_definido = 161;

				Image nueva_medida = imagen.getImage().getScaledInstance(ancho_definido, alto_definido,
						Image.SCALE_SMOOTH);
				ImageIcon imagen_redimensionada = new ImageIcon(nueva_medida);

				// llamar al metodo del panel donde se adjunta la foto

			}

			break;
		}
		case "Confirmar_agregar": {

			int validacion = 0;

			if (vp.getPanel_agregar().getNombres().getText().isEmpty()) {

				vp.getPanel_agregar().getNombres().setText("");

			} else {

				try {

					nombres_temp = vp.getPanel_agregar().getNombres().getText();
					if (nombres_temp.matches("(.*)[0-9](.*)")) {

						throw new NumeroInvalidoException();
					}
					if (nombres_temp.matches("^[a-zA-Z ]+$") == false) {

						throw new CaracterInvalidoException();
					}

				} catch (NumeroInvalidoException e2) {

					JOptionPane.showMessageDialog(null,
							"Ha ingresado un dato numerico" + "\nMotivo: " + e2.getMessage() + "\nVuelva a intentarlo");
					validacion--;
				} catch (CaracterInvalidoException e3) {

					JOptionPane.showMessageDialog(null, "Ha ingresado un caracter especial" + "\nMotivo: "
							+ e3.getMessage() + "\nVuelva a intentarlo");
					validacion--;

				}

				validacion++;
			}

			if (vp.getPanel_agregar().getApellidos().getText().isEmpty()) {

				vp.getPanel_agregar().getApellidos().setText("");
			} else {

				try {
					apellidos_temp = vp.getPanel_agregar().getApellidos().getText();

					if (apellidos_temp.matches("(.*)[0-9](.*)")) {

						throw new NumeroInvalidoException();
					}
					if (apellidos_temp.matches("^[a-zA-Z ]+$") == false) {

						throw new CaracterInvalidoException();
					}

				} catch (NumeroInvalidoException e2) {

					JOptionPane.showMessageDialog(null,
							"Ha ingresado un dato numerico" + "\nMotivo: " + e2.getMessage() + "\nVuelva a intentarlo");
					validacion--;
				} catch (CaracterInvalidoException e3) {

					JOptionPane.showMessageDialog(null, "Ha ingresado un caracter especial" + "\nMotivo: "
							+ e3.getMessage() + "\nVuelva a intentarlo");
					validacion--;

				}

				validacion++;

			}

			if (vp.getPanel_agregar().getPais().getText().isEmpty()) {

				vp.getPanel_agregar().getPais().setText("");
			} else {

				try {

					pais_temp = vp.getPanel_agregar().getPais().getText();

					if (pais_temp.matches("(.*)[0-9](.*)")) {

						throw new NumeroInvalidoException();
					}
					if (pais_temp.matches("^[a-zA-Z ]+$") == false) {

						throw new CaracterInvalidoException();
					}
					boolean existe = false;
					for (String pais : paises) {
						if (pais_temp.equalsIgnoreCase(pais)) {
							existe = true;
							break;
						}
					}
					if (existe == false) {
						throw new PaisInexistenteException();
					}

				} catch (NumeroInvalidoException e2) {

					JOptionPane.showMessageDialog(null,
							"Ha ingresado un dato numerico" + "\nMotivo: " + e2.getMessage() + "\nVuelva a intentarlo");
					validacion--;
				} catch (CaracterInvalidoException e3) {

					JOptionPane.showMessageDialog(null, "Ha ingresado un caracter especial" + "\nMotivo: "
							+ e3.getMessage() + "\nVuelva a intentarlo");
					validacion--;

				} catch (PaisInexistenteException e4) {

					JOptionPane.showMessageDialog(null, "\nMotivo: " + e4.getMessage() + "\nVuelva a intentarlo");
					validacion--;

				}

				validacion++;

			}

			if (vp.getPanel_agregar().getFecha_seleccionada().getText().isEmpty()) {
				vp.getPanel_agregar().getFecha_seleccionada().setText("");
				JOptionPane.showMessageDialog(null, "No selecciono ninguna fecha");
				validacion--;
			} else {

				fecha_temp = vp.getPanel_agregar().getFecha_seleccionada().getText();

				validacion++;
			}

			if (vp.getPanel_agregar().getFoto_nombre().getText().isEmpty()) {
				vp.getPanel_agregar().getFoto_nombre().setText("");
				JOptionPane.showMessageDialog(null, "No selecciono ninguna imagen");
				validacion--;
			} else {

				nombre_foto_temp = vp.getPanel_agregar().getFoto_nombre().getText();
				validacion++;
			}

			if (validacion == 5) {

				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

				try {
					fecha2 = formato.parse(fecha_temp);

				} catch (Exception e2) {
					// TODO: handle exception
				}

				if (pais_temp.equalsIgnoreCase("colombia")) {

					vp.getPanel_colombianos().getMostrar_colombiano().setText("");

					String datos = pdao.mostrarColombiano() + "\n";
					vp.getPanel_colombianos().getMostrar_colombiano().append(datos);

				} else {

					vp.getPanel_extranjeros().getMostrar_extranjero().setText("");

					String datos = pdao.mostrarExtranjero() + "\n";
					vp.getPanel_extranjeros().getMostrar_extranjero().append(datos);

				}

				PasajeroDTO p = new PasajeroDTO(nombres_temp, apellidos_temp, fecha2, pais_temp, nombre_foto_temp);
				boolean rechazado = false;
				for (String pais_vetado : paises_vetados) {
					if (pais_temp.equalsIgnoreCase(pais_vetado)) {

						rdao.crear(new RechazadoDTO(nombres_temp, apellidos_temp, fecha2, pais_temp, nombre_foto_temp));
						rechazado = true;
						break;
					}
				}

				if (rechazado == false) {
					adao.crear(new AceptadoDTO(nombres_temp, apellidos_temp, fecha2, pais_temp, nombre_foto_temp));
				}

				pdao.getLista().clear();
				pdao.agregarAceptado(adao.getLista());
				pdao.agregarRechazado(rdao.getLista());

				File temp_foto = new File("src/UserImages/" + nombre_foto_temp);
				String extension = nombre_foto_temp.substring(nombre_foto_temp.lastIndexOf(".") + 1);
				BufferedImage image = null;
				try {
					image = ImageIO.read(vp.getPanel_agregar().getSelector().getSelectedFile());
					ImageIO.write(image, extension, temp_foto);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Error en alguna digitacion");
			}
			vp.getPanel_agregar().getNombres().setText("");
			vp.getPanel_agregar().getApellidos().setText("");
			vp.getPanel_agregar().getPais().setText("");
			vp.getPanel_agregar().getFecha_seleccionada().setText("");
			vp.getPanel_agregar().getFoto_nombre().setText("");

			break;
		}
		case "Confirmar_eliminar": {

			try {

				eliminar = Integer.parseInt(vp.getPanel_eliminar().getEliminar().getText());

				if (eliminar < 0) {

					throw new NumeroNegativoException();

				}

			} catch (NumeroNegativoException e2) {

				JOptionPane.showMessageDialog(null,
						"Se ingreso un numero negativo" + "\nMotivo" + e2.getMessage() + "\nVuelva a intentarlo");

			} catch (NumberFormatException e3) {

				try {
					throw new NumeroIncorrectoException();
				} catch (NumeroIncorrectoException e2) {

					JOptionPane.showMessageDialog(null,
							"Se ingreso dato no numerico" + "\nMotivo" + e2.getMessage() + "\nVuelva a intentarlo");
				}

				vp.getPanel_eliminar().getEliminar().setText("");

			}

			if (pdao.eliminar(eliminar)) {

				JOptionPane.showMessageDialog(null, "Eliminado correctamente");

			} else {
				JOptionPane.showMessageDialog(null, "Error en la eliminacion");

			}

			adao.getLista().clear();
			rdao.getLista().clear();
			for (PasajeroDTO p : pdao.getLista()) {

				boolean rechazado = false;
				for (String pais_vetado : paises_vetados) {

					if (p.getPais_origen().equalsIgnoreCase(pais_vetado)) {
						rdao.crear((RechazadoDTO) p);
						rechazado = true;

						break;
					}

				}
				if (rechazado == false) {
					adao.crear((AceptadoDTO) p);

				}

				if (p.getPais_origen().equalsIgnoreCase("colombia")) {

					vp.getPanel_colombianos().getMostrar_colombiano().setText("");

					String datos = pdao.mostrarColombiano() + "\n";
					vp.getPanel_colombianos().getMostrar_colombiano().append(datos);

				} else {

					vp.getPanel_extranjeros().getMostrar_extranjero().setText("");
					String datos = pdao.mostrarExtranjero() + "\n";
					vp.getPanel_extranjeros().getMostrar_extranjero().append(datos);
				}

			}
			adao.escribirArchivo();
			rdao.escribirArchivo();
			vp.getPanel_eliminar().getEliminar().setText("");

			break;
		}
		case "Seleccionar_fecha2": {

			vp.getPanel_actualziar().setVisible(true);
			vp.getPanel_actualziar().getPanel_boton2().setVisible(true);
			vp.getPanel_actualziar().getPanel_calendario2().setVisible(true);
			vp.getPanel_actualziar().getIndice().setVisible(false);

			break;
		}
		case "Confirmar_fecha2": {

			if (vp.getPanel_actualziar().getCalendario2().getCalendar() != null) {

				Calendar fecha_seleccionada = vp.getPanel_actualziar().getCalendario2().getCalendar();

				int dia = fecha_seleccionada.get(Calendar.DAY_OF_MONTH);
				int mes = fecha_seleccionada.get(Calendar.MONTH) + 1;
				int anio = fecha_seleccionada.get(Calendar.YEAR);

				LocalDate fecha_nacimiento = LocalDate.of(anio, mes, dia);
				LocalDate fecha_actual = LocalDate.now();

				Period periodo = Period.between(fecha_nacimiento, fecha_actual);

				int dias = periodo.getDays();
				int meses = periodo.getMonths();
				int anios = periodo.getYears();

				int dias_totales = anios * 365 + meses * 30 + dias;

				for (int i = fecha_nacimiento.getYear(); i <= fecha_actual.getYear(); i++) {

					if (Year.of(i).isLeap()) {

						LocalDate primer_dia_anio = LocalDate.of(i, mes, dia);
						if (primer_dia_anio.isAfter(fecha_nacimiento) || primer_dia_anio.isEqual(fecha_nacimiento)
								&& (primer_dia_anio.isBefore(fecha_actual) || primer_dia_anio.isEqual(fecha_actual))) {

							dias_totales++;

						}
					}

				}

				int meses_totales = (anios * 12) + meses;

				fecha_temp = dia + "/" + mes + "/" + anio;

//				adjuntar, dias y meses totales junto a anios a una variable que contenga la edad total
				vp.getPanel_actualziar().getFecha_seleccionada2().setText(fecha_temp);

			}

			vp.getPanel_actualziar().getPanel_boton2().setVisible(false);
			vp.getPanel_actualziar().getPanel_calendario2().setVisible(false);
			vp.getPanel_actualziar().getIndice().setVisible(true);

			break;
		}
		case "Seleccionar_foto2": {

			vp.getPanel_actualziar().setVisible(true);

			File directorio = FileSystemView.getFileSystemView().getDefaultDirectory();
			File directorio_f = new File(directorio, "Imagenes");

			vp.getPanel_actualziar().getSelector2().setCurrentDirectory(directorio_f);
			vp.getPanel_actualziar().getSelector2().setFileSelectionMode(JFileChooser.FILES_ONLY);

		}
		case "Seleccionar2": {

			FileFilter filtro = new FileFilter() {

				@Override
				public boolean accept(File archivo) {

					if (archivo.isDirectory()) {
						return true;
					}

					String extension = obtenerExtencion(archivo);
					if (extension != null) {
						return extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png");
					}

					return false;
				}

				@Override
				public String getDescription() {

					return "Imagenes (*.jpg, *.jpeg, *.png)";
				}

			};

			vp.getPanel_actualziar().getSelector2().setFileFilter(filtro);
			vp.getPanel_actualziar().setVisible(true);

			int resultado = vp.getPanel_actualziar().getSelector2().showOpenDialog(null);

			if (resultado == JFileChooser.APPROVE_OPTION) {

				File archivo_s = vp.getPanel_actualziar().getSelector2().getSelectedFile();
				String nombre_foto = archivo_s.getName();

				nombre_foto_temp = nombre_foto;

				vp.getPanel_actualziar().getFoto_nombre2().setText(nombre_foto_temp);

				ImageIcon imagen = new ImageIcon(archivo_s.getAbsolutePath());

				int ancho_definido = 121;
				int alto_definido = 161;

				Image nueva_medida = imagen.getImage().getScaledInstance(ancho_definido, alto_definido,
						Image.SCALE_SMOOTH);
				ImageIcon imagen_redimensionada = new ImageIcon(nueva_medida);

				// llamar al metodo del panel donde se adjunta la foto

			}
			break;
		}
		case "Confirmar_actualizar": {

			int validacion = 0;

			if (vp.getPanel_actualziar().getNombres2().getText().isEmpty()) {

				vp.getPanel_actualziar().getNombres2().setText("");

			} else {

				try {

					nombres_temp = vp.getPanel_actualziar().getNombres2().getText();
					if (nombres_temp.matches("(.*)[0-9](.*)")) {

						throw new NumeroInvalidoException();
					}
					if (nombres_temp.matches("^[a-zA-Z ]+$") == false) {

						throw new CaracterInvalidoException();
					}

				} catch (NumeroInvalidoException e2) {

					JOptionPane.showMessageDialog(null,
							"Ha ingresado un dato numerico" + "\nMotivo: " + e2.getMessage() + "\nVuelva a intentarlo");
					validacion--;
				} catch (CaracterInvalidoException e3) {

					JOptionPane.showMessageDialog(null, "Ha ingresado un caracter especial" + "\nMotivo: "
							+ e3.getMessage() + "\nVuelva a intentarlo");
					validacion--;

				}

				validacion++;
			}

			if (vp.getPanel_actualziar().getApellidos2().getText().isEmpty()) {

				vp.getPanel_actualziar().getApellidos2().setText("");
			} else {

				try {
					apellidos_temp = vp.getPanel_actualziar().getApellidos2().getText();

					if (apellidos_temp.matches("(.*)[0-9](.*)")) {

						throw new NumeroInvalidoException();
					}
					if (apellidos_temp.matches("^[a-zA-Z ]+$") == false) {

						throw new CaracterInvalidoException();
					}

				} catch (NumeroInvalidoException e2) {

					JOptionPane.showMessageDialog(null,
							"Ha ingresado un dato numerico" + "\nMotivo: " + e2.getMessage() + "\nVuelva a intentarlo");
					validacion--;
				} catch (CaracterInvalidoException e3) {

					JOptionPane.showMessageDialog(null, "Ha ingresado un caracter especial" + "\nMotivo: "
							+ e3.getMessage() + "\nVuelva a intentarlo");
					validacion--;

				}

				validacion++;

			}

			if (vp.getPanel_actualziar().getPais_2().getText().isEmpty()) {

				vp.getPanel_actualziar().getPais_2().setText("");
			} else {

				try {

					pais_temp = vp.getPanel_actualziar().getPais_2().getText();

					if (pais_temp.matches("(.*)[0-9](.*)")) {

						throw new NumeroInvalidoException();
					}
					if (pais_temp.matches("^[a-zA-Z ]+$") == false) {

						throw new CaracterInvalidoException();
					}
					boolean existe = false;
					for (String pais : paises) {
						if (pais_temp.equalsIgnoreCase(pais)) {
							existe = true;
							break;
						}
					}
					if (existe == false) {
						throw new PaisInexistenteException();
					}

				} catch (NumeroInvalidoException e2) {

					JOptionPane.showMessageDialog(null,
							"Ha ingresado un dato numerico" + "\nMotivo: " + e2.getMessage() + "\nVuelva a intentarlo");
					validacion--;
				} catch (CaracterInvalidoException e3) {

					JOptionPane.showMessageDialog(null, "Ha ingresado un caracter especial" + "\nMotivo: "
							+ e3.getMessage() + "\nVuelva a intentarlo");
					validacion--;

				} catch (PaisInexistenteException e4) {

					JOptionPane.showMessageDialog(null, "\nMotivo: " + e4.getMessage() + "\nVuelva a intentarlo");
					validacion--;

				}

				validacion++;

			}

			if (vp.getPanel_actualziar().getFecha_seleccionada2().getText().isEmpty()) {

				vp.getPanel_actualziar().getFecha_seleccionada2().setText("");
				JOptionPane.showMessageDialog(null, "No selecciono ninguna fecha");
				validacion--;
			} else {

				fecha_temp = vp.getPanel_actualziar().getFecha_seleccionada2().getText();

				validacion++;
			}

			if (vp.getPanel_actualziar().getFoto_nombre2().getText().isEmpty()) {
				vp.getPanel_actualziar().getFoto_nombre2().setText("");
				JOptionPane.showMessageDialog(null, "No selecciono ninguna imagen");
				validacion--;
			} else {

				nombre_foto_temp = vp.getPanel_actualziar().getFoto_nombre2().getText();
				validacion++;
			}

			if (vp.getPanel_actualziar().getIndice().getText().isEmpty()) {
				vp.getPanel_actualziar().getIndice().setText("");

			} else {
				try {

					actualizar = Integer.parseInt(vp.getPanel_actualziar().getIndice().getText());

					if (actualizar < 0) {

						throw new NumeroNegativoException();
					}

				} catch (NumeroNegativoException e2) {

					JOptionPane.showMessageDialog(null,
							"Se ingreso un numero negativo" + "\nMotivo" + e2.getMessage() + "\nVuelva a intentarlo");
					validacion--;

				} catch (NumberFormatException e3) {

					try {
						throw new NumeroIncorrectoException();
					} catch (NumeroIncorrectoException e2) {

						JOptionPane.showMessageDialog(null,
								"Se ingreso dato no numerico" + "\nMotivo" + e2.getMessage() + "\nVuelva a intentarlo");
						validacion--;
					}

				}
				validacion++;
			}

			if (validacion == 6) {

				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

				try {
					fecha2 = formato.parse(fecha_temp);

					System.out.println(formato.format(fecha2));

				} catch (Exception e2) {
					// TODO: handle exception
				}

				if (pdao.actualizar(actualizar,
						new PasajeroDTO(nombres_temp, apellidos_temp, fecha2, pais_temp, nombre_foto_temp))) {

					if (pais_temp.equalsIgnoreCase("colombia")) {

						vp.getPanel_colombianos().getMostrar_colombiano().setText("");

						String datos = pdao.mostrarColombiano() + "\n";
						vp.getPanel_colombianos().getMostrar_colombiano().append(datos);

					} else {

						vp.getPanel_extranjeros().getMostrar_extranjero().setText("");
						String datos = pdao.mostrarExtranjero() + "\n";
						vp.getPanel_extranjeros().getMostrar_extranjero().append(datos);
					}

					JOptionPane.showMessageDialog(null, "Actualizado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Error en la actualizacion");
				}

				adao.getLista().clear();
				rdao.getLista().clear();

				for (PasajeroDTO p : pdao.getLista()) {
					boolean rechazado = false;
					for (String pais_vetado : paises_vetados) {

						if (p.getPais_origen().equalsIgnoreCase(pais_vetado)) {

							rdao.crear(new RechazadoDTO(p.getNombres(), p.getApellidos(), p.getFecha_nacimiento(),
									p.getPais_origen(), p.getNombre_imagen()));
							rechazado = true;
							break;
						}
					}
					if (rechazado == false) {
						adao.crear(new AceptadoDTO(p.getNombres(), p.getApellidos(), p.getFecha_nacimiento(),
								p.getPais_origen(), p.getNombre_imagen()));

					}
				}

				pdao.getLista().clear();
				pdao.agregarAceptado(adao.getLista());
				pdao.agregarRechazado(rdao.getLista());

				adao.escribirArchivo();
				rdao.escribirArchivo();

				File temp_foto = new File("src/UserImages/" + nombre_foto_temp);
				String extension = nombre_foto_temp.substring(nombre_foto_temp.lastIndexOf(".") + 1);
				BufferedImage image = null;
				try {
					image = ImageIO.read(vp.getPanel_agregar().getSelector().getSelectedFile());
					ImageIO.write(image, extension, temp_foto);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} else {

				JOptionPane.showMessageDialog(null, "Error en alguna digitacion");
			}

			vp.getPanel_actualziar().getNombres2().setText("");
			vp.getPanel_actualziar().getApellidos2().setText("");
			vp.getPanel_actualziar().getPais_2().setText("");
			vp.getPanel_actualziar().getFecha_seleccionada2().setText("");
			vp.getPanel_actualziar().getFoto_nombre2().setText("");
			vp.getPanel_actualziar().getIndice().setText("");

			break;
		}
		case "Busqueda_c": {

			if (vp.getPanel_colombianos().getIndice1().getText().isEmpty()) {

			}

			try {

				posicion = Integer.parseInt(vp.getPanel_colombianos().getIndice1().getText());

				if (posicion < 0) {

					throw new NumeroNegativoException();

				}
				SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
				vp.getPanel_pasaporte().getNombres().setText(pdao.getLista().get(posicion).getNombres());
				vp.getPanel_pasaporte().getApellidos().setText(pdao.getLista().get(posicion).getApellidos());
				vp.getPanel_pasaporte().getPais().setText(pdao.getLista().get(posicion).getPais_origen());
				vp.getPanel_pasaporte().getFecha()
						.setText(date_format.format(pdao.getLista().get(posicion).getFecha_nacimiento()));

				Date fecha_temp = pdao.getLista().get(posicion).getFecha_nacimiento();
				Calendar cal = Calendar.getInstance();
				cal.setTime(fecha_temp);

				int dia = cal.get(Calendar.DAY_OF_MONTH);
				int mes = cal.get(Calendar.MONTH) + 1;
				int anio = cal.get(Calendar.YEAR);

				LocalDate fecha_nacimiento = LocalDate.of(anio, mes, dia);
				LocalDate fecha_actual = LocalDate.now();

				Period periodo = Period.between(fecha_nacimiento, fecha_actual);

				int dias = periodo.getDays();
				int meses = periodo.getMonths();
				int anios = periodo.getYears();

				int dias_totales = anios * 365 + meses * 30 + dias;

				for (int i = fecha_nacimiento.getYear(); i <= fecha_actual.getYear(); i++) {

					if (Year.of(i).isLeap()) {

						LocalDate primer_dia_anio = LocalDate.of(i, mes, dia);
						if (primer_dia_anio.isAfter(fecha_nacimiento) || primer_dia_anio.isEqual(fecha_nacimiento)
								&& (primer_dia_anio.isBefore(fecha_actual) || primer_dia_anio.isEqual(fecha_actual))) {

							dias_totales++;

						}
					}

				}

				int meses_totales = (anios * 12) + meses;

				vp.getPanel_pasaporte().getEdad()
						.setText(anios + "/A�os o " + meses_totales + "/Meses o " + dias_totales + "/Dias");

				ImageIcon imageIcon = null;
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File("src/UserImages/" + pdao.getLista().get(posicion).getNombre_imagen()));
				} catch (IOException e2) {
				}
				Image dimg = img.getScaledInstance(150, 200, Image.SCALE_FAST);
				imageIcon = new ImageIcon(dimg);

				vp.getPanel_pasaporte().getImagen().setIcon(imageIcon);

				nombre_foto_pasaporte = pdao.getLista().get(posicion).getNombre_imagen();

				vp.getPanel_pasaporte().setVisible(true);
				vp.getPanel_agregar().setVisible(false);
				vp.getPanel_eliminar().setVisible(false);
				vp.getPanel_actualziar().setVisible(false);
				vp.getPanel_colombianos().setVisible(false);
				vp.getPanel_extranjeros().setVisible(false);
				vp.getPanel_archivos().setVisible(false);
				vp.setResizable(true);

			} catch (NumeroNegativoException e2) {

				JOptionPane.showMessageDialog(null,
						"Se ingreso un numero negativo" + "\nMotivo" + e2.getMessage() + "\nVuelva a intentarlo");

			} catch (NumberFormatException e3) {

				try {
					throw new NumeroIncorrectoException();
				} catch (NumeroIncorrectoException e2) {

					JOptionPane.showMessageDialog(null,
							"Se ingreso dato no numerico" + "\nMotivo" + e2.getMessage() + "\nVuelva a intentarlo");
				}

				vp.getPanel_colombianos().getIndice1().setText("");

			}

			break;
		}
		case "Busqueda_e": {

			if (vp.getPanel_extranjeros().getIndice2().getText().isEmpty()) {

			}

			try {

				posicion = Integer.parseInt(vp.getPanel_extranjeros().getIndice2().getText());

				if (posicion < 0) {

					throw new NumeroNegativoException();

				}
				SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
				vp.getPanel_pasaporte().getNombres().setText(pdao.getLista().get(posicion).getNombres());
				vp.getPanel_pasaporte().getApellidos().setText(pdao.getLista().get(posicion).getApellidos());
				vp.getPanel_pasaporte().getPais().setText(pdao.getLista().get(posicion).getPais_origen());
				vp.getPanel_pasaporte().getFecha()
						.setText(date_format.format(pdao.getLista().get(posicion).getFecha_nacimiento()));

				Date fecha_temp = pdao.getLista().get(posicion).getFecha_nacimiento();
				Calendar cal = Calendar.getInstance();
				cal.setTime(fecha_temp);

				int dia = cal.get(Calendar.DAY_OF_MONTH);
				int mes = cal.get(Calendar.MONTH) + 1;
				int anio = cal.get(Calendar.YEAR);

				LocalDate fecha_nacimiento = LocalDate.of(anio, mes, dia);
				LocalDate fecha_actual = LocalDate.now();

				Period periodo = Period.between(fecha_nacimiento, fecha_actual);

				int dias = periodo.getDays();
				int meses = periodo.getMonths();
				int anios = periodo.getYears();

				int dias_totales = anios * 365 + meses * 30 + dias;

				for (int i = fecha_nacimiento.getYear(); i <= fecha_actual.getYear(); i++) {

					if (Year.of(i).isLeap()) {

						LocalDate primer_dia_anio = LocalDate.of(i, mes, dia);
						if (primer_dia_anio.isAfter(fecha_nacimiento) || primer_dia_anio.isEqual(fecha_nacimiento)
								&& (primer_dia_anio.isBefore(fecha_actual) || primer_dia_anio.isEqual(fecha_actual))) {

							dias_totales++;

						}
					}

				}

				int meses_totales = (anios * 12) + meses;

				vp.getPanel_pasaporte().getEdad()
						.setText(anios + "/A�os o " + meses_totales + "/Meses o " + dias_totales + "/Dias");

				ImageIcon imageIcon2 = null;
				BufferedImage img2 = null;
				try {
					img2 = ImageIO.read(new File("src/UserImages/" + pdao.getLista().get(posicion).getNombre_imagen()));
				} catch (IOException e2) {
				}
				Image dimg2 = img2.getScaledInstance(150, 200, Image.SCALE_FAST);
				imageIcon2 = new ImageIcon(dimg2);

				vp.getPanel_pasaporte().getImagen().setIcon(imageIcon2);

				nombre_foto_pasaporte = pdao.getLista().get(posicion).getNombre_imagen();

				vp.getPanel_pasaporte().setVisible(true);
				vp.getPanel_agregar().setVisible(false);
				vp.getPanel_eliminar().setVisible(false);
				vp.getPanel_actualziar().setVisible(false);
				vp.getPanel_colombianos().setVisible(false);
				vp.getPanel_extranjeros().setVisible(false);
				vp.getPanel_archivos().setVisible(false);
				vp.setResizable(true);

			} catch (NumeroNegativoException e2) {

				JOptionPane.showMessageDialog(null,
						"Se ingreso un numero negativo" + "\nMotivo" + e2.getMessage() + "\nVuelva a intentarlo");

			} catch (NumberFormatException e3) {

				try {
					throw new NumeroIncorrectoException();
				} catch (NumeroIncorrectoException e2) {

					JOptionPane.showMessageDialog(null,
							"Se ingreso dato no numerico" + "\nMotivo" + e2.getMessage() + "\nVuelva a intentarlo");
				}

				vp.getPanel_extranjeros().getIndice2().setText("");

			}

			break;
		}

		default:
			break;
		}

	}

	/**
	 * Metodo para obetener la extension de las fotos a cargar.
	 * @param archivo Archivo que se selecciona para filtrar si corresponde o no los parametros establecidos
	 * @return Retorna la extension del archivo.
	 */
	private String obtenerExtencion(File archivo) {

		String nombre_a = archivo.getName();
		int indice = nombre_a.lastIndexOf('.');
		return indice > 0 ? nombre_a.substring(indice + 1).toLowerCase() : null;

	}

	@Override
	public void componentMoved(ComponentEvent e) {
	}

	@Override
	public void componentShown(ComponentEvent e) {
	}

	@Override
	public void componentHidden(ComponentEvent e) {
	}

}
