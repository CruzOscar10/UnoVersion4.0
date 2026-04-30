package UNO4_0;

import java.util.*;

/**
 * Clase principal que gestiona la lógica completa del juego UNO.
 * Controla jugadores, turnos, reglas, mazo y flujo de la partida.
 */
public class Game {
    /**
     * Constructor por defecto de Game.
     */
    public Game() {}
    
    /** Mazo de cartas del juego. */
    private Deck deck = new Deck();

    /** Lista de jugadores participantes. */
    private List<Player> jugadores = new ArrayList<>();

    /** Gestor de turnos. */
    private TurnManager turnManager = new TurnManager();

    /** Motor de reglas del juego. */
    private RuleEngine ruleEngine = new RuleEngine();

    /** Pila de descarte (cartas jugadas). */
    private Stack<Card> discardPile = new Stack<>();

    /** Scanner para entrada del usuario. */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Realiza una pausa en la ejecución del juego.
     *
     * @param ms tiempo en milisegundos.
     */
    private void pausa(int ms) {
        try { 
            Thread.sleep(ms); 
        } catch (InterruptedException e) { 
            Thread.currentThread().interrupt(); 
        }
    }

    /**
     * Inicia la partida del juego UNO.
     * Configura jugadores, reparte cartas y ejecuta el bucle principal.
     */
    public void iniciar() {
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();

        // Creación de jugadores (1 humano + 3 bots)
        jugadores.add(new Player(nombre, true));
        jugadores.add(new Player("Pepe", false));
        jugadores.add(new Player("Toña", false));
        jugadores.add(new Player("Mari", false));

        repartir();

        // Carta inicial válida (no comodín ni especial)
        Card inicial;
        do {
            inicial = deck.robarCarta();
        } while (inicial.getColor().equals("negro") || inicial.getTipo() != Card.Tipo.NUMERO);

        discardPile.push(inicial);

        // Bucle principal del juego
        while (true) {
            Player actual = turnManager.actual(jugadores);

            System.out.println("\n===========================");
            System.out.println("Dirección: " + (turnManager.getDireccion() == 1 ? "⬇️" : "⬆️"));
            System.out.println("Turno de: " + actual.getNombre());
            System.out.println("Carta mesa: " + getCartaMesa());

            mostrarResumen();

            // Turno del jugador
            actual.jugarTurno(this);

            pausa(actual.esHumano() ? 1500 : 2500);

            // Penalización por no decir UNO
            if (actual.getMano().size() == 1 && !actual.dijoUno()) {
                System.out.println("⚠️ No dijo UNO, roba 2!");
                actual.robarCarta(deck);
                actual.robarCarta(deck);
            }

            // Verificar ganador
            if (actual.getMano().vacia()) {
                System.out.println("🎉 " + actual.getNombre() + " gana la partida!");
                break;
            }

            turnManager.avanzar(jugadores);
        }
    }

    /**
     * Permite a un jugador jugar una carta.
     *
     * @param jugador jugador que juega la carta.
     * @param carta carta a jugar.
     */
    public void jugarCarta(Player jugador, Card carta) {
        discardPile.push(carta);
        ruleEngine.aplicarEfecto(carta, jugador, this);
    }

    /**
     * Reparte 7 cartas a cada jugador al inicio del juego.
     */
    private void repartir() {
        for (int i = 0; i < 7; i++) {
            for (Player p : jugadores) {
                p.robarCarta(deck);
            }
        }
    }

    /**
     * Permite elegir un color cuando se juega un comodín.
     *
     * @param jugador jugador que elige el color.
     */
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

    /**
     * Muestra un resumen de los jugadores y la cantidad de cartas que tienen.
     */
    private void mostrarResumen() {
        for (Player p : jugadores) {
            System.out.println("- " + p.getNombre() + " (" + p.getMano().size() + ")");
        }
    }

    /**
     * Obtiene la carta actual en la mesa.
     *
     * @return carta superior de la pila de descarte.
     */
    public Card getCartaMesa() { return discardPile.peek(); }

    /**
     * Obtiene el mazo de cartas.
     *
     * @return mazo del juego.
     */
    public Deck getDeck() { return deck; }

    /**
     * Obtiene el motor de reglas.
     *
     * @return RuleEngine.
     */
    public RuleEngine getRuleEngine() { return ruleEngine; }

    /**
     * Obtiene el gestor de turnos.
     *
     * @return TurnManager.
     */
    public TurnManager getTurnManager() { return turnManager; }

    /**
     * Obtiene la lista de jugadores.
     *
     * @return lista de jugadores.
     */
    public List<Player> getJugadores() { return jugadores; }

    /**
     * Obtiene el scanner para entrada de datos.
     *
     * @return scanner.
     */
    public Scanner getScanner() { return scanner; }
}