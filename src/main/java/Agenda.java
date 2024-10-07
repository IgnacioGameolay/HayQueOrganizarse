import com.toedter.calendar.JDateChooser;
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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Singleton class Agenda para gestionar eventos.
 * Esta clase permite almacenar, buscar y eliminar eventos organizados por fecha.
 */

public class Agenda {
    // Lista general de eventos
    private ArrayList<Evento> eventosEnlistados;
    // Mapas para organizar eventos por día, mes y año
    private Map<String, ArrayList<Evento>> eventosPorDia;
    private Map<String, Map<String, ArrayList<Evento>>> eventosPorMes;
    private Map<String, Map<String, Map<String, ArrayList<Evento>>>> eventosPorAnio;
    //Constructor que inicializa los mapas y la lista de eventos.
    
    private static Agenda instancia;
    
    /**
     * Constructor privado que inicializa los mapas y la lista de eventos.
     */
    private Agenda() {
        this.eventosPorAnio = new HashMap<String, Map<String, Map<String, ArrayList<Evento>>>>();
        this.eventosEnlistados = new ArrayList<Evento>();
    }
    
    /**
     * Método público para obtener la instancia única de Agenda.
     * 
     * @return La instancia de Agenda.
     */
    public static synchronized Agenda getInstancia() {
        if (instancia == null) {
            instancia = new Agenda();
        }
        return instancia;
    }
    
    
    
    /**
     * Genera 3 eventos de prueba, a modo de datos iniciales.
     * Este método se puede utilizar para inicializar la agenda con eventos de ejemplo.
     */
    public void inicializarEventosDePrueba() {

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
    }
    
    
    /**
     * Obtiene la lista de eventos enlistados.
     * 
     * @return Lista no modificable de eventos enlistados.
     */
    public List<Evento> getEventosEnlistados() {
        return Collections.unmodifiableList(eventosEnlistados); // Devuelve una lista no modificable
    }
    
    /**
     * Obtiene el número de eventos enlistados.
     * 
     * @return Largo de la lista de eventos.
     */
    public int getEventosEnlistadosLargo() {
        return eventosEnlistados.size(); // Devuelve el largo de la lista de eventos
    }
    
    
    /**
     * Agrega un evento a la agenda, actualizando la lista y los mapas de días, meses y años.
     * 
     * @param evento Evento a agregar a la agenda.
     */
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
    /**
     * Elimina un evento de la agenda dado su ID.
     * 
     * @param id ID del evento a eliminar.
     */
    public void eliminarEvento(int id) {
        // Buscar el evento por ID
        Evento eventoAEliminar = buscarEventoPorId(id);
        if (eventoAEliminar == null) {
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
        

    }
    
    
    
    /**
     * Busca eventos por una fecha específica (día, mes, año).
     * 
     * @param dia Día del evento a buscar.
     * @param mes Mes del evento a buscar.
     * @param anio Año del evento a buscar.
     * @return Un modelo de tabla con los eventos encontrados o null si no hay eventos.
     */
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
            return null;
        }
        
    }
    
   /**
     * Busca eventos dentro de una semana, comenzando desde la fecha especificada.
     * 
     * @param fechaInicioStr La fecha de inicio en formato "dd-MM-yyyy".
     * @param anio El año en el que se están buscando los eventos.
     * @return Un modelo de tabla con los eventos encontrados dentro de la semana especificada,
     *         o null si la fecha proporcionada es inválida o no hay eventos.
     */
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
    
    /**
     * Busca eventos en un mes específico de un año dado.
     * 
     * @param mes El mes en el que se están buscando los eventos, en formato "MM".
     * @param anio El año en el que se están buscando los eventos.
     * @return Un modelo de tabla con los eventos encontrados en el mes y año especificados,
     *         o null si no hay eventos o el mes/año son inválidos.
     */
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
    
    /**
     * Busca eventos que contengan una etiqueta específica.
     * 
     * @param etiqueta La etiqueta que se busca en los eventos.
     * @return Un modelo de tabla con los eventos que tienen la etiqueta especificada.
     */
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
    
    /**
 * Filtra los eventos de la lista según un rango de fechas proporcionado.
 *
 * @param fechaInicio La fecha de inicio del rango a filtrar.
 * @param fechaFin   La fecha de fin del rango a filtrar.
 * @return Un modelo de tabla que contiene los eventos que se encuentran dentro del rango de fechas
 *         especificado, o null si no se encontraron eventos.
 */
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
    
    
    
    
    /**
 * Busca un evento en la lista por su ID.
 *
 * @param id El ID del evento a buscar.
 * @return El evento correspondiente al ID proporcionado, o null si no se encuentra.
 */
    public Evento buscarEventoPorId(int id) {
        for (Evento evento : eventosEnlistados) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null; // Retorna null si no se encuentra un evento con el ID dado.
    }
    
    /**
 * Modifica un evento existente basado en su ID.
 *
 * @param id                  El ID del evento a modificar.
 * @param jTextFieldTitulo    El campo de texto para el nuevo título del evento.
 * @param jTextAreaDescripcion El área de texto para la nueva descripción del evento.
 * @param jTextFieldLugar     El campo de texto para el nuevo lugar del evento.
 * @param jDateChooserInicio  El selector de fecha para la nueva fecha de inicio del evento.
 * @param jDateChooserFin     El selector de fecha para la nueva fecha de fin del evento.
 */
    public void editarEventoPorId(int id, JTextField jTextFieldTitulo, JTextArea jTextAreaDescripcion, JTextField jTextFieldLugar, JDateChooser jDateChooserInicio, JDateChooser jDateChooserFin) {
        Evento evento = buscarEventoPorId(id);
        if (evento == null) {
            JOptionPane.showMessageDialog(null, "Evento no encontrado.", "Error!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Cargar datos actuales del evento en los campos de la GUI
        jTextFieldTitulo.setText(evento.getTitulo());
        jTextAreaDescripcion.setText(evento.getDescripcion());
        jTextFieldLugar.setText(evento.getLugar());
        jDateChooserInicio.setDate(Date.from(evento.getFechaInicio().atZone(ZoneId.systemDefault()).toInstant()));
        jDateChooserFin.setDate(Date.from(evento.getFechaFin().atZone(ZoneId.systemDefault()).toInstant()));

        int confirmation = JOptionPane.showConfirmDialog(null, "¿Quieres modificar el evento?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            // Actualizar los valores en el evento basado en los campos de la GUI
            String nuevoTitulo = jTextFieldTitulo.getText();
            String nuevaDescripcion = jTextAreaDescripcion.getText();
            String nuevoLugar = jTextFieldLugar.getText();
            LocalDateTime nuevaFechaInicio = jDateChooserInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime nuevaFechaFin = jDateChooserFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            // Validar que la fecha final sea posterior o igual a la fecha de inicio
            if (nuevaFechaFin.isBefore(nuevaFechaInicio)) {
                JOptionPane.showMessageDialog(null, "La fecha de fin debe ser posterior o igual a la fecha de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Establecer los nuevos valores en el evento
            evento.setTitulo(nuevoTitulo);
            evento.setDescripcion(nuevaDescripcion);
            evento.setLugar(nuevoLugar);
            evento.setFechaInicio(nuevaFechaInicio);
            evento.setFechaFin(nuevaFechaFin);

            JOptionPane.showMessageDialog(null, "Evento actualizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}