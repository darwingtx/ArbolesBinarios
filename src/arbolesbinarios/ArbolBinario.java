package arbolesbinarios;

public class ArbolBinario {

    private Nodo Raiz;

    public ArbolBinario(char vc[]) {
        for (char c : vc) {
            InsertarDato(c);
            FactorB(Raiz);
        }
    }

    public void FactorB(Nodo R) {
        if (R != null) {
            FactorB(R.getLigaDer());
            FactorB(R.getLigaIzq());
            R.setFb(Altura(R.getLigaIzq()) - Altura(R.getLigaDer()));
            if (R.getFb() == 2 || R.getFb() == -2) {
                if (Altura(R.getLigaDer()) > Altura(R.getLigaIzq())) {
                    if (Altura(R.getLigaDer().getLigaDer()) > Altura(R.getLigaDer().getLigaIzq())) {
                        AVL(R, R.getLigaDer(), R.getLigaDer().getLigaDer());
                    } else {
                        AVL(R, R.getLigaDer(), R.getLigaDer().getLigaIzq());
                    }
                } else {
                    if (Altura(R.getLigaIzq().getLigaDer()) > Altura(R.getLigaIzq().getLigaIzq())) {
                        AVL(R, R.getLigaIzq(), R.getLigaIzq().getLigaDer());
                    } else {
                        AVL(R, R.getLigaIzq(), R.getLigaIzq().getLigaIzq());
                    }
                }
            }
        }
    }

    public void InsertarDato(char c) {
        Raiz = insertarRecursivo(Raiz, c);
    }

    private Nodo insertarRecursivo(Nodo R, char c) {
        if (R == null) {
            return new Nodo(c);
        }
        if (c < R.getDato()) {
            R.setLigaIzq(insertarRecursivo(R.getLigaIzq(), c));
        } else if (c > R.getDato()) {
            R.setLigaDer(insertarRecursivo(R.getLigaDer(), c));

        }
        return R;
    }

    private void AVL(Nodo P, Nodo Q, Nodo R) {
        if ((P.getFb() == 2 && Q.getFb() == 1) || (P.getFb() == -2 && Q.getFb() == -1)) {
            if (P.getFb() == 2 && Q.getFb() == 1) {
                SimpleRotationRight(P, Q);
            } else if (P.getFb() == -2 && Q.getFb() == -1) {
                SimpleRotationLeft(P, Q);
            }
        } else {
            if (P.getFb() == -2 && Q.getFb() == 1) {
                DoubleRotationLeft(P, Q, R);
            } else if (P.getFb() == 2 && Q.getFb() == -1) {
                DoubleRotationRight(P, Q, R);
            }
        }
    }

    private void SimpleRotationRight(Nodo P, Nodo Q) {
        Nodo s = Padre(Raiz, P, null);
        Nodo r = Q.getLigaDer();
        if (s == null) {
            Q.setLigaDer(P);
            P.setLigaIzq(r);
            Raiz = Q;
        } else {

            if (s.getLigaDer() == P) {
                s.setLigaDer(Q);

            } else {
                s.setLigaIzq(Q);
            }
            Q.setLigaDer(P);
            P.setLigaIzq(r);
        }
    }

    private void SimpleRotationLeft(Nodo P, Nodo Q) {
        Nodo s = Padre(Raiz, P, null);
        Nodo r = Q.getLigaIzq();
        if (s == null) {
            P.setLigaDer(r);
            Q.setLigaIzq(P);
            Raiz = Q;
        } else {
            if (s.getLigaDer() == P) {
                s.setLigaDer(Q);
            } else {
                s.setLigaIzq(Q);
            }
            Q.setLigaIzq(P);
            P.setLigaDer(r);
        }
    }

    private void DoubleRotationRight(Nodo P, Nodo Q, Nodo R) {
        Nodo s = Padre(Raiz, P, null);
        P.setLigaIzq(R.getLigaDer());
        R.setLigaDer(P);
        Q.setLigaDer(R.getLigaIzq());
        R.setLigaIzq(Q);
        if (s != null) {
            if (s.getLigaDer() == P) {
                s.setLigaDer(R);
            } else {
                s.setLigaIzq(R);
            }
        } else {
            Raiz = R;
        }
    }

