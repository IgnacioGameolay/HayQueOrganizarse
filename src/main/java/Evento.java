import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
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
        this.etiquetas = new ArrayList<Etiqueta>();
    }

    public Evento(int id, String titulo, String descripcion, String lugar) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this.etiquetas = new ArrayList<Etiqueta>();
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

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void MostrarEvento(){
        System.out.println("=========================");
        System.out.println("ID: " + id);
        System.out.println("=========================");
        System.out.println("Título: " + titulo);
        System.out.println("=========================");
        System.out.println("Descripción: " + descripcion);
        System.out.println("=========================");
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("=========================");
        System.out.println("Fecha de fin: " + fechaFin);
        System.out.println("=========================");
        System.out.println("Lugar: " + lugar);
        System.out.println("=========================");
        System.out.println("=========================");
        System.out.print("Etiquetas: [");
        for (int i = 0; i < etiquetas.size(); i++) {
            System.out.print(etiquetas.get(i).getNombre());
            if (i < 2 && etiquetas.size() > 1) {
                System.out.print(", ");
            }
            if (i == 2 && etiquetas.size() > 3) {
                System.out.print("...");
                break;
            }
        }
        System.out.println("]");
        System.out.println("=========================");
    }

    // Métodos para manejar participantes y etiquetas
    public void agregarParticipante(Participante participante) {
        participantes.add(participante);
    }

    public void eliminarParticipante(Participante participante) {
        participantes.remove(participante);
    }

    public void agregarEtiqueta(Etiqueta etiqueta) {
        if (!etiquetas.contains(etiqueta)){
            etiquetas.add(etiqueta);
            return;
        }
        else{
            System.out.println("La etiqueta ya existe en el evento.");
            return;
        }
    }

    public void eliminarEtiqueta(Etiqueta etiqueta) {
        if(!etiquetas.contains(etiqueta)){
            etiquetas.remove(etiqueta);
            return;
        }
        else{
            System.out.println("La etiqueta no existe en el evento.");
            return;
        }
    }
    public void modificarEtiqueta(Etiqueta etiqueta, Etiqueta nuevaEtiqueta){
        int index = etiquetas.indexOf(etiqueta);
        if (index != -1){
            etiquetas.set(index, nuevaEtiqueta);
            return;
        }
        else{
            System.out.println("La etiqueta a modificar no se encontró.");
            return;
        }
    }


}


/*
Posible sobrecarga de metodo:
// Método para agregar una sola etiqueta
public void agregarEtiqueta(String etiqueta) {
    if (!etiquetas.contains(etiqueta)) {
        etiquetas.add(etiqueta);
    }
}

// Sobrecarga del método para agregar múltiples etiquetas
public void agregarEtiqueta(List<String> etiquetas) {
    for (String etiqueta : etiquetas) {
        if (!this.etiquetas.contains(etiqueta)) {
            this.etiquetas.add(etiqueta);
        }
    }
}

*/