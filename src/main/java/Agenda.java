import java.util.*;
import java.time.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Singleton Agenda para gestionar eventos.

public class Agenda {
    // Lista general de eventos
    private ArrayList<Evento> eventosEnlistados;
    // Mapas para organizar eventos por día, mes y año
    private Map<String, ArrayList<Evento>> eventosPorDia;
    private Map<String, Map<String, ArrayList<Evento>>> eventosPorMes;
    private Map<String, Map<String, Map<String, ArrayList<Evento>>>> eventosPorAnio;
    //Constructor que inicializa los mapas y la lista de eventos.
    
    private static Agenda instancia;
    
    private Agenda() {
        this.eventosPorAnio = new HashMap<String, Map<String, Map<String, ArrayList<Evento>>>>();
        this.eventosEnlistados = new ArrayList<Evento>();
    }
    
    // Método público para obtener la instancia
    public static synchronized Agenda getInstancia() {
        if (instancia == null) {
            instancia = new Agenda();
        }
        return instancia;
    }
    
    
    
    //Generar 3 eventos de prueba, a modo de datos iniciales
    public void inicializarEventosDePrueba() {
        System.out.println("Inicializando Eventos de Prueba...");
        // Formato de fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm");
        
        // Crear eventos de prueba
        Evento evento1 = new Evento(1, "Navidad", "Celebración de Navidad",
                LocalDateTime.parse("25-12-2024 | 00:00", formatter),
                LocalDateTime.parse("25-12-2024 | 23:59", formatter),
                "Casa");
        Evento evento2 = new Evento(2, "Año Nuevo", "Celebración de Año Nuevo",
                LocalDateTime.parse("01-01-2025 | 00:00", formatter),
                LocalDateTime.parse("01-01-2025 | 23:59", formatter),
                "Casa");
        Evento evento3 = new Evento(3, "18 de Septiembre", "Fiestas Patrias",
                LocalDateTime.parse("18-09-2024 | 00:00", formatter),
                LocalDateTime.parse("18-09-2024 | 23:59", formatter),
                "Casa");
        
        // Agregar los eventos a la lista de eventos generales
        this.agregarEvento(evento1);
        
        this.agregarEvento(evento2);
        
        this.agregarEvento(evento3);
        System.out.println("Eventos de Prueba Inicializados Correctamente!");
    }
    
    // Muestra todos los eventos enlistados en la agenda.
    public void mostrarTodosLosEventos() {
        if (eventosEnlistados.isEmpty()) {
            System.out.println("No hay eventos para mostrar.");
        } else {
            for (Evento ev : eventosEnlistados) {
                ev.MostrarEvento();
                System.out.println("///");
            }
        }
    }
    
    public List<Evento> getEventosEnlistados() {
        return Collections.unmodifiableList(eventosEnlistados); // Devuelve una lista no modificable
    }
    
    public int getEventosEnlistadosLargo() {
        return eventosEnlistados.size(); // Devuelve el largo de la lista de eventos
    }
    
