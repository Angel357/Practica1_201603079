
package practica1;
import java.util.Random;
public class Matriz {
    // objetos y variables globales
    Random ram=new Random();
    Random ram2=new Random();
    int opcionMenu, fil,col, numBomba, filAL,colAL;
    int interna[][]; 
    //hh
    public void Dificultad(int opcionMenu){
        this.opcionMenu=opcionMenu;
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
               System.out.println("");          
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
               System.out.print("[  "+interna[x][y]+"  ]");
           }//for de columnas
       }//for de filas 
    }// metodo de llenado
}//clase matriz
