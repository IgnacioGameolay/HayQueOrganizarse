/**
 * Excepción personalizada que representa errores específicos en la interfaz gráfica de usuario (GUI).
 * Esta clase extiende la clase {@link Exception} para proporcionar información adicional sobre 
 * errores relacionados con la GUI en la aplicación.
 * 
 */
public class GUIException extends Exception {
    /**
     * Constructor que inicializa una nueva instancia de {@link GUIException} con un mensaje específico.
     *
     * @param mensaje El mensaje de error que describe la causa de la excepción.
     */
    public GUIException(String mensaje) {
        super(mensaje);
    }
}

