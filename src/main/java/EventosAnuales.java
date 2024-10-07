import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


/**
 * Clase que representa un evento anual, que hereda de la clase {@link Evento}.
 * Esta clase permite la creación de eventos que se repiten anualmente.
 */
public class EventosAnuales extends Evento {
    
     /**
     * Constructor que inicializa un evento anual con todos los atributos principales.
     *
     * @param id           Identificador único del evento.
     * @param titulo       Título del evento.
     * @param descripcion  Descripción detallada del evento.
     * @param fechaInicio  Fecha y hora de inicio del evento.
     * @param fechaFin     Fecha y hora de finalización del evento.
     * @param lugar        Lugar donde se realizará el evento.
     */
    public EventosAnuales(int id, String titulo, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, String lugar) {
        super(id, titulo, descripcion, fechaInicio, fechaFin, lugar);
    }

    /**
     * Sobrecarga del método para agendar eventos cíclicos anuales.
     * Este método añade el evento en la agenda para los próximos 5 años,
     * creando instancias del evento con fechas ajustadas anualmente.
     *
     * @param agenda La agenda donde se agregará el evento anual.
     */
    @Override
    public void agendarEvento(Agenda agenda) {
        LocalDateTime fechaInicioEvento = this.getFechaInicio();
        LocalDateTime fechaFinEvento = this.getFechaFin();
        
        // Añadir el evento para los próximos 5 años
        for (int i = 0; i < 5; i++) {
            LocalDateTime nuevaFechaInicio = fechaInicioEvento.plus(i, ChronoUnit.YEARS);
            LocalDateTime nuevaFechaFin = fechaFinEvento.plus(i, ChronoUnit.YEARS);
            
            Evento eventoRepetido = new Evento(this.getId(), this.getTitulo(), this.getDescripcion(), nuevaFechaInicio, nuevaFechaFin, this.getLugar());
            agenda.agregarEvento(eventoRepetido);
        }
    }
}