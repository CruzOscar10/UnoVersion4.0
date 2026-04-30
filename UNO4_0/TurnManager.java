package UNO4_0;

import java.util.List;

/**
 * Gestiona el orden de turnos y dirección del juego UNO.
 */
public class TurnManager {

    /**
     * Constructor por defecto de TurnManager.
     */
    public TurnManager() {}

    private int turno = 0;
    private int direccion = 1;

    /**
     * Devuelve el jugador actual.
     *
     * @param jugadores lista de jugadores
     * @return jugador en turno
     */
    public Player actual(List<Player> jugadores) {
        return jugadores.get(turno);
    }

    /**
     * Avanza al siguiente turno.
     *
     * @param jugadores lista de jugadores
     */
    public void avanzar(List<Player> jugadores) {
        turno = (turno + direccion + jugadores.size()) % jugadores.size();
    }

    /**
     * Devuelve el siguiente jugador sin cambiar turno.
     *
     * @param jugadores lista de jugadores
     * @return siguiente jugador
     */
    public Player siguiente(List<Player> jugadores) {
        int i = (turno + direccion + jugadores.size()) % jugadores.size();
        return jugadores.get(i);
    }

    /**
     * Invierte la dirección del juego.
     */
    public void reversa() {
        direccion *= -1;
    }

    /**
     * Obtiene la dirección actual del juego.
     *
     * @return 1 normal, -1 reversa
     */
    public int getDireccion() {
        return direccion;
    }
}