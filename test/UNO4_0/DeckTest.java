package UNO4_0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link Deck}.
 * Verifica el correcto funcionamiento del mazo de cartas,
 * incluyendo creación, robo de cartas y barajado.
 */
class DeckTest {

    /**
     * Prueba que al robar una carta del mazo,
     * el resultado no sea nulo.
     */
    @Test
    void testRoboCartaNoNull() {
        Deck deck = new Deck();
        assertNotNull(deck.robarCarta());
    }

    /**
     * Prueba que el constructor de Deck inicializa correctamente el mazo.
     * Verifica que no se lance ninguna excepción al robar una carta.
     */
    @Test
    void testConstructorEjecutaCreacion() {
        Deck deck = new Deck();
        assertDoesNotThrow(() -> deck.robarCarta());
    }

    /**
     * Prueba que el método barajar no rompe la funcionalidad del mazo.
     * Después de barajar, aún debe ser posible robar cartas válidas.
     */
    @Test
    void testBarajarNoRompeMazo() {
        Deck deck = new Deck();
        deck.barajar();
        assertNotNull(deck.robarCarta());
    }
}