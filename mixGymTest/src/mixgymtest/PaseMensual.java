package mixgymtest;
import java.time.LocalDate;
/**
 *
 * @author jonat
 */
public class PaseMensual {
    private int clasesRestantes;
    private LocalDate fechaFin;

    // Constructor
    public PaseMensual(int clasesRestantes, LocalDate fechaFin) {
        this.clasesRestantes = clasesRestantes;
        this.fechaFin = fechaFin;
    }

    // Getters y Setters
    public int getClasesRestantes() {
        return clasesRestantes;
    }

    public void setClasesRestantes(int clasesRestantes) {
        this.clasesRestantes = clasesRestantes;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Método para descontar clases
    public void descuentoClase() {
        if (this.clasesRestantes > 0) {
            this.clasesRestantes--;
        } else {
            throw new IllegalStateException("Pase sin entradas");
        }
    }

    public int calcularPrecioGatorade(String codigoPromocional) {
        int precioBase = 2000; // Precio base en pesos
        if ("2x1".equals(codigoPromocional)) {
            return precioBase / 2;
        }
        return precioBase;
    }
}