    private void DoubleRotationLeft(Nodo P, Nodo Q, Nodo R) {
        Nodo s = Padre(Raiz, P, null);
        P.setLigaDer(R.getLigaIzq());
        R.setLigaIzq(P);
        Q.setLigaIzq(R.getLigaDer());
        R.setLigaDer(Q);
        if (s != null) {
            if (s.getLigaDer() == P) {
                s.setLigaDer(R);
            } else {
                s.setLigaIzq(R);
            }
        } else {
            Raiz = R;
        }
    }

    public int Altura(Nodo R) {
        int Altura = -1;
        if (R != null) {
            Altura = Math.max(Altura, Altura(R.getLigaIzq()));
            Altura = Math.max(Altura, Altura(R.getLigaDer()));
            Altura++;
        } else {
            Altura = 0;
        }
        return Altura;
    }

    public int Nivel(Nodo R) {
        Nodo p = null;
        int deep = 1;// iniciamos el nivel de la raiz en 1
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

    public void Eliminar(Nodo p) {
        Nodo r = Padre(Raiz, p, null);
        Nodo q = null;
        if (p != null) {
            if (p.getLigaDer() != null) {
                q = p.getLigaDer();
                while (q.getLigaIzq() != null) {
                    q = q.getLigaIzq();
                }
            } else if (p.getLigaIzq() != null) {
                q = p.getLigaIzq();
                while (q.getLigaDer() != null) {
                    q = q.getLigaDer();
                }
            }
            Eliminar(q);
            if (r != null && r.getLigaDer() == p) {
                r.setLigaDer(q);
            } else if (r != null && r.getLigaDer() != p) {
                r.setLigaIzq(q);
            }
            {
            }
            if (q != null) {
                q.setLigaDer(p.getLigaDer());
                q.setLigaIzq(p.getLigaIzq());
            }
            if (p == Raiz) {
                Raiz = q;
            }
        }
    }

    public String MostrarPrimosH(Nodo R) {
        Nodo q = null;
        Nodo x = Padre(this.Raiz, R, q);
        Nodo p = Padre(this.Raiz, x, q);
        String s = "Los primos hermanos de " + R.getDato() + " son ";

        if (x == Raiz) {
            s = "No tiene primos hermanos";
        } else {
            if (p.getLigaDer() != null && p.getLigaDer() != x) {
                p = p.getLigaDer();
                if (p.getLigaIzq() != null) {
                    s += p.getLigaIzq().getDato() + " ";
                }
                if (p.getLigaDer() != null) {
                    s += p.getLigaDer().getDato() + " ";
                }
            } else if (p.getLigaIzq() != null && p.getLigaIzq() != x) {
                p = p.getLigaIzq();
                if (p.getLigaIzq() != null) {
                    s += p.getLigaIzq().getDato() + " ";
                }
                if (p.getLigaDer() != null) {
                    s += p.getLigaDer().getDato() + " ";

                }
            }

        }
        return s;
    }

    public String MostrarArbol(Nodo R, int space, int alto) {
        String s = "";
        if (R == null) {
            return s;
        }
        space += alto;
        s = s + MostrarArbol(R.getLigaDer(), space, alto);
        for (int i = alto; i < space; i++) {
            s = s + " ";
        }
        if (R == Raiz) {
            s = s + "[" + R.getDato() + "]\n";
        } else {
            s = s + R.getDato() + "\n";

        }
        s = s + MostrarArbol(R.getLigaIzq(), space, alto);
        return s;
    }

    public String RecorrerPre(Nodo R) {
        String s = "";
        if (R != null) {
            s += R.getDato();
            s += RecorrerPre(R.getLigaIzq());
            s += RecorrerPre(R.getLigaDer());
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
        if (r.getDato() < d) {
            n = Buscar(r.getLigaDer(), d);
        } else if (r.getDato() > d) {
            n = Buscar(r.getLigaIzq(), d);
        } else if (r.getDato() == d) {
            return r;
        }
        return n;
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
        String s = " ";
        Nodo p = R;

        while (p != this.Raiz) {
            p = this.Padre(this.Raiz, p, null);
            s += p.getDato() + ", ";
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
