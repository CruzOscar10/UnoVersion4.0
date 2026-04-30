package UNO4_0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link Player}.
 * Verifica la correcta creación de jugadores y su estado inicial.
 */
class PlayerTest {

    /**
     * Prueba la creación de un jugador no humano (IA).
     * Verifica que el nombre y el tipo de jugador se asignen correctamente.
     */
    @Test
    void testCrearJugadorIA() {
        Player p = new Player("Bot", false);

        assertEquals("Bot", p.getNombre());
        assertFalse(p.esHumano());
    }

    /**
     * Prueba el estado inicial del indicador "UNO".
     * Verifica que al crear un jugador, no haya declarado UNO.
     */
    @Test
    void testDijoUnoInicialFalse() {
        Player p = new Player("Test", true);

        assertFalse(p.dijoUno());
    }
}