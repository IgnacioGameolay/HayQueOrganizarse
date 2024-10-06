
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class EventosMensuales extends Evento {
    
    public EventosMensuales(int id, String titulo, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, String lugar) {
        super(id, titulo, descripcion, fechaInicio, fechaFin, lugar);
    }

    // Sobrecarga del método para agregar eventos cíclicos mensuales
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