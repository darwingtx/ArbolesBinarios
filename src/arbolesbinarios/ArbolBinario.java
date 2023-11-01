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

    public int Altura(Nodo R) {
        int Altura = 0;
        if (R != null) {
            Altura = Math.max(Altura, Altura(R.getLigaIzq()));
            Altura = Math.max(Altura, Altura(R.getLigaDer()));

            Altura++;
        }

        return Altura;
    }

    public int Nivel(Nodo R) {
        Nodo p = null;
        int deep = 0;
        if (R != this.getRaiz()) {
            deep = 1 + Nivel(this.Padre(this.Raiz, R, p));
        }

        return deep;
    }

    public Nodo Padre(Nodo R, Nodo P, Nodo s) {
        if (R != null && P != null) {

            if (R.getLigaDer() == P || R.getLigaIzq() == P) {
                s = R;
            }
            s = Padre(R.getLigaIzq(), P, s);
            s = Padre(R.getLigaDer(), P, s);
        }

        return s;
    }

    public Nodo Hermano(Nodo R, Nodo P, Nodo s) {
        if (R != null && P != null) {

            if (R.getLigaDer() == P || R.getLigaIzq() == P) {
                if (R.getLigaDer() == P) {
                    s = R.getLigaIzq();
                } else if (R.getLigaIzq() == P) {
                    s = R.getLigaDer();
                }

            }
            s = Padre(R.getLigaIzq(), P, s);
            s = Padre(R.getLigaDer(), P, s);
        }

        return s;
    }

    public void MostrarPrimosH(Nodo R) {
        Nodo q = null;
        Nodo x = Padre(this.Raiz, R, q);
        Nodo p = Padre(this.Raiz, x, q);
        String s = "";
        if (p.getLigaDer() != null && p.getLigaDer() != x) {
            p = p.getLigaDer();
            if (p.getLigaIzq() != null) {
                s += p.getLigaIzq().getDato();
            }
            if (p.getLigaDer() != null) {
                s += p.getLigaDer().getDato();

            }
        } else if (p.getLigaIzq() != null && p.getLigaIzq() != x) {
            p = p.getLigaIzq();
            if (p.getLigaIzq() != null) {
                s += p.getLigaIzq().getDato();
            }
            if (p.getLigaDer() != null) {
                s += p.getLigaDer().getDato();

            }
        }
        JOptionPane.showMessageDialog(null, s);
    }

    public void InsertarDato(char c) {
        if (this.Raiz.getDato() < c) {
            InsertarMayor(c);
        } else {
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

    public void MostrarArbol(Nodo R, int space, int alto) {

        if (R == null) {
            return;
        }

        space += alto;

        MostrarArbol(R.getLigaDer(), space, alto);
        System.out.println();

        for (int i = alto; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(R.getDato());

        System.out.println();

        MostrarArbol(R.getLigaIzq(), space, alto);

    }

    public String RecorrerPre(Nodo R) {
        String s = "";
        if (R != null) {
            // JOptionPane.showMessageDialog(null, R.getDato());
            s += R.getDato();
            s += RecorrerPre(R.getLigaIzq());
            s += RecorrerPre(R.getLigaDer());
        }

        return s;

    }

    public boolean BuscarDato(Nodo R, char dato) {
        if (R == null) {
            return false;
        }
        if (R.getDato() == dato) {
            return true;
        }
        if (dato < R.getDato()) {
            return BuscarDato(R.getLigaIzq(), dato);
        } else {
            return BuscarDato(R.getLigaDer(), dato);
        }
    }
    public Nodo Buscar(Nodo r, char d) {
        Nodo n = null;

        if (r.getDato() < d)
        {
            n = Buscar(r.getLigaDer(), d);
        } else if (r.getDato() > d)
        {
            n = Buscar(r.getLigaIzq(), d);
        } else if (r.getDato() == d)
        {
            return r;
        }

        return n;
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

    public int Contarhojas(Nodo R) {
        int s = 0;
        if (R != null) {

            if (R.getLigaIzq() == null && R.getLigaDer() == null) {
                s += 1;
            }
            s += Contarhojas(R.getLigaIzq());
            s += Contarhojas(R.getLigaDer());
        }
        return s;
    }

    public String MostrarAncestros(Nodo R) {
        String s = "";
        Nodo p = R;

        while (p != this.Raiz) {
            p = this.Padre(this.Raiz, p, p);
            s += p.getDato();
        }

        return s;
    }

    public int Contarpadres(Nodo R) {
        int s = 0;
        if (R != null) {

            if (R.getLigaIzq() != null || R.getLigaDer() != null) {
                s += 1;
            }
            s += Contarpadres(R.getLigaIzq());
            s += Contarpadres(R.getLigaDer());
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
