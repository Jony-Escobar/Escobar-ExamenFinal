import java.time.LocalDate;
import mixgymtest.PaseMensual;
import mixgymtest.Socio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonat
 */
public class mixGymTest {

    private static Socio s1;
    private static Socio s2;
    private static PaseMensual pase;

    @BeforeClass
    public static void antesDeTodo() {
        // Inicializa los socios y el pase
        s1 = new Socio("Tu Nombre", "12345678");
        s2 = new Socio("Pablo", "87654321");
        pase = new PaseMensual(8, LocalDate.now().plusMonths(1)); // Pase con 8 clases y fecha de fin en un mes
        System.out.println("Inicialización antes de las pruebas.");
    }

    @AfterClass
    public static void despuesDeTodo() {
        // Muestra la fecha de ayer y el mensaje de fin de pruebas
        LocalDate ayer = LocalDate.now().minusDays(1);
        System.out.println("Fin de las pruebas. Fecha de ayer: " + ayer);
    }

    @Before
    public void antesDeCadaTest() {
        System.out.println("Inicio del test.");
    }

    @After
    public void despuesDeCadaTest() {
        System.out.println("Fin del test.");
    }

    // Métodos de prueba
    @Test
    public void testSociosDiferentes() {
        // Verifica que los socios sean diferentes
        assertNotSame("Los socios no deben ser iguales", s1, s2);
        assertFalse("Los socios deben ser diferentes", s1.sociosDiferentes(s2));
    }

    @Test
    public void descontarPaseTest() {
        // Descuenta una clase del pase y verifica el resultado
        pase.descuentoClase();
        assertEquals("El pase debería tener 7 clases restantes", 7, pase.getClasesRestantes());
    }

    @Test
    public void descontarPaseTest2() {
        // Prueba que falla intencionalmente para pase sin clases
        pase.setClasesRestantes(0); // Simula un pase sin clases
        pase.descuentoClase();
        assertEquals("El pase debería mostrar 'sin clases'", 0, pase.getClasesRestantes());
    }

    @Test(expected = IllegalStateException.class)
    public void descontarPaseTest3() {
        // Simula pase vencido y espera una excepción
        pase.setFechaFin(LocalDate.now().minusDays(1)); // Fecha vencida
        pase.descuentoClase();
    }

    @Test
    public void comprarGatoradeTest() {
        // Verifica el precio con código promocional
        int precioEsperado = 1050;
        int precioCobrado = pase.calcularPrecioGatorade("2x1");
        assertEquals("El precio debería ser 1050 con el código '2x1'", precioEsperado, precioCobrado);
    }

    @Test(timeout = 30)
    public void noAndaElCheck() throws InterruptedException {
        // Prueba que falla por timeout
        Thread.sleep(60); // Simula una operación lenta
    }
}
