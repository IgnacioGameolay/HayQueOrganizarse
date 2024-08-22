import java.util.*;
import java.time.*;

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

	 // Método para buscar si en un mes y año dado como parámetro hay eventos
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
}
