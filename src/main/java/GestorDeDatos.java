import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 * Clase encargada de gestionar la persistencia de datos de eventos.
 * Proporciona métodos para guardar y cargar eventos desde un archivo CSV,
 * así como para generar reportes de eventos.
 */
public class GestorDeDatos {
    private ArrayList<Evento> eventosEnlistados; // Lista de eventos
    private static final String NOMBRE_ARCHIVO = "RegistroDeConsistenciaDeDatos/RegistroDatos.csv"; // Ruta para registro de datos
    private static final String CARPETA_REPORTES = "Reportes"; // Carpeta para los reportes
    private static final String CARPETA_REGISTRO= "RegistroDeConsistenciaDeDatos"; // Carpeta para los reportes
    private static final long RETARDO_REINTENTO_MS = 5000; // Tiempo de espera entre reintentos (5 segundos)
    Agenda agenda = Agenda.getInstancia();
    
    /**
     * Constructor que inicializa una nueva instancia de {@link GestorDeDatos}.
     * Se inicializa la lista de eventos enlistados.
     */
    public GestorDeDatos() {
        eventosEnlistados = new ArrayList<>();
    }
    
    /**
     * Método privado que escribe los datos de los eventos en el archivo CSV.
     * 
     * @param writer El BufferedWriter utilizado para escribir en el archivo.
     * @throws IOException Si ocurre un error durante la escritura en el archivo.
     */
    private void escribirDatos(BufferedWriter writer) throws IOException {
        // Escribir encabezados
        writer.write("ID,Título,Descripción,FechaInicio,FechaFin,Lugar,Etiquetas");
        writer.newLine();
        
        // Escribir datos de cada evento
        for (Evento evento : agenda.getEventosEnlistados()) {
            writer.write(evento.getId() + "," +
                    evento.getTitulo() + "," +
                    evento.getDescripcion() + "," +
                    evento.getFechaInicio().toString() + "," +
                    evento.getFechaFin().toString() + "," +
                    evento.getLugar() + "," +
                    listaEtiquetasComoTexto(evento.getEtiquetas()));
            writer.newLine();
        }
    }
    
