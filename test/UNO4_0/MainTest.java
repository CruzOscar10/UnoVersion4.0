package UNO4_0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link Main}.
 * Verifica la correcta instanciación de la clase principal.
 */
class MainTest {

    /**
     * Prueba que el constructor de Main funcione correctamente.
     * Verifica que se pueda crear una instancia sin que sea nula.
     */
    @Test
    void testConstructorMain() {
        Main m = new Main();
        assertNotNull(m);
    }
}