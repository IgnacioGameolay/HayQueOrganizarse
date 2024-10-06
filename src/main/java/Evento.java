import java.time.*;
import java.util.*;


// Clase Evento
public class Evento {
    // Atributos de la clase
    private int id; //Identificador del evento
    private String titulo; // Titulo del evento
    private String descripcion; // Descripcion del evento
    private LocalDateTime fechaInicio; // Fecha de inicio del evento
    private LocalDateTime fechaFin; // Fecha del fin del evento
    private String lugar; // Lugar del evento
    private ArrayList<Participante> participantes; // Lista de participantes del evento
    private ArrayList<Etiqueta> etiquetas; // Lista de etiquetas del evento
    
    
    /**
     * Constructor que inicializa un evento con todos los atributos principales.
     *
     * @param id           Identificador único del evento.
     * @param titulo       Título del evento.
     * @param descripcion  Descripción detallada del evento.
     * @param fechaInicio  Fecha y hora de inicio del evento.
     * @param fechaFin     Fecha y hora de finalización del evento.
     * @param lugar        Lugar donde se realizará el evento.
     */
    
    public Evento(int id, String titulo, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, String lugar) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this.etiquetas = new ArrayList<Etiqueta>();
        this.participantes = new ArrayList<Participante>();
    }
    /**
     * Constructor alternativo que inicializa un evento con atributos básicos, sin fechas.
     *
     * @param id          Identificador único del evento.
     * @param titulo      Título del evento.
     * @param descripcion Descripción detallada del evento.
     * @param lugar       Lugar donde se realizará el evento.
     */
    
    public Evento(int id, String titulo, String descripcion, String lugar) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.etiquetas = new ArrayList<Etiqueta>();
        this.participantes = new ArrayList<Participante>();
    }
    
    
    public Evento(int id, String titulo, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, String lugar, ArrayList<Etiqueta> etiquetas, ArrayList<Participante> participantes) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this.etiquetas = etiquetas;
        this.participantes = participantes;
    }
    
    
    // Métodos Getter y Setter para acceder y modificar los atributos del evento.
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
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
    
    
    
    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
    
    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }
    
    public ArrayList<Participante> getParticipantes() {
        return this.participantes;
    }
    
    //* Muestra los detalles del evento en la consola.
    
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
    
    public Participante buscarParticipante(String criterio) {
        for (Participante participante : participantes) {
            if (participante.getNombre().equalsIgnoreCase(criterio) ||
                    participante.getEmail().equalsIgnoreCase(criterio) ||
                    participante.getRol().equalsIgnoreCase(criterio)) {
                return participante;
            }
        }
        return null; // Si no se encuentra ningún participante
    }
    
    //Agregar una sola etiqueta
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
    
    // Sobrecarga del método para agregar múltiples etiquetas
    public void agregarEtiqueta(ArrayList<Etiqueta> etiquetas) {
        for (Etiqueta etiqueta : etiquetas) {
            // Verificar si la etiqueta ya está en la lista
            boolean exists = false;
            for (Etiqueta e : this.etiquetas) {
                if (e.getNombre().equals(etiqueta.getNombre())) {
                    exists = true;
                    break;
                }
            }
            // Si la etiqueta no existe, agregarla
            if (!exists) {
                this.etiquetas.add(etiqueta);
            }
        }
    }
    
    //* Elimina una etiqueta del evento.
    //*
    //* @param etiqueta Objeto Etiqueta a eliminar de la lista de etiquetas.
    
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
    
    //* Modifica una etiqueta existente en el evento.
    //* @param etiqueta     Etiqueta existente a modificar.
    //* @param nuevaEtiqueta Nueva etiqueta con los valores actualizados.
    
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
    
    // Sobrescritura del método toString() para proporcionar una representación personalizada del evento
    @Override
    public String toString() {
        return "Evento{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", lugar='" + lugar + '\'' +
                ", participantes=" + participantes +
                ", etiquetas=" + etiquetas +
                '}';
    }
    
    // Sobrescritura del método equals() para comparar eventos por su ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // Si son el mismo objeto, son iguales
        if (o == null || getClass() != o.getClass()) return false;  // Si no son de la misma clase, son diferentes
        Evento evento = (Evento) o;  // Cast al tipo Evento
        return Objects.equals(id, evento.id);  // Comparamos los eventos por su ID
    }
    
    // Sobrescritura del método hashCode() basado en el ID del evento
    @Override
    public int hashCode() {
        return Objects.hash(id);  // El hashCode se genera a partir del ID
    }
}