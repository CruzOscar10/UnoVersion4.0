package UNO4_0;

public class RuleEngine {
    public boolean esJugadaValida(Card c, Card mesa) {
        if (c.getColor().equals("negro")) return true; 
        if (c.getColor().equals(mesa.getColor())) return true;
        if (c.getTipo() == Card.Tipo.NUMERO && mesa.getTipo() == Card.Tipo.NUMERO) {
            return c.getNumero() == mesa.getNumero();
        }
        return c.getTipo() == mesa.getTipo();
    }

    public void aplicarEfecto(Card carta, Player jugador, Game game) {
        TurnManager tm = game.getTurnManager();
        switch (carta.getTipo()) {
            case SALTO:
                tm.avanzar(game.getJugadores());
                break;
            case REVERSA:
                tm.reversa();
                break;
            case ROBA2:
                Player sig = tm.siguiente(game.getJugadores());
                sig.robarCarta(game.getDeck());
                sig.robarCarta(game.getDeck());
                tm.avanzar(game.getJugadores());
                break;
            case ROBA4:
                Player sig4 = tm.siguiente(game.getJugadores());
                for (int i = 0; i < 4; i++) sig4.robarCarta(game.getDeck());
                tm.avanzar(game.getJugadores());
                game.elegirColor(jugador);
                break;
            case COMODIN:
                game.elegirColor(jugador);
                break;
            default: break;
        }
    }
}