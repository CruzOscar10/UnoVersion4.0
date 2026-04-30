package UNO4_0;

/**
 * Clase principal del programa.
 * Contiene el punto de entrada para ejecutar el juego UNO.
 */
public class Main {
    /**
     * Constructor por defecto de Main.
     */
    public Main() {}

    /**
     * Método principal que inicia la ejecución del programa.
     *
     * @param args argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        new Game().iniciar();
    }
}