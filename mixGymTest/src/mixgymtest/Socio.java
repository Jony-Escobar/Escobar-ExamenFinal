package mixgymtest;

/**
 *
 * @author jonat
 */
public class Socio {
    private String nombre;
    private String dni;

    // Constructor
    public Socio(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Método para comparar socios
    public boolean sociosDiferentes(Socio otro) {
        return !this.dni.equals(otro.dni);
    }
}
