import java.security.PublicKey;

public class Tablero {

    private static final int DIMENSION = 4;
    private EstadoCasilla[][] casillas;

    public Tablero() {
        this.casillas = new EstadoCasilla[DIMENSION][DIMENSION];
        vaciar();
    }

    public void mostrar() {
        for (int i = 0; i < casillas.length; i ++) {
            for (int j = 0; j < casillas[i].length; j ++) {
                System.out.print(casillas[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public boolean hayTresEnRaya() {
        int contadorO = 0;
        int contadorX = 0;
        for (int i = 0; i < casillas.length; i ++) {
            for (int j = 0; j < casillas[i].length; j ++) {
                if (casillas[i][j] == EstadoCasilla.FICHA_O) {
                    contadorO++;
                } else if (casillas[i][j] == EstadoCasilla.FICHA_X) {
                    contadorX++;
                } else if (contadorO == 3 || contadorX == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    /*private boolean hayTresEnRaya(EstadoCasilla color) {
        return false;
    }*/

    public boolean isOcupada(Coordenada casilla) {
        if (casillas[casilla.getFila()][casilla.getColumna()] == EstadoCasilla.FICHA_O || casillas[casilla.getFila()][casilla.getColumna()] == EstadoCasilla.FICHA_X) {
            return true;
        }
        return false;
    }

    public void ponerFicha(Coordenada casilla, EstadoCasilla color) {
        casillas[casilla.getFila()][casilla.getColumna()] = color;
    }

    public void vaciar() {
        for (int i = 0; i < casillas.length; i++) {
            for (int g = 0; g < casillas.length; g++) {
                casillas[i][g] = EstadoCasilla.VACIO;
            }
        }
    }

    public boolean estaLleno() {
        int contador = 0;
        for (int i = 0; i < casillas.length; i++) {
            for (int g = 0; g < casillas.length; g++) {
                if (casillas[i][g] == EstadoCasilla.FICHA_O || casillas[i][g] == EstadoCasilla.FICHA_X) {
                    contador++;
                }
            }
        }
        int total = DIMENSION * DIMENSION;
        if (contador == total) {
            return true;
        }
        return false;
    }
}