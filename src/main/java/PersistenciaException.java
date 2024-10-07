
public class PersistenciaException extends Exception {
    public PersistenciaException(String mensaje) {
        /**
     * Constructor que inicializa una nueva instancia de {@link PersistenciaException} con un mensaje específico.
     *
     * @param mensaje El mensaje de error que describe la causa de la excepción.
     */
        super(mensaje);
    }
}
