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
                    p = p.getLigaDer();
                }else{
                    p = p.getLigaIzq();
                }else{
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

    public void Recorrer(Nodo R) {

        if (R != null) {

            Recorrer(R.getLigaIzq());
            JOptionPane.showMessageDialog(null, R.getDato());
            Recorrer(R.getLigaDer());
  
     public void RecorrerPre(Nodo R){
        if(R!=null){
            JOptionPane.showMessageDialog(null, R.getDato());
            RecorrerPre(R.getLigaIzq());
            RecorrerPre(R.getLigaDer());
        }

    }
      public void RecorrerIN(Nodo R){
        if(R!=null){
            RecorrerIN(R.getLigaIzq());
           JOptionPane.showMessageDialog(null, R.getDato());
            RecorrerIN(R.getLigaDer());
        }

    }
      public void RecorrerIN(Nodo R){
        if(R!=null){
            RecorrerIN(R.getLigaIzq());
           JOptionPane.showMessageDialog(null, R.getDato());
            RecorrerIN(R.getLigaDer());
        }

    }
     public void RecorrerPos(Nodo R){
        if(R!=null){
            RecorrerPos(R.getLigaIzq());
            RecorrerPos(R.getLigaDer());
             JOptionPane.showMessageDialog(null, R.getDato());
        }

    }


    public Nodo getRaiz() {
        return Raiz;
    }

    public void setRaiz(Nodo raiz) {
        Raiz = raiz;
    }

}
