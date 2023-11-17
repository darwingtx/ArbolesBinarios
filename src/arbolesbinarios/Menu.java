package arbolesbinarios;

import javax.swing.JOptionPane;

public class Menu {
    

    public Menu() {
        int op = 0;
        String x = JOptionPane.showInputDialog("Ingrese la cadena");
        char vc[] = x.toCharArray();
        ArbolBinario p = new ArbolBinario(vc);
        Nodo q = null;
        char a = ' ';
        boolean ba = false;
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
              +"12.AVL\n"
              + "0.Salir\n"));
          switch (op) {
            case 1:
              JOptionPane.showMessageDialog(null,p.MostrarArbol(p.getRaiz(), 5, 10));
              break;
            case 2:
              recorridos(p);
              break;
            case 3:
              ba = true;
              do {
                String input = JOptionPane.showInputDialog("Ingrese un caracter");
                if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                  a = input.charAt(0);
                  ba = false;
                } else {
                  JOptionPane.showMessageDialog(null, "Por favor, ingrese solo una letra");
                }
              } while (ba);
              p.InsertarDato(a);
              break;
            case 4:       
              ba = true;
              do {
                String input = JOptionPane.showInputDialog("Ingrese el caracter a eliminar");
                if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                  a = input.charAt(0);
                  ba = false;
                } else {
                  JOptionPane.showMessageDialog(null, "Por favor, ingrese solo una letra");
                }
              } while (ba);
              if (p.BuscarDato(p.getRaiz(), a) == true) {
                q = p.Buscar(p.getRaiz(), a);
                  p.Eliminar(q);
              }else{
                JOptionPane.showMessageDialog(null, "El dato no existe");
              }
              break;
    
            case 5:
              JOptionPane.showMessageDialog(null, "Hay " + p.Contarhojas(p.getRaiz()) + " hojas en el arbol");
              break;
            case 6:
              JOptionPane.showMessageDialog(null, "Hay " + p.Contarpadres(p.getRaiz()) + " padres en el arbol");
    
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
              JOptionPane.showMessageDialog(null,p.MostrarArbol(p.getRaiz(), 5, 10));
              ba = true;
              do {
                String input = JOptionPane.showInputDialog("Ingrese el caracter para el nivel");
                if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                  a = input.charAt(0);
                  ba = false;
                } else {
                  JOptionPane.showMessageDialog(null, "Por favor, ingrese solo una letra");
                }
              } while (ba);
              if (p.BuscarDato(p.getRaiz(), a) == true) {
                q = p.Buscar(p.getRaiz(), a);
                  JOptionPane.showMessageDialog(null, "El nivel de "+a+ " es "+ p.Nivel(q));
              }else{
                JOptionPane.showMessageDialog(null, "El dato no existe");
              }
              
              break;
            case 9:
              JOptionPane.showMessageDialog(null,p.MostrarArbol(p.getRaiz(), 5, 10));
              ba = true;
              do {
                String input = JOptionPane.showInputDialog("Ingrese el caracter para la altura");
                if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                  a = input.charAt(0);
                  ba = false;
                } else {
                  JOptionPane.showMessageDialog(null, "Por favor, ingrese solo una letra");
                }
              } while (ba);
              if (p.BuscarDato(p.getRaiz(), a) == true) {
                q = p.Buscar(p.getRaiz(), a);
                  JOptionPane.showMessageDialog(null, "La altura de "+a+ " es "+ (p.Altura(q)-1));
              }else{
                JOptionPane.showMessageDialog(null, "El dato no existe");
              }
              break;
            case 10:
              p.MostrarArbol(p.getRaiz(), 2, 5);
              a = JOptionPane.showInputDialog("Ingrese el dato, para buscar los ancestros").charAt(0);
              if (p.BuscarDato(p.getRaiz(), a) == true) {
                q = p.Buscar(p.getRaiz(), a);
                if (q != null) {
                  JOptionPane.showMessageDialog(null, "Los ancestros de " + a + " son " + p.MostrarAncestros(q));
                } else {
                  JOptionPane.showMessageDialog(null, a + " no tiene ancestros");
                }
              }else{
                JOptionPane.showMessageDialog(null, "El dato no existe");
              }
              break;
            case 11:
              p.MostrarArbol(p.getRaiz(), 2, 5);
              a = JOptionPane.showInputDialog("Ingrese el dato, para buscar el primo hermano").charAt(0);
              if (p.BuscarDato(p.getRaiz(), a) == true) {
                q = p.Buscar(p.getRaiz(), a);
                if (q != null) {
                  JOptionPane.showMessageDialog(null, p.MostrarPrimosH(q));
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

            case 12:
              p.FactorB(p.getRaiz());
              JOptionPane.showMessageDialog(null,p.MostrarArbol(p.getRaiz(), 5, 10));
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
              + "3.Posorden\n"
              + "0.Salir\n"));
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
