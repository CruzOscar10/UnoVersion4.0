package UNO4_0;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class GameTest {
    private Game game;
    private RuleEngine reglas;
    private Player p1;
    private Player p2;
    @BeforeEach
    void setUp() {
        game = new Game();
        reglas = new RuleEngine();
        p1 = new Player("Jugador1", false); // BOT
        p2 = new Player("Jugador2", false); // BOT
        game.getJugadores().add(p1);
        game.getJugadores().add(p2);
    }
    // 🟦 CAJA NEGRA - REGLAS
    @Test
    void CN_Comodin_Siempre_Valido() {
        Card mesa = new Card("rojo", 5);
        Card comodin = new Card("negro", Card.Tipo.COMODIN);
        assertTrue(reglas.esJugadaValida(comodin, mesa));
    }
    @Test
    void CN_Roba4_Obliga_Robar_4() {
        Card roba4 = new Card("negro", Card.Tipo.ROBA4);
        int antes = p2.getMano().size();
        game.jugarCarta(p1, roba4);
        int despues = p2.getMano().size();
        assertEquals(antes + 4, despues);
    }
    @Test
    void CN_Reversa_Cambia_Direccion() {
        int antes = game.getTurnManager().getDireccion();
        game.jugarCarta(p1, new Card("rojo", Card.Tipo.REVERSA));
        int despues = game.getTurnManager().getDireccion();
        assertEquals(-antes, despues);
    }
    // CAJA BLANCA - TURNOS
    @Test
    void CB_Avance_Turno_Normal() {
        TurnManager tm = game.getTurnManager();
        Player actual = tm.actual(game.getJugadores());
        tm.avanzar(game.getJugadores());
        Player siguiente = tm.actual(game.getJugadores());
        assertNotEquals(actual, siguiente);
    }

    @Test
    void CB_Bot_Juega_Carta_Valida() {
        Card mesa = new Card("rojo", 3);
        game.jugarCarta(p2, mesa);
        Card cartaValida = new Card("rojo", 7);
        p1.getMano().agregar(cartaValida);
        int antes = p1.getMano().size();
        p1.jugarTurno(game);
        int despues = p1.getMano().size();
        assertEquals(antes - 1, despues);
    }
    // 🟧 CAJA BLANCA - VALIDACIÓN INTERNA
    @Test
    void CB_Color_Igual() {
        Card mesa = new Card("azul", 1);
        Card carta = new Card("azul", 9);
        assertTrue(reglas.esJugadaValida(carta, mesa));
    }
    @Test
    void CB_Numero_Igual() {
        Card mesa = new Card("verde", 6);
        Card carta = new Card("rojo", 6);
        assertTrue(reglas.esJugadaValida(carta, mesa));
    }
    @Test
    void CB_Tipo_Igual() {
        Card mesa = new Card("rojo", Card.Tipo.SALTO);
        Card carta = new Card("azul", Card.Tipo.SALTO);
        assertTrue(reglas.esJugadaValida(carta, mesa));
    }
    @Test
    void CB_Jugada_Invalida() {
        Card mesa = new Card("rojo", 2);
        Card carta = new Card("verde", 9);
        assertFalse(reglas.esJugadaValida(carta, mesa));
    }
    // 🟥 DETECCIÓN DE ERRORES / EXCEPCIONES
    @Test
    void EX_Indice_Invalido_Hand() {
        Hand mano = new Hand();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            mano.obtenerCarta(10);
        });
    }
    @Test
    void EX_Deck_Vacio() {
        Deck deck = new Deck();
        while (true) {
            try {
                deck.robarCarta();
            } catch (RuntimeException e) {
                break;
            }
        }
        assertThrows(RuntimeException.class, deck::robarCarta);
    }
    @Test
    void EX_Hand_Sin_Jugadas() {
        Hand mano = new Hand();
        Card mesa = new Card("rojo", 5);
        Card resultado = mano.primeraValida(reglas, mesa);
        assertNull(resultado);
    }
}