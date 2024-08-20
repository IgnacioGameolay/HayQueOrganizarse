// Clase Agenda

import EventoClase.java;

public class AgendaClase {
	 private List<Evento> eventos;

	 public AgendaClase() {
		  this.eventos = new ArrayList<>();
	 }

	 // Getters y Setters
	 public List<Evento> getEventos() {
		  return eventos;
	 }

	 public void setEventos(List<Evento> eventos) {
		  this.eventos = eventos;
	 }

	 // Métodos para manejar eventos
	 public void agregarEvento(Evento evento) {
		  eventos.add(evento);
	 }

	 public void eliminarEvento(Evento evento) {
		  eventos.remove(evento);
	 }

	 public List<Evento> buscarEventosPorDia(LocalDate fecha) {
		  List<Evento> resultados = new ArrayList<>();
		  for (Evento evento : eventos) {
				if (evento.getFechaInicio().toLocalDate().equals(fecha)) {
					 resultados.add(evento);
				}
		  }
		  return resultados;
	 }

	 public List<Evento> buscarEventosPorSemana(LocalDate fecha) {
		  // Implementación para buscar eventos por semana
		  return new ArrayList<>();
	 }

	 public List<Evento> buscarEventosPorMes(int mes, int anio) {
		  // Implementación para buscar eventos por mes
		  return new ArrayList<>();
	 }

	 public List<Evento> buscarEventosPorEtiqueta(Etiqueta etiqueta) {
		  List<Evento> resultados = new ArrayList<>();
		  for (Evento evento : eventos) {
				if (evento.getEtiquetas().contains(etiqueta)) {
					 resultados.add(evento);
				}
		  }
		  return resultados;
	 }
}

