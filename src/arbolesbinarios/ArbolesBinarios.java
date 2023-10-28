
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
        Nodo r=p.getRaiz().getLigaDer().getLigaIzq();
     
    //    s= p.RecorrerIN(p.getRaiz());
    //    JOptionPane.showMessageDialog(null, s);
        
    //       s= p.RecorrerPre(p.getRaiz());
    //    JOptionPane.showMessageDialog(null, s);
    //    s= p.RecorrerPos(p.getRaiz());
    //      JOptionPane.showMessageDialog(null, s);
    //      s=p.Mostrarpadres(p.getRaiz());
    //      JOptionPane.showMessageDialog(null, s);
    //              s=p.Mostrarhojas(p.getRaiz());
    //      JOptionPane.showMessageDialog(null, s);
  
    JOptionPane.showMessageDialog(null,p.Profundo(r));
    p.ancestros(r);

    }
}
    

