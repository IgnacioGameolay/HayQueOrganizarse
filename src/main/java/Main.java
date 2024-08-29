import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

public class Main {
	

	private static void MostrarMenu() {
		System.out.println("=== Menú de la Agenda ===");
		System.out.println("1. Agregar un evento");
		System.out.println("2. Mostrar todos los eventos");
		System.out.println("3. Editar evento por ID");
		System.out.println("4. Buscar eventos por mes");
		System.out.println("5. Buscar eventos por etiqueta");
		System.out.println("9. Salir");
		System.out.println("=========================");
		System.out.print("Elige una opción: ");
	}

	public static void main(String[] args) throws IOException {
		//Inicio del main

		//Definicion de variables
		Agenda agenda = new Agenda(); // Crear una nueva agenda

		agenda.inicializarEventosDePrueba(); // Inicializar eventos de prueba
		
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		
		//Bucle del menu
		String opcion = "";
		
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
					System.out.print("Ingrese el id del evento: ");
					int id = Integer.parseInt(lector.readLine());
					System.out.println("=========================");
					System.out.print("Ingrese el título del evento: ");
					String titulo = lector.readLine();
					System.out.println("=========================");
					System.out.print("Ingrese la descripción del evento: ");
					String descripcion = lector.readLine();
					System.out.println("=========================");

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
					System.out.println("=========================");
					System.out.println("Mostrando todos los eventos:");
					System.out.println("=========================");
					agenda.mostrarTodosLosEventos();
					presioneTeclaParaContinuar();
					break;
				case "3":
					System.out.println("=========================");
					System.out.println("Editando evento por id...");
					System.out.println("=========================");
					System.out.println("Ingrese la id del evento a buscar:");
					int idBuscado = Integer.parseInt(lector.readLine());
					agenda.editarEventoPorId(idBuscado);
					presioneTeclaParaContinuar();
					break;
				case "4":
					//System.out.println("Opcion 4: Buscar eventos por mes");;;
					System.out.println("=========================");
					System.out.println("Buscando evento por mes...");
					System.out.println("=========================");
					System.out.println("Ingrese mes a buscar:");
					String mesBuscado = lector.readLine();
					System.out.println("Ingrese año a buscar:");
					String anioBuscado = lector.readLine();
					agenda.buscarEventosPorMes(mesBuscado, anioBuscado);
					System.out.println("=========================");
					presioneTeclaParaContinuar();
					break;
				case "5":
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
				default:
					System.out.println("Opción inválida. Por favor, elige una opción válida...");
					presioneTeclaParaContinuar();
					break;
		
			}
		} while(opcion != "9");		
	}




	// Funciones auxiliares
	private static boolean horaValida(String hora) {
		try {
			LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

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

	public static void presioneTeclaParaContinuar(){
		System.out.println("Presione una tecla para continuar...");
		try {
			System.in.read();
		} catch (IOException e) {
			System.out.println("Error al leer la tecla presionada.");
		}
	}
}
