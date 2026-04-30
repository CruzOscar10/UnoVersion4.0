package UNO4_0;

import java.util.Random;

/**
 * Representa a un jugador del juego UNO.
 * Puede ser un jugador humano o controlado por la IA.
 * Gestiona su mano de cartas y la lógica de su turno.
 */
public class Player {

    /** Nombre del jugador. */
    private String nombre;

    /** Mano de cartas del jugador. */
    private Hand mano = new Hand();

    /** Indica si el jugador es humano o IA. */
    private boolean humano;

    /** Indica si el jugador dijo "UNO" correctamente. */
    private boolean dijoUno = false;

    /** Generador de números aleatorios para la IA. */
    private Random random = new Random();

    /**
     * Constructor del jugador.
     *
     * @param nombre nombre del jugador.
     * @param humano true si es jugador humano, false si es IA.
     */
    public Player(String nombre, boolean humano) {
        this.nombre = nombre;
        this.humano = humano;
    }

    /**
     * Ejecuta el turno del jugador.
     *
     * @param game instancia actual del juego.
     */
    public void jugarTurno(Game game) {
        dijoUno = false;
        if (humano) turnoHumano(game);
        else turnoIA(game);
    }

    /**
     * Lógica del turno para un jugador humano.
     *
     * @param game instancia del juego.
     */
    private void turnoHumano(Game game) {
        mano.mostrar();

        if (!mano.tieneJugadaValida(game.getRuleEngine(), game.getCartaMesa())) {
            System.out.println("No tienes cartas válidas. Robas una.");
            robarCarta(game.getDeck());
            return;
        }

        while (true) {
            try {
                System.out.print("Elige índice de carta: ");
                int op = Integer.parseInt(game.getScanner().nextLine());
                Card elegida = mano.obtenerCarta(op);

                if (game.getRuleEngine().esJugadaValida(elegida, game.getCartaMesa())) {
                    mano.remover(op);
                    game.jugarCarta(this, elegida);

                    if (mano.size() == 1) {
                        System.out.print("¿Cantar UNO? (s/n): ");
                        if (game.getScanner().nextLine().equalsIgnoreCase("s")) {
                            dijoUno = true;
                            System.out.println("¡UNO!");
                        }
                    }
                    break;
                } else {
                    System.out.println("❌ Movimiento inválido.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error en la selección.");
            }
        }
    }

    /**
     * Lógica del turno para un jugador controlado por IA.
     *
     * @param game instancia del juego.
     */
    private void turnoIA(Game game) {
        Card carta = mano.primeraValida(game.getRuleEngine(), game.getCartaMesa());

        if (carta != null) {
            System.out.println(nombre + " juega: " + carta);
            game.jugarCarta(this, carta);

            if (mano.size() == 1) {
                dijoUno = true;
                System.out.println(nombre + " dice: ¡UNO!");
            }
        } else {
            Card robada = game.getDeck().robarCarta();
            System.out.println(nombre + " roba carta.");

            if (game.getRuleEngine().esJugadaValida(robada, game.getCartaMesa())) {
                System.out.println(nombre + " juega la carta robada: " + robada);
                game.jugarCarta(this, robada);
            } else {
                mano.agregar(robada);
            }
        }
    }

    /**
     * Permite al jugador robar una carta del mazo.
     *
     * @param d mazo de cartas.
     */
    public void robarCarta(Deck d) {
        mano.agregar(d.robarCarta());
    }

    /**
     * Permite a la IA elegir un color aleatorio.
     *
     * @return color elegido.
     */
    public String elegirColorIA() {
        return new String[]{"rojo", "azul", "verde", "amarillo"}[random.nextInt(4)];
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return nombre del jugador.
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene la mano del jugador.
     *
     * @return mano de cartas.
     */
    public Hand getMano() { return mano; }

    /**
     * Indica si el jugador es humano.
     *
     * @return true si es humano, false si es IA.
     */
    public boolean esHumano() { return humano; }

    /**
     * Indica si el jugador dijo "UNO".
     *
     * @return true si lo dijo correctamente, false en caso contrario.
     */
    public boolean dijoUno() { return dijoUno; }
}