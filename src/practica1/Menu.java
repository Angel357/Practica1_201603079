
package practica1;
import java.util.Scanner;
public class Menu {
    
    Scanner scanSt=new Scanner(System.in);
    Scanner scanInt=new Scanner(System.in);
    int opcionMenu;
    String pasarInicio;
    public Menu(){
        menu();
    }
    
    public void menu(){
        System.out.println("                        Luis Angel Castellanos Fajardo");
        System.out.println("                                   20603079");
        System.out.println("                             IPC1 'A' Practica 1");
        System.out.println("\n                               BUSCAMINAS");
        pasarInicio=scanSt.nextLine();
        Opciones();
    }
    public void Opciones(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                \n\n\n\nBUSCAMINAS!!!\n\n");
        System.out.println("                                1. Principiante");
        System.out.println("                                2. Normal");
        System.out.println("                                3. Profesional"); 
        System.out.println("                                4. Salir"); 
        opcionMenu=scanInt.nextInt();
        Matriz m=new Matriz();
        m.Dificultad(opcionMenu);
    }    
}
