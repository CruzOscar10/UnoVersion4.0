package UNO4_0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link Game}.
 * Verifica la correcta inicialización del juego y la interacción básica
 * al jugar cartas sobre la mesa.
 */
class GameTest {

    /**
     * Prueba que el juego se inicialice correctamente.
     * Verifica que los componentes principales no sean nulos.
     */
    @Test
    void testInicializacionGame() {
        Game game = new Game();
        assertNotNull(game.getDeck());
        assertNotNull(game.getRuleEngine());
        assertNotNull(game.getTurnManager());
        assertNotNull(game.getJugadores());
    }

    /**
     * Prueba el método jugarCarta.
     * Verifica que al jugar una carta, esta se coloque correctamente en la mesa.
     */
    @Test
    void testAgregarCartaMesa() {
        Game game = new Game();
        Card carta = new Card("rojo", 5);
        Player jugador = new Player("Test", true);

        game.jugarCarta(jugador, carta);

        assertEquals(carta, game.getCartaMesa());
    }
}