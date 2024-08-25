import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestorEventos {
    private List<Evento> eventos;

    public GestorEventos() {
        eventos = new ArrayList<>();
        // Agregar eventos iniciales
        inicializarEventos();
    }

    private void inicializarEventos() {
        // Formato de fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Crear eventos usando LocalDateTime
        eventos.add(new Evento(1, "Navidad", "Celebración de Navidad", 
            LocalDateTime.parse("25/12/2024 00:00", formatter),
            LocalDateTime.parse("25/12/2024 23:59", formatter), 
            "Casa"));

        eventos.add(new Evento(2, "Año Nuevo", "Celebración de Año Nuevo", 
            LocalDateTime.parse("01/01/2025 00:00", formatter),
            LocalDateTime.parse("01/01/2025 23:59", formatter), 
            "Casa"));

        eventos.add(new Evento(3, "18 de Septiembre", "Fiestas Patrias", 
            LocalDateTime.parse("18/09/2024 00:00", formatter),
            LocalDateTime.parse("18/09/2024 23:59", formatter), 
            "Casa"));
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void mostrarEventos() {
        for (Evento evento : eventos) {
            evento.MostrarEvento();
        }
    }

    // Métodos adicionales según sea necesario
}
