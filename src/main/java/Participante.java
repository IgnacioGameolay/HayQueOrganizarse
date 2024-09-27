public class Participante {
    // Atributos privados de la clase
    
    private String nombre; // Nombre del participante
    private String email; // Email del participante
    private String rol;  // Rol del participante en el evento (por ejemplo, organizador, asistente, etc.)


     //* Constructor de la clase Participante.
     //* @param nombre El nombre del participante.
     //* @param email  El correo electrónico del participante.
     //* @param rol    El rol del participante en el evento.
    
    public Participante(String nombre, String email, String rol) {
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    // Getters y Setters

    //* Obtiene el nombre del participante.
    //* @return El nombre del participante.
    public String getNombre() {
        return nombre;
    }

    //* Establece el nombre del participante.
    //* @param nombre El nuevo nombre del participante.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    //* Obtiene el correo electrónico del participante.
    //* @return El correo electrónico del participante.
    public String getEmail() {
        return email;
    }

    //* Establece el correo electrónico del participante.
    //* @param email El nuevo correo electrónico del participante.
    public void setEmail(String email) {
        this.email = email;
    }

    //* Obtiene el rol del participante en el evento.
    //* @return El rol del participante.
    public String getRol() {
        return rol;
    }

    //* Establece el rol del participante en el evento.
    //* @param rol El nuevo rol del participante.
    public void setRol(String rol) {
        this.rol = rol;
    }
    // Sobrescribir el método toString() para mostrar detalles del participante
    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }

    // Sobrescribir el método equals() para comparar participantes por el email
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // Si es el mismo objeto, son iguales
        if (o == null || getClass() != o.getClass()) return false;  // Si no es de la misma clase, son diferentes
        Participante that = (Participante) o;  // Cast al tipo Participante
        return email.equals(that.email);  // Comparamos por el email, que debe ser único
    }

    // Sobrescribir el método hashCode() basado en el email
    @Override
    public int hashCode() {
        return email.hashCode();  // El hashCode se genera a partir del email
    }
}
