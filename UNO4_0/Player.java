package UNO4_0;
import java.util.Random;
public class Player {
    private String nombre;
    private Hand mano = new Hand();
    private boolean humano;
    private boolean dijoUno = false;
    private Random random = new Random();
    public Player(String nombre, boolean humano) {
        this.nombre = nombre;
        this.humano = humano;
    }
    public void jugarTurno(Game game) {
        dijoUno = false;
        if (humano) turnoHumano(game);
        else turnoIA(game);
    }
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
    public void robarCarta(Deck d) { mano.agregar(d.robarCarta()); }
    public String elegirColorIA() { 
        return new String[]{"rojo", "azul", "verde", "amarillo"}[random.nextInt(4)]; 
    }
    public String getNombre() { return nombre; }
    public Hand getMano() { return mano; }
    public boolean esHumano() { return humano; }
    public boolean dijoUno() { return dijoUno; }
}