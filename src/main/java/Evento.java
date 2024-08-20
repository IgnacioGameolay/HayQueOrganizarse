import java.time.*;
import java.util.*;


// Clase Evento
public class Evento {
    private int id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String lugar;
    private ArrayList<Participante> participantes;
    private ArrayList<Etiqueta> etiquetas;

    public Evento(int id, String titulo, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, String lugar) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this.participantes = new ArrayList<>();
        this.etiquetas = new ArrayList<>();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    // Métodos para manejar participantes y etiquetas
    public void agregarParticipante(Participante participante) {
        participantes.add(participante);
    }

    public void eliminarParticipante(Participante participante) {
        participantes.remove(participante);
    }

    public void agregarEtiqueta(Etiqueta etiqueta) {
        etiquetas.add(etiqueta);
    }

    public void eliminarEtiqueta(Etiqueta etiqueta) {
        etiquetas.remove(etiqueta);
    }
}

