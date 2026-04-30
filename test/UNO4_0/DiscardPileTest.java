package UNO4_0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link DiscardPile}.
 * Verifica el comportamiento de la pila de descarte,
 * incluyendo su estado inicial y la inserción de cartas.
 */
class DiscardPileTest {

    /**
     * Prueba que la pila de descarte inicia vacía.
     * Verifica que la cima sea null al crear una nueva instancia.
     */
    @Test
    void testPilaIniciaVacia() {
        DiscardPile pila = new DiscardPile();
        assertNull(pila.cima());
    }

    /**
     * Prueba el método poner.
     * Verifica que al agregar una carta,
     * esta quede como la carta en la cima de la pila.
     */
    @Test
    void testPonerUnaCarta() {
        DiscardPile pila = new DiscardPile();
        Card carta = new Card("rojo", 5);

        pila.poner(carta);

        assertEquals(carta, pila.cima());
    }
}