import java.util.Scanner;

public class TresEnRaya {

    public static Scanner scanner;
    private Tablero tablero;
    private Jugador jugadores[];


    public static void main(String[] args){
        scanner = new Scanner(System.in);
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar();
        
    }

    public void jugar() {
        boolean bucle1 = true;
        do {
            this.tablero = new Tablero();
            this.jugadores = new Jugador[2];
            this.jugadores[0] = new Jugador(EstadoCasilla.FICHA_X);
            this.jugadores[1] = new Jugador(EstadoCasilla.FICHA_O);
            boolean bucle2 = true;
            System.out.println("Vamos a jugar al \"Tres en Raya\"");
            tablero.mostrar();
            do {
                System.out.println("Tira el jugador con " + EstadoCasilla.FICHA_X);
                jugadores[0].ponerFicha(tablero);
                tablero.mostrar();
                if (tablero.estaLleno()) {
                    System.out.println("La partida ha finalizado en empate");
                    bucle2 = false;
                    break;
                }
                if (tablero.hayTresEnRaya()) {
                    jugadores[1].cantarVictoria();
                    bucle2 = false;
                    break;
                }
                System.out.println("Tira el jugador con " + EstadoCasilla.FICHA_O);
                jugadores[1].ponerFicha(tablero);
                tablero.mostrar();
                if (tablero.estaLleno()) {
                    System.out.println("La partida ha finalizado en empate");
                    bucle2 = false;
                    break;
                }
                if (tablero.hayTresEnRaya()) {
                    jugadores[1].cantarVictoria();
                    bucle2 = false;
                    break;
                }
            } while (bucle2);
            System.out.print("¿Quieres volver a jugar? [S/N]: ");
            if (TresEnRaya.scanner.hasNext()) {
                String resposta = TresEnRaya.scanner.next();
                switch (resposta) {
                    case "S":
                    case "s":
                        bucle1 = true;
                        break;
                    case "N":
                    case "n":
                        bucle1 = false;
                        break;
                }
            } else {
                bucle1 = false;
                TresEnRaya.scanner.next();
            }
        } while (bucle1);
    }
}