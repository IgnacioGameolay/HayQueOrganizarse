import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class EventosAnuales extends Evento {
    
    public EventosAnuales(int id, String titulo, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, String lugar) {
        super(id, titulo, descripcion, fechaInicio, fechaFin, lugar);
    }

    // Sobrecarga del método para agregar eventos cíclicos anuales
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
