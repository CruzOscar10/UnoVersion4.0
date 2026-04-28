package UNO4_0;
import java.util.*;
public class Deck {
    private List<Card> cartas = new ArrayList<>();
    public Deck() {
        crear();
        barajar();
    }
    private void crear() {
        String[] colores = {"rojo", "azul", "verde", "amarillo"};
        for (String color : colores) {
            cartas.add(new Card(color, 0));
            for (int i = 1; i <= 9; i++) {
                cartas.add(new Card(color, i));
                cartas.add(new Card(color, i));
            }
            for (int i = 0; i < 2; i++) {
                cartas.add(new Card(color, Card.Tipo.SALTO));
                cartas.add(new Card(color, Card.Tipo.REVERSA));
                cartas.add(new Card(color, Card.Tipo.ROBA2));
            }
        }
        for (int i = 0; i < 4; i++) {
            cartas.add(new Card("negro", Card.Tipo.COMODIN));
            cartas.add(new Card("negro", Card.Tipo.ROBA4));
        }
    }
    public void barajar() {
        Collections.shuffle(cartas);
    }
    public Card robarCarta() {
        if (cartas.isEmpty()) {
            throw new RuntimeException("No hay cartas en el mazo");
        }
        return cartas.remove(0);
    }
}