package UNO4_0;

import java.util.*;

public class Hand {
    private List<Card> cartas = new ArrayList<>();

    public void agregar(Card c) { cartas.add(c); }
    
    public Card obtenerCarta(int i) { return cartas.get(i); }
    
    public void remover(int i) { cartas.remove(i); }

    public boolean vacia() { return cartas.isEmpty(); }
    
    public int size() { return cartas.size(); }

    public boolean tieneJugadaValida(RuleEngine r, Card mesa) {
        return cartas.stream().anyMatch(c -> r.esJugadaValida(c, mesa));
    }

    public Card primeraValida(RuleEngine r, Card mesa) {
        for (int i = 0; i < cartas.size(); i++) {
            if (r.esJugadaValida(cartas.get(i), mesa)) {
                return cartas.remove(i);
            }
        }
        return null;
    }

    public void mostrar() {
        System.out.println("Tu mano:");
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println("[" + i + "] " + cartas.get(i));
        }
    }
}