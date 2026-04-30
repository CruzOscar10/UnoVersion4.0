package UNO4_0;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link TurnManager}.
 * Verifica la gestión de turnos de los jugadores, incluyendo
 * avance, reversa y consulta del siguiente jugador.
 */
class TurnManagerTest {

    /**
     * Prueba que el primer jugador sea el actual al iniciar.
     */
    @Test
    void testJugadorActualInicial() {
        List<Player> jugadores = List.of(
            new Player("A", true),
            new Player("B", false),
            new Player("C", false)
        );

        TurnManager tm = new TurnManager();
        assertEquals("A", tm.actual(jugadores).getNombre());
    }

    /**
     * Prueba el avance normal de turno.
     * Verifica que pase al siguiente jugador en orden.
     */
    @Test
    void testAvanzarTurnoNormal() {
        List<Player> jugadores = List.of(
            new Player("A", true),
            new Player("B", false),
            new Player("C", false)
        );

        TurnManager tm = new TurnManager();

        tm.avanzar(jugadores);

        assertEquals("B", tm.actual(jugadores).getNombre());
    }

    /**
     * Prueba que el método reversa cambie la dirección del turno.
     */
    @Test
    void testReversaCambiaDireccion() {
        TurnManager tm = new TurnManager();

        tm.reversa();

        assertEquals(-1, tm.getDireccion());
    }

    /**
     * Prueba el método siguiente sin modificar el turno actual.
     * Verifica que solo consulte el siguiente jugador.
     */
    @Test
    void testSiguienteSinCambiarTurno() {
        List<Player> jugadores = List.of(
            new Player("A", true),
            new Player("B", false),
            new Player("C", false)
        );

        TurnManager tm = new TurnManager();

        Player siguiente = tm.siguiente(jugadores);

        assertEquals("B", siguiente.getNombre());
        assertEquals("A", tm.actual(jugadores).getNombre());
    }

    /**
     * Prueba que los turnos ciclen correctamente.
     * Después de recorrer todos los jugadores, vuelve al inicio.
     */
    @Test
    void testCicloTurnos() {
        List<Player> jugadores = List.of(
            new Player("A", true),
            new Player("B", false),
            new Player("C", false)
        );

        TurnManager tm = new TurnManager();

        tm.avanzar(jugadores);
        tm.avanzar(jugadores);
        tm.avanzar(jugadores);

        assertEquals("A", tm.actual(jugadores).getNombre());
    }

    /**
     * Prueba que la reversa afecte el orden de los turnos.
     * Verifica que al invertir la dirección, el turno avance en sentido contrario.
     */
    @Test
    void testReversaCambiaOrdenTurno() {
        List<Player> jugadores = List.of(
            new Player("A", true),
            new Player("B", false),
            new Player("C", false)
        );

        TurnManager tm = new TurnManager();

        tm.reversa();
        tm.avanzar(jugadores);

        assertEquals("C", tm.actual(jugadores).getNombre());
    }
}