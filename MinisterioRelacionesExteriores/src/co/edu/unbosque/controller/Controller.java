package co.edu.unbosque.controller;

import java.util.Date;

import co.edu.unbosque.model.AceptadoDAO;
import co.edu.unbosque.model.AceptadoDTO;
import co.edu.unbosque.model.PasajeroDAO;
import co.edu.unbosque.model.PasajeroDTO;
import co.edu.unbosque.model.RechazadoDAO;
import co.edu.unbosque.model.RechazadoDTO;
import co.edu.unbosque.view.Consola;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller {

	private VentanaPrincipal vp;
	private PasajeroDAO pdao;
	private Consola con;
	private AceptadoDAO adao;
	private RechazadoDAO rdao;
	private String[] paises_vetados = { "Rusia", "Corea del Norte", "Guinea Ecuatorial", "Somalia", "Australia" };

	public Controller() {
		pdao = new PasajeroDAO();
		adao = new AceptadoDAO();
		rdao = new RechazadoDAO();
		con = new Consola();
		vp = new VentanaPrincipal();
		

	}

	public void run() {
		ppal: while (true) {
			con.printErrorSalto("Accion: ");
			con.printSalto("1) Crear\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Salir");
			int op = con.leerInt();
			switch (op) {
			case 1: {
				con.quemarLinea();
				con.printSinSalto("Nombres: ");
				String nombres = con.leerNextLine();
				con.printSinSalto("Apellidos: ");
				String apellidos = con.leerNextLine();
				con.printSinSalto("Fecha de Nacimiento: ");
				Date fecha = new Date(con.leerNextLine());
				con.printSinSalto("Pais de Origen: ");
				String pais = con.leerNextLine();
				con.printSinSalto("Nombre del archivo de la foto del pasaporte: ");
				String pasaporte = con.leerNextLine();

				PasajeroDTO p = new PasajeroDTO(nombres, apellidos, fecha, pais, pasaporte);
				boolean rechazado = false;
				for (String pais_vetado : paises_vetados) {
					if (pais.equalsIgnoreCase(pais_vetado)) {
						rdao.crear(new RechazadoDTO(nombres, apellidos, fecha, pais, pasaporte));
						rechazado = true;
						break;
					}
				}
				if (rechazado == false) {
					adao.crear(new AceptadoDTO(nombres, apellidos, fecha, pais, pasaporte));
				}
				pdao.getLista().clear();
				pdao.agregarAceptado(adao.getLista());
				pdao.agregarRechazado(rdao.getLista());
				break;
			}
			case 2: {
				con.printSinSalto("Posicion a eliminar: ");
				int index = con.leerInt();
				if (pdao.eliminar(index)) {
					con.printErrorSalto("Eliminado correctamente.");
				} else {
					con.printErrorSalto("Error en la eliminacion.");
				}

				break;
			}
			case 3: {
				con.quemarLinea();
				con.printSinSalto("Nombres: ");
				String nombre = con.leerNextLine();
				con.printSinSalto("Apellidos: ");
				String apellidos = con.leerNextLine();
				con.printSinSalto("Fecha de Nacimiento: ");
				Date fecha = new Date(con.leerNextLine());
				con.printSinSalto("Pais de Origen: ");
				String pais = con.leerNextLine();
				con.printSinSalto("Nombre del archivo de la foto del pasaporte: ");
				String pasaporte = con.leerNextLine();
				con.printSinSalto("Posicion a eliminar: ");
				int index = con.leerInt();

				if (pdao.actualizar(index, new PasajeroDTO(nombre, apellidos, fecha, pais, pasaporte))) {
					con.printErrorSalto("Actualizado correctamente.");
				} else {
					con.printErrorSalto("Error en la eliminacion.");
				}

				break;
			}
			case 4: {
				con.printSalto(pdao.mostrarTodo());
				break;
			}

			case 5: {
				break ppal;
			}

			default:

			}

		}
		con.printErrorSalto("Fin del Programa");
	}

}
