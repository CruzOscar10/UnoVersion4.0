package UNO4_0;

import java.util.*;

/**
 * Representa la mano de un jugador en el juego UNO.
 * Gestiona las cartas que posee el jugador y las operaciones sobre ellas.
 */
public class Hand {
    /**
     * Constructor por defecto de Hand.
     */
    public Hand() {}

    /** Lista de cartas en la mano del jugador. */
    private List<Card> cartas = new ArrayList<>();

    /**
     * Agrega una carta a la mano.
     *
     * @param c carta a agregar.
     */
    public void agregar(Card c) { cartas.add(c); }
    
    /**
     * Obtiene una carta por su índice.
     *
     * @param i índice de la carta.
     * @return carta en la posición indicada.
     */
    public Card obtenerCarta(int i) { return cartas.get(i); }
    
    /**
     * Elimina una carta de la mano por su índice.
     *
     * @param i índice de la carta a eliminar.
     */
    public void remover(int i) { cartas.remove(i); }

    /**
     * Verifica si la mano está vacía.
     *
     * @return true si no hay cartas, false en caso contrario.
     */
    public boolean vacia() { return cartas.isEmpty(); }
    
    /**
     * Obtiene el número de cartas en la mano.
     *
     * @return cantidad de cartas.
     */
    public int size() { return cartas.size(); }

    /**
     * Verifica si existe al menos una jugada válida en la mano.
     *
     * @param r motor de reglas.
     * @param mesa carta actual en la mesa.
     * @return true si hay al menos una carta válida, false en caso contrario.
     */
    public boolean tieneJugadaValida(RuleEngine r, Card mesa) {
        return cartas.stream().anyMatch(c -> r.esJugadaValida(c, mesa));
    }

    /**
     * Obtiene y elimina la primera carta válida de la mano.
     * Usado principalmente por la IA.
     *
     * @param r motor de reglas.
     * @param mesa carta actual en la mesa.
     * @return carta válida o null si no existe.
     */
    public Card primeraValida(RuleEngine r, Card mesa) {
        for (int i = 0; i < cartas.size(); i++) {
            if (r.esJugadaValida(cartas.get(i), mesa)) {
                return cartas.remove(i);
            }
        }
        return null;
    }

    /**
     * Muestra todas las cartas de la mano con sus índices.
     */
    public void mostrar() {
        System.out.println("Tu mano:");
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println("[" + i + "] " + cartas.get(i));
        }
    }
}