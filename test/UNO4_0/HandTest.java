package UNO4_0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link Hand}.
 * Verifica la gestión de cartas en la mano de un jugador,
 * incluyendo inserción y estado inicial.
 */
class HandTest {

    /**
     * Prueba el método agregar.
     * Verifica que al añadir una carta, el tamaño de la mano aumente
     * y la carta pueda recuperarse correctamente.
     */
    @Test
    void testAgregarCarta() {
        Hand hand = new Hand();
        Card c = new Card("rojo", 5);

        hand.agregar(c);

        assertEquals(1, hand.size());
        assertEquals(c, hand.obtenerCarta(0));
    }

    /**
     * Prueba que una mano nueva esté vacía.
     * Verifica que el método vacia retorne true al inicio.
     */
    @Test
    void testVaciaInicial() {
        Hand hand = new Hand();
        assertTrue(hand.vacia());
    }
}