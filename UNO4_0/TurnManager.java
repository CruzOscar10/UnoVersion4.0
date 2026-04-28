package UNO4_0;

import java.util.List;

public class TurnManager {
    private int turno = 0;
    private int direccion = 1; 

    public Player actual(List<Player> jugadores) {
        return jugadores.get(turno);
    }

    public void avanzar(List<Player> jugadores) {
        turno = (turno + direccion + jugadores.size()) % jugadores.size();
    }

    public Player siguiente(List<Player> jugadores) {
        int i = (turno + direccion + jugadores.size()) % jugadores.size();
        return jugadores.get(i);
    }

    public void reversa() {
        direccion *= -1;
    }

    public int getDireccion() {
        return direccion;
    }
}