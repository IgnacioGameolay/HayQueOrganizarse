import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.*;

public class Main {
	
  //* Muestra el menú principal de la agenda con las opciones disponibles.
	
	private static void MostrarMenu() {
		System.out.println("=== Menú de la Agenda ===");
		System.out.println("1. Agregar un evento");
		System.out.println("2. Mostrar todos los eventos");
		System.out.println("3. Editar evento por ID");
		System.out.println("4. Buscar eventos por día");
		System.out.println("5. Buscar eventos por semana");
		System.out.println("6. Buscar eventos por mes");
		System.out.println("7. Buscar eventos por etiqueta");
		System.out.println("8. Generar reporte de eventos");
		System.out.println("9. Salir");
		System.out.println("10. Filtrar eventos");
		System.out.println("=========================");
		System.out.print("Elige una opción: ");
	}
	
	//* Función principal que inicia la ejecución del programa.
	//* @param args Argumentos de la línea de comandos.
	//* @throws IOException Manejo de excepciones de entrada y salida.

	public static void main(String[] args) throws IOException {
		//Inicio del main

		//Definicion de variables
		Agenda agenda = Agenda.getInstancia(); // Crear una nueva agenda

		agenda.inicializarEventosDePrueba(); // Inicializar eventos de prueba
		 // Crear el JFrame (ventana)
                JFrame frame = new JFrame("Menú Principal");

                // Crear una instancia del JPanel (MenuPrincipal)
                MenuPrincipal menuPanel = new MenuPrincipal();

                // Añadir el JPanel al JFrame
                frame.add(menuPanel);

                // Establecer las propiedades del JFrame
                frame.setSize(1280, 720);  // Ajusta el tamaño según tus necesidades
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cierra la aplicación al cerrar la ventana
                frame.setVisible(true);  // Hacer visible la ventana
                        
                        
                    
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		
		//Bucle del menu
		String opcion = "";
		int idBuscado, diaBuscado, id;
		String anioBuscado, mesBuscado;
		do {
			limpiarPantalla();
			MostrarMenu();
			opcion = lector.readLine();
			
			//Switch de opciones
			switch (opcion){
				case "1":
					//Crear evento
					System.out.println("=========================");
					System.out.println("Creando evento...");
					System.out.println("=========================");
                                        //SwingUtilities.invokeLater(() -> {JOptionPane.showInputDialog(null, "waka");});
                                        
					String idStr = JOptionPane.showInputDialog(null, "Ingrese el id del evento:", "Agregar Evento", JOptionPane.QUESTION_MESSAGE);
					if (idStr == null) break; // En caso de que se cancele el diálogo
					try {
					    id = Integer.parseInt(idStr);
					} catch (NumberFormatException e) {
					    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero", "Error", JOptionPane.ERROR_MESSAGE);
					    break;
					}
                                        System.out.println("No funca");
	
/*		
					} catch (IOException e) {
						System.out.println("Error al leer la entrada. Intente de nuevo");
						presioneTeclaParaContinuar();
						break;
					}

*/
					String titulo = JOptionPane.showInputDialog(null, "Ingrese el título del evento:", "Agregar Evento", JOptionPane.QUESTION_MESSAGE);
					if (titulo == null) break; // En caso de que se cancele el diálogo
					String descripcion = JOptionPane.showInputDialog(null, "Ingrese la descripción del evento:", "Agregar Evento", JOptionPane.QUESTION_MESSAGE);
					if (descripcion == null) break;

					//Ingresar datos de fecha
					LocalDateTime fechaInicio;
					while (true) {
						System.out.print("Ingrese la fecha de inicio del evento (dd/MM/yyyy): ");
						String fechaInicioStr = lector.readLine();

						String horaInicioStr;
						while (true) {
							System.out.print("Ingrese la hora de inicio del evento (HH:mm en formato 24 hrs): ");
							horaInicioStr = lector.readLine();
							if (horaValida(horaInicioStr)) break;
							else System.out.println("Hora inválida. Intente nuevamente.");
						}

						fechaInicio = parsearFechaYHora(fechaInicioStr, horaInicioStr);
						if (fechaInicio == null) {
							System.out.println("Por favor, ingrese nuevamente la fecha y la hora.");
						} else if (fechaInicio.isBefore(LocalDateTime.now())) {
							System.out.println("Advertencia: La fecha y hora del evento es anterior a la actual.");
							System.out.print("¿Desea guardar el evento de todos modos? (sí/no): ");
							String confirmacion = lector.readLine().trim().toLowerCase();
							if (confirmacion.equals("sí") || confirmacion.equals("si")) {
								break;
							} else {
								System.out.println("Por favor, ingrese una nueva fecha y hora de inicio.");
							}
						} else {
							break;
						}
					}

					System.out.println("=========================");
					System.out.print("¿La fecha de término es la misma que la de inicio? (sí/no): ");
					String mismaFecha = lector.readLine().trim().toLowerCase();

					LocalDateTime fechaFin;
					if (mismaFecha.equals("sí") || mismaFecha.equals("si")) {
						fechaFin = fechaInicio;
					} else {
						while (true) {
							System.out.print("Ingrese la fecha de término del evento (dd/MM/yyyy): ");
							String fechaFinStr = lector.readLine();

							String horaFinStr;
							while (true) {
								System.out.print("Ingrese la hora de término del evento (HH:mm en formato 24 hrs): ");
								horaFinStr = lector.readLine();
								if (horaValida(horaFinStr)) break;
								else System.out.println("Hora inválida. Intente nuevamente.");
							}

							fechaFin = parsearFechaYHora(fechaFinStr, horaFinStr);
							if (fechaFin == null || fechaFin.isBefore(fechaInicio)) {
								System.out.println("La fecha y hora de término debe ser posterior a la fecha y hora de inicio. Intente nuevamente.");
							} else {
								break;
							}
						}
					}

					System.out.println("=========================");
					System.out.print("Ingrese el lugar del evento: ");
					String lugar = lector.readLine();
					System.out.println("=========================");

					//Crear evento
					Evento evento = new Evento(id, titulo, descripcion, fechaInicio, fechaFin, lugar);
					evento.MostrarEvento();
					agenda.agregarEvento(evento);
					System.out.println("=========================");
					presioneTeclaParaContinuar();
					break;
				case "2":
					// Mostrar todos los eventos
					System.out.println("=========================");
					System.out.println("Mostrando todos los eventos:");
					System.out.println("=========================");
					agenda.mostrarTodosLosEventos();
					presioneTeclaParaContinuar();
					break;
				case "3":
					// Editar evento por ID
					System.out.println("=========================");
					System.out.println("Editando evento por id...");
					System.out.println("=========================");
					System.out.println("Ingrese la id del evento a buscar:");
					idBuscado = Integer.parseInt(lector.readLine());
					agenda.editarEventoPorId(idBuscado);
					presioneTeclaParaContinuar();
					break;
				case "4":
					// Buscar eventos por día
					System.out.println("=========================");
					System.out.println("Buscando evento por día...");
					System.out.println("=========================");
					System.out.println("Ingrese año del día a buscar:");
					anioBuscado = lector.readLine();
					System.out.println("Ingrese mes del día a buscar:");
					mesBuscado = lector.readLine();
					System.out.println("Ingrese el número del día a buscar:");
					diaBuscado = Integer.parseInt(lector.readLine());
					System.out.println("=========================");
					agenda.buscarEventosPorFecha(diaBuscado, mesBuscado, anioBuscado);
					System.out.println("=========================");
					presioneTeclaParaContinuar();
					break;
				case "5":
					// Buscar eventos por semana
					System.out.println("=========================");
					System.out.println("Buscando evento por semana...");
					System.out.println("=========================");
					System.out.println("Ingrese año de la semana a buscar:");
					anioBuscado = lector.readLine();
					System.out.println("Ingrese fecha de inicio de la semana a buscar (dd/MM/yyyy):");
					String fechaInicioBuscado = lector.readLine();
					System.out.println("=========================");
					agenda.buscarEventosPorFecha(fechaInicioBuscado, anioBuscado);
					System.out.println("=========================");
					presioneTeclaParaContinuar();
					break;
				case "6":
					// Buscar eventos por mes
					System.out.println("=========================");
					System.out.println("Buscando evento por mes...");
					System.out.println("=========================");
					System.out.println("Ingrese año del mes a buscar:");
					anioBuscado = lector.readLine();
					System.out.println("Ingrese mes a buscar:");
					mesBuscado = lector.readLine();
					
					System.out.println("=========================");
					agenda.buscarEventosPorMes(mesBuscado, anioBuscado);
					System.out.println("=========================");
					presioneTeclaParaContinuar();
					break;
				case "7":
					// Buscar eventos por etiqueta
					System.out.println("=========================");
					System.out.println("Buscando evento por Etiqueta...");
					System.out.println("=========================");
					System.out.println("Ingrese la etiqueta a buscar:");
					
					String etiqueta = lector.readLine();
					
					Etiqueta etiquetaBuscada = new Etiqueta(0, etiqueta);
					
					ArrayList<Evento> eventosEncontrados = agenda.buscarEventosPorEtiqueta(etiquetaBuscada);
					
					for (Evento e : eventosEncontrados) {
						e.MostrarEvento();
					}
					
					presioneTeclaParaContinuar();
					break;
				case "8":
					// Generar reporte de eventos
					System.out.println("Opcion 8: ");
					System.out.println("=========================");
					System.out.println("Obteniendo reporte...");
					System.out.println("=========================");
					System.out.println("Ingrese el nombre del archivo del reporte:");

					String nombreReporte = lector.readLine();
					agenda.generarReporteEventos(nombreReporte);
					break;
				case "9": 
					// Salir del programa
					System.out.println("Saliendo del programa...");
					return;
				case "10":
						System.out.println("=========================");
							System.out.println("Filtrando eventos...");
							System.out.println("=========================");
							System.out.print("Ingrese la fecha de inicio para filtrar (dd/MM/yyyy): ");
							String fechaInicioFiltro = lector.readLine();
							System.out.print("Ingrese la fecha de término para filtrar (dd/MM/yyyy): ");
							String fechaFinFiltro = lector.readLine();

							// Llama al método de la agenda que implementa el filtrado
							boolean hayEventos = agenda.filtrarEventosPorRangoFechas(
									parsearFechaYHora(fechaInicioFiltro, "00:00"), 
									parsearFechaYHora(fechaFinFiltro, "23:59")
							);

							// No es necesario este chequeo ya que el método ya muestra un mensaje si no hay eventos
							if (!hayEventos) {
									// Este mensaje es opcional porque el método ya maneja el mensaje
									System.out.println("No se encontraron eventos en ese rango de fechas.");
							}

							presioneTeclaParaContinuar();
							break;
				default:
					System.out.println("Opción inválida. Por favor, elige una opción válida...");
					presioneTeclaParaContinuar();
					break;
		
			}
		} while(opcion != "9");		
	}




