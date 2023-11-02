
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
    Nodo q = null;
    char a = ' ';
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
          p.MostrarArbol(p.getRaiz(), 2, 5);
          break;
        case 2:
          recorridos(p);

          break;
        case 3:
          char c = ' ';
          boolean ba = true;
          do {
            String input = JOptionPane.showInputDialog("Ingrese un caracter");
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
              c = input.charAt(0);
              ba = false;
            } else {
              JOptionPane.showMessageDialog(null, "Por favor, ingrese solo una letra");
            }
          } while (ba);
          p.InsertarDato(c);
          break;
        case 4:

          break;
        case 5:
          JOptionPane.showMessageDialog(null, "Hay " + p.Contarhojas(p.getRaiz()) + " hojas en el arbol");
          break;
        case 6:
          JOptionPane.showMessageDialog(null, "Hay " + p.Contarpadres(p.getRaiz()) + " hojas en el arbol");

          break;

        case 7:
          p.MostrarArbol(p.getRaiz(), 2, 5);
          a = JOptionPane.showInputDialog("Ingrese el dato, para buscar el hermano").charAt(0);
          if (p.BuscarDato(p.getRaiz(), a) == true) {
            q = p.Hermano(p.getRaiz(), p.Buscar(p.getRaiz(), a), null);
            if (q != null) {
              JOptionPane.showMessageDialog(null, "El Hermano de " + a + " es " + q.getDato());
            } else {
              JOptionPane.showMessageDialog(null, a + " no tiene hermano");
            }
          }else{
            JOptionPane.showMessageDialog(null, "El dato no existe");
          }
          break;
        case 8:
          p.MostrarArbol(p.getRaiz(), 2, 5);
          a = JOptionPane.showInputDialog("Ingrese el dato, para buscar los ancestros").charAt(0);
          if (p.BuscarDato(p.getRaiz(), a) == true) {
            q = p.Hermano(p.getRaiz(), p.Buscar(p.getRaiz(), a), null);
            if (q != null) {
              JOptionPane.showMessageDialog(null, "Los ancestros de " + a + " son " + p.MostrarAncestros(q));
            } else {
              JOptionPane.showMessageDialog(null, a + " no tiene ancestros");
            }
          }else{
            JOptionPane.showMessageDialog(null, "El dato no existe");
          }
          break;
        case 9:
          System.out.println(p.Altura(p.getRaiz().getLigaIzq().getLigaIzq()));
          break;
        case 10:

          break;
        case 11:
          p.MostrarArbol(p.getRaiz(), 2, 5);
          a = JOptionPane.showInputDialog("Ingrese el dato, para buscar el primo hermano").charAt(0);
          if (p.BuscarDato(p.getRaiz(), a) == true) {
            q = p.Buscar(p.getRaiz(), a);
            if (q != null) {
              JOptionPane.showMessageDialog(null, "Los primos hermanos de " + a + " son " + p.MostrarPrimosH(q));
            } else {
              JOptionPane.showMessageDialog(null, a + " no tiene primos hermanos");
            }
          }else{
            JOptionPane.showMessageDialog(null, "El dato no existe");
          }
          break;
        case 0:
        JOptionPane.showMessageDialog(null, "Adios!!");
          break;

        default:
          JOptionPane.showMessageDialog(null, "Ingrese una opcion valida.");
          break;
      }

    } while (op != 0);

  }

  public static void recorridos(ArbolBinario p) {
    int op = 0;
    do {

      op = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Preorden\n"
          + "2.Inorder\n"
          + "3.Posorden\n"));
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

        default:
          JOptionPane.showMessageDialog(null, "Ingrese una opcion valida.");
          break;
      }

    } while (op != 0);
  }
}
