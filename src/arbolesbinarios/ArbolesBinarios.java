
package arbolesbinarios;

import javax.swing.JOptionPane;

public class ArbolesBinarios {

  public static void main(String[] args) {
        menu();
  
  }

  public static void menu() {
    int op = 0;
    String x = JOptionPane.showInputDialog("Ingrese la cadena");
    char vc[] = x.toCharArray();
    String s = "";
    ArbolBinario p = new ArbolBinario(vc);
    Nodo q=null;
    do {
      op = Integer.parseInt(JOptionPane.showInputDialog("--------MENÚ ARBOLES BINARIOS--------\n"
          + "1.Mostrar Arbol.\n"
          + "2.Recorridos.\n"
          + "3.Insertar Dato.\n"
          + "4.Eliminar Dato.\n"
          + "5.Contar las hojas. \n"
          + "6.Contar los padres.\n"
          + "7.Mostrar hermano.\n"
          + "8.Mostrar el Nivel.\n"
          + "9.Mostrar la Altura.\n"
          + "10.Mostrar Ancestros.\n"
          + "11.Mostrar Primos Hermanos.\n"
          + "0.Salir\n"));
      switch (op) {
        case 1:
         p.MostrarArbol(p.getRaiz(),2,5);
          break;
        case 2:
        recorridos(p);

          break;
        case 3:
        char c =JOptionPane.showInputDialog("Ingrese un caracter").charAt(0);
        p.InsertarDato( c);
          break;
        case 4:

          break;
        case 5:

          break;
        case 6:

          break;

        case 7:

          break;
        case 8:

          break;
        case 9:

          break;
        case 10:

          break;
        case 11:

          break;
        case 12:

          break;

        case 0:
          break;

        default:JOptionPane.showMessageDialog(null,"Ingrese una opcion valida.");
          break;
      }

    } while (op != 0);

  }

  public static void recorridos(ArbolBinario p){
    int op = 0;
    do{

     op = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Preorden\n"
    +"2.Inorder\n"
    +"3.Posorden\n"));
      switch (op) {
        case 1:
          JOptionPane.showMessageDialog(null, p.RecorrerPre(p.getRaiz()));          
          break;
        case 2:
          JOptionPane.showMessageDialog(null, p.RecorrerIN(p.getRaiz()));          
          break;
      case 3:
          JOptionPane.showMessageDialog(null, p.RecorrerPos(p.getRaiz()));          
          break;

          case 0:
          break;
      
        default: JOptionPane.showMessageDialog(null,"Ingrese una opcion valida.");
          break;
      }


    }while(op!=0);
  }
}