    /**
     * Método que guarda los datos de los eventos en un archivo CSV.
     * Intenta escribir en el archivo original y, en caso de error, 
     * escribe en un archivo temporal y reintenta.
     */
    public void guardarDatos() {
        File archivoRegistro = new File(NOMBRE_ARCHIVO);
        File carpetaRegistro = archivoRegistro.getParentFile();
        
        // Verificar si la carpeta existe, si no, crearla
        if (carpetaRegistro != null && !carpetaRegistro.exists()) {
            carpetaRegistro.mkdirs();
        }
        
        File archivoTemporal = new File(CARPETA_REGISTRO + File.separator + "temp_RegistroDeConsistenciaDeDatos.csv");
        
        while (true) {  // Bucle que seguirá intentando hasta que pueda escribir en el archivo original
            try {
                // Intentar escribir directamente en el archivo original
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoRegistro))) {
                    escribirDatos(writer);
                    break; // Salir del bucle si la escritura fue exitosa
                }
            } catch (IOException e) {
                // Si no se puede guardar en el archivo original, guardar en el archivo temporal
                try (BufferedWriter writerTemp = new BufferedWriter(new FileWriter(archivoTemporal))) {
                    escribirDatos(writerTemp);
                } catch (IOException ex) {
                   break; // Si ni siquiera se puede guardar en el archivo temporal, romper el bucle
                }
                
                // Reintentar después de un tiempo
                try {
                    JOptionPane.showMessageDialog(null, "Cierre el archivo de Registro durante "
                            + "la ejecución del programa para poder guardar... Reintentando en " + (RETARDO_REINTENTO_MS / 1000) + " segundos...", "Error", JOptionPane.ERROR_MESSAGE);
                    Thread.sleep(RETARDO_REINTENTO_MS); // Esperar antes de intentar nuevamente
                } catch (InterruptedException ie) {
                    JOptionPane.showMessageDialog(null, "\"Proceso interrumpido: \" + ie.getMessage()", "Error", JOptionPane.ERROR_MESSAGE);
                    break; // Si el hilo es interrumpido, salir del bucle
                }
            }
        }
        
        // Si los datos fueron guardados temporalmente, intentar reemplazar el archivo original de manera más segura
        if (archivoTemporal.exists()) {
            try {
                Path sourcePath = archivoTemporal.toPath();
                Path targetPath = archivoRegistro.toPath();           
               // Usar Files.move para reemplazar el archivo de manera más confiable
                Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
            }
        }
    }
    
    
    /**
     * Método que carga los datos de los eventos desde un archivo CSV.
     * 
     * @throws PersistenciaException Si ocurre un error al cargar los datos o si el formato es incorrecto.
     */
    public void cargarDatos() throws PersistenciaException {
        ArrayList<Evento> eventos = new ArrayList<>();
        Path path = Paths.get(NOMBRE_ARCHIVO);
        
        if (Files.exists(path)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
                // Saltar encabezados
                reader.readLine();
                
                String linea;
                
                while ((linea = reader.readLine()) != null) {
                    String[] datos = linea.split(",");
                    if (datos.length >= 6) {
                        int id = Integer.parseInt(datos[0]);
                        String titulo = datos[1];
                        String descripcion = datos[2];
                        LocalDateTime fechaInicio = LocalDateTime.parse(datos[3]);
                        LocalDateTime fechaFin = LocalDateTime.parse(datos[4]);
                        String lugar = datos[5];
                        ArrayList<Etiqueta> etiquetas = new ArrayList<>();
                        
                        
                        // Verificar si hay etiquetas
                        if (datos.length > 7 && !datos[7].isEmpty()) {
                            // Aquí se agregarían las etiquetas si las hubiera
                        }
                        
                        Evento nuevoEvento = new Evento(id, titulo, descripcion, fechaInicio, fechaFin, lugar, etiquetas);
                        agenda.agregarEvento(nuevoEvento);
                    }
                }
                
            } catch (IOException e) {
                throw new PersistenciaException("Error al cargar los datos: " + e.getMessage());
            } catch (Exception e) {
                throw new PersistenciaException("Error en el formato de los datos: " + e.getMessage());
            }
        }
    }
    
    /**
     * Método que genera un reporte de eventos y lo guarda en un archivo de texto.
     * 
     * @param nombreArchivo El nombre del archivo donde se guardará el reporte.
     * @throws PersistenciaException Si ocurre un error al generar el reporte.
     */
    public void generarReporteEventos(String nombreArchivo) throws PersistenciaException{
        if (!nombreArchivo.endsWith(".txt")) {
            nombreArchivo += ".txt";
        }
        
        String directorioTrabajo = System.getProperty("user.dir") + File.separator + CARPETA_REPORTES;
        File carpeta = new File(directorioTrabajo);
        
        // Verificar si la carpeta existe, si no, crearla
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        
        File archivo = new File(carpeta, nombreArchivo);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write("ID,Título,Descripción,FechaInicio,FechaFin,Lugar,Etiquetas");
            writer.newLine();
            
            for (Evento evento : agenda.getEventosEnlistados()) {
                writer.write(evento.getId() + "," +
                        evento.getTitulo() + "," +
                        evento.getDescripcion() + "," +
                        evento.getFechaInicio().toString() + "," +
                        evento.getFechaFin().toString() + "," +
                        evento.getLugar() + "," +
                        listaEtiquetasComoTexto(evento.getEtiquetas()));
                writer.newLine();
            }
            
            
            JOptionPane.showMessageDialog(null, "Reporte generado exitosamente en: " + archivo.getPath());
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage());
            
        }
    }
    
    /**
     * Método privado que convierte una lista de etiquetas en un texto separado por espacios.
     * 
     * @param etiquetas La lista de etiquetas a convertir.
     * @return Una cadena de texto que representa las etiquetas.
     */
    private String listaEtiquetasComoTexto(ArrayList<Etiqueta> etiquetas) {
        StringBuilder sb = new StringBuilder();
        for (Etiqueta e : etiquetas) {
            sb.append(e.getNombre()).append(" ");
        }
        return sb.toString().trim();
    }
}
