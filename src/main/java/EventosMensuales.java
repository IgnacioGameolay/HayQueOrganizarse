import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Clase que representa un evento mensual, que hereda de la clase {@link Evento}.
 * Esta clase permite la creación de eventos que se repiten mensualmente.
 */
public class EventosMensuales extends Evento {
    /**
     * Constructor que inicializa un evento mensual con todos los atributos principales.
     *
     * @param id           Identificador único del evento.
     * @param titulo       Título del evento.
     * @param descripcion  Descripción detallada del evento.
     * @param fechaInicio  Fecha y hora de inicio del evento.
     * @param fechaFin     Fecha y hora de finalización del evento.
     * @param lugar        Lugar donde se realizará el evento.
     */
    public EventosMensuales(int id, String titulo, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, String lugar) {
        super(id, titulo, descripcion, fechaInicio, fechaFin, lugar);
    }

    /**
     * Sobrecarga del método para agendar eventos cíclicos mensuales.
     * Este método añade el evento en la agenda una vez al mes durante el año actual.
     * 
     * @param agenda La agenda donde se agregará el evento mensual.
     */
    @Override
    public void agendarEvento(Agenda agenda) {
        LocalDateTime fechaInicioEvento = this.getFechaInicio();
        LocalDateTime fechaFinEvento = this.getFechaFin();
        
        // Añadir el evento cada mes durante el año actual
        for (int i = 0; i < 12; i++) {
            LocalDateTime nuevaFechaInicio = fechaInicioEvento.plus(i, ChronoUnit.MONTHS);
            LocalDateTime nuevaFechaFin = fechaFinEvento.plus(i, ChronoUnit.MONTHS);
            
            // Comprobar si el evento cae dentro del año actual
            if (nuevaFechaInicio.getYear() == LocalDateTime.now().getYear()) {
                Evento eventoRepetido = new Evento(this.getId(), this.getTitulo(), this.getDescripcion(), nuevaFechaInicio, nuevaFechaFin, this.getLugar());
                agenda.agregarEvento(eventoRepetido);
            }
        }
    }
}