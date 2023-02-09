import java.security.PublicKey;
import java.util.Objects;

public class Tablero {

    private static final int DIMENSION = 3;
    private EstadoCasilla[][] casillas;

    public Tablero() {
        this.casillas = new EstadoCasilla[DIMENSION][DIMENSION];
        vaciar();
    }

    public void mostrar() {
        for (int i = 0; i < casillas.length; i ++) {
            System.out.println("+----+----+----+");
            for (int j = 0; j < casillas[i].length; j ++) {
                System.out.print("| " + casillas[i][j] + " ");
                if (j == (casillas.length-1)) {
                    System.out.print("|");
                }
            }
            System.out.println("");
        }
        System.out.println("+----+----+----+");
    }

    public boolean hayTresEnRaya() {
        boolean fichaX = hayTresEnRaya(EstadoCasilla.FICHA_X);
        boolean fichaO = hayTresEnRaya(EstadoCasilla.FICHA_O);
        if (fichaO || fichaX) {
            return true;
        }
        return false;
    }

    private boolean hayTresEnRaya(EstadoCasilla color) {
        boolean lineaHorizontal = lineasTresEnRaya("horizontal", color);
        boolean lineaVertical = lineasTresEnRaya("vertical", color);
        boolean diagonalDalt = lineasTresEnRaya("dalt", color);
        boolean diagonalBaix = lineasTresEnRaya("baix", color);
        if (lineaHorizontal || lineaVertical || diagonalDalt || diagonalBaix) {
            return true;
        }

        return false;
    }

    private boolean lineasTresEnRaya (String tipo, EstadoCasilla color) {
        int contador;
        for (int i = 0; i < casillas.length; i++) {
            contador = 0;
            for (int j = 0; j < casillas.length; j++) {
                if (Objects.equals(tipo, "horizontal")) {
                    if (casillas[i][j] == color) {
                        contador++;
                    }
                } else if (Objects.equals(tipo, "vertical")) {
                    if (casillas[j][i] == color) {
                        contador++;
                    }
                }
            }
            if (contador == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean diagonalTresEnRaya(String tipo, EstadoCasilla color) {
        int contador;
        int columna = 0;
        if (Objects.equals(tipo, "dalt")) {
            columna = 0;
        } else if (Objects.equals(tipo, "baix")) {
            columna = DIMENSION-1;
        }

        for (int f = 0; f < casillas.length; f++) {
            contador = 0;
            if (casillas[f][columna] == color) {
                contador++;
            }
            if (Objects.equals(tipo, "dalt")) {
                columna++;
            } else if (Objects.equals(tipo, "baix")) {
                columna--;
            }
            if (contador == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isOcupada(Coordenada casilla) {
        if (casillas[(casilla.getFila()-1)][(casilla.getColumna()-1)] == EstadoCasilla.FICHA_O || casillas[(casilla.getFila()-1)][(casilla.getColumna()-1)] == EstadoCasilla.FICHA_X) {
            return true;
        }
        return false;
    }

    public void ponerFicha(Coordenada casilla, EstadoCasilla color) {
        casillas[(casilla.getFila()-1)][(casilla.getColumna()-1)] = color;
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