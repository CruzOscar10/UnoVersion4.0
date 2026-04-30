package UNO4_0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link Card}.
 * Verifica la correcta creación, comportamiento y modificación de objetos Card.
 */
class CardTest {

    /**
     * Prueba la creación de una carta numérica.
     * Verifica que el color, tipo y número se asignen correctamente.
     */
    @Test
    void testCrearCartaNumero() {
        Card carta = new Card("rojo", 7);
        assertEquals("rojo", carta.getColor());
        assertEquals(Card.Tipo.NUMERO, carta.getTipo());
        assertEquals(7, carta.getNumero());
    }

    /**
     * Prueba la creación de una carta especial (no numérica).
     * Verifica que el tipo se asigne correctamente y que el número sea -1.
     */
    @Test
    void testCrearCartaEspecial() {
        Card carta = new Card("azul", Card.Tipo.SALTO);
        assertEquals("azul", carta.getColor());
        assertEquals(Card.Tipo.SALTO, carta.getTipo());
        assertEquals(-1, carta.getNumero());
    }

    /**
     * Prueba el método toString para una carta numérica.
     * Verifica que el formato de salida sea "color número".
     */
    @Test
    void testToStringNumero() {
        Card carta = new Card("verde", 5);
        assertEquals("verde 5", carta.toString());
    }

    /**
     * Prueba el método setColor.
     * Verifica que el color de la carta se actualice correctamente.
     */
    @Test
    void testSetColor() {
        Card carta = new Card("rojo", 2);
        carta.setColor("azul");
        assertEquals("azul", carta.getColor());
    }
}