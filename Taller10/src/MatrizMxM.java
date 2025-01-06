
/**
 * Dada una matriz cuadrada (m X m) de valores enteros aleatorios, desarrollar su procesamiento para presentar los elementos:
 * De la diagonal principal.
 * De la diagonal segundaria.
 * Ubicados bajo la diagonal principal.
 * Ubicados sobre la diagonal principal.
 * Ubicados bajo la diagonal secundaria.
 * Ubicados sobre la diagonal secundaria.
 *
 * @author Daniela Briceño
 */
import java.util.Scanner;

public class MatrizMxM {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        int lim = 0;
        System.out.print("Ingrese el limite de la matriz: ");
        lim = tcl.nextInt();
        int[][] matriz = new int[lim][lim];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
                System.out.print("[ " + matriz[i][j] + " ]");
            }
            System.out.println(" ");
        }       
        System.out.println("\nDiagonal principal ");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + "\t");
        }
        
        System.out.println("\nDebajo de la diagonal principal");
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < i; j++) {
            System.out.print(matriz[i][j] + "\t");
            }
        }
        System.out.println("\nSobre la diagonal principal ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = i + 1; j < matriz.length ; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
        }
        System.out.println("\nDiagonal secundaria");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][matriz.length - i -1] + "\t");
        }
        System.out.println("\nDebajo la diagonal secundaria");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length ; j++) {
                if (i+j >matriz.length-1) {
                    System.out.print(matriz[i][j]+"\t");
                }
            }
        }
        System.out.println("\nSobre la diagonal secundaria");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j+i < (matriz.length - 1); j++) {
                System.out.print(matriz[i][j]+ "\t");
            }
        }
        System.out.println();
    }
}
/*
 * run:
 * Ingrese el limite de la matriz: 3
 * [ 9 ][ 9 ][ 8 ] 
 * [ 7 ][ 9 ][ 2 ] 
 * [ 1 ][ 1 ][ 9 ] 

 * Diagonal principal 
 * 9	9	9	
 * Debajo de la diagonal principal
 * 7	1	1	
 * Sobre la diagonal principal 
 * 9	8	2	
 * Diagonal secundaria
 * 8	9	1	
 * Debajo la diagonal secundaria
 * 2	1	9	
 * Sobre la diagonal secundaria
 * 9	9	7	
 * BUILD SUCCESSFUL (total time: 1 second)
*/