    //Agrega un evento a la agenda, actualizando la lista y los mapas de días, meses y años.
    public void agregarEvento(Evento evento) {
        LocalDateTime fechaInicio = evento.getFechaInicio();
        String anio, mes, dia;
        anio = String.valueOf(fechaInicio.getYear()); // YYYY
        mes = String.format("%02d", fechaInicio.getMonthValue()); // MM
        dia = String.format("%02d", fechaInicio.getDayOfMonth()); // DD
        
        
        // Agregar el evento al mapa por año
        if (!eventosPorAnio.containsKey(anio)) {
            eventosPorAnio.put(anio, new HashMap<String, Map<String, ArrayList<Evento>>>());
        }
        Map<String, Map<String, ArrayList<Evento>>> eventosPorMes = eventosPorAnio.get(anio);
        
        // Agregar el evento al mapa por mes
        if (!eventosPorMes.containsKey(mes)) {
            eventosPorMes.put(mes, new HashMap<String, ArrayList<Evento>>());
        }
        Map<String, ArrayList<Evento>> eventosPorDia = eventosPorMes.get(mes);
        
        // Agregar el evento al mapa por día
        if (!eventosPorDia.containsKey(dia)) {
            eventosPorDia.put(dia, new ArrayList<Evento>());
        }
        eventosPorDia.get(dia).add(evento);
        
        //Agregar el evento a la lista de eventos generales
        eventosEnlistados.add(evento);
    }
    //Elimina un evento de la agenda dado su ID.
    public void eliminarEvento(int id) {
        // Buscar el evento por ID
        Evento eventoAEliminar = buscarEventoPorId(id);
        if (eventoAEliminar == null) {
            System.out.println("Evento no encontrado.");
            return;
        }
        
        // Eliminar el evento de la lista de eventos generales
        eventosEnlistados.remove(eventoAEliminar);
        
        // Obtener la fecha de inicio del evento para localizarlo en los mapas
        LocalDateTime fechaInicio = eventoAEliminar.getFechaInicio();
        String anio = String.valueOf(fechaInicio.getYear());
        String mes = String.format("%02d", fechaInicio.getMonthValue());
        String dia = String.format("%02d", fechaInicio.getDayOfMonth());
        
        // Eliminar el evento de los mapas por año, mes y día
        Map<String, Map<String, ArrayList<Evento>>> eventosPorMes = eventosPorAnio.get(anio);
        if (eventosPorMes != null) {
            Map<String, ArrayList<Evento>> eventosPorDia = eventosPorMes.get(mes);
            if (eventosPorDia != null) {
                ArrayList<Evento> eventos = eventosPorDia.get(dia);
                if (eventos != null) {
                    eventos.remove(eventoAEliminar);
                    // Eliminar la entrada si la lista de eventos está vacía
                    if (eventos.isEmpty()) {
                        eventosPorDia.remove(dia);
                    }
                }
                // Eliminar la entrada del mes si no hay más días con eventos
                if (eventosPorDia.isEmpty()) {
                    eventosPorMes.remove(mes);
                }
            }
            // Eliminar la entrada del año si no hay más meses con eventos
            if (eventosPorMes.isEmpty()) {
                eventosPorAnio.remove(anio);
            }
        }
        
        System.out.println("Evento eliminado correctamente.");
    }
    
    
    //buscar eventos por dia específico
    public javax.swing.table.DefaultTableModel buscarEventosPorFecha(int dia, String mes, String anio) {
        // Convertir los parámetros en formato String
        String anioString = String.valueOf(anio);
        String mesString = String.format("%02d", Integer.parseInt(mes));
        String diaString = String.format("%02d", dia); // Asegurar formato de dos dígitos para el día
        
        // Obtener el mapa de meses para el año especificado
        Map<String, Map<String, ArrayList<Evento>>> eventosPorMesAnio = eventosPorAnio.get(anioString);
        if (eventosPorMesAnio == null) {
            return null;
        }
        
        // Obtener el mapa de días para el mes especificado
        Map<String, ArrayList<Evento>> eventosPorDiaMes = eventosPorMesAnio.get(mesString);
        if (eventosPorDiaMes == null) {
            return null;
        }
        
        // Obtener la lista de eventos para el día especificado
        ArrayList<Evento> eventos = eventosPorDiaMes.get(diaString);
        if (eventos != null && !eventos.isEmpty()) {
            javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                    new Object[]{"ID", "Titulo", "Lugar", "FechaInicio", "FechaFin", "Etiquetas"}, 0
            );
            // Limpiar el modelo antes de añadir filas nuevas
            modelo.setRowCount(0);
            
            // Iterar sobre cada evento en la lista de eventos
            for (Evento evento : eventos) {
                Object[] fila = new Object[6]; // 6 columnas: ID, Titulo, Lugar, FechaInicio, FechaFin, Etiquetas
                
                fila[0] = evento.getId(); // Añadir ID del evento
                fila[1] = evento.getTitulo(); // Título del evento
                fila[2] = evento.getLugar(); // Lugar del evento
                fila[3] = evento.getFechaInicio().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de inicio
                fila[4] = evento.getFechaFin().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de fin
                
                // Convertir el array de etiquetas en un string para mostrarlo en una celda
                List<Etiqueta> etiquetas = evento.getEtiquetas();
                String etiquetasStr = etiquetas.stream()
                        .map(Etiqueta::getNombre) // Obtener el nombre de cada etiqueta
                        .reduce((acc, nombre) -> acc + ", " + nombre) // Unirlas en un string
                        .orElse(""); // En caso de que no haya etiquetas
                
                fila[5] = etiquetasStr; // Añadir la cadena de etiquetas a la fila
                
                // Añadir la fila al modelo
                modelo.addRow(fila);
            }
            return modelo;
        } else {
            // Si no hay eventos para el día, imprime un mensaje
            System.out.println("No hay eventos para el día " + diaString + " del mes " + mesString + " del año " + anioString);
        }
        return null;
    }
    
    //buscar eventos de una semana entera (los 6 días seguidos a un día en especificado)
    public javax.swing.table.DefaultTableModel buscarEventosPorFecha(String fechaInicioStr, String anio) {
        // Formateador de fecha para el formato dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaInicioDate;
        
        // Intentar convertir la fecha proporcionada
        try {
            fechaInicioDate = LocalDate.parse(fechaInicioStr, formatter);
        } catch (Exception e) {
            return null;
        }
        
        // Definir el primer día de la búsqueda (fecha de inicio) y el último día (6 días después)
        LocalDate primerDiaBusqueda = fechaInicioDate;
        LocalDate ultimoDiaBusqueda = primerDiaBusqueda.plusDays(6);
        
        // Formatear las fechas para imprimir
        String primerDiaStr = primerDiaBusqueda.format(formatter);
        String ultimoDiaStr = ultimoDiaBusqueda.format(formatter);
        
        // Obtener el mapa de meses para el año especificado
        Map<String, Map<String, ArrayList<Evento>>> eventosPorMesAnio = eventosPorAnio.get(anio);
        if (eventosPorMesAnio == null) {
            return null;
        }
        
        boolean hayEventos = false;
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                new Object[]{"ID", "Titulo", "Lugar", "FechaInicio", "FechaFin", "Etiquetas"}, 0
        );
        
        // Recorrer todos los días de la semana
        for (LocalDate fecha = primerDiaBusqueda; !fecha.isAfter(ultimoDiaBusqueda); fecha = fecha.plusDays(1)) {
            String diaString = fecha.format(DateTimeFormatter.ofPattern("dd"));
            String mesString = fecha.format(DateTimeFormatter.ofPattern("MM"));
            
            // Obtener el mapa de días para el mes especificado
            Map<String, ArrayList<Evento>> eventosPorDiaMes = eventosPorMesAnio.get(mesString);
            if (eventosPorDiaMes != null) {
                // Obtener la lista de eventos para el día específico
                ArrayList<Evento> eventos = eventosPorDiaMes.get(diaString);
                if (eventos != null && !eventos.isEmpty()) {
                    // Marca que hay eventos para la semana
                    hayEventos = true;
                    
                    // Iterar sobre cada evento en la lista de eventos
                    // Limpiar el modelo antes de añadir filas nuevas
                    modelo.setRowCount(0);
                    
                    // Iterar sobre cada evento en la lista de eventos
                    for (Evento evento : eventos) {
                        Object[] fila = new Object[6]; // 6 columnas: ID, Titulo, Lugar, FechaInicio, FechaFin, Etiquetas
                        
                        fila[0] = evento.getId(); // Añadir ID del evento
                        fila[1] = evento.getTitulo(); // Título del evento
                        fila[2] = evento.getLugar(); // Lugar del evento
                        fila[3] = evento.getFechaInicio().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de inicio
                        fila[4] = evento.getFechaFin().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de fin
                        
                        // Convertir el array de etiquetas en un string para mostrarlo en una celda
                        List<Etiqueta> etiquetas = evento.getEtiquetas();
                        String etiquetasStr = etiquetas.stream()
                                .map(Etiqueta::getNombre) // Obtener el nombre de cada etiqueta
                                .reduce((acc, nombre) -> acc + ", " + nombre) // Unirlas en un string
                                .orElse(""); // En caso de que no haya etiquetas
                        
                        fila[5] = etiquetasStr; // Añadir la cadena de etiquetas a la fila
                        
                        // Añadir la fila al modelo
                        modelo.addRow(fila);
                    }
                    
                }
            }
        }
        
        return modelo;
    }
    
    // Método para buscar si en un mes y anio dado como parámetro hay eventos
    //buscar eventos por mes
    public javax.swing.table.DefaultTableModel buscarEventosPorMes(String mes, String anio) {
        String anioString = String.valueOf(anio);
        String mesString = String.format("%02d", Integer.parseInt(mes));
        
        // Obtener el mapa de meses para el año especificado
        Map<String, Map<String, ArrayList<Evento>>> eventosPorMesAnio = eventosPorAnio.get(anioString);
        
        if (eventosPorMesAnio == null) {
            return null;
        }
        
        // Obtener el mapa de días para el mes especificado
        Map<String, ArrayList<Evento>> eventosPorDiaMes = eventosPorMesAnio.get(mesString);
        if (eventosPorDiaMes == null) {
            return null;
        }
        
        
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                new Object[]{"ID", "Titulo", "Lugar", "FechaInicio", "FechaFin", "Etiquetas"}, 0
        );
        // Recorrer el mapa de días
        for (String diaStr : eventosPorDiaMes.keySet()) {
            // Obtener la lista de eventos para el día actual
            ArrayList<Evento> eventos = eventosPorDiaMes.get(diaStr);
            
            // Verificar si la lista de eventos está vacía
            if (eventos != null && !eventos.isEmpty()) {
                // Iterar sobre cada evento en la lista de eventos
                for (Evento evento : eventos) {
                    Object[] fila = new Object[6]; // 6 columnas: ID, Titulo, Lugar, FechaInicio, FechaFin, Etiquetas
                    
                    fila[0] = evento.getId(); // Añadir ID del evento
                    fila[1] = evento.getTitulo(); // Título del evento
                    fila[2] = evento.getLugar(); // Lugar del evento
                    fila[3] = evento.getFechaInicio().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de inicio
                    fila[4] = evento.getFechaFin().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de fin
                    
                    // Convertir el array de etiquetas en un string para mostrarlo en una celda
                    List<Etiqueta> etiquetas = evento.getEtiquetas();
                    String etiquetasStr = etiquetas.stream()
                            .map(Etiqueta::getNombre) // Obtener el nombre de cada etiqueta
                            .reduce((acc, nombre) -> acc + ", " + nombre) // Unirlas en un string
                            .orElse(""); // En caso de que no haya etiquetas
                    
                    fila[5] = etiquetasStr; // Añadir la cadena de etiquetas a la fila
                    
                    // Añadir la fila al modelo
                    modelo.addRow(fila);
                }
                
            }
        }
        return modelo;
    }
    
    //Buscar eventos por etiquetas
    public javax.swing.table.DefaultTableModel buscarEventosPorEtiqueta(Etiqueta etiqueta) {
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                new Object[]{"ID", "Titulo", "Lugar", "FechaInicio", "FechaFin", "Etiquetas"}, 0
        );
        for (Evento evento : eventosEnlistados) {
            for (Etiqueta etiquetaEvento : evento.getEtiquetas()){
                if (etiquetaEvento.getNombre().equals(etiqueta.getNombre())){
                    Object[] fila = new Object[6]; // 6 columnas: ID, Titulo, Lugar, FechaInicio, FechaFin, Etiquetas
                    
                    fila[0] = evento.getId(); // Añadir ID del evento
                    fila[1] = evento.getTitulo(); // Título del evento
                    fila[2] = evento.getLugar(); // Lugar del evento
                    fila[3] = evento.getFechaInicio().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de inicio
                    fila[4] = evento.getFechaFin().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de fin
                    
                    // Convertir el array de etiquetas en un string para mostrarlo en una celda
                    List<Etiqueta> etiquetas = evento.getEtiquetas();
                    String etiquetasStr = etiquetas.stream()
                            .map(Etiqueta::getNombre) // Obtener el nombre de cada etiqueta
                            .reduce((acc, nombre) -> acc + ", " + nombre) // Unirlas en un string
                            .orElse(""); // En caso de que no haya etiquetas
                    
                    fila[5] = etiquetasStr; // Añadir la cadena de etiquetas a la fila
                    
                    // Añadir la fila al modelo
                    modelo.addRow(fila);
                }
            }
        }
        return modelo;
    }
    
    public javax.swing.table.DefaultTableModel filtrarEventosPorRangoFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        ArrayList<Evento> eventosFiltrados = new ArrayList<>();
        
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                new Object[]{"ID", "Titulo", "Lugar", "FechaInicio", "FechaFin", "Etiquetas"}, 0
        );
        
        for (Evento evento : this.eventosEnlistados) {
            if ((evento.getFechaInicio().isEqual(fechaInicio) || evento.getFechaInicio().isAfter(fechaInicio)) &&
                    (evento.getFechaFin().isEqual(fechaFin) || evento.getFechaFin().isBefore(fechaFin))) {
                eventosFiltrados.add(evento);
            }
        }
        
        if (eventosFiltrados.isEmpty()) {
            return null; // No se encontraron eventos
        } else {
            // Mostrar los eventos filtrados si hay
            for (Evento evento : eventosFiltrados) {
                Object[] fila = new Object[6]; // 6 columnas: ID, Titulo, Lugar, FechaInicio, FechaFin, Etiquetas
                
                fila[0] = evento.getId(); // Añadir ID del evento
                fila[1] = evento.getTitulo(); // Título del evento
                fila[2] = evento.getLugar(); // Lugar del evento
                fila[3] = evento.getFechaInicio().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de inicio
                fila[4] = evento.getFechaFin().format(DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm")); // Fecha de fin
                
                // Convertir el array de etiquetas en un string para mostrarlo en una celda
                List<Etiqueta> etiquetas = evento.getEtiquetas();
                String etiquetasStr = etiquetas.stream()
                        .map(Etiqueta::getNombre) // Obtener el nombre de cada etiqueta
                        .reduce((acc, nombre) -> acc + ", " + nombre) // Unirlas en un string
                        .orElse(""); // En caso de que no haya etiquetas
                
                fila[5] = etiquetasStr; // Añadir la cadena de etiquetas a la fila
                
                // Añadir la fila al modelo
                modelo.addRow(fila);
            }
            return modelo; // Se encontraron eventos
        }
    }
    
    
    
    //Edicion de eventos
    public Evento buscarEventoPorId(int id) {
        for (Evento evento : eventosEnlistados) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null; // Retorna null si no se encuentra un evento con el ID dado.
    }
    
    public void editarEventoPorId(int id) {
        Evento evento = buscarEventoPorId(id);
        if (evento == null) {
            System.out.println("Evento no encontrado.");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("=========================");
            System.out.println("\n¿Qué te gustaría editar?");
            System.out.println("1. Título");
            System.out.println("2. Descripción");
            System.out.println("3. Fecha de inicio");
            System.out.println("4. Fecha de fin");
            System.out.println("5. Lugar");
            System.out.println("6. Etiquetas");
            System.out.println("7. Finalizar edición");
            System.out.println("=========================");
            System.out.println("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("=========================");
            switch (opcion) {
                case 1:
                    System.out.print("Nuevo título: ");
                    String nuevoTitulo = scanner.nextLine();
                    evento.setTitulo(nuevoTitulo);
                    break;
                    
                case 2:
                    System.out.print("Nueva descripción: ");
                    String nuevaDescripcion = scanner.nextLine();
                    evento.setDescripcion(nuevaDescripcion);
                    break;
                    
                case 3:
                    System.out.print("Nueva fecha de inicio (dd-MM-yyyy | HH:mm): ");
                    String nuevaFechaInicioStr = scanner.nextLine();
                    try {
                        LocalDateTime nuevaFechaInicio = LocalDateTime.parse(nuevaFechaInicioStr);
                        evento.setFechaInicio(nuevaFechaInicio);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de fecha inválido.");
                    }
                    break;
                    
                case 4:
                    System.out.print("Nueva fecha de fin (dd-MM-yyyy | HH:mm): ");
                    String nuevaFechaFinStr = scanner.nextLine();
                    try {
                        LocalDateTime nuevaFechaFin = LocalDateTime.parse(nuevaFechaFinStr);
                        evento.setFechaFin(nuevaFechaFin);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de fecha inválido.");
                    }
                    break;
                    
                case 5:
                    System.out.print("Nuevo lugar: ");
                    String nuevoLugar = scanner.nextLine();
                    evento.setLugar(nuevoLugar);
                    break;
                    
                case 6:
                    System.out.println("=========================");
                    System.out.println("\n¿Qué te gustaría hacer con las etiquetas?");
                    System.out.println("1. Agregar etiqueta");
                    System.out.println("2. Eliminar etiqueta");
                    System.out.println("3. Modificar etiqueta");
                    System.out.print("Seleccione una opción: ");
                    int opcionEtiqueta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("=========================");
                    switch (opcionEtiqueta) {
                        case 1:
                            System.out.print("Ingrese la nueva etiqueta: ");
                            String nuevaEtiqueta = scanner.nextLine();
                            // Asumiendo que el constructor de Etiqueta necesita un id y un nombre
                            Etiqueta etiquetaAgregar = new Etiqueta(0, nuevaEtiqueta);
                            evento.agregarEtiqueta(etiquetaAgregar);
                            System.out.println("=========================");
                            break;
                            
                        case 2:
                            System.out.print("Ingrese la etiqueta a eliminar: ");
                            String etiquetaEliminar = scanner.nextLine();
                            Etiqueta etiquetaEliminarObj = new Etiqueta(0, etiquetaEliminar);
                            evento.eliminarEtiqueta(etiquetaEliminarObj);
                            System.out.println("=========================");
                            break;
                            
                        case 3:
                            
                            System.out.print("Ingrese la etiqueta a modificar: ");
                            
                            String etiquetaModificar = scanner.nextLine();
                            System.out.println("=========================");
                            System.out.print("Ingrese la nueva etiqueta: ");
                            String etiquetaModificada = scanner.nextLine();
                            System.out.println("=========================");
                            Etiqueta etiquetaModificarObj = new Etiqueta(0, etiquetaModificar);
                            Etiqueta etiquetaModificadaObj = new Etiqueta(0, etiquetaModificada);
                            evento.modificarEtiqueta(etiquetaModificarObj, etiquetaModificadaObj);
                            break;
                            
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    break;
                    
                case 7:
                    System.out.println("Edición finalizada.");
                    return;
                    
                default:
                    System.out.println("Opción no válida.");
                    break;
                    
            }
        }
    }
}