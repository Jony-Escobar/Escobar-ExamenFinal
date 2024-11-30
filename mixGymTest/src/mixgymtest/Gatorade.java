package mixgymtest;

/**
 *
 * @author jonat
 */
public class Gatorade {
    private double precio;

    // Constructor
    public Gatorade(double precio) {
        this.precio = precio;
    }

    // Método para comprar Gatorade con código "2x1"
    public double comprar(String codigo) {
        if ("2x1".equals(codigo)) {
            return precio; // Cobrar solo un Gatorade
        }
        return precio * 2; // Si no es "2x1", cobrar dos Gatorades
    }

    // Getters y Setters
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
