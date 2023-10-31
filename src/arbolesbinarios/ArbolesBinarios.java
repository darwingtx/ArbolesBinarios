
package arbolesbinarios;

import javax.swing.JOptionPane;

public class ArbolesBinarios {

   
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        String x = JOptionPane.showInputDialog("Ingrese la cadena");
        char vc[] = x.toCharArray();
        String s="";
        ArbolBinario p = new ArbolBinario(vc);
        p.MostrarArbol(p.getRaiz(), 6, 10);

    //       s= p.RecorrerPre(p.getRaiz());

       // s= p.RecorrerPre(p.getRaiz());

    //    JOptionPane.showMessageDialog(null, s);
    //    s= p.RecorrerPos(p.getRaiz());
    //      JOptionPane.showMessageDialog(null, s);
    //      s=p.Mostrarpadres(p.getRaiz());
    //      JOptionPane.showMessageDialog(null, s);
    //              s=p.Mostrarhojas(p.getRaiz());

    //      JOptionPane.showMessageDialog(null, s);
  
   
         //JOptionPane.showMessageDialog(null, s);
       // Nodo r = p.getRaiz().getLigaIzq();
       // Nodo oo = new Nodo('x');

       // Nodo q = p.Hermano(p.getRaiz(), r, oo);

        //JOptionPane.showMessageDialog(null,q.getDato());

        //JOptionPane.showMessageDialog(null,p.Profundo(r));

    }
}
    

