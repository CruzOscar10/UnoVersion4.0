package UNO4_0;
import java.util.*;
public class Game {
    private Deck deck = new Deck();
    private List<Player> jugadores = new ArrayList<>();
    private TurnManager turnManager = new TurnManager();
    private RuleEngine ruleEngine = new RuleEngine();
    private Stack<Card> discardPile = new Stack<>();
    private Scanner scanner = new Scanner(System.in);
    private void pausa(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
    public void iniciar() {
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        jugadores.add(new Player(nombre, true));
        jugadores.add(new Player("Pepe", false));
        jugadores.add(new Player("Toña", false));
        jugadores.add(new Player("Mari", false));
        repartir();       
        Card inicial;
        do {
            inicial = deck.robarCarta();
        } while (inicial.getColor().equals("negro") || inicial.getTipo() != Card.Tipo.NUMERO);
        discardPile.push(inicial);
        while (true) {
            Player actual = turnManager.actual(jugadores);
            System.out.println("\n===========================");
            System.out.println("Dirección: " + (turnManager.getDireccion() == 1 ? "⬇️" : "⬆️"));
            System.out.println("Turno de: " + actual.getNombre());
            System.out.println("Carta mesa: " + getCartaMesa());
            mostrarResumen();
            actual.jugarTurno(this);
            pausa(actual.esHumano() ? 1500 : 2500);
            if (actual.getMano().size() == 1 && !actual.dijoUno()) {
                System.out.println("⚠️ No dijo UNO, roba 2!");
                actual.robarCarta(deck);
                actual.robarCarta(deck);
            }
            if (actual.getMano().vacia()) {
                System.out.println("🎉 " + actual.getNombre() + " gana la partida!");
                break;
            }
            turnManager.avanzar(jugadores);
        }
    }
    public void jugarCarta(Player jugador, Card carta) {
        discardPile.push(carta);
        ruleEngine.aplicarEfecto(carta, jugador, this);
    }
    private void repartir() {
        for (int i = 0; i < 7; i++) {
            for (Player p : jugadores) p.robarCarta(deck);
        }
    }
    public void elegirColor(Player jugador) {
        String color;
        if (jugador.esHumano()) {
            while (true) {
                System.out.print("Elige color (rojo/azul/verde/amarillo): ");
                color = scanner.nextLine().toLowerCase();
                if (color.matches("rojo|azul|verde|amarillo")) break;
            }
        } else {
            color = jugador.elegirColorIA();
            System.out.println(jugador.getNombre() + " elige: " + color);
        }
        getCartaMesa().setColor(color);
    }

    private void mostrarResumen() {
        for (Player p : jugadores) {
            System.out.println("- " + p.getNombre() + " (" + p.getMano().size() + ")");
        }
    }

    public Card getCartaMesa() { return discardPile.peek(); }
    public Deck getDeck() { return deck; }
    public RuleEngine getRuleEngine() { return ruleEngine; }
    public TurnManager getTurnManager() { return turnManager; }
    public List<Player> getJugadores() { return jugadores; }
    public Scanner getScanner() { return scanner; }
}