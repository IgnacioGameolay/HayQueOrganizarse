
//Clase Etiqueta que representa una etiqueta con un identificador y un nombre.
public class Etiqueta {
    private int id; // Identificador único de la etiqueta
    private String nombre; // Nombre de la etiqueta
    
    //Constructor de la clase Etiqueta.
    //@param id     Identificador único de la etiqueta.
    //@param nombre Nombre de la etiqueta.
    
    public Etiqueta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters

    //Obtiene el identificador de la etiqueta.
    //@return El identificador de la etiqueta.
    
    public int getId() {
        return id;
    }
    
    //Establece el identificador de la etiqueta.
    //@param id El identificador a establecer.
    
    public void setId(int id) {
        this.id = id;
    }
    
    //Obtiene el nombre de la etiqueta.
    //@return El nombre de la etiqueta.
    
    public String getNombre() {
        return nombre;
    }

    //Establece el nombre de la etiqueta.
    //@param nombre El nombre a establecer.
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}