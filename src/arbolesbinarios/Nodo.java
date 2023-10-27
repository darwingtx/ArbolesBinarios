
package arbolesbinarios;


public class Nodo {
    
    private int dato;
    private Nodo LigaIzq, LigaDer;
    
    //metodos 

    public Nodo(int dato) {
        this.dato = dato;
        this.LigaIzq = null;
        this.LigaDer = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
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

 
    
    
 

}
