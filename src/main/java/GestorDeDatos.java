import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GestorDeDatos {
    private ArrayList<Evento> eventosEnlistados; // Lista de eventos
    private static final String NOMBRE_ARCHIVO = "RegistroDeConsistenciaDeDatos/RegistroDatos.csv"; // Ruta para registro de datos
    private static final String CARPETA_REPORTES = "Reportes"; // Carpeta para los reportes
    private static final String CARPETA_REGISTRO= "RegistroDeConsistenciaDeDatos"; // Carpeta para los reportes
    private static final long RETARDO_REINTENTO_MS = 5000; // Tiempo de espera entre reintentos (5 segundos)
    Agenda agenda = Agenda.getInstancia();
    
    public GestorDeDatos() {
        eventosEnlistados = new ArrayList<>();
    }
    
    private void escribirDatos(BufferedWriter writer) throws IOException {
        // Escribir encabezados
        writer.write("ID,Título,Descripción,FechaInicio,FechaFin,Lugar,Participantes,Etiquetas");
        writer.newLine();
        
        // Escribir datos de cada evento
        for (Evento evento : agenda.getEventosEnlistados()) {
            writer.write(evento.getId() + "," +
                    evento.getTitulo() + "," +
                    evento.getDescripcion() + "," +
                    evento.getFechaInicio().toString() + "," +
                    evento.getFechaFin().toString() + "," +
                    evento.getLugar() + "," +
                    listaParticipantesComoTexto(evento.getParticipantes()) + "," +
                    listaEtiquetasComoTexto(evento.getEtiquetas()));
            writer.newLine();
        }
    }
    
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
                    System.out.println("Datos guardados exitosamente en: " + NOMBRE_ARCHIVO);
                    break; // Salir del bucle si la escritura fue exitosa
                }
            } catch (IOException e) {
                System.out.println("Error al guardar en el archivo original: " + e.getMessage());
                System.out.println("Guardando en archivo temporal...");
                
                // Si no se puede guardar en el archivo original, guardar en el archivo temporal
                try (BufferedWriter writerTemp = new BufferedWriter(new FileWriter(archivoTemporal))) {
                    escribirDatos(writerTemp);
                    System.out.println("Datos guardados temporalmente en: " + archivoTemporal.getName());
                } catch (IOException ex) {
                    System.out.println("Error al guardar en el archivo temporal: " + ex.getMessage());
                    break; // Si ni siquiera se puede guardar en el archivo temporal, romper el bucle
                }
                
                // Reintentar después de un tiempo
                try {
                    System.out.println("Reintentando en " + (RETARDO_REINTENTO_MS / 1000) + " segundos...");
                    Thread.sleep(RETARDO_REINTENTO_MS); // Esperar antes de intentar nuevamente
                } catch (InterruptedException ie) {
                    System.out.println("Proceso interrumpido: " + ie.getMessage());
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
                System.out.println("Archivo original reemplazado exitosamente con el archivo temporal.");
            } catch (IOException e) {
                System.out.println("Error al reemplazar el archivo original: " + e.getMessage());
            }
        }
    }
    
    public void cargarDatos() throws PersistenciaException {
        ArrayList<Evento> eventos = new ArrayList<>();
        Path path = Paths.get(NOMBRE_ARCHIVO);
        
        if (Files.exists(path)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
                // Saltar encabezados
                reader.readLine();
                
                String linea;
                
                while ((linea = reader.readLine()) != null) {
                    System.out.println("Leyendo línea: " + linea);
                    String[] datos = linea.split(",");
                    if (datos.length >= 6) {
                        int id = Integer.parseInt(datos[0]);
                        String titulo = datos[1];
                        String descripcion = datos[2];
                        LocalDateTime fechaInicio = LocalDateTime.parse(datos[3]);
                        LocalDateTime fechaFin = LocalDateTime.parse(datos[4]);
                        String lugar = datos[5];
                        ArrayList<Participante> participantes = new ArrayList<>();
                        ArrayList<Etiqueta> etiquetas = new ArrayList<>();
                        
                        // Verificar si hay participantes
                        if (datos.length > 6 && !datos[6].isEmpty()) {
                            // Aquí se agregarían los participantes si los hubiera
                        }
                        
                        // Verificar si hay etiquetas
                        if (datos.length > 7 && !datos[7].isEmpty()) {
                            // Aquí se agregarían las etiquetas si las hubiera
                        }
                        
                        Evento nuevoEvento = new Evento(id, titulo, descripcion, fechaInicio, fechaFin, lugar, etiquetas, participantes);
                        agenda.agregarEvento(nuevoEvento);
                    }
                }
                
                System.out.println("Datos cargados exitosamente desde: " + NOMBRE_ARCHIVO);
            } catch (IOException e) {
                throw new PersistenciaException("Error al cargar los datos: " + e.getMessage());
            } catch (Exception e) {
                throw new PersistenciaException("Error en el formato de los datos: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró un archivo desde el cuál cargar datos. ");
            System.out.println("Intentando crear uno nuevo...");
        }
    }
    
    public void generarReporteEventos(String nombreArchivo) {
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
            writer.write("ID,Título,Descripción,FechaInicio,FechaFin,Lugar,Participantes,Etiquetas");
            writer.newLine();
            
            for (Evento evento : agenda.getEventosEnlistados()) {
                writer.write(evento.getId() + "," +
                        evento.getTitulo() + "," +
                        evento.getDescripcion() + "," +
                        evento.getFechaInicio().toString() + "," +
                        evento.getFechaFin().toString() + "," +
                        evento.getLugar() + "," +
                        listaParticipantesComoTexto(evento.getParticipantes()) + "," +
                        listaEtiquetasComoTexto(evento.getEtiquetas()));
                writer.newLine();
            }
            
            System.out.println("Reporte generado exitosamente en: " + archivo.getPath());
            
        } catch (IOException e) {
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }
    }
    
    private String listaParticipantesComoTexto(ArrayList<Participante> participantes) {
        StringBuilder sb = new StringBuilder();
        for (Participante p : participantes) {
            sb.append(p.getNombre()).append(" ");
        }
        return sb.toString().trim();
    }
    
    private String listaEtiquetasComoTexto(ArrayList<Etiqueta> etiquetas) {
        StringBuilder sb = new StringBuilder();
        for (Etiqueta e : etiquetas) {
            sb.append(e.getNombre()).append(" ");
        }
        return sb.toString().trim();
    }
}