	// Funciones auxiliares

	 //* Valida si una hora ingresada es correcta (HH:mm).
	 //* @param hora Cadena que representa la hora en formato HH:mm.
	 //* @return true si la hora es válida, false en caso contrario.
	
	private static boolean horaValida(String hora) {
		try {
			LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	
	 //* Convierte una cadena de fecha y hora en un objeto LocalDateTime.
	 //* @param fecha La fecha en formato dd/MM/yyyy.
	 //* @param hora La hora en formato HH:mm.
	 //* @return Un objeto LocalDateTime si la fecha y hora son válidas; null si no lo son.
	
	private static LocalDateTime parsearFechaYHora(String fecha, String hora) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		try {
			if (hora.equals("24:00")) {
				LocalDate fechaBase = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				return fechaBase.plusDays(1).atStartOfDay();
			} else {
				return LocalDateTime.parse(fecha + " " + hora, formatter);
			}
		} catch (DateTimeParseException e) {
			System.out.println("Error: Formato de fecha o hora inválido.");
			System.out.println("Por favor, ingrese la fecha en el formato dd/MM/yyyy y la hora en el formato HH:mm.");
			return null;
		}
	}
  //* Limpia la pantalla de la consola.
	public static void limpiarPantalla() {
			try {
					String sistemaOperativo = System.getProperty("os.name");
					ProcessBuilder processBuilder;
					if (sistemaOperativo.contains("Windows")) {
							processBuilder = new ProcessBuilder("cmd", "/c", "cls");
					} else {
							processBuilder = new ProcessBuilder("clear");
					}
					Process proceso = processBuilder.inheritIO().start();
					proceso.waitFor();
			} catch (IOException | InterruptedException e) {
					System.out.println("No se pudo limpiar la consola.");
			}
	}
  // * Pausa la ejecución hasta que el usuario presione Enter.
	public static void presioneTeclaParaContinuar(){
		System.out.println("Presione una tecla para continuar...");
		try {
			System.in.read();
		} catch (IOException e) {
			System.out.println("Error al leer la tecla presionada.");
		}
	}
}
