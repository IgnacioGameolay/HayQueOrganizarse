import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

public class Main {
    

    private static void MostrarMenu() {
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
        Agenda agenda = new Agenda();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        MostrarMenu();
        String opcion = lector.readLine();

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

        LocalDateTime fechaInicio;
        while (true) {
            System.out.print("Ingrese la fecha de inicio del evento (dd/MM/yyyy): ");
            String fechaInicioStr = lector.readLine();

            String horaInicioStr;
            while (true) {
                System.out.print("Ingrese la hora de inicio del evento (HH:mm en formato 24 hrs): ");
                horaInicioStr = lector.readLine();
                if (horaValida(horaInicioStr)) break;
                else System.out.println("Hora inválida. Intente nuevamente.");
            }

            fechaInicio = parsearFechaYHora(fechaInicioStr, horaInicioStr);
            if (fechaInicio == null) {
                System.out.println("Por favor, ingrese nuevamente la fecha y la hora.");
            } else if (fechaInicio.isBefore(LocalDateTime.now())) {
                System.out.println("Advertencia: La fecha y hora del evento es anterior a la actual.");
                System.out.print("¿Desea guardar el evento de todos modos? (sí/no): ");
                String confirmacion = lector.readLine().trim().toLowerCase();
                if (confirmacion.equals("sí") || confirmacion.equals("si")) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese una nueva fecha y hora de inicio.");
                }
            } else {
                break;
            }
        }

        System.out.println("=========================");
        System.out.print("¿La fecha de término es la misma que la de inicio? (sí/no): ");
        String mismaFecha = lector.readLine().trim().toLowerCase();

        LocalDateTime fechaFin;
        if (mismaFecha.equals("sí") || mismaFecha.equals("si")) {
            fechaFin = fechaInicio;
        } else {
            while (true) {
                System.out.print("Ingrese la fecha de término del evento (dd/MM/yyyy): ");
                String fechaFinStr = lector.readLine();

                String horaFinStr;
                while (true) {
                    System.out.print("Ingrese la hora de término del evento (HH:mm en formato 24 hrs): ");
                    horaFinStr = lector.readLine();
                    if (horaValida(horaFinStr)) break;
                    else System.out.println("Hora inválida. Intente nuevamente.");
                }

                fechaFin = parsearFechaYHora(fechaFinStr, horaFinStr);
                if (fechaFin == null || fechaFin.isBefore(fechaInicio)) {
                    System.out.println("La fecha y hora de término debe ser posterior a la fecha y hora de inicio. Intente nuevamente.");
                } else {
                    break;
                }
            }
        }

        System.out.println("=========================");
        System.out.print("Ingrese el lugar del evento: ");
        String lugar = lector.readLine();
        System.out.println("=========================");

        Evento evento = new Evento(id, titulo, descripcion, fechaInicio, fechaFin, lugar);
        evento.MostrarEvento();
        agenda.agregarEvento(evento);
        System.out.println("=========================");





        System.out.println("=========================");
        System.out.println("Buscando evento por mes...");
        System.out.println("=========================");
        System.out.println("Ingrese mes a buscar");
        String mesBuscado = lector.readLine();
        System.out.println("Ingrese anio a buscar");
        String anioBuscado = lector.readLine();
        agenda.buscarEventosPorMes(mesBuscado, anioBuscado);
        System.out.println("=========================");



        
    }

    private static boolean horaValida(String hora) {
        try {
            LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

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
            System.out.println("Error: Formato de fecha o hora inválido. Por favor, ingrese la fecha en el formato dd/MM/yyyy y la hora en el formato HH:mm.");
            return null;
        }
    }
}
