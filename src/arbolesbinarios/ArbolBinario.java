package arbolesbinarios;

import javax.swing.JOptionPane;

public class ArbolBinario {

    private Nodo Raiz;

    public ArbolBinario(char vc[]) {
        char mayor = vc[0];
        Raiz = new Nodo(mayor);

        for (char c : vc) {
            if (mayor < c) {
                InsertarMayor(c);
            } else if (mayor > c) {
                InsertarMenor(c);
            }
        }

    }

    public void InsertarDato(char c){
        if (this.Raiz.getDato() < c) {
                InsertarMayor(c);
            } else{
                InsertarMenor(c);
            }
    }

    public void InsertarMayor(char c) {
        Nodo p = Raiz.getLigaDer();
        Nodo x = new Nodo(c);
        if (p == null) {
            Raiz.setLigaDer(x);
        } else {
            Nodo a = p;
            while (p != null) {
                a = p;
                if (p.getDato() > c) {
                    p = p.getLigaIzq();
                } else {
                    p = p.getLigaDer();
                }
            }

            if (a.getDato() > c) {
                a.setLigaIzq(x);
            } else {
                a.setLigaDer(x);
            }

        }
    }

    public void InsertarMenor(char c) {
        Nodo p = Raiz.getLigaIzq();
        Nodo x = new Nodo(c);
        if (p == null) {
            Raiz.setLigaIzq(x);
        } else {
            Nodo a = p;
            while (p != null) {
                a = p;
                if (p.getDato() < c) {
                    p = p.getLigaIzq();
                } else {
                    p = p.getLigaDer();
                }
            }

            if (a.getDato() > c) {
                a.setLigaIzq(x);
            } else {
                a.setLigaDer(x);
            }

        }
    }
  
    public void MostrarArbol(Nodo R, int space, int alto){

        if(R == null){
            return;
        }

        space+=alto;

        MostrarArbol(R.getLigaDer(), space, alto);
        System.out.println();

        for(int i = alto; i<space; i++){
            System.out.print(" ");
        }
        System.out.println(R.getDato());

        System.out.println();

        MostrarArbol(R.getLigaIzq(), space, alto);

    }
    

     public String  RecorrerPre(Nodo R){
         String s="";
        if(R!=null){
            // JOptionPane.showMessageDialog(null, R.getDato());
            s+=R.getDato();
            s+=RecorrerPre(R.getLigaIzq());
            s+=RecorrerPre(R.getLigaDer());
        }

        return s;

    }

    public String RecorrerIN(Nodo R) {
        String s = "";
        if (R != null) {
            s += RecorrerIN(R.getLigaIzq());
            s += R.getDato();
            s += RecorrerIN(R.getLigaDer());
        }
        return s;
    }

    public String RecorrerPos(Nodo R) {
        String s = "";
        if (R != null) {
            s += RecorrerPos(R.getLigaIzq());
            s += RecorrerPos(R.getLigaDer());
            s += R.getDato();
        }
        return s;
    }

    public String Mostrarhojas(Nodo R) {
        String s = "";
        if (R != null) {

            if (R.getLigaIzq() == null && R.getLigaDer() == null) {
                s += R.getDato();
            }
            s += Mostrarhojas(R.getLigaIzq());
            s += Mostrarhojas(R.getLigaDer());
        }
        return s;
    }

    public String Mostrarpadres(Nodo R) {
        String s = "";
        if (R != null) {

            if (R.getLigaIzq() != null || R.getLigaDer() != null) {
                s += R.getDato();
            }
            s += Mostrarpadres(R.getLigaIzq());
            s += Mostrarpadres(R.getLigaDer());
        }
        return s;
    }


    public Nodo getRaiz() {
        return Raiz;
    }

    public void setRaiz(Nodo raiz) {
        Raiz = raiz;
    }

}
