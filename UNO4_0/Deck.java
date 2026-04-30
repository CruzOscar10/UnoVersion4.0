package UNO4_0;

import java.util.*;

/**
 * Representa el mazo de cartas del juego UNO.
 * Se encarga de crear, barajar y repartir cartas.
 */
public class Deck {

    /** Lista que contiene todas las cartas del mazo. */
    private List<Card> cartas = new ArrayList<>();

    /**
     * Constructor del mazo.
     * Inicializa el mazo creando las cartas y barajándolas.
     */
    public Deck() {
        crear();
        barajar();
    }

    /**
     * Crea todas las cartas del mazo según las reglas del UNO.
     * Incluye cartas numéricas, especiales y comodines.
     */
    private void crear() {
        String[] colores = {"rojo", "azul", "verde", "amarillo"};

        for (String color : colores) {
            // Carta 0 (una por color)
            cartas.add(new Card(color, 0));

            // Cartas del 1 al 9 (dos por número)
            for (int i = 1; i <= 9; i++) {
                cartas.add(new Card(color, i));
                cartas.add(new Card(color, i));
            }

            // Cartas especiales (dos por tipo y color)
            for (int i = 0; i < 2; i++) {
                cartas.add(new Card(color, Card.Tipo.SALTO));
                cartas.add(new Card(color, Card.Tipo.REVERSA));
                cartas.add(new Card(color, Card.Tipo.ROBA2));
            }
        }

        // Cartas comodín (4 de cada tipo)
        for (int i = 0; i < 4; i++) {
            cartas.add(new Card("negro", Card.Tipo.COMODIN));
            cartas.add(new Card("negro", Card.Tipo.ROBA4));
        }
    }

    /**
     * Baraja aleatoriamente las cartas del mazo.
     */
    public void barajar() {
        Collections.shuffle(cartas);
    }

    /**
     * Permite robar una carta del mazo.
     *
     * @return la carta robada.
     * @throws RuntimeException si el mazo está vacío.
     */
    public Card robarCarta() {
        if (cartas.isEmpty()) {
            throw new RuntimeException("No hay cartas en el mazo");
        }
        return cartas.remove(0);
    }
}