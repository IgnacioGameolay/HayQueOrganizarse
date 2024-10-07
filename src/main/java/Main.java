import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;

public class Main {
    
    //* Muestra el menú principal de la agenda con las opciones disponibles.
    
    private static void MostrarMenu() {
        System.out.println("=== Menú de la Agenda ===");
        System.out.println("1. Agregar un evento");
        System.out.println("2. Mostrar todos los eventos");
        System.out.println("3. Editar evento por ID");
        System.out.println("4. Buscar eventos por día");
        System.out.println("5. Buscar eventos por semana");
        System.out.println("6. Buscar eventos por mes");
        System.out.println("7. Buscar eventos por etiqueta");
        System.out.println("8. Generar reporte de eventos");
        System.out.println("9. Salir");
        System.out.println("10. Filtrar eventos");
        System.out.println("=========================");
        System.out.print("Elige una opción: ");
    }
    
    //* Función principal que inicia la ejecución del programa.
    //* @param args Argumentos de la línea de comandos.
    //* @throws IOException Manejo de excepciones de entrada y salida.
    
    public static void main(String[] args) throws IOException,PersistenciaException,GUIException {
        //Inicio del main
        
        //Definicion de variables
        Agenda agenda = Agenda.getInstancia(); // Crear una nueva agenda
        
        GestorDeDatos gestorDeDatos = new GestorDeDatos();
        
        // Cargar eventos al iniciar la aplicación
        try {
            gestorDeDatos.cargarDatos();
            System.out.println("Eventos cargados exitosamente desde el ");
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al cargar los eventos: " + e.getMessage());
        }
        
        if (agenda.getEventosEnlistadosLargo() == 0){
            agenda.inicializarEventosDePrueba(); // Inicializar eventos de prueba
            gestorDeDatos.guardarDatos();
        }
        
        try {
            // Crear el JFrame (ventana)
            JFrame frame = new JFrame("Menú Principal");

            // Crear una instancia del JPanel (MenuPrincipal)
            MenuPrincipal menuPanel = new MenuPrincipal(gestorDeDatos);

            // Añadir el JPanel al JFrame
            frame.add(menuPanel);

            // Establecer las propiedades del JFrame
            frame.setSize(1280, 720);  // Ajusta el tamaño según tus necesidades
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cierra la aplicación al cerrar la ventana
            frame.setVisible(true);  // Hacer visible la ventana

            
        } catch (GUIException e) {
            throw new GUIException("Ha ocurrido un error inesperado al intentar crear la ventana: " + e.getMessage());
        } 
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        //Bucle del menu
        String opcion = "";
        int idBuscado, diaBuscado, id;
        String anioBuscado, mesBuscado;
        do {
            //Switch de opciones
            switch (opcion){                case "3":
                    // Editar evento por ID
                    System.out.println("=========================");
                    System.out.println("Editando evento por id...");
                    System.out.println("=========================");
                    System.out.println("Ingrese la id del evento a buscar:");
                    idBuscado = Integer.parseInt(lector.readLine());
                    agenda.editarEventoPorId(idBuscado);
                    presioneTeclaParaContinuar();
                    break;

                case "7":
                    // Buscar eventos por etiqueta
                    System.out.println("=========================");
                    System.out.println("Buscando evento por Etiqueta...");
                    System.out.println("=========================");
                    System.out.println("Ingrese la etiqueta a buscar:");
                    
                    String etiqueta = lector.readLine();
                    
                    Etiqueta etiquetaBuscada = new Etiqueta(0, etiqueta);
                    
                    ArrayList<Evento> eventosEncontrados = agenda.buscarEventosPorEtiqueta(etiquetaBuscada);
                    
                    for (Evento e : eventosEncontrados) {
                        e.MostrarEvento();
                    }
                    
                    presioneTeclaParaContinuar();
                    break;
                
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida...");
                    presioneTeclaParaContinuar();
                    break;
                    
            }
            gestorDeDatos.guardarDatos();
        } while(opcion != "9");
    }
    
    
    
    
    // Funciones auxiliares
    
    //* Valida si una hora ingresada es correcta (HH:mm).
    //* @param hora Cadena que representa la hora en formato HH:mm.
    //* @return true si la hora es válida, false en caso contrario.
    
    private static boolean horaValida(String hora) {
        try {
            LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    
    //* Convierte una cadena de fecha y hora en un objeto LocalDateTime.
    //* @param fecha La fecha en formato dd/MM/yyyy.
    //* @param hora La hora en formato HH:mm.
    //* @return Un objeto LocalDateTime si la fecha y hora son válidas; null si no lo son.
    
    private static LocalDateTime parsearFechaYHora(String fecha, String hora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        try {
            if (hora.equals("24:00")) {
                LocalDate fechaBase = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                return fechaBase.plusDays(1).atStartOfDay();
            } else {
                return LocalDateTime.parse(fecha + " " + hora, formatter);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha o hora inválido.");
            System.out.println("Por favor, ingrese la fecha en el formato dd/MM/yyyy y la hora en el formato HH:mm.");
            return null;
        }
    }
    //* Limpia la pantalla de la consola.
    public static void limpiarPantalla() {
        try {
            String sistemaOperativo = System.getProperty("os.name");
            ProcessBuilder processBuilder;
            if (sistemaOperativo.contains("Windows")) {
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                processBuilder = new ProcessBuilder("clear");
            }
            Process proceso = processBuilder.inheritIO().start();
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("No se pudo limpiar la consola.");
        }
    }
    // * Pausa la ejecución hasta que el usuario presione Enter.
    public static void presioneTeclaParaContinuar(){
        System.out.println("Presione una tecla para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println("Error al leer la tecla presionada.");
        }
    }
}
