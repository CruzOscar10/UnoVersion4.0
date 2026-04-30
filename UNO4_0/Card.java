package UNO4_0;

/**
 * Representa una carta del juego UNO.
 * Puede ser numérica o especial.
 */
public class Card {

    /**
     * Tipos de cartas del juego UNO.
     */
    public enum Tipo {

        /** Carta numérica del 0 al 9 */
        NUMERO,

        /** Salta el turno del siguiente jugador */
        SALTO,

        /** Invierte el orden del juego */
        REVERSA,

        /** El siguiente jugador roba 2 cartas */
        ROBA2,

        /** El siguiente jugador roba 4 cartas */
        ROBA4,

        /** Carta comodín para cambiar color */
        COMODIN
    }

    /** Color de la carta */
    private String color;

    /** Tipo de carta */
    private Tipo tipo;

    /** Número de la carta (solo aplica si es NUMERO) */
    private int numero;

    /**
     * Constructor de carta numérica.
     *
     * @param color color de la carta
     * @param numero número de la carta
     */
    public Card(String color, int numero) {
        this.color = color;
        this.numero = numero;
        this.tipo = Tipo.NUMERO;
    }

    /**
     * Constructor de carta especial.
     *
     * @param color color de la carta
     * @param tipo tipo de carta especial
     */
    public Card(String color, Tipo tipo) {
        this.color = color;
        this.tipo = tipo;
        this.numero = -1;
    }

    /**
     * Obtiene el color de la carta.
     *
     * @return color de la carta
     */
    public String getColor() { return color; }

    /**
     * Cambia el color de la carta.
     *
     * @param color nuevo color
     */
    public void setColor(String color) { this.color = color; }

    /**
     * Obtiene el tipo de la carta.
     *
     * @return tipo de carta
     */
    public Tipo getTipo() { return tipo; }

    /**
     * Obtiene el número de la carta.
     *
     * @return número de la carta o -1 si no es numérica
     */
    public int getNumero() { return numero; }

    /**
     * Representación en texto de la carta.
     *
     * @return cadena con la carta
     */
    @Override
    public String toString() {
        return (tipo == Tipo.NUMERO) ? color + " " + numero : color + " " + tipo;
    }
}