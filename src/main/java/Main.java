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
        
    public static void main(String[] args) throws IOException,PersistenciaException,GUIException {
        //Definicion de variables
        Agenda agenda = Agenda.getInstancia(); // Crear una nueva agenda
        
        GestorDeDatos gestorDeDatos = new GestorDeDatos(); // Crear un getso de datos
        
        // Cargar eventos al iniciar la aplicaciÖân
        try {
            gestorDeDatos.cargarDatos();
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al cargar los eventos: " + e.getMessage());
        }
        
        if (agenda.getEventosEnlistadosLargo() == 0){
            agenda.inicializarEventosDePrueba(); // Inicializar eventos de prueba
            gestorDeDatos.guardarDatos();
        }
        
        try {
            // Forzar la codificaciÖân a UTF-8
            System.setProperty("file.encoding", "UTF-8");
        
            // Crear el JFrame (ventana)
            JFrame frame = new JFrame("MenÖè Principal");
            
            
            // Crear una instancia del JPanel (MenuPrincipal)
            MenuPrincipal menuPanel = new MenuPrincipal(gestorDeDatos);

            // AÖáadir el JPanel al JFrame
            frame.add(menuPanel);

            // Establecer las propiedades del JFrame
            frame.setSize(1600, 800);  // Ajusta el tamaÖáo segÖèn tus necesidades
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cierra la aplicaciÖân al cerrar la ventana
            frame.setVisible(true);  // Hacer visible la ventana

            
        } catch (GUIException e) {
            throw new GUIException("Ha ocurrido un error inesperado al intentar crear la ventana: " + e.getMessage());
        } 
    }
}
