import java.time.*;
import java.util.*;
import java.io.*;

public class Main {


  private static void MostrarMenu(){
      System.out.println("=== Menú de la Agenda ===");
      System.out.println("1. Agregar un evento");
      System.out.println("2. Buscar eventos por día");
      System.out.println("3. Buscar eventos por semana");
      System.out.println("4. Buscar eventos por mes");
      System.out.println("5. Buscar eventos por etiqueta");
      System.out.println("6. Salir");
      System.out.print("Elige una opción: ");
  }


  
  public static void main(String[] args) throws IOException {
    System.out.println("Hello world!");
    
    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    MostrarMenu();
    String opcion;
    opcion = lector.readLine();

    System.out.println("=========================");
    System.out.println("Creando evento...");
    System.out.println("=========================");
    System.out.print("Ingrese el id del evento: ");
    int id = Integer.parseInt(lector.readLine());
    System.out.println("=========================");
    System.out.print("Ingrese el título del evento: ");
    String titulo = lector.readLine();
    System.out.println("=========================");
    System.out.print("Ingrese la descripción del evento: ");
    String descripcion = lector.readLine();
    System.out.println("=========================");
    System.out.print("Ingrese la fecha de inicio del evento" + "(dd/mm/yyyy): ");
    String lugar = lector.readLine();
    System.out.println("=========================");

    Evento evento = new Evento(id, titulo, descripcion, lugar);
    evento.MostrarEvento();
    System.out.println("=========================");
  }

}
