
package arbolesbinarios;

public class Nodo {

    private char dato;
    private Nodo LigaIzq, LigaDer;
    private int Fb;

    // metodos

    public Nodo(char dato) {

        this.dato = dato;
        this.LigaIzq = null;
        this.LigaDer = null;
        this.Fb = 0;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getLigaIzq() {
        return LigaIzq;
    }

    public void setLigaIzq(Nodo LigaIzq) {
        this.LigaIzq = LigaIzq;
    }

    public Nodo getLigaDer() {
        return LigaDer;
    }

    public void setLigaDer(Nodo LigaDer) {
        this.LigaDer = LigaDer;
    }

    public int getFb() {
        return Fb;
    }

    public void setFb(int fb) {
        Fb = fb;
    }

}
