
package practica1;
import java.util.Random;
import java.util.Scanner;
public class Matriz {
    // objetos y variables globales
    Random ram=new Random();
    Random ram2=new Random();
    Scanner scan=new Scanner(System.in);
    int opcionMenu, fil,col, numBomba, filAL,colAL,opJuego,selFil,selCol,contV,j;
    int interna[][]; 
    String Externa[][];
    //hh
    public void Dificultad(int opcionMenu){
        try{
        this.opcionMenu=opcionMenu;
        }catch(Exception sel){
            
        }
        switch(opcionMenu){
            case 1:
                fil=4;
                col=4;
                llenadoMatriz();
                break;
            case 2:
                fil=6;
                col=6;
                llenadoMatriz();
                break;
            case 3:
                fil=8;
                col=8;
                llenadoMatriz();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                
                break;   
        } // switch
    }// metodo dificultad
    public void llenadoMatriz(){
       interna=new int[fil][col];
       //con el siguiente switch se determina el numero de bombas dependiendo el nivel de dificultad
       switch(opcionMenu){
           case 1:
               numBomba=4;
               break;
           case 2:
               numBomba=8;
               break;
           case 3:
                numBomba=12;
               break;
       }
        //Aca se agregan de forma aleatoria la minas en la matriz
       for(int m=0;m<numBomba;m++){
           filAL=0+ram.nextInt(fil-1);
           colAL=0+ram.nextInt(col-1);
           if(interna[filAL][colAL]==-1){
               m--;
           }else{
           interna[filAL][colAL]=-1;}       
       }// for de minas 
       //Esta parte es para el llenado de toda la matriz en donde no hayan minas 
       for(int x=0;x<fil;x++){      
           for(int y=0;y<col;y++){
               if(interna[x][y]!=-1){
                   int contMina=0;
                   for(int r=0;r<8;r++){
                       try{
                       switch(r){
                           case 0:
                               if(interna[x-1][y-1]==-1){
                                   contMina++;
                               }
                               break;
                           case 1:
                               if(interna[x-1][y]==-1){
                                   contMina++;
                               }
                               break;
                           case 2:
                               if(interna[x-1][y+1]==-1){
                                   contMina++;
                               }
                               break;
                           case 3:
                               if(interna[x][y-1]==-1){
                                   contMina++;
                               }
                               break;
                           case 4:
                               if(interna[x][y+1]==-1){
                                   contMina++;
                               }
                               break;
                           case 5:
                               if(interna[x+1][y-1]==-1){
                                   contMina++;
                               }
                               break;
                           case 6:
                               if(interna[x+1][y]==-1){
                                   contMina++;
                               }
                               break;
                           case 7:
                               if(interna[x+1][y+1]==-1){
                                   contMina++;
                               }
                               break;    
                       }//switch
                   }catch(Exception e){}//try
                   }//for
               interna[x][y]=contMina;
               }
           }//for de columnas
       }//for de filas
       Externa=new String[fil][col];
       for(int i=0;i<fil;i++){
           for(int j=0;j<col;j++){
                Externa[i][j]="*";
           }
       }
       Juego();
    }// metodo de llenado
    public void Juego(){
       System.out.println("\n\n\n");
       System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
       System.out.println("\n\n                               BUSCAMINAS");
       System.out.println("                            Elija una opcion\n");
       for(int i=0;i<fil;i++){
           
           System.out.print("                          ");
           for(j=0;j<col;j++){
                System.out.print("["+Externa[i][j]+"]");
                if(j==(col-1)){
           System.out.println("");    
           }
           }//for col
       }//for fil
       
               for(int c=0;c<fil;c++){
                for(int d=0;d<col;d++){
                    if(Externa[c][d].equals("*")){
                        contV++;
                    }
                }//contador de columnas para victorias
               }//contador de filas para victoria
               switch(opcionMenu){
                   case 1:
                       if(contV==4){
                           System.out.println("\n\n\n\n\n               Has ganado el juego por descubrir todas las casillas sin bomba.\n\n\n\n");
                           llenadoMatriz();
                       }
                       break;
                   case 2:
                       if(contV==8){
                           System.out.println("\n\n\n\n\n               Has ganado el juego por descubrir todas las casillas sin bomba.\n\n\n\n");
                           llenadoMatriz();
                       }
                       break;
                   case 3:
                       if(contV==12){
                           System.out.println("\n\n\n\n\n               Has ganado el juego por descubrir todas las casillas sin bomba.\n\n\n\n");
                           llenadoMatriz();
                       }
                       break;
               }
               contV=0;
       System.out.println("\n\n");
       System.out.println("                             1. Descubrir Casilla");
       System.out.println("                             2. Reinciar");
       System.out.println("                             3. Salir");
       opJuego=scan.nextInt();
       switch(opJuego){
           case 1:
               System.out.println("                              Ingrese el numero de fila entre 1 y "+fil);
               selFil=scan.nextInt();
               selFil--;
               System.out.println("                              Ingrese el numero de columna entre 1 y "+col);
               selCol=scan.nextInt();
               selCol--;
               if(interna[selFil][selCol]==-1){
                   System.out.println("\n\n\n\n");
                   Externa[selFil][selCol]="X";
                   for(int e=0;e<fil;e++){
                       System.out.println("");
                       for(int f=0;f<col;f++){
                           System.out.print("["+Externa[e][f]+"]");
                       }
                   }
                   
                   System.out.println("\n\n\n         Has perdido el juego por seleccionar una mina, vuelve a intentarlo.");
                   llenadoMatriz();
               }else{
                   Externa[selFil][selCol]=Integer.toString(interna[selFil][selCol]);
                   for(int v=0;v<4;v++){
                       try{
                       switch(v){
                           case 0:
                               if(interna[selFil-1][selCol]!=-1){
                                   Externa[selFil-1][selCol]=Integer.toString(interna[selFil-1][selCol]);
                               }
                               break;
                           case 1:
                               if(interna[selFil][selCol+1]!=-1){
                                   Externa[selFil][selCol+1]=Integer.toString(interna[selFil][selCol+1]);
                               }
                               break;
                           case 2:
                               if(interna[selFil+1][selCol]!=-1){
                                   Externa[selFil+1][selCol]=Integer.toString(interna[selFil+1][selCol]);
                               }
                               break;
                           case 3:
                               if(interna[selFil][selCol-1]!=-1){
                                   Externa[selFil][selCol-1]=Integer.toString(interna[selFil][selCol-1]);
                               }
                               break;
                       }//switch
                       }catch(Exception a){}//try
                   }//for
                   Juego();
               }
               break;
           case 2:
               System.out.println("\n\n\n\n\n\n\n");
               Menu m=new Menu();
               m.menu();
               break;
           case 3:
               System.exit(0);
               break;
           case 100:
               System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
               System.out.println("                  Solucionario!!!\n");
               for(int a=0;a<fil;a++){
                   System.out.println("");
                 for(int b=0;b<col;b++){
                   System.out.print("[ "+interna[a][b]+" ]");
               } }
               Juego();
               break;
           default:
               System.out.println("\n\n                    Has seleccionado una opcion que no esta dentro del menu, vuelve a seleccionar de 1 a 3 por favor. ");
               Juego();
               break;
       }
       System.out.println("\n\n");
    }// metodo juego
}//clase matriz
