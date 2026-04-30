package UNO4_0;

import java.util.*;

/**
 * Representa la pila de descarte del juego UNO.
 * Almacena las cartas jugadas y permite consultar la carta superior.
 */
public class DiscardPile {

    /** Estructura que almacena las cartas en orden de descarte. */
    private Deque<Card> pila = new ArrayDeque<>();

    /**
     * Constructor por defecto de la pila de descarte.
     */
    public DiscardPile() {
        // Inicializa la pila vacía
    }

    /**
     * Coloca una carta en la cima de la pila de descarte.
     *
     * @param c carta a colocar en la pila.
     */
    public void poner(Card c) {
        pila.push(c);
    }

    /**
     * Obtiene la carta que está en la cima de la pila sin retirarla.
     *
     * @return carta superior de la pila o null si está vacía.
     */
    public Card cima() {
        return pila.peek();
    }
}