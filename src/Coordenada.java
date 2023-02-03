public class Coordenada {

    private int fila;
    private int columna;

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public boolean isValida(int dimension) {
        if (columna > 0 && columna <= dimension) {
            if (fila > 0 && fila <= dimension) {
                return true;
            }
        }
        return false;
    }
}