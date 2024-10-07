import java.time.*;
import java.util.*;


/**
 * Clase que representa un evento con sus atributos y métodos para gestionarlo.
 */

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
    
    /**
     * Constructor que inicializa un evento con todos los atributos, incluidas las etiquetas.
     *
     * @param id          Identificador único del evento.
     * @param titulo      Título del evento.
     * @param descripcion Descripción detallada del evento.
     * @param fechaInicio Fecha y hora de inicio del evento.
     * @param fechaFin    Fecha y hora de finalización del evento.
     * @param lugar       Lugar donde se realizará el evento.
     * @param etiquetas   Lista de etiquetas asociadas al evento.
     */
    
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
    /**
     * Establece el identificador del evento.
     *
     * @param id El nuevo identificador del evento.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del evento.
     *
     * @return El identificador del evento.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el título del evento.
     *
     * @return El título del evento.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del evento.
     *
     * @param titulo El nuevo título del evento.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la descripción del evento.
     *
     * @return La descripción del evento.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del evento.
     *
     * @param descripcion La nueva descripción del evento.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la fecha de inicio del evento.
     *
     * @return La fecha de inicio del evento.
     */
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del evento.
     *
     * @param fechaInicio La nueva fecha de inicio del evento.
     */
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de fin del evento.
     *
     * @return La fecha de fin del evento.
     */
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin del evento.
     *
     * @param fechaFin La nueva fecha de fin del evento.
     */
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el lugar del evento.
     *
     * @return El lugar del evento.
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar del evento.
     *
     * @param lugar El nuevo lugar del evento.
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Establece la lista de etiquetas del evento.
     *
     * @param etiquetas La nueva lista de etiquetas del evento.
     */
    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     * Obtiene la lista de etiquetas del evento.
     *
     * @return La lista de etiquetas del evento.
     */
    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    /**
     * Agrega el evento a una agenda dada.
     *
     * @param agenda La agenda en la que se añadirá el evento.
     */
    public void agendarEvento(Agenda agenda) {
        agenda.agregarEvento(this);
    }

    /**
     * Agrega una etiqueta al evento si no existe ya en la lista.
     *
     * @param etiqueta La etiqueta a agregar al evento.
     */
    public void agregarEtiqueta(Etiqueta etiqueta) {
        if (!etiquetas.contains(etiqueta)) {
            etiquetas.add(etiqueta);
        }
    }

    /**
     * Agrega múltiples etiquetas al evento, ignorando las que ya existen.
     *
     * @param etiquetas Lista de etiquetas a agregar al evento.
     */
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

    /**
     * Elimina una etiqueta del evento.
     *
     * @param etiqueta Objeto Etiqueta a eliminar de la lista de etiquetas.
     */
    public void eliminarEtiqueta(Etiqueta etiqueta) {
        if (!etiquetas.contains(etiqueta)) {
            etiquetas.remove(etiqueta);
        }
    }

    /**
     * Modifica una etiqueta existente en el evento.
     *
     * @param etiqueta     Etiqueta existente a modificar.
     * @param nuevaEtiqueta Nueva etiqueta con los valores actualizados.
     */
    
    public void modificarEtiqueta(Etiqueta etiqueta, Etiqueta nuevaEtiqueta){
        int index = etiquetas.indexOf(etiqueta);
        if (index != -1){
            etiquetas.set(index, nuevaEtiqueta);
            return;
        }
    }
}