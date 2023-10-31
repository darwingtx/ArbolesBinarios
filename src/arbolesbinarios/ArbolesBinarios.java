
package arbolesbinarios;

import javax.swing.JOptionPane;

public class ArbolesBinarios {

<<<<<<< HEAD
   
    /**
     * @param args
     */
=======

>>>>>>> 376b03531e5d1dc82c33f4ce95228324a76415f6
    public static void main(String[] args) {
        
        String x = JOptionPane.showInputDialog("Ingrese la cadena");
        char vc[] = x.toCharArray();
        String s="";
        ArbolBinario p = new ArbolBinario(vc);
<<<<<<< HEAD
        Nodo r=p.getRaiz().getLigaDer().getLigaIzq();
=======
        p.MostrarArbol(p.getRaiz(), 6, 10);

       // Nodo r=p.getRaiz().getLigaDer().getLigaDer().getLigaDer();
>>>>>>> 376b03531e5d1dc82c33f4ce95228324a76415f6
     
    //    s= p.RecorrerIN(p.getRaiz());
    //    JOptionPane.showMessageDialog(null, s);
        
<<<<<<< HEAD
    //       s= p.RecorrerPre(p.getRaiz());
=======
       // s= p.RecorrerPre(p.getRaiz());
>>>>>>> 376b03531e5d1dc82c33f4ce95228324a76415f6
    //    JOptionPane.showMessageDialog(null, s);
    //    s= p.RecorrerPos(p.getRaiz());
    //      JOptionPane.showMessageDialog(null, s);
    //      s=p.Mostrarpadres(p.getRaiz());
    //      JOptionPane.showMessageDialog(null, s);
    //              s=p.Mostrarhojas(p.getRaiz());
<<<<<<< HEAD
    //      JOptionPane.showMessageDialog(null, s);
  
    JOptionPane.showMessageDialog(null,p.Profundo(r));
    p.ancestros(r);
=======
         //JOptionPane.showMessageDialog(null, s);
       // Nodo r = p.getRaiz().getLigaIzq();
       // Nodo oo = new Nodo('x');

       // Nodo q = p.Hermano(p.getRaiz(), r, oo);

        //JOptionPane.showMessageDialog(null,q.getDato());

        //JOptionPane.showMessageDialog(null,p.Profundo(r));
>>>>>>> 376b03531e5d1dc82c33f4ce95228324a76415f6

    }
}
    

