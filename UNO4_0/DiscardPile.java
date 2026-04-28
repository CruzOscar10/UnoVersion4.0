package UNO4_0;
import java.util.*;

public class DiscardPile {
    private Deque<Card> pila = new ArrayDeque<>();

    public void poner(Card c) {
        pila.push(c);
    }

    public Card cima() {
        return pila.peek();
    }
}