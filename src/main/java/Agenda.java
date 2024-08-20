// Clase Agenda
import java.util.*;
import java.time.*;

public class Agenda {
	 private ArrayList<Evento> eventos;

	 public Agenda() {
		  this.eventos = new ArrayList<Evento>();
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
		  eventos.add(evento);
	 }

	 public void eliminarEvento(Evento evento) {
		  eventos.remove(evento);
	 }

	 public ArrayList<Evento> buscarEventosPorDia(LocalDate fecha) {
		  ArrayList<Evento> resultados = new ArrayList<>();
		  for (Evento evento : eventos) {
				if (evento.getFechaInicio().toLocalDate().equals(fecha)) {
					 resultados.add(evento);
				}
		  }
		  return resultados;
	 }

	 public ArrayList<Evento> buscarEventosPorSemana(LocalDate fecha) {
		  // Implementación para buscar eventos por semana
		  return new ArrayList<Evento> ();
	 }

	 public ArrayList<Evento> buscarEventosPorMes(int mes, int anio) {
		  // Implementación para buscar eventos por mes
		  return new ArrayList<Evento> ();
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

