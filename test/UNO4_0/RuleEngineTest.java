package UNO4_0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link RuleEngine}.
 * Verifica las reglas básicas de validación de jugadas en el juego UNO.
 */
class RuleEngineTest {

    /**
     * Prueba que una carta negra (comodín) siempre sea válida.
     * Independientemente de la carta en la mesa.
     */
    @Test
    void testCartaNegraSiempreValida() {
        RuleEngine r = new RuleEngine();
        Card c = new Card("negro", Card.Tipo.COMODIN);
        Card mesa = new Card("rojo", 5);
        assertTrue(r.esJugadaValida(c, mesa));
    }

    /**
     * Prueba que una carta con el mismo color que la carta en la mesa sea válida.
     */
    @Test
    void testMismoColorValido() {
        RuleEngine r = new RuleEngine();
        Card c = new Card("rojo", 3);
        Card mesa = new Card("rojo", 8);

        assertTrue(r.esJugadaValida(c, mesa));
    }

    /**
     * Prueba que una carta con el mismo número que la carta en la mesa sea válida,
     * aunque el color sea diferente.
     */
    @Test
    void testMismoNumeroValido() {
        RuleEngine r = new RuleEngine();

        Card c = new Card("azul", 5);
        Card mesa = new Card("rojo", 5);

        assertTrue(r.esJugadaValida(c, mesa));
    }
}