public class Jugador {

    private EstadoCasilla ficha;
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_RESET = "\u001B[0m";

    public Jugador(EstadoCasilla ficha) {
        this.ficha = ficha;
    }

    public void ponerFicha(Tablero tablero) {
        boolean bucle = true;
        do {
            Coordenada coordenada = recogerCoordenada();
            boolean valida = coordenada.isValida(3);
            boolean ocupada = tablero.isOcupada(coordenada);
            if (!valida) {
                System.out.println(ANSI_RED + "¡Error!" + ANSI_RESET + " Introduce una cooredena válida");
                bucle = true;
            } else if (ocupada) {
                System.out.println(ANSI_RED + "¡Error!" + ANSI_RESET + " Coordenada ocupada en el tablero");
                bucle = true;
            } else {
                tablero.ponerFicha(coordenada, ficha);
                bucle = false;
            }
        } while (bucle);
    }

    private Coordenada recogerCoordenada() {
        int fila = 0;
        int columna = 0;
        boolean bucle1;
        do {
            System.out.print("Introduce fila [1-3]: ");
            if (TresEnRaya.scanner.hasNextInt()) {
                fila = TresEnRaya.scanner.nextInt();
                break;
            } else {
                System.out.println(ANSI_RED + "¡Error!" + ANSI_RESET + " Debe introducir un número entero");
                bucle1 = false;
                TresEnRaya.scanner.next();
            }
        } while (bucle1);
        boolean bucle2;
        do {
            System.out.print("Introduce columna [1-3]: ");
            if (TresEnRaya.scanner.hasNextInt()) {
                columna = TresEnRaya.scanner.nextInt();
                break;
            } else {
                System.out.println(ANSI_RED + "¡Error!" + ANSI_RESET + " Debe introducir un número entero");
                bucle2 = false;
                TresEnRaya.scanner.next();
            }
        } while (bucle2);
        return new Coordenada(fila, columna);
    }

    public void cantarVictoria() {
        System.out.println("¡El jugador " + ficha + " es el ganador!");
    }
}