import java.util.*;
import java.time.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Agenda {
	 private ArrayList<Evento> eventos;

	 private Map<String, ArrayList<Evento>> eventosPorDia;
	 private Map<String, Map<String, ArrayList<Evento>>> eventosPorMes;
	 //private Map<String, Map<String, Map<String, ArrayList<Evento>>>> eventosPorMes;
	 private Map<String, Map<String, Map<String, ArrayList<Evento>>>> eventosPorAnio;

	 public Agenda() {
		  this.eventosPorAnio = new HashMap<String, Map<String, Map<String, ArrayList<Evento>>>>();
		 
	 }

	 // Getters y Setters
	 public ArrayList<Evento> getEventos() {
		  return eventos;
	 }

	 public void setEventos(ArrayList<Evento> eventos) {
		  this.eventos = eventos;
	 }

	// Métodos para manejar eventos
	 public void agregarEvento(Evento evento) {
		  LocalDateTime fechaInicio = evento.getFechaInicio();
		  String anio, mes, dia;
		  anio = String.valueOf(fechaInicio.getYear()); // YYYY
		  mes = String.format("%02d", fechaInicio.getMonthValue()); // MM
		  dia = String.format("%02d", fechaInicio.getDayOfMonth()); // DD
		 

		  // Agregar el evento al mapa por año
		  if (!eventosPorAnio.containsKey(anio)) {
				eventosPorAnio.put(anio, new HashMap<String, Map<String, ArrayList<Evento>>>());
		  }
		  Map<String, Map<String, ArrayList<Evento>>> eventosPorMes = eventosPorAnio.get(anio);

		  // Agregar el evento al mapa por mes
		  if (!eventosPorMes.containsKey(mes)) {
				eventosPorMes.put(mes, new HashMap<String, ArrayList<Evento>>());
		  }
		  Map<String, ArrayList<Evento>> eventosPorDia = eventosPorMes.get(mes);

		  // Agregar el evento al mapa por día
		  if (!eventosPorDia.containsKey(dia)) {
				eventosPorDia.put(dia, new ArrayList<Evento>());
		  }
		  eventosPorDia.get(dia).add(evento);
	 }
	
	/*
	 // Métodos para manejar eventos
	 public void agregarEvento(Evento evento) {
		  LocalDateTime fechaInicio = evento.getFechaInicio();
		  String anio, mes, dia;
		  anio = String.valueOf(fechaInicio.getYear()); // YYYY
		  mes = String.valueOf(fechaInicio.getMonthValue()); // MM
		  dia = String.valueOf(fechaInicio.getDayOfMonth()); // DD

		  // Agregar el evento al mapa de dias
		  eventosPorDia.computeIfAbsent(dia, k -> new ArrayList<>()).add(evento);
		 Map<String, Map<String, ArrayList<Evento>>> eventosPorMes;
		  // Agregar al mapa por mes
		  eventosPorMes
				.computeIfAbsent(anio, k -> new HashMap<>())
				.computeIfAbsent(mes, k -> new HashMap<>())
				.computeIfAbsent(dia, k -> new ArrayList<Evento>())
				.add(evento);

		  // Agregar al mapa por anio
		  eventosPorAnio
				.computeIfAbsent(anio, k -> new HashMap<>())
				.computeIfAbsent(mes, k -> new HashMap<String, ArrayList<Evento>>())
				.computeIfAbsent(dia, k -> new ArrayList<>())
				.add(evento);
	 }

	 public void eliminarEvento(Evento evento) {
		  eventos.remove(evento);
	 }*/

	
	 public ArrayList<Evento> buscarEventosPorSemana(LocalDate fecha) {
		  // Implementación para buscar eventos por semana
		  return new ArrayList<Evento>();
	 }

	 // Método para buscar si en un mes y anio dado como parámetro hay eventos
	 public void buscarEventosPorMes(String mes, String anio) {
		  String anioString = String.valueOf(anio);
		  String mesString = String.valueOf(mes);

		  // Obtener el mapa de meses para el año especificado
		  Map<String, Map<String, ArrayList<Evento>>> eventosPorMesAnio = eventosPorAnio.get(anioString);
		 
		  if (eventosPorMesAnio == null) {
				System.out.println("No hay eventos para el año " + anioString);
				return;
		  }

		  // Obtener el mapa de días para el mes especificado
		  Map<String, ArrayList<Evento>> eventosPorDiaMes = eventosPorMesAnio.get(mesString);
		  if (eventosPorDiaMes == null) {
				System.out.println("No hay eventos para el mes ingresado " + mesString);
				return;
		  }

		  int hayEventos = 0;
		  // Recorrer el mapa de días
		  for (String diaStr : eventosPorDiaMes.keySet()) {
				// Obtener la lista de eventos para el día actual
				ArrayList<Evento> eventos = eventosPorDiaMes.get(diaStr);

				// Verificar si la lista de eventos está vacía
				if (eventos != null && !eventos.isEmpty()) {
					 // Marca que hay eventos para el mes
					 hayEventos = 1;

					 // Imprime el encabezado para el día
					 System.out.println("Eventos para el día " + diaStr + ":");

					 // Iterar sobre cada evento en la lista de eventos
					 for (Evento evento : eventos) {
						  // Mostrar los detalles del evento
						  evento.MostrarEvento();
						  System.out.println();
					 }
				}
		  }
		  // Si no hay eventos para el mes, imprime un mensaje
		  if (hayEventos == 0) {
				System.out.println("No hay eventos para el mes " + mesString + " del año " + anioString);
		  }
	 }

	 public ArrayList<Evento> buscarEventosPorEtiqueta(Etiqueta etiqueta) {
		  ArrayList<Evento> resultados = new ArrayList<Evento>();
		  for (Evento evento : eventos) {
				if (evento.getEtiquetas().contains(etiqueta)) {
					 resultados.add(evento);
				}
		  }
		  return resultados;
	 }
	//Edicion de eventos
	public Evento buscarEventoPorId(int id) {
			for (Evento evento : eventos) {
					if (evento.getId() == id) {
							return evento;
					}
			}
			return null; // Retorna null si no se encuentra un evento con el ID dado.
	}
	public void editarEventoPorId(int id) {
			Evento evento = buscarEventoPorId(id);
			if (evento == null) {
					System.out.println("Evento no encontrado.");
					return;
			}

			Scanner scanner = new Scanner(System.in);

			while (true) {
					System.out.println("\n¿Qué te gustaría editar?");
					System.out.println("1. Título");
					System.out.println("2. Descripción");
					System.out.println("3. Fecha de inicio");
					System.out.println("4. Fecha de fin");
					System.out.println("5. Lugar");
					System.out.println("6. Etiquetas");
					System.out.println("7. Finalizar edición");
					System.out.print("Seleccione una opción: ");
					int opcion = scanner.nextInt();
					scanner.nextLine();

					switch (opcion) {
							case 1:
									System.out.print("Nuevo título: ");
									String nuevoTitulo = scanner.nextLine();
									evento.setTitulo(nuevoTitulo);
									break;

							case 2:
									System.out.print("Nueva descripción: ");
									String nuevaDescripcion = scanner.nextLine();
									evento.setDescripcion(nuevaDescripcion);
									break;

							case 3:
									System.out.print("Nueva fecha de inicio (YYYY-MM-DDTHH:MM): ");
									String nuevaFechaInicioStr = scanner.nextLine();
									try {
											LocalDateTime nuevaFechaInicio = LocalDateTime.parse(nuevaFechaInicioStr);
											evento.setFechaInicio(nuevaFechaInicio);
									} catch (DateTimeParseException e) {
											System.out.println("Formato de fecha inválido.");
									}
									break;

							case 4:
									System.out.print("Nueva fecha de fin (YYYY-MM-DDTHH:MM): ");
									String nuevaFechaFinStr = scanner.nextLine();
									try {
											LocalDateTime nuevaFechaFin = LocalDateTime.parse(nuevaFechaFinStr);
											evento.setFechaFin(nuevaFechaFin);
									} catch (DateTimeParseException e) {
											System.out.println("Formato de fecha inválido.");
									}
									break;

							case 5:
									System.out.print("Nuevo lugar: ");
									String nuevoLugar = scanner.nextLine();
									evento.setLugar(nuevoLugar);
									break;

							case 6:
									System.out.println("\n¿Qué te gustaría hacer con las etiquetas?");
									System.out.println("1. Agregar etiqueta");
									System.out.println("2. Eliminar etiqueta");
									System.out.println("3. Modificar etiqueta");
									System.out.print("Seleccione una opción: ");
									int opcionEtiqueta = scanner.nextInt();
									scanner.nextLine();

									switch (opcionEtiqueta) {
											case 1:
													System.out.print("Ingrese la nueva etiqueta: ");
													String nuevaEtiqueta = scanner.nextLine();
													// Asumiendo que el constructor de Etiqueta necesita un id y un nombre
													Etiqueta etiquetaAgregar = new Etiqueta(0, nuevaEtiqueta);
													evento.agregarEtiqueta(etiquetaAgregar);
													break;

											case 2:
													System.out.print("Ingrese la etiqueta a eliminar: ");
													String etiquetaEliminar = scanner.nextLine();
													Etiqueta etiquetaEliminarObj = new Etiqueta(0, etiquetaEliminar);
													evento.eliminarEtiqueta(etiquetaEliminarObj);
													break;

											case 3:
													System.out.print("Ingrese la etiqueta a modificar: ");
													String etiquetaModificar = scanner.nextLine();
													System.out.print("Ingrese la nueva etiqueta: ");
													String etiquetaModificada = scanner.nextLine();
													Etiqueta etiquetaModificarObj = new Etiqueta(0, etiquetaModificar);
													Etiqueta etiquetaModificadaObj = new Etiqueta(0, etiquetaModificada);
													evento.modificarEtiqueta(etiquetaModificarObj, etiquetaModificadaObj);
													break;

											default:
													System.out.println("Opción no válida.");
													break;
									}
									break;

							case 7:
									System.out.println("Edición finalizada.");
									return;

							default:
									System.out.println("Opción no válida.");
									break;
					}
			}
	}
}

//Edicion de eventos 



/*
 Posible sobrecarga de metodo:

 public List<Evento> buscarEventos(LocalDate fecha) {
		 return eventos.stream()
				 .filter(evento -> evento.getFechaInicio().toLocalDate().equals(fecha))
				 .collect(Collectors.toList());
 }

 // Sobrecarga del método para buscar eventos por etiqueta
 public List<Evento> buscarEventos(String etiqueta) {
		 return eventos.stream()
				 .filter(evento -> evento.getEtiquetas().contains(etiqueta))
				 .collect(Collectors.toList());
 */

