/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesbinarios;

/**
 *
 * @author abela
 */
public class Nodo {
    
    private int dato;
    private Nodo LigaIzq, LigaDer;
    
//metodos 

    public Nodo(int dato, Nodo LigaIzq, Nodo LigaDer) {
        this.dato = dato;
        this.LigaIzq = LigaIzq;
        this.LigaDer = LigaDer;
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
