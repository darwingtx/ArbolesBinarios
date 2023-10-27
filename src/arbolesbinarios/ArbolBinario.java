package arbolesbinarios;

public class ArbolBinario {
    
    private Nodo Raiz;

    public ArbolBinario(char vs[]){
        char mayor = vs[0];
        Raiz = new Nodo(mayor);

        for (char c : vs) {
            if (mayor > c) {
                InsertarMayor(c);
            }else{
                InsertarMenor(c);
            }
        }

    }

    public void InsertarMayor(char c){

    }


}
