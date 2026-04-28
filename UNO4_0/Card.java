package UNO4_0;

public class Card {
    public enum Tipo { NUMERO, SALTO, REVERSA, ROBA2, ROBA4, COMODIN }
    private String color;
    private Tipo tipo;
    private int numero;

    public Card(String color, int numero) {
        this.color = color;
        this.numero = numero;
        this.tipo = Tipo.NUMERO;
    }

    public Card(String color, Tipo tipo) {
        this.color = color;
        this.tipo = tipo;
        this.numero = -1;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public Tipo getTipo() { return tipo; }
    public int getNumero() { return numero; }

    @Override
    public String toString() {
        return (tipo == Tipo.NUMERO) ? color + " " + numero : color + " " + tipo;
    }
}