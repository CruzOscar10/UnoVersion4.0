package UNO4_0;

/**
 * Motor de reglas del juego UNO.
 * Se encarga de validar jugadas y aplicar efectos de cartas especiales.
 */
public class RuleEngine {
    /**
     * Constructor por defecto de RuleEngine.
     */
    public RuleEngine() {}

    /**
     * Determina si una carta puede jugarse sobre la carta actual en la mesa.
     *
     * @param c carta que el jugador desea jugar.
     * @param mesa carta actual en la mesa.
     * @return true si la jugada es válida, false en caso contrario.
     */
    public boolean esJugadaValida(Card c, Card mesa) {
        // Las cartas negras (comodines) siempre son válidas
        if (c.getColor().equals("negro")) return true;

        // Coincide el color
        if (c.getColor().equals(mesa.getColor())) return true;

        // Coincide el número (solo si ambas son numéricas)
        if (c.getTipo() == Card.Tipo.NUMERO && mesa.getTipo() == Card.Tipo.NUMERO) {
            return c.getNumero() == mesa.getNumero();
        }

        // Coincide el tipo de carta especial
        return c.getTipo() == mesa.getTipo();
    }

    /**
     * Aplica el efecto de una carta especial al juego.
     *
     * @param carta carta jugada.
     * @param jugador jugador que jugó la carta.
     * @param game instancia del juego actual.
     */
    public void aplicarEfecto(Card carta, Player jugador, Game game) {
        TurnManager tm = game.getTurnManager();

        switch (carta.getTipo()) {
            case SALTO:
                // Salta el turno del siguiente jugador
                tm.avanzar(game.getJugadores());
                break;

            case REVERSA:
                // Invierte la dirección del juego
                tm.reversa();
                break;

            case ROBA2:
                // El siguiente jugador roba 2 cartas y pierde turno
                Player sig = tm.siguiente(game.getJugadores());
                sig.robarCarta(game.getDeck());
                sig.robarCarta(game.getDeck());
                tm.avanzar(game.getJugadores());
                break;

            case ROBA4:
                // El siguiente jugador roba 4 cartas, pierde turno y se elige color
                Player sig4 = tm.siguiente(game.getJugadores());
                for (int i = 0; i < 4; i++) sig4.robarCarta(game.getDeck());
                tm.avanzar(game.getJugadores());
                game.elegirColor(jugador);
                break;

            case COMODIN:
                // Permite elegir un nuevo color
                game.elegirColor(jugador);
                break;

            default:
                // No hay efecto para cartas numéricas
                break;
        }
    }
}