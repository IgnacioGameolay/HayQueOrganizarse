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
        this.fechaInicio = fechaInicio.withSecond(0).withNano(0);
    this.fechaFin = fechaFin.withSecond(0).withNano(0);
        this.lugar = lugar;
        this.etiquetas = new ArrayList<Etiqueta>();
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
    }
    
    
    public Evento(int id, String titulo, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, String lugar, ArrayList<Etiqueta> etiquetas) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this.etiquetas = etiquetas;
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
    
    //Metodo para agendar this evento a Agenda, siendo un diseño de sistema sumamente extensible para multiples eventos especiales.
    public void agendarEvento(Agenda agenda) {
        agenda.agregarEvento(this);
    }
    
    //Agregar una sola etiqueta
    public void agregarEtiqueta(Etiqueta etiqueta) {
        if (!etiquetas.contains(etiqueta)){
            etiquetas.add(etiqueta);
        }
        else{
            System.out.println("La etiqueta ya existe en el evento.");
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
        }
        else{
            System.out.println("La etiqueta no existe en el evento.");
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
}